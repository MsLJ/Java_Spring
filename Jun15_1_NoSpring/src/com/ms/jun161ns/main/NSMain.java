package com.ms.jun161ns.main;

//게임을 만들자: 첫 캐릭터로 아이언맨 

// 개발 팀장 : 빔 발사 기능이 있는 아이언맨 만들라고 지시

// 신입개발자: 빔 발사 기능 잇는 아이언맨 생성
//게임을 만들자: 첫 캐릭터로 아이언맨
//->첫 캐릭터로 헐크,아이언맨은 현질하게
//만약 이렇게 된다면 자바 코드를 싹다 처음부터 다 뜯어고쳐야할것

public class NSMain {
	public static void main(String[] args) {
		Hulk hk = new Hulk();
		hk.attack();
		IronMan.getIrm().attack();
		// 메소드명을 모르기에 .beam일수도 있고 공격이

	}

}
