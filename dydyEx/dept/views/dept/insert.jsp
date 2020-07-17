<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>사원입력</h1>
<hr>

<form action="/dept/insert" method="post">

<label>사원번호<input type="number" min="0" max="99" name="deptno"> </label><br>
<label>사원이름<input type="text" name="dname"> </label><br>
<label>지역<input type="text" name="loc"> </label><br><br>

<button>입력하기</button>
</form>


</body>
</html>
