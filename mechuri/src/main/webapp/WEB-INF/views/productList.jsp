<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src='http://code.jquery.com/jquery-latest.js'></script>
<title>자사 제품 보기</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<section id="main" class="wrapper">
	<div class="inner">
	  <header class="align-center">
<h1>제품 리스트</h1>
 </header>

<table border='1'>
    <tr>
      <th>제품번호</th>
      <th>소분류명</th>
      <th>제품명</th>
      <th>등록일</th>
      <th>상태</th>
      <th>처리완료일</th>
   </tr>
 <c:forEach items="${list}" var="dto">
<tr>
<td> ${dto.product_no}  </td>	
<td>     ${dto.product_catesname } </td>	
<td>    <a href="productUpdateForm.do?product_no=${dto.product_no }"> ${dto.product_name} </a>  </td> 
<td>    <fmt:formatDate value="${dto.product_regdate}" pattern="yyyy.MM.dd"/>  </td>

<td><c:choose>
	<c:when test= "${dto.product_others01 eq 'N' }">
		수정신청  
	</c:when>
	<c:when test= "${dto.product_flag eq 'N' }"> 
		등록신청  
	</c:when>
	<c:when test= "${dto.product_others01 eq 'Y' }"> 
		수정완료
	</c:when>
	<c:when test= "${dto.product_flag eq 'Y' }"> 
		등록완료
	</c:when>
	</c:choose></td> 
	
<td>
<c:choose>	
<c:when test= "${dto.product_flag eq 'N' }"> 
		처리중  
</c:when>
<c:when test= "${dto.product_others01 eq 'N' }"> 
		처리중  
</c:when>
<c:otherwise>
<fmt:formatDate value="${dto.product_replacedate}" pattern="yyyy.MM.dd"/>
</c:otherwise>
</c:choose>
</td>
	
	
</tr>
</c:forEach>
 
</table>
      </div>
   </section>

</body>
</html>