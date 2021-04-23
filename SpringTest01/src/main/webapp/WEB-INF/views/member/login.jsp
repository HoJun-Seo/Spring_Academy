<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>관리자 로그인</title>
	<%@ include file="../include/header.jsp" %>
	
	<script type="text/javascript">
		$(function(){
			console.log('jQuery Ok...');
			

			$('#btnLogin').click(function(){
				console.log('login click');
				
				var userid = $('#userid').val();
				var passwd = $('#passwd').val();
				
				if (userid ==""){
					alert('아이디를 입력하세요.');
					$('#userid').focus();
					return;
				}
				if (passwd == ""){
					alert('비밀번호를 입력하세요.');
					$('#passwd').focus();
					return ;
				}
				
				document.adminlogin.action = "${path}/admin/login_check.do";
				document.adminlogin.submit();
				
			});
			
		});	
	</script>
	</head>
<body>
 <%@ include file="../include/admin_menu.jsp" %>
 <p>
 <h2>관리자 로그인(admin,1234)</h2><p>
 <form name="adminlogin" method="post">
	<table border="1" width="400">
		<tr>
			<td>아이디</td>
			<td><input name="userid" id="userid" autocomplete="off" ></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" id="passwd" autocomplete="off" ></td>	
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" id="btnLogin">로그인</button>
				
				<c:if test="${message == 'nologin' }">
					<div id="mess" style="color:red">로그인 하세요</div>
				</c:if>
				<c:if test="${message == 'error' }">
					<div id="mess" style="color:red">아이디 또는 비밀번호가 일치하지 않습니다.</div>
				</c:if>
				<c:if test="${message == 'logout' }">
					<div id="mess" style="color:red">로그 아웃 되었습니다.</div>
				</c:if>								
			</td>
		</tr>		
	</table> 
 </form>
</body>
</html>