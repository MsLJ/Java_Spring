package com.ms.jun13maintence.main;

import java.util.Scanner;

public class MartMain {
	// 마트 정책이 포인트를 0.5%적립하는걸로 바뀜
	// ->프로그램 수정해야
	// 1)마트 사장님이 자바 못함
	// 2)할줄안다해도 수정불가
	// .jar:컴파일된거 압축해놓은거
	// ->마트측에서 해결 불가능
	// ->개발자한테 연락
	// ->소스수정 ->재컴파일 ->재압축->재배포
	
	// 전임자가 만들어놓고 프로젝트 지우고 퇴사
	// 이 친구가 들어갔는데 바꿔야함 war를 디컴파일
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		int price = 0;
		
		double point = 0;
		double sumpoint = 0;

		while (true) {
			System.out.println();
			price = k.nextInt();
			point = (price * 0.01);
			System.out.printf("물건 사서 생긴 포인트:%.01f", point);
			sumpoint += point;
			System.out.println();
			System.out.printf("총 포인트:%.0f", sumpoint);
			if (price <= 0) {
				break;

			}
		}
		k.close();

	}
}
