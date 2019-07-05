<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

  <div data-layout="_r" class="MOD_ARTICLEBLOCKS1">
    <div data-layout="al16 ch8 ec4" class="MOD_ARTICLEBLOCKS1_Cont">
      <a href="#" class="MOD_ARTICLEBLOCKS1_BlockSmall">
      
      	<c:forEach items="${list}" var="dto">
        <div style="background-image:url('images/mechu.png')" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text">${dto.board_fileno }</div> <!-- 펭귄이미지 -->

        <div class="MOD_ARTICLEBLOCKS1_Txt">
          <h3 class="MOD_ARTICLEBLOCKS1_Title">${dto.board_title}</h3>
          <p class="MOD_ARTICLEBLOCKS1_Category">${dto.board_nick}</p>
        </div>
        </c:forEach> 
      </a>
    </div>

    
    <div data-layout="al16 ch8 ec4" class="MOD_ARTICLEBLOCKS1_Cont">
      <a href="#" class="MOD_ARTICLEBLOCKS1_BlockSmall">
        <div style="background-image:url('images/mechu.png')" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text"></div>

        <div class="MOD_ARTICLEBLOCKS1_Txt">
          <h3 class="MOD_ARTICLEBLOCKS1_Title">미스트 강추!</h3>
          <p class="MOD_ARTICLEBLOCKS1_Category">으녕으녕</p>
        </div>
      </a>
    </div>
    <div data-layout="al16 ch8 ec4" class="MOD_ARTICLEBLOCKS1_Cont">
      <a href="#" class="MOD_ARTICLEBLOCKS1_BlockSmall">
        <div style="background-image:url('images/mechu.png')" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text"></div>

        <div class="MOD_ARTICLEBLOCKS1_Txt">
          <h3 class="MOD_ARTICLEBLOCKS1_Title">이니스프리 세일한대여</h3>
          <p class="MOD_ARTICLEBLOCKS1_Category">미라미라</p>
        </div>
      </a>
    </div>
    
    <div data-layout="al16 ch8 ec4" class="MOD_ARTICLEBLOCKS1_Cont">
      <a href="#" class="MOD_ARTICLEBLOCKS1_BlockSmall">
        <div style="background-image:url('images/mechu.png')" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text"></div>

        <div class="MOD_ARTICLEBLOCKS1_Txt">
          <h3 class="MOD_ARTICLEBLOCKS1_Title">여름철 피부관리 꿀팁!</h3>
          <p class="MOD_ARTICLEBLOCKS1_Category">재현아니고재원</p>
        </div>
      </a>
    </div>
    
    
    
        <div data-layout="al16 ch8 ec4" class="MOD_ARTICLEBLOCKS1_Cont">
      <a href="#" class="MOD_ARTICLEBLOCKS1_BlockSmall">
        <div style="background-image:url('images/mechu.png')" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text"></div>

        <div class="MOD_ARTICLEBLOCKS1_Txt">
          <h3 class="MOD_ARTICLEBLOCKS1_Title">선크림 TOP3 추천</h3>
          <p class="MOD_ARTICLEBLOCKS1_Category">형근쓰</p>
        </div>
      </a>
    </div>



    <div data-layout="al16 ch8 ec4" class="MOD_ARTICLEBLOCKS1_Cont">
      <a href="#" class="MOD_ARTICLEBLOCKS1_BlockSmall">
        <div style="background-image:url('images/mechu.png')" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text"></div>

        <div class="MOD_ARTICLEBLOCKS1_Txt">
          <h3 class="MOD_ARTICLEBLOCKS1_Title">트러블 자국 케어법</h3>
          <p class="MOD_ARTICLEBLOCKS1_Category">혜0</p>
        </div>
      </a>
    </div>
    
    
        <div data-layout="al16 ch8 ec4" class="MOD_ARTICLEBLOCKS1_Cont">
      <a href="#" class="MOD_ARTICLEBLOCKS1_BlockSmall">
        <div style="background-image:url('images/mechu.png')" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text"></div>

        <div class="MOD_ARTICLEBLOCKS1_Txt">
          <h3 class="MOD_ARTICLEBLOCKS1_Title">헤어스프레이 추천할게요ㅋㅋ</h3>
          <p class="MOD_ARTICLEBLOCKS1_Category">상희상희</p>
        </div>
      </a>
    </div>
    
        <div data-layout="al16 ch8 ec4" class="MOD_ARTICLEBLOCKS1_Cont">
      <a href="#" class="MOD_ARTICLEBLOCKS1_BlockSmall">
        <div style="background-image:url('images/mechu.png')" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text"></div>

        <div class="MOD_ARTICLEBLOCKS1_Txt">
          <h3 class="MOD_ARTICLEBLOCKS1_Title">올리브영 세일 언제해요?</h3>
          <p class="MOD_ARTICLEBLOCKS1_Category">강쌤</p>
        </div>
      </a>
    </div>
    
    
      <div data-layout="al16 ch8 ec4" class="MOD_ARTICLEBLOCKS1_Cont">
      <a href="#" class="MOD_ARTICLEBLOCKS1_BlockSmall">
        <div style="background-image:url('images/mechu.png')" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text"></div>

        <div class="MOD_ARTICLEBLOCKS1_Txt">
          <h3 class="MOD_ARTICLEBLOCKS1_Title">올리브영 세일 언제해요?</h3>
          <p class="MOD_ARTICLEBLOCKS1_Category">강쌤</p>
        </div>
      </a>
    </div>
    
  </div>
  

</section>

<jsp:include page="../Footer.jsp"/>
</body>

</html>
			