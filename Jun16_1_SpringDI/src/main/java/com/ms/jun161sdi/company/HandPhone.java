package com.ms.jun161sdi.company;

import org.springframework.beans.factory.annotation.Autowired;

//if(
//세상에 회사는 카카오밖에 없고:Singleton
//모든 핸드폰은 카카오에서:static
//)
//@XXX: annotation
// 	원래는 작업해야,
//  어노테이션 쓰면 자동으로 처리됨

public class HandPhone {
//beans2.xml에 등록되어있는
	// 그 하나뿐인 회사랑 자동 연결
	// aac방식이여야만
	@Autowired
	private Company maker;

	// 생성자 x
	// getter/setter x
	public void print() {
		maker.print();
	}

}
