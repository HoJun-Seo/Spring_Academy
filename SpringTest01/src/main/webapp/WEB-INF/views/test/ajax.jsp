<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�񵿱� ó��</title>
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../include/menu.jsp"></jsp:include>
	
	<h2>�񵿱� ó��</h2>
	<hr />
	<div id="result"></div>
	
	<script type="text/javascript">
		$(function () {
			console.log('jQuery Ok...');
			
			$.ajax({
				type:"post",
				url:"ajax_background.do",
				success:function(dto){
					console.log("��û ����");
					
					console.log("result:" + dto);
					$('#result').html("<h3>��ǰ�� : " + dto.name + ", ���� : "
							+ dto.price + "</h3>");
				}
			});
		});
	</script>
</body>
</html>