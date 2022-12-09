<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/ms2" method="post">
		<p>최종 학력을 선택하세요.</p>
		
		<input type="radio" name="school" value="초등" id="el">
		<label for="el">초등</label>
		<br>
		<input type="radio" name="school" value="중학교" id="mi">
		<label for="mi">증학교</label>
		<br>
		<input type="radio" name="school" value="고등학교" id="hi">
		<label for="hi">고등학교</label>
		<br>
		<input type="radio" name="school" value="기타" id="ect">
		<label for="ect">기타</label>
		<br>
		
		<input type="submit" value="학력 선택">
		
	</form>

</body>
</html>