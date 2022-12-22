<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정화면</title>
</head>
<body>
<h1>게시글 수정</h1>
	<form action="/board/update.do" method="post">
		<input type="hidden" name="curPage" value="${curPage}">
		<input type="hidden" name="criteria" value="${criteria}">
		<input type="hidden" name="keyword" value="${keyword}">
		등록번호 : <input name="num" value="${dto.num}" readonly><br>
		작성자 : <input name="bid" required value="${dto.bid}"><br>
		비밀번호 : <input name="pw"  required ><br>
		제목 : <input name="title" required value="${dto.title}"><br>
		
		내용<br>
		<textarea rows="10" name="content" required>${dto.content}</textarea><br>
		
		<input type="submit" value="수정">
	
	
	
	</form>


</body>
</html>