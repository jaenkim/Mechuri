<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% response.setContentType("text/html;charset=UTF-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="assets/css/5stars.css">
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
		<td rowspan="5">사진</td>
		<td>${proInfo.product_name} <input type="button" value="${proInfo.product_catelname} &#47; ${proInfo.product_catesname}" class="btn btn-light" /></td>
	</tr>
	<tr>
		<td>용량: ${proInfo.product_ml} &#47; 정가: ${proInfo.product_price}<p><a href="https://search.shopping.naver.com/search/all.nhn?query=${proInfo.product_name}&cat_id=&frm=NVSHATC" >최저가격 확인하기</a></td>
	</tr>
	<tr>
		<td><img src="images/point_${proInfo.product_point }.png" alt="이미지"> &#47; ${proInfo.product_point } &#47; ${proInfo.product_pointcount } </td>
	</tr>
	<tr> 
		<td><input type="button" value="성분정보 보기" onclick="ingre.do?product_no=${proInfo.product_no}&product_ingre=${proInfo.product_ingre }" /></td>
	</tr>
	<tr> 
		<td>${proInfo.product_conts}</td>
	</tr>
	<tr>
	<td>
	<div>
		<span class="heading">별점</span> 
		<img 	src="images/point_${proInfo.product_point }.png" alt="이미지">
		<p>별점 평균: ${proInfo.product_point } 별점 준 사람 수: ${proInfo.product_pointcount }</p>
	</div>
	</td>
	<td>
	<div>
		<div class="progress">
			<div class="progress-bar" style="width: ${(detailReview.rev1count/proInfo.product_pointcount)*100}%">${(detailReview.rev1count/proInfo.product_pointcount)*100}%</div>
		</div>
		<p>1점(${detailReview.rev1count}명)</p>
		<div class="progress">
			<div class="progress-bar" style="width: ${(detailReview.rev2count/proInfo.product_pointcount)*100}%">${(detailReview.rev2count/proInfo.product_pointcount)*100}%</div>
		</div>
		<p>2점(${detailReview.rev2count}명)</p>
		<div class="progress">
			<div class="progress-bar" style="width: ${(detailReview.rev3count/proInfo.product_pointcount)*100}%">${(detailReview.rev3count/proInfo.product_pointcount)*100}%</div>
		</div>
		<p>3점(${detailReview.rev3count}명)</p>
			<div class="progress">
			<div class="progress-bar" style="width: ${(detailReview.rev4count/proInfo.product_pointcount)*100}%">${(detailReview.rev4count/proInfo.product_pointcount)*100}%</div>
		</div>
		<p>4점(${detailReview.rev4count}명)</p>
			<div class="progress">
			<div class="progress-bar" style="width: ${(detailReview.rev5count/proInfo.product_pointcount)*100}%">${(detailReview.rev5count/proInfo.product_pointcount)*100}%</div>
		</div>
		<p>5점(${detailReview.rev5count}명)</p>
	</div>
	</td>
	</tr>
	</table>
	<table border="1">
		<tr>
		<th>리뷰번호</th>
		<th>리뷰작성자 닉네임</th>
		<th>리뷰 내용</th>
		<th>별점</th>
		<th>사진</th>
		<th>리뷰 작성일</th>
		</tr>
		<c:forEach items="${reviewInfo}" var="reviewInfo">
		<tr>
			<td>${reviewInfo.review_no}</td>
			<td>${reviewInfo.review_nick }</td>
			<td>${reviewInfo.review_conts }</td>
			<td>${reviewInfo.review_point }</td>
			<td>${reviewInfo.review_storedfile }</td>
			<td>${reviewInfo.review_regdate }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>