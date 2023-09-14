package com.ms.web2.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ByeController")
public class ByeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (MemberDAO.getMdao().isLogined(request)) {
			MemberDAO.getMdao().deleteMember(request);
			MemberDAO.getMdao().logout(request);
			MemberDAO.getMdao().isLogined(request);
			request.setAttribute("cp", "home.jsp");
		}

		request.setAttribute("cp", "home.jsp");

		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}