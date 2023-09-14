package com.ms.web2.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class TokenGenerator {
	public static void generate(HttpServletRequest request) {
		Date now = new Date();
		// 새로고침했을때 각기 다른 고유 번호가 필요함
		// 그 번호를 년도 시간 분 초단위로 번호를 설정하면 됄것
		SimpleDateFormat sdf = new SimpleDateFormat("mmssSS");

		request.setAttribute("token", sdf.format(now));
	}

}
