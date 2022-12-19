<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 자세히 보기</title>
</head>
<body>
	<h1>게시글 자세히 보기</h1>
	
	글번호: ${dto.num}<br>
	작성일: ${dto.writeday}<br>
	작성자: ${dto.author}<br>
	조회수: ${dto.readcnt}<br>
	제에목: ${dto.title}<br>
	글내용
	<p>${dto.content}</p>
	
	<br>
	<a href="/board/list.do">목록</a> |
	<a href="/board/updateui.do?num=${dto.num}">수정</a> |
	<a href="#" onclick="deleteBoard()">삭제</a> |
	<a href="/board/replyui.do?orgNum=${dto.num}">답글 달기 화면으로 가기</a>
	
	<form action="/board/delete.do" method="post" id="mform">
		<input type="hidden" name="num" value="${dto.num}">
	</form>
	<script type="text/javascript">
		function deleteBoard() {
			let pw = prompt("비밀번호를 입력하세요.");

			let pwt = document.createElement("input");
			pwt.setAttribute("type", "password");
			pwt.setAttribute("name", "pw");
			pwt.setAttribute("value", pw);
			
			document.getElementById("mform").appendChild(pwt);
			
			
			document.getElementById("mform").submit();
		}
	</script>	
</body>
</html>