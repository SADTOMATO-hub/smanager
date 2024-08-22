<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="https://cdn.datatables.net/2.1.4/css/dataTables.dataTables.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://cdn.datatables.net/2.1.4/js/dataTables.js"></script>

<h3>게시판 상세(board.jsp)</h3>

<form action="removeBoard.do">
	<input type="hidden" name="bno" value="${board.boardNo }"> <input
		type="hidden" name="page" value="${page }">
	<table class="table">
		<tr>
			<th class="col-sm-3">글번호</th>
			<td>${board.boardNo }</td>
			<th>조회수</th>
			<td>${board.viewCnt }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">${board.content }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${board.writer }</td>
		</tr>
		<tr>
			<th>파일</th>
			<td colspan="3"><img width="250px" src="imgs/${board.image }"></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><c:choose>
					<c:when test="${logid == board.writer }">
						<input class="btn btn-danger" type="submit" value="삭제화면">
						<button class="btn btn-warning" type="button">수정화면</button>
					</c:when>
					<c:otherwise>
						<input class="btn btn-danger" disabled type="submit" value="삭제화면">
						<button class="btn btn-warning" disabled type="button">수정화면</button>
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>
</form>
<!-- 댓글관련 -->
<div class="container reply">
	<!-- 목록 -->
	<div class="header">
		<input class="col-sm-6" id="content">
		<button class="col-sm-2" id="addReply">댓글등록</button>
		<button class="col-sm-2" id="deleteReply">댓글삭제</button>
	</div>
	<table id="example" class="display" style="width: 100%">
		<thead>
			<tr>
				<th>No</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>No</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>삭제</th>
			</tr>
		</tfoot>
	</table>
</div>
<script>
	const bno = "${board.boardNo }";
	const replyer = "${logid}";
	document.querySelector('form>table button.btn.btn-warning')
			.addEventListener('click', function(e) {
				location.href = 'modifyBoard.do?bno=${board.boardNo }';
			});
	let table = $('#example').DataTable({
		ajax : 'replyList.do?bno=' + bno,
		columns : [ {
			data : 'replyNo'
		}, {
			data : 'replyContent'
		}, {
			data : 'replyer'
		}, {
			data : 'replyDate'
		} ],
		lengthMenu : [ [ 5, 10, 20, -1 ], [ 5, 10, 20, 'All' ] ],
		 columnDefs: [
		        {
		            render: function (data, type, row) {
		                return '<button onclick="deleteRow('+ $(this).html() +')" value="분쇄">';
		            },
		            targets: 4
		        }]
	});
	//댓글등록
	$('#addReply').on('click', function() {
		$.ajax({
			url : 'addReply.do',
			data : {
				replyer : replyer,
				content : $('#content').val(),
				bno : bno
			},
			dataType : 'json',
			success : function(result) {
				console.log(result);
				let rvo = result.retval
				table.row.add({
					'replyNo' : rvo.replyNo,
					'replyContent' : rvo.replyContent,
					'replyer' : rvo.replyer,
					'replyDate' : rvo.replyDate
				}).draw(false)
				$('#content').val('');
			},
			error : function(err) {
				console.log(err)
			}
		})
	})
	//댓글삭제
	let rno
	$('#example').on('click', 'tr', function() {
		if ($(this).hasClass('selected')) {
			$(this).removeClass('selected');
		} else {
			table.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
			rno = $(this).children().first().html();
		}
	});
	$('#deleteReply').click(function() {
		$.ajax({
			url : 'removeReply.do',
			data : {
				rno : rno
			},
			dataType : 'json',
			success : function(result){
		table.row('.selected').remove().draw(false);				
			}
		})
	});
	function deleteRow(rno){
		$.ajax({
			url : 'removeReply.do',
			data : {
				rno : rno
			},
			dataType : 'json',
			success : function(result){
		table.row('.selected').remove().draw(false);				
			}
		})
	}
</script>


