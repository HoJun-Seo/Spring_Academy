<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 요청 페이지</title>
</head>
<body>
<%--  include 적용 --%>
<jsp:include page="../include/menu.jsp"></jsp:include>

<h2>구구단 요청 페이지</h2>
<hr>
<form action="gugu_result.do" method="get">
	<input type="number" value="3" name="dan">
	<input type="submit"  value="확인">
</form>
</body>
</html>