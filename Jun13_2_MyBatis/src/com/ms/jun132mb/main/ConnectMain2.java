package com.ms.jun132mb.main;

import org.apache.ibatis.session.SqlSession;

import com.ms.db.manager.msDBManager;

public class ConnectMain2 {

	public static void main(String[] args) {

		SqlSession ss = null;
		try {
			//기존에 메인보다 매니저가 먼저 실행돼서 파일명 세팅되는 시점보다
			//싱글턴 이여서 순서가 파일을 먼저 연결하게된다
			//기존 싱글턴으로는 안될것;
			// aaaa.xml 이라는 설계도
			msDBManager.getMsdb().setSqlSessionFactory("aaaa.xml");
			ss = msDBManager.getMsdb().connect();

			// 공장 설계자 생성 공장은 설계자가 설계도로 만든것
			System.out.println("성공");

		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();

	}
}
