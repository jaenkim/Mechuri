<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 정보 보기</title>
</head>

<jsp:include page="Header.jsp"/>
<section id="main" class="wrapper">
<div style="width:400px; margin: 0 auto;">
	<div class="inner">
	  <header class="align-center">
<h1>내 정보 보기</h1>
 </header>
<br><br>
<div class="12u">
<c:forEach items="${userInfo}" var="userinfo">
<form action='infoUpdate.do' method='post' name='updatefrm'>
<input type="hidden" name='mem_status' value="M"/>
<input type="hidden" name="mem_no" value="${userinfo.mem_no }"/>
<div class="row uniform">
	<div class="6u 12u$(xsmall)" style="width:400px;">
<b>아이디:</b> <input type="text" name="mem_id" value="${userinfo.mem_id }" readonly="readonly"><br>
<b>이름:</b> <input type="text" name="mem_name" value="${userinfo.mem_name }" required="required"><br>
<b>비밀번호:</b> <input type="password" name="mem_pw" value="${userinfo.mem_pw }" required="required"><br>
<b>닉네임:</b> <input type="text" name="mem_nick" value="${userinfo.mem_nick }" required="required"><br>
<b>연락처:</b> <input type="text" name="mem_phone" value="${userinfo.mem_phone }" required="required"><br>

<br>
<div style="width: 500px; margin: 0 auto;">
<input type='button' class="button special" value="수정" onclick='updateCheck()'>
<span><input type='button' class="button" onclick="removeCheck('${userinfo.mem_no }')" value="탈퇴"> </span>
</div>
</div>
</div>
</form>
</c:forEach>
<script type='text/javascript'>
		
	function comtal(mem_no){
		//일반회원 탈퇴
		location.href = "comtal.do?mem_no="+mem_no;
	}
	
</script>


<script type="text/javascript">
	function updateCheck() {
	 if (confirm("정보를 수정하시겠습니까?") == true){    //확인
	     document.updatefrm.submit();
	 }else{   //취소
	     return;
	 }
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
    </div>
             </div>
             </div>
   </section>
</body>
</html>