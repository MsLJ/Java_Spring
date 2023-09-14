package com.ms.zoo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.zoo.member.MemberDAO;
import com.ms.zoo.sns.SNSDAO;

@Controller
public class HomeController {
	private boolean isFirstReq;
	// 기존 방식이 안통하기에 처음 유저가 접속하면
	// 페이지를 세는걸로 처음 들어왔는지 아닌지 체크하는 변수 만들고

	@Autowired
	private MemberDAO mDAO;

	@Autowired
	private TokenGenerator tGT;

	@Autowired
	private SNSDAO sDAO;

	// JVM이 OS위에 올라가고
	// ->Static들 만들어지고
	// ->main으로 가서 시작

	// JSP Model2:직접 다
	// DAO를 직접 싱글턴 작업을
	// ->Static영역에
	// ->DAO가 만들어지고 ->HomeController만들어짐

	// (Spring+Maven+MyBatis) Framework:자동으로
	// Spring에서는 자동으로
	// ->Static영역이 아니다
	// DAO를 servlet-context.xml에 하나 만들어놨음
	// C도 servlet-context.xml에 하나 만들어놨음
	// SqlSession servlet-context.xml에 하나 만들어놨음
	// Spring: servlet-context.xml에 등록해놓으면 자동으로 객체 만들어줌
	// DAO가 먼저 생성? C? SqlSession?(어떤 객체가 먼저 생성될지 모름)
	// SqlSession->DAO->Controller 순으로 객체 생성이 되어야할것
	public HomeController() {
		// sDAO.setAllmsgCount();
		isFirstReq = true;
		// 프로젝트 실행됐을때 true
	}

	// 서비스 시작해놓고
	// 어떤 사용자가 첫 접속때

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		if (isFirstReq) {
			// 프로젝트 실행되고 처음 들어온사람에 의해 페이지를 세고 그 후에 다시 false로 해놓으면
			// 프로젝트를 다시 실행하기전까지는 세지않을것
			sDAO.setAllmsgCount();
			isFirstReq = false;

		}
		mDAO.islogined(request);
		tGT.generate(request);
		sDAO.snsGet(request, 1);
		sDAO.clearsearch(request);
		request.setAttribute("cp", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String indexDo(HttpServletRequest request) {
		tGT.generate(request);
		return home(request);
	}

}
