<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge; chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/notice.css" rel="stylesheet" />
<!-- Latest compiled and minified CSS -->
<title>CSS</title>
    <style>
        body {
            margin: 110px 150px;
        }
          
        h1.a:after {
            content: "";
            display: block;
            width: 1000px;
            border-bottom: 1px solid #bcbcbc;
            margin: 20px 0px;
        }
        
        h1.b {
            text-align: center;
        }
        
        h1.b:after {
            content: "";
            display: block;
            width: 60px;
            border-bottom: 1px solid #bcbcbc;
            margin: 20px auto;
        }
        .break {
        word-break:break-all;
        }
    </style>
  
</head>



<body>
    <h1 class="a">${doRead.title}</h1>
    <div class="break">                                  
        <h4>${doRead.contents}</h4>
    </div>  
</body>
<!--     <table style="border:1px solid #ccc" class="board_list"> -->
<%--         <caption>상세보기</caption> --%>
<%--         <colgroup> --%>
<%--             <col width="15%"> --%>
<%--             <col width="35%"> --%>
<%--             <col width="15%"> --%>
<%--             <col width="*"> --%>
<%--         </colgroup> --%>
         
<!--         <tbody> -->
<!--             <tr> -->
<!--                 <th>제목</th> -->
<%--                 <td>${doRead.title}</td> --%>

<!--             </tr> -->
<!--             <tr> -->
<!--                 <th>작성자</th> -->
<%--                 <td>${doRead.reg_num }</td> --%>
<!--                 <th>작성시간</th> -->
<%--                 <td>${doRead.reg_dt }</td> --%>
<!--             </tr> -->
<!--             <tr> -->
<!--                 <th>내용</th> -->
<!--                 <td colspan="3"> -->
<%--                     ${doRead.contents } --%>
<!--                 </td> -->
<!--             </tr> -->
<!--         </tbody> -->
<!--     </table> -->
<!--     <a href="#" id="list" class="btn">목록으로</a> -->



<!-- 모든 컴파일된 플러그인을 포함합니다  bootstrap js -->
<script type="text/javascript" src="/resources/jquery.min.js"></script>

<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
</html>
