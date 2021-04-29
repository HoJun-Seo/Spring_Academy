<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>장바구니 리스트</title>
		<%@ include file="../include/header.jsp" %>
		
		<script type="text/javascript">
			$(function(){

				$('#btnList').click(function(){
					location.href="${path}/shop/product/list.do";
				});
				
				$('#btnUpdate').click(function(){
					document.form1.submit();
				});
				
				$('#btnDelete').click(function(){
					if(confirm("장바구니를 비우겠습니까?")){
						location.href="${path}/shop/cart/deleteAll.do";
					} 
				});					
			});
			</script>
	</head>
<body>
 <%@ include file="../include/admin_menu.jsp" %>
 <p>
 <h2>장바구니</h2>
 <hr />
 <c:choose>
 	<c:when test="${map.count == 0 }">
 		장바구니가 비었습니다.
 	</c:when>
 	<c:otherwise>
 		<form  name="form1" method="post" action="${path}/shop/cart/update.do">
 			<table border="1" width="500">
 				<tr>
 					<td>상품명</td>
 					<td>단가</td>
 					<td>수량</td>
 					<td>금액</td>
 					<td>&nbsp;</td>
 				</tr>
 				<!-- map안에 list객에 자료보관 되어있음. map.list형식으로 표혀 -->
 				<c:forEach var="row" items="${map.list }">
 				<tr align="center">
 					<td>${row.product_name }</td>
 					<td><fmt:formatNumber value="${row.price }"  pattern="#,###,###"/> </td>
 					<td>
 						<input type="number" name="amount"  value="<fmt:formatNumber value="${row.amount}"  pattern="#,###,###"/>"  max="100" min="1" style="width=300px;"/>
 						<input type="hidden" name="cart_id" value="${row.cart_id }" >
 					</td>
 					<td><fmt:formatNumber value="${row.money }"  pattern="#,###,###"/></td>
 					<td><a href="${path }/shop/cart/delete.do?cart_id=${row.cart_id }">[삭제]</a></td>
 				</tr> 					
 				</c:forEach>
 				<tr>
 					<td colspan="5">
 						장바구니 금액 : <fmt:formatNumber value="${map.sumMoney }"  pattern="#,###,###"/>원 <br>
 						배 송 료 : <fmt:formatNumber value="${map.fee }"  pattern="#,###,###"/>원 <br>
 						총 합 계 : <fmt:formatNumber value="${map.sum }"  pattern="#,###,###"/>원 <br>
 					</td>
 				</tr> 				
 			</table>
 			<!-- 반복문 처리 관계로 forEach안에 있는 항목은 배열처리됨.  update.do에서 인자처리서 배열로 처리해야함.   button클릭시 submit과 같은 기능  -->
			<button id="btnUpdate">수정</button>  <button type="button" id="btnDelete">장바구니 비우기</button>
 		</form>
 	</c:otherwise>
 </c:choose>

<hr />
 <button id="btnList">상폼 리스트</button>
</body>
</html>