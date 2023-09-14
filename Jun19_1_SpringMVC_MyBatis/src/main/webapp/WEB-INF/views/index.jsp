<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="menu.reg">
		메뉴명:<input name="m_name">
		<p>
			가격:<input name="m_price">
		<p>
			<button>등록</button>
	</form>

	<br>

	<c:forEach var="mm" items="${m}">

메뉴명:${mm.m_name }<br>
가격:${mm.m_price }<br>

</c:forEach>


</body>
</html>