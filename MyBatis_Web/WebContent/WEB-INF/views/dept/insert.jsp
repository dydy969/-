<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>부서 정보 입력 </h1>
<hr>

<form action="/dept/insert" method="post">

<label>부서번호 <input type="number" min="0" max="99" name="deptno" id="deptno"> </label><br>
<label>부서이름 <input type="text" name="dname" id="dname"> </label><br>
<label>부서위치 <input type="text" name="loc" id="loc"> </label><br><br>

<button>입력</button>
</form>


</body>
</html>