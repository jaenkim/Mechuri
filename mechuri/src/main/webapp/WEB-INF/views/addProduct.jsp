<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
	 </select>
제품명 <input type="text">
용량
가격
설명
성분정보
대표이미지: <input type="image" src="../images/banner.jpg"><br>
</body>
</html>