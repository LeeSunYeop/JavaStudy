<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<hr>
${param.id} : ${param.name} : ${param.age}
<br>
<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	pageContext.setAttribute("id", id);
	pageContext.setAttribute("name", name);
	pageContext.setAttribute("age", age);
%>

${id} : ${name} : ${age}
<hr>