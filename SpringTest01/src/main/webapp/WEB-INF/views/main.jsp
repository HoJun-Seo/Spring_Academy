<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 시작</title>
</head>
<body>
	<!-- include 적용 -->
	<jsp:include page="include/menu.jsp"></jsp:include>
	<h2>스프링 시작</h2>
	<hr>
	<h3>이름 : ${name}</h3>
	<h3>메시지 : ${message}</h3>
</body>
</html>