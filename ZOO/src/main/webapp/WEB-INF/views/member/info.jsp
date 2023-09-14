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
	<table id="joinTbl">
		<form action="member.info.update"
			onsubmit="return memberUpdateck(this);" method="post"
			enctype="multipart/form-data">
			<tr align="center">
				<td><input name="zm_id" readonly="readonly"
					value="${sessionScope.loginMember.zm_id }" placeholder="ID"
					maxlength="10"></td>
			</tr>
			<tr align="center">
				<td><input type="password"
					value="${sessionScope.loginMember.zm_pw }" name="zm_pw"
					placeholder="PW" maxlength="12"></td>
			</tr>
			<tr align="center">
				<td><input name="pwck"
					value="${sessionScope.loginMember.zm_pw }" placeholder="PW재확인"></td>
			</tr>
			<tr align="center">
				<td><input name="zm_name"
					value="${sessionScope.loginMember.zm_name }" placeholder="이름"></td>
			</tr>
			<tr>
				<td><fmt:formatDate
						value="${sessionScope.loginMember.zm_birthday }"
						pattern="yyyy-MM-dd(E)" /></td>
			</tr>
			<tr align="center">
				<td><input readonly="readonly" id="addr1" name="addr1" value="${addr1 }" autocomplete="off"
					placeholder="우편번호" maxlength="5"> <input readonly="readonly" id="addr2" name="addr2"
					autocomplete="off" value="${addr2 }" placeholder="주소"> <input
					name="addr3" autocomplete="off" value="${addr3 }"
					placeholder="상세주소"></td>
			</tr>

			<tr>
				<td><img
					src="resources/photo/${sessionScope.loginMember.zm_photo }"></td>
			</tr>


			<tr align="center">

				<td>사진:<input type="file" name="zm_photo"></td>


			</tr>
			<tr>
				<td><button>정보수정</button>
		</form>
		<button onclick="return bye();">탈퇴</button>
		</td>
		</tr>



	</table>
</body>
</html>