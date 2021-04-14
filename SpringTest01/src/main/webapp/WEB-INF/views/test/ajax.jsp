<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>비동기 처리</title>
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../include/menu.jsp"></jsp:include>
	
	<h2>비동기 처리</h2>
	<hr />
	<div id="result"></div>
	
	<script type="text/javascript">
		$(function () {
			console.log('jQuery Ok...');
			
			$.ajax({
				type:"post",
				url:"ajax_background.do",
				success:function(data){
					console.log("요청 성공");
					
					console.log("result:" + data);
					$('#result').html(data);
				}
			});
		});
	</script>
</body>
</html>