<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js" ></script>
		<style type="text/css">
			table{margin-right: auto; margin-left: auto; align-content: center;}
			form{text-align: center; width: 850px; float: right;}
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
					}else{
						return true;
					}
				});
			});
		</script> 
		
		
		<style type="text/css">
			@font-face {
		    font-family: 'GmarketSansBold';
		    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansBold.woff') format('woff');
		    font-weight: normal;
		    font-style: normal;
		}
		
			@font-face {
		    font-family: 'KOTRAHOPE';
		    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2110@1.0/KOTRAHOPE.woff2') format('woff2');
		    font-weight: normal;
		    font-style: normal;
		}
			
			h1, body {
				text-align: center;
				color: #3D3D3D;
				font-family: GmarketSansBold;
			}
			
			h4 {
				font-family: KOTRAHOPE;
				color: #F58B00;
			}	
			
			h2 { 
				text-align: center;
				color: #B45F04;
				font-family: GmarketSansBold;
			}
			
			</style>

	</head>
	<body>
		
		<section>
			<div class="container">
				<div class="row">
				<jsp:include page="../common/category.jsp"/>
				<!-- 상품 페이지 추가-->
					<hr>
					<h2><i class="fa fa-coffee" aria-hidden="true"></i><br></h2>
					<h1>나만의 원두 찾기</h1>
					<hr>
					<form action="${path}/front">
						<input type=hidden name="methodName" value="survey">
						<input type=hidden name="key" value="survey">
						<h4>산뜻함이 느껴지면서 감귤류 등의 신맛을 좋아하시나요?</h4>
						<table>
							<tr>
								<td rowspan="2">
								<i class="fa fa-frown-o" aria-hidden="true"></i>&nbsp;
									싫어함&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<th>
									<input type="radio" name="sour" value="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="sour" value="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="sour" value="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="sour" value="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="sour" value="5">
								</th>
								<td rowspan="2">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;좋아함
									&nbsp;<i class="fa fa-smile-o" aria-hidden="true"></i>
								</td>
							</tr>
							<tr>
								<th>1</th>
								<th>2</th>
								<th>3</th>
								<th>4</th>
								<th>5</th>
							</tr>
						</table><br><br><br>
						<h4>불향이 나거나 쌉쌉한맛을 좋아하나요?</h4>
						<table>
							<tr>
								<td rowspan="2">
								<i class="fa fa-frown-o" aria-hidden="true"></i>&nbsp;
									싫어함&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<th>
									<input type="radio" name="body" value="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="body" value="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="body" value="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="body" value="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="body" value="5">
								</th>
								<td rowspan="2">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;좋아함
									&nbsp;<i class="fa fa-smile-o" aria-hidden="true"></i>
								</td>
							</tr>
							<tr>
								<th>1</th>
								<th>2</th>
								<th>3</th>
								<th>4</th>
								<th>5</th>
							</tr>
						</table><br><br><br>
						<h4>다소 단맛이 나는 것을 좋아하나요?</h4>
						<table>
							<tr>
								<td rowspan="2">
								<i class="fa fa-frown-o" aria-hidden="true"></i>&nbsp;
									싫어함&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<th>
									<input type="radio" name="sweet" value="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="sweet" value="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="sweet" value="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="sweet" value="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="sweet" value="5">
								</th>
								<td rowspan="2">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;좋아함
									&nbsp;<i class="fa fa-smile-o" aria-hidden="true"></i>
								</td>
							</tr>
							<tr>
								<th>1</th>
								<th>2</th>
								<th>3</th>
								<th>4</th>
								<th>5</th>
							</tr>
						</table><br><br><br>
						<h4>과일향, 허브향, 견과향 이러한 향들을 좋아하시나요?</h4>
						<table>
							<tr>
								<td rowspan="2">
								<i class="fa fa-frown-o" aria-hidden="true"></i>&nbsp;
									싫어함&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<th>
									<input type="radio" name="aroma" value="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="aroma" value="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="aroma" value="3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="aroma" value="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<th>
									<input type="radio" name="aroma" value="5">
								</th>
								<td rowspan="2">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;좋아함
									&nbsp;<i class="fa fa-smile-o" aria-hidden="true"></i>
								</td>
							</tr>
							<tr>
								<th>1</th>
								<th>2</th>
								<th>3</th>
								<th>4</th>
								<th>5</th>
							</tr>
						</table><br>
						<input type="submit" value="확인하기" class="btn btn-default"><br><br><br><br>
					</form>
				</div>
			</div>
		</section> 
	</body>
	<jsp:include page="../common/footer.jsp"/>
</html>