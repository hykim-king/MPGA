<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge; chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<script type="text/javascript" src="/resources/jquery.min.js"></script>

<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
<script>
// function del(seq) {
//     var chk = confirm("정말 삭제하시겠습니까?");
//     if (chk) {
//         location.href='noticeDoDelete.do?seq='+seq;
//     }
// }   

</script>


<style>
a.a-edit {
text-decoration: none; border: rgba(75, 112, 253, 0.3) solid; border-width: 0 0 6px 0;

}

a.a-delete {
text-decoration: none; border: rgba(360, 83, 48, 0.39) solid; border-width: 0 0 6px 0;
text-color: red;


}
</style>


<title>Insert title here</title>
</head>
<h3><a href="/home.do">홈으로</a></h3>
<body>
<!--  action = "/noticeWrite.do" method = "get" -->

    <div class="container">
        <div class="row">

            <div class="col-md-10 col-md-offset-1">

                <div class="panel panel-default panel-table">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col col-xs-6">
                                <h3 class="panel-title">
                                    <b>공지사항데이터리스트</b>
                                </h3>
                            </div>
                            <form method="get" name="form">
                            <div class="col col-xs-6 text-right">
                                <button type="submit" class="btn btn-sm btn-primary btn-create" value="write" onclick="javascript: form.action='/noticeDoInsert.do';" >작성
                                    
                                </button>
                            </div>
                            </form>
                        </div>
                    </div>
                    <form method="GET" name="form_01">
                    <div class="panel-body">
                        <table class="table table-striped table-bordered table-list" id="tempList">
                            <thead>
                                <tr>
                                    <th><em class="glyphicon glyphicon-cog"></em></th>
                                    <th>번호</th>
                                    <th>제목</th>
                                    <th>날짜</th>
                                    <th>관리자번호</th>
                                    <th>게시판구분</th>
                                    
                                </tr>
                            </thead>
                            <tbody class = "noticeTable">
                                <c:forEach items="${getAll}" var="noticeVO" varStatus="status">  
                                    <tr>

                                        <td align="center">
                                        
<!--                                         <input value = "Edit" id="doUpdateBt" name="doUpdateBt" onclick="location.href='/noticeDoUpdate.do?seq={noticeVO.seq}'" /> -->
                                        <a href = "/noticeDoUpdate.do?seq=${noticeVO.seq}" class = "a-edit">Edit</a>
                                        &nbsp;&nbsp;
                                        <a href = "/noticeDoDelete.do?seq=${noticeVO.seq}" class = "a-delete">Delete</a>

	   
	                                    </td>

                                        <td class="seq">${noticeVO.seq}</td>
                                        <td class="title">${noticeVO.title}</td>
                                        <td class="reg_dt">${noticeVO.reg_dt}</td>
                                        <td class="reg_num">${noticeVO.reg_num} </td>
                                        <td class="board_cfc">${noticeVO.board_cfc}</td>

                                    </tr>

									</c:forEach>
									
                            </tbody>
                        </table>

                    </div>
                    </form>
                    <div class="panel-footer">
                        <div class="row">

                            <div class="col col-xs-8">
                                <ul class="pagination hidden-xs pull-right">
                                    <li><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                </ul>
                                <ul class="pagination visible-xs pull-right">
                                    <li><a href="#">«</a></li>
                                    <li><a href="#">»</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>


                </div>

            </div>

			</div> 
    </div>

</body>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/notice.css" rel="stylesheet"/> 
<!-- 모든 컴파일된 플러그인을 포함합니다  bootstrap js -->


</html>