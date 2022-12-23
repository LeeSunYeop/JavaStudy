<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
	<h1>회원정보 수정</h1>
	<form action="/member/update.do" method="post">
		아이디 : <input name="mid" value="${dto.mid}" readonly><br>
		비밀번호 : <input name="mpw" value="${dto.mpw}"><br>
		이름 : <input name="name" value="${dto.name}"><br>
		생년월일 : <input name="birth" value="${dto.birth}">
		<input type="date" name="birth" value="2022-12-22" required><br>
		
		<input type="submit" value="수정">
	</form>

</body>
</html>