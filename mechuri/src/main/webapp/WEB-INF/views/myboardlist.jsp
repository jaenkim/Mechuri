<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내가 쓴 글 목록</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<section id="main" class="wrapper">
	<div class="inner">
	  <header class="align-center">
<h1>내가 쓴 글 목록</h1>
 </header>
 
  
 <table border='1'>
 <tr>
 <th>글번호</th>
 <th>제목</th>
 </tr>
 <c:forEach items="${myboard}" var="myboard">
 <tr><td>${myboard.board_no}</td>
 <td><a href="boardDetail.do?board_no=${myboard.board_no }">${myboard.board_title }</a></td>
</tr>
 </c:forEach>
 </table>
          </div>
   </section>
</body>
</html>