<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- �±� ���̺귯�� ���� -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- ���ؽ�Ʈ �н�(���) ������ ���� -->
<c:set var="path" value="${pageContext.request.ContextPath}" />
<!-- jQuery ���̺귯�� ���� -->
<script type="text/javascript" src="../resources/js/jquery.min.js" ></script>
<script type="text/javascript">
	alert('jQuery Ok..');
</script>

<!-- ��Ÿ�� ��Ʈ ���� -->
<link rel="stylesheet" href="${path}/"/>