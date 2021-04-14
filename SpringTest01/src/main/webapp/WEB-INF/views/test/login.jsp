<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인(ajax_비동기)</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../include/menu.jsp"></jsp:include>
<h2>로그인(ajax_비동기)</h2>
<hr />

id : 	<input type="text" id="id"/><br>
pwd : <input type="passwd" id="pwd" /><br /><hr />
		<input type="button" id="btnLogin" value="로그인" /><br /><hr />
		<div id="result"></div>
		
		
<script>
	$(function() {
		$('#btnLogin').click(function() {
			console.log('btnLogin  click...');
			
			id = $('#id').val();// 태그요소의 값을 메모리 변수 읽어옴
			pwd = $('#pwd').val();
			param = { "id":id, "pwd" : pwd}// 배열 : [], 객체: {} , json객체
			
			$.ajax({
				type: "post",
				data: param,
				url : "login_result.do",
				success : function(data) {// 정상처리되었을 때 수행하는 메서드
					console.log("data :"+data);
				
					$('#result').html(data);
				}
				
			});// ajax()
			
		});// click()
	});
</script>		
</body>
</html>