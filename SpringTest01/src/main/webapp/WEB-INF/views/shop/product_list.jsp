<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 리스트</title>
		<%@ include file="../include/header.jsp" %>
		
		<script type="text/javascript">
			$(function(){
				$('#btnAdd').click(function(){
					location.href="${path}/shop/product/write.do/";
				});
			});
			</script>
	</head>
<body>
 <%@ include file="../include/admin_menu.jsp" %>
 <p>
 <button id="btnAdd">상품 등록</button>
 
<table border="3" width="500">
	<tr>
		<th>상품 ID</th>
		<th>&nbsp;</th>
		<th>상품명</th>
		<th>상품가격</th>
	</tr>
	<c:forEach var="row" items="${list}">
	<tr align="center">
		<td>${row.product_id}</td>
		<td><img alt="" src="${path }/images/${row.product_url}" width="150"  /></td>
		<!-- Pathvariable방식 url형식으로 전달 : 인자전달 방식아님 -->
		<td>
			<a href="${path }/shop/product/detail/${row.product_id}">${row.product_name }</a>
			<c:if test="${sessionScope.admin_userid != null }">
				<br>
				<a href="${path }/shop/product/edit/${row.product_id}">[편집]</a>
			</c:if>
		</td>
		<td><fmt:formatNumber value="${row.product_price }" pattern="#,###" /></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>