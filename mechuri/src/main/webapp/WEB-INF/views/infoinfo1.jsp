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
<b>브랜드명 :</b> <input type="text" name="mem_brand" value="${infoinfo.mem_brand }" readonly="readonly"><br>
<b>아이디:</b> <input type="text" name="mem_id" value="${infoinfo.mem_id }" readonly="readonly"><br>
<b>비밀번호:</b> <input type="password" name="mem_pw" value="${infoinfo.mem_pw }" readonly="readonly"><br>
<b>담당자명:</b> <input type="text" name="mem_name" value="${infoinfo.mem_name }" readonly="readonly"><br>
<b>이메일:</b> <input type="text" name="mem_email" value="${infoinfo.mem_email }" readonly="readonly"><br>
<b>연락처:</b> <input type="text" name="mem_phone" value="${infoinfo.mem_phone }" readonly="readonly"><br>
<b>주소:</b> <input type="text" name="mem_post" value="${infoinfo.mem_post }" readonly="readonly"><br>
<input type="text" name="mem_addr1" value="${infoinfo.mem_addr1 }" readonly="readonly"><br>
<input type="text" name="mem_addr2" value="${infoinfo.mem_addr2 }" readonly="readonly"><br>
<b>홈페이지:</b> <input type="text" name="mem_homepage" value="${infoinfo.mem_homepage }" readonly="readonly""><br><br><br>

</c:forEach>
<div style="width: 200px; margin: 0 auto;">
<a href='comUserManage.do'><input type='button' value='회원목록'></a>
</div>
</div>
</div>
</div>


    </div>
             </div>
   </section>
</body>
</html>