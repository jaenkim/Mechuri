<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
  <div class="row">
    <div id="writerDate"><fmt:formatDate value="${dto.board_regdate}" pattern="yyyy년 MM월 dd일" /></div>
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
	<input type="button" value="글목록" onclick="location.href='boardlist2.do?pnum=1'" />
  </div>
  
<!--   <br> -->
<!--   <div> -->
<!--     <input type="button" value="취소" id="delete1"> -->
<!--     <input type="button" value="수정" id="update1"> -->
<!--    </div> -->

</div>


<!-- 여기부터 댓글 -->
 <form action="replyboard.do" method="post">
 
<div class="container">
<input type="hidden" name="board_no" value="${dto.board_no}" />
  <div class="row">
    <div class="col-25">
      <label for="reply"><input type="text" name="reply_nick" required="required" /></label>
    </div>
    <div class="col-75">
    	<div id="reply1">
      <input type="text" id="reply" name="reply_contents" required="required" />
      </div>
      <div id="replybtn1">
      <input type="submit" id="replybtn" value="작성"  />
    	</div>
    </div>
  </div>
  <br><br>
  
  
  
  <div>
  <c:forEach items="${replylist}" var="replylist">
   	 <div id="replyconts">
   	 
   	 
   	 
   	 <c:choose>
   	 	<c:when test="${replylist.reply_new eq 'true' }"> 
   	 	
    		<div id="replynick"><img src="${pageContext.request.contextPath}/images/new2.png" style="max-width:10%; height:auto;" />&nbsp;${replylist.reply_nick}</div>
    		<div id="replycon">${replylist.reply_conts}</div>
    		<div id="replyregdate"><fmt:formatDate value="${dto.board_regdate}" pattern="yyyy년 MM월 dd일" /></div>
   		 
    
    	</c:when>
    	<c:otherwise> 
            <div id="replynick">${replylist.reply_nick}</div>
    		<div id="replycon">${replylist.reply_conts}</div>
    		<div id="replyregdate">${replylist.reply_regdate}</div>
        </c:otherwise> 
    </c:choose>
    
    
    
    </div>
    </c:forEach>

    
  </div>
  
  
</div>
</form>
<br><br><br>
<jsp:include page="../Footer.jsp"/>


<script type="text/javascript">
	//글 삭제하기 
	function delBoard(board_no) {
		location.href="boardDelete.do?board_no=${dto.board_no}"; 
	}
	//수정폼으로 이동
	function updateBoard(board_no) {
		location.href="updateForm.do?board_no=${dto.board_no}";
	}
	
</script>


</body>
</html>