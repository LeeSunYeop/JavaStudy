<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>
	<a href="/board/insertui.do">글쓰기 화면으로 가기</a>
	
	<table border="1">
		<thead>
			<tr>
				<th>num</th>
				<th>author</th>
				<th>title</th>
				<th>writeday</th>
				<th>readcnt</th>
				<th>repRoot</th>
				<th>repStep</th>
				<th>repIndent</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="dto">
			
				<tr>
					<td>${dto.num}</td>
					<td>${dto.author}</td>
					<td><a href="/board/read.do?num=${dto.num}">${dto.title}</a></td>
					<td>${dto.writeday}</td>
					<td>${dto.readcnt}</td>
					<td>${dto.repRoot}</td>
					<td>${dto.repStep}</td>
					<td>${dto.repIndent}</td>
				</tr>
			
			</c:forEach>
		
		
		
		
			
			
		</tbody>
		
	</table>


</body>
</html>