/**
 * boardJquery.js
 */
console.log('boardJquery')
$(document).ready(function() {
	$('#addReply').on('click', function() {
		let replyContent = $('#content').val();
		$.ajax({
			url: 'addReply.do',
			data: { replyer: replyer, content: replyContent, bno: bno },
			dataType: 'json',
			success: function(result) {
				let elem = result.retVal;
				$('#replyList').prepend(makeRow(elem));
				$('#content').val('');
			},
			erorr: function(err) {
				console.log(err);
			}


		})// end of ajax
	})//end of click
})//end of document

let page = 1;
$.ajax({
	url: 'replyList.do', // 서버url 호출
	data: { bno: bno, page: page },//서버에 전달할 파라메터
	dataType: 'json',
	success: function(result) {
		console.log(result);
		$.each(result, function(i, elem) {
			console.log("요기 =>", i, elem);
			makeRow();
			$('#replyList').append(temp);
		})
	},
	erorr: function(err) {
		console.log(err);
	}
})//end of ajax


function deleteRow() {
	//삭제하기 위한 ajax
	// temp.remove()
	let li = $(this).parent().parent();
	let rno = li.data('rno')
	$.ajax({
		url: 'removeReply.do',
		data: { rno: rno },
		dataType: 'json',
		success: function(result) {
			if (result.retCode == 'Success') {
				li.remove();
			} else {
				alert('처리실패')
			}
		},
		error: function(error) {
			console.log(error)
		}
	});
}//end of delete

function makeRow(elem) {
	let temp = $('#replyList li:eq(0)').clone();
	temp.attr('data-rno', elem.replyNo);
	temp.css('display', 'block') //속성(attribute) 변경
	temp.find('span:eq(0)').html(elem.replyNo);
	temp.find('span').eq(1).html(elem.replyContent);
	temp.find('span').eq(2).html(elem.replyer);
	let btn = $('<button>분쇄</button>').on('click', deleteRow)
	temp.find('span').eq(3).html(btn);

	return temp;
}

