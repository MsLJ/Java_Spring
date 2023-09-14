package com.ms.jul03jqueryajax.shopping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShoppingController {
	
	@Autowired
	private ShoppingDAO sDAO;
	@RequestMapping(value = "/get.shopping", method = RequestMethod.GET,produces="application/xml; charset=utf-8")
	public @ResponseBody String getshopping(HttpServletRequest request) {
		
		return sDAO.get(request);
	}

}
