<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 처리 결과</title>
</head>
<body>
<%--  include 적용 --%>
<jsp:include page="../include/menu.jsp"></jsp:include>

<h2>성적 처리 결과</h2>
<hr>
	이름 : ${ dto.name} <br>
	국어 : ${ dto.kor} <br>
	영어 : ${ dto.eng} <br>
	수학 : ${ dto.mat} <br>
	총점 : ${ dto.total} <br>
	평균 : ${ dto.avg} <br>
</body>
</html>