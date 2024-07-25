<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h3>맴버목록.memberList</h3>
<c:choose>
<ul class="nav nav-pills">
  <li class="nav-item">
    <a class="nav-link active" href="memberList.do?order=member_id&res=user">일반회원</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="memberList.do?order=member_id&res=Admin">관리자</a>
  </li>
</ul>
</c:choose>
<table class="table table-hover">
	<thead>
		<tr>
			<th><a href="memberList.do?order=member_id">회원 아이디</a></th>
			<th><a href="memberList.do?order=member_pw">회원 비밀번호</a></th>
			<th><a href="memberList.do?order=member_nm">회원명</a></th>
			<th><a href="memberList.do?order=responsibility">회원 권한</a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="list" items="${memberList }">
		<tr>
			<td>${list.memberId }</td>
			<td>${list.memberPw }</td>
			<td>${list.memberNm }</td>
			<td>${list.responsibility }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

