package com.ms.jun161sdi.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ms.jun161sdi.company.Company;
import com.ms.jun161sdi.company.HandPhone;

public class SDIMain2 {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans2.xml");
		aac.registerShutdownHook();
		Company c = (Company) aac.getBean("c");
		c.print();
		HandPhone h = (HandPhone) aac.getBean("h");
		h.print();
		aac.close();

	}

}
