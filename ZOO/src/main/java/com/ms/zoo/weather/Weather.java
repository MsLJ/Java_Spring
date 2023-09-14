package com.ms.zoo.weather;

import java.math.BigDecimal;

public class Weather {
	private BigDecimal zwc_temp;
	private BigDecimal zwc_humidity;
	private String zwc_description;
	private String zwc_color;

	public Weather() {
		// TODO Auto-generated constructor stub
	}

	public Weather(BigDecimal zwc_temp, BigDecimal zwc_humidity, String zwc_description, String zwc_color) {
		super();
		this.zwc_temp = zwc_temp;
		this.zwc_humidity = zwc_humidity;
		this.zwc_description = zwc_description;
		this.zwc_color = zwc_color;
	}

	public BigDecimal getZwc_temp() {
		return zwc_temp;
	}

	public void setZwc_temp(BigDecimal zwc_temp) {
		this.zwc_temp = zwc_temp;
	}

	public BigDecimal getZwc_humidity() {
		return zwc_humidity;
	}

	public void setZwc_humidity(BigDecimal zwc_humidity) {
		this.zwc_humidity = zwc_humidity;
	}

	public String getZwc_description() {
		return zwc_description;
	}

	public void setZwc_description(String zwc_description) {
		this.zwc_description = zwc_description;
	}

	public String getZwc_color() {
		return zwc_color;
	}

	public void setZwc_color(String zwc_color) {
		this.zwc_color = zwc_color;
	}

}
