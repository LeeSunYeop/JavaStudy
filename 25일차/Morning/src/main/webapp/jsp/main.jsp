<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	HttpSession session = request.getSession(false);
	String id = null;
	
	if(session != null){
		id = (String)session.getAttribute("id"); 
		// Object를 사용안하면 String 으로 형변환 해야 한다.
		// Object obj_id = session.getAttribute("id");
	}
%>

<%= id %> 님, 환영합니다. <a href="/logout">로그아웃</a>
</body>
</html>