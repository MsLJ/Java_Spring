package com.ms.zoo.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.zoo.sns.SNSDAO;
import com.ms.zoo.sns.SNSMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {
	@Autowired
	private SqlSession ss;
	// 이미 등록해놓은 sqlSession 사용해서 DB연결
	@Autowired
	private SNSDAO sDAO;

	private SimpleDateFormat sdf;

	public MemberDAO() {
		sdf = new SimpleDateFormat("yyyyMMdd");
	}

	// SpringMvC자동으로 해주는데
	// 파일 업로드는 mr.을 쓰기에 다 수동으로 해줘야함
	// (수동작업)
	// 날짜
	// input여러개 합치기
	// 파일업로드
	
	public zooMembers get2(ZooMember m) {
		List<ZooMember>member=ss.getMapper(MemberMapper.class).get2(m);
		zooMembers members=new zooMembers(member);
		return members;
	}

	public void deleteMem(HttpServletRequest request) {
		try {
			// 삭제할때 주의할점
			// 1.삭제하고나서 사용자의 올린 파일들은 삭제되지않는다
			// 그렇기에 따로 경로를 찾아서 삭제해줘야한다.
			// 2.만약 게시물이 있다면 아이디가 삭제후게시물 숫자도 다시세줘야할것이다
			// 3.delete하고난후 logout과 login을 안하면 session에 남아있기에
			// Controller나 객체에 넣어줘야한다.

			ZooMember m = (ZooMember) request.getSession().getAttribute("loginMember");
			System.out.println(m.getZm_id());
			int msgCount = ss.getMapper(SNSMapper.class).getwriterPage(m);
			System.out.println(msgCount);

			if (ss.getMapper(MemberMapper.class).deleteMember(m) == 1) {
				request.setAttribute("result", "삭제성공");
				sDAO.setAllMsgCount(msgCount);
				String path = request.getSession().getServletContext().getRealPath("resources/photo");
				String file = URLDecoder.decode(m.getZm_photo(), "utf-8");
				new File(path + "/" + file).delete();
				logout(request);
				islogined(request);

				// 어떻게 날리는거지 세션을?
				// 이미 삭제하고 난 다음 null을 다시 set해서?
				// ->기존에 해왔던방식은 컨트롤러에서 따로 로그아웃해주고
				// 다시 로그인하는걸로 세션을 초기화했는데
				// 이번에는 그냥 이 객체안에 로그아웃이랑 로그인 기능까지 넣어서
				// delete하면 바로 로그아웃하면서 로그인하면서 세션 날라감

			} else {
				request.setAttribute("result", "삭제실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "삭제실패");
		}

	}

	public void splitAddr(HttpServletRequest request) {
		ZooMember m = (ZooMember) request.getSession().getAttribute("loginMember");
		String addr = m.getZm_addr();
		String[] addr2 = addr.split("!");
		request.setAttribute("addr1", addr2[0]);
		request.setAttribute("addr2", addr2[1]);
		request.setAttribute("addr3", addr2[2]);
	}

	public void logout(HttpServletRequest request) {
		if (request.getSession().getAttribute("loginMember") != null) {
			request.getSession().setAttribute("loginMember", null);

		}
	}

	public void join(HttpServletRequest request, ZooMember m) {

		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("resources/photo");
		System.out.println(path);
		try {
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			request.setAttribute("result", "파일업로드 실패");
			return;
		}
		try {
			m.setZm_id(mr.getParameter("zm_id"));
			m.setZm_pw(mr.getParameter("zm_pw"));
			m.setZm_name(mr.getParameter("zm_name"));
			String birth = mr.getParameter("birthday");
			int birth2 = Integer.parseInt(mr.getParameter("birthday2"));
			if (birth2 < 3) {
				birth = "19" + birth;

			} else {
				birth = "20" + birth;
			}

			Date birthday = sdf.parse(birth);
			m.setZm_birthday(birthday);
			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String addr = addr1 + "!" + addr2 + "!" + addr3;
			m.setZm_addr(addr);
			String photo = mr.getFilesystemName("zm_photo");
			photo = URLEncoder.encode(photo, "utf-8");
			photo = photo.replace("+", " ");
			m.setZm_photo(photo);
			System.out.println(m.getZm_id());
			System.out.println(m.getZm_pw());
			System.out.println(m.getZm_name());
			System.out.println(m.getZm_birthday());
			System.out.println(m.getZm_addr());
			System.out.println(m.getZm_photo());
			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				request.setAttribute("result", "가입성공");

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "가입실패");
			new File(path + "/" + mr.getFilesystemName("zm_photo")).delete();

		}

	}

	public void update(HttpServletRequest request, ZooMember m) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("resources/photo");
		System.out.println(path);
		try {
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("reuslt", "파일업로드 실패(용량)");
			return;
		}
		String newphoto = null;
		String oldphoto = null;

		try {
			ZooMember dbM = (ZooMember) request.getSession().getAttribute("loginMember");
			newphoto = mr.getFilesystemName("zm_photo");
			oldphoto = dbM.getZm_photo();
			if (newphoto == oldphoto) {
				newphoto = oldphoto;

			} else {
				newphoto = URLEncoder.encode(newphoto, "utf-8");
				newphoto.replace("+", " ");

			}
			m.setZm_id(dbM.getZm_id());
			m.setZm_pw(mr.getParameter("zm_pw"));
			m.setZm_name(mr.getParameter("zm_name"));
			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String addr = addr1 + "!" + addr2 + "!" + addr3;
			m.setZm_addr(addr);
			m.setZm_photo(newphoto);
			if (ss.getMapper(MemberMapper.class).updateMember(m) == 1) {

				request.setAttribute("result", "수정성공");
				if (!oldphoto.equals(newphoto)) {
					oldphoto = URLDecoder.decode(oldphoto, "utf-8");
					new File(path + "/" + oldphoto).delete();

				}
				m.setZm_birthday(dbM.getZm_birthday());
				request.getSession().setAttribute("loginMember", m);
			} else {
				request.setAttribute("result", "수정실패");
				if (!oldphoto.equals(newphoto)) {
					newphoto = URLDecoder.decode(newphoto, "utf-8");
					new File(path + "/" + newphoto).delete();

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정 실패");
			if (!oldphoto.equals(newphoto)) {
				try {
					newphoto = URLDecoder.decode(newphoto, "utf-8");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				new File(path + "/" + newphoto).delete();

			}
		}

	}

	public boolean islogined(HttpServletRequest request) {
		ZooMember m = (ZooMember) request.getSession().getAttribute("loginMember");
		if (m != null) {
			request.setAttribute("loginPage", "member/logined.jsp");
			return true;

		} else {
			request.setAttribute("loginPage", "member/login.jsp");
			return false;
		}

	}

	public void login(ZooMember inputMember, HttpServletRequest request) {
		try {
			ZooMember dbMember = ss.getMapper(MemberMapper.class).getMemberByID(inputMember);
			if (dbMember != null) {
				if (dbMember.getZm_pw().equals(inputMember.getZm_pw())) {
					request.getSession().setAttribute("loginMember", dbMember);
					request.getSession().setMaxInactiveInterval(10 * 6 * 30);
					request.setAttribute("result", "로그인성공");

				} else {
					request.setAttribute("result", "로그인실패(pw)");
				}

			} else {
				request.setAttribute("result", "로그인실패(id도 없음)");
			}

		} catch (Exception e) {
			request.setAttribute("result", "로그인실패(DB)");
			e.printStackTrace();
		}

	}

}
