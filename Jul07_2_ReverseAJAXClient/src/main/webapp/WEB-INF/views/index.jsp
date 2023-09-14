<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" />
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script
	src="https://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>

<script type="text/javascript"
	src="http://195.168.9.63:7777/socket.io/socket.io.js"></script>

<script type="text/javascript">
	function show() {
		var u = "http://localhost/jul072reverseajax/coffee.get";
		$.getJSON(u, function(data) {
			$("table").empty();
			$.each(data.coffees, function(i, c) {
				//coffees라는 배열이기에 coffees에서 each문을돌리면
				//자동으로 그 배열에 i값을 넣어서 돌아가기에
				//data.coffees로 $each문하면됌.
				//따로 또 coffees[i]로 하지않고
				var cntd = $("<td></td>").text(c.c_name);
				var cptd = $("<td></td>").text(c.c_price);
				var tr = $("<tr></tr>").append(cntd, cptd);
				$("table").append(tr);
			});
		});

	}
	$(function() {
		var socket = io.connect("http://195.168.9.63:7777");
		show();
		$("button").click(function() {
			var n = $("#name").val();
			var p = $("#price").val();
			var u = "coffee.reg?c_name=" + n + "&c_price=" + p;
			$.getJSON(u, function(data) {
				socket.emit("clientMsg","등록");		
				//신호보내기 emit(제목,내용);
				//app.js측에서는 socket.on으로 신호 받고 제목,function(객체){
					//console.log(객체); 하면 내용이 출력
					//저쪽에서도 메세지를 받았으니 io.sockets.emit으로 ServerMsg,msg로 보내면
				//});
			});
			$("#name").val("");
			$("#price").val("");

		});
	socket.on("severMsg",function(){
		show();
		//여기서 신호를 받고 누군가 등록해서 이 메세지가 오게된것 그래서 여기서 show();를쓰면
		//실시간 완성
	});
	
	

	});
</script>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div data-role="page" id="productPage">
		<div data-role="header" data-theme="b" data-position="fixed">
			<h1>Coffee Shop</h1>
		</div>
		<div data-role="content">

			<input placeholder="이름" id="name"> <input placeholder="가격"
				id="price">
			<button>등록</button>

			<table border="1"></table>



		</div>


	</div>

</body>
</html>