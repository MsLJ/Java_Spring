package com.ms.web2.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.ms.db.manager.msDBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {
	private static final MemberDAO MDAO = new MemberDAO();

	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}

	public static MemberDAO getMdao() {
		return MDAO;
	}

	public void login(HttpServletRequest request) {
		SqlSession ss = null;
		try {
			ss = msDBManager.getMsdb().connect();
			request.setCharacterEncoding("utf-8");

			String webm_id = request.getParameter("id");
			String webm_pw = request.getParameter("pw");
			Member inputMember = new Member(webm_id, webm_pw, null, null, null, null, null);

			Member dbMember = ss.selectOne("memberMapper.loginMember", inputMember);

			if (dbMember != null) {
				if (inputMember.getWebm_pw().equals(dbMember.getWebm_pw())) {
					request.setAttribute("result", "로그인성공");
					request.getSession().setAttribute("loginMember", dbMember);
					request.getSession().setMaxInactiveInterval(10 * 6 * 30);

				} else {
					request.setAttribute("result", "pw불일치");
				}

			} else {
				request.setAttribute("result", "로그인 실패(미가입 아이디)");

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "로그인실패(DB)");

		}
		ss.close();

	}

	public void updateMemberInfo(HttpServletRequest request) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("joindata");
		System.out.println(path);
		SqlSession ss = null;
		try {
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy()

			);

		} catch (Exception e) {
			request.setAttribute("result", "파일 업로드 실패(갱신)");
			e.printStackTrace();
			return;
		}
		String oldImg = null;
		String newImg = null;
		ss = msDBManager.getMsdb().connect();
		try {
			Member m = (Member) request.getSession().getAttribute("loginMember");
			oldImg = m.getWebm_photo();
			newImg = mr.getFilesystemName("img");
			if (newImg == null) {
				newImg = oldImg;

			} else {
				newImg = URLEncoder.encode(newImg, "utf-8");
				newImg = newImg.replace("+", " ");
			}
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String addr123 = addr1 + "#" + addr2 + "#" + addr3;
			Member forUpdate = new Member(m.getWebm_id(), pw, name, null, addr123, null, newImg);

			if (ss.update("memberMapper.update", forUpdate) == 1) {
				request.setAttribute("result", "수정 성공");
				ss.commit();
				if (!oldImg.equals(newImg)) {
					oldImg = URLDecoder.decode(oldImg, "utf-8");
					new File(path + "/" + oldImg).delete();

				}
				m.setWebm_pw(pw);
				m.setWebm_name(name);
				m.setWebm_adr(addr123);
				m.setWebm_photo(newImg);
				// 수정된 내용들을 세션을 불러와서 수정된 값들을 새로set해주고
				// 다시 session을 불러 값들을 set해준다

				request.getSession().setAttribute("loginMember", m);

			} else {
				request.setAttribute("result", "수정실패");
				if (!oldImg.equals(newImg)) {
					newImg = URLDecoder.decode(newImg, "utf-8");
					new File(path + "/" + newImg).delete();

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정 실패");
			if (!oldImg.equals(newImg)) {
				try {
					newImg = URLDecoder.decode(newImg, "utf-8");
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new File(path + "/" + newImg).delete();

			}
			ss.close();
		}

	}

	public void deleteMember(HttpServletRequest request) {
		SqlSession ss = null;

		try {
			ss = msDBManager.getMsdb().connect();
			Member m = (Member) request.getSession().getAttribute("loginMember");

			if (ss.delete("memberMapper.deleteMember") == 1) {
				request.setAttribute("result", "삭제 성공");
				ss.commit();
				String path = request.getSession().getServletContext().getRealPath("joindata");
				String photo = URLDecoder.decode(m.getWebm_photo(), "utf-8");
				new File(path + "/" + photo).delete();
				System.out.println(path);

			} else {

				request.setAttribute("result", "삭제 실패(DB)");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "삭제 실패(DB)");

		}
		ss.close();

	}

	public void logout(HttpServletRequest request) {
		// 세션 끊기
		// 로그인 정보말고 세션에 넣어놓은 다른것들도 다 날아갈테니
		request.getSession().setAttribute("loginMember", null);
//		request.getSession().setMaxInactiveInterval(-1);

	}

	public boolean isLogined(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		if (m != null) {
			request.setAttribute("loginpage", "member/logined.jsp");
			return true;
			// 로그인 됐

		} else {
			request.setAttribute("loginpage", "member/login.jsp");
			return false;
		}
	}

	public void joinmember(HttpServletRequest request) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("joindata");

		try {
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy()

			);

		} catch (Exception e) {

			request.setAttribute("result", "파일업로드실패");
			return;
		}
		SqlSession ss = null;
		try {

			ss = msDBManager.getMsdb().connect();
			String webm_id = mr.getParameter("id");
			String webm_pw = mr.getParameter("pw");
			String webm_name = mr.getParameter("name");
			int webm_ag = Integer.parseInt(mr.getParameter("age"));
			BigDecimal webm_age = new BigDecimal(webm_ag);
			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String webm_adr = addr1 + "#" + addr2 + "#" + addr3;
			String y = mr.getParameter("y");
			String m = mr.getParameter("m");
			String d = mr.getParameter("d");
			int yy = Integer.parseInt(y);
			int mm = Integer.parseInt(m);
			int dd = Integer.parseInt(d);
			String ymd = String.format("%04d%02d%02d", yy, mm, dd);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

			Date webm_birthday = sdf.parse(ymd);

			String webm_photo = mr.getFilesystemName("img");
			webm_photo = URLEncoder.encode(webm_photo, "utf-8");
			webm_photo = webm_photo.replace("+", " ");
			Member mem = new Member(webm_id, webm_pw, webm_name, webm_age, webm_adr, webm_birthday, webm_photo);

			if (ss.insert("memberMapper.regMember", mem) == 1) {
				request.setAttribute("result", "회원가입 성공");
				ss.commit();

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "회원가입실패");
		}
		ss.close();
	}

	public void splitAddr(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String addr = m.getWebm_adr();
		String[] addrr = addr.split("#");
		request.setAttribute("addr1", addrr[0]);
		request.setAttribute("addr2", addrr[1]);
		request.setAttribute("addr3", addrr[2]);

	}

}
