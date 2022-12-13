<%@ page import="kr.co.domain.MemberDTO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 보기</title>
</head>
<body>
<a href="/insert.do">회원 등록 화면으로 가기</a><br>
<br>

<c:forEach items="${list}" var="dto">
	${dto.id} : ${dto.name}<br>
</c:forEach>


</body>
</html>