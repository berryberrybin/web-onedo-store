<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
	<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
    <style>
		 .a{border:solid red 5px}
		 input{border:solid gray 1px}
		 table{width:100%}
		 th,td{border:1px gray solid; text-align:center;padding:3px}
		 h2{text-align:left;}
		 a{text-decoration: none;}
		 a:hover {color: red}
	</style>
    <script type="text/javascript">
    $(function(){ 
  	  /**
  	  전체 검색
  	  */
  	  function selectAll() {
  		  $.ajax({
  	   			url :"${path}/ajax" ,
  	   			type:"post", 
  	   			dataType:"json"  , 
  	   			data: {key:"ajaxGoods", methodName:"selectAll"},
  	   			success :function(result){
  	   				alert(result);
  	   				}
  	   		}) //ajax
  	}
  	  //selectAll 함수 끝
		selectAll();
     });//ready끝
</script>
</head>
<body>
</body>
	<jsp:include page="common/footer.jsp"/>
</html>