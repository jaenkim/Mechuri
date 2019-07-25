<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일반 회원가입 페이지</title>
</head>
<body>
	<jsp:include page="Header.jsp" />

	<form action='signUpBoard.do' method='post'>
	
<section id="main" class="wrapper">
	<div class="inner">
	  <header class="align-center">
		<h1>회원가입</h1>
		</header>
			<input type="hidden" value="${mem_naverid}" name="mem_naverid"  />
			<div style="margin-left:450px;">
		<div class="form-holder">
		아이디:<input type="text" value="${mem_id}" name="mem_id"
				class="form-control" readonly="readonly"  style="width:35%;display:inline-block; margin-right:70%; margin-top:10px;" >
		</div>
		<div class="form-holder">
			<input type="hidden" placeholder="네이버 로그인 비밀번호와 동일합니다." name="mem_pw"
				class="form-control" readonly="readonly" style="width:35%;display:inline-block; margin-right:70%; margin-top:10px;">
		</div>
		<div class="form-holder">
			이름:<input type="text" value="${mem_name }" name="mem_name"
				class="form-control" readonly="readonly" style="font-size: 15px; width:35%;display:inline-block; margin-right:70%; margin-top:10px;">
		</div>
		<div class="form-holder">
			닉네임:<input type="text" value="${mem_nick }"  name="mem_nick"
				class="form-control" readonly="readonly" style="font-size: 15px; width:35%;display:inline-block; margin-right:70%; margin-top:10px;">
		</div>
		<div class="form-holder">
			전화번호:<input type="text" placeholder="핸드폰" name="mem_phone"
				class="form-control" style="font-size: 15px; width:35%;display:inline-block; margin-right:70%; margin-top:10px;">
		</div>
		

		<button  type="submit" style="margin-bottom: 10px; margin-top:40px; margin-left:40px;">회원가입하기</button>
</div>
</div>
</section>
	</form>
	

	<jsp:include page="Footer.jsp" />

</body>
</html>