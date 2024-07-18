<%@page import="com.yedam.vo.StudentVO"%>
<%@page import="com.yedam.mapper.StudentMapper"%>
<%@page import="com.yedam.common.DataSource"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	String sno = request.getParameter("sno"); //?sno=s2018-04
	StudentVO std = mapper.selectOne(sno);
	%>
	<h3>학생상세보기</h3>
	<table border="2">
		<tr>
			<th>학생번호</a></th>
			<td><%=std.getStudentNo() %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=std.getStudentName() %></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%=std.getStudentPhone() %></td>
		</tr>
	</table>
	<a href="../SampleServlet">목록으로 갑시다.</a>
</body>
</html>