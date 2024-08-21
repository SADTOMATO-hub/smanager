<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> .jsp</title> 
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" ></script>
<script>
	$(document).ready(function(){
	   $('#addbtn').on('click', function(){
		   //console.log('aa')
		  
		//  let button = $('<button />').html('제거').on('click', function(){
		//	  $(this).parent.hidde(1000);
		//  });
		  
		  let value = $('#userVal').val();
		 
		  $('#list').append($('<li />').html(value).append($('<button />').html('제거')));
	   }); //addbtn
		 $('#oddbtn').on('click', function(){
			$('#list li:gt(2)').css('background', 'red');	 /*j쿼리에서 스타일을 넣는 법*/
		 }); //oddbtn
		 $('#evenbtn').on('click',function(){
			$('#list li:not(:has(span))').css('color', 'pink');
		 }); //evenbtn
	});//document
</script>
<body>
	입력 :
	<input id="userVal"> <!-- val = value -->
	<button id="addbtn">추가</button>
	<button id="oddbtn">3번째 이후</button>
	<button id="evenbtn">사랑4</button>
	
	<div id="show">
		<ul id="list">
			<li>사랑1<span>span</span></li>
			<li>사랑2</li>
			<li>사랑3</li>
			<li>사랑4</li>
			<li>사랑5</li>
			<li>사랑6</li>
			<li>사랑7</li>
			<li>사랑8</li>
			<li>사랑9</li>
		</ul>
	</div>
</body>
</html>