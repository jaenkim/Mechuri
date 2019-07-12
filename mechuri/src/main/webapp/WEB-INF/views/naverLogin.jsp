<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>LoginTest</title>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<style type="text/css">
html, div, body, h3 {
	margin: 0;
	padding: 0;
}

h3 {
	display: inline-block;
	padding: 0.6em;
}
</style>
</head>
<body>



	<div
		style="background-color: #15a181; width: 100%; height: 50px; text-align: center; color: white;">
		<h3>SIST Login</h3>
	</div>
	<br>
	<form action="callback.do" method="post">
		<input type="hidden" value="naver_id_login" />
		<div id="naver_id_login"></div>
	</form>
	<!-- 네이버아이디로로그인 버튼 노출 영역 -->
<!-- 네이버 로그인 화면에서 ID, PW를 올바르게 입력하면 callback 메소드 실행 요청 -->
<div id="naver_id_login" style="text-align:center"><a href="${url}"><img width="223" src="${pageContext.request.contextPath}/resources/img/naver_Bn_Green.PNG"/></a></div>

	<script type="text/javascript">
 		var naver_id_login = new naver_id_login("_1g9pc8r0RyK3g8Zeg9_", "http://localhost:8888/mechuri/callback.do");	// Client ID, CallBack URL 삽입
											// 단 'localhost'가 포함된 CallBack URL
 		var state = naver_id_login.getUniqState();
		
 		naver_id_login.setButton("white", 2, 40);
 		naver_id_login.setDomain("http://localhost:8888/mechuri/naverLogin.do");	//  URL
 		naver_id_login.setState(state);
 		naver_id_login.setPopup();
 		naver_id_login.init_naver_id_login();
	</script>
	<br>
</body>
</html>