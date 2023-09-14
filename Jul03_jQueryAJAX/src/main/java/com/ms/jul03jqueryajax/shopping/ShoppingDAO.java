package com.ms.jul03jqueryajax.shopping;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class ShoppingDAO {
	public String get(HttpServletRequest request) {
		HttpsURLConnection huc = null;
		try {
//			네이버 개발자 센터:Cross-Domain적용 안되어있음
//			->JavaScript로 AJAX는 불가능(파랑)
//			JAVA로 HTTP통신해서,그쪽으로 요청을 (빨강)
//			네이버 개발자 센터
//				req.param
//				query
//				start
//				req.header
//				X-Naver-Client-id
//				x-Naver-Client-Secret
			//기존에 하던 주소에 파라메터넣어서 하는방식은X
			//왜냐하면 지금 네이버API는 Header키와 벨류값을 필요로하기에
			//그냥 인터넷창주소에 파라메터넣어서 검색하면 아무것도 안뜸... 
			//이곳에서 header를 설정했기에 검색은 무조건 View쪽input을 사용하여
			//검색해봐야할것
			String q=request.getParameter("q");
			String start=request.getParameter("s");
			String h1=request.getHeader("ni");
			String h2=request.getHeader("ns");
			//System.out.println(q);
			String s = "https://openapi.naver.com/v1/search/shop.xml?query="+q+"&start="+start;
			URL u = new URL(s);
			huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("X-Naver-Client-Id", h1);
			huc.addRequestProperty("X-Naver-Client-Secret", h2);
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			return br.readLine();
			
	}catch (Exception e) {
		
		e.printStackTrace();
		return null;
	}finally {
		huc.disconnect();
	}
	}


}

