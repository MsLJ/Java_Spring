package com.ms.zoo.member;

import java.util.Date;
public class ZooMember {
	private String zm_id;
	private String zm_pw;
	private String zm_name;
	private Date zm_birthday;
	private String zm_addr;
	private String zm_photo;
	public ZooMember() {
		// TODO Auto-generated constructor stub
	}
	public ZooMember(String zm_id, String zm_pw, String zm_name, Date zm_birthday, String zm_addr, String zm_photo) {
		super();
		this.zm_id = zm_id;
		this.zm_pw = zm_pw;
		this.zm_name = zm_name;
		this.zm_birthday = zm_birthday;
		this.zm_addr = zm_addr;
		this.zm_photo = zm_photo;
	}
	public String getZm_id() {
		return zm_id;
	}
	public void setZm_id(String zm_id) {
		this.zm_id = zm_id;
	}
	public String getZm_pw() {
		return zm_pw;
	}
	public void setZm_pw(String zm_pw) {
		this.zm_pw = zm_pw;
	}
	public String getZm_name() {
		return zm_name;
	}
	public void setZm_name(String zm_name) {
		this.zm_name = zm_name;
	}
	public Date getZm_birthday() {
		return zm_birthday;
	}
	public void setZm_birthday(Date zm_birthday) {
		this.zm_birthday = zm_birthday;
	}
	public String getZm_addr() {
		return zm_addr;
	}
	public void setZm_addr(String zm_addr) {
		this.zm_addr = zm_addr;
	}
	public String getZm_photo() {
		return zm_photo;
	}
	public void setZm_photo(String zm_photo) {
		this.zm_photo = zm_photo;
	}
	
	

}
