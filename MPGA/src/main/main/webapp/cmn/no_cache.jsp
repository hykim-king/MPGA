<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jstl 선언부: core 태그 라이브러시 사용하기 반듯이 필요. --%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CP" value="${pageContext.request.contextPath }" />    
<%
/*
  웹 브라우저가 변경된 내역을 출력하지 않는 이유 중 하나는 웹브라어저가
  서버가 생성한 결과를 출력하지 않고 캐시에 저장된 데이터를 출력하기 때문이다.
  --> 
  HTTP는 특수한 응답 헤더를 통해서 웹 브라우저가 응답 결과를 캐시 할 것인지에 대한 여부를
  설정할 수 있다.
*/
  String CP = request.getContextPath();//project명
  CP = CP+"/resources" ;
  
  
  
  Date   currDate = new Date();
  
  
  //Cache-Control :  HTTP/1.1
  response.setHeader("Cache-Control", "no-cache");
  response.addHeader("Cache-Control", "no-cache");
  
  //Progma :  HTTP/1.0
  response.setHeader("Progma", "No-cache");
  //Expires : HTTP/1.0
  //1970.1.1. 현제까지 경과된 시간.
  //캐시를 하지 않을 경우 현재 시간이전으로 시간설정을 하면 된다.
  response.setHeader("Expires", "1L");
  
%>