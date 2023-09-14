package com.ms.jun191spmvcmybatis.menu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MenuController {
	
	@Autowired
	private MenuDAO mDAO;

	@RequestMapping(value = "/menu.reg", method = RequestMethod.GET)
	public String menu(Menu m, HttpServletRequest request) {
		mDAO.reg(m, request);
		mDAO.get(request);
		System.out.println(m.getM_name());
		System.out.println(m.getM_price());

		return "index";
	}
	
	
	

}
