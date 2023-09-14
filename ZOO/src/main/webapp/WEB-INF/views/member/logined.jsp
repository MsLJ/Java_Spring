<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="loginedTb">
		<tr align="left">
			<td>${sessionScope.loginMember.zm_name }님안녕</td>
		</tr>
		<tr align="left">
			<td><fmt:formatDate
					value="${sessionScope.loginMember.zm_birthday}" pattern="yyyy" />년생</td>
		</tr>
		<tr align="center">
			<td><img
				src="resources/photo/${sessionScope.loginMember.zm_photo}"></td>
		</tr>
		<tr align="center">
			<td><a href="member.info.go"><img
					src="resources/photo/detail.png"></a> <a href="member.logout"><img
					src="resources/photo/logout.png"></a></td>
		</tr>


	</table>

</body>
</html>