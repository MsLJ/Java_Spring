package com.ms.jun161sdi.company;

public class Company {
private String name;
private int worker;
private String address;
public Company() {
	// TODO Auto-generated constructor stub
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public int getWorker() {
	return worker;
}


public void setWorker(int worker) {
	this.worker = worker;
}


public String getAddress() {
	return address;
}


public void setAddress(String address) {
	this.address = address;
}


public Company(String name, int worker, String address) {
	super();
	this.name = name;
	this.worker = worker;
	this.address = address;
}

public void print () {
	System.out.println(name);
	System.out.println(worker);
	System.out.println(address);
}
}
