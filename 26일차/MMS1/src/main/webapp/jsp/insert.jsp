<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 입력 화면</title>
</head>
<body>
	<form action="/insert.do" method="post">
		ID: <input name="id"><br>
		NAME: <input name="name"><br>
		AGE: <input name="age"><br>
		<input type="submit" value="입력">
	</form>

</body>
</html>