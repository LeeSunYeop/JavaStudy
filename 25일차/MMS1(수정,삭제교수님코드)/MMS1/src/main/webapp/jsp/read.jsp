<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 자세히 보기</title>
</head>
<body>
ID : ${dto.id}<br>
NAME : ${dto.name}<br>
AGE ; ${dto.age}<br>

<a href="/list.do">목록</a> | 
<a href="/updateui.do?id=${dto.id}">수정화면으로</a> | 
<a href="/delete.do?id=${dto.id}">삭제</a>

</body>
</html>