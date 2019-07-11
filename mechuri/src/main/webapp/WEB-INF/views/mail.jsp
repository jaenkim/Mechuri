<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메일보내기</title>
</head>
<body>
  <h4>메일 보내기</h4>
  <!-- 4. view 설정 -->
  <form action="/mailSending.do" method="post">
    <div align="center"><!-- 받는 사람 이메일 -->
      <input type="text" name="tomail" size="120" style="width:100%" placeholder="상대의 이메일">
    </div>     
    <div align="center"><!-- 제목 -->
      <input type="text" name="title" size="120" style="width:100%" placeholder="제목을 입력해주세요">
    </div>
    <p>
    <div><!-- 내용 --> 
      <textarea name="content" cols="120" rows="12" style="width:100%; resize:none" placeholder="내용"></textarea>
    </div>
    <p>
    <div align="center">
      <input type="submit" value="메일 보내기">
    </div>
  </form>
</body>
</html>