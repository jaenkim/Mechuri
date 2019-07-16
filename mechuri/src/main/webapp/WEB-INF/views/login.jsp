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

	<br>
	<br>
	<br>
	<br>
	<br>
	<center>
		<form name="form1" id="form1" method="post" action="login_check.do">


			<!-- <로그인 화면><br>
<input type="text" name="id" maxlength="20" placeholder="아이디"
			onchange='checkIdAjax(this.value)'
			style="width: 250px; height: 35px; font-size: 17px; margin-top: 10px;"><br>
            
<input type='password' name='pw' id='pwid'
			onchange='isSame()' maxlength="20" placeholder="비밀번호"
			style="width: 250px; height: 35px; font-size: 17px; margin-top: 10px;"><br>
			
<input type='button' value='가입하기'id='newbtn' style="width: 250px; height: 35px; font-size: 17px; margin-top: 10px;">
 -->


			<div class="board_list">
				<input type="text" id="mem_id" name="mem_id" class="wdp_90"
					placeholder="아이디">
			</div>

			<div class="field_container">
				<input type="Password" id="mem_pw" name="mem_pw" class="wdp_90"
					placeholder="비밀번호"> <br>
				<button id="btn_area">
					<span class="btn" id="btnLogin">로그인</span> <br> <br>
				</button>
			</div>
		</form>
	</center>




	<%-- <center> --%>
	<%-- <c:choose> --%>
	<%-- <c:when test="${sessionId != null}"> --%>
	<!-- <h2> 네이버 아이디 로그인 성공하셨습니다!! </h2> -->
	<%-- <h3>'${sessionId}' 님 환영합니다! </h3> --%>
	<!-- <h3><a href="logout">로그아웃</a></h3> -->
	<%-- </c:when> --%>
	<%-- <c:otherwise> --%>
	<!-- <form action="login.do" method="post" name="frm" style="width:470px;"> -->
	<!-- <h2>로그인</h2> -->
	<!-- </form> -->
	<!-- <br> -->
	<!-- <!-- 네이버 로그인 창으로 이동 -->
	-->
	<%-- <div id="naver_id_login" style="text-align:center"><a href="${url}"> --%>
	<!-- <img width="223" src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"/></a></div> -->
	<!-- <br> -->
	<%-- </c:otherwise> --%>
	<%-- </c:choose> --%>
	<%-- </center> --%>




	<c:if test="${message == 'error' }">
		<div style="color: red;">아이디 또는 비밀번호가 일치하지 않습니다.</div>
	</c:if>
	<c:if test="${message == 'logout' }">
		<div style="color: red;">로그아웃 되었습니다.</div>
	</c:if>
	<br>
	<div class="idpw">
		<a href="#" class="login_link">아이디찾기|</a> <a href="#"
			class="login_link">비밀번호찾기|</a> <a href="signUp.do" class="login_link">회원가입</a>
	</div>


	<div id="sign_in_options" class="field_container">
		<div id="sign_in_alternatives_container">
			<span id="google_sign_in_option">or you can <a href="#"
				id="google_sign_in" class="login_link">sign in with Google</a></span> 
			<span	id="password_sign_in_option">or you can <a href="#"
				id="password_sign_in" class="login_link">sign in using a
					password</a></span>
		</div>
	</div>
	<div id="remember_me_container">

		<input name="user[remember_me]" type="hidden" value="0">
		<input	id="user_remember_me" name="user[remember_me]" type="checkbox"
			value="1"> <label class="login_link" for="user_remember_me"
			id="remember_me_label">stay signed in</label>

		<div id="naver_id_login" style="text-align: center">
			<a href="${url}"> <img width="223"
				src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png" /></a>
		</div>
		<br>

		<div class="clearfix"></div>
	</div>

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
	<jsp:include page="Footer.jsp" />
	
</body>
</html>