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
		ID : <input name="mid" value="${dto.mid}" readonly><br>
		PASSWORD : <input name="password" value="${dto.password}">
		NAME : <input name="name" value="${dto.name}"><br>
		AGE : <input name="age" value="${dto.age}"><br>
		<input type="submit" value="수정">
		
	</form>

</body>
</html>