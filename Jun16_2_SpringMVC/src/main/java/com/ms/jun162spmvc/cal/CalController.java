package com.ms.jun162spmvc.cal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalController {
	// Servlet-context.xml이 이미 aac방식으로 불러와지는중
	// 거기 등록된 그 하나의 Calculator객체와 자동연결
	@Autowired
	private Calculator c;

	// 3).Spring ver(이걸 주로 쓰게될것) 자동형변환,객체자동
	@RequestMapping(value = "/xy.calculate", method = RequestMethod.GET)
	public String xtCalculate(XY xy, HttpServletRequest request) {
		c.calculate(xy, request);
		return "output";
	}

	// 1).JSP 버젼
//	@RequestMapping (value="/xy.calculate",method=RequestMethod.GET)
//	public String xtCalculate(HttpServletRequest request) {
//	  int x=Integer.parseInt(request.getParameter("x"));
//	  int y=Integer.parseInt(request.getParameter("y"));
//	  int hab=x+y;
//	  int ma=x-y;
//	  int gob=x*y;
//	  int invide=x/y;
//	  request.setAttribute("hab", hab);
//	  request.setAttribute("ma", ma);
//	  request.setAttribute("gob", gob);
//	  request.setAttribute("invide", invide);
//		return "output";
//	}
	// 2).Spring ver 자동형변환
//	@RequestMapping (value="/xy.calculate",method=RequestMethod.GET)
//	public String xtCalculate(
//			@RequestParam(value="x")int x ,
//			@RequestParam(value="y")int y
//			
//			) {
//		System.out.println(x);
//		System.out.println(y);
//		return "output";
//	}
	// 3).Spring ver(이걸 주로 쓰게될것) 자동형변환,객체자동

}
