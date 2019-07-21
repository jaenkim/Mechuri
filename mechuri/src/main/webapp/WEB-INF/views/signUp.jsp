<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html;charset=UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	function checkz() { //아이디(이메일형식), 비밀번호, 비밀번호 확인 유효성 검사
		var getCheck = RegExp(/^[a-zA-Z0-9]{4,12}$/);
		var getId = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
		var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);

		if (!getCheck.test($("#tbPwd").val())) {
			alert("pw를 형식에 맞게 입력해주세요");
			$("#tbPwd").val("");
			$("#tbPwd").focus();
			return false;
		}
		if ($("#tbPwd").val() != ($("#cpass").val())) {
			alert("비밀번호가 틀렸습니다. 다시 입력해 주세요");
			$("#tbPwd").val("");
			$("#cpass").val("");
			$("#tbPwd").focus();
			return false;
		}
		//이메일 공백 확인
		if ($("#mem_id").val() == "") {
			alert("아이디를 입력해주세요");
			$("#mem_id").focus();
			return false;
		}
		//이메일 유효성 검사
		if (!getMail.test($("#mem_id").val())) {
			alert("아이디를 형식에 맞게 입력해주세요")
			$("#mem_id").val("");
			$("#mem_id").focus();
			return false;
		}
	}

	function mailChk() {
		var email = $("#mem_id").val();

		$.ajax({
			type : "POST",
			url : "./mail.do",
			data : "mem_id=" + email,
			async : true,
			success : function(msg) {
				$("#hid").val(msg);
				$("#bt").attr("disabled", true);
				$("#btn").attr("disabled", false);

				alert("메일로 인증코드를 전송하였습니다.");
			}
		});
	}

	function keyChk() {
		if ($("#insrt").val() == $("#hid").val()) {
			alert("인증확인완료");
			$("#sbm").attr("disabled", false);
		} else {
			alert("잘못된 인증번호 입니다. 다시 한 번 확인해 주세요.");
		}
	}

	function idcheck() {
		var email = $("#mem_id").val();

		$.ajax({
			type : "POST",
			url : "./idcheck.do",
			data : "mem_id=" + email,
			async : true,
			success : function(msg) {
				if (msg == "a") {
					alert("사용 가능한 아이디입니다.")
				} else {
					alert("이미 존재하는 아이디입니다.")
				}
			}

		});
	}
</script>

<style>
* {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

body {
	font-family: "Montserrat-Regular"; : #999;
	font-size: 12px;
	margin: 0;
}

p, h1, h2, h3, h4, h5, h6, ul {
	margin: 0;
}

img {
	max-width: 100%;
}

ul {
	padding-left: 0;
	margin-bottom: 0;
}

a {
	text-decoration: none; : # ff9a9c;
	transition: all 0.3s ease;
}

a:hover {
	text-decoration: none;
	:
	#
	fe4447;
}

:focus {
	outline: none;
}

.wrapper {
	min-height: 100vh;
	display: flex;
	align-items: center;
	background: url("../images/bg-registration-form-4.jpg") no-repeat;
	background-size: cover;
}

.inner {
	max-width: 850px;
	margin: auto;
	background: #fff;
	display: flex;
	box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.2);
	-webkit-box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.2);
	-ms-box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.2);
	-o-box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.2);
}

.image-holder {
	width: 50%;
	padding-right: 15px;
}

form {
	padding: 20% 20% 20% 20%;
	text-align: center;
}

h3 {
	font-size: 35px;
	font-family: "ElMessiri-SemiBold";
	text-align: center;
	margin-bottom: 27px;
	:
	#
	ff9a9c;
}

.form-holder {
	padding-left: 42%;
}

.form-control {
	display: block;
	width: 100%;
	border-radius: 23.5px;
	height: 47px;
	padding: 0 24px; : #808080;
	font-size: 13px;
	border: none;
	background: #f7f7f7;
	margin-bottom: 25px;
}

.form-control::-webkit-input-placeholder {
	font-size: 13px; : #808080;
	text-transform: uppercase;
	font-family: "Montserrat-Regular";
}

.form-control::-moz-placeholder {
	font-size: 13px; : #808080;
	text-transform: uppercase;
	font-family: "Montserrat-Regular";
}

.form-control:-ms-input-placeholder {
	font-size: 13px; : #808080;
	text-transform: uppercase;
	font-family: "Montserrat-Regular";
}

.form-control:-moz-placeholder {
	font-size: 13px; : #808080;
	text-transform: uppercase;
	font-family: "Montserrat-Regular";
}

