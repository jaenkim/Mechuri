<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function appr1Check(product_no) {
	 if (confirm("등록 승인 하시겠습니까?") == true){    //확인
		 document.appr1frm.product_no.value= product_no;
	     document.appr1frm.submit();
	 }else{   //취소
	     return;
	 }
	}
    </script>
    
<script type="text/javascript">
	function appr2Check(tempinfo_no) {
	 if (confirm("수정 승인 하시겠습니까?") == true){    //확인
		 document.appr2frm.tempinfo_no.value= tempinfo_no;
	     document.appr2frm.submit();
	 }else{   //취소
	     return;
	 }
	}
    </script>
    
    
<title>제품 등록/수정 승인</title>
</head>

<body>
<jsp:include page="Header.jsp"/>

		<section id="main" class="wrapper">
				<div class="inner">
					<header class="align-center">
<h1>[제품등록] 승인 요청 리스트</h1>
 </header>
   <form action='approveProduct.do' method='post' name='appr1frm'>
  <input type='hidden' name='product_no' value='${dto.product_no}'>
  <table border='1'>
       <tr>
 <th>제품번호</th>
 <th>브랜드명</th>
 <th>제품명</th>
 <th>용량</th>
 <th>내용</th>
 <th>승인</th>
 </tr>
  <c:forEach items="${list}" var="dto">
  <input type='hidden' name='product_name' value='${dto.product_name}'>
  <input type='hidden' name='product_compno' value='${dto.product_compno}'>
     <tr><td>    ${dto.product_no} </td>
        <td>${dto.product_brand } </td>
 		<td><a href="productUpdateForm.do?product_no=${dto.product_no}" >${dto.product_name} </a> </td>
       <td>  ${dto.product_ml } </td>
        <td> ${dto.product_conts } </td>
	<td><input type="button" value="승인" class="button special small" onclick='appr1Check(${dto.product_no})'> </td>
	</tr>
</c:forEach>
</table>
</form>

</div>
			</section>

<br><br><br>

	<section id="main" class="wrapper">
				<div class="inner">
					<header class="align-center">
<h1>[제품수정] 승인 요청 리스트</h1>
 </header>
 <form action='approveProduct1.do' method='post' name='appr2frm'>
    <input type='hidden' name='tempinfo_no' value='${dto1.tempinfo_no}'>
      <table border='1'>
       <tr>
 <th>제품번호</th>
 <th>브랜드명</th>
 <th>제품명</th>
 <th>용량</th>
 <th>내용</th>
 <th>승인</th>
 </tr>
  <c:forEach items="${list1}" var="dto1">
        <tr><td> ${dto1.tempinfo_no} </td>
        <td> ${dto1.tempinfo_others02 }</td>
<td><a href="productUpdateForm.do?product_no=${dto1.tempinfo_no}" > ${dto1.tempinfo_name}</a></td>
  <td>  ${dto1.tempinfo_ml }</td>
       <td>  ${dto1.tempinfo_conts }</td>
<td>	<input type="button" value="승인" class="button special small" onclick='appr2Check(${dto1.tempinfo_no})'></td>
</c:forEach>
</table>
</form>
	</div>
			</section>
</body>
</html>