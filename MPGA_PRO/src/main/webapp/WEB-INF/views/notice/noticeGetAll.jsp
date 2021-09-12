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
<%-- <form method="GET" action="/noticeRead.do?seq=${noticeVO.seq}"> --%>
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
											<c:forEach items="${doSelect02}" var = "noticeDAO">
												<tr>

													<td><a href ="noticeDoRead.do?seq=${noticeDAO.seq}">${noticeDAO.title}</a></td>
													<td>${noticeDAO.reg_dt}</td>
													<td>${noticeDAO.reg_num}</td>
												</tr>
												</c:forEach>
											</tbody>
										</table>  

									</div>

								</div>
							</div>
						</div>
					</div>

				</div>

				<div role="tabpanel" class="tab-pane" id="protocol">
				<h3>이용약관</h3><br>
                    <h4>제 1조 목적</h4>
                    <P>본 약관은 유한책임회사 청춘은바로치킨이닭(이하 “회사”라 함)이 운영하는 “청바치” 사이트 또는 “청바치” 모바일 애플리케이션에서 제공하는 서비스(이하 “서비스”라 함)를 이용함에 있어 “청바치”와 이용자의 권리, 의무 및 책임 사항을 규정함을 목적으로 합니다.</p><br>

                    <h4>제 2조 정의</h4>
                    <P>① “청바치”란 회사가 “서비스”를 이용자에게 제공하기 위하여 컴퓨터 등 정보통신설비를 이용하여 재화 또는 용역(이하 “재화 등”이라 함)을 거래할 수 있도록 설정한 가상의 영업장을 말하며, 아울러 “청바치”를 운영하는 사업자의 의미로도 사용합니다.</P>
                    <P>② “청바치서비스”란 회사가 운영하는 사이트나 모바일 애플리케이션을 통해 이용자가 원하는 재화 등을 주문하면, 주문이 완료된 재화 등을 가맹점이 이용자에게 배달하는 서비스를 기본으로 하되, 배달대행, 테이크아웃 등 “청바치” 사이트 및 모바일 애플리케이션 상의 제공 서비스 전체를 의미합니다.</P>
                    <P>③ “이용자”란 “청바치”에 접속하여 본 약관에 따라 청바치가 제공하는 서비스를 받는 회원 및 비회원을 말합니다.</P>
                    <P>④ “회원”이라 함은 “청바치”에 개인정보를 제공하여 회원등록을 한 자로서, “청바치”의 정보를 지속적으로 제공받으며, “청바치”가 제공하는 서비스를 계속적으로 이용할 수 있는 자를 말합니다.</P>
                    <P>⑤ “비회원”이라 함은 회원에 가입하지 않고 “청바치”가 제공하는 서비스를 이용하는 자를 말합니다.</P><br>

                    <h4>제 3조 (약관의 명시와 설명 및 개정)</h4>
                    <P>① “청바치”는 본 약관의 내용과 상호, 영업소 소재지 주소(소비자의 불만을 처리할 수 있는 곳의 주소를 포함), 대표자의 성명, 사업자등록번호, 연락처(전화, 팩스, 전자우편 주소 등), 통신판매업신고번호, 개인정보관리책임자 등을 이용자가 알 수 있도록 “청바치” 쇼핑몰의 초기 서비스화면(전면)에 게시합니다. 다만, 약관의 내용은 이용자가 연결화면을 통하여 볼 수 있도록 할 수 있습니다.</P>
                    <P>② “청바치”는 이용자가 약관에 동의하기에 앞서 약관에 정하여져 있는 내용 중 주문 취소 ∙ 배송책임 ∙ 환불조건 등과 같은 중요한 내용을 이용자가 이해할 수 있도록 별도의 연결화면 또는 팝업화면 등을 제공하여 이용자의 확인을 구하여야 합니다.</P>
                    <P>③ “청바치”는 「전자상거래 등에서의 소비자 보호에 관한 법률」, 「약관의 규제에 관한 법률」, 「전자거래기본법」, 「전자서명법」, 「정보통신망이용촉진 및 정보보호 등에 관한 법률」, 「방문판매 등에 관한 법률」, 「소비자보호법」 등 관련법을 위배하지 않는 범위에서 본 약관을 개정할 수 있습니다.</P>
                    <P>④ “청바치”가 약관을 개정할 경우에는 적용일자 및 개정사유를 명시하여 현행약관과 함께 “청바치”의 초기화면에 그 적용일자 7일 이전부터 적용일자 전일까지 공지합니다. 다만, 이용자에게 불리하게 약관내용을 변경하는 경우에는 최소한 30일 이상의 사전 유예기간을 두고 공지합니다. 이 경우 “청바치”는 개정 전 내용과 개정 후 내용을 명확하게 비교하여 이용자가 알기 쉽도록 표시합니다.</P><br>

                    <h4>제 4조 (서비스의 중지)</h4>
                    <p>① “청바치”는 다음과 같은 업무를 수행합니다.</p>
                    <p> 1. 재화 등과 관련한 전자상거래 중개 및 배달대행</p>
                    <p> 2. 재화 등 또는 관련 용역에 대한 정보 제공 및 구매계약의 체결</p>
                    <p> 3. 기타 “청바치”가 정하는 업무</p>
                    <p>② “청바치”는 재화 등의 품절 또는 기술적 사양의 변경 등의 사유가 발생하는 경우 장차 체결되는 계약에 의해 제공할 청바치서비스의 내용을 변경할 수 있으며, 오로지 가맹점의 사정(가맹점의 고의나 과실로 “청바치” 사이트에 재화 등의 메뉴 업데이트가 이루어지지 않는 것을 포함하나 이에 한하지 아니함)으로 인해 해당 관련 서비스의 중단이 불가피한 사정이 있는 경우에는 이미 체결된 계약의 해당 주문 건에 대한 서비스를
                        개별적으로 중단할 수 있습니다. 위 각 경우에는 변경된 재화 등의 내용 및 제공일자를 명시하여 현재의 재화 등의 내용을 게시한 곳에 즉시 공지합니다.</p>
                    <p>③ “청바치”가 이용자와 계약을 체결한 서비스의 내용을 전항의 사유로 변경하거나 중단할 경우에는 그 사유를 이용자에게 통지 가능한 연락처(주소, 전자우편, 전화 등)로 즉시 통지합니다.</p>
                    <p>④ 전항의 경우 “청바치”는 이로 인하여 이용자가 입은 손해를 배상합니다. 단, “청바치”가 고의 또는 과실이 없음을 입증하는 경우에는 그러하지 아니합니다.</p><br>

                    <h4>제 5조 (회원가입)</h4>
                    <P>① 이용자는 “청바치”가 정한 가입 양식에 따라 회원정보를 기입한 후 본 약관에 동의한다는 의사표시를 함으로서 회원가입을 신청합니다.</P>
                    <p>② “청바치”는 제1항과 같은 회원가입 신청에 대하여 승낙함으로써 회원가입계약이 성립하며, 다음 각 호 중 어느 하나에 해당하는 이용자의 회원가입 신청에 대해서는 이를 거부할 수 있습니다.</p>
                    <p> 1. 가입신청자가 본 약관 제9조 제3항에 의하여 이전에 회원자격을 상실한 적이 있는 경우, 다만 제9조 제3항에 의한 회원자격 상실 후 3년이 경과한 자로서 “청바치”의 회원 재가입 승낙을 얻은 경우에는 예외로 합니다.</p>
                    <p> 2. 등록 내용에 허위, 기재누락, 오기가 있는 경우</p>
                    <p> 3. 기타 회원으로 등록하는 것이 “청바치”의 기술상 현저히 지장이 있다고 판단되는 경우</p>
                    <p>④ 회원은 제6조 제1항에 따라 기입한 등록사항에 변경이 있는 경우, 즉시 전자우편 기타 방법으로 “청바치”에 대하여 그 변경사항을 알려야 합니다.</p>
                    <p>⑤ 개인정보 보호를 위하여 만 14세 미만 아동의 회원 가입은 제한됩니다.</p></div>
                    
                    
				<div role="tabpanel" class="tab-pane" id="personal">
				<h3>개인정보처리방침</h3><br>
                    <h4>제1조 (목적)</h4>

                    <p>① “개인정보”란 생존하는 개인에 관한 정보로서 당해 정보에 포함되어 있는 성명, 주민등록번호 등의 사항에 의하여 당해 개인을 식별할 수 있는 정보(당해 정보 만으로는 특정 개인을 식별할 수 없더라도 다른 정보와 용이하게 결합하여 식별할 수 있는 것을 포함합니다)를 말합니다. </p>
                    <p>② 회사는 귀하의 개인정보보호를 매우 중요시하며, 『개인정보보호법』, 『정보통신망 이용촉진 및 정보보호에 관한 법률』 상의 개인정보보호규정 및 정보통신부가 제정한 『개인정보보호지침』을 준수하고 있습니다. 회사는 개인정보취급방침을 통하여 귀하께서 제공하시는 개인정보가 어떠한 용도와 방식으로 이용되고 있으며 개인정보보호를 위해 어떠한 조치가 취해지고 있는지 알려드립니다. </p>
                    <p>③ 회사는 개인정보취급방침을 홈페이지 첫 화면에 공개함으로써 귀하께서 언제나 용이하게 보실 수 있도록 조치하고 있습니다. </p>
                    <p>④ 회사는 개인정보취급방침의 지속적인 개선을 위하여 개인정보취급방침을 개정하는데 필요한 절차를 정하고 있습니다. 그리고 개인정보취급방침을 개정하는 경우 버전번호 등을 부여하여 개정된 사항을 귀하께서 쉽게 알아볼 수 있도록 하고 있습니다. </p><br>
                    <h4>제2조 (수집항목)</h4>
                    <p>회사는 별도의 회원가입 절차 없이 대부분의 컨텐츠에 자유롭게 접근할 수 있습니다. 그러나 회사는 맞춤형 서비스를 제공하기 위하여 회원서비스 및 제휴사를 통해 이용자의 정보를 수집하고 있습니다. 회사의 회원제 서비스를 이용하시고자 할 경우 다음의 정보를 입력해주셔야 하며 선택항목을 입력하시지 않았다 하여 서비스 이용에 제한은 없습니다. </p>
                    <p>1. 회원 가입 시 수집하는 개인정보의 범위 </p>
                    <p>2. 비회원 이용 시 수집하는 개인정보의 범위 </p>
                    <p>3. 회원 주문 시 수집하는 개인정보의 범위 </p>
                    <p>4. 서비스 이용과정이나 사업처리과정에서의 자동생성 정보 </p><br>
                    <h4>제3조 (개인정보 수집에 대한 동의)</h4>
                    <p>귀하께서는 ‘제2조(수집하는 개인정보의 항목)’ 상 개인정보의 수집에 대해 동의를 거부할 수 있습니다. 다만, 거부하는 경우, 회원서비스 이용을 위한 회원가입이 불가하거나 회원서비스를 이용하지 못할 수 있습니다. 회사는 다음 각 호의 어느 하나에 해당하는 경우에는 법령에 따라 이와 같은 동의 없이 이용자의 개인정보를 수집∙이용할 수 있습니다. </p>
                    <p>1. 정보통신서비스의 제공에 관한 계약을 이행하기 위하여 필요한 개인정보로서 경제적 · 기술적인 사유로 통상적인 동의를 받는 것이 뚜렷하게 곤란한 경우 </p>
                    <p>2. 정보통신서비스의 제공에 따른 요금정산을 위하여 필요한 경우 </p>
                    <p>3. 그 밖에 법률에 특별한 규정이 있는 경우 </p><br>
                    <h4>제4조 (개인정보의 수집 및 이용목적)</h4>
                    <p>① 회사는 다음과 같은 목적을 위하여 개인정보를 수집하고 있으며 목적이 변경될 경우에는 사전에 이용자의 동의를 구하도록 하겠습니다. </p>
                    <p>1. 이메일주소, 비밀번호 : 회원제 서비스 이용에 따른 본인 식별 절차에 이용 </p>
                    <p>2. 이메일주소, 휴대전화번호 : 고지사항 전달, 본인 의사 확인, 불만 처리 등 원활한 의사소통 경로의 확보, 새로운 서비스/신상품이나 이벤트 정보 안내, 서비스 이용에 대한 리뷰 작성 권유, 그 밖에 회사가 제공하는 서비스 안내 및 광고성 정보 전송 </p>
                    <p>3. 주소, 휴대전화번호 : 이용자의 음식 주문에 따른 배달 진행, 맛집배달대행 서비스 이용 및 경품 배송을 위한 정확한 배송지의 확보 및 본인 식별 </p>
                    <p>4. 휴대전화번호 : 회사가 제공하는 서비스 중 테이크아웃 서비스의 이용 </p>
                    <p>5. 주소 : 최근 배달 주소가 최대 5개까지 단말에 저장되어 주문 시 이용자가 확인 가능 </p>
                    <p>6. 그 외 선택항목 : 개인맞춤 서비스를 제공하기 위한 자료 </p>
                    <p>② 이용자의 기본적 인권 침해의 우려가 있는 민감한 개인정보(인종 및 민족, 사상 및 신조, 출신지 및 본적지, 정치적 성향 및 범죄기록, 의료정보 등)는 수집하지 않습니다. </p><br>
                    <h4>제5조 (쿠키에 의한 개인정보 수집)</h4>
                    <p>① 쿠키(cookie)는 웹사이트가 귀하의 컴퓨터 브라우저(인터넷 익스플로러 등)로 전송하는 소량의 정보입니다. 회사는 귀하에 대한 정보를 저장하고 수시로 찾아내는 ‘쿠키(cookie)’를 사용합니다. 쿠키는 귀하의 컴퓨터는 식별하지만 귀하를 개인적으로 식별하지는 않습니다. 또한 귀하는 쿠키에 대한 선택권이 있습니다. 웹브라우저 상단의 도구 > 인터넷옵션 탭(option tab)에서 모든 쿠키를 다 받아들이거나,
                        쿠키가 설치될 때 통지를 보내도록 하거나, 아니면 모든 쿠키를 거부할 수 있는 선택권을 가질 수 있습니다. </p>
                    <p>② 회사의 쿠키(cookie) 운용 </p>
                    <p>1. 접속빈도 또는 머문 시간 등을 분석하여 이용자의 취향과 관심분야를 파악하여 타겟(target) 마케팅에 활용 </p>
                    <p>2. 회원들의 습관을 분석하여 서비스 개편 등의 척도 </p>
                    </div>
                    
				<div role="tabpanel" class="tab-pane" id="help">
				    <form method="GET" action="/noticeDoRead.do">
				    
				    
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
											     <c:forEach items="${doSelect01}" var="noticeVO">
												    <tr>

	

														<td><a href='<c:url value ='/noticeDoRead.do?seq=${noticeVO.seq}'/>'><c:out value="${noticeVO.title}" /></a></td>
														<td><c:out value="${noticeVO.reg_dt}" /></td>
													    <td><c:out value="${noticeVO.reg_num}" /></td>
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
				</div>
			</div>

		</div>
	</div>
<!-- </form> -->
</div>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
<script type="text/javascript" src="/resources/jquery.min.js"></script>

<!-- 모든 컴파일된 플러그인을 포함합니다  bootstrap js -->
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>

</html>