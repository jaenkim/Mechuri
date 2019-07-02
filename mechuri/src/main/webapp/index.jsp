<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mechuri</title>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Aperitif - Custom Template</title>

	<link rel="stylesheet" href="assets/css/style.min.css">
	<link rel="stylesheet" href="assets/css/modules.css">
	<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap&subset=korean" rel="stylesheet">
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
<body class="default">
<jsp:include page="WEB-INF/views/Header.jsp" />

<!--
START MODULE AREA 2: Menu 1
-->
<!-- <section class="MOD_MENU" data-theme="_bgp">
  <div data-layout="_r" class="nopadding">
    <nav class="MOD_MENU_Nav">
      <p class="MOD_MENU_Title">Menu</p>
      <svg class="MOD_MENU_Button" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="30px" height="30px" viewBox="0 0 30 30" enable-background="new 0 0 30 30" xml:space="preserve">
        <rect width="30" height="6"/>
        <rect y="24" width="30" height="6"/>
        <rect y="12" width="30" height="6"/>
      </svg>
      <ul class="AP_Menu_List">
        <li>
          <a href="#" data-theme="_bgp">Menu Item</a>
        </li>
        <li>
          <a href="#" data-theme="_bgp">Menu Item</a>
          <ul>
            <li>
              <a href="#" data-theme="_bgpd">Sub-Menu Item</a>
            </li>
            <li>
              <a href="#" data-theme="_bgpd">Sub-Menu Item long title</a>
            </li>
            <li>
              <a href="#" data-theme="_bgpd">Sub-Menu Item</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="#" data-theme="_bgp">Menu Item</a>
        </li>
        <li>
          <a href="#" data-theme="_bgp">Menu Item</a>
        </li>
        <li>
          <a href="#" data-theme="_bgp">Menu Item</a>
        </li>
        <li>
          <a href="#" data-theme="_bgp">Menu Item</a>
          <ul>
            <li>
              <a href="#" data-theme="_bgpd">Sub-Menu Item</a>
            </li>
            <li>
              <a href="#" data-theme="_bgpd">Sub-Menu Item long title</a>
            </li>
            <li>
              <a href="#" data-theme="_bgpd">Sub-Menu Item</a>
            </li>
          </ul>
        </li>
      </ul>
    </nav>
  </div>
</section> -->
<!--END MODULE AREA 2: Menu 1-->

<!--
START MODULE AREA 3: Hero 1
-->
<section class="MOD_HERO" style="background-image:url(images/banner003.jpg)">
  <div data-layout="_r">
    <div data-layout="de10">
      <h1>당신에게 맞는 화장품을 찾아보세요</h1>
      <h3>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</h3>
      <a href="#" class="btn">Read more</a>
    </div>
  </div>
</section>
<!--END MODULE AREA 3: Hero 1-->

<!-- 공동구매 -->
<!--START MODULE AREA 4: Feature 1-->
<section class="MOD_FEATURE">
  <div data-layout="_r">
  <div class="groupbuyingHeader">
  <p class="groupbuyingHeader"> 공동구매
  </div>
      <div data-layout="ch8 ec4">
      <a href="#" class="MOD_FEATURE_Container">
        <img class="MOD_FEATURE_Picture" src="images/product01.jpg" alt="">
        <div class="MOD_FEATURE_TextContainer">
          <p class="MOD_FEATURE_Title" data-theme="_ts2">Feature title</p>
          <p class="MOD_FEATURE_Description">제품명: </p>
          <p class="MOD_FEATURE_Description">가격:  </p>
          <p class="MOD_FEATURE_Description">판매종료일:  </p>
        </div>
      </a>
    </div>
    <div data-layout="ch8 ec4">
      <a href="#" class="MOD_FEATURE_Container">
        <img class="MOD_FEATURE_Picture" src="images/product02.jpg" alt="">
        <div class="MOD_FEATURE_TextContainer">
          <p class="MOD_FEATURE_Title" data-theme="_ts2">Feature title</p>
          <p class="MOD_FEATURE_Description">제품명: </p>
          <p class="MOD_FEATURE_Description">가격:  </p>
          <p class="MOD_FEATURE_Description">판매종료일:  </p>
        </div>
      </a>
    </div>
    <div data-layout="ch8 ec4">
      <a href="#" class="MOD_FEATURE_Container">
        <img class="MOD_FEATURE_Picture" src="images/product03.jpg" alt="">
        <div class="MOD_FEATURE_TextContainer">
          <p class="MOD_FEATURE_Title" data-theme="_ts2">Feature title</p>
          <p class="MOD_FEATURE_Description">제품명: </p>
          <p class="MOD_FEATURE_Description">가격:  </p>
          <p class="MOD_FEATURE_Description">판매종료일:  </p>
        </div>
      </a>
    </div>
    <div data-layout="ch8 ec4">
      <a href="#" class="MOD_FEATURE_Container">
        <img class="MOD_FEATURE_Picture" src="images/product04.jpg" alt="">
        <div class="MOD_FEATURE_TextContainer">
          <p class="MOD_FEATURE_Title" data-theme="_ts2">Feature title</p>
          <p class="MOD_FEATURE_Description">제품명: </p>
          <p class="MOD_FEATURE_Description">가격:  </p>
          <p class="MOD_FEATURE_Description">판매종료일:  </p>
        </div>
      </a>
    </div>
  </div>
