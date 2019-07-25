<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<button onclick="GoTop()" id="goTop" class="button alt" title="Go to top" style="position: fixed; z-index: 1; bottom: 20px; right: 10px;" >Top</button>

<script>
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    document.getElementById("goTop").style.display = "block";
  } else {
    document.getElementById("goTop").style.display = "none";
  }
}

// When the user clicks on the button, scroll to the top of the document
function GoTop() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}
</script>
</body>
</html>