<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="/">Home</a>
<a href="/member/list.do">회원관리 목록(oracle)</a>
<a href="${pageContext.request.contextPath}/shop/product/list.do">상품목록</a>
<a href="/upload/uploadForm">파일업로드</a>
<a href="/member/address.do">도로명주소</a>

<!-- 관리자 로그인 경우만 페이지 요청 -->
<c:if test="${sessionScope.admin_user == 'admin' }">
	<a href="/shop/product/write.do">상품 등록</a>
</c:if>

<!-- 로그인 하는 경우만 처리하는 부분 : 장바구니 목록 보기 -->
<span>
	<c:if test="${sessionScope.userid != null }">
		<a href="/short/cart/list.do">장바구니 보기</a>
	</c:if>
</span>

<!--  로그인/로그아웃 상태에 따라 처리 -->
<div style="text-align: right">
    <c:choose>
        <c:when test="${sessionScope.userid == null }">
            <a href="/member/login.do">로그인</a>
            <a href="/admin/login.do">관리자로그인</a>
        </c:when>
        <c:otherwise>
            ${sessionScope.name} 님이 로그인 중입니다.
            <a href="/member/logout.do">로그아웃</a>
        </c:otherwise>
    </c:choose>
</div>
<!--  로그인 경우만 처리하는 부분: 장바구니 목록 보기 -->
<span>
    <c:if test="${sessionScope.userid != null}">
        <a href="/short/cart/list.do">장바구니보기</a>
    </c:if>
</span>
<!--  관리자 로그인 경우만 페이지요청 -->
<c:if test="${sessionScope.admin_user == 'admin'}">
    <a href="/shop/product/write.do">상품등록</a> |
</c:if>

<a href="/shop/product/write.do">상품등록</a>

    