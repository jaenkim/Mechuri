<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html;charset=UTF-8");
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="assets/js/rankSorting.js"></script>
<title>제품 목록 페이지</title>

<!-- <link rel="stylesheet" href="assets/css/style.min.css"> -->
<!-- <link rel="stylesheet" href="assets/css/modules.css"> -->
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap&subset=korean"
	rel="stylesheet">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body class="default">
	<%-- <jsp:include page="../Header.jsp" />  --%>


	<section>
	<h5>이 곳에 페이지를 작성 '3'</h5>
	</section>

	<div>
		<form action="list.do" method="post">
		<h3>필터 영역</h3>
			<input type="hidden" name="command" value="filter" /> 
			<input	type="checkbox" name="age" value="10대" /> 10대 
			<input	type="checkbox" name="age" value="20대" /> 20대 
			<input	type="checkbox" name="age" value="30대" /> 30대<br /> 
			<input	type="checkbox" name="age" value="40대" /> 40대 
			<input	type="checkbox" name="age" value="50대 이상" /> 50대 이상<br />
			<input type="checkbox" name="gender" value="여성" /> 여성 
			<input	type="checkbox" name="gender" value="남성" /> 남성 <br />
			<p>카테고리</p>
			<select name="filter_catelname" style="width: 200px">
				<option value="">전체</option>
			</select> <select name="filter_catesname" style="width: 200px">
				<option value="">전체</option>
			</select> 
			<input type="submit" value="선택 조건으로 검색" />
		</form>
	</div>
	<div>
	
	</div>
	
	<table border='1' id="rankingTable">
	<thead>
		<tr>
			<th>순위 <button onclick="sortTD ( 0 )">▲</button><button onclick="reverseTD ( 0 )">▼</button> </th>
<!-- 		<th>사진</th>	 -->
			<th>브랜드 <button onclick="sortTD ( 1 )">▲</button><button onclick="reverseTD ( 1 )">▼</button> </th>
			<th>제품명 <button onclick="sortTD ( 2 )">▲</button><button onclick="reverseTD ( 2 )">▼</button> </th>
			<th>평점/평점인원 <button onclick="sortTD ( 3 )">▲</button><button onclick="reverseTD ( 3 )">▼</button> </th>
		</tr>
	</thead>
  	<tbody>
		<c:forEach items="${list}" var="dto">
			<tr class="sorting">
<%--   		<td><img src="images/${dto.product_storedname }.png" alt="이미지"> --%>
				<td>${dto.product_rank}</td>
				<td>${dto.product_brand}</td>
				<td><a href="productdetail.do?no=${dto.product_no}&ingre=${dto.product_ingre}">${dto.product_name} </a></td>
				<td>
					<c:choose>
						<c:when test="${dto.product_pointcount == 0}">
							평점 없음
						</c:when>
						<c:otherwise>
						<fmt:formatNumber value="${dto.product_point }" pattern=".00" /> / ${dto.product_pointcount }
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
<jsp:include page="../TopScroll.jsp" />	
<!-- 정렬 -->
<script type="text/javascript">
	var myTable = document.getElementById( "rankingTable" ); 
	var replace = replacement( myTable ); 
	function sortTD( index ){    replace.ascending( index );    } 
	function reverseTD( index ){    replace.descending( index );    } 
</script>
	
	<jsp:include page="../Footer.jsp" />
	<script src="assets/js/index.js"></script>
	<script src="assets/js/cate_filter.js"></script>
</body>

</html>