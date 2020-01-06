<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		.container{
			margin: 0 auto;	
			width:600px;
			height: 600px;
		}
		.head{
			width:600px;
			height: 100px;
			background: tan;
		}
		.postbody{
			width:600px;
			height: 400px;
			border: 1px solid black;
		}
		.postbottom{
			width:600px;
			height:80px;
			border: 1px solid black;
		}
		.postImg img{
			width:200px;
		}
		
		
	</style>
</head>
<body>
	<div class="container">
		<div class="head">
			<input type="hidden" id="hiddenBno" value="${DATA.bno}">
			<div class="posttitle"><h3>제목 : ${DATA.title}</h3></div>
			<div class="postGreat"><span>작성일 :</span><span>${DATA.sDate}</span> </div>
		</div>
		<div class="postbody">
			 <div class="postImg">
			 	<img src="/www/upload/${DATA.savename}">
			 </div>
		<p>
		${DATA.body}
		</p>
		</div>
		<div class="postbottom">
			<div class="btnClass">
				<button id="greatBtn">추천</button>
				<button id="badBtn">반대</button>
			</div>
			<div class="postGreat">추천 :<span id="greatSpan">${DATA.great}</span></div>
			<div class="postBad">반대 : <span></span>${DATA.bad}</div>
		</div>
	</div>
	<script type="text/javascript" src="/www/js/jquery-3.4.1.min.js" ></script>
	<script type="text/javascript">
	
	var count=0;
	$(document).ready(function(){
		$('#greatBtn').click(function(){
			var sBno = $('#hiddenBno').val();
			 $.ajax({
				url : "choo.van",
				type :	"post",
				dataType :	"json",
				data :{
					"bbno" : sBno
				},
				success : function(data){
					var ck = data;
					if(ck == 1){
						//update가 완료 됐을 경우
						var cnt = $('#greatSpan').html();
						$('#greatSpan').html(parseInt(cnt) + 1);
					}else{
					}
				},
				error : function(){
					alert('통신에러');
				}

		});
	});
	});
	</script>
</body>
</html>