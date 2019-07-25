<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
function sub(){
	if($("#id").val()==""||$("#name").val()==""){
		alert("아이디와 이름 모두 입력해주세요.");
	} else {
		alert("임시 비밀번호가 고객님의 이메일로 전송 되었습니다.");
	}
}
	/* function sub() {
		alert("임시 비밀번호가 고객님의 이메일로 전송 되었습니다.");
		if{
			
		}
	} */
</script>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<section id="main" class="wrapper">
		<div style="width: 150px; margin: 0 auto;">
			<div class="inner">
				
				<h1 style="inline;width:200px; ">비밀번호  찾기</h1>
				<form action="pwFind.do" method="post" id="pwFind">
					<input type="text" name="mem_id" id="id" required="required"
						placeholder="아이디를 입력하세요" style="width:230px"/> <input type="text" name="mem_name"
						id="name" required="required" placeholder="이름을 입력하세요" style="width:230px" /> <br><input
						type="submit" id="sbm" value="비밀번호찾기" onclick="sub()"/>

				</form>
			</div>
		</div>
	</section>
	<jsp:include page="Footer.jsp" />
</body>
</html>