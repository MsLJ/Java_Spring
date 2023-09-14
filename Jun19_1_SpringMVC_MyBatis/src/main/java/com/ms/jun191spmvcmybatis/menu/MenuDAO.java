package com.ms.jun191spmvcmybatis.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuDAO {
	// 등록된거랑 자동연결 Autowired
	@Autowired
	private SqlSession ss;
	
	
	public void get(HttpServletRequest request) {
		MenuMapper mp= ss.getMapper(MenuMapper.class);
		List<Menu>menus=mp.get();
		request.setAttribute("m", menus);
//		request.setAttribute("m", ss.getMapper(MenuMapper.class).get());
		
		
	}

	public void reg(Menu m, HttpServletRequest request) {
		try {
			//결과처리를 보기위해 기존에 했던 request.setattribute로
			//결과처리를 보는작업 만약에 결과처리를 보는 작업이 필요없다면
			//request도 필요x
			if (ss.getMapper(MenuMapper.class).reg(m)==1) {
				request.setAttribute("result", "성공");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "실패");
		}
		// interface부르기
//		MenuMapper mm = ss.getMapper(MenuMapper.class);

		// abstract method를 부르면 Sql자동으로 가능
//		mm.reg(m);

	}

}
