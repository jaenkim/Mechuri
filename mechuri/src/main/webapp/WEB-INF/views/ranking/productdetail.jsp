<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% response.setContentType("text/html;charset=UTF-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="assets/css/5stars.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>${proInfo.product_name} :: 메추리 랭킹</title>
</head>
<script type="text/javascript">

</script>
<body>

<h1>제품 상세페이지</h1>
<!-- 제품상세 -->
<table border='1'>
	<tr>
		<td>${proInfo.product_rank}</td> <!-- 제품 순위 -->
		<td>${proInfo.product_brand}</td> <!-- 제품 브랜드 -->
	</tr>
	<tr>
		<td rowspan="5">사진</td> <!-- 제품 이미지 -->
		<td class="sortPname">${proInfo.product_name} <input type="button" value="${proInfo.product_catelname} &#47; ${proInfo.product_catesname}" class="btn btn-light" /></td> <!-- 제품명 제품카테고리(버튼 > 브랜드 상세페이지 이동) -->
	</tr>
	<tr>
		<td class="sortPrice">용량: ${proInfo.product_ml} &#47; 정가: ${proInfo.product_price}<p><a href="https://search.shopping.naver.com/search/all.nhn?query=${proInfo.product_name}&cat_id=&frm=NVSHATC" >최저가격 확인하기</a></td>
	</tr>
	<tr>
		<td class="sortCountofPointers"><img src="images/productPoint/point_${proInfo.product_point }.png" alt="이미지"> &#47; ${proInfo.product_point } &#47; ${proInfo.product_pointcount } </td>
	</tr>
	<tr> 
		<td><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">성분 상세보기 ></button></td>
	</tr>
	<tr> 
		<td>${proInfo.product_conts}</td>
	</tr>
	<tr>
	<td>
	<div>
		<span class="heading">별점</span> 
		<img 	src="images/productPoint/point_${proInfo.product_point }.png" alt="이미지">
		<p>별점 평균: ${proInfo.product_point } 별점 준 사람 수: ${proInfo.product_pointcount }</p>
	</div>
	</td>
	<td>
	<div>
		
			<div class="progress">
			<c:choose>
				<c:when test="${detailReview.rev1count == null}">
					<div class="progress-bar" style="width: 0%">0%</div>
				</c:when>
				<c:otherwise>
					<div class="progress-bar" style="width: ${(detailReview.rev1count/proInfo.product_pointcount)*100}%">${(detailReview.rev1count/proInfo.product_pointcount)*100}%</div>
				</c:otherwise>
			</c:choose>
			</div>
			<p>1점(${detailReview.rev1count}명)</p>
		
		<div class="progress">
			<c:choose>
				<c:when test="${ detailReview.rev2count == null}">
					<div class="progress-bar" style="width: 0%">0%</div>
				</c:when>
				<c:otherwise>
					<div class="progress-bar" style="width: ${(detailReview.rev2count/proInfo.product_pointcount)*100}%">${(detailReview.rev2count/proInfo.product_pointcount)*100}%</div>
				</c:otherwise>
			</c:choose>
		</div>
		<p>2점(${detailReview.rev2count}명)</p>
		<div class="progress">
			<c:choose>
				<c:when test="${ detailReview.rev3count == null}">
					<div class="progress-bar" style="width: 0%">0%</div>
				</c:when>
				<c:otherwise>
					<div class="progress-bar" style="width: ${(detailReview.rev3count/proInfo.product_pointcount)*100}%">${(detailReview.rev3count/proInfo.product_pointcount)*100}%</div>
				</c:otherwise>
			</c:choose>
		</div>
		<p>3점(${detailReview.rev3count}명)</p>
		<div class="progress">
			<c:choose>
				<c:when test="${ detailReview.rev4count == null}">
					<div class="progress-bar" style="width: 0%">0%</div>
				</c:when>
				<c:otherwise>
					<div class="progress-bar" style="width: ${(detailReview.rev4count/proInfo.product_pointcount)*100}%">${(detailReview.rev4count/proInfo.product_pointcount)*100}%</div>
				</c:otherwise>
			</c:choose>
		</div>
		<p>4점(${detailReview.rev4count}명)</p>
		<div class="progress">
			<c:choose>
				<c:when test="${ detailReview.rev5count == null}">
					<div class="progress-bar" style="width: 0%">0%</div>
				</c:when>
				<c:otherwise>
					<div class="progress-bar" style="width: ${(detailReview.rev5count/proInfo.product_pointcount)*100}%">${(detailReview.rev5count/proInfo.product_pointcount)*100}%</div>
				</c:otherwise>
			</c:choose>
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

 <!-- 성분 Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- 성분 Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">성분정보</h4>
        </div>
        <div class="modal-body">
          <p>${proInfo.product_name } </p>
          <p>${proInfo.product_ml},${proInfo.product_price}</p>
          <p>해당 제품의 전성분에 대한 EWG 안전도 등급입니다.</p>
          <div>
	        <img src="images/ingre/ingre_dangernone.png" alt="등급미정">등급미정
	        <img src="images/ingre/ingre_dangerlow.png" alt="낮은 위험도">낮은 위험도
	        <img src="images/ingre/ingre_dangermiddle.png" alt="중간 위험도">중간 위험도
	      	<img src="images/ingre/ingre_dangerhigh.png" alt="높은 위험도">높은 위험도
          </div>
          <div>
          	<table border = '1'>
          	<c:forEach items="${ingreInfo}" var="ingreInfo">
          		<tr>
          			<td>
          				<img src="images/ingre/ingre_${ingreInfo.ingre_grade}.png" alt="위험도">
          			</td>
          			<td>
          				<p>${ingreInfo.ingre_korname}</p>	
          				<p>${ingreInfo.ingre_engname}</p>
          				<p>${ingreInfo.ingre_conts}</p>
          				<c:choose>
	          				<c:when test="${ingreInfo.ingre_20conts != null}">
	          					<img src="images/ingre/ingre_20.png" alt="20가지 주의성분"> 20가지 주의성분 포함 | ${ingreInfo.ingre_20conts}</p>
	          				</c:when>
	          				<c:otherwise>
	          				</c:otherwise>
          				</c:choose>
          				<c:choose>
	          				<c:when test="${ingreInfo.ingre_skintype != null}">
	          					<img src="images/ingre/ingre_skin.png" alt="도움되는 피부타입"> ${ingreInfo.ingre_skintype}에 도움
	          				</c:when>
	          				<c:otherwise>
	          				</c:otherwise>
          				</c:choose>
          			</td>	
           		</tr>
          	</c:forEach>
          	</table>
          </div>
          
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
     
    </div>
  </div>
</body>
</html>