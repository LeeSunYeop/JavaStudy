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
	<h1 style=" text-align: center;">${title}</h1>

	<a href="/jsp/member/login.jsp">로그인 화면으로</a>
	<table border="1" style="margin-left: auto; margin-right: auto;">
	
		<thead>
			<tr>
				<th>등록번호</th>
				<th>작성자</th>
				<th width="300px">제목</th>
				<th>작성일자</th>
				<th>조회수</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${pt.list}" var="dto">
			
				<tr>
					<td>${dto.num}</td>
					<td>${dto.bid}</td>
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
	<jsp:include page="part_search.jsp"/>
	<jsp:include page="part_page.jsp" />
	<div style=" text-align: center;">
		<a href="/board/insertui.do">게시글 등록</a>
	</div>
</body>
</html>