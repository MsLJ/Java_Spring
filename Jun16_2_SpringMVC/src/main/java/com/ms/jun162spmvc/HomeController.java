package com.ms.jun162spmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//JSP Model2:C가 SerVlet
//			주소/프로젝트폴더명/컨트롤러명 doGet,doPost

//주소/패키지 마지막자리/마음대로
//SpringMVC:C를 일반 클래스에서 @Controller
@Controller
public class HomeController {
	// te.st로 GET방식 요청받으면
	@RequestMapping(value = "/home.ms", method = RequestMethod.GET)
	public void test() {
		// 요청 들어오면 이 메소드가 실행되게
		System.out.println("요청받음");
	}

	@RequestMapping(value = "/ab.cd", method = RequestMethod.GET)
	public void abcd() {
		// 요청 들어오면 이 메소드가 실행되게
		System.out.println("abcd요청받음");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goInput() {
//		request.getRequestDispatcher("input.jsp").forward(request.response);
		return "input";//input.jsp로 포워딩
	}


}
