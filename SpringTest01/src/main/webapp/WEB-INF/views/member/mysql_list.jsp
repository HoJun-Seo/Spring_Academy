<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis List </title>
<style type="text/css">
a { text-decoration: none;  outline: none;}
</style>
</head>
<body>
<h2>회원목록</h2>
<input type="button" value="회원가입" onclick="location.href='/member/write.do'"/>
<table border=1 width=800>
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>이메일</td>
		<td>가입일자</td>
		<td>가입일자(형식2)</td>
		<td>가입일자(형식3)</td>
	</tr><!--  controller에서 저장한 items객체 -->
	<c:forEach var="row" items="${list }">
	<tr>
		<td>${row.userid }</td>
		<td>
			<a href="/member/view.do?userid=${row.userid }">${row.name }</a>
		</td>
		<td>${row.email }</td>
		<td><fmt:formatDate value="${row.join_date }" pattern="yyyy-MM-dd"/></td>
		<td><fmt:formatDate value="${row.join_date }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td>${row.join_date}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>