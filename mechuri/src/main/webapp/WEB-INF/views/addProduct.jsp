<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기업 제품 등록 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/bootstrap-theme.css" />
  <link rel="stylesheet" href="../css/bootstrap.css" />
<style>

table {
	font-size:20px;
	font : ariel
}


</style>
</head>
<body>
<div>

<table class="table table-hover ">
<tr class="danger">
	<th colspan='2'><h2>신규제품등록</h2></th>
</tr>
<tr>
	<td>카테고리</td>
	<td><select>
 		 <option value="volvo">기초</option>
 		 <option value="saab">베이스</option>
		 <option value="opel">클렌징</option>
 		 <option value="audi">색조</option>
 		 <option value="volvo">선케어</option>
 		 <option value="saab">바디&핸드&풋</option>
		 <option value="opel">베이비&맘</option>
 		 <option value="audi">남성</option>
	 </select></td>
</tr>
<tr>
	<td>제품명</td>
	<td></td>
</tr>
<tr>
	<td>용량</td>
	<td></td>
</tr>
<tr>
	<td>가격</td>
	<td></td>
</tr>
<tr>
	<td>설명</td>
	<td></td>
</tr>
<tr>
	<td>성분정보</td>
	<td></td>
</tr>
<tr>
	<td>제품 대표이미지</td>
	<td></td>
</tr>

</table>
</div><br><br><br><br>




<h3>신규 제품 등록</h3>
카테고리 <select>
 		 <option value="volvo">기초</option>
 		 <option value="saab">베이스</option>
		 <option value="opel">클렌징</option>
 		 <option value="audi">색조</option>
 		 <option value="volvo">선케어</option>
 		 <option value="saab">바디&핸드&풋</option>
		 <option value="opel">베이비&맘</option>
 		 <option value="audi">남성</option>
	 </select><br>
제품명: <input type="text"><br>
용량: <input type="text"><br>
가격: <input type="text"><br>
설명: <input type="text"><br>
성분정보: <input type="text"><br>
<label for="exampleInputFile">대표이미지</label>
    <input type="file" id="exampleInputFile">
  

<!-- <input type="image" src="../images/banner.jpg"><br> -->







</body>
</html>