<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 입력 화면</title>
</head>
<body>
	<h1>회원 정보 입력 화면</h1>
	<form action="/member/insert.do" method="post">
		ID: <input name="mid" required><br>
		PASSWORD: <input name="password" required><br>
		NAME: <input name="name" required><br>
		AGE: <input name="age" required><br>
		<input type="submit" value="입력">
	</form>

</body>
</html>