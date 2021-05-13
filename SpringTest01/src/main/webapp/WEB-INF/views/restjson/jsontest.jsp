<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 데이터 전송</title>
<%@ include file="../include/header.jsp" %>
<script>
    $(function() {

        $('#checkJson').click(function() {

            var member = {
                    userid      : "test01",
                    passwd : "1234",
                    name     : "홍길동",
                    email    : "hong@gmail.com"
            };  // json타입


            $.ajax({
                type                : "POST",
                url                : "${path}/rest/info", 
                contentType : "application/json",
                data                : JSON.stringify(member), // 회원 정보를 json문자열로 변환
                success         : function(data, textStatus) {
                    alert('전송 성공');

                    var txtResult = "";
                    txtResult += "아이디: "+data.userid +"<br>"
                    txtResult += "비밀번호: "+data.passwd +"<br>"
                    txtResult += "닉네임: "+data.name +"<br>"
                    txtResult += "이메일: "+data.email +"<br>";

                    $('#output').html(txtResult);
                },
                error             : function(data, textStatus) {
                    alert('에러가 발생했습니다. : 전송 실패')
                },
                complete         : function() {
                    alert('작업 완료')
                }

            });  // ajax();

        });  // click();

    });
</script>
</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>


<hr>
<h3>JSON형식 회원 정보 데이터 보내기 </h3>
<hr>

<input type="button" id="checkJson" value="회원정보 보내기" /><br />
<div id="output"></div>

</body>
</html>