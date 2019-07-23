<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% response.setContentType("text/html;charset=UTF-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/style.main.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/listSideNav.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap&subset=korean" rel="stylesheet">
<script src="assets/js/rankSorting.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<title>제품 목록 페이지</title>
</head>
<body>
<jsp:include page="../Header.jsp" />  
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
				<h1>Generic Page</h1>
				<p>Lorem ipsum dolor sit amet nullam id egestas urna aliquam</p>
			</header>
	<div class="sidenav">
		<form action="list.do" method="post">
		<input type="hidden" name="command" value="filter" /> 
		<h3><img src="images/filter.png" alt="" /> 필터 </h3>
			<div class="6u 12u$(small)">
				<h3>연령대</h3>
				<input type="checkbox" id="ageChekAlly" onclick="ageChekAll()" /><label for="ageChekAlly" style="font-family: 'LotteMartHappy';">전체</label>
				<input	type="checkbox" id="age10" name="ages" class="ageChek" value="10대" /><label for="age10">10대</label> 
				<input	type="checkbox" id="age20" name="ages" class="ageChek" value="20대" /><label for="age20">20대</label>
				<input	type="checkbox" id="age30" name="ages" class="ageChek" value="30대" /><label for="age30">30대</label>
				<input	type="checkbox" id="age40" name="ages" class="ageChek" value="40대" /><label for="age40">40대</label>
				<input	type="checkbox" id="age50" name="ages" class="ageChek" value="50대 이상" /><label for="age50">50대 이상</label>
			</div>
				<hr>
			<div class="6u 12u$(small)">
				<h3>성별</h3>
				<input type="checkbox" id="genderChekAlly" onclick="genderChekAll();" /><label for="genderChekAlly">전체</label>
				<input type="checkbox" id="female" name="genders" class="genderChek" value="여성" /><label for="female">여성</label>
				<input	type="checkbox" id="male" name="genders" class="genderChek" value="남성" /><label for="male">남성</label> 
			</div>
			<div class="6u 12u$(small)">
				<h3>피부타입</h3>
				<input type="checkbox" id="skinChekAlly" onclick="skinChekAll();" /><label for="skinChekAlly">전체</label>
				<input type="checkbox" id="dry" name="skins" class="skinChek" value="건성" /><label for="dry">건성</label><br />
				<input	type="checkbox" id="oilly" name="skins" class="skinChek" value="지성" /><label for="oilly">지성</label>
				<input type="checkbox" id="ato" name="skins" class="skinChek" value="여드름성" /><label for="ato">여드름성</label>
			</div>
			<hr>
			<div class="6u 12u$(small)">
				<h3>카테고리</h3>
			<select name="filter_catelname" style="width: 130px; display:inline;">	<option value="">전체</option></select>
			<select name="filter_catesname" style="width: 130px; display:inline;"><option value="">전체</option></select>
			</div> 
			<input type="submit" value="선택 조건으로 검색" />
		</form>
	</div>
	
	<div>
	
	</div>
	
	<table border='1' id="rankingTable">
	<thead>
		<tr>
			<th>순위 <button onclick="sortTD ( 0 )">▲</button><button onclick="reverseTD ( 0 )">▼</button> </th>
<!-- 		<th>사진</th>	 -->
			<th>브랜드 <button onclick="sortTD ( 1 )">▲</button><button onclick="reverseTD ( 1 )">▼</button> </th>
			<th>제품명 <button onclick="sortTD ( 2 )">▲</button><button onclick="reverseTD ( 2 )">▼</button> </th>
			<th>평점/평점인원 <button onclick="sortTD ( 3 )">▲</button><button onclick="reverseTD ( 3 )">▼</button> </th>
		</tr>
	</thead>
  	<tbody>
		<c:forEach items="${list}" var="dto">
			<tr class="sorting">
<%--   		<td><img src="images/${dto.product_storedname }.png" alt="이미지"> --%>
				<td>${dto.product_rank}</td>
				<td>${dto.product_brand}</td>
				<td><a href="productdetail.do?no=${dto.product_no}&ingre=${dto.product_ingre}">${dto.product_name} </a></td>
				<td>
					<c:choose>
						<c:when test="${dto.product_pointcount == 0}">
							평점 없음
						</c:when>
						<c:otherwise>
						<fmt:formatNumber value="${dto.product_point }" pattern=".00" /> / ${dto.product_pointcount }
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
		</div>
	</section>

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