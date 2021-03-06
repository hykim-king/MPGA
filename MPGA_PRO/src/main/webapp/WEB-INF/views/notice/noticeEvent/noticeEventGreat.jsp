<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/views/banner/TopBanner.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge; chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/notice.css" rel="stylesheet"/> 

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
<title>Insert title here</title>
<style>
.text-center{
font-weight: bold;
}

.coupon {
    border: 3px dashed #bcbcbc;
    border-radius: 10px;
    font-family: "HelveticaNeue-Light", "Helvetica Neue Light", 
    "Helvetica Neue", Helvetica, Arial, "Lucida Grande", sans-serif; 
    font-weight: 300;
}

.coupon #head {
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    min-height: 56px;
}

.coupon #footer {
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
}

#title .visible-xs {
    font-size: 12px;
}

.coupon #title img {
    font-size: 30px;
    height: 30px;
    margin-top: 5px;
}

@media screen and (max-width: 500px) {
    .coupon #title img {
        height: 15px;
    }
}

.coupon #title span {
    float: right;
    margin-top: 5px;
    font-weight: 700;
    text-transform: uppercase;
}

.coupon-img {
    width: 100%;
    margin-bottom: 15px;
    padding: 0;
}

.items {
    margin: 15px 0;
}

.usd, .cents {
    font-size: 20px;
}

.number {
    font-size: 40px;
    font-weight: 700;
}

sup {
    top: -15px;
}

#business-info ul {
    margin: 0;
    padding: 0;
    list-style-type: none;
    text-align: center;
}

#business-info ul li { 
    display: inline;
    text-align: center;
}

#business-info ul li span {
    text-decoration: none;
    padding: .2em 1em;
}

#business-info ul li span i {
    padding-right: 5px;
}

.disclosure {
    padding-top: 15px;
    font-size: 11px;
    color: #bcbcbc;
    text-align: center;
}

.coupon-code {
    color: #333333;
    font-size: 11px;
}

.exp {
    color: #f34235;
}

.print {
    font-size: 14px;
    float: right;
}



/*------------------dont copy these lines----------------------*/
body {
    font-family: "HelveticaNeue-Light", "Helvetica Neue Light", 
    "Helvetica Neue", Helvetica, Arial, "Lucida Grande", sans-serif; 
    font-weight: 300;
}
.row {
    margin: 30px 0;
}

#quicknav ul {
    margin: 0;
    padding: 0;
    list-style-type: none;
    text-align: center;
}

#quicknav ul li { 
    display: inline; 
}

#quicknav ul li a {
    text-decoration: none;
    padding: .2em 1em;
}

.btn-danger, 
.btn-success, 
.btn-info, 
.btn-warning, 
.btn-primary {
    width: 105px;
}

.btn-default {
    margin-bottom: 40px;
}
</style>
</head>

<div class="container">

    <div class="row"><h1 class="text-center">???????????? ???????????????</h1>
        <p class="text-center">??????????????? ?????????????????? ??????????????????.</p>
    </div>

    
    
    <div class="row"><h4 class="text-center"><u>With Chung Ba Chi</u></h4></div>
    
    <div class="row" id="red">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-danger coupon">
              <div class="panel-heading" id="head">
                <div class="panel-title" id="title">
                    <i class="fa fa-github fa-2x"></i>
                    <span class="hidden-xs">???????????? ?????? ???????????? ????????? ???????????????!</span>
                    <span class="visible-xs">???????????? ?????? ???????????? ????????? ???????????????!</span>
                </div>
              </div>
              <div class="panel-body">
                <img src="eventImage/GreatMember.jpg" class="coupon-img img-rounded">
                <div class="col-md-12 well well-sm">
                    <div id="business-info">
                        <ul>
                            <li><span><i class="fa fa-phone"></i> (123) 456-789</span></li>
                            <li><span><i class="fa fa-map-marker"></i> ?????? ???????????? ?????????????????? ??????</span></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-9">
                    <ul class="items">
                        <li><b>10% ????????????</b></li>
                        <li><b>30% ????????????</b></li>
                        <li><b>50% ????????????</b></li>
                        <li><b>100% ????????????</b></li>
                    </ul>
                </div>
                <div class="col-md-3">
                    <div class="offer text-danger">
                        <span class="usd"><sup>MAX</sup></span>
                        <span class="number">100</span>
                        <span class="cents"><sup>%</sup></span>
                    </div>
                </div>
                <div class="col-md-12">
                    <p class="disclosure">????????? ???????????? ??????????????? ????????? ??? ????????? ????????? ????????? ???????????? ???????????? FAQ ???????????? ??????????????? ????????? ????????? ???
                    ??? ????????? 1:1????????? ????????? ????????? ????????????.</p>
                </div>
              </div>
              <div class="panel-footer">
                <div class="coupon-code">
                    Code: thanksforGreatMember
                    <span class="print">
                        <a href="#" class="btn btn-link"><i class="fa fa-lg fa-print"></i> Print</a>
                    </span>
                </div>
                <div class="exp">????????????: Dec 30, 2021</div>
              </div>
            </div>
        </div>
    </div>

    
    <p class="text-center"><a href="#" class="btn btn-default">Back to top <i class="fa fa-chevron-up"></i></a></p>

</div>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
<script type="text/javascript" src="/resources/jquery.min.js"></script>

<!-- ?????? ???????????? ??????????????? ???????????????  bootstrap js -->
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
</html>