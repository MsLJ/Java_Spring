package com.ms.jun163s.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

//Java-JSP-EJB(Enterprise JavaBean)
//				winter
//Spring: 웹 개발X POJO를 사용,IoC로 DI해주는 Framework
//		기존에 있던 자바객체를 사용하지만 프로그램이 아닌 외부파일에서 객체를 만들고 프로그램을 제어하는 Framework

//		POJO(Plain Old Java Object)
//		IoC(Inversion of Control)
//			제어의 역전
//			프로그램 -제어-> 파일
//			v 파일-제어->프로그램 (IoC)
//		DI(Dependency Injection)
//			의존성 주입
//			객체만들고 값 넣고

public class SMain {

	public static void main(String[] args) {
		//빈 공장객체
		DefaultListableBeanFactory dlbf
		=new DefaultListableBeanFactory();
		//xml 읽는객체
		XmlBeanDefinitionReader xbdr
		=new XmlBeanDefinitionReader(dlbf);
		//xml파일 읽기
		xbdr.loadBeanDefinitions(
				new ClassPathResource("hero.xml")
				);
		
		
		//뭘 받아와야할지 모르니 (객체)dlbf.getBean(id명);
		Avengers aa=(Avengers)dlbf.getBean("a");
//		Avengers aa=dlbf.getBean("a",Avengers.class);
		aa.attack();

	}

}
