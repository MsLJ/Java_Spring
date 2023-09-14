package com.ms.db.manager;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//하나의 프로젝트만 할것이라면 이렇게 싱글턴패턴을 적용시키는게 맞을것인데
//개발자가 하나의 프로젝트만?
//사실 이건 오래써먹기는 힘들지도?

public class msDBManager {
	private SqlSessionFactory sf;
	private msDBManager() {
		
	}

	public void setSqlSessionFactory(String cfgFile) {
		try {
			InputStream is = Resources.getResourceAsStream(cfgFile);
			System.out.println(cfgFile);
			sf = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
		}

	}

	private static final msDBManager MSDB = new msDBManager();


	public static msDBManager getMsdb() {
		return MSDB;
	}

	public SqlSession connect() {
		return sf.openSession();

	}

}
