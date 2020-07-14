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
	<td>부서번호</td>
	<td>부서명</td>
	<td>지역</td>
</tr>

<tr>
	<td>${detail.deptno }</td>
	<td>${detail.dname }</td>
	<td>${detail.loc }</td>
</tr>
</table>

<a href="javascript:jistory.go(-1)">뒤로가기1</a>
<a href="/detail/list">뒤로가기2</a>
</body>
</html>