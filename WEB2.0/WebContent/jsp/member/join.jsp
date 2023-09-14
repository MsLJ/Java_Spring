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
	<form action="JoinController" name="joinF"
		onsubmit="return joinCheck();" method="post"
		enctype="multipart/form-data">
		<table id="joinTb">
			<tr align="center">
				<td><input name="id" placeholder="ID" maxlength="12"></td>
			</tr>
			<tr align="center">
				<td><input type="password" name="pw" placeholder="PW" maxlength="12"></td>
			</tr>
			<tr align="center">
				<td><input name="pwck" placeholder="PW재확인"></td>
			</tr>
			<tr align="center">
				<td><input name="name" placeholder="이름"></td>
			</tr>
			<tr align="center">
				<td><input name="age" placeholder="나이"></td>
			</tr>
			<tr align="center">
				<td><input name="addr1" placeholder="우편번호" maxlength="5">
					<input name="addr2" placeholder="주소"> <input name="addr3"
					placeholder="상세주소"></td>
			</tr>
			<tr align="center">
				<td><select name="y">
						<c:forEach var="y" begin="${cy - 131 }" end="${cy }">
							<option>${y }</option>
						</c:forEach>
				</select>년 <select name="m">
						<c:forEach var="m" begin="1" end="12">
							<option>${m }</option>

						</c:forEach>
				</select>월 <select name="d">
						<c:forEach var="d" begin="1" end="31">
							<option>${d }</option>
						</c:forEach>

				</select>일</td>
			</tr>
			<tr align="center">
				<td>사진:<input type="file" name="img"></td>
			</tr>
			<tr align="center">
				<td><button>회원가입</button></td>
			</tr>
		</table>

	</form>



</body>
</html>