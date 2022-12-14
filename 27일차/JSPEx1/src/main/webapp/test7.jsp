<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String msg = "black";
	pageContext.setAttribute("msg", msg);
%>

${msg}

<c:if test="${msg == 'red' }">
	<p>참입니다.</p>
</c:if>

<c:if test="${msg != 'red' }">
	<p>거짓입니다.</p>
</c:if>


</body>
</html>