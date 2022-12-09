<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/ms1" method="post">
		<label for="id">ID</label>
		<input id="id" name="id"><br>
		
		<label for="pw">PW</label>
		<input type="password" id="pw" name="pw"><br>
		
		<label for="name">NAME</label>
		<input id="name" name="name"><br>
		
		<input type="submit" value="로그인">
	</form>

</body>
</html>