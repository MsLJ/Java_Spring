package com.ms.web2.member;

import java.math.BigDecimal;
import java.util.Date;

public class Member {
//	create table web2_member(
//			webm_id varchar2(10 char) primary key,
//			webm_pw varchar2(12 char) not null,
//			webm_name varchar2(12 char) not null,
//			webm_age number(3)not null,
//			webm_adr varchar2(100 char)not null,
//			webm_birthday date not null,
//			webm_photo varchar2(100 char)not null
//			);
	private String webm_id;
	private String webm_pw;
	private String webm_name;
	private BigDecimal webm_age;
	private String webm_adr;
	private Date webm_birthday;
	private String webm_photo;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String webm_id, String webm_pw, String webm_name, BigDecimal webm_age, String webm_adr,
			Date webm_birthday, String webm_photo) {
		super();
		this.webm_id = webm_id;
		this.webm_pw = webm_pw;
		this.webm_name = webm_name;
		this.webm_age = webm_age;
		this.webm_adr = webm_adr;
		this.webm_birthday = webm_birthday;
		this.webm_photo = webm_photo;
	}
	public String getWebm_id() {
		return webm_id;
	}
	public void setWebm_id(String webm_id) {
		this.webm_id = webm_id;
	}
	public String getWebm_pw() {
		return webm_pw;
	}
	public void setWebm_pw(String webm_pw) {
		this.webm_pw = webm_pw;
	}
	public String getWebm_name() {
		return webm_name;
	}
	public void setWebm_name(String webm_name) {
		this.webm_name = webm_name;
	}
	public BigDecimal getWebm_age() {
		return webm_age;
	}
	public void setWebm_age(BigDecimal webm_age) {
		this.webm_age = webm_age;
	}
	public String getWebm_adr() {
		return webm_adr;
	}
	public void setWebm_adr(String webm_adr) {
		this.webm_adr = webm_adr;
	}
	public Date getWebm_birthday() {
		return webm_birthday;
	}
	public void setWebm_birthday(Date webm_birthday) {
		this.webm_birthday = webm_birthday;
	}
	public String getWebm_photo() {
		return webm_photo;
	}
	public void setWebm_photo(String webm_photo) {
		this.webm_photo = webm_photo;
	}
	
	
	

}
