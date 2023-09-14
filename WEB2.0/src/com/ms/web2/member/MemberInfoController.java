package com.ms.web2.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ms.web2.main.DateManager;
@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.getMdao().login(request);
		if (MemberDAO.getMdao().isLogined(request)) {
			//주소 뜯어서 
			MemberDAO.getMdao().splitAddr(request);
		request.setAttribute("cp", "member/info.jsp");
		
		
	}else {
		request.setAttribute("cp", "home.jsp");
		
	}
	request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.getMdao().login(request);
		if (MemberDAO.getMdao().isLogined(request)) {
			MemberDAO.getMdao().updateMemberInfo(request);
			MemberDAO.getMdao().splitAddr(request);
			request.setAttribute("cp", "home.jsp");
			
			
		}else {
		
		
			request.setAttribute("cp", "home.jsp");
		}
		
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
