package com.ms.jun13maintence.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class MartMain2 {
	// 마트 정책이 포인트를 0.5%적립하는걸로 바뀜
	// ->프로그램 수정해야
	// ->마트 사장님 point.txt수정하면 됨
	// ->마트측에서 해결 가능

	// 뭔가가 .java에->컴파일 당해서 ->수정이 불가능
	// 앞으로 말하는 유지보수에 용이:
	// 수정이 일어날만한거는 .java에 하지말고 외부파일에 저장하자
	// eGovFramework
	//  MyBatis:Java+DB유지보수에 용이
	//	Maven:.Jar관리 유지보수에 용이
	//	Spring:Java객체 유지보수에 용이
	
	//java - Spring
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		BufferedReader br = null;
		int price = 0;
		double point = 0;
		double sumpoint = 0;
		try {
			FileInputStream fis = new FileInputStream("C:\\lee\\work space\\point.txt");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			String p = br.readLine();
			double pp = Double.parseDouble(p);
			System.out.println(pp);
			while (true) {
				System.out.println("구매금액:");
				price = k.nextInt();
				point = (price * pp);
				System.out.printf("물건 사서 생긴 포인트:%.01f\n", point);
				sumpoint += point;
				System.out.printf("총 포인트:%.0f\n", sumpoint);
				if (price <= 0) {
					break;

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		k.close();

	}
}
