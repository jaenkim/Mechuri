<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쪽지 발송</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<section id="main" class="wrapper">
<div style="width:400px; margin: 0 auto;">
	<div class="inner">
	  <header class="align-center">
<h1>쪽지 발송</h1>
<p>이 쪽지는 모든 회원에게 발송됩니다.</p>
	</header>

<form action="gogomsg.do" method="post">
<select name="userorcomp">
  <option value="0">기업회원</option>
  <option value="1">일반회원</option>
</select>
<b>제목:</b> <input type="text" name="msg_title">
<b>내용:</b> <textarea rows="10" cols="10" name="msg_conts"></textarea>
<div style="margin-top:20px; margin-left:250px;">
<input type='submit' value='전송' />
</div>
</form>
</div>
</div>
</section>
</body>
</html>