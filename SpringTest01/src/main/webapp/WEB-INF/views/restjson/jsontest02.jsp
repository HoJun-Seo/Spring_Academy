<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 데이터 형식 전송2</title>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript">
	$(function () {
		console.log('jQuery Ok...');
		
		$("#checkJson1").click(function () {
			var member = {
                    userid      : "test01",
                    passwd : "1234",
                    name     : "홍길동",
                    email    : "hong@gmail.com"
            }; 
			
			// 서버에 json 데이터 보내기
			 $.ajax({
	                type                : "POST",
	                url                : "${path}/rest/info", 
	                contentType : "application/json",
	                data                : JSON.stringify(member), // 회원 정보를 json문자열로 변환
	                success         : function(data, textStatus) {
	                    alert('전송 성공');

	                    var txtResult = "";
	                    txtResult += "아이디: "+data.userid +"<br>"
	                    txtResult += "비밀번호: "+data.passwd +"<br>"
	                    txtResult += "닉네임: "+data.name +"<br>"
	                    txtResult += "이메일: "+data.email +"<br>";

	                    $('#output').html(txtResult);
	                },
	                error             : function(data, textStatus) {
	                    alert('에러가 발생했습니다. : 전송 실패')
	                },
	                complete         : function() {
	                    alert('작업 완료')
	                }

	            });  // ajax();
		})
		
		$('#checkJson2').click(function () {
			
		})
		$('#checkJson3').click(function () {
			
		})
		$('#checkJson4').click(function () {
			
		})
	})
</script>
</head>
<body>
	<input type="button" id="checkJson1" value="새글 쓰기">
	<input type="button" id="checkJson2" value="수정">
	<input type="button" id="checkJson3" value="삭제">
	<input type="button" id="checkJson4" value="조회">
	<div id="output"></div>
</body>
</html>