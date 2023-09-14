<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/member.css">
<link rel="stylesheet" href="resources/css/sns.css">
<link rel="stylesheet" href="resources/css/gallery.css">
<script type="text/javascript" src="resources/js/zoojoinck.js"></script>
<script type="text/javascript" src="resources/js/zoojoinckh.js"></script>
<script type="text/javascript" src="resources/js/zoomove.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/zoo_jQuery.js"></script>
<script type="text/javascript" charset="utf-8">
	(function(w, d, t, f) {
		w[f] = w[f]
				|| function(c, k, n) {
					s = w[f], k = s['k'] = (s['k'] || (k ? ('&k=' + k) : ''));
					s['c'] = c = (c instanceof Array) ? c : [ c ];
					s['n'] = n = n || 0;
					L = d.createElement(t), e = d.getElementsByTagName(t)[0];
					L.async = 1;
					L.src = '//feed.aqicn.org/feed/' + (c[n].city) + '/'
							+ (c[n].lang || '') + '/feed.v1.js?n=' + n + k;
					e.parentNode.insertBefore(L, e);
				};
	})(window, document, 'script', '_aqiFeed');
</script>
<script type="text/javascript" charset="utf-8">
	_aqiFeed({
		container : "city-aqi-container",
		city : "seoul"
	});
</script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table id="siteTitleArea">
		<tr>
			<td align="center">
				<table id="siteMenu">
					<tr>
						<td align="center"><a href="dataroom.go">DATA</a></td>
						<td align="center"><a href="gallery.go">GALLERY</a></td>
						<td align="center"><a>???</a></td>

					</tr>
				</table>
			</td>

		</tr>
		<tr>
			<td align="center">
				<table id="siteTitle">
					<tr align="center">
					
						<td><a href="index.do">Peaches_Zoo</a>
				</table>

			</td>
		
				
		</tr>
		<tr>
			<td><table id="siteLoginArea">
					<tr>
						<td align="right"><jsp:include page="${loginPage }"></jsp:include>


						</td>


					</tr>
				</table></td>
		</tr>
	</table>

	<table id="siteContentArea">
		<tr>
			<td align="center"></td>
			<td><jsp:include page="${cp }"></jsp:include></td>
		</tr>
	</table>



	<div id="resultDiv">${result }
		<br>
		<span id="city-aqi-container"></span>
	</div>




</body>
</html>