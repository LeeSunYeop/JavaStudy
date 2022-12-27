<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>회원 가입 화면</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<form action="/member/insert" method="post">
			<div class="form-group row">
				<label for="id" class="col-sm-2 col-form-label text-right">아이디</label>
				<div class="col-sm-10"> 
					<input class="form-control" id="id" name="id" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="name" class="col-sm-2 col-form-label text-right">이름</label>
				<div class="col-sm-10">
					<input class="form-control" id="name" name="name" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="pw1" class="col-sm-2 col-form-label text-right">비밀번호</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pw1" name="pw" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="pw2" class="col-sm-2 col-form-label text-right">비밀번호(확인)</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pw2" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="birth" class="col-sm-2 col-form-label text-right">생년월일</label>
				<div class="col-sm-10">
					<input class="form-control" id="birth" name="birth" type="date" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="email" class="col-sm-2 col-form-label text-right">이메일</label>
				<div class="col-sm-10">
					<input class="form-control" id="email" name="email" type="email" required>
				</div>
			</div>

			<div class="form-group row">
				<label for="address" class="col-sm-2 col-form-label text-right">주소</label>
				<div class="col-sm-10">
					<input class="form-control" id="address" name="address" required>
				</div>
			</div>
			
			<div class="form-group row">
				<div class="col-sm-10">
     				 <button type="submit" class="btn btn-primary">가입</button>
    			</div>
    		</div>
    		
		</form>
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$("button[type='submit']").click(function(event) {
				event.preventDefault();
				
				let pw1 = $("#pw1").val();
				let pw2 = $("#pw2").val();
				
				if(pw1 == "" || pw2 == ""){					
					$("#pw1").focus();
					alert("비밀번호를 입력해 주세요.")
					
					return false;
				}
				
				if (pw1 != pw2) {
					$("#pw2").val("");
					$("#pw1").select();
					$("#pw1").focus();
					alert("비밀번호가 맞지 않습니다.")
					
					return false;					
				} 
				
				$("form").submit();
												
			});			
		});
	
	</script>
	
</body>
</html>