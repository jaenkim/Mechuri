<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html;charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function checkz() { //아이디(이메일형식), 비밀번호, 비밀번호 확인 유효성 검사
		var getCheck = RegExp(/^[a-zA-Z0-9]{4,12}$/);
 		var getId = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
		var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/); 

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

		if (!getCheck.test($("#tbPwd").val())) {
			alert("pw를 형식에 맞게 입력해주세요");
			$("#tbPwd").val("");
			$("#tbPwd").focus();
			return;
		}
		if ($("#tbPwd").val() != ($("#cpass").val())) {
			alert("비밀번호가 다릅니다. 다시 입력해 주세요");
			$("#tbPwd").val("");
			$("#cpass").val("");
			$("#tbPwd").focus();

		} else {
			alert("비밀번호가 일치합니다. 가입을 진행해주세요");
		}
		return;
	}

	// 	function mailChk() {
	// 		var email = $("#mem_id").val();

	// 		$.ajax({
	// 			type : "POST",
	// 			url : "./mail.do",
	// 			data : "mem_id=" + email,
	// 			async : true,
	// 			success : function(msg) {
	// 				$("#hid").val(msg);
	// 				$("#bt").attr("disabled", true);
	// 				$("#btn").attr("disabled", false);

	// 				alert("메일로 인증코드를 전송하였습니다.");
	// 			}
	// 		});
	// 	}

	//아이디 중복체크& 메일 인증 보내기 한번에 하기! (버튼 하나 없애기!)
	function mailChk() {

		var email = $("#mem_id").val();
		var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);

		//이메일 유효성 검사
		if (!getMail.test($("#mem_id").val())) {
			alert("아이디를 형식에 맞게 입력해주세요")
			$("#mem_id").val("");
			$("#mem_id").focus();
			return false;
		}

		$.ajax({
			type : "POST",
			url : "./idcheck.do",
			data : "mem_id=" + email,
			async : true,
			success : function(msg) {
				if (msg == "a") {
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
				} else {
					alert("이미 존재하는 아이디입니다.");
				}
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
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일반 회원가입 페이지</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<form action='signUpBoard.do' method='post' name="sub">
		<br> <br> <br>

		<section class="wrapper" id="main">
		<div style="width:800px; margin: 0 auto;">
			<div class="form-holder">

					<h2>일반회원 가입</h2><a href="compSignUp.do">기업회원 가입 바로가기</a>

					<br><br>
					<div class="6u$ 12u$(xsmall)" style="width:800px;">
						<input type="email" placeholder="ex)aaa@gmail.com" name="mem_id"
							id="mem_id" class="form-control" required="required" style="width:70%;display:inline-block; margin-right: 10px; " />
							
			<input type="button" class="button" value="아이디인증" id="bt" style="display:inline-block; "
				onclick="mailChk()" />
			
					</div>

<!-- 				</center> -->
			</div>
			
			
			<div class="form-holder" >

				<br>
					<div class="6u$ 12u$(xsmall)" style="width:800px;">
						<input type="text" id="insrt" placeholder="인증번호를 입력해주세요." style="width:70%;display:inline-block; margin-right: 10px;"
							style="font-size: 13px;" required="required"> 							
							<input type="hidden" id="hid" />
														<input type="hidden" id="hid" />
							
						<input type="button" class="btn-success" id="btn" disabled="disabled" style="display:inline-block; width:21%"
							onclick="keyChk()" value="인증">
					</div>
				
			</div>
		
			<div class="form-holder">
				<br>
					<div class="6u$ 12u$(xsmall)" style="width:800px;">
						<input type="password" placeholder="비밀번호(영문+숫자,4-12글자)" name="mem_pw" style="width:70%;display:inline-block; margin-right: 10px;"
							id="tbPwd" class="form-control" style="font-size: 13px;"
							required="required"> 
					</div>
				
			</div>
			<div class="form-holder">
			<br>
					<div class="6u$ 12u$(xsmall)" style="width:800px;">
						<input type="password" placeholder="비밀번호 확인" class="form-control" style="width:70%;display:inline-block; margin-right: 10px;"
							id="cpass" style="font-size: 13px;" required="required">
							<input type="button" value="비밀번호확인"  style="display:inline-block; width:21%; padding:0" onclick="checkz()">
					</div>
				

			</div>
			<div class="form-holder">
				<br>
					<div class="6u$ 12u$(xsmall)" style="width:800px;">
						<input type="text" placeholder="이름" name="mem_name" style="width:70%;display:inline-block; margin-right: 10px;
							class="form-control" style="font-size: 13px;" required="required">
					</div>
				
			</div>
			<div class="form-holder">

				<br>
					<div class="6u$ 12u$(xsmall)" style="width:800px;">
						<input type="text" placeholder="별명" name="mem_nick" style="width:70%;display:inline-block; margin-right: 10px;  
							class="form-control" style="font-size: 13px;" required="required">
					</div>
				
			</div>
			<div class="form-holder">

				<br>
					<div class="6u$ 12u$(xsmall)" style="width:800px;">
						<input type="text" placeholder="핸드폰" name="mem_phone" style="width:70%;display:inline-block; margin-right: 10px;
							class="form-control" style="font-size: 13px;" required="required">
					</div>
				
			</div>
			<div class="checkbox"></div>

				<br>
				<div class="6u$ 12u$(xsmall)">
				<button input type="submit" id="sbmd" style="font-color:white;font-size: 15px;">회원가입하기</button>
		
	</div>
	</form>
	</section>
	<!-- 	</div>  -->


	<jsp:include page="Footer.jsp" />

</body>
</html>