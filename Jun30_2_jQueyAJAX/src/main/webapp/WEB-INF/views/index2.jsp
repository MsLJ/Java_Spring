<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		$("#b2")
				.click(
						function() {
							$
									.ajax({
										url : "https://api.openweathermap.org/data/2.5/weather",
										data : {
											units : "meric",
											q : "seoul",
											lang : "kr",
											appid : "baff8f3c6cbc28a4024e336599de28c4"
										},
										//data의 순서는 상관이 없다 그러므로 내용만 정확하면 다 나옴

										success : function(weatherData) {
											//weatherData.main.temp
											//weatherData.weather[0].icon
											//weatherData.weather[0].description
											//weatherData.weather[0].main.humdity
											var src = "https://openweathermap.org/img/wn/"
													+ weatherData.weather[0].icon
													+ "@2x.png";
											var imgg = $("img")
													.attr("src", src);
											var td = $("#descTd")
													.text(
															weatherData.weather[0].description);
											var t = weatherData.main.temp + "("
													+ weatherData.main.humidity
													+ "%)";
											$("#tempTd").text(t);

										}
									});
						});
	});
</script>

</script>
<title>Insert title here</title>
</head>
<body>
	<button id="b1">버튼</button>
	<hr>
	<button id="b2">openweathermap 날씨받기</button>
	<table border="1">
		<tr>
			<td><img></td>
		</tr>
		<tr>
			<td id="descTd"></td>
		</tr>
		<tr>
			<td id="tempTd"></td>
		</tr>


	</table>

</body>
</html>