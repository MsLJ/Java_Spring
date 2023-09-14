<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	function getShopping(start) {
		var search = $("input").val();
		//ㅋ->%2A
		search = encodeURIComponent(search);
		//alert(search);

		$.ajax({
			url : "get.shopping",
			data : {
				q : search,
				s : start
			},
			beforeSend : function(req) {
				req.setRequestHeader("ni", "js8a3iKcJsnzGvTy7N0Y");
				req.setRequestHeader("ns", "lGgWGRmKYz");
			},
			success : function(data) {
				if (start == 1) {

					$("table").empty();
				}
				//검색할때마다 비워주는
				$(data).find("item").each(
						function(i, item) {
							var img = $("<img>").attr("src",
									$(item).find("image").text());
							var title = $(item).find("title").text();
							var maker = $(item).find("maker").text();
							var lprice = $(item).find("lprice").text();
							var imagetd = $("<td></td>").append(img);
							var titletd = $("<td></td>").html(title);
							//화면에 다 떠있고,버튼 눌렀을때
							//톰캣과는 무관
							var makertd = $("<td></td>").text(maker);
							var lpricetd = $("<td></td>").text(lprice);
							var tr = $("<tr></tr>").append(imagetd, titletd,
									makertd, lpricetd);
							$("table").append(tr);
							//alert($(item).find("title").text());

						});

			}

		});

	}

	$(function() {
		
		var start=0;
		$("button").click(function() {
			start=1;
			getShopping(start);

		});
		var get=true;
		$(window).scroll(function() {
			var htmlHeightBlack = $(document).height();
			var browserHeightRed = $(window).height();
			var browserOffsetgreen = $(window).scrollTop();
			if (browserHeightRed + browserOffsetgreen >= htmlHeightBlack - 10&&get) {
				start += 10;
				getShopping(start);
				get=false;

			}else{
				get=true;
			}
		});
		$("input").keyup(function() {
			$("button").trigger("click");
		});

	});
	//html
	//jsp:사실은 서블릿:실행때 서블릿으로 바뀌어서 실행
	//EL/JSTL:실행때 자바소스로 바뀌어서 실행
</script>
<style type="text/css">
img {
	width: 100px;
	height: 100px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




	<input>

	<button>검색</button>

	<table border="1">


	</table>

</body>
</html>