package com.ms.jun132mb.main;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InsertMain {

	public static void main(String[] args) {
		SqlSession ss = null;
		try {
			InputStream is = Resources.getResourceAsStream("aaaa.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			ss = ssf.openSession();
			Scanner k = new Scanner(System.in);
			System.out.println("이름:");
			String name = k.next();
			System.out.println("가격:");
			int p = k.nextInt();
//			BigDecimal price=k.nextBigDecimal();
			BigDecimal pp = new BigDecimal(p);// int,double,String->BigDecimal때는 new 생성자
			int ppp=pp.intValue();// BigDecimal->int

			Coffee c = new Coffee(name, pp);
			// (namespace.id)
			if (ss.insert("coffeeMapper.regCoffee", c) == 1) {
				System.out.println("등록성공");
				ss.commit();
			}
			// db작업은 위험해서
			// commit해야 실제 서버에 반영 /rollback하면 취소
			// 이클립스/JDBC/Connection Pool이 자동 commit이였음

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
		}
		ss.close();
	}

}
