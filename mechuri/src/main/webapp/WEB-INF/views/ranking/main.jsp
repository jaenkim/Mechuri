<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css?family=Cute+Font|Gamja+Flower|Nanum+Gothic|Noto+Sans+KR|Noto+Serif+KR|Poor+Story&display=swap" rel="stylesheet">
<title>Mechuri</title>
<style>
.flex11 {
  
    display: inline-block;
    flex-wrap: nowrap;
    justify-content: space-between;
    align-items: stretch;
}

.flex12 {
  
    display: inline-block;
    flex-wrap: nowrap;
    justify-content: space-between;
    align-items: stretch;
}

.inner11 {
    margin: 10px;
    max-width: 65em;
}

.wrapper11{
	padding: 0 0 1em 0;
}

.wrapper22{
	padding: 6em 0 0 0;
}

.style11{
    background: #f6755e;
    color: #fcdcd6;
}

.rimg{
	width: 222px !important; 
	height: 227px; 

}
</style>
</head>
<body>
	<jsp:include page="../Header.jsp" />
		<!-- Banner -->
			<section id="banner">
				<div class="content">
					<h1>당신에게 꼭 맞는 화장품을 찾아보세요</h1>
					<p>수 많은 화장품 중 당신에게 꼭 맞는 화장품은 무엇일까요?<br />함께 찾아봐요. 메추리가 도와드릴게요.</p>
					<ul class="actions">
						<li><a href="list.do" class="button scrolly">시작하기</a></li>
					</ul>
				</div>
			</section>
			
		<!-- One-현재 1위 랭킹 제품 -->
			<section id="two" class="wrapper22 style1 special" style="background-color:#f6755e; color:#fcdcd6;">
				<h1 style="text-align: center; display: inline; color:#ffffff;">메</h1>
				<h4 style="text-align: center; display: inline; color:#ffffff;">이크업&nbsp;&nbsp;</h4>
				<h1 style="text-align: center; display: inline; color:#ffffff;">추</h1>
				<h4 style="text-align: center; display: inline; color:#ffffff;">천&nbsp;&nbsp;</h4>
				<h1 style="text-align: center; display: inline; color:#ffffff;">리</h1>
				<h4 style="text-align: center; display: inline; color:#ffffff;">스트 </h4>
				<br><br><br><br>
				
					<div class="inner11 flex11 flex-3">
					<div class="flex-item box">
						<div class="image fit">
							<c:choose>
								<c:when test="${mainrank[0].product_storedfile==null}">
									<a href="productdetail.do?no=${mainrank[0].product_no}&ingre=${mainrank[0].product_ingre}"><img src="images/product/7.jpg" alt="기초" class="rimg" /></a>
								</c:when>
								<c:otherwise>
									<a href="productdetail.do?no=${mainrank[0].product_no}&ingre=${mainrank[0].product_ingre}"><img src="upload/${mainrank[0].product_storedfile }" alt="기초" class="rimg" /></a>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="content rimg">
							<p>${mainrank[0].product_brand }</p>
							<h3 style="color:#ffffff;">${mainrank[0].product_name }</h3>
							<p>${mainrank[0].product_ml }/${mainrank[0].product_price }</p>
						</div>
					</div>
				</div>	
				
							
				<div class="inner11 flex11 flex-3">
					<div class="flex-item box">
						<div class="image fit">
							<c:choose>
								<c:when test="${mainrank[1].product_storedfile==null}">
									<a href="productdetail.do?no=${mainrank[1].product_no}&ingre=${mainrank[1].product_ingre}"><img src="images/product/10.jpg" alt="베이스" class="rimg" /></a>
								</c:when>
								<c:otherwise>
									<a href="productdetail.do?no=${mainrank[1].product_no}&ingre=${mainrank[1].product_ingre}"><img src="upload/${mainrank[1].product_storedfile }" alt="베이스" class="rimg" /></a>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="content rimg">
							<p>${mainrank[1].product_brand }</p>
							<h3 style="color:#ffffff;">${mainrank[1].product_name }</h3>
							<p>${mainrank[1].product_ml }/${mainrank[1].product_price }</p>
						</div>
					</div>
				</div>
				
				
				<div class="inner11 flex11 flex-3">
					<div class="flex-item box">
						<div class="image fit">
							<c:choose>
								<c:when test="${mainrank[2].product_storedfile==null}">
									<a href="productdetail.do?no=${mainrank[2].product_no}&ingre=${mainrank[2].product_ingre}"><img src="images/product/6.jpg" alt="클렌징" class="rimg" /></a>
								</c:when>
								<c:otherwise>
									<a href="productdetail.do?no=${mainrank[2].product_no}&ingre=${mainrank[2].product_ingre}"><img src="upload/${mainrank[2].product_storedfile }" alt="클렌징" class="rimg" /></a>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="content rimg">
							<p>${mainrank[2].product_brand }</p>
							<h3 style="color:#ffffff;">${mainrank[2].product_name }</h3>
							<p>${mainrank[2].product_ml }/${mainrank[2].product_price }</p>
						</div>
					</div>
				</div>
				
				
					<div class="inner11 flex11 flex-3">
					<div class="flex-item box">
						<div class="image fit">
							<c:choose>
								<c:when test="${mainrank[3].product_storedfile==null}">
								<a href="productdetail.do?no=${mainrank[3].product_no}&ingre=${mainrank[3].product_ingre}">	<img src="images/product/3.jpg" alt="색조" class="rimg" /></a>
								</c:when>
								<c:otherwise>
								<a href="productdetail.do?no=${mainrank[3].product_no}&ingre=${mainrank[3].product_ingre}">	<img src="upload/${mainrank[3].product_storedfile }" alt="색조" class="rimg" /></a>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="content rimg">
							<p>${mainrank[3].product_brand }</p>
							<h3 style="color:#ffffff;">${mainrank[3].product_name }</h3>
							<p>${mainrank[3].product_ml }/${mainrank[3].product_price }</p>
						</div>
					</div>
				</div>
				</section>
					
					<section id="two" class="wrapper11 style special" style="background-color:#f6755e; color:#fcdcd6;">			
					<div class="inner11 flex12 flex-3">
					<div class="flex-item box">
						<div class="image fit">
							<c:choose>
								<c:when test="${mainrank[4].product_storedfile==null}">
								<a href="productdetail.do?no=${mainrank[4].product_no}&ingre=${mainrank[4].product_ingre}">	<img src="images/product/1.jpg" alt="선" class="rimg" /></a>
								</c:when>
								<c:otherwise>
								<a href="productdetail.do?no=${mainrank[4].product_no}&ingre=${mainrank[4].product_ingre}">	<img src="upload/${mainrank[4].product_storedfile }" alt="선" class="rimg" /></a>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="content rimg">
							<p>${mainrank[4].product_brand }</p>
							<h3 style="color:#ffffff;">${mainrank[4].product_name }</h3>
							<p>${mainrank[4].product_ml }/${mainrank[4].product_price }</p>
						</div>
					</div>
				</div>
				
				
					
					<div class="inner11 flex12 flex-3">
					<div class="flex-item box">
						<div class="image fit">
							<c:choose>
								<c:when test="${mainrank[5].product_storedfile==null}">
							<a href="productdetail.do?no=${mainrank[5].product_no}&ingre=${mainrank[5].product_ingre}">		<img src="images/product/5.jpg" alt="바디" class="rimg" /></a>
								</c:when>
								<c:otherwise>
							<a href="productdetail.do?no=${mainrank[5].product_no}&ingre=${mainrank[5].product_ingre}">		<img src="upload/${mainrank[5].product_storedfile }" alt="바디" class="rimg" /></a>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="content rimg">
							<p>${mainrank[5].product_brand }</p>
							<h3 style="color:#ffffff;">${mainrank[5].product_name }</h3>
							<p>${mainrank[5].product_ml }/${mainrank[5].product_price }</p>
						</div>
					</div>
				</div>
				
				
						<div class="inner11 flex12 flex-3">
					<div class="flex-item box">
						<div class="image fit">
							<c:choose>
								<c:when test="${mainrank[6].product_storedfile==null}">
								<a href="productdetail.do?no=${mainrank[6].product_no}&ingre=${mainrank[6].product_ingre}">	<img src="images/product/8.jpg" alt="맘" class="rimg" /></a>
								</c:when>
								<c:otherwise>
								<a href="productdetail.do?no=${mainrank[6].product_no}&ingre=${mainrank[6].product_ingre}">	<img src="upload/${mainrank[6].product_storedfile }" alt="맘" class="rimg" /></a>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="content rimg">
							<p>${mainrank[6].product_brand }</p>
							<h3 style="color:#ffffff;">${mainrank[6].product_name }</h3>
							<p>${mainrank[6].product_ml }/${mainrank[6].product_price }</p>
						</div>
					</div>
				</div>
				
				
					<div class="inner11 flex12 flex-3">
					<div class="flex-item box">
						<div class="image fit">
							<c:choose>
								<c:when test="${mainrank[7].product_storedfile==null}">
								<a href="productdetail.do?no=${mainrank[7].product_no}&ingre=${mainrank[7].product_ingre}">	<img src="images/product/9.jpg" alt="남성" class="rimg" /></a>
								</c:when>
								<c:otherwise>
								<a href="productdetail.do?no=${mainrank[7].product_no}&ingre=${mainrank[7].product_ingre}">	<img src="upload/${mainrank[7].product_storedfile }" alt="남" class="rimg" /></a>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="content rimg">
							<p>${mainrank[7].product_brand }</p>
							<h3 style="color:#ffffff;">${mainrank[7].product_name }</h3>
							<p>${mainrank[7].product_ml }/${mainrank[7].product_price }</p>
						</div>
					</div>
				</div>
				
				
				
				
			</section>
			




		<!-- Two_커뮤니티-->
		<section id="three" class="wrapper">
			<h2 style="text-align: center;">HOT 메추리톡</h2>
			<br><br>
				<div class="inner flex flex-3">
					<c:forEach items="${commu}" var="commu">
					
					<c:choose>
					<c:when test="${commu.board_storedfile eq 'empty' }"> <!-- 펭귄 when은 if문 -->
					<div class="flex-item box" style="margin-right:40px;">
						<div class="image fit">
						<a href="boardDetail.do?board_no=${commu.board_no }"><img src="images/mechu.png" alt="" width="180" height="230" /></a>
						</div>
						<div class="content" style="text-align:center;">
							<h3>${commu.board_title }</h3>
						</div>
						<div style="text-align:center;"><fmt:formatDate value="${commu.board_regdate}" pattern="yyyy-MM-dd"/></div>
						<div style="text-align:center;">조회수: ${commu.board_count}</div>
					</div>
					</c:when>
					<c:otherwise>
					<div class="flex-item box" style="margin-right:40px;">
						<div class="image fit">
						<a href="boardDetail.do?board_no=${commu.board_no }">
						<img src="upload/${commu.board_storedfile }" alt="" width="180" height="230"/></a>
						</div>
						<div class="content" style="text-align:center;">
							<h3>${commu.board_title }</h3>
						</div>
						<div style="text-align:center;"><fmt:formatDate value="${commu.board_regdate}" pattern="yyyy-MM-dd"/></div>
						<div style="text-align:center;">조회수: ${commu.board_count}</div>
					</div>
					</c:otherwise>
					</c:choose>
					</c:forEach>
				</div>
			</section>

	<jsp:include page="../Footer.jsp" />


</body>

</html>