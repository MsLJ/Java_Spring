<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	//AJAX:(Asynchronous JavaScript And XML)
	//자바스크립트로비동기식 통신을해서 XML파싱
	//브라우저의 동일 출처 정책->외부 데이터 사용 불가	
	//
	//Cross-Domain AJAX
	//	외부 데이터 가져오는AJAX
	//	1)서버측에서  응답헤더를 설정해놨으면
	//		Access-Control-Allow-Orign
	//	2)안해놨으면?? 어떻게->Proxy서버	
	//		

	//$.ajax({
	//url:"프로토콜://..../주소",
	//data:{명:"값",param명":값,...},
	//success:function(받은거){
	//...

	//	}
	//});
	//$(function() {
	//$("#b1").click(function() {
	//	$.ajax({
	//	url : "https://www.kma.go.kr/wid/queryDFSRSS.jsp",
	//	data : {
	//		zone : 4136052000
	//	},
	//	success : function(zxc) {
	//	alert(zxc);
	//}
	//	});

	//});

	//	});

	$(function() {
		$("button")
				.click(
						function() {
							var ar = [];
							$
									.ajax({
										url : "weather.get",
										data : {
											zone : 4136052000
										},
										success : function(zxc) {

											$(zxc)
													.find("data")
													.each(
															function(i, w) {
																//pm10Ar[i]={y :a.PM10 ,label : a.MSRSTE_NM};
																//pm25Ar[i]={y :a.PM25 ,label : a.MSRSTE_NM};
																if ($(w).find(
																		"day")
																		.text() == "0") {
																ar[i] = {
																	x : $(w)
																			.find(
																					"hour")
																			.text() * 1,//str->int
																	y : $(w)
																			.find(
																					"temp")
																			.text() * 1
																};
																	var hour = $(
																			w)
																			.find(
																					"hour")
																			.text();
																	var wdKor = $(
																			w)
																			.find(
																					"wdKor")
																			.text();
																	var temp = $(
																			w)
																			.find(
																					"temp")
																			.text();
																	var wfKor = $(
																			w)
																			.find(
																					"wfKor")
																			.text();
																	var wdKortd = $(
																			"<td></td>")
																			.text(
																					wdKor);
																	var hourtd = $(
																			"<td></td>")
																			.text(
																					hour
																							+ "시");
																	var wfKortd = $(
																			"<td></td>")
																			.text(
																					"오늘의 날씨:"
																							+ wfKor);
																	var temptd = $(
																			"<td></td>")
																			.text(
																					temp
																							+ "도");
																	var tr = $(
																			"<tr></tr>")
																			.append(
																					hourtd,
																					wdKortd,
																					wfKortd,
																					temptd);

																	$("table")
																			.append(
																					tr);

																}
																//alert($(w).find("temp").text());
															});
										}
									});

							var chart = new CanvasJS.Chart("chartContainer", {

								title : {
									text : "오늘의 날씨"
								},
								data : [ {
									type : "line",
									dataPoints : ar

								} ]
							});

							chart.render();
						});

	});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>






	<button>버튼</button>
	<hr>
	<div id="chartContainer" style="height: 300px; width: 100%;"></div>
	<table border="1">


	</table>

</body>
</html>