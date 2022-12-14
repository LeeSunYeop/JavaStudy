<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>

	<form action="/login.do" method="post">
		ID : <input name="id"><br>
		비밀번호: <input name="name" type="password"><br>
		<input type="submit" value="로그인">
	
	</form>

</body>
</html>