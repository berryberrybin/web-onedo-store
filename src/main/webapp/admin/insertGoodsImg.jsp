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
		$("#insert").click(function() {
			 $("#upLoadForm").ajaxForm({
				   url: "${path}/upLoadServlet" , 
		      		type: "post", 
		      		dataType: "json" ,
		      		success: function(result){//중복, 사용가능
		      			alert(result +"성공");
		      		  var str="";
		      		  $.each(result, function(index, item){
		      			str+="filesystemName : " + item.filesystemName+"<br>";
		      			str+="path : " + item.path+"<br>";  
		      			
		      		  });
		      		  
		      		  $("div").html(str);
		      		} ,
		      		error: function(err){
		      			alert(err+" 예외가 발생했습니다.");
		      		}
			   });
			   
			   $("#insertGoodsImgForm").submit(); //전송
		});
	});
</script>
	
</head>

<body>
<h2>상품이미지 등록</h2>
	<form method="post"  enctype="multipart/form-data" id="insertGoodsImgForm">
		<table>
			<tr>
				<td>상품코드</td>
				<td><input type="text"  name="goodsCode" disabled="disabled"></td>
			</tr>
	
			<tr>
				<td>파일첨부</td>
				<td><input type="file" name="goodsImg" id="goodsImg"></td>
			</tr>
			<tr><td colspan="2"><input type="button" id="insertGoodsImg" value="등록"></td></tr>
			
		</table>
	</form>
	<br><br><br><br>
<jsp:include page="../common/adminfooter.jsp" />
</body>
</html>