</section>
<!--
END MODULE AREA 4: Feature 1
-->

<!--
START MODULE AREA 5: Article Block 1
-->
<section data-theme="_bgp">
  <div data-layout="_r" class="MOD_ARTICLEBLOCKS1">
    <div data-layout="al16 ec8" class="MOD_ARTICLEBLOCKS1_Cont">
      <a href="#" class="MOD_ARTICLEBLOCKS1_BlockLarge">
        <div style="background-image:url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/96252/aperitif-large-object1-luca-bravo.jpg)" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text"></div>
        <div class="MOD_ARTICLEBLOCKS1_Txt">
          <h3 class="MOD_ARTICLEBLOCKS1_Title">Article Title</h3>
          <p class="MOD_ARTICLEBLOCKS1_Category">Category</p>
        </div>
      </a>
    </div>
    <div data-layout="al16 ch8 ec4" class="MOD_ARTICLEBLOCKS1_Cont">
      <a href="#" class="MOD_ARTICLEBLOCKS1_BlockSmall">
        <div style="background-image:url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/96252/aperitif-large-object1-luca-bravo.jpg)" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text"></div>

        <div class="MOD_ARTICLEBLOCKS1_Txt">
          <h3 class="MOD_ARTICLEBLOCKS1_Title">Article Title</h3>
          <p class="MOD_ARTICLEBLOCKS1_Category">Category</p>
        </div>
      </a>
    </div>
    <div data-layout="al16 ch8 ec4" class="MOD_ARTICLEBLOCKS1_Cont">
      <a href="#" class="MOD_ARTICLEBLOCKS1_BlockSmall">
        <div style="background-image:url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/96252/aperitif-large-object1-luca-bravo.jpg)" class="MOD_ARTICLEBLOCKS1_Img" role="img" aria-label="alt text"></div>

        <div class="MOD_ARTICLEBLOCKS1_Txt">
          <h3 class="MOD_ARTICLEBLOCKS1_Title">Article Title</h3>
          <p class="MOD_ARTICLEBLOCKS1_Category">Category</p>
        </div>
      </a>
    </div>


  </div>
</section>
<!--
END MODULE AREA 5: Article Block 1
-->

