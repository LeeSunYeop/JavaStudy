<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 화면</title>
</head>
<body>
	<form action="/update.do" method="post">
		ID : <input name="id" value="${dto.id}" readonly><br>
		NAME : <input name="name" value="${dto.name}"><br>
		AGE : <input name="age" value="${dto.age}"><br>
		<input type="submit" value="수정">
	
	</form>

</body>
</html>