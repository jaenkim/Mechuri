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
    
    
  function check(){
	 
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
 
    
</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기업 회원가입 페이지</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<form action='compSignUpBoard.do' method='post' >
		<br> <br> <br>
		
		<section id="main" class="wrapper">
		<div style="width:600px; margin: 0 auto;">
		<div class="form-holder">
			
				<h2>기업회원 가입</h2>
				<div class="6u$ 12u$(xsmall)" style="width:800px;">
				<input type="text" placeholder="브랜드명" name="mem_brand"
					class="form-control" style="font-size: 13px; width:70%;display:inline-block; margin-right: 10px; ">
					</div>
		
		</div>							
		<div class="form-holder">
			<br>
				
			<div class="6u$ 12u$(xsmall)" style="width:742px;">
					<input type="text" id="sample4_postcode" name="mem_post"
						placeholder="우편번호" style="font-size: 13px; width:50%;display:inline-block; margin-right: 10px;"> 
			<input type="button" class="button" id="sample4_button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"
						style="font-size: 13px; display:inline-block; ">
			</div>
			</div>
			<div class="form-holder">
			<br> 
			<div class="6u$ 12u$(xsmall)" style="width:800px;">
					<input type="text" id="sample4_roadAddress" name="mem_addr1" placeholder="도로명주소"
						style="font-size: 13px; width:70%;display:inline-block; margin-right: 10px;"></div><br> 
			<div class="6u$ 12u$(xsmall)" style="width:800px;">			
					<input type="text" id="sample4_jibunAddress" name="mem_addr2" placeholder="지번주소"
						style="font-size: 13px; width:70%;display:inline-block; margin-right: 10px;"></div><br> 
			<div class="6u$ 12u$(xsmall)" style="width:800px;">		
					<input type="text" id="sample4_detailAddress" name="mem_others01" placeholder="상세주소"
						style="font-size: 13px; width:70%;display:inline-block; margin-right: 10px;">
						</div>
			</div>	
		
		
		<br>

		<div class="form-holder" >
			
			<div class="6u$ 12u$(xsmall)" style="width:800px;">	
				<input type="text" placeholder="홈페이지" name="mem_homepage"
					class="form-control" style="font-size: 13px; width:70%;display:inline-block; margin-right: 10px;">
			</div>		
			
		</div>
		<br>

		<div class="form-holder">
			
				<h3>담당자 정보</h3>
				<div class="6u$ 12u$(xsmall)" style="width:800px;">	
				<input type="text" placeholder="아이디" name="mem_id"
					class="form-control" style="font-size: 13px; width:70%;display:inline-block; margin-right: 10px;">
					</div>
			
		</div>
		<br>
		<div class="form-holder" >
			
			<div class="6u$ 12u$(xsmall)" style="width:800px;">
				<input type="password" placeholder="비밀번호" name="mem_pw" id="tbPwd"
					class="form-control" style="font-size: 13px; width:70%;display:inline-block; margin-right: 10px;">
			</div>
			
		</div>
		<br>
		<div class="form-holder">
			
			<div class="6u$ 12u$(xsmall)" style="width:800px;">
				<input type="password" placeholder="비밀번호확인" class="form-control" id="cpass"
					style="font-size: 13px; width:50%;display:inline-block; margin-right: 10px;">
					<input type="button" value="비밀번호확인"  style="display:inline-block; width:15%; padding:0; font-size: 13px;" onclick="check()">
					</div>
			
		</div>
		<br>
		<div class="form-holder">
			
			<div class="6u$ 12u$(xsmall)" style="width:800px;">
				<input type="text" placeholder="담당자명" name="mem_name"
					class="form-control" style="font-size: 13px; width:70%;display:inline-block; margin-right: 10px;">
					</div>
			
		</div>
		<br>
		<div class="form-holder">
			
			<div class="6u$ 12u$(xsmall)" style="width:800px;">
				<input type="email" placeholder="이메일" name="mem_email"
					class="form-control" style="font-size: 13px; width:70%;display:inline-block; margin-right: 10px;">
					</div>
			
		</div>
		<br>
		<div class="form-holder">
			
			<div class="6u$ 12u$(xsmall)" style="width:800px;">
				<input type="text" placeholder="연락처" name="mem_phone"
					class="form-control" style="font-size: 13px; width:70%;display:inline-block; margin-right: 10px;">
					</div>
		
		</div>
		<br>
		<div style="">
			
				<button input type="submit" style="background-color: #f6755e;"
					style="font-size:13px;">회원가입하기</button>
			
		
		</div>
		</div>
		</section>
	</form>
	<!-- 	</div>  -->



	<jsp:include page="Footer.jsp" />
</body>
</html>