<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginController" name="loginF" method="post" onsubmit="return loginCheck();">
		<table id="logintb">
			<tr>
				<th>Login</th>
			</tr>
			<tr>
				<td><input name="id" placeholder="ID" maxlength="12"></td>
			</tr>

			<tr>
				<td><input name="pw" type="password"  placeholder="PW" maxlength="12"></td>
			</tr>

			<tr>
				<td align="center"><button>로그인</button>
					<a href="JoinController">회원가입</a></td>
			</tr>
		</table>
	</form>

</body>
</html>