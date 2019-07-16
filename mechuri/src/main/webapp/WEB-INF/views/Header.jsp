<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% 
	String seUsername="";
	String seNaverUsername="";
	try { 
		seUsername = (String)session.getAttribute("mem_name");
		seNaverUsername = (String)session.getAttribute("naverName");
		if (seNaverUsername==null) { 
			seNaverUsername="";
		}else if(seUsername == null){
			seUsername="";
		}
	} catch (Exception e) { 
		throw new ServletException(e);
	}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Title insert here</title>
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/style.min.css" />
<link rel="stylesheet" href="assets/css/modules.css" />
<style type="text/css">
#accordian li {
	list-style-type: none;
} 

/* 서브메뉴 스타일 */
#accordian ul ul li a {
	color: white;
	text-decoration: none;
	font-size: 11px;
	line-height: 27px;
	display: block;
	padding: 0 15px;
	-webkit-transition: all 0.15s;
	-moz-transition: all 0.15s;
	-o-transition: all 0.15s;
	-ms-transition: all 0.15s;
	transition: all 0.15s;
}

#accordian ul ul li a:hover {
	background: #003545;
	border-left: 5px solid #09c;
} 

/* active 클래스 외에 것은 보이지 않게 하기 */
#accordian ul ul {
	display: none;
}

#accordian li.active ul {
	display: block;
}
</style>
</head>
<body>

<!-- Header -->
	<header id="header"> 
		<nav class="left">
			<a href="#menu"><span>Menu</span></a>
		</nav>
			<a href="index.jsp" class="logo">Mechuri</a>
		<nav class="right">
		<% if (!seUsername.equals("")) {  
    				out.print(seUsername); %> 
 		<a style="color:black;" href="logout.do">로그아웃</a>
		<%} else if(!seNaverUsername.equals("")) { 
				out.print(seNaverUsername); %>
		<% } else{ } %>
		
		
<c:choose>
<c:when test="seNaverUsername eq ''">
<a href="/mechuri/memLogin.do" class="button alt">Log in</a>
</c:when>
<c:otherwise>	
<input type='button' value='Log in' style="display:none" >

<!-- <a href="/mechuri/memLogin.do" class="button alt">Log in</a> -->
</c:otherwise>
</c:choose>
		
</nav>
</header>

<!-- 우측 마이페이지 메뉴 -->
<!-- <nav id="menu"> -->
<!-- 	<div id="accordian"> -->
<!-- 		<ul> -->
<!-- 			<li> -->
<!-- 				<p> -->
<!-- 					<span class="icon-dashboard"></span>Dashboard -->
<!-- 				</p> -->
<!-- 				<ul> -->
<!-- 					<li><a href="#">Reports</a></li> -->
<!-- 					<li><a href="#">Search</a></li> -->
<!-- 					<li><a href="#">Graphs</a></li> -->
<!-- 					<li><a href="#">Settings</a></li> -->
<!-- 				</ul> -->
<!-- 			</li> -->
<!-- 			<li class="active"> -->
<!-- 				<p> -->
<!-- 					<span class="icon-tasks"></span>Tasks -->
<!-- 				</p> -->
<!-- 				<ul> -->
<!-- 					<li><a href="#">Today's tasks</a></li> -->
<!-- 					<li><a href="#">Urgent</a></li> -->
<!-- 					<li><a href="#">Overdues</a></li> -->
<!-- 					<li><a href="#">Recurring</a></li> -->
<!-- 					<li><a href="#">Settings</a></li> -->
<!-- 				</ul> -->
<!-- 			</li> -->
<!-- 			<li> -->
<!-- 				<p> -->
<!-- 					<span class="icon-calendar"></span>Calendar -->
<!-- 				</p> -->
<!-- 				<ul> -->
<!-- 					<li><a href="#">Team Calendar</a></li> -->
<!-- 					<li><a href="#">Private Calendar</a></li> -->
<!-- 					<li><a href="#">Settings</a></li> -->
<!-- 				</ul> -->
<!-- 			</li> -->
<!-- 			<li> -->
<!-- 				<p> -->
<!-- 					<span class="icon-heart"></span>Favourites -->
<!-- 				</p> -->
<!-- 				<ul> -->
<!-- 					<li><a href="#">Global favs</a></li> -->
<!-- 					<li><a href="#">My favs</a></li> -->
<!-- 					<li><a href="#">Team favs</a></li> -->
<!-- 					<li><a href="#">Settings</a></li> -->
<!-- 				</ul> -->
<!-- 			</li> -->
<!-- 		</ul> -->
<!-- 	</div> -->
<!-- </nav> -->
	
	
<!-- 헤더 네이게이션바 메뉴 -->
<!-- <section class="MOD_MENU" data-theme="_bgp"> -->
<!--   <div data-layout="_r" class="nopadding"> -->
<!--     <nav class="MOD_MENU_Nav"> -->
<!--       <p class="MOD_MENU_Title">Menu</p> -->
<!--       <svg class="MOD_MENU_Button" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="30px" height="30px" viewBox="0 0 30 30" enable-background="new 0 0 30 30" xml:space="preserve"> -->
<!--         <rect width="30" height="6"/> -->
<!--         <rect y="24" width="30" height="6"/> -->
<!--         <rect y="12" width="30" height="6"/> -->
<!--       </svg> -->
<!--       <ul class="AP_Menu_List"> -->
<!--         <li> -->
<!--           <a href="#" data-theme="_bgp">Menu Item</a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="#" data-theme="_bgp">Menu Item</a> -->
<!--           <ul> -->
<!--             <li> -->
<!--               <a href="#" data-theme="_bgpd">Sub-Menu Item</a> -->
<!--             </li> -->
<!--             <li> -->
<!--               <a href="#" data-theme="_bgpd">Sub-Menu Item long title</a> -->
<!--             </li> -->
<!--             <li> -->
<!--               <a href="#" data-theme="_bgpd">Sub-Menu Item</a> -->
<!--             </li> -->
<!--           </ul> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="#" data-theme="_bgp">Menu Item</a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="#" data-theme="_bgp">Menu Item</a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="#" data-theme="_bgp">Menu Item</a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a href="#" data-theme="_bgp">Menu Item</a> -->
<!--           <ul> -->
<!--             <li> -->
<!--               <a href="#" data-theme="_bgpd">Sub-Menu Item</a> -->
<!--             </li> -->
<!--             <li> -->
<!--               <a href="#" data-theme="_bgpd">Sub-Menu Item long title</a> -->
<!--             </li> -->
<!--             <li> -->
<!--               <a href="#" data-theme="_bgpd">Sub-Menu Item</a> -->
<!--             </li> -->
<!--           </ul> -->
<!--         </li> -->
<!--       </ul> -->
<!--     </nav> -->
<!--   </div> -->
<!-- </section> -->
<!--END MODULE AREA 2: Menu 1-->
			
			
			
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
	 		<script src="assets/js/HeaderMenu.js"></script> 

</body>
</html>