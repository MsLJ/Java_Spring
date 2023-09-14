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
	<c:forEach items="${smg }" var="s">
		<table class="snsViewArea">
			<tr>
				<td align="center" class="imgTd" rowspan="4"><img
					class="writerImg" src="resources/photo/${s.zm_photo }"></td>
				<td rowspan="3" style="background-color: #${s.zs_color};"
					class="writerTd">${s.zs_writer }</td>
				<td class="txtTd">${s.zs_txt }</td>
			</tr>
			<tr>
				<td class="replyTd">
				<c:forEach var="sr" items="${s.zs_re }">
				<c:choose>
				<c:when test="${sr.zsr_writer==sessionScope.loginMember.zm_id }">
				<div ondblclick="deletesnsRe(${sr.zsr_no},${page });" style="cursor: pointer">
				<span
					style="text-shadow: 0px 2px 2px#${s.zs_color};">${sr.zsr_writer }-${sr.zsr_txt } </span>
				<span class="date"><fmt:formatDate value="${sr.zsr_date }" type="date" dateStyle="short"/> </span><br>
				</div>
				
				</c:when>
				<c:otherwise>
				<div>
				
				<span
					style="text-shadow: 0px 2px 2px#${s.zs_color};">${sr.zsr_writer }-${sr.zsr_txt } </span>
				<span class="date"><fmt:formatDate value="${sr.zsr_date }" type="date" dateStyle="short"/> </span><br>
				
				</div>
				</c:otherwise>
				
				
				
				</c:choose>
				</c:forEach>
			<c:if test="${sessionScope.loginMember!=null}">
			<form action="sns.re.write" onsubmit="return snsReplyWriteCheck(this);">
				<span class="writer" style="text-shadow: 0px 2px 2px#${s.zs_color};">	</span>
					<input name="zsr_zs_no" value="${s.zs_no }" type="hidden">
					<input name="token" value="${token }" type="hidden">
					<input name="page" value="${page }" type="hidden">
					<input name="zsr_txt" maxlength="150" placeholder="내용을 입력해주세요">
				<button>글쓰기</button>
			</form>
			
			
			</c:if>
			
					</td>

			</tr>
			<tr>
				<td align="right" class="dateTd"><fmt:formatDate
						value="${s.zs_date }" type="both" dateStyle="long" /></td>
			</tr>
			<c:if test="${s.zs_writer==sessionScope.loginMember.zm_id }">

				<tr>
					<td colspan="2" class="updateTd" align="right"
						onclick="updateMSG(${s.zs_no},'${s.zs_txt }',${page });">수정</td>
					<td class="deleteTd" align="right" onclick="deleteMSG(${s.zs_no});">삭제</td>
				</tr>
			</c:if>




		</table>


	</c:forEach>
	
<c:choose>

	<c:when test="${sessionScope.loginMember!=null}">
	
	<table id="snsControlArea1">

					<tr><td><img src="resources/photo/search2.gif" id="snsControlAreaHandle"></td></tr>
		<tr>
			<td align="left">
				<form action="sns.search">
					<table id="searchTb">
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td id="snsSearchArea"><input name="search">
								<button>
									<img src="resources/photo/search.png">
								</button></td>
						</tr>
					</table>

				</form>
			</td>
		</tr>


		<tr>
			<td>
					<form action="sns.write" onsubmit="return snsWriteCheck(this);">
						<table id="snsWriteArea">
							<tr>
								<td><input type="hidden" name="token" value="${token}"></td>
							</tr>
							<tr>
								<td>#<input name="zs_color" maxlength="6" class="textType"
									placeholder="FFFFFF">
								</td>
								<td><input type="image" src="resources/photo/confirm.png"
									style="width: 40px"></td>
							</tr>
							
							
							

							<tr>
								<td><textarea name="zs_txt" placeholder="내용"></textarea></td>
							</tr>
						</table>
					</form>
	</table>
	</c:when>
	<c:otherwise>
	<table id="snsControlArea3">

					<tr><td><img src="resources/photo/search2.gif" id="snsControlAreaHandle"></td></tr>
		<tr>
			<td align="left">
				<form action="sns.search">
					<table id="searchTb">
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td id="snsSearchArea"><input name="search">
								<button>
									<img src="resources/photo/search.png">
								</button></td>
						</tr>
					</table>

				</form>
			</td>
		</tr>
		</table>
		
	
	
	
	
	</c:otherwise>
	</c:choose>

				
	<c:if test="${page !=1}">
		<div id="snsL" onclick="snsPageChange(${page-1});">&lt;</div>
	</c:if>
	<c:if test="${page!= pageCount }">
		<div id="snsR" onclick="snsPageChange(${page+1});">&gt;</div>
	</c:if>

	<table id="blackArea">
	<tr> <td align="center">
	<form action="sns.update" onsubmit="return snsupdateCk(this);">
	<input name="zs_no" id="snsUpdatezs_no" type="hidden">
	<input name="page"  id="snsUpdatePage" type="hidden">
	<table>
	<tr><td id="x" align="right" colspan="2">X</td></tr>
	<tr><td> <textarea name="zs_txt" id="snsUpdatezs_Txt"></textarea>
	</td> </tr>
	<tr><td align="right"><button>수정</button></td> </tr>
	</table>
	
	</form>
	
	
	</td></tr>
	
	</table>





</body>
</html>