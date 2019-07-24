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
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/main.css">
	

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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-theme.css" />
<link rel="stylesheet" href="../css/bootstrap.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/botstrap.js"></script>	

</head>
<style>
	src {
		width:50px;
		height:50px;
	}
	.container-fluid {
		text-align:center;	
		font-size:20px;
		
	}
	
</style>


<!-- End Head -->
<body class="default">
<jsp:include page="../Header.jsp"/>
<section id="main" class="wrapper">
<div class="inner">
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
 
 
<section data-theme="_bgp">



  <div style="background-color:#f2f2f2;" data-layout="_r" class="MOD_ARTICLEBLOCKS1" a href="boardDetail.do?seq=${dto.board_no}">
  
  
  <c:forEach items="${list}" var="dto">
    <div data-layout="al16 ch8 ec4" class="MOD_ARTICLEBLOCKS1_Cont" >
    
    	
    
      <a href="boardDetail.do?board_no=${dto.board_no}" class="MOD_ARTICLEBLOCKS1_BlockSmall">
  
     	<c:choose> 
     		<c:when test="${dto.board_storedfile eq 'empty' }"> <!-- 펭귄 when은 if문 -->
      	<div style="background-image:url('images/mechu.png')" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text" ></div> 
      	</c:when> 	
      	<c:otherwise> <!-- 펭귄 otherwise는 else -->
        <div style="background-image:url('upload/${dto.board_storedfile}')" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text" ></div> 
        </c:otherwise> 
		</c:choose>
		<!-- 여기부터글 -->
        <div class="MOD_ARTICLEBLOCKS1_Txt">
        <c:choose>
        	<c:when test="${dto.board_new eq 'true' }"> 
         		<h3 class="MOD_ARTICLEBLOCKS1_Title">${dto.board_title}&nbsp;<img src="${pageContext.request.contextPath}/images/new2.png" style="max-width:15%; height:auto;" /> </h3> 
           	 
             </c:when> 
             <c:otherwise> 
             	<h3 class="MOD_ARTICLEBLOCKS1_Title">${dto.board_title}</h3> 
            </c:otherwise> 
        </c:choose>
         	
          <p class="MOD_ARTICLEBLOCKS1_Category">${dto.board_nick} </p>
        <div>조회: ${dto.board_count}</div>
        </div>
        
      </a>
    </div>


    </c:forEach> 
  
    
  
    </div>
    
    <!-- 페이징 -->
 	
    <div class="container-fluid" style="background-color:#f2f2f2;">

    	<c:forEach begin="1" end="${pcount}" step="1" var="i">
			<a href="boardlist2.do?board_pnum=${i}">[ ${i} ]</a>
		</c:forEach>

    </div> 
   
 

</section>
</div>
</section>
<jsp:include page="../Footer.jsp"/>
</body>





</html>
			