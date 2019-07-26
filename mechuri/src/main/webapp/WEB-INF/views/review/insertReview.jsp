<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% response.setContentType("text/html;charset=UTF-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script language="javascript">
	function SetValue(this){
		range_val.value = this.value;
	}
</script>
<link rel="stylesheet" href="commAssets/css/boarddetail.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 별점 부트스트랩, 	css, js -->
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="assets/css/style.main2.css">
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

<title>리뷰: ${product.product_name }</title>


<script type="text/javascript">
 $(function(){ 
	$('.starRev > span').mouseenter(function(){
	  $(this).parent().children('span').removeClass('on'); 
  $(this).addClass('on').prevAll('span').addClass('on');
		  return false; 
	}); 
	$(".starR1,.starR2").mouseover(function(){ 
$("input[name=review_rating]").val(($(".on").length)/2);
	});
	
  }); 
</script>
</head>
<body>
<jsp:include page="../Header.jsp"/>
<section id="main" class="wrapper">
				<div class="inner">
					<header class="align-center">
						<c:choose>
						<c:when test="${naverNickname!=null}">
							<h2> ${naverNickname}님께서 사용해보신 <br /> ${product.product_name }의 리뷰를 작성해주세요 :)</h2>
						</c:when>
						<c:when test="${mem_nick!=null}">
							<h2> ${mem_nick}님께서 사용해보신 <br /> ${product.product_name }의 리뷰를 작성해주세요 :)</h2>
						</c:when>
						<c:otherwise>
						
						</c:otherwise>
					</c:choose>
					</header>
					<hr>
					<!-- 리뷰 작성하는 부분 -->
					<div>
					<form action = "insertReview.do?product_no=${product.product_no }&writer=${writer}&callbackIngre=${callbackIngre}" method="post" enctype="multipart/form-data">
						<table style="border-width: 0px;">
							<tr style="border-width: 0px;">
								<td style="width: 30%; background-color: #ffffff; border-width: 0px;"><h3>별점</h3><h5>(별점은 5점 만점으로 표시해주세요)</h5></td>
								<td style="width: 30%; background-color: #ffffff; border-width: 0px;">
										<input type="hidden" name="review_rating" >	
											<script type="text/javascript">
											$(function(){
												var rate=$(".starRev").find("input[name=rate]").val();
												var k=0; 
												for(var i=0;i<parseFloat (rate);i+=0.5){
													  $(".starRev>span").eq(k).addClass('on');
													  k++; }
											$(this).parent().children('span').removeClass('on');
											}); 
											</script>
											
											<!-- 별모양 -->
											<div class="starRev">
												<span class="starR1">별1_왼쪽</span> <span class="starR2">별1_오른쪽</span>
												<span class="starR1">별2_왼쪽</span> <span class="starR2">별2_오른쪽</span>
												<span class="starR1">별3_왼쪽</span> <span class="starR2">별3_오른쪽</span>
												<span class="starR1">별4_왼쪽</span> <span class="starR2">별4_오른쪽</span>
												<span class="starR1">별5_왼쪽</span> <span class="starR2">별5_오른쪽</span>
												<input type="hidden" name="rate" value="" />
											</div>
							</td>
						</table>
						<table>
							<tr>
								<td style="width: 15%; background-color: #ffffff; border-width: 0px;"><h3>내용</h3><h5>(200자 이내로 작성해주세요.)</h5></td>
								<td style="width: 85%; background-color: #ffffff; border-width: 0px;"><input type="text" id="content" name="reviewconts" required="required" style="height:200px; width:80%; margin:auto;" > </td>
							</tr>
							<tr>
								<td><input type="file" name="filename" onchange="javascript:document.getElementById('file_route').value=this.value"/>
										<input type="text" readonly="readonly" title="File Route" id="file_route" />
								</td>
							</tr>
						</table>
					<input type="submit" value="작성완료" class="button small fit" style="float: right;"/>
					</form>
									
		</div>
	</section>
</body>
</html>