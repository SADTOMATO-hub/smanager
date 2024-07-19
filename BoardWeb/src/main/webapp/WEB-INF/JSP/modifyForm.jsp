<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%
	BoardVO board = (BoardVO) request.getAttribute("board");
%>
<h3>수정 페이지</h3>
	<form action="updateBoard.do">
<input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
	<table class="table">
		<tr>
			<th class="col-sm-3">글번호</th><td><%=board.getBoardNo() %></td>
			<th>조회수</th><td><%=board.getViewCnt() %></td>
		</tr>
		<tr>
			<th>제목</th>
		<td><input class="form-control" type="text" name="title" value=<%=board.getTitle() %>></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea class="form-control" name="content"><%=board.getContent() %></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><%=board.getWriter() %></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			<input class="btn btn-danger" type="submit" value="수정 확인"> 
			<button class="btn btn-warning" type="reset">취소</button>
			</td>
		</tr>
	</table>
</form>
<%@ include file="../includes/footer.jsp"%>