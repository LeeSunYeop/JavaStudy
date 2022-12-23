<%@page import="kr.co.repository.MemberDAO"%>
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
<title>환영</title>
</head>
<body>
<%
	HttpSession session = request.getSession(false);
	if(session != null){
		MemberDTO login =(MemberDTO)session.getAttribute("login");
		pageContext.setAttribute("login", login);
	}
%>

	<h1>${login.name}님 환영합니다.</h1>
	<a href="/board/list.do?mid=${login.mid}">게시목록가기</a>
</body>
</html>