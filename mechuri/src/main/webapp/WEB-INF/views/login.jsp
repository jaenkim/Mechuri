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

<!-- <script type="text/javascript">
$(function(){
    var naverLogin = new naver.LoginWithNaverId({
        clientId: "{_1g9pc8r0RyK3g8Zeg9_}",
        callbackUrl: "{http://localhost:8888/mechuri/callback.do}",
        isPopup: true,
        loginButton: {color: "green", type: 3, height: 45}
    });
    naverLogin.init();
})//e.o.naver -->


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
		};
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

<center>
<c:choose>
<c:when test="${sessionId != null}">
<h2> 네이버 아이디 로그인 성공하셨습니다!! </h2>
<h3>'${sessionId}' 님 환영합니다! </h3>
<h3><a href="logout">로그아웃</a></h3>
</c:when>
<c:otherwise>
<form action="login.do" method="post" name="frm" style="width:470px;">
<h2>로그인</h2>
<input type="text" name="id" id="id" class="w3-input w3-border" placeholder="아이디" value="${id}"> <br>
<input type="password" id="pwd" name="pwd" class="w3-input w3-border" placeholder="비밀번호" >	<br>
<input type="submit" value="로그인" onclick="#"> <br>
</form>
<br>
<!-- 네이버 로그인 창으로 이동 -->
<div id="naver_id_login" style="text-align:center"><a href="${url}">
<img width="223" src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"/></a></div>
<br>
</c:otherwise>
</c:choose>
</center>



	<jsp:include page="Footer.jsp" />
</body>
</html>