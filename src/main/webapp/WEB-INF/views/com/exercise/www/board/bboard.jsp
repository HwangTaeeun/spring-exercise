<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CLS Project FileBoard</title>
<link rel="stylesheet" href="/www/css/w3.css" >
<script type="text/javascript" src="/www/js/jquery-3.4.1.min.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#login').click(function(){
			$(location).attr('href','/www/member/login.van');
		});
		$('#wbtn').click(function(){
			$(location).attr('href','/www/board/writeForm.van');
		});
		
		$('.list1').click(function(){
			var bno = $(this).attr('id');
			alert(bno);
			$('#bno').val(bno);
			$('#frm').submit();
		});
	});
</script>
</head>
<body>
	<form method="post" action="/www/board/viewPost.van" id="frm">
		<input type="hidden" id="bno" name="bno" >
	</form>
	<div class="w3-col m3"><p></p></div>
	<div class="w3-col m6 w3-center">
		<h2 class="w3-col w3-padding w3-blue w3-card">게시판</h2>
		
		<div class="w3-content w3-padding w3-margin-bottom">
			<div class="w3-button w3-small w3-orange w3-left" id="hbtn">Home</div>
			<c:if test="${empty SID}">
				<div class="w3-button w3-small w3-red w3-left" id="login">로그인</div>
			</c:if>
			<c:if test="${not empty SID}">
				<div class="w3-button w3-small w3-blue w3-right" id="wbtn">글쓰기</div>
			</c:if>
		</div>
		<div class="w3-col w3-card w3-margin-top w3-padding">
			<div class="w3-col">
			<div class="w3-row w3-border"> <!--|작성자 | 내용 | 작성일 -->
					<div class="w3-col m2 w3-border-right w3-light-gray">작성일</div>
					<div class="w3-col m2 w3-border-right w3-light-gray">작성자</div>
					<div class="w3-col m4 w3-border-right w3-light-gray">제목</div>
					<div class="w3-col m2 w3-border-right w3-light-gray">추천</div>
					<div class="w3-col m2 w3-light-gray">반대</div>					
			</div>
				
		<c:forEach var="data" items="${LIST}">
			<script type="text/javascript">
				alert('${PAGE.startCont}');
				
			</script>
			<div class="list1" id="${data.bno}">
					<div class="w3-col m2 w3-border-right">${data.sDate}</div>
					<div class="w3-col m2 w3-border-right">${data.bid}</div>
					<div class="w3-col m4 w3-border-right">${data.title}</div>
					<div class="w3-col m2 w3-border-right">${data.great}</div>
					<div class="w3-col m2 w3-border-right">${data.bad}</div>
			</div>
		</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>