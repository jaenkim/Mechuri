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
	<!-- 네이버아이디로로그인 버튼 노출 영역 -->
				
			<!-- //네이버아이디로로그인 버튼 노출 영역 -->

				<!-- 네이버아디디로로그인 초기화 Script -->
			<script type="text/javascript">
				var naverLogin = new naver.LoginWithNaverId(
				{
					clientId: "_1g9pc8r0RyK3g8Zeg9_",
					callbackUrl: "http://localhost:8888/mechuri/callback.do",
					isPopup: false, /* 팝업을 통한 연동처리 여부 */
					loginButton: {color: "green", type: 3, height: 50 } /* 로그인 버튼의 타입을 지정 */
				}
			);
	
			/* 설정정보를 초기화하고 연동을 준비 */
			naverLogin.init();
	
			</script>
    
<!-- // 네이버아이디로로그인 초기화 Script -->
	<br>
</body>
</html>