<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>성적 처리</title>
</head>
<body>
	<h2>성적 처리</h2>
	<hr>
	<form action="point_result.do" method="post">
		이름 : <input type="text" name="name"> <br>
		국어 : <input type="text" name="kor"> <br>
		영어 : <input type="text" name="eng"> <br>
		수학 : <input type="text" name="mat"> <br>
		<input type="submit" value="확인">
	</form> 
</body>
</html>