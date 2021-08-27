<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="ko">
<head>
<style type="text/css">

body, header, h1, h2, a, div, ul, li, form, input, button, span {
    margin: 0;
    padding: 0;
}
header {
    position: fixed;
    top: 0;
    left: 0; 
    right: 0;
    height: 75px;
    padding: 1rem;
    color: white;
    background: teal;
    font-weight: bold;
    display: flex;
    justify-content: space-between;
    align-items: center;
}
body {
    padding-top: 75px;
    background: #EEE;
}
ul{
    list-style:none;
}

.main_container {
    margin: 10%;
    padding: 5px;
}


</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/RPA_J08/asset_jsp/ed01/j07_request_view.jsp" method="post">
    <header>
  <h1><a href="#" class="moveToMain">청바치</a></h1>
  
  <div class="">
    <div class="">     
          <div class="topMenu">
            <ul>
              <li><a href="#">로그인</a></li>
              <li><a href="#">회원가입</a></li>
              <li><a href="#">마이페이지</a></li>
              <li><a href="#">공지사항</a></li>
            </ul>
          
            
          </div>
        </div>
  </div>
</header>
</form>
</body>
</html>