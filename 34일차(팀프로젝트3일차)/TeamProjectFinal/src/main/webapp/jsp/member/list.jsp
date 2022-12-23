<%@ page import="kr.co.domain.MemberDTO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 보기</title>
</head>
<body>



<h1>관리자 페이지입니다.</h1>
<%
	HttpSession session = request.getSession(false);
	if(session != null){
		MemberDTO login =(MemberDTO)session.getAttribute("login");
		pageContext.setAttribute("login", login);
	}
%>
	<c:forEach items="${list}" var="dto">
		<a href="/member/read.do?mid=${dto.mid}">${dto.mid} : ${dto.name}</a>
		<br>
	</c:forEach>
	<br>
	<c:if test="${empty login }">
		<a href="/member/loginui.do">로그인</a> |
	</c:if>
	<c:if test="${not empty login}">
		<a href="/member/logout.do">로그아웃</a> |
		
	</c:if>
	<a href="/board/list.do">게시글 목록</a>

</body>
</html>