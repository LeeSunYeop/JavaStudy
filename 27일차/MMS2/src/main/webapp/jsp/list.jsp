<%@ page import="kr.co.domain.MemberDTO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 보기</title>
</head>
<body>
<a href="/member/insertui.do">회원 등록 화면으로 가기</a><br>
<br>

<c:forEach items="${list}" var="dto">
	<a href="/member/read.do?id=${dto.id}">${dto.id} : ${dto.name}</a>
	<br>
</c:forEach>
<br>

<a href="/member/loginui.do">로그인</a> |
<a href="/member/logout.do">로그아웃</a>

</body>
</html>