package com.ms.jun162spmvc.cal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

//servlet-context.xml에 자동등록
@Service
public class Calculator {

	public void calculate(XY xy,HttpServletRequest request) {
		int z=xy.getX()+xy.getY();
		int q=xy.getX()-xy.getY();
		int w=xy.getX()*xy.getY();
		int e=xy.getX()/xy.getY();
		request.setAttribute("hab", z);
		request.setAttribute("minus", q);
		request.setAttribute("gob", w);
		request.setAttribute("invide", e);
		

	}

}
