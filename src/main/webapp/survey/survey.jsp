<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="${path}/front">
			<input type=hidden name="methodName" value="survey">
			<input type=hidden name="key" value="survey">
			산미
			<input type="radio" name="sour" value="1">
			<label >1</label>
			<input type="radio" name="sour" value="2">
			<label>2</label>
			<input type="radio" name="sour" value="3">
			<label>3</label>
			<input type="radio" name="sour" value="4">
			<label>4</label>
			<input type="radio" name="sour" value="5">
			<label>5</label> <br>
			
			바디감
			<input type="radio" name="body" value="1">
			<label >1</label>
			<input type="radio" name="body" value="2">
			<label>2</label>
			<input type="radio" name="body" value="3">
			<label>3</label>
			<input type="radio" name="body" value="4">
			<label>4</label>
			<input type="radio" name="body" value="5">
			<label>5</label> <br>
			
			단맛
			<input type="radio" name="sweet" value="1">
			<label >1</label>
			<input type="radio" name="sweet" value="2">
			<label>2</label>
			<input type="radio" name="sweet" value="3">
			<label>3</label>
			<input type="radio" name="sweet" value="4">
			<label>4</label>
			<input type="radio" name="sweet" value="5">
			<label>5</label> <br>
			
			아로마
			<input type="radio" name="aroma" value="1">
			<label >1</label>
			<input type="radio" name="aroma" value="2">
			<label>2</label>
			<input type="radio" name="aroma" value="3">
			<label>3</label>
			<input type="radio" name="aroma" value="4">
			<label>4</label>
			<input type="radio" name="aroma" value="5">
			<label>5</label> <br>
			<input type="submit" value="확인하기">
		</form> 
	</body>
</html>