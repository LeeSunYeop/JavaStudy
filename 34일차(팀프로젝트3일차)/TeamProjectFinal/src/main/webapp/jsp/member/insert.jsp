<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
</head>
<body>
	<h1>대우직업능력개발원 회원가입</h1>
	<form action="/member/insert.do" method="post">
		이름* <br>
		<input name="name" required><br>
		아이디* <br>
		<input name="mid" required><br>
		비밀번호* <br>
		<input name="mpw" required><br>
		비밀번호확인* <br>
		<input name="mpw" required><br>				
		생년월일* <br>
		<input type="date" name="birth" value="2022-12-22" required><br>
		<br>
		<input type="submit" value="회원가입">
	</form>

</body>
</html>