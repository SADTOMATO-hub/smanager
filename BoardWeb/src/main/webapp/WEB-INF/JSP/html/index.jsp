<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 여기는 html/index.jsp -->
<h3>연습합시다</h3>

<div id="student">
<table class="table">
		<tr>
			<th>학생번호</th>
			<td><input type="text" class="form-control" id="sno"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" class="form-control" id="sname"></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" class="form-control" id="phone"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button id="addBtn" class="btn btn-primary">등록</button>
			</td>
		</tr>
	</table>
</div>
<hr />
<div>
	<table class="table">
		<thead>
			<tr>
				<th>학생번호</th>
				<th>학생이름</th>
				<th>학생전번</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody id="stdlist">
		</tbody>
	</table>
</div>

<div id="show">
	<select class="form-control" id="searchGender">
		<option value="All">고르시오</option>
		<option value="Male">남성</option>
		<option value="Female">여성</option>
	</select>
	<table class="table">
		<thead>
		</thead>
		<tbody id="emplist">
			<!-- 사원번호, fname, lame, salary -->
		</tbody>
	</table>
</div>


<table class="table table-hover">
	<thead>
		<tr>
			<th>친구이름</th>
			<th>주소</th>
			<th>신장</th>
			<th>삭제</th>
			<th><input type="checkbox" class="btn btn-primary"></th>
		</tr>
	</thead>
	<tbody id="list">
		<tr>
		</tr>
	</tbody>
</table>







<script src="js/json4.js"></script>