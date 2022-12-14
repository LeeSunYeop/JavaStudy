<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 액션 태그</title>
</head>
<body>
<%@ include file="part_head.jsp" %>
<h1>본문입니다.</h1>

<jsp:include page="part_contents.jsp">
	<jsp:param value="1" name="id"/>
	<jsp:param value="홍길동" name="name"/>
	<jsp:param value="16" name="age"/>
</jsp:include>

<jsp:include page="part_footer.jsp"/>


</body>
</html>