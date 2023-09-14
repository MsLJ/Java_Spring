package com.ms.jun132mb.main;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class ConnectMain {

	// JDBC
	// ConnectionPool
	// MyBatis:
	// 	Java+DB유지보수 용이
	//	 DB ORM(Object Relationship Mapping)Framework
	
	

	// 					DB연결정보 		SQL
	// JDBC 			.java 			.java
	// ConnectionPool 	context.xml 	.java
	// MyBatis 			???.xml 		???.xml

	// OracleDB서버->ojdbc8.jar
	// MyBatis ->mybatis.jar

	// 만약  Maven에서 받아왔는데 제대로 작동하지않는다면
	// Eclipse끄고
	// 로컬저장소
	// c:\사용자\계정\.m2
	// .m2폴더 삭제하고
	// Eclipse켜기 그 후에 프로젝트 우클릭 Maven->Update Project
	// import도 지워지기에 project 우클릭 다시 Maven import작업
	
	//https://mybatis.org/mybatis-3/

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
