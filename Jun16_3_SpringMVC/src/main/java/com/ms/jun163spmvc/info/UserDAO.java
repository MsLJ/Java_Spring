package com.ms.jun163spmvc.info;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class UserDAO {
	private SimpleDateFormat sdf;
	private SimpleDateFormat sdf2;

	public UserDAO() {
		sdf = new SimpleDateFormat("yyyyMMdd");
		sdf2 = new SimpleDateFormat("yyyy");

	}

	public void printUserInfo(UserInfo ui, HttpServletRequest request) {

		try {
			String b = request.getParameter("birth2");
			ui.setBirth(sdf.parse(b));

			String by = sdf2.format(ui.getBirth());
			int birthyear = Integer.parseInt(by);

			String cy = sdf2.format(new Date());
			int curYear = Integer.parseInt(cy);

			int age = curYear - birthyear;
			ui.setAge(age);
			request.setAttribute("ui", ui);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
