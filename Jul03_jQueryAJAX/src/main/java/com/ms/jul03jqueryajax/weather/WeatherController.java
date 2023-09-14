package com.ms.jul03jqueryajax.weather;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherController {

	@Autowired
	private WeatherDAO wDAO;

	@RequestMapping(value = "/weather.get", method = RequestMethod.GET,produces="application/xml; charset=utf-8")
	public @ResponseBody String weatherGet(@RequestParam(value="zone")String zone) {
		//zone을 받기위한 작업 @ResponseBody&&RequestParam
		return wDAO.get(zone);
	}

}