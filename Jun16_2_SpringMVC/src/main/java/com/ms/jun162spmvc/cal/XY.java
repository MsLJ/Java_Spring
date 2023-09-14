package com.ms.jun162spmvc.cal;


//Spring이 자동으로 객체를 생성해주는데
//조건은 JSP파라메터명과 멤버변수명이 같아야한다.
public class XY {
	private int x;
	private int y;

	public XY() {
		// TODO Auto-generated constructor stub
	}

	public XY(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
