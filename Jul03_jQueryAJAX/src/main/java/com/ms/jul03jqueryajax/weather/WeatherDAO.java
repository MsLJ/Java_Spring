package com.ms.jul03jqueryajax.weather;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

@Service
public class WeatherDAO {

	public String get(String zone) {
		// 자바로 기상청XML 콘솔창에
		//Proxy:
		//기존 방식으로는 기상청에서 받아올수없으니 다른 방법으로 우회해서
		//따로 자바때 했던 형식으로 정보를 받아오고 그걸 내껄로 만들어놓은후에 
		//V쪽에서 내껄 다시 받아와서 parsing하는쪽으로 이게바로 Proxy
		//zone을 받기위해
		HttpsURLConnection huc = null;
		try {
			String s = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone="+zone;
			URL u = new URL(s);
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			StringBuffer sb = new StringBuffer();
			//스트링을 한줄에 뭉치게 하는
			while ((line = br.readLine()) != null) {

				sb.append(line);
			}
			String xml = sb.toString();
			System.out.println(xml);
			return xml;
			//한줄에 뭉쳐서 그걸 리턴

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			huc.disconnect();
		}

	}

}
