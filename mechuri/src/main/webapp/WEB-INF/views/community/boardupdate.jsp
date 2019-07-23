<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판  업데이트 폼</title>
<link rel="stylesheet" href="commAssets/css/boarddetail.css">
</head>
<body>
<jsp:include page="../Header.jsp"/>

<br><br><br>

<div class="container">
  <form action="updateBoard.do" method="post" enctype="multipart/form-data">
  <input type="hidden" name="board_no" value="${dto.board_no}" />
  <div class="row">
    <div class="col-25">
      <label for="title"  style="margin:5% 0% 0% 40%;">제목</label>
    </div>
    <div class="col-75">
      <input type="text" id="title" name="titlename" value="${dto.board_title}" style="width:80%;">
    </div>
  </div>
  
    <div class="row">
    <div class="col-25">
      <label for="writernick"  style="margin:5% 0% 0% 40%;">작성자</label>
    </div>
    <div class="col-75">
      <input type="text" id="writernick" name="writernick" value="${dto.board_nick}" readonly="readonly" style="width:80%;">
    </div>
  </div>
  
 
  <div class="row">
    <div class="col-25">
      <label for="content"  style="margin:5% 0% 0% 40%;">내용</label>
    </div>
    <div class="col-75">
    	<textarea id="content" name="content" style="height:200px; width:80%;">${dto.board_conts}</textarea>
    </div>
  </div>
   <br>
  <br>
	<div class="file_input">
    <label  style="margin:0% 0% 0% 8%;">
        	파일첨부
        <input type="file" name="filename" onchange="javascript:document.getElementById('file_route').value=this.value">
    </label>
    <input type="text" readonly="readonly" title="File Route" name="storedfile" value="${dto.board_storedfile}" id="file_route">
	</div>

  <br>
  <div style="text-align:center;">
    <input type="submit" value="수정완료" />
	<input type="button" value="글목록" onclick="location.href='boardlist2.do?pnum=1'" />
   </div>
  </form>
</div> 
<br><br><br>
	<jsp:include page="../Footer.jsp"/>
</body>
</html>