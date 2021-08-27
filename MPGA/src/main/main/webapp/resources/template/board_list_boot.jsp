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
  
<title>게시판 목록</title>
</head>
<body>
   <!-- contents -->
   <div class="container">
      <!-- 제목 -->
      <div class="page-header">
        <h2>게시판 목록</h2>
      </div>	
      <!--// 제목 -------------------------------------------------------------->
      
      <!-- 버튼 -->
      <div class="row text-right">
        <label class="col-xs-6 col-md-2"></label>    
        <div   class="col-xs-6 col-md-10">
          <input class="btn btn-default btn-primary btn-sm" type="button" value="조회" id="doRetrieve">
          <input class="btn btn-default btn-primary btn-sm" type="button" value="등록" id="moveToList">
        </div>
      </div>
      <!--// 버튼 -------------------------------------------------------------->
      
      <!-- 검색 -->
      <div class="row text-right">
         <form class="form-inline col-xs-12 col-md-12">
            <div class="form-group">
              <select class="form-control input-sm">
                <option value="">전체</option>
                <option value="10">제목</option>
                <option value="20">내용</option>                
              </select>
              <input  type="text" class="form-control input-sm" placeholder="검색어">
              <select class="form-control input-sm">
                <option value="10">10</option>
                <option value="20">20</option>
                <option value="30">30</option>
                <option value="100">100</option>
                <option value="200">200</option>
              </select>
            </div>
         </form>
      </div>
      <!--// 검색 -------------------------------------------------------------->
      
      <!-- .table 을 .table-responsive 으로 감싸서 작은 기기에서는 수평 스크롤을 할 수 있는 반응형 
      테이블을 만듭니다(768px 이하). 768px 보다 큰 기기에서는 보기에 차이가 없습니다. -->
      <!-- table -->
      <div class="table-responsive">
        <table class="table table-bordered table-striped table-condensed table-hover">
          <thead class="bg-primary">
             <th class="text-center col-xs-1 col-md-1">번호</th>
             <th class="text-center col-xs-8 col-md-8">제목</th>
             <th class="text-center col-xs-1 col-md-1">작성일</th>
             <th class="text-center col-xs-1 col-md-1">작성자</th>    
             <th class="text-center col-xs-1 col-md-1">조회수</th>
          </thead>
          
          <tbody>
            <!-- 문자: 왼쪽(제목,작성자), 숫자: 오른쪽(조회수), 같으면: 가운데(작성일,번호) -->  
            <tr>
              <td class="text-center">1</td>
              <td class="text-left">RPA 온라인 수업</td>
              <td class="text-center">2021/08/18</td>
              <td class="text-left">이상무</td>
              <td class="text-right">0</td>
            </tr> 
            <tr>
              <td class="text-center">2</td>
              <td class="text-left">RPA 온라인 수업</td>
              <td class="text-center">2021/08/18</td>
              <td class="text-left">이상무</td>
              <td class="text-right">0</td>
            </tr>
            <tr>
              <td class="text-center">2</td>
              <td class="text-left">RPA 온라인 수업</td>
              <td class="text-center">2021/08/18</td>
              <td class="text-left">이상무</td>
              <td class="text-right">0</td>
            </tr> 
            <tr>
              <td class="text-center">3</td>
              <td class="text-left">RPA 온라인 수업</td>
              <td class="text-center">2021/08/18</td>
              <td class="text-left">이상무</td>
              <td class="text-right">0</td>
            </tr>
            <tr>
              <td class="text-center">4</td>
              <td class="text-left">RPA 온라인 수업</td>
              <td class="text-center">2021/08/18</td>
              <td class="text-left">이상무</td>
              <td class="text-right">0</td>
            </tr>
            <tr>
              <td class="text-center">5</td>
              <td class="text-left">RPA 온라인 수업</td>
              <td class="text-center">2021/08/18</td>
              <td class="text-left">이상무</td>
              <td class="text-right">0</td>
            </tr>                                                 
          </tbody>
        </table>
      </div>
      <!--// table ------------------------------------------------------------>
      
      <!-- pagenation -->
      <div class="text-center">
				<nav>
				  <ul class="pagination">
				    <li>
				      <a href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li><a href="#">4</a></li>
				    <li><a href="#">5</a></li>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>      
      </div>
      <!--// pagenation ------------------------------------------------------->
   </div>
   <!-- //contents ------------------------------------------------------------>
   
   <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
   <script type="text/javascript" src="${CP }/resources/js/jquery.js"></script>
   
   <!-- 모든 컴파일된 플러그인을 포함합니다  bootstrap js -->
   <script type="text/javascript" src="${CP }/resources/js/bootstrap.min.js"></script>
   
   <script src="./js/board_reg_boot.js"></script>
   
</body>
</html>