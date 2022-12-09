<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/ms2" method="get">
		<p>당신의 취미는?</p>
		
		<input type="checkbox" name="hobby" value="독서" id="book">
		<label for="book">독서</label>
		
		<input type="checkbox" name="hobby" value="낮잠" id="sleep">
		<label for="sleep">낮잠</label>
		
		<input type="checkbox" name="hobby" value="운동" id="play">
		<label for="play">운동</label>
		
		<br>
		
		<input type="submit" value="선택">		
	</form>

</body>
</html>