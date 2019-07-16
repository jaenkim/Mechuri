<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원목록</title>

<script type="text/javascript">
	function removeCheck() {
	 if (confirm("정말 삭제하시겠습니까?") == true){    //확인
	     document.removefrm.submit();
	 }else{   //취소
	     return;
	 }
	}
    </script>
</head>
<body>
<h1>일반 회원 목록</h1>
 <form action='userDelete.do' method='post' name='removefrm'>
<table border='1'>
<tr>
<th>번호</th>
<th>아이디</th>
<th>성명</th>
<th>가입일</th>
<th>닉네임</th>
<th>휴대폰번호</th>
<th>탈퇴여부</th>
<th>탈퇴일</th>
<th>삭제(완전탈퇴)</th>
</tr>


 <c:forEach items="${members}" var="member">
 <input type="hidden" name="mem_no" value="${member.mem_no }"/>
 <tr>
 <td>${member.mem_no}</td>
 <td>${member.mem_id }</td>
 <td>${member.mem_name }</td>
 <td><fmt:formatDate value="${member.mem_regdate }" pattern="yyyy.MM.dd"/></td>
 <td>${member.mem_nick }</td>
 <td>${member.mem_phone}</td>
 <td>${member.mem_delflag }</td>
 <td><fmt:formatDate value="${member.mem_deldate }" pattern="yyyy.MM.dd"/></td>
 
 <td><input type='button' value="삭제" onclick='removeCheck()'></td>
 </tr>
</c:forEach>
</table>
 </form>

</body>
</html>