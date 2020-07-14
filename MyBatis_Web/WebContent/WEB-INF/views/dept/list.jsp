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

<h1>부서 정보 목록</h1>
<hr>

<table border="1">
<thead>
<tr>
	<td>부서번호</td>
	<td>부서이름</td>
	<td>위치</td>
</tr>
</thead>
<c:forEach items="${deptList }" var="dept">
<tr>
	<td>${dept.deptno }</td>
	<td><a href="/dept/detail?deptno=${dept.deptno }">${dept.dname }</a> </td>
	<td>${dept.loc }</td>
</tr>
</c:forEach>
</table>

<a href="/dept/insert">입력</a>
</body>
</html>