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
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/notice.css" rel="stylesheet"/> 
<title>Insert title here</title>
</head>

<body>
<form method="get" name="form"><!--  action = "/noticeWrite.do" method = "get" -->

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
                            <div class="col col-xs-6 text-right">
                                <button type="submit" class="btn btn-sm btn-primary btn-create" value="write" onclick="javascript: form.action='/noticeWrite.do';" >작성
                                    
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped table-bordered table-list">
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
                            <tbody>
                                <c:forEach items="${noticeListAll}" var="noticeVO">
                                    <tr>

                                        <td align="center">
                                        
                                        <button class="btn btn-default" ><em class="glyphicon glyphicon-pencil"></em></button> 
                                        
                                        <button class="btn btn-danger" type="submit" value="delete" 
                                        onclick="javascript: form.action='/noticeDelete.do';" >
                                        <em class="glyphicon glyphicon-trash" ></em></button>
                                        


                                            </td>

                                        <td id="seq"><c:out value ="${noticeVO.seq}" /></td>
                                        <td id="title"><c:out value ="${noticeVO.title}" /></td>
                                        <td id="reg_dt"><c:out value ="${noticeVO.reg_dt}" /></td>
                                        <td id="reg_num"><c:out value ="${noticeVO.reg_num}" /></td>
                                        <td id="board_cfc"><c:out value ="${noticeVO.board_cfc}" /></td>

                                    </tr>

									</c:forEach>
									
                            </tbody>
                        </table>

                    </div>
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
</form>

</body>

<!-- 모든 컴파일된 플러그인을 포함합니다  bootstrap js -->


</html>