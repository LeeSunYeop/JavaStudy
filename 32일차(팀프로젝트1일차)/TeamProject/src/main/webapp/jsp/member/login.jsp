<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<h1>로그인 화면</h1>
	<h3>대우직업능력개발원</h3>
	<%
		String error = request.getParameter("error");
		if(error!=null){
			out.print("<div class='alert alert-danger'>");
			out.print("아이디와 비밀번호를 확인해주세요.");
			out.print("</div>");
		}
	%>
	<form action="/member/login.do" method="post">	
				
		<input name="mid" placeholder="아이디" required>
		<br>				
		<input type="password" name="password" placeholder="비밀번호" required>
		<br>
		<input type="submit" title="로그인" value="로그인">					
		<br>
		<br>
	</form>	
	<form action="/member/login.do" method="post">	
		<input type="submit" value="회원가입">
	</form>
	<form action="/member/login.do" method="post">
		<input type="submit" value="아이디/비밀번호찾기">	
		<br>
		<br>
		*직원은 인트라넷으로 접속하세오.		
	</form>
	
	<form action="/member/login.do" method="post">
		ID : <input name="mid"><br>
		비밀번호: <input name="name" type="password"><br>
		<input type="submit" title="로그인" value="로그인" class="ej_login_btn" id="ej-Button">	
	
	</form>

</body>
</html>