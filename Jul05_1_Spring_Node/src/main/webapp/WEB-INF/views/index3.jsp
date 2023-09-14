<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" />
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="https://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<script type="text/javascript">
$(function() {
	alert("a");
	//var u="http://localhost:9999/memo.reg";
	
	
});

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div data-role="page" id="p1">
	<div data-role="header" data-theme="b" data-position="fixed">
	<a href="#p2" data-transition="flip" data-icon="arrow-r">2page</a>
	<!-- 빈공간 터치하면 header footer둘다 들어가는 기능까지 -->
	<!-- 화면 전환효과 data-transition= fade flip flow turn slideup slidedown -->
		<h1>1페이지</h1>
	</div>
	<div data-role="content">
	<input>
	<button>da</button>
	<select data-theme="e">
	<option>banana</option>
	<option>mango</option>
	<option>yello</option>
	</select>
	
	</div>
	
	<div data-role="footer" data-position="fixed"> 
	<h1>bottom</h1>
	</div>
</div>
<!-- --------------------------------------------------------------------------- -->
<div data-role="page" id="p2">
	<div data-role="header" data-theme="d" data-position="fixed">
	<a href="#p1" data-transition="flow"data-icon="arrow-l">1page</a>
		<h1>2페이지</h1>
	</div>
	<div data-role="content">
	
	<ul data-role="listview" data-filter="true" data-inset="true">
	<!--  data-inset="true" 다른 객체랑도 어울리게 -->
	<!-- data-filter="true" 실시간 검색기능-->
	<!-- li안에 a태그 넣으면 그거 누르면 이동 -->
	<li data-role="list-divider">과일</li>
	<li><a href="#p3">사과</a></li>
	<li>바나나</li>
	<li>수박</li>
	<li data-role="list-divider">zhongwen</li>
	<li>xiangjiao</li>
	<li>xigua</li>
	</ul>
	
	
	
	
	
	<input>
	<button>da</button>
	<select data-theme="e">
	<option>banana</option>
	<option>mango</option>
	<option>yello</option>
	</select>
	
	</div>
	
	<div data-role="footer" data-theme="d" data-position="fixed"> 
	<h1>bottom</h1>
	</div>
</div>
<!-- ------------------------------------------------------------------------------ -->
<div data-role="page" id="p3">
	<div data-role="header" data-theme="b" data-position="fixed">
	<a href="#p1" data-transition="flip" data-icon="arrow-r">1page</a>
		<h1>1페이지</h1>
	</div>
	<div data-role="content">
	사과
	
	</div>
	
	<div data-role="footer" data-position="fixed"> 
	<h1>bottom</h1>
	</div>
</div>
</body>
</html>