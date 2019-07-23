<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쪽지 보기</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<section id="main" class="wrapper">
	<div class="inner">
	  <header class="align-center">
<h1>쪽지함</h1>
 </header>
<table border='1'>
 <c:forEach items="${list}" var="dto">
 <tr>
        <td><b> ${dto.msg_title}</b> </td>
        <td> ${dto.msg_conts} </td>
        <td> <fmt:formatDate value="${dto.msg_regdate}" pattern="yyyy-MM-dd HH:mm"/></td>
        
</c:forEach>
</table>
       </div>
   </section>
</body>
</html>