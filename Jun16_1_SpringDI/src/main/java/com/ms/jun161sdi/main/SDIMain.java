package com.ms.jun161sdi.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//Spring
//aac

import com.ms.jun161sdi.company.Company;
import com.ms.jun161sdi.company.Snack;

public class SDIMain {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans.xml");
		aac.registerShutdownHook();

//		Company c = (Company) aac.getBean("c");
//		c.print();

		Snack s = (Snack) aac.getBean("s1");
		System.out.println(s.getName());
		System.out.println(s.getPrice());
		s.getMaker().print();
		for (String string : s.getIngredients()) {
			System.out.println(string);
		}
		for (String string : s.getStyle()) {
			System.out.println(string);
		}

		for (String string : s.getNutrient().keySet()) {
			System.out.println(string);

		}
//		for (String string : s.getNutrient().get()) {
//			
//		}
		
		System.out.println(s.getNutrient().get("탄수화물"));
		System.out.println(s.getNutrient().get("단백질"));
		System.out.println(s.getNutrient().get("당분"));
		System.out.println(s.getNutrient().get("염분"));

		aac.close();
	}

}
