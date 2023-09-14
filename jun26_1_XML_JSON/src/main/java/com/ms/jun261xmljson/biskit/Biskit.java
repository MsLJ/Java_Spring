package com.ms.jun261xmljson.biskit;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Biskit {//데이터 하나를 표현하는 JavaBean

	//클래스 바로 위에 @XmlRootElement
private String b_name;
private BigDecimal b_price;
public Biskit() {
	// TODO Auto-generated constructor stub
}
public Biskit(String b_name, BigDecimal b_price) {
	super();
	this.b_name = b_name;
	this.b_price = b_price;
}

public String getB_name() {
	return b_name;
}
//set위에 @XmlElement
@XmlElement
public void setB_name(String b_name) {
	this.b_name = b_name;
}
public BigDecimal getB_price() {
	return b_price;
}
@XmlElement
public void setB_price(BigDecimal b_price) {
	this.b_price = b_price;
}


}
