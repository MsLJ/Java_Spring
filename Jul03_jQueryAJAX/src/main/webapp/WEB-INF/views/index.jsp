<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=447801452fa6725b3a8e2dbb90088e5e"></script>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
//JavaScript에서는 변수를 위에다 가져다가 쓸수있다.
//어차피 자주 쓸 변수 위에 정리하고 쓰자.
var map;
var marker;
var roadview;



		var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체
function move(lt,lg) {
	var ll=new kakao.maps.LatLng(lt,lg);
	map.panTo(ll);
	marker.setPosition(ll);
	roadviewClient.getNearestPanoId(ll, 100, function(panoId) {
	    roadview.setPanoId(panoId); //panoId와 중심좌표를 통해 로드뷰 실행
	});
	
	//지도
	//로드뷰
	//마커
}


	//Rest Api키:b8fa6b88c1acddea8f6e06afb295981b

	$(function() {
		//GPS있으면 GPS로
		//없으면 IP주소로 지역별 알수있다 정확도는 떨어지지만
		//위치 정보 받아오기
		
		navigator.geolocation.getCurrentPosition(function(l) {
			var lat = l.coords.latitude;//위도
			var lng = l.coords.longitude;//경도
			var curLoc=new kakao.maps.LatLng(lat, lng);
			$("h1").text(lat);
			$("h2").text(lng);
			//현재위치 카카오맵
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center : curLoc, //지도의 중심좌표.
		level : 3,
		mapTypeId:kakao.maps.MapTypeId.ROADMAP
	//지도의 레벨(확대, 축소 정도)
	}

	 map = new kakao.maps.Map(container, options); 
		var roadviewContainer = document.getElementById('roadview'); //로드뷰를 표시할 div
		  roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체

		var position = curLoc;

		// 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
		roadviewClient.getNearestPanoId(position, 50, function(panoId) {
		    roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
		});
	 marker = new kakao.maps.Marker({
	    map: map,
	    position: curLoc
	});	
	

	});
	$("#locSearch").keyup(function (e) {
		
			var locSearch=$(this).val();
			$.ajax({
				url:"https://dapi.kakao.com/v2/local/search/address"
				,data:{
					query : locSearch
				},
				beforeSend:function(req){
					req.setRequestHeader("Authorization",
							"KakaoAK b8fa6b88c1acddea8f6e06afb295981b");
				},success : function(k){
					//위에 move(lt,lg)라는 function을 따로 만들어서 그 곳에 검색한 좌표를 set해줌
					
					move(k.documents[0].y,k.documents[0].x);
				
				}
			});
			
		
		
	});
	$("#search").keyup(function(e) {
		
			
		var search=$(this).val();
		//카카오 측에서 만들어놓은 현재시점 
		//mapcenter의 x와y값 구하는 함수를 가져다가 쓰기만하면될것
		var lt=map.getCenter().getLat();
		var lg=map.getCenter().getLng();
				
		$.ajax({
			url:"https://dapi.kakao.com/v2/local/search/keyword",
		data:{
			query:search,
			x:lg,
			y:lt,
			radius:5000
		},
		beforeSend:function(req){
			req.setRequestHeader("Authorization",
			"KakaoAK b8fa6b88c1acddea8f6e06afb295981b");
			
		},success : function(k){
				$("#tb1").empty();
			$.each(k.documents,function(i,kk){
			
				var place_name=$("<td></td>").text(kk.place_name);
				var road_address_name=$("<td></td>").text(kk.road_address_name);
				var phone=$("<td></td>").text(kk.phone);
				//내가 생각한것은 각 td에 attr속성 id값을 주고 그 i차례대로 줘서 하는걸 생각했지만
				//예전에도 jQuery로 이미 인터프린터 방식으로 넘어간것이기에 그렇게 만든 id값으로는 눌러도 이벤트처리작동이 제대로 돼지않음x
				//그러므로 jQuery형식으로는 무리가있어서 JavaScript형식을 활용해야했고 기존에 미리 만들어놓은 move라는함수를 활용해서
				//tr에 onclick attr을 주고 클릭하면 move함수로 맵이동
				var tr=$("<tr></tr>").attr("onclick","move("+kk.y+","+kk.x+");").append(place_name,road_address_name,phone);
				$("#tb1").append(tr);
			
			});
		}
		});
			
	});
	});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	지역명:
	<input id="locSearch">
	<br> 검색어:
	<input id="search">
	<hr>


	<table style="width: 50%;">
		<tr>
			<td style="width:50%;"><div id="map" style="width: 100%; height: 400px;"></div></td>
		</tr>
		<tr>
			<td style="width:50%;"><div id="roadview" style="width: 100%; height: 400px;"></div></td>
		</tr>

	</table>
	<table id="tb1" border="1"></table>


</body>
</html>