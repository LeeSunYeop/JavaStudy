<%@page import="kr.co.domain.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%
	HttpSession session = request.getSession(false);
	if(session != null){
		MemberDTO login =(MemberDTO)session.getAttribute("login");
		pageContext.setAttribute("login", login);
	}
%>
   
<div style=" text-align: center;">    
	<c:if test="${pt.curPage > 1}">
		<a href="/board/list.do?curPage=${pt.curPage-1}&criteria=${pt.criteria}&keyword=${pt.keyword}&mid=${login.mid}">&lt;</a>
	</c:if>    
	<c:forEach begin="${pt.beginPageNum}" end="${pt.finishPageNum}" var="i">
		<c:if test="${i != pt.curPage}">
			<a href="/board/list.do?curPage=${i}&criteria=${pt.criteria}&keyword=${pt.keyword}&mid=${login.mid}">${i}</a>
		</c:if>
		<c:if test="${i == pt.curPage}">
			<a style="color:red;" href="/board/list.do?curPage=${i}&criteria=${pt.criteria}&keyword=${pt.keyword}&mid=${login.mid}">${i}</a>
		</c:if>
	</c:forEach>
	
	<c:if test="${pt.curPage < pt.totalPage}">
		<a href="/board/list.do?curPage=${pt.curPage+1}&criteria=${pt.criteria}&keyword=${pt.keyword}&mid=${login.mid}">&gt;</a>
	</c:if>
</div>