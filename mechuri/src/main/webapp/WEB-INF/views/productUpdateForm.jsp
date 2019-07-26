<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<jsp:include page="Header.jsp"/>
<section id="main" class="wrapper">
<div style="width:400px; margin: 0 auto;">
	<div class="inner">
	  <header class="align-center">
	<h1>${dto.product_name }</h1>
	<p>대분류- ${dto.product_catelname } / 소분류- ${dto.product_catelname }</p>
	</header>
	
<form action='tempinfoInsert.do' method='post' enctype='multipart/form-data' name='updatefrm'>
<input type='hidden' name='pno' value='${dto.product_no }'/>

<c:choose>
	<c:when test= "${dto.product_djflag eq 'N' }">
		<p>(단종 제품)</p>
	</c:when>
</c:choose>
<br><br>

	<c:choose>
	<c:when test="${dto.product_storedfile==null }">
	<img src="images/product/7.jpg" alt="기초"/>
	</c:when>
	<c:otherwise>
	<img src="upload/${dto.product_storedfile} "/>
	</c:otherwise>
	</c:choose>
	<br><br>
  <label for="filename">제품사진:     </label>
        <input type="file" id="filename" name="filename" onchange="javascript:document.getElementById('file_route').value=this.value">
    <input type="text" readonly="readonly" title="File Route" name="storedfile" value="${dto.product_storedfile}" id="file_route">
	
	<br><br>

          
         
제품명: <input type="text" name="tempinfo_name" value="${dto.product_name }" required="required"/><br><br>
용량: <input type="text" name="tempinfo_ml" value="${dto.product_ml}" required="required"><br><br>
가격: <input type="text" name="tempinfo_price" value="${dto.product_price}" required="required"><br><br>
제품설명: <input type="text" name="tempinfo_conts" value="${dto.product_conts}" required="required"><br><br>
성분: <input type="text" name="tempinfo_ingre" value="${dto.product_ingre}" required="required"><br><br>
피부타입: <select name="tempinfo_skintype" required="required">
        <option selected=${dto.product_skintype } hidden="">${dto.product_skintype }</option>
		<option value="건성">건성</option>
		<option value="중성">중성</option>
		<option value="지성">지성</option>
		<option value="민감성">민감성</option>
		<option value="여드름성">여드름성</option>
		<option value="아토피성">아토피성</option>
		</select><br><br>
타겟 연령: <select name="tempinfo_age" required="required">
        <option selected=${dto.product_age } hidden="">${dto.product_age }</option>
		<option value="10대">10대</option>
		<option value="20대">20대</option>
		<option value="30대">30대</option>
		<option value="40대">40대</option>
		<option value="50대 이상">50대 이상</option>
		</select><br><br>

타겟 성별: 	<select name="tempinfo_gender" required="required">
        <option selected=${dto.product_gender } hidden="">${dto.product_gender }</option>
		<option value="여성">여성</option>
		<option value="남성">남성</option>
		</select>
		<br><br>


<div style="width: 800px; margin: 0 auto;">
	<c:choose>
	<c:when test= "${dto.product_flag eq 'N' }">
		<button type='button' disabled="disabled" onclick="updateCheck()" class="button special small" >수정신청</button>
	</c:when>
	<c:when test= "${dto.product_others01 eq 'N' }">
		<button type='button' disabled="disabled" onclick="updateCheck()" class="button special small">수정신청</button>
	</c:when>
	<c:otherwise>
		<button type='button' onclick="updateCheck()" class="button special small">수정신청</button>
	</c:otherwise>
	</c:choose>

	
	<c:choose>
	<c:when test= "${dto.product_djflag eq 'N' }">
	<button type='button' disabled="disabled" onclick="productDj('${dto.product_no }')" class="button small" class="button small">단종처리</button> 
	</c:when>
	<c:otherwise>
	<button type='button' onclick="danCheck('${dto.product_no }')" class="button small">단종처리</button> 
	</c:otherwise>
	</c:choose>

    <button type='button' class="button alt small" onclick="removeCheck('${dto.product_no }')" >삭제</button> 
</div>
<script src="assets/js/cate_filter.js"></script>
<script type='text/javascript'>
	
	function productDj(product_no){
		//단종 작업
		location.href = "productdj.do?product_no="+product_no;
	}
	
	
	function productDel(product_no){
		//삭제 작업
		location.href = "productdel.do?product_no="+product_no;
	}
	
</script>

<script type="text/javascript">
	function updateCheck() {
	 if (confirm("수정 신청하시겠습니까?") == true){    //확인
	     document.updatefrm.submit();
	 }else{   //취소
	     return;
	 }
	}
    </script>
    

<script type="text/javascript">
	function removeCheck(product_no) {
	 if (confirm("정말 삭제하시겠습니까?") == true){    //확인
		 productDel(product_no);
	 }else{   //취소
	     return;
	 }
	}
    </script>
    
<script type="text/javascript">
	function danCheck(product_no) {
	 if (confirm("단종 처리 하시겠습니까?") == true){    //확인
		 productDj(product_no);
	 }else{   //취소
	     return;
	 }
	}
    </script>
    
</form>
     </div>
     </div>
   </section>
</body>
</html>