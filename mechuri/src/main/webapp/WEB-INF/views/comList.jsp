<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기업 회원 목록</title>
    
</head>
<body>
<jsp:include page="Header.jsp"/>
<section id="main" class="wrapper">
	<div class="inner">
	  <header class="align-center">
<h1>기업 회원 목록</h1>
 </header>
 
 <form action='userDelete.do' method='post' name='removefrm'>
  <input type="hidden" name="mem_no" value="${member.mem_no }"/>
    <input type="hidden" name="mem_status" value="C"/>

<table border='1'>
<tr>
<th>번호</th>
<th>브랜드명</th>
<th>연락처</th>
<th>가입신청일</th>
<th>가입승인여부</th>
<th>탈퇴여부</th>
<th>탈퇴일</th>
<th>삭제(완전탈퇴)</th>
</tr>
 <c:forEach items="${commembers}" var="member">
 
 <tr>
 <td>${member.mem_no}</td>
 <td><a href="infoinfo.do?mem_no=${member.mem_no }&mem_status=C">${member.mem_brand }</a></td>
 <td>${member.mem_phone}</td>
 <td><fmt:formatDate value="${member.mem_regdate }" pattern="yyyy.MM.dd"/></td>
 <td>
 <c:choose>
	<c:when test= "${member.mem_apprflag eq 'Y' }">
	승인완료
<!-- 		<input type='button'  value="가입승인" disabled="disabled" > -->
	</c:when>
	<c:otherwise>
 <a href="compAppr.do?mem_no=${member.mem_no }"><input type='button' value="가입승인" class="button special small"></a>
 	</c:otherwise>
 	</c:choose>
 </td>
 <td>${member.mem_delflag }</td>
 <td><fmt:formatDate value="${member.mem_deldate }" pattern="yyyy.MM.dd"/></td>
 
 <td><button onclick="removeCheck(${member.mem_no})" class="button small" >삭제</button></td> 
 </tr>
 
</c:forEach>
</table>
 </form>
 
 <script type="text/javascript">
	function removeCheck(mem_no) {
	 if (confirm("정말 삭제하시겠습니까?") == true){    //확인
	     document.removefrm.mem_no.value = mem_no;
	     document.removefrm.submit();
	 }else{   //취소
	     return false;
	 }
	}
    </script>
         </div>
   </section>
</body>
</html>