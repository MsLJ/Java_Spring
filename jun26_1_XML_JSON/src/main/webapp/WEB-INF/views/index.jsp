<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	$(function() {
		$("button").click(function() {
			$.ajax({
				url : "biskit.get",
				success : function(zxc) {
					$(zxc).find("biskit").each(function(i, b) {
						alert($(b).find("b_name").text());//biskit의 갯수 each가 for each
						alert($(b).find("b_price").text());//biskit의 갯수 each가 for each
						//XML
						//i++출력
					});
				}
			});
			//위에가 먼저 나올것이라고 생각하지만 비동기식이기에 alert z가먼저 
			//alert("z");
		});
		$("input").click(function() {
			$.ajax({
				url : "menu.get",
				data : {
					page : 1
				},

				success : function(asd) {
					$.each(asd.menu, function(i, m) {
						alert(m.m_name);
						alert(m.m_price);
					//JSON
					});

				}

			});
		});
	});
</script>
</head>
<body>
	<input>
	<button>버튼</button>



</body>
</html>