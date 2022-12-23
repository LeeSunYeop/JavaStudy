<%@page import="kr.co.domain.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	HttpSession session = request.getSession(false);
	if(session != null){
		MemberDTO login =(MemberDTO)session.getAttribute("login");
		pageContext.setAttribute("login", login);
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>
	<h1>게시글 보기</h1>
	글번호 : ${dto.num}<br>
	작성일 : ${dto.writeday}<br>
	작성자 : ${dto.name}<br>
	조회수 : ${dto.readcnt}<br>
	제 목 : ${dto.title}<br>
	내 용
	<p>${dto.content}</p>
	
	<br>

	<a href="/board/list.do?curPage=${curPage}&criteria=${criteria}&keyword=${keyword}&mid=${login.mid}">목록</a>|
	<c:if test="${dto.bid==login.mid}">
		<a href="/board/updateui.do?num=${dto.num}&curPage=${curPage}&criteria=${criteria}&keyword=${keyword}&mid=${login.mid}">수정</a>|
	</c:if>
	<c:if test="${dto.bid==login.mid}">
		<a href="#" onclick="deleteBoard()">삭제</a><br>
	</c:if>
	
	<c:if test="${login.mid != null }">
		<a href="/board/replyui.do?orgNum=${dto.num}&curPage=${curPage}&criteria=${criteria}&keyword=${keyword}&mid=${login.mid}">답글</a>
	</c:if>
	

	
	
	<form action="/board/delete.do?mid=${login.mid}" method="post" id="mform">
		<input type="hidden" name="num" value="${dto.num}">
		<input type="hidden" name="curPage" value="${curPage}">
		<input type="hidden" name="criteria" value="${criteria}">
		<input type="hidden" name="keyword" value="${keyword}">		
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