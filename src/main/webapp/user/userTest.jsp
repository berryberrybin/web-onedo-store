<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
		<script type="text/javascript">
			$(function(){ 
				function selectAll() {	
					$.ajax({
						url :"${path}/ajax" ,
						type :"post", 
						dataType :"json"  , 
						data : {key:"ajaxGoods", methodName:"selectAll"},
						success :function(result){
							//alert(1);
							let str ="";
							$.each(result, function(index, item) {
								str+="<tr>";
								str+=`<td><a href="#">${item.goodsCode}</a></td>`;
								str+=`<td>${item.goodsType}</td>`;
								str+=`<td>${item.goodsName}</td>`;
								str+=`<td>${item.goodsPrice}</td>`;
								str+=`<td>${item.goodsStock}</td>`;
								str+=`<td>${item.goodsDetail}</td>`;
								str+=`<td>${item.isSoldout}</td>`;
								str+=`<td>${item.goodsView}</td>`;
								str+=`<td>${item.goodsImg}</td>`;
								str+=`<td><input type='button' value='삭제'></td>`;
								str+="</tr>";
							});
						},
						error : function(err){  
							alert(err+"에러 발생했습니다.");
						} 
					}) //ajax
				}//selectAll 함수 끝
				
				selectAll();
			});//ready끝
		</script>
	</head>
	<body>

	</body>
</html>