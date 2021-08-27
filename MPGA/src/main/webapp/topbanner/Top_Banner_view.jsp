<%@ include file="/azaz/Top_Banner.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2021. 8. 27.</title> 
</head>
<body>
    <div id="modal_search" class="modal">
            <div class="modal_header">
                <h2 class="title1">메뉴 소개</h2>
            </div>
            <div class="modal_body">
    <fieldset>
        <legend>메뉴 소개</legend> 
        <table class="table">
            <caption></caption>
            
            <figure class="photo">
                <div>
                 <img src="/Project/B_08_02.png" alt="">
                </div>
<!--     <a href="#none" class="on"><img src="/RPA_J09/B_08_02.png" alt=""></a>     
          <a href="#none"><img src="/RPA_J09/B_08_02.png" alt=""></a> -->           
            </figure>

                <p class="content">
                    <strong>메뉴 정보 </strong><br>
                    오븐에 조리 후 후라이드 하여 속은 촉촉하고 겉은 바삭한 푸라닭 오븐 후라이드 메뉴. 
                    <br>건강과 맛까지 생각한 오리지널 메뉴. 
                </p>
    
    <!-- -----------------------------별점 표시-------------------------- -->
    
     <p class="star_rating">
    <a href="#" class="on">★</a>
    <a href="#" class="on">★</a>
    <a href="#" class="on">★</a>
    <a href="#">★</a>
    <a href="#">★</a>
    </p>
    
    
        </table> 
    </fieldset>
              </div>
            </div>

<!-- ---------------------------------리뷰------------------------------------------- -->


        <form class="form" method="post">
            <fieldset>
                <legend><img src="/Project/review.png" alt="REVIEW"></legend>
                    <input type="hidden" id="review_seq" value="4353">
                    
                <table class="table">
                    <caption></caption>
                        <p class="content">
                                      푸라닭 치킨에 대한 평가를 해주세요
                            <span><p4>(광고, 욕설 및 상대를 비방하는 글은 관리자에 의해 삭제됩니다)</p4></span>
                        </p>
                                 <!--  <form class="form" method="post">   
                                        <fieldset>
                                            <legend>평가 입력</legend>
                                            <input type="hidden" id="review_seq" value="4353">
                                            <table class="table">
                                        <caption>평가 입력 </caption> --> 
                    <tr>
                        <th class="row">
                            <label for="">푸라닭 치킨
                                <figure><img src="/Project/B_08_02s.png" alt=""></figure>
                            </label>
                        </th>
                        <td class="reply">
                            <input type="text" name="review_input" id="review_input" maxlength="30" placeholder="로그인 후 이용해 주세요. 30자 이하로 입력해주세요.">
                        </td>
                        <td class="btn">
                            <button type="submit">등록</button>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
        
        
        
        
        
    </body>
</html>