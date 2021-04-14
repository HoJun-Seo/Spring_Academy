<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>모델_뷰 객체를 활용한 전달 방식</title>
</head>
<body>
	<h2>모델_뷰 객체를 활용한 전달 방식</h2>
	<hr>
	<%-- 자료전달 받는 형식 : 맵키 클래스 객체이름.클래스 멤버 변수 --%>
	<h4>상품이름 : ${map.product.name}</h4>
	<h4>상품이름 : ${map.product.price}</h4>
	
</body>
</html>