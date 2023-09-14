package com.ms.jun191spmvcmybatis;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.jun191spmvcmybatis.menu.MenuDAO;

@Controller
public class HomeController {
	
	
	@Autowired
	private MenuDAO mDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		mDAO.get(request);

		return "index";
	}

}
