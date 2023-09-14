package com.ms.web2.sns;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import com.ms.db.manager.msDBManager;
import com.ms.web2.member.Member;

import oracle.jdbc.driver.DBConversion;

public class SnsDAO {
	private int allsnsCount;
	private int snsperPage;

	public int getAllsnsCount() {
		return allsnsCount;
	}

	public void setAllsnsCount(int msgCount) {
		System.out.println(allsnsCount);
		allsnsCount -= msgCount;
		System.out.println(allsnsCount);
	}

	public void setAllSNSCount() {

		SqlSession ss = null;
		try {
			ss = msDBManager.getMsdb().connect();
			// 앞에 테이블을 만들때 아이디가 없으면 글이 삭제돼니
			// 갯수를 샐때는 join을 할필요가 없을것
			SNSPage spp = new SNSPage("", null, null);
			allsnsCount = ss.selectOne("snsMapper.getAllMsgCount", spp);
			System.out.println(allsnsCount);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		ss.close();
	}

	public SnsDAO() {
		snsperPage = 10;
	}

	public void search(HttpServletRequest request) {
		String search = request.getParameter("search");
		request.getSession().setAttribute("search", search);
	}

	public void clearSearch(HttpServletRequest request) {
		request.getSession().setAttribute("search", null);
	}

	public final static SnsDAO SDAO = new SnsDAO();

	public static SnsDAO getSdao() {
		return SDAO;
	}

	public void snsReply(HttpServletRequest request) {
		SqlSession ss = null;

		try {
			String token = request.getParameter("token");
			String lastToken = (String) request.getSession().getAttribute("lastToken");
			// 세션으로 갖고올때 앞에 (String)형 변환이유는 Object로 들어오기에 형변환을 꼭 해줘야한다.
			if (lastToken != null && token.equals(lastToken)) {
				request.setAttribute("result", "댓글쓰기 실패");
				return;

			}

			ss = msDBManager.getMsdb().connect();
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String id = m.getWebm_id();
			String txt = request.getParameter("txt");
			int noo = Integer.parseInt(request.getParameter("re_no"));
			BigDecimal no = new BigDecimal(noo);
			SNSReply sr = new SNSReply(null, no, id, txt, null);

			if (ss.insert("snsMapper.insertsnsReply", sr) == 1) {
				request.setAttribute("result", "댓글성공");
				request.getSession().setAttribute("lastToken", token);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			request.setAttribute("result", "댓글실패");
		}
		ss.close();

	}

	public int getSearchSnsCount(String search) {
		SqlSession ss = null;
		try {
			ss = msDBManager.getMsdb().connect();
			SNSMsg smg = new SNSMsg(null, null, search, null, null);
			return ss.selectOne("snsMapper.getAllMsgCount", smg);

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			ss.close();
		}

	}

	// Connection 연결
	// PreparedStatement:DB작업 총괄매니저(1회용) 또 사용하고싶으면 close하고 다시
	public void getSns(int page, HttpServletRequest request) {
		SqlSession ss = null;

		try {
			ss = msDBManager.getMsdb().connect();
			String search = (String) request.getSession().getAttribute("search");
			int snsCount = allsnsCount;
			if (search == null) {
				search = "";
			} else {
				SNSPage sp2 = new SNSPage(search, null, null);
				snsCount = ss.selectOne("snsMapper.getAllMsgCount", sp2);
			}
			System.out.println(snsCount);

			int pageCount = (int) Math.ceil(snsCount / (double) snsperPage);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("page", page);
			int startt = (page - 1) * snsperPage + 1;
			BigDecimal start = new BigDecimal(startt);
			int endd = snsperPage * page;
			BigDecimal end = new BigDecimal(endd);
//			System.out.println(end);
			SNSPage sp = new SNSPage(search, start, end);
			List<SNSMsg> smg = ss.selectList("snsMapper.getSNS", sp);

			request.setAttribute("smg", smg);

		} catch (Exception e) {
			e.printStackTrace();

		}

		ss.close();
	}

	public void write(HttpServletRequest request) {
		SqlSession ss = null;

		try {
			String token = request.getParameter("token");
			String lastToken = (String) request.getSession().getAttribute("lastToken");
			// lastToken값이 없으면 일단 아래로 진행 &&이기에 뒤에 조건식은 보지않음
			// 그 후에 lastToken값이 생기면 뒤의 조건식 검사 return; 시키면 될것
			if (lastToken != null && token.equals(lastToken)) {
				request.setAttribute("result", "글 쓰기 실패(새로고침)");
				return;
			}

			ss = msDBManager.getMsdb().connect();
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String txt = request.getParameter("txt");
			txt.replace(" n", "<br>");

			SNSMsg sm = new SNSMsg(null, m.getWebm_id(), txt, null, null);
			if (ss.insert("snsMapper.writeSNS", sm) == 1) {
				request.setAttribute("result", "write성공");
				ss.commit();
				allsnsCount++;
				request.getSession().setAttribute("lastToken", token);

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		ss.close();
	}

}
