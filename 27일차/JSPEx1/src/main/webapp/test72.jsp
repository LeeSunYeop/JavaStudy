<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
// Command 클래스 작업이라고 상상하세요.
	List<String> list = new ArrayList<String>();
	list.add("hello");
	list.add("good");
	list.add("world");
	list.add("test");
	
	request.setAttribute("list", list);	
%>

<c:forEach items="${list}" var="msg">
	${msg} <br>
</c:forEach>

<c:forEach begin="1" end="10" step="1" var="num">
	${num}<br>
</c:forEach>

</body>
</html>