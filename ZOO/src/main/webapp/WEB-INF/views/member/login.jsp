<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="member.login" onsubmit="return loginCheck(this);" method="post">
		<table id="loginTbl">
			<tr>
				<td><input name="zm_id" placeholder="id" maxlength="10"></td>


				<td><input name="zm_pw" placeholder="pw" maxlength="10"></td>


			</tr>
			<tr align="right">
				<td align="right" colspan="2"><button>로그인</button><a href="member.join.go">회원가입</a></td>
</tr>

		</table>


	</form>
</body>
</html>