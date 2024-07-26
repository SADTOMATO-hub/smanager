/**
 * boardService
 * 목록,등록,삭제 기능을 정의
 */
const svc = {
	replyList(bno = 1, loadCallback) {
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'replyList.do?bno=' + bno);
		xhtp.send();
		xhtp.onload = loadCallback//end function
	},//end replyList
	//등록기능
	addReply(param ={bno, replyer, content}, loadCallback){
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'addReply.do?bno='+ param.bno + '&replyer=' + param.replyer + '&content=' + param.content );
		xhtp.send();
		xhtp.onload = loadCallback;
	}
}//end svc

