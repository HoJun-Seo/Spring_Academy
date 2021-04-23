<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 처리</title>
</head>
<body>
<jsp:include page="../include/menu.jsp"></jsp:include>
<h2>성적 처리</h2>
<hr>
<form action="point_result.do" method="post">

	이름: <input type="text" name="name"><br> 
	국어: <input type="text" name="kor"><br>
	영어: <input type="text" name="eng"><br>
	수학: <input type="text" name="mat"><br>
	<input type="submit" value="확인"><br>
	
</form>
</body>
</html>