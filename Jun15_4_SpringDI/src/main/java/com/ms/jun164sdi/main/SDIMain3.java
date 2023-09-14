package com.ms.jun164sdi.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class SDIMain3 {
	public static void main(String[] args) {
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(new ClassPathResource("beans.xml")

		);
		// aac는 기본생성자를 미리 만들어놓기에 dlbf방식이랑 다르게
		// 기본생성자 n개를 먼저 만듬
		// dlbf같은 경우에는 객체를 만들어질때 그 때마다 기본생성자 만듬
		Dog d = (Dog) dlbf.getBean("d1");
		d.printInfo();
		Dog dd = (Dog) dlbf.getBean("d2");
		dd.printInfo();
		Dog ddd=(Dog)dlbf.getBean("d3");
		ddd.printInfo();

	}
}
