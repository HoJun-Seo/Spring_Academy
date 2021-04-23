<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기 처리</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="../include/menu.jsp"></jsp:include>

<h2>비동기 처리</h2>
<hr />
<div id="result"></div>



<script>
	$(function() {
		console.log('jQuery Ok...');
		
		$.ajax({
			type: "post",
			url : "ajax_background.do",
			success : function(dto) {
				console.log("요청 성공");
				
				console.log("result:"+dto);
				$('#result').html("<h3>상품명:"+dto.name+", 가격: "+dto.price+"</h3>");
				
			}
		});// ajax();
		
	});
</script>
</body>
</html>













