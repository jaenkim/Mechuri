<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function appr1Check() {
	 if (confirm("등록 승인 하시겠습니까?") == true){    //확인
	     document.appr1frm.submit();
	 }else{   //취소
	     return;
	 }
	}
    </script>
    
<script type="text/javascript">
	function appr2Check() {
	 if (confirm("수정 승인 하시겠습니까?") == true){    //확인
	     document.appr2frm.submit();
	 }else{   //취소
	     return;
	 }
	}
    </script>
<title>승인 해야 할 제품 보기</title>
</head>
<body>
<div>
<h1>(제품등록)승인 해야 할 제품 리스트</h1>
 <c:forEach items="${list}" var="dto">
 <form action='approveProduct.do' method='post' name='appr1frm'>
  <input type='hidden' name='product_no' value='${dto.product_no}'>
  <input type='hidden' name='product_name' value='${dto.product_name}'>
  <input type='hidden' name='product_compno' value='${dto.product_compno}'>
 
         ${dto.product_no}
         ${dto.product_brand }
 <a href="productUpdateForm.do?product_no=${dto.product_no}" >${dto.product_name} </a>
         ${dto.product_ml }
         ${dto.product_conts }
	<input type="button" value="승인" onclick='appr1Check()'>
<br>
</form>
</c:forEach>
</div>
<br><br><br>

<div>
<h1>(제품수정)승인 해야 할 제품 리스트</h1>
 <c:forEach items="${list1}" var="dto1">
 <form action='approveProduct1.do' method='post' name='appr2frm'>
  <input type='hidden' name='tempinfo_no' value='${dto1.tempinfo_no}'>
 
         ${dto1.tempinfo_no}
<a href="productUpdateForm.do?product_no=${dto1.tempinfo_no}" > ${dto1.tempinfo_name}</a>
         ${dto1.tempinfo_ml }
         ${dto1.tempinfo_conts }
	<input type="button" value="승인" onclick='appr2Check()'>
<br>
</form>
</c:forEach>
</div>
</body>
</html>