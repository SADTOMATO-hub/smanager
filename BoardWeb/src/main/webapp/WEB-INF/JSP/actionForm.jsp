<%@page import="com.yedam.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="mytag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>actionForm.jsp</title>
</head>
<body>
	<h3>액션 태그 연습.</h3>
	<%
	request.setAttribute("myName", "붉은 토마토");
	StudentVO student = new StudentVO();
	student.setStudentNo("100");
	student.setStudentName("홍길동");
	request.setAttribute("student", student);
	String msg = "Hello";
	%>
	<mytag:set var="msg" value="Hello2"></mytag:set>
	<mytag:set var="age" value="20"></mytag:set>


	<h3>Jsp Standard Tag Library & Expression Language</h3>
	<!-- 표준액션태그 여기서 반복,조건 등 등을 쓸 수 있다 -->

	<p>학생정보 ${student}</p>
	<p>학생의 이름은 ${student.studentName}, 학번은 ${student.studentNo }</p>

	<!-- 표준액션태그 여기서 반복,조건을 쓸 수 있다 -->
	<p>${ 10 + 4 }</p>
	<p>${ 10 > 20 }</p>
	<p>${ 'Hello' += 'World' }</p>
	<p>${ 10>5 ? 'true' : 'false' }</p>
	<p>내 이름은 ${myName}</p>
	<p>Msg 값은 ${msg}</p>	
	<mytag:choose>
		<mytag:when test="${age >= 20 }">
			<p>성인</p>
		</mytag:when>
		<mytag:otherwise>
			<p>미성년자</p>
		</mytag:otherwise>
	</mytag:choose>
	<mytag:forEach var="i" begin="1" end="10" step="2">
	<p>${i }</p>
	</mytag:forEach>
	<p>구구단</p>
	<mytag:forEach var="n" begin="1" end="9">
	<p>4 * ${n } = ${4*n }</p>
	</mytag:forEach>
	<!-- 기본 배포 -->
</body>
</html>