<!--
START MODULE AREA 6: Footer 2
-->
<footer>
  <div class="MOD_FOOTER2" data-theme="_bgd">
    <div data-layout="_r">
      <div data-layout="al16 ch8 ch-o1 ec-third ec-o1">
        <h3>Links</h3>
        <nav>
          <ul>
            <li><a href="#">Footer Link 1</a></li>
            <li><a href="#">Footer Link 2</a></li>
            <li><a href="#">Footer Link 3</a></li>
            <li><a href="#">Footer Link 4</a></li>
            <li><a href="#">Footer Link 5</a></li>
          </ul>
        </nav>
      </div>
      <div data-layout="al16 ch-o3 ec-third ec-o2">
        <h3>Contact</h3>
        <!-- Facebook SVG -->
        <div class="MOD_FOOTER2_Icons">
          <a href="#" class="smIcon"><svg class="fb" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0v24h24v-24h-24zm16 7h-1.923c-.616 0-1.077.252-1.077.889v1.111h3l-.239 3h-2.761v8h-3v-8h-2v-3h2v-1.923c0-2.022 1.064-3.077 3.461-3.077h2.539v3z"/></svg></a>
          <!-- Twitter SVG -->
          <a href="#" class="smIcon"><svg class="tw" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0v24h24v-24h-24zm18.862 9.237c.208 4.617-3.235 9.765-9.33 9.765-1.854 0-3.579-.543-5.032-1.475 1.742.205 3.48-.278 4.86-1.359-1.437-.027-2.649-.976-3.066-2.28.515.098 1.021.069 1.482-.056-1.579-.317-2.668-1.739-2.633-3.26.442.246.949.394 1.486.411-1.461-.977-1.875-2.907-1.016-4.383 1.619 1.986 4.038 3.293 6.766 3.43-.479-2.053 1.079-4.03 3.198-4.03.944 0 1.797.398 2.396 1.037.748-.147 1.451-.42 2.085-.796-.245.767-.766 1.41-1.443 1.816.664-.08 1.297-.256 1.885-.517-.44.656-.997 1.234-1.638 1.697z"/></svg></a>
          <!-- LinkedIn SVG -->
          <a href="#" class="smIcon"><svg class="li" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0v24h24v-24h-24zm8 19h-3v-11h3v11zm-1.5-12.268c-.966 0-1.75-.79-1.75-1.764s.784-1.764 1.75-1.764 1.75.79 1.75 1.764-.783 1.764-1.75 1.764zm13.5 12.268h-3v-5.604c0-3.368-4-3.113-4 0v5.604h-3v-11h3v1.765c1.397-2.586 7-2.777 7 2.476v6.759z"/></svg></a>
          <!-- Google Plus SVG-->
          <a href="#" class="smIcon"><svg class="gp" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0v24h24v-24h-24zm8.667 16.667c-2.581 0-4.667-2.087-4.667-4.667s2.086-4.667 4.667-4.667c1.26 0 2.313.46 3.127 1.22l-1.267 1.22c-.347-.333-.954-.72-1.86-.72-1.593 0-2.893 1.32-2.893 2.947s1.3 2.947 2.893 2.947c1.847 0 2.54-1.327 2.647-2.013h-2.647v-1.6h4.406c.041.233.074.467.074.773 0 2.666-1.787 4.56-4.48 4.56zm11.333-4h-2v2h-1.333v-2h-2v-1.333h2v-2h1.333v2h2v1.333z"/></svg></a>
          <!-- Pinterest SVG -->
          <a href="#" class="smIcon"><svg class="pi" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M0 0v24h24v-24h-24zm12 20c-.825 0-1.62-.125-2.369-.357.326-.531.813-1.402.994-2.098l.499-1.901c.261.498 1.023.918 1.833.918 2.413 0 4.151-2.219 4.151-4.976 0-2.643-2.157-4.62-4.932-4.62-3.452 0-5.286 2.317-5.286 4.841 0 1.174.625 2.634 1.624 3.1.151.07.232.039.268-.107l.222-.907c.019-.081.01-.15-.056-.23-.331-.4-.595-1.138-.595-1.825 0-1.765 1.336-3.472 3.612-3.472 1.965 0 3.341 1.339 3.341 3.255 0 2.164-1.093 3.663-2.515 3.663-.786 0-1.374-.649-1.185-1.446.226-.951.663-1.977.663-2.664 0-.614-.33-1.127-1.012-1.127-.803 0-1.448.831-1.448 1.943 0 .709.239 1.188.239 1.188s-.793 3.353-.938 3.977c-.161.691-.098 1.662-.028 2.294-2.974-1.165-5.082-4.06-5.082-7.449 0-4.418 3.582-8 8-8s8 3.582 8 8-3.582 8-8 8z"/></svg></a>
        </div>
        <p>Email: <a href="mailto:#">email@email.com</a><br>Phone: <a href="tel:#">01234 567 8910</a>
        </p>
        <p>Copyright &copy; 2017 Company</p>
      </div>
      <div data-layout="al16 ch8 ch-o2 ec-third ec-o3">
        <h3>Address</h3>
          <address>
            123 The High Street<br>
            The Town<br>
            The City<br>
            County / State<br>
            Postal / Zip Code
          </address>
      </div>
    </div>
  </div>
</footer>
<!--
END MODULE AREA 6: Footer 2
-->

<script src="assets/js/index.js"></script>
</body>

</html>