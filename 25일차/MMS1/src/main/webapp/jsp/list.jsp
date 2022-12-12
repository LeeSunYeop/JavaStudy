<%@ page import="kr.co.domain.MemberDTO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		List<MemberDTO> list = (List<MemberDTO>)request.getAttribute("list");
	
		for(int i=0; i<list.size(); i++){
			MemberDTO dto = list.get(i);
			%>
			
				<%= dto.getId() %>
				<%= " : " %>
				<a href="/read.do?id=<%= dto.getId()%>"><%= dto.getName() %></a>
				<%= "<br>" %>
			<% 
		}
	%>

</body>
</html>