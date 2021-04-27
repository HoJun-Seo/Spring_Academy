<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 정보</title>
		<%@ include file="../include/header.jsp" %>
	</head>
<body>
 <%@ include file="../include/admin_menu.jsp" %>
 <p>
 <h2>상품 정보</h2>
 <hr>
 <table>
 	<tr>
 		<td><img src="${path }/images/${dto.product_url}" width="300"  /></td>
 	</tr>
 	<tr>
 		<td>상품명</td>
 		<td>${dto.product_name }</td>
 	</tr>
 	 <tr>
 		<td>상품가격</td>
 		<td><fmt:formatNumber value="${dto.product_price }" pattern="#,### 원" /></td>
 	</tr>
  	 <tr>
 		<td>상품설명</td>
 		<td>${dto.product_desc }</td>
 	</tr>
 	 <tr>
 		<td colspan="2">
 			<!-- form에서 name값인 product_id, amount값은 dto필드이름과 동일해야 dto안에 있는 필드로 보내짐:
 			insert.do에서 CartDTO객체로 받음 -->
 			<form name="form1" method="post" action="${path }/shop/cart/insert.do">
 				<input type="hidden" name="product_id" value="${dto.product_id }"/>
 				<select name="amount">
 					<c:forEach begin="1" end="10" var="i">
 						<option value="${i }">${i }</option>
 					</c:forEach>
 				</select>
 				<input type="submit" value="장바구니 담기"/>
 			</form>
 			<a href="${path }/shop/product/list.do">상품 리스트</a>
 		
 		</td>
 	</tr> 		
 </table>
</body>
</html>