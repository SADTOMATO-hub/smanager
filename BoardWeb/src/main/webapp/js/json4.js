/**
 * json4.js
 */

document.querySelector('#show').remove();
document.querySelector('div.container-fluid>div:nth-of-type(1)').remove();
document.querySelector('div.container-fluid>table').remove();

//자바스크립트.do를 통해 학생을 추가하는 기능
let addBtn = document.querySelector('#addBtn')
addBtn.addEventListener('click', addStudentInfo)
function addStudentInfo(e) {
	let sno = document.querySelector('#sno').value
	let sname = document.querySelector('#sname').value
	let phone = document.querySelector('#phone').value
	
	console.log(sno)
	console.log(sname)
	console.log(phone)
	
	const addHtp = new XMLHttpRequest();
	addHtp.open('get', 'addStudent.do?sno=' + sno + '&sname=' + sname + '&phone=' + phone);
	addHtp.send();
	addHtp.onload = function(e) {
		console.log(addBtn.response)
		let result = JSON.parse(addHtp.responseText); // {"retCode" : "Success"}
		if (result.retCode == 'Success') {
			alert("성공");
			let tr = makeRow();
			document.getElementById('stdlist').appendChild();
		} else if (result.retCode == 'Fail') {
			alert("실패");
		}
	}
}


//Asynchronous Javascript And Xml (AJAX)
let btn = document.createAttribute('button');
let student
let xhtp = new XMLHttpRequest();
xhtp.open('get', 'studentJson.do'); // 서버상의 특정페이지 요청.
xhtp.send();

xhtp.onload = function(e) {
	console.log(xhtp.response);
	let json = xhtp.response
	student = JSON.parse(json);
	console.log(student);
	initList();
}

function initList() {
	let target = document.getElementById('stdlist');
	target.innerHTML = '';
	student.forEach(emp => {
		target.appendChild(makeRow(emp));
	})
	//	let value = document.querySelector('#searchGender').value;
};

//사원정보 => row
function makeRow(emp = {}) {
	console.log(emp)
	let fileds = ['studentNo', 'studentName', 'studentPhone'];
	let tr = document.createElement('tr');
	tr.setAttribute('data-sno', emp.studentNo);
	fileds.forEach(filed => {
		let td = document.createElement('td');
		td.innerHTML = emp[filed];
		tr.appendChild(td);
	})
	let td = document.createElement('td');
	let btn = document.createElement('button')
	btn.setAttribute('class', 'btn btn-danger') // <button class="btn btn-dnger">삭제</button>
	btn.addEventListener('click', deleteRowFnc)
	btn.innerHTML = '제거';
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;
}

function deleteRowFnc(e) {
	console.log(e.target.parentElement.parentElement.firstChild.innerText);
	let tr = e.target.parentElement.parentElement
	let sno = e.target.parentElement.parentElement.firstChild.innerText;
	sno = e.target.parentElement.parentElement.dataset.sno          //getAttribute("data-sno")
	const delHtp = new XMLHttpRequest();
	delHtp.open('get', 'removeStudent.do?sno=' + sno);
	delHtp.send();
	delHtp.onload = function() {
		let result = JSON.parse(delHtp.responseText); // {"retCode" : "Success"}
		if (result.retCode == 'Success') {
			alert("성공");
			tr.remove();
			console.log(e.target.parentElement.parentElement)
		} else if (result.retCode == 'Fail') {
			alert("실패");
		}
	}
}