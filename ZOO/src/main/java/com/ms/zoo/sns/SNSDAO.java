package com.ms.zoo.sns;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.zoo.ZOOAttribute;
import com.ms.zoo.member.ZooMember;
import com.ms.zoo.weather.WeatherColorDAO;

@Service
public class SNSDAO {
	@Autowired
	private SqlSession ss;
	@Autowired
	private WeatherColorDAO wCDAO;
	@Autowired
	private ZOOAttribute za;
//기존에 했던 페이지 나누기 방식은 유지보수하는데 있어서 어려울것
	// 그렇기에 Spring 의 장점 servlet-context.xml에 따로 등록해주고 가져다 쓰기
	private int allMsgCount;

	public void search(HttpServletRequest request) {
		request.getSession().setAttribute("search", request.getParameter("search"));
	}

	public SNSDAO() {
	}

	public void clearsearch(HttpServletRequest request) {
		request.getSession().setAttribute("search", null);
	}

	public void setAllmsgCount() {
		SNSPage sp = new SNSPage(null, null, "");
		allMsgCount = ss.getMapper(SNSMapper.class).getPage(sp);
		System.out.println(allMsgCount);
	}

	public int getAllMsgCount() {
		return allMsgCount;
	}

	public void setAllMsgCount(int msgCount) {
		allMsgCount = allMsgCount - msgCount;

	}

	public void writeSNSReply(HttpServletRequest request, SNSReply sr) {

		try {
			String token = request.getParameter("token");
			String lastToken = (String) request.getSession().getAttribute("lasttoken");

			if (lastToken != null && token.equals(lastToken)) {
				request.setAttribute("result", "새로고침 실패");
				return;
			}

			ZooMember m = (ZooMember) request.getSession().getAttribute("loginMember");
			sr.setZsr_writer(m.getZm_id());
			if (ss.getMapper(SNSReplyMapper.class).writere(sr) == 1) {
				request.getSession().setAttribute("lasttoken", token);
				request.setAttribute("result", "댓글작성성공");

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "댓글작성실패");

		}

	}

	public void updateSNS(HttpServletRequest request, SNSMsg sm) {

		try {
			String zs_txt = sm.getZs_txt();
			zs_txt = zs_txt.replace("\r\n", "<br>");
			sm.setZs_txt(zs_txt);
			if (ss.getMapper(SNSMapper.class).update(sm) == 1) {
				request.setAttribute("result", "수정성공");

			}

		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("result", "수정실패");
		}
	}

	public void deleteSNSRe(HttpServletRequest request, SNSReply sr) {

		try {
			if (ss.getMapper(SNSReplyMapper.class).deletere(sr) == 1) {
				request.setAttribute("result", "댓글삭제성공");

			}

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("result", "댓글삭제성공");
		}

	}

	public void deleteSNS(HttpServletRequest request, SNSMsg sm) {

		try {

			if (ss.getMapper(SNSMapper.class).delete(sm) == 1) {
				request.setAttribute("result", "삭제성공");
				allMsgCount--;

			} else {

				request.setAttribute("result", "삭제실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "삭제실패");

			// TODO: handle exception
		}

	}

	public void snsGet(HttpServletRequest request, int page) {
		try {
			int msgCount = allMsgCount;
			String search = (String) request.getSession().getAttribute("search");
			SNSPage sp = new SNSPage(null, null, search);
			if (search == null) {
				sp.setSearch("");

			} else {
				msgCount = ss.getMapper(SNSMapper.class).getPage(sp);
			}

			int pageCount = (int) Math.ceil(msgCount / (double) za.getSnsMsgPerPage());
			int start = (page - 1) * za.getSnsMsgPerPage() + 1;
			int end = page * za.getSnsMsgPerPage();
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("page", page);
			sp.setStart(new BigDecimal(start));
			sp.setEnd(new BigDecimal(end));
			List<SNSMsg> smg = ss.getMapper(SNSMapper.class).getSNS(sp);

			for (SNSMsg snsMsg : smg) {
				snsMsg.setZs_re(ss.getMapper(SNSReplyMapper.class).getre(snsMsg));

			}
			request.setAttribute("smg", smg);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void snsWrite(HttpServletRequest request, SNSMsg sm) {

		try {
			String token = request.getParameter("token");
			System.out.println(token);
			String lastToken = (String) request.getSession().getAttribute("lastToken");
			if (lastToken != null && token.equals(lastToken)) {
				request.setAttribute("result", "새로고침으로 실패");
				return;

			}
			ZooMember m = (ZooMember) request.getSession().getAttribute("loginMember");

			sm.setZs_writer(m.getZm_id());
			sm.setZs_txt(sm.getZs_txt().replace("\r\n", "<br>"));

			if (ss.getMapper(SNSMapper.class).write(sm) == 1) {
				request.setAttribute("result", "글쓰기 성공");

				// 객체 단위로 놀기에 따로 컨트롤러에 지정하고
				// 토큰도 재생성할 필요없이 글쓰기 성공에 같이 처리하면 될것

				wCDAO.reg(sm);
				allMsgCount++;
				request.getSession().setAttribute("lastToken", token);
			} else {
				request.setAttribute("result", "글쓰기 실패");
			}

		} catch (Exception e) {
			request.setAttribute("result", "글쓰기 실패");
			e.printStackTrace();
		}
	}

}
