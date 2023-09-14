package com.ms.jun163spmvc.info;

import java.util.Date;

public class UserInfo {
	private String name;
	private Date birth;
	private int age;

	public UserInfo() {
		// TODO Auto-generated constructor stub
	}

	public UserInfo(String name, Date birth, int age) {
		super();
		this.name = name;
		this.birth = birth;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


   

}
