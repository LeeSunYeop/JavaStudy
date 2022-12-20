<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>
	<p>
		안녕하세요. 띄어쓰기는&nbsp;&nbsp;&nbsp;&nbsp;원래 없었는데, 미국인이 제안해서 생긴 문법입니다.
	</p>
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
						<a href="/board/read.do?num=${dto.num}&curPage=${pt.curPage}">${dto.title}</a>
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