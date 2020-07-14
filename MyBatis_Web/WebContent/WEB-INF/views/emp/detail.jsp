<%@page import="web.dto.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
	<td>사원번호</td>
	<td>이름</td>
	<td>직무</td>
	<td>매니저</td>
	<td>입사일</td>
	<td>급여</td>
	<td>상여금</td>
	<td>Dept번호</td>
</tr>

	<tr>
		<td>${empno.empno }</td>
		<td>${empno.ename }</td>
		<td>${empno.job }</td>
		<td>${empno.mgr }</td>
		<td>${empno.hiredate }</td>
		<td>${empno.sal }</td>
		<td>${empno.comm }</td>
		<td>${empno.deptno }</td>
	</tr>
</table>

</body>
</html>