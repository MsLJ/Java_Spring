package com.ms.jun132mb.main;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UpdateMain {

	public static void main(String[] args) {
		SqlSession ss = null;
		Scanner k = new Scanner(System.in);
		try {
			// 5000이상 ->-500깍기

			InputStream is = Resources.getResourceAsStream("aaaa.xml");
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			ss = sf.openSession();
			System.out.println("얼마이상?");
			int price = k.nextInt();
			BigDecimal p = new BigDecimal(price);
			System.out.println("얼마 할인");
			BigDecimal pp = new BigDecimal(k.nextInt());
			CoffeeUpdateValues cc = new CoffeeUpdateValues(pp, p);

			if (ss.update("coffeeMapper.updateCoffeePrice", cc) >= 1) {
				System.out.println("업데이트 성공");
				ss.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("업데이트 실패");
			// TODO: handle exception
		}
		k.close();
		ss.close();
	}
	

}
