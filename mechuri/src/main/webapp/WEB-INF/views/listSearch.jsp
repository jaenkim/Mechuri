<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
		<script>
			//http://localhost:8888/mechuri/listSearch.do?page=1&perPageNum=20&searchType=n&keyword=아
			$(function() {
				$('#searchBtn').click(
						function() {
							self.location = "listSearch.do"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword="
									+ encodeURIComponent($('#keywordInput')
											.val());
						});
			});
		</script>
		
		
		<script>
	$(document).ready(function() {
		$(window).scroll(function() {
			if ($(this).scrollTop() > 200) {
				$('.top').fadeIn();
			} else {
				$('.top').fadeOut();
			}
		});
		$('.top').click(function() {
			$('html, body').animate({
				scrollTop : 0
			}, 400);
			return false;
		});
	});
</script>

<title>제품 전체보기 검색</title>

<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color:
}

th {
	background-color: #ff9999;
	color: white;
}

div {
	/* margin: auto;
	width: 500px;
	height: 2000px;
	border: 1px solid #bcbcbc; */
}

button.top {
	position: fixed;
	left: 90%;
	bottom: 50px;
	display: none;
}
</style>


</head>
<body>
	<jsp:include page="Header.jsp" />

	<section id="main" class="wrapper">
				<div class="inner">
					<header class="align-center">
		<h2>상품 검색</h2>
			</header>
			<div>
		<div style="float: left; width: 10%; margin-right:10px; margin-top:30px; margin-bottom:30px; margin-left:400px;">
			<select style="size: 50px; display: inline-block;" name="searchType" >
				<!-- 컨트롤러에서 값을 보내주는것이 아니라 컨트롤러에 요청된 URL에 따라 값이 달라짐. -->
				<option value="no"
					<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
				<option id="bb" class="none" value="n"
					<c:out value="${scri.searchType eq 'n' ? 'selected' : ''}"/>>이름</option>
				<option id="cc" class="none" value="b"
					<c:out value="${scri.searchType eq 'b' ? 'selected' : ''}"/>>브랜드</option>
				<option id="dd" class="none" value="cl"
					<c:out value="${scri.searchType eq 'cl' ? 'selected' : ''}"/>>대분류명</option>
			</select>
			</div>
			<!-- 검색 타입 값에 따라 출력   -->
		<div style="float: left; width: 40%; margin-right:10px; margin-top:30px; margin-bottom:30px; ">
	
			<input type="text" name="keyword" id="keywordInput"
				placeholder="검색어를 입력하세요" value="${scri.keyword}" />
			</div>
			
			<div style="float: left; width: 10%;">
			
			<button id="searchBtn" style="display: inline-block; margin-top:30px; margin-bottom:30px;">검색</button>
				
				</div>
		
</div>

		<table id="serachTable">
			<thead>
				<tr>
					<th>상품번호</th>
					<th>상품이름</th>
					<th>대분류명</th>
					<th>소분류명</th>
					<th>브랜드</th>
					<th>가격</th>
				</tr>
			</thead>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.product_no}</td>
					<td><a href="productdetail.do?no=${dto.product_no}&ingre=${dto.product_ingre}">${dto.product_name}
					</a>
					<td>${dto.product_catelname}</td>
					<td>${dto.product_catesname}</td>
					<td>${dto.product_brand}</td>
					<td>${dto.product_price}</td>
				</tr>
			</c:forEach>
			<!-- 목록 끝 -->
		</table>
	</div>
	</section>
	<button href="#" class="top">Top</button>
	
	<jsp:include page="Footer.jsp" />
</body>
</html>