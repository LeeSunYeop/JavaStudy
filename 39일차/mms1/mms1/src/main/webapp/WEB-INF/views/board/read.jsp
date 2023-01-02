<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>게시글 자세히 보기</title>

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
			<h1 class="display-4">게시글 자세히 보기</h1>
		</div>


			<div class="form-group row">
				<label for="id">작성자</label> 
				<input class="form-control" value="${dto.id}" readonly>
			</div>
			
			<div class="form-group row">
				<label for="readcnt">조회수</label> 
				<input class="form-control" value="${dto.readcnt}" readonly>
			</div>
			
			<div class="form-group row">
				<label for="regdate">작성일</label> 
				<input class="form-control" value="${dto.regdate}" type="date" readonly>
			</div>
			
			<div class="form-group row">
				<label for="updatedate">수정일</label> 
				<input id="updatedate" class="form-control" value="${dto.updatedate}" type="date" readonly>
			</div>


			<div class="form-group row">
				<label for="title">제목</label> 
				<input id="title" class="form-control" value="${dto.title}" readonly>
			</div>
			


			<div class="form-group row">
				<label for="content">내용</label>
				<textarea id="content" class="form-control" readonly>${dto.content}</textarea>
			</div>
			
			<div class="form-group row">
				<a href="/board/list/${curpage}/${criteria}/${keyword}" class="btn btn-light">목록</a> 
				<a class="btn btn-light" id="read_btn_updateui">수정</a> 
				<a class="btn btn-light" id="read_btn_delete">삭제</a> 
				<a class="btn btn-light">댓글</a>
			</div>


		<div class="modal" tabindex="-1" id="read_div_modal" data-backdrop="static">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">게시글 수정 화면</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="form-group row">
							<label for="read_input_modal_pw">비밀번호</label> 
							<input type="password" class="form-control" id="read_input_modal_pw">
						</div>
					
						<div class="form-group row">
							<label for="read_input_modal_title">제목</label> 
							<input class="form-control" id="read_input_modal_title"
								value="${dto.title}">
						</div>



						<div class="form-group row">
							<label for="read_ta_modal_content">내용</label>
							<textarea id="read_ta_modal_content" class="form-control">${dto.content}</textarea>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button id="read_btn_modal_submit" type="button" class="btn btn-primary">수정 완료</button>
					</div>
				</div>
			</div>
		</div>




	</div>
	
	<script type="text/javascript">
		let bno = "${dto.bno}";	
	
		$(document).ready(function() {
			
			
			$("#read_btn_delete").click(function() {
				let pw = prompt("비밀번호를 입력하세요.");
				
				$.ajax({
					url : "/board/delete/"+bno,
					type : "post",
					data : {
						"pw" : pw
					},
					dataType : "text",
					success : function(result) {
						if(result > 0){
							alert("삭제 성공");
							location.assign("/board/list/${curpage}/${criteria}/${keyword}");
						} else{
							alert("삭제 실패");
						}
					}
				});
			});
			
			$("#read_btn_modal_submit").click(function() {
				let title = $("#read_input_modal_title").val();
				let content = $("#read_ta_modal_content").val();
				let pw = $("#read_input_modal_pw").val();
				
				
				$.ajax({
					url : '/board/update',
					type : 'post',
					data : {
						"bno" : bno,
						"pw" : pw,
						"title" : title,
						"content" : content
					},
					dataType : "text",
					success : function(result) {
						if(result > 0){
							$("#title").val(title);
							$("#content").val(content);
							
							let today = new Date();
							let year = today.getFullYear();
							let month = today.getMonth() + 1;
							let date = today.getDate();
							month = month >= 10 ? month : '0'+month;
							date = date >= 10 ? date : '0'+date;
							
							today = year+"-"+month+"-"+date;
							$("#updatedate").val(today);
							
							$("#read_div_modal").modal("toggle");
							
						}else{
							alert("비밀번호를 확인하세요.");
							$("#read_input_modal_pw").focus();
							$("#read_input_modal_pw").select();
						}
					}
				});
				
			});
			
			
			
			$("#read_btn_updateui").click(function() {
				$("#read_div_modal").modal("toggle");
			});
			
		});
	</script>
	
	
	
	
	
	
	
	
</body>
</html>