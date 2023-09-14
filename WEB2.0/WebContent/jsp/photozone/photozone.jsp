<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.loginMember!=null }">

		<form action="PhotoZoneController" onsubmit="return photoCheck();"
			name="photoF" enctype="multipart/form-data" method="post">
			<table id="photoWriteTb">

				<tr>
					<td><input type="file" name="photo"></td>
				</tr>
				<tr>
					<td><input name="token" type="hidden" value="${token }"></td>
				</tr>
				<tr>
					<td>
						<button>올리기</button>
					</td>
				</tr>


			</table>
		</form>
	</c:if>
	<c:forEach var="pt" items="${ptz }">
		<c:choose>
			<c:when test="">

			</c:when>
		</c:choose>
		<table id="photozoneTb">
			<tr>
				<td>${pt.id}</td>
			</tr>
			<tr>
				<td><img src="photozone/${pt.photo}"></td>
				<td><a><img src="img/like.png"> </a></td>
				<td><a><img src="img/unlike.jpg"> </a></td>
			</tr>
			<tr>
				<td><fmt:formatDate value="${pt.date}" type="both" /></td>
			</tr>
			<tr><td colspan="3" align="right"><button onclick="deletePhoto(${pt.no})">삭제</button> </td></tr>
		</table>
	</c:forEach>
	<c:if test="${page !=1}">
	<a href="PhotoZonePageController?page=${page-1 }" class="photoL">&lt;</a>
	</c:if>
	<c:if test="${page !=pageCount}">
	<a href="PhotoZonePageController?page=${page+1 }" class="photoR">&gt;</a>
	</c:if>





</body>
</html>