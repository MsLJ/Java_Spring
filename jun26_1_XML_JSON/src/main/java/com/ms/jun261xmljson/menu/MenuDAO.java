package com.ms.jun261xmljson.menu;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuDAO {
	@Autowired
	private SqlSession ss;

//테이블 표현하는 객체로 표현
	public Menus getmenu2(int page) {
//	List<Menu>menu=ss.getMapper(MenuMapper.class).get();
//	Menus menus=new Menus(menu);
//	return menus;
		// 한줄로 요약
		int getall = ss.getMapper(MenuMapper.class).getpage();
		int perpage = 5;
		int pageCount=(int)Math.ceil(getall/(double)perpage);
		//page값은 주소에서 받아오는거임
		if (page>pageCount) {
			return null;
			
		}
		int start = (page - 1) * perpage + 1;
		int end = page * perpage;
		MenuPage mp=new MenuPage( new BigDecimal(start),new BigDecimal(end));
		
		return new Menus(ss.getMapper(MenuMapper.class).get(mp));
	}

}
