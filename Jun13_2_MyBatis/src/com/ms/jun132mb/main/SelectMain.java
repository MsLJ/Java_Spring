package com.ms.jun132mb.main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMain {

	// DB ORM
	public static void main(String[] args) {
		SqlSession ss = null;
		try {
			InputStream is = Resources.getResourceAsStream("aaaa.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			ss = ssf.openSession();

			// Avengers - Ironman
			// List- ArrayList

//			Coffee=ss.selectList("coffeeMapper.selectCoffee");

			List<Coffee> coffees = ss.selectList("coffeeMapper.selectCoffee");
			for (Coffee coffee2 : coffees) {
				System.out.printf("%s,%.0f\r\n", coffee2.getC_name(), coffee2.getC_price());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		ss.close();
	}
}
