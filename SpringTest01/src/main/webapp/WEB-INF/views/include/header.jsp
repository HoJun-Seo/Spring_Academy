<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 태그 라이브러리 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 컨텍스트 패스(경로) 변수로 선언 -->
<c:set var="path" value="${pageContext.request.ContextPath}" />
<!-- jQuery 라이브러리 연결 -->
<script type="text/javascript" src="../resources/js/jquery.min.js" ></script>
<script type="text/javascript">
	alert('jQuery Ok..');
</script>

<!-- 스타일 시트 연결 -->
<link rel="stylesheet" href="${path}/"/>