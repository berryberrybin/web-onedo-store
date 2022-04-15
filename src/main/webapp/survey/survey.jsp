<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>나만의 원두 찾기</title>
		<script type="text/javascript" src="../js/jquery-3.6.0.min.js" ></script>
		<style type="text/css">
			form{text-align: center;}
		</style>
		<script type="text/javascript">
			$(function() {
				$("[type=submit]").click(function() {
					if($("input[name='sour']:checked").val()==null){
						alert("모든 답에 체크 해주세요.")
						return false;
					}else if($("input[name='body']:checked").val()==null){
						alert("모든 답에 체크 해주세요.")
						return false;
					}else if($("input[name='sweet']:checked").val()==null){
						alert("모든 답에 체크 해주세요.")
						return false;
					}else if($("input[name='aroma']:checked").val()==null){
						alert("모든 답에 체크 해주세요.")
						return false;
					}
				});
			});
		</script> 
	</head>
	<body>
		
		<section>
			<div class="container">
				<div class="row">
				<jsp:include page="../common/category.jsp"/>
				<!-- 상품 페이지 추가-->
					<h1>나만의 원두 찾기</h1>
					<form action="${path}/front">
						<input type=hidden name="methodName" value="survey">
						<input type=hidden name="key" value="survey">
						산미
						<input type="radio" name="sour" value="1">
						<label >1</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sour" value="2">
						<label>2</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sour" value="3">
						<label>3</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sour" value="4">
						<label>4</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sour" value="5">
						<label>5</label> <br>
						바디감
						<input type="radio" name="body" value="1">
						<label >1</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="body" value="2">
						<label>2</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="body" value="3">
						<label>3</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="body" value="4">
						<label>4</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="body" value="5">
						<label>5</label> <br>
						
						단맛
						<input type="radio" name="sweet" value="1">
						<label >1</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sweet" value="2">
						<label>2</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sweet" value="3">
						<label>3</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sweet" value="4">
						<label>4</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sweet" value="5">
						<label>5</label> <br>
						
						아로마
						<input type="radio" name="aroma" value="1">
						<label >1</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="aroma" value="2">
						<label>2</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="aroma" value="3">
						<label>3</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="aroma" value="4">
						<label>4</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="aroma" value="5">
						<label>5</label> <br>
						<input type="submit" value="확인하기">
					</form>
				</div>
			</div>
		</section> 
	</body>
	<jsp:include page="../common/footer.jsp"/>
</html>