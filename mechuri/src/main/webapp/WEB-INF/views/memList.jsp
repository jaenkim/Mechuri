<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일반 회원 목록</title>

<script type="text/javascript">
	function removeCheck(mem_no) {
	 if (confirm("정말 삭제하시겠습니까?") == true){    //확인
	     document.removefrm.mem_no.value = mem_no;
	 	document.removefrm.submit();
	 }else{   //취소
	     return;
	 }
	}
    </script>
</head>


<body>
<jsp:include page="Header.jsp"/>

<section id="main" class="wrapper">
	<div class="inner">
	  <header class="align-center">
		<h1>일반 회원 목록</h1>
	  </header>

 <form action='userDelete.do' method='post' name='removefrm'>
    <input type="hidden" name="mem_no"/>
    <input type="hidden" name="mem_status" value="M"/>
<table border='1'>
<tr>
<th>번호</th>
<th>아이디</th>
<th>성명</th>
<th>닉네임</th>
<th>가입일</th>
<th>탈퇴여부</th>
<th>탈퇴일</th>
<th>삭제(완전탈퇴)</th>
</tr>


 <c:forEach items="${members}" var="member">
 <tr>
 <td>${member.mem_no}</td>
 <td>${member.mem_id }</td>
 <td><a href="infoinfo.do?mem_no=${member.mem_no }&mem_status=M">${member.mem_name }</a></td>
 <td>${member.mem_nick }</td>
 <td><fmt:formatDate value="${member.mem_regdate }" pattern="yyyy.MM.dd"/></td>
 <td>${member.mem_delflag }</td>
 <td><fmt:formatDate value="${member.mem_deldate }" pattern="yyyy.MM.dd"/></td>
 
 <td><input type="button" value="삭제" class="button small" onclick='removeCheck(${member.mem_no})' /></td>
 </tr>
</c:forEach>
</table>
 </form>
     </div>
   </section>
</body>
</html>