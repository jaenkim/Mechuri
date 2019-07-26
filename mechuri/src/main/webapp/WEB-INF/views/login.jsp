<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html;charset=UTF-8");
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<script type="text/javascript" src="../js/botstrap.js">
	$(function(){ //페이지 로딩이 완료된 후 자동 실행
		$("#btnLogin").click(fucntion(){
			var mem_id=$("#mem_id").val(); //태그에 입력된 값
			var mem_pw=$("#mem_pw").val();
			if(mem_id=="") {
				alert("아이디를 입력하세요.");
				$("#mem_id").focus(); //태그에 입력포커스이동
				return;
			}
			if(mem_pw=="") {
				alert("비밀번호를 입력하세요.");
				$("#mem_pw").focus();
				return;
			}
			document.form1.action
			="${path}/login_check.do";
			document.form1.submit(); //서버에 자료 전송
		});
	});
</script>

<!-- 네이버아이디로로그인 버튼 노출 영역 -->
<script type="text/javascript">
 		var naver_id_login = new naver_id_login("_1g9pc8r0RyK3g8Zeg9_", "http://localhost:8888/mechuri/callback.do");	// Client ID, CallBack URL 삽입
											// 단 'localhost'가 포함된 CallBack URL
 		var state = naver_id_login.getUniqState();
		
 		naver_id_login.setButton("white", 2, 40);
 		naver_id_login.setDomain("http://localhost:8888/mechuri/login.do");	//  URL
 		naver_id_login.setState(state);
 		naver_id_login.setPopup();
 		naver_id_login.init_naver_id_login();
	</script>
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일반회원 로그인 화면</title>
</head>

<body>
<jsp:include page="Header.jsp" />
	<br>
	<br>
	<br>
	<br>
	<br>
	<center>
		<form name="form1" id="form1" method="post" action="login_check.do">

			<!-- <div class="board_list"> -->
			<div class="6u$ 12u$(xsmall)">
				<input type="text" id="mem_id" name="mem_id" class="wdp_90"
					placeholder="아이디" style="font-size:13px; width:31%">
			</div>
	<!-- </div> -->
			<div class="field_container">
			<div class="6u$ 12u$(xsmall)">
			<br>
				<input type="Password" id="mem_pw" name="mem_pw" class="wdp_90"
					placeholder="비밀번호" style="font-size:13px; width:31%"> <br>
				<button class="button special" id="btn_area">
					<span class="btn" id="btnLogin" class="button" background-color="#f6755e" text-align:center;>로그인</span> <br> <br>
				</button> 
			</div>
			</div>
		</form>
	</center>

	<c:if test="${message == 'error' }">
		<div style="color: red;">아이디 또는 비밀번호가 일치하지 않습니다.</div>
	</c:if>
	<c:if test="${message == 'logout' }">
		<div style="color: red;">로그아웃 되었습니다.</div>
	</c:if>
	<br>
	<div class="idpw" style="text-align: center">
	<center>
		<a href="searchAccount.do" class="login_link">아이디찾기|</a> <a href="pwFindForm.do"
			class="login_link">비밀번호찾기|</a> <a href="signUp.do" class="login_link">회원가입</a>
	</center>
	</div>
<br>
		<div id="naver_id_login" style="text-align: center">
			<a href="${url}"> <img width="223"
				src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png" /></a>
		</div>
		<br>

		<div class="clearfix"></div>
	
	<jsp:include page="Footer.jsp" />
	
</body>
</html>