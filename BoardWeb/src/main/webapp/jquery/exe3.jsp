<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<title>jQuery Element Insert</title>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
		$(function() {
			$("button").on("click", function() {
				$("#list").append("<li>새로 추가된 아이템이에요!</li>");
			});
		});
	</script>
</head>

<body>

	<h1>.append() 메소드</h1>
	<ul id="list">
		<li>첫 번째 아이템이에요!</li>
		<li>두 번째 아이템이에요!</li>
		<li>세 번째 아이템이에요!</li>
	</ul>
	<button>아이템 추가</button>
	
</body>

</html>