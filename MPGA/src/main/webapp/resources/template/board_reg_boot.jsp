<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="/cmn/no_cache.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->

<link rel="icon" type="image/x-icon"  href="${CP }/resources/k_favicon.ico">
<link href="${CP }/resources/css/bootstrap.min.css" rel="stylesheet">   

<!-- 부가적 테마:  -->
<link href="${CP }/resources/css/bootstrap-theme.css" rel="stylesheet">  

<!-- javascript 공통변수 -->
<script src="${CP }/resources/js/cmn/cmn.js"></script>
  
<title>boot hello 2021. 8. 9.</title>
</head>
<body>
   <!-- contents -->
   <div class="container">
      <!-- 제목 -->
      <div class="page-header">
        <h2>게시판 등록</h2>
      </div>	
      <!--// 제목 -------------------------------------------------------------->
      
      <!-- 버튼 -->
      <div class="row text-right">
        <label class="col-xs-6 col-md-2"></label>    
        <div   class="col-xs-6 col-md-10">
          <input class="btn btn-default btn-primary btn-sm" type="button" value="목록" id="moveToList">
          <input class="btn btn-default btn-primary btn-sm" type="button" value="등록" id="doInsert">
        </div>
      </div>
      <!--// 버튼 -------------------------------------------------------------->
      
      <!-- form -->
      <form class="form-horizontal">
        
			  <div class="form-group">
			    <label for="title" class="col-xs-12 col-md-2 control-label">제목</label>
			    <div class="col-xs-12 col-md-10">
			      <input type="text" name="title" class="form-control" id="title" placeholder="제목" maxlength="200">
			    </div>
			  </div>  
        <div class="form-group">
          <label for="regDt" class="col-xs-12 col-md-2 control-label">작성일</label>
          <div class="col-xs-12 col-md-10">
            <input type="text" name="regDt" class="form-control" id="regDt" placeholder="작성일" maxlength="12">
          </div>
        </div>
        			        
        <div class="form-group">
          <label for="contents" class="col-xs-12 col-md-2 control-label">내용</label>
          <div class="col-xs-12 col-md-10">
            <textarea class="form-control" rows="3" id="contents"></textarea>
          </div>
        </div>       
        
      
      
      
      </form>
      <!--// form ------------------------------------------------------------->
      						   
   </div>
   <!-- //contents ------------------------------------------------------------>
   
   <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
   <script type="text/javascript" src="${CP }/resources/js/jquery.js"></script>
   
   <!-- 모든 컴파일된 플러그인을 포함합니다  bootstrap js -->
   <script type="text/javascript" src="${CP }/resources/js/bootstrap.min.js"></script>
   
   <script src="./js/board_reg_boot.js"></script>
   
</body>
</html>