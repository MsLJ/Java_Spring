<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.loginMember!=null }">
		<form action="SnsWriteController" name="snsWriteForm"
			onsubmit="return snsWriteCheck();">
			<table id="snsWriteTb">
				<tr>
					<td align="center"><textarea name="txt" maxlength="200"
							placeholder="입력하세요 최대(200자)"></textarea></td>
				</tr>
				<tr>
					<td align="center"><input name="token" type="hidden"
						value="${token }">
						<button>쓰기</button></td>
				</tr>
			</table>
		</form>
	</c:if>
	<form action="SnsSearchController">
		<table id="snsSearchArea">
			<tr align="right">
				<td colspan="3" align="right"><input name="search" type="text"
					maxlength="30" placeholder="제목을 입력해주세요">
					<button>검색</button></td>
			</tr>
		</table>
	</form>
	<c:forEach var="sm" items="${smg }">
		<table class="smgTb">
			<tr>
				<td class="td2" align="left">${sm.sns_writer }</td>
			</tr>
			<tr>
				<td class="td1" align="left" rowspan="3"><img
					src="joindata/${sm.webm_photo }"></td>
			</tr>
			<tr>
				<td class="td4">${sm.sns_txt }<c:if
						test="${sessionScope.loginMember !=null }">
						<form action="SnsReplyController"
							onsubmit="return snsREChek(this);">
							<input name="token" value="${token }" type="hidden"> <input
								name="re_no" value="${sm.sns_no }" type="hidden"> <span
								class="snsReplyWriter">"${sessionScope.loginMember.webm_id }"</span>
							<input name="txt">
							<button>쓰기</button>
						</form>
					</c:if>

				</td>
			</tr>


			<tr>
				<td class="td3"><fmt:formatDate value="${sm.sns_date }"
						type="both" /></td>
			</tr>


			<tr>
				<td align="right" colspan="2" class="td5">
					<button class="update"
						onclick="updateSNSMsg(${sm.sns_no},'${sm.sns_txt}');">수정</button>
					<button class="delete" onclick="deleteSNS${sm.sns_no};">삭제</button>
				</td>
			</tr>


		</table>

	</c:forEach>



	<c:if test="${page !=1}">
		<a href="SnsPageController?page=${page-1 }" class="snsL">&lt;</a>
	</c:if>
	<c:if test="${page!= pageCount }">
		<a href="SnsPageController?page=${page+1}" class="snsR">&gt;</a>
	</c:if>



</body>
</html>