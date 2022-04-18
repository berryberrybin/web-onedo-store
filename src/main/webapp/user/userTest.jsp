<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
		<style type="text/css">
			table{
				text-align: center;
			}
		</style>
		<script type="text/javascript">
			$(function(){ 
				/**
					전체회원 조회
				*/
				function selectAll() {	
					$.ajax({
						url :"${path}/ajax" ,
						type :"post", 
						dataType :"json"  , 
						data : {key:"ajaxUser", methodName:"selectAll"},
						success :function(result){
							let str ="";
							$.each(result, function(index, item) {
								str+="<tr>";
								str+="<td>" + item.userId + "</td>";
								str+=`<td>${'${item.userName}'}</td>`;
								str+=`<td>${'${item.userPhone}'}</td>`;
								str+=`<td>${'${item.userAddr}'}</td>`;
								str+=`<td>${'${item.birth}'}</td>`;
								if(item.gender==("m")){
									str+=`<td>남자</td>`;
								}else{
									str+=`<td>여자</td>`;
								}
								if(item.userType==1){
									str+=`<td>정상</td>`;
								}else{
									str+=`<td>정지</td>`;
								}
								if(item.userType==1){
									str+=`<td><input type='button' value='정지' name='${"${item.userId}"}'></td>`;
								}else{
									str+=`<td><input type='button' value='해제' name='${"${item.userId}"}'></td>`;
								}
								str+="</tr>";
								
								$("#uu tr:gt(0)").remove();
								$("#uu tr:eq(0)").after(str);
							});
						},
						error : function(err){  
							alert(err+"에러 발생했습니다.");
						} 
					}); 
				}
				
				/*
					유저타입 변경하기(정지, 해제)
				*/
				$(document).on("click", "[type=button]", function() {
					if($(this).attr("value")=='정지'){
						var delConfirm = confirm($(this).attr("name") + ' 계정이 정지됩니다.');
					}else{
						var delConfirm = confirm($(this).attr("name") + ' 계정이 해제됩니다.');
					}
					
					if (delConfirm) {
						$.ajax({
				   			url :"../ajax" ,
				   			type:"post", 
				   			dataType:"text"  ,
				   			data: {key : "ajaxUser", methodName : "typeUpdate", id : $(this).attr("name"), type : $(this).attr("value")} , 
				   			success :function(result){
								if(result==0){
									alert("변경되지않았습니다.");
								}else{
									selectAll();
								}
				   			} , 
				   			error : function(err){  
				   				alert(err+"에러 발생했어요.");
				   			}  
				   		});
					}else {
						alert('정지가 취소되었습니다.');
					}
					
				});
				
				selectAll();
			});
		</script>
	</head>
	<body>
		<table id="uu">
			<tr>
				<th>아이디</th><th>이름</th><th>연락처</th><th>주소</th><th>생년월일</th><th>성별</th><th>계정정보</th>
			</tr>
		</table>
	</body>
</html>