package com.ms.web2.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import com.ms.db.manager.msDBManager;
import com.ms.web2.member.MemberDAO;
import com.ms.web2.sns.SnsDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		msDBManager.getMsdb().setSqlSessionFactory("com/ms/web2/main/config.xml");
		SnsDAO.getSdao().setAllSNSCount();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		MemberDAO.getMdao().login(request);
		MemberDAO.getMdao().isLogined(request);
		
		request.setAttribute("cp", "home.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
