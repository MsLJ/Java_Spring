<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>





	<form action="member.join" onsubmit="return memberjoinck(this);"
		method="post" enctype="multipart/form-data">
		<table id="joinTbl">
			<tr align="center">
				<td><input id="memberJoinID" name="zm_id" placeholder="ID" maxlength="10"></td>
			</tr>
			<tr align="center">
				<td><input type="password" name="zm_pw" placeholder="PW"
					maxlength="12"></td>
			</tr>
			<tr align="center">
				<td><input name="pwck" placeholder="PW재확인"></td>
			</tr>
			<tr align="center">
				<td><input name="zm_name" placeholder="이름"></td>
				
			</tr>
			<tr align="center">
				<td><input name="birthday" placeholder="주민번호 앞자리" maxlength="6">-<input
					name="birthday2" type="password" maxlength="1"
					placeholder="X-XXXXXX"></td>
			</tr>
			<tr align="center">
				<td><input id="addr1" name="addr1" placeholder="우편번호" maxlength="5" readonly="readonly">
					<input id="addr2" name="addr2" placeholder="주소" readonly="readonly"> <input name="addr3"
					placeholder="상세주소"></td>
			</tr>
			<tr align="center">

				<td>사진:<input type="file" name="zm_photo"></td>


			</tr>
			<tr>
				<td><button>가입</button></td>
			</tr>



		</table>
	</form>











</body>
</html>