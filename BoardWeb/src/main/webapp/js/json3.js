/**
 * json3.js
 */

document.querySelector('div.container-fluid>div:nth-of-type(2)').remove();
document.querySelector('div.container-fluid>table').remove();

//Asynchronous Javascript And Xml (AJAX)
let employees
let xhtp = new XMLHttpRequest();
xhtp.open('get', 'data/MOCK_DATA.json'); // 서버상의 특정페이지 요청.
xhtp.send();
xhtp.onload = function(e) {
	console.log(xhtp.response);
	let json = xhtp.response
	employees = JSON.parse(json);
	console.log(employees);
	initList();
}

document.querySelector('#searchGender').addEventListener('change', function(e) {
	initList();
});

function initList() {
	let value = document.querySelector('#searchGender').value;
	let target = document.getElementById('emplist');
	target.innerHTML = '';
	employees.forEach(emp => {
		if (value == 'All' || emp.gender == value) {
			target.appendChild(makeRow(emp));

		}
	});
}

//사원정보 => row
function makeRow(emp = {}) {
	let fileds = ['id', 'first_name', 'last_name', 'salary'];
	let tr = document.createElement('tr');
	fileds.forEach(filed => {
		let td = document.createElement('td');
		td.innerHTML = emp[filed];
		tr.appendChild(td);
	})
	return tr;
}