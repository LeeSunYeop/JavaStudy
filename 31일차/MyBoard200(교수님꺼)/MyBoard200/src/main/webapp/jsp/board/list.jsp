<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>

</head>
<body>
	<h1>${title}</h1>

	<a href="/board/insertui.do">글쓰기 화면으로 가기</a>
	
	<jsp:include page="part_search.jsp"/>
	
	<table border="1">
		<thead>
			<tr>
				<th>num</th>
				<th>author</th>
				<th width="300px">title</th>
				<th>writeday</th>
				<th>readcnt</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${pt.list}" var="dto">
			
				<tr>
					<td>${dto.num}</td>
					<td>${dto.author}</td>
					<td>
						<c:forEach begin="1" end="${dto.repIndent}">
							&nbsp;
						</c:forEach>
						<a href="/board/read.do?num=${dto.num}&curPage=${pt.curPage}&criteria=${pt.criteria}&keyword=${pt.keyword}">${dto.title}</a>
					</td>
					<td>${dto.writeday}</td>
					<td>${dto.readcnt}</td>
				</tr>
			
			</c:forEach>
		</tbody>
		
	</table>

	<jsp:include page="part_page.jsp"/>
</body>
</html>