package com.ms.jun132mb.main;

import java.io.InputStream;
import java.util.Scanner;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeleteController {

	public static void main(String[] args) {
		Scanner k=new Scanner(System.in);
		SqlSession ss = null;
		try {
			InputStream is=Resources.getResourceAsStream("aaaa.xml");
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(is);
			ss=ssf.openSession();
			
			System.out.println("삭제이름뭐:");
			String c=k.next();
			
			Coffee cc=new Coffee(c,null);
			
			
			if (ss.delete("coffeeMapper.deleteCoffee",cc)==1) {
				System.out.println("삭제성공");
				ss.commit();
				
			}

			
		} catch (Exception e) {
			System.out.println("삭제 실패");
			e.printStackTrace();

		}
		k.close();
		ss.close();
	}

}
