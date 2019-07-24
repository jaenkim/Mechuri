<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/style.main.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css?family=Cute+Font|Gamja+Flower|Nanum+Gothic|Noto+Sans+KR|Noto+Serif+KR|Poor+Story&display=swap" rel="stylesheet">
<title>Mechuri</title>
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
			<section id="two" class="wrapper style1 special">
				<h2 style="text-align: center;">랭킹 헤더</h2>
				<div class="inner flex flex-3">
					<div class="flex-item box">
						<div class="image fit">
							<img src="images/pic02.jpg" alt="" />
						</div>
						<div class="content">
							<h3>Consequat</h3>
							<p>Placerat ornare. Pellentesque od sed euismod in, pharetra ltricies edarcu cas consequat.</p>
						</div>
					</div>
					<div class="flex-item box">
						<div class="image fit">
							<img src="images/pic03.jpg" alt="" />
						</div>
						<div class="content">
							<h3>Adipiscing</h3>
							<p>Morbi in sem quis dui placerat Pellentesque odio nisi, euismod pharetra lorem ipsum.</p>
						</div>
					</div>
					<div class="flex-item box">
						<div class="image fit">
							<img src="images/pic04.jpg" alt="" />
						</div>
						<div class="content">
							<h3>Malesuada</h3>
							<p>Nam dui mi, tincidunt quis, accu an porttitor, facilisis luctus que metus vulputate sem magna.</p>
						</div>
					</div>
				</div>
			</section>
			
		<!-- Two_커뮤니티-->
		<section id="three" class="wrapper">
			<h2 style="text-align: center;">메추리톡 헤더</h2>
				<div class="inner flex flex-3">
					<div class="flex-item box">
						<div class="image fit">
							<img src="images/new1.jpg" alt="" />
						</div>
						<div class="content">
							<h3>Consequat</h3>
							<p>Placerat ornare. Pellentesque od sed euismod in, pharetra ltricies edarcu cas consequat.</p>
						</div>
					</div>
					<div class="flex-item box">
						<div class="image fit">
							<img src="images/pic03.jpg" alt="" />
						</div>
						<div class="content">
							<h3>Adipiscing</h3>
							<p>Morbi in sem quis dui placerat Pellentesque odio nisi, euismod pharetra lorem ipsum.</p>
						</div>
					</div>
					<div class="flex-item box">
						<div class="image fit">
							<img src="images/pic04.jpg" alt="" />
						</div>
						<div class="content">
							<h3>Malesuada</h3>
							<p>Nam dui mi, tincidunt quis, accu an porttitor, facilisis luctus que metus vulputate sem magna.</p>
						</div>
					</div>
				</div>
			</section>


	<jsp:include page="../Footer.jsp" />


</body>

</html>