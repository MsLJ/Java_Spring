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
		<table id="joinTb">
	<form action="MemberInfoController" name="memberupdateF"
		onsubmit="return updateMCheck();" method="post"
		enctype="multipart/form-data">
			<tr align="center">
				<td><input value="${sessionScope.loginMember.webm_id}" readonly="readonly" name="id"maxlength="12">
					</td>
			</tr>
			<tr align="center">
				<td><input type="password" name="pw"
					value="${sessionScope.loginMember.webm_pw}" maxlength="12">
					</td>
			</tr>
			<tr align="center">
				<td><input name="pwck"
					value="${sessionScope.loginMember.webm_pw}" >
					</td>
			</tr>
			<tr align="center">
				<td><input name="name"
					value="${sessionScope.loginMember.webm_name}" >
					</td>
			</tr>
			<tr align="center">
				<td><input name="age" readonly="readonly" value="${sessionScope.loginMember.webm_age }"></td>
			</tr>
			<tr align="center">
				<td><span id="memberInfoBD"><fmt:formatDate value="${sessionScope.longinMember.webm_birthday }" type="date" dateStyle="long"/></span>
					</td>
			</tr>
			<tr align="center">
				<td><input name="addr1"
					value="${addr1 }" maxlength="5">
					<input name="addr2" value="${addr2 }"> 
					<input name="addr3"
					value="${addr3 }"></td>
			</tr>
			<tr align="center">
				<td>
				<input readonly="readonly" value="${sessionScope.loginMember.webm_birthday }">
				</td>
				</tr>
				<tr align="center">
				<td>사진:
				<img src="joindata/${sessionScope.loginMember.webm_photo }">
				<input type="file" name="img" ></td>
			</tr>
			<tr align="center">
				<td>
					<button>수정</button>
					</form>
					
					<button onclick="return bye();">탈퇴</button>
				</td>
			</tr>
		</table>
</body>
</html>