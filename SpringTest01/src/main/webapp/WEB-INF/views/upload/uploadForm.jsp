<%@ page language="java" contentType="text/html; charset=UTF-8"
buffer="none"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>파일 업로드</title>
	<%@ include file="../include/header.jsp" %>
	
	<style type="text/css">
		iframe {
			width : 500px;
			height: 300px;
			border: 3px;
			border-style: soild;
		}
	</style>
	<script type="text/javascript">
	$(function() {
		console.log('jQuery Ok...');
	})</script>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %> 
<hr>

<form name="form1" action="/upload/uploadForm" method="post" 
		enctype="multipart/form-data"    target="iframe1">
	<input type="file" name="file">  
	<input type="submit" value="업로드" />	
</form>	
<p>
<iframe name="iframe1"></iframe>

</body>
</html>