<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 보기</title>
</head>

<jsp:include page="Header.jsp"/>
<section id="main" class="wrapper">
<div style="width:400px; margin: 0 auto;">
	<div class="inner">
	  <header class="align-center">
<h1>회원 정보 보기</h1>
 </header>
<br><br>
<div class="12u">
<div class="row uniform">
	<div class="6u 12u$(xsmall)" style="width:400px;">
<c:forEach items="${infoinfo}" var="infoinfo">
<b>아이디:</b> <input type="text" name="mem_id" value="${infoinfo.mem_id }" readonly="readonly"><br>
<b>이름:</b> <input type="text" name="mem_name" value="${infoinfo.mem_name }" readonly="readonly"><br>
<b>비밀번호:</b> <input type="password" name="mem_pw" value="${infoinfo.mem_pw }" readonly="readonly"><br>
<b>닉네임:</b> <input type="text" name="mem_nick" value="${infoinfo.mem_nick }" readonly="readonly"><br>
<b>연락처:</b> <input type="text" name="mem_phone" value="${infoinfo.mem_phone }" readonly="readonly"><br>

</c:forEach>
<div style="width: 200px; margin: 0 auto;">
<a href='userManage.do'><input type='button' value='회원목록'></a>
</div>
</div>
</div>
</div>


    </div>
             </div>
   </section>
</body>
</html>