<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String CP = request.getContextPath();
    CP = CP+"/resources" ;
%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

<link href="<%=CP %>/css/bootstrap.min.css" rel="stylesheet">   
   
<title>boot hello 2021. 8. 9.</title>
</head>
<body>
   <h2>Hello,world! 2021. 8. 9.</h2>
   <hr>
   <!--디자인:html-->   
   
   
   <!--//디자인:html ------------------------------------------------------------>
   
   <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
   <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
   <script type="text/javascript" src="<%=CP %>/js/jquery.js"></script>
   
   <!-- 모든 컴파일된 플러그인을 포함합니다  bootstrap js -->
   <script type="text/javascript" src="<%=CP %>/js/bootstrap.min.js"></script>
   
   <!-- 사용자 정의 JavaScript -->
   <script type="text/javascript">
    $(document).ready(function(){
    	 console.log("jquery.");
    });
   
   </script>
   <!--// 사용자 정의 JavaScript ------------------------------------------------->
</body>
</html>