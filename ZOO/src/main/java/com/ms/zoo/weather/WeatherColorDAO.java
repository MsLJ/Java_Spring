package com.ms.zoo.weather;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.zoo.sns.SNSMsg;

@Service
public class WeatherColorDAO {

	@Autowired
	private SqlSession ss;

	public void reg(SNSMsg sm) {
		HttpURLConnection huc = null;
		try {

			
			Weather w=new Weather();
			
			URL u = new URL(
					"https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=baff8f3c6cbc28a4024e336599de28c4&units=meric&lang=kr");
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			JSONParser jp = new JSONParser();
			JSONObject weatherData = (JSONObject) jp.parse(isr);
			// 홈페이지상에서 weahter만 리스트로 되어있기에 리스트에0번째가 우리가 원하는 description이 있다
			JSONArray weather = (JSONArray) weatherData.get("weather");
			JSONObject weather0 = (JSONObject) weather.get(0);
			System.out.println(weather0.get("description"));

			JSONObject main = (JSONObject) weatherData.get("main");
			System.out.println(main.get("temp"));
			System.out.println(main.get("humidity"));
//			String o=(String)main.get("temp");
//			Object oo=main.get("humidity");
			w.setZwc_temp(new BigDecimal(main.get("temp").toString()));
			w.setZwc_humidity(new BigDecimal(main.get("humidity").toString()));
			w.setZwc_description((String) weather0.get("description"));

			w.setZwc_color(sm.getZs_color());
			ss.getMapper(WeatherMapper.class).reg(w);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		huc.disconnect();

	}
}
