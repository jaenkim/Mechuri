<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    
<title>기업 제품 등록 페이지</title>
</head>
<body>
<jsp:include page="Header.jsp"/>
			<section id="main" class="wrapper">
			<div style="width:400px; margin: 0 auto;">
				<div class="inner">
					<header class="align-center">
<h1>신규 제품 등록</h1>
					</header>

<form action='addProduct.do' method='post' enctype='multipart/form-data' id='addfrm' name='addfrm'>

	 	 
	 <p><b>카테고리:</b></p>
         <select name="filter_catelname" id="filter_catelname">
            <option value="">카테고리 선택</option>
         </select> 
         <select name="filter_catesname" id="filter_catesname">
            <option value="">카테고리 선택</option>
         </select> 
         <br>
        
<b>제품명:</b> <input type="text" name="product_name" required="required"/><br>
<b>용량:</b> <input type="text" name="product_ml" required="required"/><br>
<b>가격:</b> <input type="text" name="product_price" required="required"><br>
<b>제품설명:</b> <input type="text" name="product_conts"><br>
<b>성분:</b> <input type="text" name="product_ingre" required="required"><br>
<b>피부타입:</b> <select name="product_skintype">
		<option value="전체">전체</option>
		<option value="건성">건성</option>
		<option value="지성">지성</option>
		<option value="여드름성">여드름성</option>
		</select><br>
<b>타겟 연령:</b><select name="product_age">
		<option value="전체">전체</option>
		<option value="10대">10대</option>
		<option value="20대">20대</option>
		<option value="30대">30대</option>
		<option value="40대">40대</option>
		<option value="50대 이상">50대 이상</option>
		</select><br>

<b>타겟 성별:</b> 	<select name="product_gender">
		<option value="전체">전체</option>
		<option value="여성">여성</option>
		<option value="남성">남성</option>
		</select><br>
		

  <label><b>제품 사진:</b>
   	 <input type="file" name="filename" onchange="javascript:document.getElementById('file_route').value=this.value" required="required"/>
    </label>
    <input type="text" readonly="readonly" title="File Route" id="file_route">
    <br>
    <br>
<div style="width: 150px; margin: 0 auto;">
<input type='submit' value='등록'>  
</div>
<script src="assets/js/cate_filter.js"></script>
<script>
$("#addfrm").submit(function(){
	if($("#filter_catelname").val()=="" || $("#filter_catesname").val()==""){
        	 alert('카테고리를 선택해주세요');
        	 return false;
         }
	return true;
	});
</script>
</form>
	</div>
	</div>
			</section>
</body>
</html>