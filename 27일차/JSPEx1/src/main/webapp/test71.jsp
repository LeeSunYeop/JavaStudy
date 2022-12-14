<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int score = 89;
	
		pageContext.setAttribute("score", score);	
	%>
	
	<c:choose>
		<c:when test="${score >= 90 }">
			A
		</c:when>
		
		<c:when test="${score >= 80 }">
			B
		</c:when>
		
		<c:when test="${score >= 70 }">
			C
		</c:when>
		
		<c:when test="${score >= 60 }">
			D
		</c:when>
		
		<c:otherwise>
			F
		</c:otherwise>
	
	</c:choose>


</body>
</html>