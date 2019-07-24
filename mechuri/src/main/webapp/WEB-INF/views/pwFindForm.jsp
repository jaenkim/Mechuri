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
	function sub() {
		alert("임시 비밀번호가 고객님의 이메일로 전송 되었습니다.")	
	}
</script>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<section id="main" class="wrapper">
		<div style="width: 150px; margin: 0 auto;">
			<div class="inner">

				<h1>비밀번호  찾기</h1>
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