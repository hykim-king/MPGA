<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge; chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<style>
body {
    position: relative;
    padding: 150px;
}

.form-group {
    max-width: 100%;
    width: 800px;
    margin-left: auto;
    margin-right: auto;
}
</style>
<title>글쓰기</title>

</head>

<body>
    <form method="POST">
           <div class="form-group">
            <label for="exampleFormControlInput1">번호</label> <input type="text"
                class="form-control" id="seq"
                value="${doRead.seq}" name="seq" readonly = "readonly">
        </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">제목</label> <input type="text"
                class="form-control" id="title"
                placeholder="제목을 입력해 주세요" name="title" value="${doRead.title}">
        </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">게시판구분</label> <input
                type="text" class="form-control" id="board_cfc"
                placeholder="1은 FAQ 2는 새소식 3은 이벤트" name="board_cfc" value="${doRead.board_cfc}">
        </div>
        

        <div class="form-group">
            <label for="exampleFormControlTextarea1">내용</label>
            <textarea class="form-control" id="contents"
                rows="3" name="contents" >${doRead.contents}</textarea>

        </div>
        <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
<!--        <div class="form-group"> -->
<!--            <label for="exampleFormControlInput1">현재날짜</label> <input type="text" -->
<!--                class="form-control" id="exampleFormControlInput1" -->
<!--                placeholder="SYSDATE" name="reg_dt"> -->
<!--        </div> -->
        <div class ="form-group">
            <label for="exampleFormControlInput1">관리자번호</label> <input type="text"
                class="form-control" id="reg_num"
                placeholder="1111" name="reg_num" value="${doRead.reg_num}">
            <button type="submit"class="btn btn-sm btn-primary btn-create"style="float:rigtht">수정</button>
            <button type="button"class="btn btn-danger btn-primary btn-create"style="float:rigtht"
            onclick = "location.href = '/noticeListManage.do' ">취소</button>
        </div>

        <script type="text/javascript" src="/resources/jquery.min.js"></script>

        <!-- 모든 컴파일된 플러그인을 포함합니다  bootstrap js -->
        <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    </form>
</body>
</html>