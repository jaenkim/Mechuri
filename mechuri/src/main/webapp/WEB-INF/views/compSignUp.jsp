<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
    /*             // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                } */

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
<!-- <style>


* {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box; }

body {
  font-family: "Montserrat-Regular";
  color: #999;
  font-size: 12px;
  margin: 0; }

p, h1, h2, h3, h4, h5, h6, ul {
  margin: 0; }

img {
  max-width: 100%; }

ul {
  padding-left: 0;
  margin-bottom: 0; }

a {
  text-decoration: none;
  color: #ff9a9c;
  transition: all 0.3s ease; }
  a:hover {
    text-decoration: none;
    color: #fe4447; }

:focus {
  outline: none; }

.wrapper {
  min-height: 100vh;
  display: flex;
  align-items: center;
  background: url("../images/bg-registration-form-4.jpg") no-repeat;
  background-size: cover; }

.inner {
  max-width: 850px;
  margin: auto;
  background: #fff;
  display: flex;
  box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.2);
  -webkit-box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.2);
  -moz-box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.2);
  -ms-box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.2);
  -o-box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.2); }

.image-holder {
  width: 50%;
  padding-right: 15px; }

form {
  padding: 20% 20% 20% 20%;

   text-align:center; 
  }

h3 {
  font-size: 35px;
  font-family: "ElMessiri-SemiBold";
  text-align: center;
  margin-bottom: 27px;
  color: #ff9a9c; }

.form-holder {
    padding-left: 42%;  
 /*   border:1px solid red; */
   }
  

.form-control {
  display: block;
  width: 100%;
  border-radius: 23.5px;
  height: 47px;
  padding: 0 24px;
  color: #808080;
  font-size: 13px;
  border: none;
  background: #f7f7f7;
  margin-bottom: 25px; }
  .form-control::-webkit-input-placeholder {
    font-size: 13px;
    color: #808080;
    text-transform: uppercase;
    font-family: "Montserrat-Regular"; }
  .form-control::-moz-placeholder {
    font-size: 13px;
    color: #808080;
    text-transform: uppercase;
    font-family: "Montserrat-Regular"; }
  .form-control:-ms-input-placeholder {
    font-size: 13px;
    color: #808080;
    text-transform: uppercase;
    font-family: "Montserrat-Regular"; }
  .form-control:-moz-placeholder {
    font-size: 13px;
    color: #808080;
    text-transform: uppercase;
    font-family: "Montserrat-Regular"; }

@-webkit-keyframes hvr-wobble-horizontal {
  16.65% {
    -webkit-transform: translateX(8px);
    transform: translateX(8px); }
  33.3% {
    -webkit-transform: translateX(-6px);
    transform: translateX(-6px); }
  49.95% {
    -webkit-transform: translateX(4px);
    transform: translateX(4px); }
  66.6% {
    -webkit-transform: translateX(-2px);
    transform: translateX(-2px); }
  83.25% {
    -webkit-transform: translateX(1px);
    transform: translateX(1px); }
  100% {
    -webkit-transform: translateX(0);
    transform: translateX(0); } }
@keyframes hvr-wobble-horizontal {
  16.65% {
    -webkit-transform: translateX(8px);
    transform: translateX(8px); }
  33.3% {
    -webkit-transform: translateX(-6px);
    transform: translateX(-6px); }
  49.95% {
    -webkit-transform: translateX(4px);
    transform: translateX(4px); }
  66.6% {
    -webkit-transform: translateX(-2px);
    transform: translateX(-2px); }
  83.25% {
    -webkit-transform: translateX(1px);
    transform: translateX(1px); }
  100% {
    -webkit-transform: translateX(0);
    transform: translateX(0); } }
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
  font-size: 15px;
  color: #fff;
  text-transform: uppercase;
  font-family: "Montserrat-SemiBold";
  -webkit-transform: perspective(1px) translateZ(0);
  transform: perspective(1px) translateZ(0);
  box-shadow: 0 0 1px rgba(0, 0, 0, 0); }
  button:hover {
    -webkit-animation-name: hvr-wobble-horizontal;
    animation-name: hvr-wobble-horizontal;
    -webkit-animation-duration: 1s;
    animation-duration: 1s;
    -webkit-animation-timing-function: ease-in-out;
    animation-timing-function: ease-in-out;
    -webkit-animation-iteration-count: 1;
    animation-iteration-count: 1; }

