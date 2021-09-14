<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src ="/jquery-3.2.1.min.js" ></script>
<script>
 $(document).ready(function() {
	 $("#ajaxbtn").on('click', function() {
		 $.ajax( {
			 url : '/helloajax',
			 type : 'get',
			 success:function(serverdata) {
				 for(var i = 0; i < serverdata.length; i++) {
					 $("#result").append("<h3>" + serverdata[i] + "</h3>");
				 }
			 }
		 });
	 });
	 
 });
 </script>
</head>
<body>
<h1> 전달 받은 모델 : ${insa }</h1>


<c:forEach items="${list }" var="subject">
<h2>${subject }</h2>
</c:forEach>

<button id="ajaxbtn"> ajax로 요청한 결과를 출력합니다. </button>
<div id = "result"> </div>


<img src="/images/qwe.jpg" ><br>
c:/kdigital2/upload/업로드파일저장<br>
<img src="/upload/cappuccino.jpg">

</body>
</html>