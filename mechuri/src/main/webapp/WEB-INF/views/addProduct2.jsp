<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	function addCheck() {
	 if (confirm("등록 하시겠습니까?") == true){    //확인
	     document.addfrm.submit();
	 }else{   //취소
	     return;
	 }
	}
    </script>
<title>기업 제품 등록 페이지</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
<br><br><br><br>
<form action='addProduct.do' method='post' enctype='multipart/form-data' name='addfrm'>
<h3>신규 제품 등록</h3>

	 	 
	 <p>카테고리</p>
         <select name="filter_catelname" style="width: 200px">
            <option value="전체">전체</option>
         </select> 
         <select name="filter_catesname" style="width: 200px">
            <option value="전체">전체</option>
         </select> 
         <br>
         
         
제품명: <input type="text" name="product_name"/><br>
용량: <input type="text" name="product_ml"><br>
가격: <input type="text" name="product_price"><br>
제품설명: <input type="text" name="product_conts"><br>
성분: <input type="text" name="product_ingre"><br>
피부타입: <select name="product_skintype">
		<option value="전체">전체</option>
		<option value="건성">건성</option>
		<option value="중성">중성</option>
		<option value="지성">지성</option>
		<option value="민감성">민감성</option>
		<option value="여드름성">여드름성</option>
		<option value="아토피성">아토피성</option>
		</select><br>
타겟 연령: <select name="product_age">
		<option value="전체">전체</option>
		<option value="10대">10대</option>
		<option value="20대">20대</option>
		<option value="30대">30대</option>
		<option value="40대">40대</option>
		<option value="50대 이상">50대 이상</option>
		</select><br>

타겟 성별: 	<select name="product_gender">
		<option value="전체">전체</option>
		<option value="여성">여성</option>
		<option value="남성">남성</option>
		</select><br>
		

  <label>제품 사진:
   	 <input type="file" name="filename" onchange="javascript:document.getElementById('file_route').value=this.value"/>
    </label>
    <input type="text" readonly="readonly" title="File Route" id="file_route">
    <br>
    <br>
<input type='button' value='등록' onclick="addCheck()">  

<script src="assets/js/cate_filter.js"></script>
</form>
</body>
</html>