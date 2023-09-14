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


	<table id="${ucr.what }">
		<tr>
			<th>변환결과</th>
		</tr>
		<tr>
			<td align="center"><fmt:formatNumber value="${ucr.from }"
					pattern="#.0"></fmt:formatNumber> ${ucr.fromUnit }</td>
		</tr>
		<tr>
			<td align="center">↓</td>
		</tr>
		<tr>
			<td align="center"><fmt:formatNumber value="${ucr.to }"
					pattern="#.0">

				</fmt:formatNumber> ${ucr.toUnit }</td>
		</tr>
	</table>
</body>
</html>