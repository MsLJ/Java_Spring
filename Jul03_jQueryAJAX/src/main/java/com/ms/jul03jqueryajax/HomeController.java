package com.ms.jul03jqueryajax;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.jul03jqueryajax.shopping.ShoppingDAO;
import com.ms.jul03jqueryajax.weather.WeatherDAO;

@Controller
public class HomeController {
	@Autowired
	private WeatherDAO wDAO;
	@Autowired
	private ShoppingDAO sDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request ) {
		

		return "index";
	}

}
