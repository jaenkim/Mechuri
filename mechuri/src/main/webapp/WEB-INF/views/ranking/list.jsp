<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% response.setContentType("text/html;charset=UTF-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/listSideNav.css">
<link rel="stylesheet" href="assets/css/style.main2.css">
<!-- <link rel="stylesheet" href="assets/css/starRating.css"> -->
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap&subset=korean" rel="stylesheet">
<script src="assets/js/rankSorting.js"></script>
<!-- <script src="assets/js/starRating.js"></script> -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<title>제품 목록 페이지</title>
</head>
<body>
<jsp:include page="../Header.jsp" />  
<style type="text/css">
.starR1 {
	background:
		url('http://miuu227.godohosting.com/images/icon/ico_review.png')
		no-repeat -52px 0;
	background-size: auto 100%;
	width: 15px;
	height: 30px;
	float: left;
	text-indent: -9999px;
	cursor: pointer;
}

.starR2 {
	background:
		url('http://miuu227.godohosting.com/images/icon/ico_review.png')
		no-repeat right 0;
	background-size: auto 100%;
	width: 15px;
	height: 30px;
	float: left;
	text-indent: -9999px;
	cursor: pointer;
}

.starR1.on {
	background-position: 0 0;
}

.starR2.on {
	background-position: -15px 0;
}
</style>
<script type="text/javascript">
/* 체크박스 전체선택, 전체해제 */
function ageChekAll(){
       if( $("#ageChekAlly").is(':checked') ){
         $("input[name=ages]").prop("checked", true);
       }else{
         $("input[name=ages]").prop("checked", false);
       }
}
function genderChekAll(){
    if( $("#genderChekAlly").is(':checked') ){
      $("input[name=genders]").prop("checked", true);
    }else{
      $("input[name=genders]").prop("checked", false);
    }
}
function skinChekAll(){
    if( $("#skinChekAlly").is(':checked') ){
      $("input[name=skins]").prop("checked", true);
    }else{
      $("input[name=skins]").prop("checked", false);
    }
}
</script>

	<section id="main" class="wrapper">
		<div class="inner">
			<header class="align-center">
				<h1>메추리 랭킹</h1>
				<p>랭킹은 즐거워 </p>
			</header>
	<div id="filternav" class="sidenav">
		<form action="list.do" method="post">
		<input type="hidden" name="command" value="filter" /> 
<!-- 		<h3 style="margin-left: 10px; margin-top: 10px;"><img src="images/filter.png" alt="" /> 필터 </h3> -->
			<div>
				<h3 style="margin-left: 20px; margin-top: 0px; margin-right: 0px; margin-bottom: 0px;">연령대</h3>
				<input style="margin-left: 30px;" type="checkbox" id="ageChekAlly" onclick="ageChekAll()" /><label for="ageChekAlly" style="font-family: 'LotteMartHappy';">전체</label><br />
				<input	style="margin-left: 30px;" type="checkbox" id="age10" name="ages" class="ageChek" value="10대" /><label for="age10">10대</label> 
				<input	type="checkbox" id="age20" name="ages" class="ageChek" value="20대" /><label for="age20">20대</label><br />
				<input	style="margin-left: 30px;" type="checkbox" id="age30" name="ages" class="ageChek" value="30대" /><label for="age30">30대</label>
				<input	type="checkbox" id="age40" name="ages" class="ageChek" value="40대" /><label for="age40">40대</label><br />
				<input style="margin-left: 30px;" 	type="checkbox" id="age50" name="ages" class="ageChek" value="50대 이상" /><label for="age50">50대 이상</label>
			</div>
				<hr>
			<div>
				<h3 style="margin-left: 20px; margin-top: 0px; margin-right: 0px; margin-bottom: 0px;">성별</h3>
				<input style="margin-left: 30px;" type="checkbox" id="genderChekAlly" onclick="genderChekAll();" /><label for="genderChekAlly">전체</label><br />
				<input style="margin-left: 30px;" type="checkbox" id="female" name="genders" class="genderChek" value="여성" /><label for="female">여성</label>
				<input	type="checkbox" id="male" name="genders" class="genderChek" value="남성" /><label for="male">남성</label> 
			</div>
			<hr>
			<div>
				<h3 style="margin-left: 20px; margin-top: 0px; margin-right: 0px; margin-bottom: 0px;">피부타입</h3>
				<input style="margin-left: 30px;" type="checkbox" id="skinChekAlly" onclick="skinChekAll();" /><label for="skinChekAlly">전체</label>
				<input type="checkbox" id="dry" name="skins" class="skinChek" value="건성" /><label for="dry">건성</label><br />
				<input	style="margin-left: 30px;" type="checkbox" id="oilly" name="skins" class="skinChek" value="지성" /><label for="oilly">지성</label>
				<input type="checkbox" id="ato" name="skins" class="skinChek" value="여드름성" /><label for="ato">여드름성</label>
			</div>
			<hr>
			<div>
				<h3 style="margin-left: 20px; margin-top: 0px; margin-right: 0px; margin-bottom: 0px;">카테고리</h3>
			<select style="margin-left: 10px; width: 50%; display:inline;" name="filter_catelname" >	<option value="">전체</option></select>
			<select name="filter_catesname" style="width: 40%; display:inline;"><option value="">전체</option></select>
			</div> 
			<input style="margin-left: 30px; margin-top: 20px" type="submit" value="선택 조건으로 검색" />
		</form>
	</div>
	
	<div>
	
	</div>
<!-- 	<button onclick="sortTD (0)">▲</button><button onclick="reverseTD (0)">▼</button> -->
<!-- 	<button onclick="sortTD ( 1 )">▲</button><button onclick="reverseTD ( 1 )">▼</button> -->
<!-- 	<button onclick="sortTD ( 2 )">▲</button><button onclick="reverseTD ( 2 )">▼</button> -->
<!-- 	<button onclick="sortTD ( 3 )">▲</button><button onclick="reverseTD ( 3 )">▼</button> -->
	
	<table border='1' id="rankingTable">
<!-- 	<thead> -->
<!-- 		<tr> -->
<!-- 			<th>순위 <button onclick="sortTD ( 0 )">▲</button><button onclick="reverseTD ( 0 )">▼</button> </th> -->
<!-- 			<th>사진</th> -->
<!-- 			<th>브랜드 <button onclick="sortTD ( 1 )">▲</button><button onclick="reverseTD ( 1 )">▼</button> </th> -->
<!-- 			<th>제품명 <button onclick="sortTD ( 2 )">▲</button><button onclick="reverseTD ( 2 )">▼</button> </th> -->
<!-- 			<th>평점/평점인원 <button onclick="sortTD ( 3 )">▲</button><button onclick="reverseTD ( 3 )">▼</button> </th> -->
<!-- 		</tr> -->
<!-- 	</thead> -->
  	
		<c:forEach items="${list}" var="dto">
		<tbody>
			<tr style="height: 10px; border-bottom-width: 0px;">
				<td rowspan="3" style="text-align: center; font-family: Happy; font-size: 20px; background-color: #ffffff; border-width: 0px;">${dto.product_rank}</td>
				<td rowspan="3" style="width: 20%;text-align: center; background-color: #ffffff; border-width: 0px;"><img src="images/product/${random}.jpg" style="width:120px; text-align: center;" alt="제품 이미지"></td>
				<td colspan="4" style="background-color: #ffffff; border-width: 0px;">${dto.product_brand}</td>
			</tr>
			<tr style="border-width: 0px;">
				<td style="width: 45%; background-color: #ffffff; border-width: 0px;"><a href="productdetail.do?no=${dto.product_no}&ingre=${dto.product_ingre}">${dto.product_name}</a></td>
				<td rowspan="2" style="width:	5%; background-color: #ffffff; border-width: 0px;">
					<c:choose>
						<c:when test="${dto.product_pointcount == 0}">
							평점 없음
						</c:when>
						<c:otherwise>
							<fmt:formatNumber value="${dto.product_point }" pattern=".00" />
						</c:otherwise>
					</c:choose>
				</td>
<%-- 				<td rowspan="2" style="width: 13%;"><img style="width:100px;" src="images/productPoint/<fmt:formatNumber value='${dto.product_point}' pattern='.0' />.png"></td>  --%>
				<td rowspan="2" style="width: 19%; background-color: #ffffff; border-width: 0px;">
						<input type="hidden" name="review_class_seq" value="">
						<input type="hidden" name="review_rating" >
						<!-- 별모양 -->
						<div class="starRev" >
							<span class="starR1">별1_왼쪽</span> <span class="starR2">별1_오른쪽</span>
							<span class="starR1">별2_왼쪽</span> <span class="starR2">별2_오른쪽</span>
							<span class="starR1">별3_왼쪽</span> <span class="starR2">별3_오른쪽</span>
							<span class="starR1">별4_왼쪽</span> <span class="starR2">별4_오른쪽</span>
							<span class="starR1">별5_왼쪽</span> <span class="starR2">별5_오른쪽</span> 
							<input type="hidden" name="rate" value="${fn:substring(dto.product_point,0,fn:indexOf(dto.product_point,'.')+1)}${fn:substring(dto.product_point,fn:indexOf(dto.product_point,'.')+1,3)<5?'0':'5'}" />
<%-- 							<input type="hidden" name="rate" value="${fn:substring(dto.product_point2,indexOf(dto.product_point2,'.'),length(dto.product_point2)}" /> --%>
							
						</div>
				</td>
				<td rowspan="2" style="width: 6%;">(${dto.product_pointcount })</td>
			</tr>
			<tr style="border-width: 0px;">
				<td style="background-color: #ffffff; border-width: 0px;">${dto.product_price } / ${dto.product_ml }</td>
			</tr>
			</tbody>
		</c:forEach>
	
	</table>

		</div>
	</section>
	
<script type="text/javascript">
	$(function(){
		var rates=$(".starRev").find("input[name=rate]");//[rate,rate,rate,rate,rate,rate] 평점을 담은 input 태그들
// 		var rate=$(".starRev").find("input[name=rate]").val();   
			rates.each(function(){
				var p=$(this).val();//평점 하나 구하기
				var k=0;//인덱스 초기화
				for(var i=0;i<parseFloat(p);i+=0.5){
				 	$(this).parent().find("span").eq(k).addClass('on');// 별에 색칠해주는 작업
					k++;
				}									
			});
		});
</script>

<jsp:include page="../TopScroll.jsp" />	
<!-- 정렬 -->
<script type="text/javascript">
	var myTable = document.getElementById( "rankingTable" ); 
	var replace = replacement( myTable ); 
	function sortTD( index ){    replace.ascending( index );    } 
	function reverseTD( index ){    replace.descending( index ); }
</script>
	
	<jsp:include page="../Footer.jsp" />
	<script src="assets/js/index.js"></script>
	<script src="assets/js/cate_filter.js"></script>
</body>

</html>

<!-- <tr class="sorting"> -->
<%--   		<td><img src="images/${dto.product_storedname }.png" alt="이미지"> --%> 
<%-- 				<td>${dto.product_rank}</td> --%>
<%-- 				<td>${dto.product_brand}</td> --%>
<%-- 				<td><a href="productdetail.do?no=${dto.product_no}&ingre=${dto.product_ingre}">${dto.product_name} </a></td> --%>
<!-- 				<td> -->
<%-- 					<c:choose> --%>
<%-- 						<c:when test="${dto.product_pointcount == 0}"> --%>
<!-- 							평점 없음 -->
<%-- 						</c:when> --%>
<%-- 						<c:otherwise> --%>
<%-- 						<fmt:formatNumber value="${dto.product_point }" pattern=".00" /> / ${dto.product_pointcount } --%>
<%-- 						</c:otherwise> --%>
<%-- 					</c:choose> --%>
<!-- 				</td> -->
<!-- 			</tr> -->