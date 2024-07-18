<%@page import="com.yedam.vo.StudentVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.mapper.StudentMapper"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.yedam.common.DataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentList.jsp</title>
</head>
<body>
	<table border="2">
		<thead>
			<tr>
				<th>이름</th>
				<th>학번</th>
				<th>연락처</th>
			</tr>
		</thead>
		<%
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<StudentVO> list = mapper.studentList();
		for (StudentVO svo : list) {
		%>
		<tr>
			<td><a href="student.jsp?sno=<%=svo.getStudentNo() %>"><%=svo.getStudentName()%></a></td>
			<td><%=svo.getStudentNo()%></td>
			<td><%=svo.getStudentPhone()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>