package com.ms.jun164sdi.main;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

//기존 자바에서는 이름과 나이를 바꿀려면 싹다 코드를 갈아엎어야함
//Spring 쓰지말고 
// beans.xml에 객체 만들어 놓은거고 java쪽에서는 불러오기만하는거
//dlbf:처음 부를때 만들뿐
// 이름이 뽀삐,3살인 개
// 정보출력
public class SDIMain {
	public static void main(String[] args) {
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(new ClassPathResource("beans.xml"));
		System.out.println("ㅋ");
		Dog d = (Dog) dlbf.getBean("d1");
		d.printInfo();
		Dog d2 = (Dog) dlbf.getBean("d1");
		d2.printInfo();
		System.out.println(d);
		System.out.println(d2);
		Dog dd = (Dog) dlbf.getBean("d2");
		dd.printInfo();

	}
}
