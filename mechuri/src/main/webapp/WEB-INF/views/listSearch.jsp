<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script>

 $(function(){
  $('#searchBtn').click(function() {
   self.location = "listSearch.do"
     + '${pageMaker.makeQuery(1)}'
     + "&searchType="
     + $("select option:selected").val()
     + "&keyword="
     + encodeURIComponent($('#keywordInput').val());
    });
 });   
 </script>
<title>제품 전체보기 검색</title>
</head>
<body>
<div class="search">
 <select name="searchType"> <!-- 컨트롤러에서 값을 보내주는것이 아니라 컨트롤러에 요청된 URL에 따라 값이 달라짐. -->
  <option value="no"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
  <option value="n"<c:out value="${scri.searchType eq 'n' ? 'selected' : ''}"/>>이름</option>
  <option value="b"<c:out value="${scri.searchType eq 'b' ? 'selected' : ''}"/>>브랜드</option>
  <option value="cl"<c:out value="${scri.searchType eq 'cl' ? 'selected' : ''}"/>>카테고리</option>
 </select>
 
 <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>

 <button id="searchBtn" >검색</button>
 
 	<h2>상품 검색 목록</h2>
 		<table border='1' id="serachTable">
 		<thead>
			<tr><th>상품번호</th><th>상품이름</th><th>큰 카테고리</th><th>작은 카테고리</th><th>브랜드</th><th>가격</th></tr>
		</thead>	
			<!-- 목록 시작 -->
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.product_no}</td>
				<td><a href="/mechuri/listSearch.do?product_no=${dto.product_no}&
										page=${scri.page}&
										perPageNum=${scri.perPageNum}&
										searchType=${scri.searchType}&
										keyword=${scri.keyword}">${dto.product_name}</a></td>
				<td>${dto.product_catelname}</td>
				<td>${dto.product_catesname}</td>
				<td>${dto.product_brand}</td>
				<td>${dto.product_price}</td>
			</tr>
			</c:forEach>
			<!-- 목록 끝 -->
 	</table>
 	
 	<div class="col-md-offset-3"> 
			<ul class="pagination">
				<c:if test="${pageMaker.prev}">
					<li><a href="listSearch${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
				</c:if>	

				<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
					<li <c:out value="${pageMaker.cri.page == idx ? 'class=active' : ''}"/>>
					<a href="listSearch${pageMaker.makeSearch(idx)}">${idx}</a></li>
				</c:forEach>
	<!--  jstl로 URL 또는 세션에 있는 scri.searchType값을 가져와서, 이 값이 'w'라면 selected를 출력하고, 아니면 공백('')을 출력한다는 조건문 --> 
				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a href="listSearch${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
				</c:if>	
			</ul> 
		</div>
</div>
<jsp:include page="Footer.jsp" />
</body>
</html>