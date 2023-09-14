package com.ms.web2.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateManager {
	
	
	public static void getCurYear(HttpServletRequest request) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String cy=sdf.format(new Date());
		int cy2=Integer.parseInt(cy);
		request.setAttribute("cy", cy2);
		
	}

}
