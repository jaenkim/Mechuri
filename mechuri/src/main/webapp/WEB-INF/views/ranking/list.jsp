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
	<h1>이 곳에 페이지를 작성 '3'</h1>
	</section>

	<div>
		<form action="list.do" method="post">
		<h3>필터 영역</h3>
			<input type="hidden" name="command" value="filter" /> 
			<input	type="checkbox" name="filter_age10" value="전체,10대" /> 10대 
			<input	type="checkbox" name="filter_age20" value="전체,20대" /> 20대 
			<input	type="checkbox" name="filter_age30" value="전체,30대" /> 30대 <br /> 
			<input	type="checkbox" name="filter_age40" value="전체,40대" /> 40대 
			<input	type="checkbox" name="filter_age50" value="전체,50대" /> 50대 이상 <br />
			<input type="checkbox" name="filter_genderF" value="여성" /> 여성 
			<input	type="checkbox" name="filter_genderM" value="남성" /> 남성 <br />
			<p>카테고리</p>
			<select name="filter_catelname" style="width: 200px">
				<option value="">전체</option>
			</select> <select name="filter_catesname" style="width: 200px">
				<option value="">전체</option>
			</select> <input type="submit" value="선택 조건으로 검색" />
		</form>
	</div>
	<div>
		<h3>정렬</h3>
		<p><a href="list.do?command=sortbyhighprice">가격 높은순</a></p>
		<p><a href="list.do?command=sortbylowprice">가격 낮은순</a></p>
		<p><a href="list.do?command=sortbyascname">이름순</a></p>
		<p><a href="list.do?command=sortbymaxreview">리뷰 많은순</a></p>
		<p><a href="list.do?command=sortbyminreview">리뷰 적은순</a></p>
	</div>
	<table border='1'>
		<tr>
 			<th>순위</th>
<!-- 			<th>사진</th> -->
			<th>브랜드</th>
			<th>제품명</th>
			<th>평점</th>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
<%--  				<td><img src="images/${dto.product_storedname }.png" alt="이미지">  --%>
				<td>${dto.product_rank}</td>
				<td>${dto.product_brand}</td>
				<td><a href="productdetail.do?no=${dto.product_no}&ingre=${dto.product_ingre}">${dto.product_name}</a></td>
				<td><fmt:formatNumber value="${dto.product_point }" pattern=".00" /></td>
			</tr>
		</c:forEach>
	</table>

	
	<jsp:include page="../Footer.jsp" />
	<script src="assets/js/index.js"></script>
	<script src="assets/js/cate_filter.js"></script>
	<script type="text/javascript">
//  		function productdetail(product_no){
//  			onclick = "productdetail(${dto.product_no})"
// 			location.href = "productdetail.do?product_no="+product_no;
// 		} 
	
	</script>
</body>

</html>