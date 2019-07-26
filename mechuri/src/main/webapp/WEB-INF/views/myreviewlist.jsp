<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내가 쓴 리뷰 목록</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<section id="main" class="wrapper">
	<div class="inner">
	  <header class="align-center">
<h1>내가 쓴 리뷰 목록</h1>
 </header>
 
  
 <table border='1'>
 <tr>
 <th>글번호</th>
 <th>리뷰글</th>
 </tr>
 <c:forEach items="${myreview}" var="myreview">
 <tr><td>${myreview.review_no}</td>
 <td><a href="productdetail.do?product_no=${myreview. review_productno}&product_ingre=''">${myreview.review_conts }</a></td>
</tr>
 </c:forEach>
 </table>
          </div>
   </section>
</body>
</html>