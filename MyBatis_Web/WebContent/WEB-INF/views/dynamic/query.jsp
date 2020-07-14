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
<h1>Query </h1>
<hr>

<table>
<c:forEach var="list" items="${list}" >
	<tr>
	<td>
	번호  : ${list.NO}
	아이디 : ${list.ID}
	패스워드 : ${list.PW}
	</td>
	</tr>
</c:forEach>
</table>

</body>
</html>