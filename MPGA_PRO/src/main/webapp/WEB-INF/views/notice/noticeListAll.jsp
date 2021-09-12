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
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/notice.css" rel="stylesheet"/> 

<!-- Optional theme -->
<!-- <link rel="stylesheet" -->
<!--     href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" -->
<!--     integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" -->
<!--     crossorigin="anonymous" /> -->
<title>Insert title here</title>

</head>

<div class="container mt-2">
	<div class="row">
		<div class="col-md-12">
		
			<h2 class="mb-3">공지사항</h2>
			<h4><a href="/noticeListManage.do">공지사항관리페이지</a></h4>
			
			 <!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#event"
					aria-controls="home" role="tab" data-toggle="tab"><i
						class="fa fa-home"></i>  <span>이벤트</span></a></li>
				<li role="presentation"><a href="#lastevent"
					aria-controls="profile" role="tab" data-toggle="tab"><i
						class="fa fa-user"></i>  <span>지난이벤트</span></a></li>
				<li role="presentation"><a href="#new" aria-controls="messages"
					role="tab" data-toggle="tab"><i class="fa fa-envelope-o"></i> 
						<span>새소식</span></a></li>
				<li role="presentation"><a href="#protocol"
					aria-controls="settings" role="tab" data-toggle="tab"><i
						class="fa fa-cog"></i>  <span>이용약관</span></a></li>
				<li role="presentation"><a href="#personal"
					aria-controls="settings" role="tab" data-toggle="tab"><i
						class="fa fa-plus-square-o"></i>  <span>개인정보처리방침</span></a></li>
				<li role="presentation" ><a href="#help"
					aria-controls="settings" role="tab" data-toggle="tab"><i
						class="fa fa-plus-square-o"></i>  <span>고객센터</span></a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="event">
					<div class="container">
						<div class="row">
							<div class="[ col-xs-12 col-sm-offset-2 col-sm-8 ]">
								<ul class="event-list">
									<li><time datetime="2022-09-20">
											<span class="day">1</span> <span class="month">9월</span> <span
												class="year">2021</span> <span class="time">ALL DAY</span>
										</time>

										<div class="info">
											<h2 class="title">30%할인 쿠폰 이벤트</h2>
											<p class="desc">회사 망할때까지 진행</p>
										</div></li>

									<li><time datetime="2022-09-20 0000">
											<span class="day">28</span> <span class="month">8월</span> <span
												class="year">2021</span> <span class="time">12:00 AM</span>
										</time>
										<div class="info">
											<h2 class="title">신메뉴 시식회</h2>
											<p class="desc">10월 마감</p>

										</div></li>

									<li><time datetime="2022-09-20 2000">
											<span class="day">16</span> <span class="month">8월</span> <span
												class="year">2021</span> <span class="time">8:00 PM</span>
										</time>

										<div class="info">
											<h2 class="title">우수회원 쿠폰증정</h2>
											<p class="desc">영원히 계속</p>

										</div></li>

									<li><time datetime="2022-09-20 1600">
											<span class="day">31</span> <span class="month">7월</span> <span
												class="year">2021</span> <span class="time">4:00 PM</span>
										</time>

										<div class="info">
											<h2 class="title">신규회원할인이벤트</h2>
											<p class="desc">계속계속</p>

										</div></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				
				
				<div role="tabpanel" class="tab-pane" id="lastevent">
					<div class="container">
						<div class="row">
							<div class="[ col-xs-12 col-sm-offset-2 col-sm-8 ]">
								<ul class="event-list">
									<li><time datetime="2022-09-20"> </time>

										<div class="info">
											<h2 class="title">선착순 기프티콘이벤트</h2>
											<p class="desc">마감입니다.</p>
										</div></li>

									<li><time datetime="2022-09-20 0000"> </time>
										<div class="info">
											<h2 class="title">SNS인증 이벤트</h2>
											<p class="desc">마감입니다.</p>

										</div></li>


								</ul>
							</div>
						</div>
					</div>
				</div>
				
				
				<div role="tabpanel" class="tab-pane" id="new">
					<div class="container">
						<div class="row">

							<div class="col-md-10 col-md-offset-1">

								<div class="panel panel-default panel-table">
									<div class="panel-heading">
										<div class="row">
											<div class="col col-xs-6">
												<h3 class="panel-title">
													<b>사이트변경사항</b>
												</h3>
											</div>
											<div class="col col-xs-6 text-right">
												<button type="submit"
													class="btn btn-sm btn-primary btn-create">작성</button>
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
												</tr>
											</thead>
											<tbody>
												<tr>
													<td align="center"><a class="btn btn-default"> <em
															class="glyphicon glyphicon-pencil"></em></a> <a
														class="btn btn-danger"><em
															class="glyphicon glyphicon-trash"></em></a></td>

													<td>1</td>
													<td>이걸 도대체 어떻게 해야 할까요?</td>
													<td>20190102</td>
												</tr>
											</tbody>
										</table>

									</div>

								</div>
							</div>
						</div>
					</div>

				</div>

				<div role="tabpanel" class="tab-pane" id="protocol">Lorem
					Ipsum is simply dummy text of the printing and typesetting
					industry. Lorem Ipsum has been the industry's standard dummy text
					ever sincwas popularised in the 1960s with the release of Letraset
					sheets containing Lorem Ipsum passage..</div>
				<div role="tabpanel" class="tab-pane" id="personal">Lorem
					Ipsum is simply dummy text of the printing and typesetting
					industry. Lorem Ipsum has been the industry's standard dummy text
					ever since thp into electronic typesetting, remaining essentially
					unchanged. It was popularised in the 1960s with the release of
					Letraset sheets containing Lorem Ipsum passage..</div>
				<div role="tabpanel" class="tab-pane" id="help">
					<div class="container">
						<div class="row">

							<div class="col-md-10 col-md-offset-1">

								<div class="panel panel-default panel-table">
									<div class="panel-heading">
										<div class="row">
											<div class="col col-xs-6">
												<h3 class="panel-title">
													<b>자주하는질문</b>
												</h3>
											</div>
						
										</div>
									</div>
									<div class="panel-body">
										<table class="table table-striped table-bordered table-list">
											<thead>
												<tr>

													<th>제목</th>
													<th>날짜</th>
													<th>작성자번호</th>
												</tr>
											</thead>
											<tbody>
											     <c:forEach items="${noticeListAll}" var="noticeVO">
												    <tr>

	

														<td>${noticeVO.title}</td>
														<td>${noticeVO.reg_dt}</td>
													    <td>${noticeVO.reg_num}</td>
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

				</div>
			</div>

		</div>
	</div>
</div>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
<script type="text/javascript" src="/resources/jquery.min.js"></script>

<!-- 모든 컴파일된 플러그인을 포함합니다  bootstrap js -->
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>

</html>