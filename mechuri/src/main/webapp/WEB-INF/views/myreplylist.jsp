<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 댓글 보기</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<section id="main" class="wrapper">
	<div class="inner">
	  <header class="align-center">
	  <h1>내가 쓴 댓글 목록</h1>
	   </header>
	   
 <table border='1'>	 
  <tr>
 <th>댓글번호</th>
 <th>댓글내용</th>
 </tr>
 <c:forEach items="${myreply}" var="myreply">
 <tr><td>${myreply.reply_no}</td>
 <td> <a href="boardDetail.do?board_no=${myreply.reply_communo }">${myreply.reply_conts }</a></td>
 </tr>
 </c:forEach>
 </table>
          </div>
   </section>
</body>
</html>