<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%
   request.setCharacterEncoding("UTF-8");
%>
<%
   response.setContentType("text/html;charset=UTF-8");
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
   String seUsername = "";
   String seNaverUsername = "";
   try {
      seUsername = (String) session.getAttribute("mem_name");
      seNaverUsername = (String) session.getAttribute("naverName");
      if (seNaverUsername == null) {
         seNaverUsername = "";
      }
      if (seUsername == null) {
         seUsername = "";
      }
   } catch (Exception e) {
      throw new ServletException(e);
   }

   String seId = "";
   try {
      seId = (String) session.getAttribute("mem_id");
      if (seId == null) {
         seId = "";
      }
   } catch (Exception e) {
      throw new ServletException(e);
   }

   String sePw = "";
   try {
      seId = (String) session.getAttribute("mem_pw");
      if (seId == null) {
         sePw = "";
      }
   } catch (Exception e) {
      throw new ServletException(e);
   }
   
   String seStatus = "";
   try {
      seStatus = (String) session.getAttribute("mem_status");
      if (seStatus == null) {
         seStatus = "";
      }
   } catch (Exception e) {
      throw new ServletException(e);
   }
   
   String naverStatus = "";
   try{
      naverStatus = (String)session.getAttribute("naverStatus");
      if(naverStatus == null){
         naverStatus = "";
      }
      
   }catch(Exception e){
      throw new ServletException(e);
   }

   String seBrand = "";
   try {
      seBrand = (String) session.getAttribute("mem_brand");
      if (seBrand == null) {
         seBrand = "";
      }
   } catch (Exception e) {
      throw new ServletException(e);
   }

   String seNick = "";
   try {
      seNick = (String) session.getAttribute("mem_nick");
      if (seNick == null) {
         seNick = "";
      }
   } catch (Exception e) {
      throw new ServletException(e);
   }
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/rightMenu.css" />
</head>
<body>


   <!-- Header -->
   <% if(seUsername.equals("") && seNaverUsername.equals("")){ %>
   <header id="header">
   <a href="index.jsp" class="logo">Mechuri</a>
   <nav class="right"><a href="/mechuri/login.do" class="button alt" style="margin-top:20%">Log in</a>
   </nav>
   </header>
   
<%}else{ %>   
 
 <header id="header">
   <nav class="left"> <a href="#menu"><span>Menu</span></a></nav>
   <a href="index.jsp" class="logo">Mechuri</a>
   <nav class="right">
 <%
      if (!seUsername.equals("")) {
         out.print(seUsername);
   %> <a style="color: black;" href="logout.do">로그아웃</a> 
   
   <%
    } 
      else if (!seNaverUsername.equals("")) {
       out.print(seNaverUsername); %> 
       <a style="color: black;" href="logout.do">로그아웃</a> 
  <!--      <span>네이버에서 완전히 로그아웃해야합니다.</span> -->
    <% } else { %>
  <a href="/mechuri/login.do" class="button alt">Log in</a>
<% } %>

   </nav> 




      <!-- Menu -->
   <!-- 우측 마이페이지 메뉴 -->
<%  if (seStatus.equals("")) { }%>

<%  if (seStatus.equals("M")||naverStatus.equals("M")) { %>
         <nav id="menu">
               <ul class="links">
               <li><a href="userInfo.do">개인정보 수정</a></li>
               <li><a href="myboardlist.do">내 글보기</a></li>
               <li><a href="myreplylist.do">내 댓글 보기</a></li>
               <li><a href="myreviewlist.do">내 리뷰 보기</a></li>
               <li><a href="msglist.do">쪽지함</a></li>
               </ul>
            <ul class="actions vertical">
               <li><a href="#" class="button fit">Login</a></li>
            </ul>
         </nav>

<% } %>   
   
   
<!-- 기업회원 -->
<% if (seStatus.equals("C")) {%> 

   <nav id="menu">
               <ul class="links">
               <li><a href="ProductList.do">자사제품 전체보기</a></li>
               <li><a href="addProductForm.do">제품등록 신청하기</a></li>
               <li><a href="comInfo.do">기업정보 보기/수정</a></li>
               <li><a href="msglist.do">쪽지함</a></li>
               </ul>
            <ul class="actions vertical">
               <li><a href="#" class="button fit">Login</a></li>
            </ul>
         </nav>

<% } %>   



<!-- 관리자 -->
<% if (seStatus.equals("A")) {%> 


   <nav id="menu">
               <ul class="links">
               <li><a href="userManage.do">일반회원 목록보기</a></li>
               <li><a href="comUserManage.do">기업회원 가입승인/목록보기</a></li>
               <li><a href="productadminlist.do">제품등록/수정 승인</a></li>
               <li><a href="allmsgsend.do">쪽지 발송</a></li>    
               </ul>
            <ul class="actions vertical">
               <li><a href="#" class="button fit">Login</a></li>
            </ul>
         </nav>

<% }} %>      



      <!-- Scripts -->
         <script src="assets/js/jquery.min.js"></script>
         <script src="assets/js/jquery.scrolly.min.js"></script>
         <script src="assets/js/skel.min.js"></script>
         <script src="assets/js/util.js"></script>
         <script src="assets/js/main.js"></script>

<div id="wholeSidenav" class="wholesidenav">
  <a href="list.do" id="ranking" style="line-height: 40px;">메추리 랭킹</a>
  <a href="boardlist2.do" id="community" style="line-height: 40px;">메추리톡</a>
  <a href="listSearch.do" id="search" style="line-height: 40px;">제품검색</a>
</div>

</header>
</html>