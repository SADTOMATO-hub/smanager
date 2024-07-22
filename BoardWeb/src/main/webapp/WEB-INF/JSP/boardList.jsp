
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../includes/header.jsp"%>

<h3>게시글목록</h3>
<!-- 검색조건 영역 -->
<div class="center">
	<form action="boardList.do">
	  <div class="row">
		<div class="col-sm-4"> <!-- select 목록 -->
			<select name="searchCondition" class="form-control">
				<option value="">고르시오</option>
				<option value="T" ${paging2.searchCondition == 'T' ? 'selected' : '' }>제목</option>
				<option value="W" ${paging2.searchCondition eq 'W' ? 'selected' : '' }>작성자</option>
				<option value="TW" ${paging2.searchCondition eq 'TW' ? 'selected' : '' }>제목과 작성자</option>
			</select>
		</div>   	
	  <div class="col-sm-6">
	  	<input type="text" name="keyword" value="${paging2.keyword }" class="form-control">
	  </div>
	  <div class="col-sm-2">
	  	<input type="submit" value="조회" class="btn btn-primary">
	  </div>
	  </div>
	</form>
</div>

<table class="table">
	<thead>
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach var="board" items="${boardList }">
		
		<tr>
			<td>${board.boardNo }</td>
			<td><a href="board.do?page=${paging.page }&bno=${board.boardNo }">${board.title }</a></td>
			<td>${board.writer }</td>
			<td>${board.writeDate }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<p>${paging }</p>
<!-- 페이징 -->
<nav aria-label="Page navigation example">
   <ul class="pagination justify-content-center">
   <!-- prev 페이지 -->
  <c:if test="${paging.prev }">
    <li class="page-item">
      <a class="page-link" href="boardList.do?page=${paging2.page - 1 }&searchCondition=${paging2.searchCondition}&keyword=${paging2.keyword}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
  </c:if>
     <!-- 페이지 갯수만큼 링크생성 -->
    <c:forEach var="p" begin="${paging.startpage }" end="${paging.endpage }">
      <c:choose>
    	<c:when test="${paging.page == p }">
    	  <li class="page-item active" aria-current="page">
    	    <span class="page-link">${p }</span>
    	   </li>
    	</c:when>
    	<c:otherwise>
		  <li class="page-item"><a class="page-link" href="boardList.do?page=${p }&searchCondition=${paging2.searchCondition}&keyword=${paging2.keyword}">${p }</a></li>
					<!--paging.getPage속성 = p 같으면..  -->
		</c:otherwise>
      </c:choose>
    </c:forEach>    
     <!-- next 페이지 -->
    <c:if test="${paging.isNext()}">
    <li class="page-item">
      <a class="page-link" href="boardList.do?page=${paging.page + 1 }&searchCondition=${paging2.searchCondition}&keyword=${paging2.keyword}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
  </ul>
</nav>
<!-- 페이지부분 -->
<%@ include file="../includes/footer.jsp"%>