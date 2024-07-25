/**
 * arry1.js
 */
function checkBox(e){
let chM = document.querySelector('div.container-fluid>thead> input[type="checkbox"]:checked');
let ch = document.querySelectorall('div.container-fluid>tbody> input[type="checkbox"]')
if(chM == ch){
	
}
	
}
//thead에 있는 체크박스에 체인지 이벤트를 등록하려고 함
document.querySelector('div.container-fluid>table>thead input[type="checkbox"]')//
.addEventListener('change', changeFnc);
function changeFnc(e){
	console.log(e.target.checked);
	console.log(document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]').length);
	//찾으려는 대상 체크박스.
	document.querySelectorAll('div.container-fluid>table>tbody input[type="checkbox"]')//
	.forEach(function(itm){
		itm.checked = e.target.checked;
	})
}//end changeFnc

//수정 버튼
document.getElementById('modifyBtn').addEventListener('click', modifyFnc);
function modifyFnc(e) {
	// 화면상에 있는 tr을 대상으로 변경을 해야하니까...
	document.querySelectorAll('#list tr').forEach(function(tr) {
		if (tr.children[0].innerHTML == document.querySelector('#fname').value) {
			tr.children[1].innerHTML == document.querySelector('#fadd').value;
			tr.children[2].innerHTML == document.querySelector('#height').value;
		}
	});
}//end modifyFnc

//tr을 누르면 해당 값이  value에 들어가게끔 해보세요

// 등록 버튼에 클릭이벤트 추가
document.getElementById('addBtn').addEventListener('click', addBtnFnc);
//addBtnFnc 
function addBtnFnc(e) {
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
}//end addBtnFnc

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
	function detailCallback(e) {
		//e.stopPropagation(); 부모에서 찾아오는 방식
		console.log(e)
		let tr = e.target.parentElement.parentElement;
		// this : 1> 함수영역에서 window를 지칭함 2>이벤트 역역에서는 이벤트를 받는 대상을 지칭함 3>객체에서는 객체를 지칭함
		tr = this;
		document.getElementById('fname').value = tr.children[0].innerHTML;
		document.getElementById('fadd').value = tr.children[1].innerHTML;
		document.getElementById('height').value = tr.children[2].innerHTML;
	}//end of detailCallback

// friend => tr 생성
function makeTr(friend = { name: 'Hong', address: 'Seoul', height: 170 }) {/*오브젝트 타입임을 알림*/
	//tr만들기
	let tr = document.createElement('tr');
	tr.addEventListener('click', detailCallback/*,true*/); // true를 누르면 버블링 방식이 아니라 반대방식
	tr.children
	for (let love in friend) {
		let td = document.createElement('td');
		td.innerHTML = friend[love];
		tr.appendChild(td);
	}
	//삭제버튼	
	let td = document.createElement('td');
	let btn = document.createElement('button')
	btn.setAttribute('class', 'btn btn-danger') // <button class="btn btn-dnger">삭제</button>
	btn.addEventListener('click', function(e) {
		e.stopPropagation();  //click 이벤트가 버튼에 있다가 td로 tr로 table로 감. 하지만 이 걸 걸면 버튼 영역에서 멈춤
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
}//end makeTr
