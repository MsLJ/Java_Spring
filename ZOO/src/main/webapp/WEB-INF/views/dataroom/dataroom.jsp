<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>	
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${drf}" var="d" >
	<table class="snsViewArea">
	<tr><th align="left">작성자-제목-날짜</th>
	</tr>
	<tr>
	<td style="text-shadow: 0px 2px 2px#${d.zd_category};">${d.zd_uploader}-${d.zd_title }- <fmt:formatDate value="${d.zd_date }" dateStyle="short"/> -
	<a href="dataroom.download?zd_file=${d.zd_file }">${d.zd_file }</a>
	</td>
	<c:if test="${d.zd_uploader==sessionScope.loginMember.zm_id }">
	<td style="text-shadow: 0px 2px 2px#${d.zd_category};"  align="right" style="cursor: pointer" ondblclick="deletedata(${d.zd_no})">삭제</td>
	</c:if>
	</tr>
	</table>
	
	
	
	</c:forEach>
	<table id="snsControlArea2">



		<tr>
			<td>
		<c:if test="${sessionScope.loginMember!=null}">
			
				<form action="dataroom.upload" onsubmit="return dataroomUpdateck(this);" method="post"
				enctype="multipart/form-data">
					<table id="snsWriteArea">
						<tr>
							<td><input type="hidden" name="token" value="${token}"></td>
						</tr>
						<tr>
							<td><input name="zd_title" class="textType" placeholder="제목"
								maxlength="40"></td>
						</tr>
						<tr>
							<td><input type="radio" name="zd_category" value="6AD697">고양이&nbsp;&nbsp;
								<input type="radio" name="zd_category" value="D6C4C1">너구리&nbsp;&nbsp;
								<input type="radio" name="zd_category" value="D68844">강아지&nbsp;&nbsp;
								<input type="radio" name="zd_category" value="83BCEE">기타&nbsp;&nbsp;


							</td>
						</tr>
						<tr>

							<td><input name="zd_file" type="file"></td>
							<td><input type="image" src="resources/photo/confirm.png"
								style="width: 40px"></td>
						</tr>

					</table>
				</form>
				</c:if>
			</td>
			
		</tr>
	</table>






</body>
</html>