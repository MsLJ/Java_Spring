package com.ms.jun161ns.main;

public class IronMan {
	public static final IronMan IRM=new IronMan();
	public IronMan() {
		// TODO Auto-generated constructor stub
	}
	public static IronMan getIrm() {
		return IRM;
	}
	public void attack() {
		System.out.println("빔 발사");
	}
	

}
