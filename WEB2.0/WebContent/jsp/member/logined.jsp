<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="loginedTb">
		<tr>
			<td>${sessionScope.loginMember.webm_name }님안녕</td>
		</tr>
		<tr>
			<td>${sessionScope.loginMember.webm_age}살</td>
		</tr>
		<tr>
		<td><fmt:formatDate value="${sessionScope.loginMember.webm_birthday}" type="both"/></td>
		</tr>
		<tr>
			<td><img src="joindata/${sessionScope.loginMember.webm_photo}"></td>
		</tr>

		<tr>
			<td colspan="2" align="center"><a href="MemberInfoController"><img src="img/favorite_FILL0_wght400_GRAD0_opsz48.png"></a>
				<a href="LoginController"><img src="img/logout_FILL0_wght400_GRAD0_opsz48.png"></a></td>
		</tr>
	</table>
</body>
</html>