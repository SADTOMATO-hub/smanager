<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<title>jQuery Element Selection</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
		  $('button').on('click', function(){     //on = 이벤트를 건다.
			// https://www.tcpschool.com/examples/images/img_monalisa.png // 이 이미지를 출력하려고 함
			$('img').attr('src', 'https://www.tcpschool.com/examples/images/img_monalisa.png')
		  });		
		}); // 도큐먼트가 준비되면 실행을 하겠다
	</script>
</head>

<body>

	<h1>속성 선택자</h1>
	<img src="https://www.tcpschool.com/examples/images/img_flower.png" alt="flower"><br>
	<button>속성을 바꾸죠!!</button>
	
</body>

</html>