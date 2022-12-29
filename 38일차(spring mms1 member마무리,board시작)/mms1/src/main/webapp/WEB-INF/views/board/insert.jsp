<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>게시글 입력 화면</title>

<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
   integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
   crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
   integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
   crossorigin="anonymous"></script>
</head>
<body>
   <div class="container">
      <div class="jumbotron">
         <h1 class="display-4">게시글 입력 화면</h1>
      </div>

      <form action="/board/insert" method="post">
         <div class="form-group row">
            <label for="id">작성자</label>         
            <input class="form-control" id="id" name="id" required>           
         </div>
         
         <div class="form-group row">
            <label for="pw">비밀번호</label>         
            <input type="password" class="form-control" id="pw" name="pw" required>           
         </div>         
         
         <div class="form-group row">
            <label for="title">제목</label>           
            <input class="form-control" id="title" name="title" required>           
         </div>
         
         <div class="form-group row">      
            <label for="content">내용</label> 
            <textarea rows="10" id="content" name="content" class="form-control" required></textarea>            
         </div>
         
         <div class="form-group row">           
            <button type="submit" class="btn btn-primary boardsubmit">완료</button>           
         </div>
      
      </form>
   </div>
   
   <script type="text/javascript">
      $(document).ready(function() {
         $("form[action='/board/insert']").on("click", ".boardsubmit", function(event) {
        	 event.preventDefault();
        	 
        	 let id = $("#id").val();
        	 let pw = $("#pw").val();
        	 let title = $("#title").val();
        	 let content = $("#content").val();
        	 
        	 if(id == ""){
        		 $("#id").focus(); 
        		 return false;
        	 } 
        	 
        	 if(pw == ""){
        		 $("#pw").focus();
        		 return false;
        	 }
        	 
        	 if(title == ""){
        		 $("#title").focus();
        		 return false;
        	 }
        	 
        	 if(content == ''){
        		 $("#content").focus();
        		 return false;
        	 }
       	
        	 $("form").submit();
		});
      });
   </script>

</body>
</html>