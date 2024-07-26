/**
 *  board.js
 */
//댓글등록 버튼에 클릭 이벤트 등록
let addBtn = document.getElementById('addReply')
addBtn.addEventListener('click', function(e){
	
    let content = document.getElementById('content').value
    let replyer = 'user01';
    let param = {bno, replyer, content}
    
    svc.addReply(param, function(){
		//등록완료 => 화면에 등록된 글 추가
		
		let output = JSON.parse()
	});
});
    


console.log(bno)
svc.replyList(bno, function() {
	let result = JSON.parse(this.responseText);
	result.forEach(reply => {
		replyList.appendChild(makeRow(reply));
	});
});

// reply => row
function makeRow(reply = {}) {
	let cloned = document.querySelector('div.reply>div.content li').cloneNode(true);
	cloned.style.display = 'block'; // <li> style="display : block" <li>
	cloned.querySelector('span:nth-of-type(1)').innerText = reply.replyNo;
	cloned.querySelector('span:nth-of-type(2)').innerText = reply.replyContent;
	cloned.querySelector('span:nth-of-type(3)').innerText = reply.replyer;
	return cloned;
}

