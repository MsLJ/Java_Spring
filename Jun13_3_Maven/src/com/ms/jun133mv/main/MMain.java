package com.ms.jun133mv.main;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MMain {
	// Java:외부 .jar 잘 쓰기
	// ->Maven:.jar자동관리
	public static void main(String[] args) {
		//Connection con=null;
		SqlSession ss=null;
		try {
			//aaaa.xml 이라는 설계도 
			InputStream is=Resources.getResourceAsStream("aaaa.xml");
			
			//공장 설계자 생성  공장은 설계자가 설계도로 만든것
			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf=ssfb.build(is);
			ss=ssf.openSession();
			System.out.println("성공");

		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
