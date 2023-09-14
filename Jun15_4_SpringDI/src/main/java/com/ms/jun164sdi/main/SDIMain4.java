package com.ms.jun164sdi.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ms.jun164sdi.human.Human;

public class SDIMain4 {
	public static void main(String[] args) {

		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans.xml");
		aac.registerShutdownHook();
		Human h = (Human) aac.getBean("h");
		h.printInfo();
//		Human hh = (Human) aac.getBean("h2");
//		hh.printInfo();
		// 오늘날짜
//		Date now = new Date();
		// 2023/06/15
//		SimpleDateFormat sdf = (SimpleDateFormat) aac.getBean("sdf");
		// Spring의 장점
		// SimpleDateFormat을수정할일이 생기면
		// bean으로 만들어 놓으면 유지보수하기 용이할것
//		String result = sdf.format(now);
		// 마지막에 String으로 받을것
//		System.out.println(result);

		aac.close();

	}

}
