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
<h1>사원 상세</h1>
<hr>

<table>
<tr>
	<td>${detail.deptno }</td>
	<td>${detail.dname }</td>
	<td>${detail.loc }</td>
</tr>
</table>

</body>
</html>
