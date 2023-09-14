<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
function showSnack() {
	//따로 function을 만들어서 여기에서 정보들을 불러오는 작업을하고
	//처음에 들어왔을때 이 함수를 부르고 등록에 성고했을때도 다시 이 함수를 부르면 될것
		var uu="http://localhost:9999/snack.get";
		$.getJSON(uu,function(a){
			//지금 현재 받아온 객체가 어차피 배열이기에 
			//따로 작업할 필요x 바로 each문 돌리면 될것
			$.each(a,function(i,s){
				var nametd=$("<td></td>").text(s.s_name);
				var pricetd=$("<td></td>").text(s.s_price);
				var tr=$("<tr></tr>").append(nametd,pricetd);
				$("table").append(tr);
			});
		});
	
}

$(function() {
	//RESTful
	showSnack();
	
	$("button").click(function () {
		var name=$("#name").val();
		var price=$("#price").val();
		//ajax:외부데이터 못씀
		//요청도 가고 응답도 오는데 크롬에서 그 응답을 받지않은것
		//Node.js쪽에 res.setHeader("Access-Control-Allow-Origin","*");
		//를 추가하면 알림이 뜸
		var u="http://localhost:9999/snack.reg?n="+name+"&p="+price;
		//JSON만,요청헤더는 표현 불가
		$.getJSON(u,function(asd){
			alert("등록 성공");
			showSnack();
		});
		$("#name").val("");
		$("#price").val("");
		$("table").empty();
		//등록 성공하고 비워줘야 다음에 추가했을때 중복으로 추가안될것
		
		
		//카카오&네이버그런거 쓸려면 아래꺼
		/* $.ajax({
			url:"http://localhost:9999/snack.reg",
			data:{n:name,
			p:price},
			success:function(asd){
				alert(JSON.stringify(asd));
			}
		
		
		
		}); */
	
	});
});

</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름:<input id="name"><p>
가격:<input id="price"><p>
<button>등록</button>
<table border="1"></table>

</body>
</html>