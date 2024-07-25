/**
 * json2.k.js
 */

document.querySelector('div.container-fluid>div:nth-of-type(2)').remove();
document.querySelector('div.container-fluid>table').remove();

let json = `
[{"id":1,"first_name":"Murry","last_name":"Lilleyman","email":"mlilleyman0@reverbnation.com","gender":"Male","salary":9301},
{"id":2,"first_name":"Augustine","last_name":"Flucker","email":"aflucker1@ibm.com","gender":"Female","salary":9589},
{"id":3,"first_name":"Ansel","last_name":"Clemence","email":"aclemence2@irs.gov","gender":"Male","salary":7716},
{"id":4,"first_name":"Jedediah","last_name":"Borzone","email":"jborzone3@xrea.com","gender":"Male","salary":6771},
{"id":5,"first_name":"Koren","last_name":"Popplestone","email":"kpopplestone4@gizmodo.com","gender":"Female","salary":9885},
{"id":6,"first_name":"Quinn","last_name":"Vurley","email":"qvurley5@unc.edu","gender":"Bigender","salary":1009},
{"id":7,"first_name":"Gratia","last_name":"Mullen","email":"gmullen6@gravatar.com","gender":"Female","salary":9181},
{"id":8,"first_name":"Laurene","last_name":"Luberti","email":"lluberti7@blogs.com","gender":"Female","salary":5684},
{"id":9,"first_name":"Cassaundra","last_name":"Sigert","email":"csigert8@mlb.com","gender":"Female","salary":5617},
{"id":10,"first_name":"Anica","last_name":"Mackneis","email":"amackneis9@craigslist.org","gender":"Female","salary":8025},
{"id":11,"first_name":"Erl","last_name":"Van Halle","email":"evanhallea@google.co.uk","gender":"Male","salary":4565},
{"id":12,"first_name":"Shaun","last_name":"Yurin","email":"syurinb@amazon.co.jp","gender":"Female","salary":2358},
{"id":13,"first_name":"Geordie","last_name":"Tatum","email":"gtatumc@goodreads.com","gender":"Male","salary":5388},
{"id":14,"first_name":"Gustie","last_name":"Ballham","email":"gballhamd@si.edu","gender":"Female","salary":4652},
{"id":15,"first_name":"Mateo","last_name":"Paver","email":"mpavere@tmall.com","gender":"Male","salary":9123},
{"id":16,"first_name":"Patti","last_name":"Wadge","email":"pwadgef@mediafire.com","gender":"Female","salary":1424},
{"id":17,"first_name":"Claudine","last_name":"Marjoram","email":"cmarjoramg@163.com","gender":"Female","salary":8273},
{"id":18,"first_name":"Garvy","last_name":"Bodsworth","email":"gbodsworthh@mit.edu","gender":"Male","salary":9753},
{"id":19,"first_name":"Roobbie","last_name":"D'Adda","email":"rdaddai@youku.com","gender":"Female","salary":7504},
{"id":20,"first_name":"Miles","last_name":"Rushford","email":"mrushfordj@go.com","gender":"Male","salary":9001}]
`;

let employees = JSON.parse(json);
console.log(employees);

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