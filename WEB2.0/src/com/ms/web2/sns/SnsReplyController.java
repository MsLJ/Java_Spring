package com.ms.web2.sns;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ms.web2.main.TokenGenerator;
import com.ms.web2.member.MemberDAO;

@WebServlet("/SnsReplyController")
public class SnsReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (MemberDAO.getMdao().isLogined(request)) {
			SnsDAO.getSdao().snsReply(request);
		}
		TokenGenerator.generate(request);
		SnsDAO.getSdao().getSns(1, request);
		request.setAttribute("cp", "sns/sns.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