.checkbox {
  position: relative;
  padding-left: 19px;
  margin-bottom: 37px;
  margin-left: 26px; }
  .checkbox label {
    cursor: pointer;
    color: #999; }
  .checkbox input {
    position: absolute;
    opacity: 0;
    cursor: pointer; }
  .checkbox input:checked ~ .checkmark:after {
    display: block; }

.checkmark {
  position: absolute;
  top: 2px;
  left: 0;
  height: 10px;
  width: 10px;
  border-radius: 50%;
  border: 1px solid #e7e7e7; }
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
    display: none; }


  display: flex;
  align-items: center;
  margin-left: 23px; }

@media (max-width: 100px) {
  .inner {
    display: block; }

  .image-holder {
    width: 100%;
    padding-right: 0; }

  form {
    align:center;
    padding: 0px 15px 70px; }

  .wrapper {
    background: none; } }

.inner {
	align:center;
}

 input { 
 	align:center; 
 } 
#sample4_button {
/* 	position : static; */
/* 	bottom:128px; */
/* 	top:18px; */
/*  	margin: 20px 0px;  */
 	display: block;
}

</style> -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기업 회원가입 페이지</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<form action='compSignUpBoard.do' method='post'>
		<br> <br> <br>

		<!-- <div class="inner"> -->


		<div class="form-holder" style="text-align: center">
			<center>
				<h3>기업회원 가입</h3>
				<input type="text" placeholder="브랜드명" name="mem_brand"
					class="form-control" style="font-size: 13px;">
			</center>
		</div>



		<div class="form-holder" style="text-align: center">
			<div class="well">
				<center>
					<input type="text" id="sample4_postcode" name="mem_post"
						placeholder="우편번호" style="font-size: 13px;"><br> <input
						type="button" id="sample4_button"
						onclick="sample4_execDaumPostcode()" value="우편번호 찾기"
						style="font-size: 13px;"><br> <input type="text"
						id="sample4_roadAddress" name="mem_addr1" placeholder="도로명주소"
						style="font-size: 13px;"><br> <input type="text"
						id="sample4_jibunAddress" name="mem_addr2" placeholder="지번주소"
						style="font-size: 13px;"><br> <input type="text"
						id="sample4_detailAddress" name="mem_others01" placeholder="상세주소"
						style="font-size: 13px;">
				</center>
			</div>
		</div>
		<br>

		<div class="form-holder" style="text-align: center">
			<center>
				<input type="text" placeholder="홈페이지" name="mem_homepage"
					class="form-control" style="font-size: 13px;">
			</center>
		</div>
		<br>

		<div class="form-holder" style="text-align: center">
			<center>
				<h3>담당자 정보</h3>
				<input type="text" placeholder="아이디" name="mem_id"
					class="form-control" style="font-size: 13px;">
			</center>
		</div>
		<div class="form-holder" style="text-align: center">
			<center>
				<input type="password" placeholder="비밀번호" name="mem_pw"
					class="form-control" style="font-size: 13px;">
			</center>
		</div>
		<div class="form-holder" style="text-align: center">
			<center>
				<input type="password" placeholder="비밀번호확인" class="form-control"
					style="font-size: 13px;">
			</center>
		</div>
		<div class="form-holder" style="text-align: center">
			<center>
				<input type="text" placeholder="담당자명" name="mem_name"
					class="form-control" style="font-size: 13px;">
			</center>
		</div>
		<div class="form-holder" style="text-align: center">
			<center>
				<input type="email" placeholder="이메일" name="mem_email"
					class="form-control" style="font-size: 13px;">
			</center>
		</div>
		<div class="form-holder" style="text-align: center">
			<center>
				<input type="text" placeholder="연락처" name="mem_phone"
					class="form-control" style="font-size: 13px;">
			</center>
		</div>
		<div style="text-align: center">
			<center>
				<button input type="submit" style="background-color: #f6755e;"
					style="font-size:13px;">회원가입하기</button>
			</center>
		</div>
	</form>
	<!-- 	</div>  -->



	<jsp:include page="Footer.jsp" />
</body>
</html>