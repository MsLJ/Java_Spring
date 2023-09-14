package com.ms.zoo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class TokenGenerator {
	private SimpleDateFormat sdf;

	public TokenGenerator() {
		sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
	}

	public void generate(HttpServletRequest request) {
		Date now = new Date();
		String token = sdf.format(now);
		request.setAttribute("token", token);
	}

}
