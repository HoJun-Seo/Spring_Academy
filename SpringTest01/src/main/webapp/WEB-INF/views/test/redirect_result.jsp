<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Redirect 처리 결과</title>
</head>
<body>
<%--  include 적용 --%>
<jsp:include page="../include/menu.jsp"></jsp:include>
<h2>Redirect 처리 결과</h2>
<hr>
<h4>이름 : ${name }</h4>
<h4>나이 : ${age }</h4>
</body>
</html>