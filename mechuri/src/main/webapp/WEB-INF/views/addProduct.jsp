<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기업 제품 등록 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/bootstrap-theme.css" />
  <link rel="stylesheet" href="../css/bootstrap.css" />

</head>
<body>
<h3>신규 제품 등록</h3>
카테고리 <select>
 		 <option value="volvo">기초</option>
 		 <option value="saab">베이스</option>
		 <option value="opel">클렌징</option>
 		 <option value="audi">색조</option>
 		 <option value="volvo">선케어</option>
 		 <option value="saab">바디&핸드&풋</option>
		 <option value="opel">베이비&맘</option>
 		 <option value="audi">남성</option>
	 </select><br>
제품명: <input type="text"><br>
용량: <input type="text"><br>
가격: <input type="text"><br>
설명: <input type="text"><br>
성분정보: <input type="text"><br>
대표이미지: <input type="image" src="../images/banner.jpg"><br>



<form class="form-horizontal">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Sign in</button>
    </div>
  </div>
</form>




</body>
</html>