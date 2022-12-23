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
<style type="text/css">
	.search{
		text-align: center;
		margin: 5px;
		padding: 5px;
	}
</style>

<div class="search">
	<form action="/board/list.do?mid=${login.mid}" method="get">
		<select name="criteria">
			<option value="title">제목</option>
			<option value="bid">작성자</option>
			<option value="content">내용</option>
		</select>
		<input name="keyword" placeholder="검색어를 입력하세요"> 
		<input type="submit" value="검색">

	</form>
</div>
