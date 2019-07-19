<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% response.setContentType("text/html;charset=UTF-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script language="javascript">
	function SetValue(this){
		range_val.value = this.value;
	}
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰: ${product.product_name }</title>
</head>
<body>

<h3>리뷰 작성</h3>
<h3>대상 제품: ${product.product_name }</h3>
<h2>브랜드: ${product.product_brand }</h2>
<h2>카테고리: ${product.product_catelname } / ${product.product_catesname }</h2>
<h2>가격/용량: ${product.product_price } / ${product.product_ml }</h2>
<form action = "insertReview.do?product_no=${product.product_no }&writer=${writer}&callbackIngre=${callbackIngre}" method="post" enctype="multipart/form-data">
 <table border='1'>
	<tr>
		<td>리뷰내용</td>
		<td>
			<input type="textarea" name="reviewconts" rows="6" cols="100" required />
		</td>
	</tr>
	<tr>
		<td rowspan="2">
		<label> 별점 </label>
        <input type="range" name="points" min="0" max="5.0" step="0.5" value="2.5" oninput="document.getElementById('value1').innerHTML=this.value;">
        <span id="value1"></span>
        </td>
	</tr>
	<tr>
		<td rowspan="2"><input type="file" name="filename" onchange="javascript:document.getElementById('file_route').value=this.value"/>
    			<input type="text" readonly="readonly" title="File Route" id="file_route" />
    	</td>
    </tr>
    <tr>
    	<td rowspan="2"> <input type="submit" value="작성완료" /></td>
    </tr>
</table>
</form>
</body>
</html>