<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 등록</title>
		<%@ include file="../include/header.jsp" %>
		
		<!-- 1. ckeditor 라이브러리 : Locale 방식-->
		<script type="text/javascript" src="${path }/ckeditor/ckeditor.js"></script>
		<!--  CDN방식으로 라이브러리 연결 
		<script src="https://cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script> 
		 -->
		
		<!-- 2. summer editor 라이브러리 설정 : include libraries(jQuery, bootstrap)
		 
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->
		
		<!-- include summernote css/js : CDN방식(연결잘됨) 
		<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>   -->
		
		<!-- include summernote css/js : Local 방식 
		<link  href="${path}/summernote/summernote.css" rel="stylesheet">
		<script type="text/javascript" src="${path}/summernote/summernote.js"></script>  -->
		
		
		<script type="text/javascript">
		
			// summernote editor 라이브러리 적용
			/*
			$(function(){
				$('#product_desc').summernote({
					height : 300,
					width : 800
				});
			});
			*/
			
			function product_write() {
				console.log('등록 click');
				var name = document.form1.product_name.value;
				var price = document.form1.product_price.value;
				var desc = document.form1.product_desc.value;
				
				
				console.log("document.form1.product_name.value:"+document.form1.product_name.value.length)
				console.log("price:"+document.form1.product_price.value.length)
				console.log("desc:"+document.form1.product_desc.value.length)
				console.log("desc:"+desc);
				
				
				if (name.length == 0) {
					alert("상품명을 입력하세요.");
					document.form1.product_name.focus();
					return false;	
				}
				if (price.length == 0) {
					alert("가격을 입력하세요.");
					document.form1.product_price.focus();
					return;	
				}
				/* 주석처리하지 않으면 항상 비어 있는 상태이기때문
				if (desc.length == 0) {
					alert("상품설명을 입력하세요.");
					document.form1.product_desc.focus();
					return;	
				}
				*/

				document.form1.action = "${path}/shop/product/insert.do";
				document.form1.submit();
				
			}
		
		</script>
	</head>
<body>
 <!--  관리자 메뉴항목 include -->
 <%@ include file="../include/admin_menu.jsp" %>
 
 <p><br>
 <!-- 파일 업로드시 enctype="multipart/form-data" 옵션이 반드시 기술해야 함. "  -->
 <form name="form1" id="form1" method="post"  enctype="multipart/form-data">
 	<table border="1" width="1000" cellpadding="5">
 		<tr>
 			<td width="200">상품명</td>
 			<td><input type="text" name="product_name" value=""></td>
 		</tr>
 		<tr>
 			<td>가격</td>
 			<td><input name="product_price"/></td>
 		</tr> 	
 		<tr>
 			<td>상품설명</td>
 			<td>
 				<textarea rows="5" cols="60" name="product_desc" id="product_desc" ></textarea>
			</td>				
 		</tr>
		 				
		<!-- 상품 설명 부분을 ckeditor라이브러로 연결 -->
		<script type="text/javascript">
		
			// id가 product_desc 인 태그에 ckeditor 라이브러리 연결 하기
			// 1. 이미지 업로드 탭기능 없이 사용(디폴트 기능)
			// CKEDITOR.replace("product_desc");
			
			// 2. 이미지 업로드 태기능 추가해서 사용
			/*
			CKEDITOR.replace("product_desc",{
				filebrowserUploadUrl:"${path}/imageUplodad.do"
			});
			*/
			
			// ckeditor에서 이미지업로드 에러발생경우 처리, "view/ckeditor/config.js"파일 수정
			// config.filebrowserUploadMethod = 'form'; 마지막 줄에 추가	
			
			
		</script> 
 		<tr>
 			<td>상품이미지</td>
 			<!-- ProductDTO필드에서 MultipartFile 객체로 선언한 필드명과 동일해야함.  -->
 			<td><input type="file" name="product_file1" /></td>
 		</tr>
 		<tr>
 			<td colspan="2">
 				<input type="button" value="등록" onclick="product_write()" />
 				<input type="button" value="상품리스트"  onclick="location.href='${path}/shop/product/list.do'">
 			</td>
 		</tr>  		  					
 	</table>
 </form>
 
  <hr />
 <br />
 
 <!--  관리자 메뉴항목 include -->
 <%@ include file="../include/admin_header.jsp" %>
</body>
</html>