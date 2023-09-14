<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css" />
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script
	src="https://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<script type="text/javascript">
function delMemo(txt){
	
	var u="http://localhost:9999/memo.delete?txt="+txt;
	 $.getJSON(u, function (a) {
		 $("ul").empty();
		 getMemo();
		 alert("성공");
	 });
	
	
}

function getMemo() {
	var u="http://localhost:9999/memo.get";
	  $.getJSON(u, function (a) {
		  $.each(a,function(i,m){
			  var d=m.m_date;//"2023-07-05T08T01:18.028Z"
			  var d2=Date.parse(d);//1900-01-01부터 몇 밀리초 지났나?
			  var d3=new Date(d2);//완성된 날짜객체
			 // alert(d3.getFullYear());//2023
			  //alert(d3.getMonth()+1);//7
			 // alert(d3.getDate());//5
			 var d4=d3.getFullYear()+"/"+(d3.getMonth()+1)+"/"+d3.getDate();
			 d4+=" "+d3.getHours()+":"+d3.getMinutes();
			  var br=$("<br>");
			  var br2=$("<br>");
			  
			  //text는 글자를 넣는거고 지금 만든거
			  //DOM객체 여서 append를 써야할것
			 var mtxt= $("<li></li>").append(m.m_txt,br,br2,d4).attr("onclick", "delMemo('" + m.m_txt + "');");
			 //var mdate= $("<li></li>").text(m.m_date);
			 $("ul").append(mtxt);
		  });
		  //jQuery로 동적으로 listview에 넣은것들 디자인 적용
		  $("ul").listview("refresh");
          
      });
	
}
$(function() {
	getMemo();
    $("input").keyup(function (e) {
        if (e.keyCode == 13) {
            var txt = $(this).val();
            var u = "http://localhost:9999/memo.reg?txt=" + txt;
            $.getJSON(u, function (a) {
                alert("등록이 성공하였습니다.");
                getMemo();

                $("ul").empty();
            });
                $(this).val("");
        }
    });
});
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css"></style>
</head>

<body>
	<div data-role="page" id="coverPage">
		<div data-role="header" data-theme="b" data-position="fixed">
			<h1>메모</h1>
		</div>
		<div data-role="content">
			<table>
				<tr>
					<td align="center"><a href="#mainPage" data-transition="flip"><img
							src="resources/doge.jpg"></a></td>
				</tr>
			</table>


		</div>

		<div data-role="footer" data-position="fixed">
			<h1>bottom</h1>
		</div>
	</div>
	<!-- --------------------------------------------------------------------------- -->
	<div data-role="page" id="mainPage">
		<div data-role="header" data-theme="d" data-position="fixed">
			<a href="#coverPage" data-transition="flow" data-icon="arrow-l">뒤로</a>
			<h1>메모</h1>
		</div>
		<div data-role="content">
			<ul data-role="listview">

			</ul>

		</div>

		<div data-role="footer" data-theme="d" data-position="fixed">
			<input>

		</div>
	</div>

</body>
</html>