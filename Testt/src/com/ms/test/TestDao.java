package com.ms.test;

import javax.servlet.http.HttpServletRequest;

public class TestDao {
	public static void getTest(HttpServletRequest request){
		
		int a=10;
		request.setAttribute("a", a);
		
	}

}
