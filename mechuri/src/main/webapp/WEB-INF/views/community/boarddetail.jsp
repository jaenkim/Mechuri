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
<div id="img">
<div class="images">
	<c:choose> 
     		<c:when test="${dto.board_storedfile eq 'empty' }"> <!-- 펭귄 when은 if문 -->
      	<div style="background-image:url('images/mechu.png')" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text" ></div> 
      		</c:when> 	
      		<c:otherwise> <!-- 펭귄 otherwise는 else -->
        <div style="background-image:url('upload/${dto.board_storedfile}')" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text" ></div> 
        	</c:otherwise> 
	</c:choose>

</div>
</div>

<div class="container">
  
  <div class="row">
    <div id="writerDate"><fmt:formatDate value="${dto.board_regdate}" pattern="yyyy년 MM월 dd일" /></div>
    <div class="col-25">
      <label for="img" style="margin:10% 0% 0% 40%;">사진</label>
    </div>
    <div class="col-75">
      <div style="background-image:url('upload/${dto.board_storedfile}'); background-size:200px;  background-repeat:no-repeat; width:300px; height:300px; "  role="img"></div>
    </div>
  </div>

  <div class="row">
   <%--  <div id="writerDate"><fmt:formatDate value="${dto.board_regdate}" pattern="yyyy년 MM월 dd일" /></div> --%>
    <div class="col-25">
      <label for="title" style="margin:10% 0% 0% 40%;">제목</label>
    </div>
    <div class="col-75">
      <input type="text" id="title" name="titlename" value="${dto.board_title}" readonly="readonly" style="width:80%;">
    </div>
  </div>
  
  <div class="row">
    <div class="col-25">
      <label for="writernick" style="margin:5% 0% 0% 40%;">작성자</label>
    </div>
    <div class="col-75">
      <input type="text" id="writernick" name="writernick" value="${dto.board_nick}" readonly="readonly" style="width:80%;" >
    </div>
  </div>
  
  
  <div class="row">
    <div class="col-25">
      <label for="content" style="margin:5% 0% 0% 40%;">내용</label>
    </div>
    <div class="col-75">
      <textarea id="content" name="content" style="height:200px;width:80%;" readonly="readonly" >${dto.board_conts}</textarea>
    </div>
  </div>
  
  <br>
  <div style="text-align:center;">
	<c:choose>
  		<c:when test="${mem_nick eq dto.board_nick}">
  			<input type="button" value="수정" onclick="updateBoard()" />
			<input type="button" value="삭제" onclick="delBoard('${dto.board_no}')"/>
			<input type="button" value="해당 글목록" onclick="location.href='boardlist2.do?board_pnum=${board_pnum}'" />
  		</c:when>
  		<c:otherwise>
  			<input type="button" value="글목록" id="writelist" onclick="location.href='boardlist2.do?board_pnum=${board_pnum}'" />
  		</c:otherwise>
  	</c:choose>	
  </div>
  
<!--   <br> -->
<!--   <div> -->
<!--     <input type="button" value="취소" id="delete1"> -->
<!--     <input type="button" value="수정" id="update1"> -->
<!--    </div> -->

</div>

<!-- 여기부터 댓글 -->

 
<div class="container">
 <form action="replyboard.do" method="post" style="height:70px;">
<input type="hidden" name="board_no" value="${dto.board_no}" />
  <div class="row">
    <div class="col-25">
      <label for="reply">
      <input type="text" name="reply_nick" readonly="readonly" 
      value=
	   <c:choose>
	    	<c:when test="${naverNickname eq null}">
	    		${mem_nick}
	    	</c:when>
	  		 <c:otherwise>
	    		${naverNickname}
	    	 </c:otherwise>
	    </c:choose>
    	>

      </label>
    </div>

    <div class="col-75">
    	<div id="reply1">
      <input type="text" id="reply" name="reply_contents" required="required" placeholder="댓글을 작성해 주세요" style="width:85%;" />
      </div>
      <div id="replybtn1">
      <input type="submit" id="replybtn" value="작성"  />
    	</div>
    </div>
  </div>
  <br><br>
</form>

   
  
 <!--  댓글 출력되는 곳 -->

  <div>
  <c:forEach items="${replylist}" var="replylist">
        
		 <div id="replynick">
			<c:choose>
		   	 	<c:when test="${replylist.reply_new eq 'true'}"> 			
		    		<div id="replynick"><img src="${pageContext.request.contextPath }/images/new2.png" value="${replylist.reply_nick}" style="max-width:50%; height:auto;" /></div>
		    	</c:when>	
		    	<c:otherwise>
		    	
		    	</c:otherwise>		
			</c:choose>
			${replylist.reply_nick}
						
		 </div>   		
		 <div id="replycon" >${replylist.reply_conts}</div>
		 <div id="replyregdate"><fmt:formatDate value="${replylist.reply_regdate}"  pattern="yyyy-MM-dd HH:mm" /></div>
		 
		 <!-- 내 댓글만 삭제버튼 보이게처리 -->
		 
	<c:choose>
  		<c:when test="${mem_nick eq replylist.reply_nick }">
  			<input type="button" value="댓글삭제" class="button small" onclick="delReply('${replylist.reply_no}')">
  		</c:when>
  		<c:when test="${naverNickname eq replylist.reply_nick}">
  			<input type="button" value="댓글삭제" class="button small" onclick="delReply('${replylist.reply_no}')">
  		</c:when>
  		<c:otherwise>
  			
  		</c:otherwise>
  	</c:choose>	
  	
		 
  <!--	<input type="button" value="댓글삭제" class="button small" onclick="delReply('${replylist.reply_no}')">  댓글삭제버튼이 위의otherwise에들어가면 아예안나옴.. -->
    </c:forEach>
    </div>
</div>

<script type="text/javascript">
	//글 삭제하기 
	function delBoard(board_no) {
		location.href="boardDelete.do?board_no=${dto.board_no}"; 
	}
	//수정폼으로 이동
	function updateBoard(board_no) {
		location.href="updateForm.do?board_no=${dto.board_no}";
	}
	//댓글삭제 이동
	 function delReply(reply_no) {
		location.href="replyDelete.do?reply_no="+reply_no ; 
	} 
	
</script>

<jsp:include page="../Footer.jsp"/>
</body>
</html>