<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 작성하기</title>
<link rel="stylesheet" href="commAssets/css/boarddetail.css">
	

</head>
<body>
<jsp:include page="../Header.jsp"/>

<br><br><br>
<div class="container">
  <form action="insertWrite.do" method="post" enctype="multipart/form-data">
  <div class="row">
  	<%-- <div class="col-25">
      <label for="title">닉네임</label>
    </div>
    <div class="col-75">
      <input type="text" id="title" name="nickname" value="${naverNickname}" readonly="readonly">
    </div> --%>
    
    
    	
    
  			<div class="col-25">
      			<label for="title"  style="margin:5% 0% 0% 40%;">닉네임</label>
    		</div>
    		<div class="col-75">
      			<input type="text" id="title" style="width:80%;" readonly="readonly" name="nickname" value=
      				<c:choose>
    					<c:when test="${naverNickname eq null}">
    						${mem_nick}
    					</c:when>
  		 				<c:otherwise>
    						${naverNickname}
    	 				</c:otherwise>
    				</c:choose> />		
     		</div>
  		
  		   
    <div class="col-25">
      <label for="title" style="margin:5% 0% 0% 40%;">제목</label>
    </div>
    <div class="col-75">
      <input type="text" id="title" required="required" name="titlename" style="width:80%;" >
    </div>
  </div>
 
  <div class="row">
    <div class="col-25">
      <label for="content" style="margin:5% 0% 0% 40%;">내용</label>
    </div>
    <div class="col-75">
      <input type="text" id="content" name="content" required="required" style="height:200px; width:80%;" >
    </div>
  </div>
  <br>
  <br>
	<div class="file_input">
    <label style="margin:0% 0% 0% 8%;">파일첨부
   	 <input type="file" name="filename" onchange="javascript:document.getElementById('file_route').value=this.value"/>
    </label>
    <input type="text" readonly="readonly" title="File Route" id="file_route">
    
	</div>

  <br>
  <div>
    <input type="button" value="글목록" id="cancel1" onclick="location.href='boardlist2.do?board_pnum=1'" />
    <input type="submit" value="작성" id="submit1">
  </div>
  </form>
</div>
<br><br><br>
<jsp:include page="../Footer.jsp"/>
</body>
</html>