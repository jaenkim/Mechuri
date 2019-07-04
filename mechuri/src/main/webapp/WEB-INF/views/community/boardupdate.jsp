<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 상세보기</title>
<link rel="stylesheet" href="commAssets/css/boarddetail.css">

</head>
<body>
	<jsp:include page="../Header.jsp"/>
<br><br><br>
<div class="container">
  <form action="/action_page.php">
  <div class="row">
    <div class="col-25">
      <label for="title">제목</label>
    </div>
    <div class="col-75">
      <input type="text" id="title" name="titlename" value="이니스프리 1+1 행사 한대요">
    </div>
  </div>
 
  <div class="row">
    <div class="col-25">
      <label for="content">내용</label>
    </div>
    <div class="col-75">
      <textarea id="content" name="content" style="height:200px">전품목 1+1 행사 한대요~뭐살까~</textarea>
    </div>
  </div>
   <br>
  <br>
	<div class="file_input">
    <label>
        	파일첨부
        <input type="file" onchange="javascript:document.getElementById('file_route').value=this.value">
    </label>
    <input type="text" readonly="readonly" title="File Route" id="file_route">
	</div>

  <br>
  <div>
    <input type="button" value="취소" id="cancel1">
    <input type="button" value="삭제" id="delete1">
    <input type="button" value="수정" id="update1">
   </div>
  </form>
</div> 
<br><br><br>
	<jsp:include page="../Footer.jsp"/>
</body>
</html>