<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="jquery.bxslider/jquery.bxslider.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script>
	$(document).ready(function() {
		$(".slider").bxSlider();
	});
</script>
<script type="text/javascript">
	$(function() {

		var s = $('.bxslider').bxSlider({
			mode : 'vertical',
			captions : true,
			slideWidth : 120,
			auto : true,
			pause : 3000

		});
		$("button")
				.click(
						function() {

							//$.ajax({
							//url:"프로토콜://..../주소",
							//data:{명:"값",param명":값,...},
							//beforeSend:function(요청객체){
							//요청객체.setRequestHeader("이름","값");	
							//	},
							//success:function(받은거){
							var search = $("input").val();
							//alert(search);
							$
									.ajax({
										url : "https://dapi.kakao.com/v3/search/book",
										data : {
											query : search

										},
										beforeSend : function(req) {
											req
													.setRequestHeader(
															"Authorization",
															"KakaoAK b8fa6b88c1acddea8f6e06afb295981b");
										},

										success : function(kakao) {
											$("table").empty();

											$
													.each(
															kakao.documents,
															function(i, k) {

																var img = $(
																		"<img>")
																		.attr(
																				"src",
																				k.thumbnail);
																var imgTd = $(
																		"<td></td>")
																		.append(
																				img);
																var td = $(
																		"<td></td>")
																		.text(
																				k.title);
																var td1 = $(
																		"<td></td>")
																		.text(
																				k.authors);
																var td2 = $(
																		"<td></td>")
																		.text(
																				k.contents);
																var td3 = $(
																		"<td></td>")
																		.text(
																				k.datetime);
																var td4 = $(
																		"<td></td>")
																		.text(
																				k.sale_price);
																var td5 = $(
																		"<td></td>")
																		.text(
																				k.status);
																var tr = $(
																		"<tr></tr>")
																		.append(
																				imgTd,
																				td,
																				td1,
																				td2,
																				td3,
																				td4,
																				td5);
																$("table")
																		.append(
																				tr);
																var img2 = $(
																		"<img>")
																		.attr(
																				"src",
																				k.thumbnail)
																		.attr(
																				"title",
																				k.title);
																var div = $(
																		"<div></div>")
																		.append(
																				img2);
																$(".slider")
																		.append(
																				div);

															});
											s.reloadSlider();

										}

									});

						});
		$("input").keyup(function(e) {
			//if (e.keycode == 13) {
			$("button").trigger("click");
			//}

		});

	});
</script>
<style type="text/css">
div {
	width: 120px;
	height: 174px;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<input>
	<button>검색</button>
	<hr>
	<div id="slider" class="slider">
		<div>h</div>
		<div>h</div>
	</div>
	<table border="1">
	</table>

</body>
</html>