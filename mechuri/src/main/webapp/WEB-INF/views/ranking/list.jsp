<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% response.setContentType("text/html;charset=UTF-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제품 목록 페이지</title>

<!-- <link rel="stylesheet" href="assets/css/style.min.css"> -->
<!-- <link rel="stylesheet" href="assets/css/modules.css"> -->
<link	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap&subset=korean"
	rel="stylesheet">

</head>
<body class="default">
<%-- <jsp:include page="../Header.jsp" />  --%>

<!--  START MODULE AREA 1: Page Title 1-->
<section>
  <div data-layout="_r">
    <div data-layout="al16">
      <h1>이 곳에 페이지를 작성 '3'</h1>
    </div>
  </div>
</section>
<!--  END MODULE AREA 1: Page Title 1-->
<section class="filter">
<div>
<form action="list.do" method="post" >
	<input type="hidden" name="command" value="filter" />
	<input type="checkbox" name="filter_age10" value="10대" /> 10대
	<input type="checkbox" name="filter_age20" value="20대" /> 20대
	<input type="checkbox" name="filter_age30" value="30대" /> 30대 <br />
	<input type="checkbox" name="filter_age40" value="40대" /> 40대
	<input type="checkbox" name="filter_age50" value="50대" /> 50대 이상 <br />
	<input type="checkbox" name="filter_genderW" value="여성" /> 여성
	<input type="checkbox" name="filter_genderM" value="남성" /> 남성 <br />
<input type="submit" value="선택 조건으로 검색"/>
</form>
</div>
</section>
<!--START MODULE AREA 2: Article Block 2-->
<!-- <section class="MOD_ARTICLEBLOCKS2_Section">
  <div data-layout="_r" class="MOD_ARTICLEBLOCKS2"> -->
  
  
<!--   <div data-layout="al16 ch8 ec4" class="MOD_ARTICLEBLOCKS2_Cont"> -->
  <!--   <a href="#" class="MOD_ARTICLEBLOCKS2_BlockSmall"> </a> -->
  <table border='1'>
  <th>순위</th>
  <th>브랜드</th>
  <th>제품명</th>
  <c:forEach items="${list}" var="dto">
  <tr>
        <td>${dto.product_rank}</td>
        <td>${dto.product_brand}</td>
        <td>${dto.product_name}</td>
   </tr>
</c:forEach>  
</table>

<!--   </div>
</section> -->
<!--
END MODULE AREA 2: Article Block 2
-->


<jsp:include page="../Footer.jsp" />
<script src="assets/js/index.js"></script>
</body>

</html>