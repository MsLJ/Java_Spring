package com.ms.jun164ucv.ucc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UnitConvertController {

	@Autowired
	private UnitConverter ur;

	@RequestMapping(value = "/unit.convert", method = RequestMethod.GET)
	public String goConvert(UCResult ucr, HttpServletRequest request) {
		ur.convert(ucr, request);
		
		return "output";

	}

}
