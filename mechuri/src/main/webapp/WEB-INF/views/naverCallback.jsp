<%@ page language="java" contentType="text/html; charset=EUC-KR"   pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
<head>
    <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
 
<body>
    <script type="text/javascript">
          var naver_id_login = new naver_id_login("{_1g9pc8r0RyK3g8Zeg9_}", "http://localhost:8888/mechuri/callback.do");
          // ���� ��ū �� ���
          //alert(naver_id_login.oauthParams.access_token);
          
          // ���̹� ����� ������ ��ȸ
          naver_id_login.get_naver_userprofile("naverSignInCallback()");
          
          // ���̹� ����� ������ ��ȸ ���� ������ ������ ó���� callback function
          function naverSignInCallback() {
            var id = naver_id_login.getProfileData('id')+"@n";
            var nickname = naver_id_login.getProfileData('name');
            //var email = naver_id_login.getProfileData('email');
            
            $.ajax({
                 url : "/memLogin"+id,
                     headers : {
                     "Accept" : "application/json",
                     "Content-Type" : "application/json"
                  },
                  success : function(idChk){
                      
                     if(idChk==true){ //DB�� ���̵� ���� ��� => ȸ������
                          console.log("ȸ��������...");
                          $.ajax({
                              url : "/signUp",
                              method : "POST",
                              headers : {
                                "Accept" : "application/json",
                                "Content-Type" : "application/json"
                              },
                              data : JSON.stringify({
                                  userId : id,
                                userName : nickname,
                                  password : "naver123",
                              }),
                              success : function(JSONData){
                                 alert("ȸ�������� ���������� �Ǿ����ϴ�.");
                                 window.close();
                                 top.opener.location="/user/snsLogin/"+id;
                              }
                          })
                      }
                      if(idChk==false){ //DB�� ���̵� ������ ��� => �α���
                          console.log("�α��� ��...");
                          window.close();
                          top.opener.location="/user/snsLogin/"+id;
                      }
                  }
            })
            
          }
    </script>
    
    <form name="defaultForm">
    </form>
    
</body>
</html>

