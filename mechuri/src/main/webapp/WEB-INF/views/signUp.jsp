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



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일반 회원가입 페이지</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<form action='signUpBoard.do' method='post'>
		<br> <br> <br>

		<!-- <div class="inner"> -->

		

		
		<div class="form-holder" style="text-align: center">
		<center>
		<h3>일반회원 가입</h3>
			 <input type="text" placeholder="ex)aaa@gmail.com" name="mem_id" id="mem_id"
				class="form-control" />
		</center>		
		</div>		
		<span>	  <input type="button" value="아이디중복확인" id="btbt" onclick="idcheck()" />
				 <input type="hidden" id="hid" style="font-size:13px;"> </span>	
				 <br>
		<div class="form-holder" style="text-align: center">	
		<center>	 
				<input type="text" id="insrt" placeholder="인증번호를 입력해주세요." style="font-size:13px;">
		</center>	
		</div>	
				<input type="button" value="아이디인증" id="bt" onclick="mailChk()" />
				<input type="button" class="btn-success" id="btn"
					disabled="disabled" onclick="keyChk()" value="인증">
			
		

		<div class="form-holder" style="text-align: center">
		<center>
			<input type="text" placeholder="비밀번호(영문+숫자,4-12글자)" name="mem_pw" id="tbPwd"
				class="form-control" style="font-size:13px;">
		</center>
		</div>
		<div class="form-holder" style="text-align: center">
		<center>
			<input type="password" placeholder="비밀번호 확인" class="form-control" id="cpass"
				style="font-size: 13px;">
				</center>
			
		</div>
		<div class="form-holder" style="text-align: center">
		<center>
			<input type="text" placeholder="이름" name="mem_name"
				class="form-control" style="font-size: 13px;">
		</center>
		</div>
		<div class="form-holder" style="text-align: center">
		
		<center>
			<input type="text" placeholder="별명" name="mem_nick"
				class="form-control" style="font-size: 13px;">
		</center>
		</div>
		<div class="form-holder" style="text-align: center">
	
		<center>
			<input type="text" placeholder="핸드폰" name="mem_phone"
				class="form-control" style="font-size: 153x;">
		</center>
		</div>
		<div class="checkbox"></div>

		<button input type="submit" id="sbmd">회원가입하기</button>
			
	</form>
	
	<!-- 	</div>  -->



	<jsp:include page="Footer.jsp" />

</body>
</html>