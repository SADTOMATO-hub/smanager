
 //document.addEventListener('DOMContentLoaded', function() {
//})  // 다큐먼트 객체가 실핼할 준비가 되면, 함수를 실행하는 기능
	 
$(document).ready(function(){      //j쿼리 버전의 다큐먼트 객체가 실핼할 준비가 되면, 함수를 실행하는 기능
	//obj = document.getElementById('show'); //이것이 기존의 방식이다.
	//let obj = $('#show'); //이게 j쿼리 방식이다.

	let obj = $('.show'); //show라는 이름의 모든 클래스를 불러온다.
	//	obj.html('Hello'); //show라는 클래스에 전부 hello를 넣고 싶다.
	obj[0].innerHTML = 'Hello'; //기존 방식
	//$(obj).eq(0).html('Hello'); // 1번째 객체에 hello를 넣고 싶다.  .eq(n). = 인덱스 번호를 사용하는 j쿼리의 함수
	$(obj).eq(1).html('love'); // 2번째 객체에 love를 넣고 싶다.
	
	//j쿼리 객체 생성
	$('#show').append($('<button />').html('제거')); //버튼 객체 생성  == <button>제거</button>
	//	$('#show').append($('<button>제거</button>')
	
	console.log(obj); 
})
	 
