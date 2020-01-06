<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1st Test</title>
<link rel="stylesheet" href="/www/css/w3.css" >
<script type="text/javascript" src="/www/js/jquery-3.4.1.min.js" ></script>
<script type="text/javascript">
$(document).ready(function(){
$('#login').click(function(){
	$(location).attr('href','/www/member/login.van');
});
$('#goBoard').click(function(){
	$(location).attr('href', '/www/board/boardView.van');	
});

$('#logout').click(function(){
	$(location).attr('href','/www/member/logoutProc.van');
});
});
</script>
</head>
<body>
	<div class="w3-col m2"><p></p></div>
	<div class="w3-col m8 w3-center w3-margin-top">
		<h1 class="w3-col w3-blue">Welcome My Home!!!</h1>
		<div class="w3-col">
			<c:if test="${empty SID}">
				<div class="w3-col m2 w3-red w3-button" id="login">로그인</div>
			</c:if>
			<c:if test="${not empty SID}">
				<div class="w3-col m2 w3-pink w3-button" id="logout">로그아웃</div>
				<div class="w3-col m2 w3-khaki w3-button" id="goBoard">게시판</div>
			</c:if>
		</div>
	</div>
</body>
</html>