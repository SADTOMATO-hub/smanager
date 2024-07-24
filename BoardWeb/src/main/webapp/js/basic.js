/**
 * basic
 */
console.log("basic.js")

let name = "이우상";
let address = "일본 도쿄";
let age = 15;

const myInfo = {name, address, age};
const myInfoary = [name, address, age];

// createElement('span') => <span></span>
// innerText/innerHTML = 값
// 부모.appendChild(자식) => <부모><자식/></부모>
makeDom();
function makeDom(){
 	myInfoary.forEach(function(itm){
	let span = document.createElement('span');
 	span.innerHTML = itm + ' ';
 	document.getElementById('show').appendChild(span); 		
 	console.log(span);	 	
	 })
	}	
/*}*/












	

