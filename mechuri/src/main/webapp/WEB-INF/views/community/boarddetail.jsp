<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 상세보기 폼</title>
<link rel="stylesheet" href="commAssets/css/boarddetail.css">
</head>
<body>
<jsp:include page="../Header.jsp"/>
<br><br><br>

<div class="container">
  <form action="#">
  <div class="row">
    <div id="writerDate">${dto.board_regdate}</div><br>
    <div class="col-25">
      <label for="title">제목</label>
    </div>
    <div class="col-75">
      <input type="text" id="title" name="titlename" value="${dto.board_title}" readonly="readonly">
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="writernick">작성자</label>
    </div>
    <div class="col-75">
      <input type="text" id="writernick" name="writernick" value="${dto.board_nick}" readonly="readonly">
    </div>
  </div>
  
  
  <div class="row">
    <div class="col-25">
      <label for="content">내용</label>
    </div>
    <div class="col-75">
      <textarea id="content" name="content" style="height:200px" readonly="readonly">${dto.board_conts}</textarea>
    </div>
  </div>
  
  <br>
  <div>
	<input type="button" value="수정" onclick="updateBoard()" />
	<input type="button" value="삭제" onclick="delBoard('${dto.board_no}')"/>
	<input type="button" value="글목록" onclick="location.href='boardlist2.do'" />
  </div>
  
<!--   <br> -->
<!--   <div> -->
<!--     <input type="button" value="취소" id="delete1"> -->
<!--     <input type="button" value="수정" id="update1"> -->
<!--    </div> -->
  </form>
</div>

<div class="container">
  <form action="#">
  <div class="row">
    <div class="col-25">
      <label for="reply">댓글</label>
    </div>
    <div class="col-75">
    	<div id="reply1">
      <input type="text" id="reply" name="reply" placeholder="로그인 하면 댓글을 작성할 수 있어요!">
      </div>
      <div id="replybtn1">
      <input type="button" id="replybtn" value="작성"/>
    	</div>
    </div>
  </div>
  <br><br>
  <div>
    <div id="replyconts">
    	<div id="replynick">승승</div>
    	<div id="replycon">선크림 좋아요 선크림 사세요!</div>
    	<div id="replyregdate">2019-07-03</div>
    </div>
    
     <div id="replyconts">
    	<div id="replynick">미라</div>
    	<div id="replycon">립스틱 사야겠다...</div>
    	<div id="replyregdate">2019-07-03</div>
    </div>
    
     <div id="replyconts">
    	<div id="replynick">재워니</div>
    	<div id="replycon">헐 원쁠원?</div>
    	<div id="replyregdate">2019-07-03</div>
    </div>
    
    
     <div id="replyconts">
    	<div id="replynick">으뇽</div>
    	<div id="replycon">갔더니 거의 품절이네요ㅠ</div>
    	<div id="replyregdate">2019-07-03</div>
    </div>
    
  </div>
  
  </form>
</div>
<br><br><br>
<jsp:include page="../Footer.jsp"/>


<script type="text/javascript">
	//글 삭제하기 
	function delBoard(board_no) {
		location.href="boardDelete.do?board_no=${dto.board_no}"; 
	}
	//수정폼으로 이동
	function updateBoard() {
		location.href="updateForm.do?board_no=${dto.board_no}";
	}
	
</script>


</body>
</html>