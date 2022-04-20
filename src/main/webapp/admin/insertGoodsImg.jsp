<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="../common/adminheader.jsp" />
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
	
	<style type="text/css">
	
  table {
    width: 50%;
    border-top: 1px solid ;
    border-collapse: collapse;
  }
  td {
  	width: 100px;
  	height: 50px;
    border-bottom: 1px solid ;
    border-left: 1px solid ;
    padding: 10px;
    text-align: center;
  }
  th:first-child, td:first-child {
    border-left: none;
  }
  input[type="text"]{
	text-align: center;
	background: transparent;
	border:none;
	border-right:0px; 
	border-top:0px; 
	boder-left:0px; 
	boder-bottom:0px;

  }
  #insert{
  	width: 50px;
  	height: 30px;
  }
</style>
<script type="text/javascript">
	$(function() {
		alert(${item.goodsCode});
		$(document).on("click",function(){
			let goodsCode = $(this).attr("name");
			
		})
	});
</script>
	
</head>

<body>
<h2>상품이미지 등록</h2>
	<form method="post"  enctype="multipart/form-data" id="insertGoodsImgForm"
		action="${path}/front?key=goods&methodName=insertGoodsImg"> <!-- request로 받으려고 get방식으로 따로 보내기 -->
		<table>
			<tr>
				<td>상품코드</td>
				<td><input type="text"  name="goodsCode" disabled="disabled" value="${item.goodsCode}" ></td>
			</tr>
	
			<tr>
				<td>파일첨부</td>
				<td><input type="file" name="goodsImg" id="goodsImg" placeholder="파일첨부"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" id="insertGoodsImg" value="등록">
				</td>
			</tr>
			
		</table>
	</form>
	<br><br><br><br>
	<div><a href="${path}/admin/adminGoods.jsp">상품조회로 돌아가기</a></div>
<jsp:include page="../common/adminfooter.jsp" />
</body>
</html>