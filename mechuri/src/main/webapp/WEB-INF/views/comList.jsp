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
    
</head>
<body>
<h1>기업 회원 목록</h1>
 <form action='userDelete.do' method='post' name='removefrm'>

<table border='1'>
<tr>
<th>번호</th>
<th>브랜드명</th>
<th>담당자명</th>
<th>연락처</th>
<th>이메일</th>
<th>가입신청일</th>
<th>가입승인여부</th>
<th>탈퇴여부</th>
<th>탈퇴일</th>
<th>삭제(완전탈퇴)</th>
</tr>
 <c:forEach items="${commembers}" var="member">
  <input type="hidden" name="mem_no" value="${member.mem_no }"/>
 
 <tr>
 <td>${member.mem_no}</td>
 <td>${member.mem_brand }</td>
 <td>${member.mem_name }</td>
 <td>${member.mem_phone}</td>
 <td>${member.mem_email}</td>
 <td><fmt:formatDate value="${member.mem_regdate }" pattern="yyyy.MM.dd"/></td>
 <td>
 <c:choose>
	<c:when test= "${member.mem_apprflag eq 'Y' }">
	승인완료
<!-- 		<input type='button'  value="가입승인" disabled="disabled" > -->
	</c:when>
	<c:otherwise>
 <a href="compAppr.do?mem_no=${member.mem_no }"><input type='button' value="가입승인"></a>
 	</c:otherwise>
 	</c:choose>
 </td>
 <td>${member.mem_delflag }</td>
 <td><fmt:formatDate value="${member.mem_deldate }" pattern="yyyy.MM.dd"/></td>
 
 <td><button onclick="removeCheck()">삭제</button></td> 
 </tr>
 
</c:forEach>
</table>
 </form>
 
 <script type="text/javascript">
	function removeCheck() {
	 if (confirm("정말 삭제하시겠습니까?") == true){    //확인
	     document.removefrm.submit();
	 }else{   //취소
	     return;
	 }
	}
    </script>
</body>
</html>