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
<body>
<jsp:include page="Header.jsp"/>
<br><br><br><br>
<h1>내 정보 보기(일반회원)</h1>


<c:forEach items="${userInfo}" var="userinfo">
<form action='infoUpdate.do' method='post' name='updatefrm'>
<input type="hidden" name='mem_status' value="M"/>
<input type="hidden" name="mem_no" value="${userinfo.mem_no }"/>
아이디: <input type="text" name="mem_id" value="${userinfo.mem_id }" readonly="readonly"><br>
이름: <input type="text" name="mem_name" value="${userinfo.mem_name }" required="required"><br>
비밀번호: <input type="password" name="mem_pw" value="${userinfo.mem_pw }" required="required"><br>
닉네임: <input type="text" name="mem_nick" value="${userinfo.mem_nick }" required="required"><br>
연락처: <input type="text" name="mem_phone" value="${userinfo.mem_phone }" required="required"><br>

<br>
<input type='button' value="수정" onclick='updateCheck()'>
<button type='button' onclick="removeCheck('${userinfo.mem_no }')">탈퇴</button> 

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
</body>
</html>