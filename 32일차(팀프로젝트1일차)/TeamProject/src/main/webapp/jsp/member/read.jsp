<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 상세보기</title>
</head>
<body>
	<h1>회원정보 상세보기</h1>
	ID : ${dto.mid}<br>
	NAME : ${dto.name}<br>
	AGE : ${dto.age}<br>

	<a href="/member/list.do">목록</a> |
	<a href="/member/updateui.do?id=${dto.mid}">수정</a> |
	<a href="/member/delete.do?id=${dto.mid}">삭제</a> |
	<a href="/member/loginui.do">로그인</a> |
	<a href="/member/logout.do">로그아웃</a>

</body>
</html>