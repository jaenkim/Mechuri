<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% response.setContentType("text/html;charset=UTF-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Title insert here</title>

</head>
<body>
<h1>제품 상세페이지</h1>
<table border='1'>
	<tr>
		<td>${proInfo.product_rank}</td>
		<td>${proInfo.product_brand}</td>
	</tr>
	<tr>
		<td rowspan="4">사진</td>
		<td>${proInfo.product_name} <input type="button" value="${proInfo.product_catelname} &#47; ${proInfo.product_catesname}" class="btn btn-light" /></td>
	</tr>
	<tr>
		<td>${proInfo.product_ml} &#47; ${proInfo.product_price}</td>
	</tr>
	<tr>
		<td><img src="images/${proInfo.product_point }.png" alt="이미지"> &#47; ${product.product_point } &#47; ${product.product_pointcount } </td>
	</tr>
	<tr> 
		<td colspan="2">${proInfo.product_conts}</td>
	</tr>
	<tr>
		<td>평점분석</td>
		<td>1점대, 2점대, 3점대, 4점대, 5점대</td>
	</tr>
	<c:forEach items="${reviewInfo}" var="reviewInfo">
	<tr>
		<td colspan="2">${reviewInfo.review_nick } <input type="button" class="btn btn-light" /> 정렬 </td>
	</tr>
	</c:forEach>
</table>
</body>
</html>