package com.ms.zoo;

public class ZOOAttribute {
	private int snsMsgPerPage;

	public ZOOAttribute() {
		// 여기에 페이지를 설정하는게 아닌 객체를 생성해서 xml에
		// 등록하기위해 이곳에 만들어놓은것 유지보수 편하게 하기위해
	}

	public ZOOAttribute(int snsMsgPerPage) {
		super();
		this.snsMsgPerPage = snsMsgPerPage;
	}

	public int getSnsMsgPerPage() {
		return snsMsgPerPage;
	}

	public void setSnsMsgPerPage(int snsMsgPerPage) {
		this.snsMsgPerPage = snsMsgPerPage;
	}

}
