<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/member.css">
<link rel="stylesheet" href="css/sns.css">
<link rel="stylesheet" href="css/photo.css">
<script src="js/web2joinck.js" type="text/javascript"></script>
<script src="js/web2joinckh.js" type="text/javascript"></script>
<script src="js/web2Move.js" type="text/javascript"></script>




<title>WEB2.0</title>
</head>
<body>
<table id="siteTitleArea">
		<tr>
			<th class="th" align="center" colspan="3"><a
				href="HomeController">WEB_2.0</a></th>
		</tr>
	</table>
	<table id="siteMenuArea">
		<tr>
			<td><a href="SnsController">WEB2.0 Site</a></td>
			<td><a href="PhotoZoneController">PhotoZone</a></td>
			<td><a>??</a></td>
		</tr>
	</table>
	<table id="siteLoginArea">
		<tr>
			<td align="center"><jsp:include page="${loginpage }"></jsp:include>

			</td>
		</tr>

	</table>

	<table id="siteContentArea">
		<tr>
			<td align="center"></td>
			<td><jsp:include page="${cp }"></jsp:include></td>
		</tr>
	</table>
<div id="resultDiv">${result }</div>






</body>
</html>