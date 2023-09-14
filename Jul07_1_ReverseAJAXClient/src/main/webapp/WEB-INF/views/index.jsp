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
	
	
<script type="text/javascript" src="http://195.168.9.63:9999/socket.io/socket.io.js"></script>	

<script type="text/javascript">
function getProduct() {
    var u = "http://localhost:8888/product.get";
    $.getJSON(u, function(a) {
        $("table").empty();
        $.each(a, function(i, p) {
            var name = p.p_name;
            var price = p.p_price;
            var td = $("<td></td>").text("name:" + name);
            var td2 = $("<td></td>").text("price:" + price);
            var tr = $("<tr></tr>").append(td, td2);
            $("table").append(tr);
        });
    });
}

$(function() {
    var socket = io.connect("http://195.168.9.63:9999");
    getProduct();

    $("button").click(function() {
        var n = $("#name").val();
        var p = $("#price").val();
        var u = "http://localhost:8888/product.reg?n=" + n + "&p=" + p;
        $.getJSON(u, function(a) {
            alert("등록 성공");
        });
        $("#name").val("");
        $("#price").val("");
    });

    socket.on("ss", function(a) {
        $("table").empty();
        $.each(a, function(i, p) {
            var name = p.p_name;
            var price = p.p_price;
            var td = $("<td></td>").text("name:" + name);
            var td2 = $("<td></td>").text("price:" + price);
            var tr = $("<tr></tr>").append(td, td2);
            $("table").append(tr);
        });
    });
});
</script>




<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div data-role="page" id="productPage">
		<div data-role="header" data-theme="d" data-position="fixed">
			<h1>Product</h1>
		</div>
		<div data-role="content">
			<input placeholder="이름" id="name"> <input placeholder="가격"
				id="price">
			<button>올리기</button>
			<table border="1">
			
			</table>




		</div>


	</div>

</body>
</html>