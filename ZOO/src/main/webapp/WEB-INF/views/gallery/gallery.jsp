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
	<div id="galleyArea">
		<c:forEach items="${ggr}" var="g">
			<table class="grImg">

				<tr>
					<td align="center"><img src="resources/gallery/${g.zg_photo }">
						<fmt:formatDate value="${g.zg_date }" dateStyle="short" /></td>
				</tr>
				<tr>
					<td>${g.zg_title }</td>
				</tr>
			</table>



		</c:forEach>

	</div>

	<c:if test="${sessionScope.loginMember!=null}">


		<table id="snsControlArea2">



			<tr>
				<td>
					<form action="gallery.upload"
						onsubmit="return galleryUploadCk(this);" method="post"
						enctype="multipart/form-data">
						<table id="snsWriteArea">
							<tr>
								<td><input type="hidden" name="token" value="${token}"></td>
							</tr>
							<tr>
								<td><input name="zg_title" class="textType"
									placeholder="제목" maxlength="40"></td>
							</tr>

							<tr>

								<td><input name="zg_photo" type="file"></td>
								<td><input type="image" src="resources/photo/confirm.png"
									style="width: 40px"></td>
							</tr>

						</table>
					</form>
				</td>
			</tr>
		</table>
	</c:if>



</body>
</html>