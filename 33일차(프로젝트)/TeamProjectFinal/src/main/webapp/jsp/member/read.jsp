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
	아이디 : ${dto.mid}<br>
	이름 : ${dto.name}<br>
	생년월일 : ${dto.birth}<br>

	<a href="/member/list.do">목록</a> |
	<a href="/member/updateui.do?mid=${dto.mid}">수정</a> |	
	<a href="#" onclick="deleteBoard()">삭제</a> |
	<a href="/member/logout.do">로그아웃</a>

	<form action="/member/delete.do" method="post" id="mform">
		<input type="hidden" name="mid" value="${dto.mid}">
		<input type="hidden" name="curPage" value="${curPage}">
		<input type="hidden" name="criteria" value="${criteria}">
		<input type="hidden" name="keyword" value="${keyword}">
	</form>
	
	<script type="text/javascript">
		function deleteBoard() {
			let mpw = prompt("비밀번호를 입력하세요.");
			
			let mpwt = document.createElement("input");
			mpwt.setAttribute("type", "password");
			mpwt.setAttribute("name", "mpw");
			mpwt.setAttribute("value", mpw);
			
			document.getElementById("mform").appendChild(mpwt);
			
			document.getElementById("mform").submit();
		}
	</script>
</body>
</html>