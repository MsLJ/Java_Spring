package com.ms.jun134mv.main;

import org.json.simple.parser.JSONParser;
import org.xmlpull.v1.XmlPullParser;

import ms.ljh.db.manager.MsDBManager;
import oracle.jdbc.driver.OracleDriver;

//이번에도 xml,json 파싱
//Mavenrepository.com에서 Maven소스 복사
//프로젝트 pom.xml에 붙이고 저장

//메이븐 중앙 저장소에서 .jar파일 다운받아서
// 컴의 메이븐 로컬 저장소에 저장 (c:\사용자\계정\.m2\repository)에 저장
// 프로젝트에 쓸 수있게 세팅까지 

//Maven과 수동으로.jar를 동시에 불가능하기에
//Maven저장소에서 가져오는것이기에 만약 저장소에 필요한것이 없다면
//사설 저장소에서도 구해오기위해 <dependencies>위쪽에 사설 저장소를 추가
//그후에  <dependencies>에 추가
//만약에 자신이 직접 만든 .jar파일을 사용하고싶다면 import->maver->install or deploy~~..
//거기에 그륩 아이디 + artifact아이디 + version 적고 만들고 
//pom.xml에 돌아가서 <dependency>해서 그륩 아이디 + artifact아이디 + version 적기

//c:\사용자\계정\.m2\repository

public class MMain {
	public static void main(String[] args) {
		MsDBManager ms;
		OracleDriver od;
		XmlPullParser xpp;
		JSONParser jp;

	}
}