@
-webkit-keyframes hvr-wobble-horizontal { 16.65% {
	-webkit-transform: translateX(8px);
	transform: translateX(8px);
}

33
.3



 



%
{
-webkit-transform






:



 



translateX






(-6
px




);
transform






:



 



translateX






(-6
px




);
}
49
.95



 



%
{
-webkit-transform






:



 



translateX






(4
px




);
transform






:



 



translateX






(4
px




);
}
66
.6



 



%
{
-webkit-transform






:



 



translateX






(-2
px




);
transform






:



 



translateX






(-2
px




);
}
83
.25



 



%
{
-webkit-transform






:



 



translateX






(1
px




);
transform






:



 



translateX






(1
px




);
}
100%
{
-webkit-transform








:




 




translateX








(0);
transform








:




 




translateX








(0);
}
}
@
keyframes hvr-wobble-horizontal { 16.65% {
	-webkit-transform: translateX(8px);
	transform: translateX(8px);
}

33
.3



 



%
{
-webkit-transform






:



 



translateX






(-6
px




);
transform






:



 



translateX






(-6
px




);
}
49
.95



 



%
{
-webkit-transform






:



 



translateX






(4
px




);
transform






:



 



translateX






(4
px




);
}
66
.6



 



%
{
-webkit-transform






:



 



translateX






(-2
px




);
transform






:



 



translateX






(-2
px




);
}
83
.25



 



%
{
-webkit-transform






:



 



translateX






(1
px




);
transform






:



 



translateX






(1
px




);
}
100%
{
-webkit-transform








:




 




translateX








(0);
transform








:




 




translateX








(0);
}
}
button {
	letter-spacing: 2px;
	border: none;
	width: 133px;
	height: 47px;
	margin-right: 19px;
	border-radius: 23.5px;
	cursor: pointer;
	display: flex;
	align-items: center;
	justify-content: center;
	padding: 0;
	background: #ff9a9c;
	font-size: 15px; : # fff;
	text-transform: uppercase;
	font-family: "Montserrat-SemiBold";
	-webkit-transform: perspective(1px) translateZ(0);
	transform: perspective(1px) translateZ(0);
	box-shadow: 0 0 1px rgba(0, 0, 0, 0);
}

button:hover {
	-webkit-animation-name: hvr-wobble-horizontal;
	animation-name: hvr-wobble-horizontal;
	-webkit-animation-duration: 1s;
	animation-duration: 1s;
	-webkit-animation-timing-function: ease-in-out;
	animation-timing-function: ease-in-out;
	-webkit-animation-iteration-count: 1;
	animation-iteration-count: 1;
}

.checkbox {
	position: relative;
	padding-left: 19px;
	margin-bottom: 37px;
	margin-left: 26px;
}

.checkbox label {
	cursor: pointer;
	:
	#999;
}

.checkbox input {
	position: absolute;
	opacity: 0;
	cursor: pointer;
}

.checkbox input:checked ~ .checkmark:after {
	display: block;
}

.checkmark {
	position: absolute;
	top: 2px;
	left: 0;
	height: 10px;
	width: 10px;
	border-radius: 50%;
	border: 1px solid #e7e7e7;
}

.checkmark:after {
	content: "";
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 4px;
	height: 4px;
	border-radius: 50%;
	background: #ff9a9c;
	position: absolute;
	display: none;
}

display








:




 




flex








;
align-items








:




 




center








;
margin-left








:




 




23
px








;
}
@media ( max-width : 100px) {
	.inner {
		display: block;
	}
	.image-holder {
		width: 100%;
		padding-right: 0;
	}
	form {
		align: center;
		padding: 0px 15px 70px;
	}
	.wrapper {
		background: none;
	}
}

.inner {
	align: center;
}

input {
	align: center;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일반 회원가입 페이지</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<form action='signUpBoard.do' method='post'>
		<br> <br> <br>

		<!-- <div class="inner"> -->

		<h3>일반회원 가입</h3>


		<div class="form-holder" style="text-align: center">
			<input type="button" value="아이디중복확인" id="btbt" onclick="idcheck()" /> <input
				type="text" placeholder="ex)aaa@gmail.com" name="mem_id" id="mem_id"
				class="form-control" /> <input type="button" value="아이디인증" id="bt"
				onclick="mailChk()" /> <input type="hidden" id="hid"> <input
				type="text" id="insrt" placeholder="인증번호를 입력해주세요.">
			<center>
				<input type="button" class="btn-success" id="btn"
					disabled="disabled" onclick="keyChk()" value="인증">
			</center>
		</div>


		<div class="form-holder">
			<input type="text" placeholder="비밀번호(영문+숫자,4-12글자)" name="mem_pw" id="tbPwd"
				class="form-control">
		</div>
		<div class="form-holder">
			<input type="password" placeholder="비밀번호 확인" class="form-control" id="cpass"
				style="font-size: 15px;">
		</div>
		<div class="form-holder">
			<input type="text" placeholder="이름" name="mem_name"
				class="form-control" style="font-size: 15px;">
		</div>
		<div class="form-holder">
			<input type="text" placeholder="별명" name="mem_nick"
				class="form-control" style="font-size: 15px;">
		</div>
		<div class="form-holder">
			<input type="text" placeholder="핸드폰" name="mem_phone"
				class="form-control" style="font-size: 15px;">
		</div>
		<div class="checkbox"></div>

		<button input type="submit" id="sbm">회원가입하기</button>

	</form>
	<!-- 	</div>  -->



	<jsp:include page="Footer.jsp" />

</body>
</html>