<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록 화면(Oracle)</title>
</head>
<body>
<h2>회원 등록 </h2>
<form action="${path}/member/memberinsert.do"  id="form" method="post">
	<table border="1" width="400">
		<tr>
			<td>아이디</td>
			<td><input name="userid"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input  type="password" name="passwd" ></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input name="name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input name="email"></td>
		</tr>	
		<tr align="center">
			<td colspan="2"><input type="submit" value="확인"/></td>
		</tr>		
	</table>
</form>
</body>
</html>