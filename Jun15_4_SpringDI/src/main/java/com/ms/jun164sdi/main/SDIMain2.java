package com.ms.jun164sdi.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//aac:일단 다 만들어놓음

//GarbageCollection :heap에서의 주소값을 stack영역에 가져다 와서쓰는데
// Stack영역에  heap의 주소값을 가져다 쓰는데 
// Stack영역에 heap 지정된주소값이 없으면 (프로그램이 종료될 시기 혹은 없을때)
// 자바내에서 자체적으로 heap영역에 있는주소값을 자동정리해주는 
//시스템을 GC라고 부른다
//aac는 지금 Heap에 일단 주소값 생성상태인데
//aac는 GC에 해당하지않음 자동으로 지워지지않기에 수동으로 .close해야 지워짐
public class SDIMain2 {
	public static void main(String[] args) {
		//객체를 getBean하기전에 aac는 이미 미리 객체를 만들어놓음
		AbstractApplicationContext aac
		= new ClassPathXmlApplicationContext("beans.xml");
		aac.registerShutdownHook();
		//aac가 없어질때 만들어논 객체 없애라고
		
		System.out.println("ㅋ");
//		Dog dd1=(Dog)aac.getBean("d2");
//		dd1.printInfo();
		aac.close();//aac없애기->만들어놨던 객체 없애기
	}

}
