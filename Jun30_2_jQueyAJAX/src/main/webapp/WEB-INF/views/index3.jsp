<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="resources/jQuery.js"></script>
<script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("button")
				.click(
						function() {
							$.ajax({
									url : "http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/json/RealtimeCityAir/1/25/",
									success : function(misaemungi) {
										var pm10Ar=[];
										var pm25Ar=[];
											$.each(misaemungi.RealtimeCityAir.row,function(i, a) {
												pm10Ar[i]={y :a.PM10 ,label : a.MSRSTE_NM};
												pm25Ar[i]={y :a.PM25 ,label : a.MSRSTE_NM};
												//a.PM10
												//a.PM25
												
												
												
												var td1 = $("<td></td>").text(a.MSRDT);
																var td2 = $("<td></td>").text(a.MSRSTE_NM);
																var td3 = $("<td></td>").text(a.IDEX_NM);
																var td4 = $("<td></td>").text(a.IDEX_MVL);
																var tr = $("<tr></tr>").append(td1,td2,td3,td4);
																$("table")
																		.append(
																				tr);
															});
											//var ms = misaemungi.RealtimeCityAir.row[2].MSRDT;
											//var msn = misaemungi.RealtimeCityAir.row[2].MSRSTE_NM;
											//var idex = misaemungi.RealtimeCityAir.row[2].IDEX_NM;

											//$("#ms").text("날짜:" + ms);
											//$("#msn").text("지역:" + msn);
											//$("#idex").text("정도:" + idex);

		var chart = new CanvasJS.Chart("chartContainer", {
			title : {
				text : "서울시 미세먼지"

			},
			data : [ {
				type : "stackedColumn",
				dataPoints :pm10Ar
				},  {
					type : "stackedColumn",
					dataPoints :pm25Ar
					
				}
				
			
				

				]
			} 
		});
		chart.render();
										}

									});

						});

	});
</script>

</script>
<title>Insert title here</title>
</head>
<body>
	<div id="chartContainer" style="height: 300px; width: 100%;"></div>
	<button>받아오기</button>

	<table border="1">

	</table>

</body>
</html>