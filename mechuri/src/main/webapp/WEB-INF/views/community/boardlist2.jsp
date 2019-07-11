 <%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.sql.*,java.text.SimpleDateFormat,java.util.Date"%>
<!DOCTYPE html>
<html lang="en">
<!-- Start Head -->
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>커뮤니티 게시판</title>

	<link rel="stylesheet" href="commAssets/css/style.min.css">
	<link rel="stylesheet" href="commAssets/css/modules.css">
	<link rel="stylesheet" href="commAssets/css/button.css">
	

	<!-- Canonical URL usage -->
	<link rel="canonical" href="https://aperitif.io/">

	<!-- Facebook Open Graph -->
	<meta property="og:url"                content="https://aperitif.io/" />
	<meta property="og:title"              content="Aperitif | The web template generator" />
	<meta property="og:description"        content="Aperitif is a rapid web template generation tool." />
	<meta property="og:image"              content="https://aperitif.io/img/aperitif-facebook.png" />
	<meta property="og:image:width"        content="1200" />
	<meta property="og:image:height"       content="630" />

	<!-- Twitter Cards -->
	<meta name="twitter:card" content="summary_large_image">
	<meta name="twitter:site" content="@Aperitif">
	<meta name="twitter:creator" content="@Aperitif">
	<meta name="twitter:title" content="Aperitif - The web template generator">
	<meta name="twitter:description" content="Aperitif is a rapid web template generation tool.">
	<meta name="twitter:image" content="https://aperitif.io/img/aperitif-card.png">

	<!-- Google Structured Data -->
	<script type="application/ld+json">
	{
	"@context" : "http://schema.org",
	"@type" : "SoftwareApplication",
	"name" : "Aperitif",
	"image" : "https://aperitif.io/img/aperitif-logo.svg",
	"url" : "https://aperitif.io/",
	"author" : {
	  "@type" : "Person",
	  "name" : "Octavector"
	},
	"datePublished" : "2017-MM-DD",
	"applicationCategory" : "HTML"
	}
	</script>
	

</head>
<script>

</script>


<!-- End Head -->
<body class="default">
	<jsp:include page="../Header.jsp"/>
<!--
START MODULE AREA 1: header1
-->
<br><br><br><br>
<header class="MOD_HEADER1">
  <div data-layout="_r">
    <div data-layout="al16 de10" class="MOD_HEADER1_Title">
      <h1 class="MOD_HEADER1_TextLogo">메추리톡</h1>
      <p class="MOD_HEADER1_Slogan">메추리 회원들의 커뮤니티 공간입니다</p>
      <br>
      <button id= "postbutton" class="button" onclick="location.href='boardwrite.do'">글 쓰기</button>
    </div>
  </div>
</header>
<!--
END MODULE AREA 1: Header 1
-->

<!--
START MODULE AREA 2: Article Block 1
-->
<section data-theme="_bgp">



  <div data-layout="_r" class="MOD_ARTICLEBLOCKS1" a href="boardDetail.do?seq=${dto.board_no}">
  
  
  <c:forEach items="${list}" var="dto">
    <div data-layout="al16 ch8 ec4" class="MOD_ARTICLEBLOCKS1_Cont" >
      <a href="boardDetail.do?board_no=${dto.board_no}" class="MOD_ARTICLEBLOCKS1_BlockSmall">
     
      	
        <div style="background-image:url('upload/${dto.board_storedfile}')" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text" >${dto.board_fileno}</div> 
		
        <div class="MOD_ARTICLEBLOCKS1_Txt">
        <c:choose>
        	<c:when test="${dto.board_new eq 'true' }"> 
         		<h3 class="MOD_ARTICLEBLOCKS1_Title">${dto.board_title}</h3> 
           	<img src="${pageContext.request.contextPath}/images/new.png" />  
             </c:when> 
             <c:otherwise> 
             	<h3 class="MOD_ARTICLEBLOCKS1_Title">${dto.board_title}</h3> 
            </c:otherwise> 
        </c:choose>
         	
          <p class="MOD_ARTICLEBLOCKS1_Category">${dto.board_nick}</p>
        </div>
        
      </a>
    </div>


    </c:forEach> 
    </div>
   
 

</section>







<jsp:include page="../Footer.jsp"/>
</body>










<%-- <table border="1">
	<tr>	
		<th colspan='3'>이미지</th>
	</tr>
	<c:choose>
		<c:when test="${empty list}">
			<tr><td colspan="10">---작성된 글이 없습니다.---</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.board_originfile}</td>
					<td>${dto.board_title}</td>
					<td>${dto.board_nick}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<tr>
		<td colspan="10">
			<input type="button" value="글 추가" onclick="location.href='insertWrite.do'"/>
			<input type="submit" value="글삭제" />
		</td>
	</tr>
</table> --%>

	


</html>
			