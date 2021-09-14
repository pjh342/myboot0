<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${list }" var="uploadVO">
<h3><a href="http://localhost:9001/upload/${uploadVO.filename1 }"> ${uploadVO.filename1 }</a> <br>
<a href="http://localhost:9001/upload/${uploadVO.filename2 }"> ${uploadVO.filename2 }</a></h3>
</c:forEach>
</body>
</html>