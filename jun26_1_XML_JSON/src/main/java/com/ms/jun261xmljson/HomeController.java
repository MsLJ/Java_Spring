package com.ms.jun261xmljson;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ms.jun261xmljson.biskit.BiskitDAO;
import com.ms.jun261xmljson.biskit.Biskits;
import com.ms.jun261xmljson.menu.MenuDAO;
import com.ms.jun261xmljson.menu.Menus;

@Controller
public class HomeController {

	@Autowired
	private BiskitDAO bDAO;
	@Autowired
	private MenuDAO mDAO;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String gethome(HttpServletRequest request) {
		bDAO.getbiskit(request);
		return "index";
	}

	@RequestMapping(value = "/biskit.get", method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody Biskits biskitGet(HttpServletRequest request) {
		
		Biskits biskits = bDAO.getbiskit2();
		// index.jsp로 포워딩-x
		// index라는 글자를 응답-?
		return biskits;
	}
//	@RequestMapping(value = "/menu.get", method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
//	public @ResponseBody Menus menuGet(HttpServletRequest request) {
//		Menus menus=mDAO.getmenu2();
//		// index.jsp로 포워딩-x
//		// index라는 글자를 응답-?
//		return menus;
//	}
	
	

}

