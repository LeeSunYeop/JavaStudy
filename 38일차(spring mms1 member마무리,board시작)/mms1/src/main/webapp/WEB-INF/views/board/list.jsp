<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>게시글 목록 보기</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
   <div class="jumbotron">
         <h1 class="display-4">게시글 목록 화면</h1>
   </div>
   
   <table class="table">
        <thead>
          <tr>
            <th scope="col" class="text-center">글번호</th>
            <th scope="col" class="text-center">제목</th>
            <th scope="col" class="text-center">작성자</th>
            <th scope="col" class="text-center">조회수</th>
            <th scope="col" class="text-center">작성일</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="dto">
        	<tr>
            <td class="text-center">${dto.bno}</td>
            <td>${dto.title}</td>
            <td class="text-center">${dto.id}</td>
            <td class="text-center">${dto.readcnt}</td>
            <td class="text-center">${dto.regdate}</td>
            </tr>
        </c:forEach>
          
   
        </tbody>
   </table>
   

</div>



</body>
</html>