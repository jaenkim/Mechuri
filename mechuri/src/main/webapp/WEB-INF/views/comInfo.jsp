<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 정보 보기(기업)</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<section id="main" class="wrapper">
<div style="width:400px; margin: 0 auto;">

				<div class="inner">
					<header class="align-center">
<h1>내 정보 보기(기업)</h1>
					</header>
 <c:forEach items="${cominfo}" var="cominfo">
<form action='infoUpdate.do' method='post' name='updatefrm'>
<input type="hidden" name="mem_no" value="${cominfo.mem_no }"/>
<input type="hidden" name='mem_status' value="C"/>
<b>브랜드명 :</b> <input type="text" name="mem_brand" value="${cominfo.mem_brand }" required="required"><br>
<b>아이디:</b> <input type="text" name="mem_id" value="${cominfo.mem_id }" readonly="readonly"><br>
<b>비밀번호:</b> <input type="password" name="mem_pw" value="${cominfo.mem_pw }" required="required"><br>
<b>담당자명:</b> <input type="text" name="mem_name" value="${cominfo.mem_name }" required="required"><br>
<b>이메일:</b> <input type="text" name="mem_email" value="${cominfo.mem_email }" required="required"><br>
<b>연락처:</b> <input type="text" name="mem_phone" value="${cominfo.mem_phone }" required="required"><br>
<b>주소:</b> <input type="text" name="mem_post" value="${cominfo.mem_post }" required="required"><br>
<input type="text" name="mem_addr1" value="${cominfo.mem_addr1 }" required="required"><br>
<input type="text" name="mem_addr2" value="${cominfo.mem_addr2 }" required="required"><br>
<b>홈페이지:</b> <input type="text" name="mem_homepage" value="${cominfo.mem_homepage }" required="required"><br><br><br>

<div style="width: 500px; margin: 0 auto;">

<input type='button' value="수정" onclick="updateCheck()" class="button special">
<span><input type='button' onclick="removeCheck('${cominfo.mem_no }')" value="탈퇴"/> </span>
</div>

</form>
</c:forEach>
<script type='text/javascript'>
		
	function comtal(mem_no){
		//기업 탈퇴
		location.href = "comtal.do?mem_no="+mem_no;
	}
	
</script>

<script type="text/javascript">
	function removeCheck(mem_no) {
	 if (confirm("정말 탈퇴하시겠습니까?") == true){    //확인
	     comtal(mem_no);
	 }else{   //취소
	     return;
	 }
	}
    </script>
    
    <script type="text/javascript">
	function updateCheck() {
	 if (confirm("수정하시겠습니까?") == true){    //확인
	     document.updatefrm.submit();
	 }else{   //취소
	     return;
	 }
	}
    </script>
    	</div>
    	   </div>
			</section>
</body>
</html>