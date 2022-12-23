
<%@page import="kr.co.domain.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>

<%
	HttpSession session = request.getSession(false);
	if(session != null){
		MemberDTO login =(MemberDTO)session.getAttribute("login");
		pageContext.setAttribute("login", login);
	}
%>
	<h1>게시글 등록</h1>
	<form action="/board/insert.do?mid=${login.mid}" method="post">
		<input type="hidden" name="bid" value="${login.mid}">
		작성자   :   <input name="name" value="${login.name}"  readonly required><br>
		제목 : <input name="title" required><br>
		암호 : <input name="pw" required><br> 
		내용<br>
		<textarea rows="10" name="content" required></textarea><br>
		
		<input type="submit" value="등록">
	
	
	
	</form>

</body>
</html>