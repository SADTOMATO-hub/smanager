/**
 * arry1.js
 */
//수정 버튼
document.getElementById('modifyBtn').addEventListener('click', function(e) {
	// 화면상에 있는 tr을 대상으로 변경을 해야하니까...
	document.querySelectorAll('#list tr').forEach(function(tr) {
		if (tr.children[0].innerHTML == document.querySelector('#fname').value) {
			tr.children[1].innerHTML == document.querySelector('#fadd').value;
			tr.children[2].innerHTML == document.querySelector('#height').value;
		}
	});
});

//tr을 누르면 해당 값이  value에 들어가게끔 해보세요

// 등록 버튼에 클릭이벤트 추가
document.getElementById('addBtn').addEventListener('click', function(e) {
	let name = document.getElementById('fname').value;
	let add = document.getElementById('fadd').value;
	let hi = document.getElementById('height').value;
	if (!name || !add || !hi) {
		alert('값을 입력하시오');
		return;
	}

	let friend = { name, add, hi }
	//tr만드는 부분
	let tr = makeTr(friend);
	list.appendChild(tr);

	alert('OK');

	fname.value = '';
	fadd.value = '';
	document.getElementById('height').value = '';
})

const friends = [
	{ name: "김정연", address: "대구", height: 180 },
	{ name: "김연호", address: "부산", height: 176 },
	{ name: "이해원", address: "서울", height: 162 }
]

makeList();
function makeList() {
	friends.forEach(function(friend) {
		let tr = makeTr(friend);
		document.getElementById('list').appendChild(tr);
	})
}

// friend => tr 생성
function makeTr(friend = { name: 'Hong', address: 'Seoul', height: 170 }) {/*오브젝트 타입임을 알림*/
	//tr만들기
	let tr = document.createElement('tr');
	tr.children
		for(let love in friend) {
		let td = document.createElement('td');
		td.innerHTML = friend[love];
		tr.appendChild(td);
	}
	//삭제버튼	
	let td = document.createElement('td');
	let btn = document.createElement('button')
	btn.setAttribute('class', 'btn btn-danger') // <button class="btn btn-dnger">삭제</button>
	btn.addEventListener('click', function(e) {
		e.target.parentElement.parentElement.remove();
	})
	btn.innerHTML = '제거';
	td.appendChild(btn);
	tr.appendChild(td);
	
	//체크박스
	td = document.createElement('td');
	let input = document.createElement('input');
	input.setAttribute('type', 'checkbox');
	td.appendChild(input);
	tr.appendChild(td);
	return tr;
}
