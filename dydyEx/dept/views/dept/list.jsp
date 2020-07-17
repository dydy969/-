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

<h1>사원정보</h1>
<hr>

<table>
<c:forEach items="${list }" var="d">

<tr>
	<td>사원번호</td>
	<td>사원이름</td>
	<td>지역</td>
</tr>
<tr>
	<td>${d.deptno }</td>
	<td><a href="/dept/detail?deptno=${d.deptno }">${d.dname }</a></td>
	<td>${d.loc }</td>
</tr>



</c:forEach>


</table>
<a href="/dept/insert">입력하기</a>

</body>
</html>
