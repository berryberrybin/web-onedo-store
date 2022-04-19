<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../common/adminheader.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>

<style>
	.a {border: solid red 5px}
	table {width: 100%}
	th, td {border: 1px gray solid;text-align: center;padding: 3px}
	h2 {text-align: left;}
	a {text-decoration: none;}
	a:hover {color: red}
	textarea{width:100px; height:100px; float: right;}
	input, select{
		border: solid gray 1px
		width: 250px;
	}
	form{
		width: 250px;
	}
	.col-sm-5 clearfix{
		position: absolute;
		float: right;
	}
	#inForm{width: 100%}
	
</style>
<script type="text/javascript">
	$(function() {
		
		//전체검색
		function selectAll() {
			$.ajax({
				url : "${path}/ajax",
				type : "post",
				dataType : "json",
				data : {key : "ajaxGoods", methodName : "selectAll"},
				success : function(result) {
					let str = "";
					$.each(result, function(index, item) {
						str += "<tr>";
						str += "<td><a href='#'>" + item.goodsCode + "</a></td>";
						str += "<td>" + item.goodsType + "</td>";
						str += "<td>" + item.goodsName + "</td>";
						str += "<td>" + item.goodsPrice + "</td>";
						str += "<td>" + item.goodsStock + "</td>";
						str += "<td><span>" + item.isSoldout +"</span><span style='display:none'>"+item.goodsDetail+"</span></td>";
						str += `<td><input type='button' value='이미지넣기'></td>`;
						str += `<td><input type='button' value='삭제' name='${'${item.goodsCode}'}'></td>`;
						str += "</tr>";
					});
					$("#goodstable tr:gt(0)").remove();
					$("#goodstable tr:eq(0)").after(str);

				},
				error : function(err) {
					alert(err + "에러 발생했습니다.");
				}
			}); //ajax
		}//selectAll 함수 끝

		/**
		상품 등록 + 수정
		 */
		$("#btn").click(function() {
			let state = true; 
				
			$("input[type=text], [type=select]").each(function(index, item) { 
				if($(this).val()==""){
					alert("값을 입력해 주세요.");
					$(this).focus();
	
					state = false;
					return false;
				}
			});
		
			
			if (state) {
				 if ($(this).val == "수정") {
					$("[name=methodName]").val("insert");  //수정이지만, insert메소드로
				
					//버튼글씨 '등록' 변경,  readonly속성제거
					$("#btn").val("등록");
					
				}  

				 $.ajax({  //등록
					url : "${path}/ajax",
					type : "post", 
					dataType : "text", 
					data : $("#inForm").serialize(),
					success : function(result) {
						if (result == 0) {
							alert("실패하였습니다!"); //
						} else {
						  
							//text내용 지우고 화면 갱신
							alert("등록성공하였습니다!"); 
							$("input[type=text] ,[type=select], [type=number]").val("");
							$("#goodsDetail").val("");
							selectAll();
							$("[name=methodName]").val("insert"); //등록이라 insert메소드
						}

					}, 
					error : function(err) {
						alert(err + "에러 발생했습니다.");
					}
					}); //ajax끝
				}//if(state)끝
		
		});//click이벤트 끝
		
		
		//상품코드를 클릭했을 때 이벤트 처리
		$(document).on("click", "#goodstable > tbody > tr > td:nth-child(1) > a", function() {
			
			//text박스에 값넣기
			let goodsCode = $(this).parent().next(); 
			let goodsName = goodsCode.next();
			let goodsPrice = goodsName.next();
			let goodsStock = goodsPrice.next();
			let isSoldout = goodsStock.next(); 
			let goodsType = isSoldout.next();
			let goodsDetail  = goodsType.next();
			
			//상품코드 저장하기 
			$("#goodsCode").val($(this).text());
			$("#goodsType").val($(this).parent().next().text());
			$("#goodsName").val(goodsName.text());
			$("#goodsPrice").val(goodsPrice.text());
			$("#goodsStock").val(goodsStock.text());
			$("#isSoldout").val(isSoldout.find("span:first").text());
			$("#goodsDetail").text(isSoldout.find("span:last").text());
			
			$("#goodsCode").attr("readonly", "readonly");
			$("#btn").val("수정");
			
			$("h2").text("상품수정");
		});
		

		//삭제하기 : 데이터에선X 품절상태를 판매중지로 바꾸기
		$(document).on("click", "[value=삭제]", function() {
			 $.ajax({
	   			url :"${path}/ajax", 
	   			type:"post", 
	   			dataType:"text", 
	   			data: {key:"ajaxGoods", methodName:"delete", goodsCode : $(this).attr("name") }, //서버에게 보낼 데이터정보(parameter정보)
	   			success :function(result){
	   				selectAll();
	   			} ,
	   			error : function(err){  
	   				alert(err+"에러 발생했어요.");
	   			}  
	   		}); //ajax끝
	   		
		});

		selectAll();
	});//ready끝
</script>
</head>
<body>

	<section id="cart_items">
		<div class="container">

				<h2>상품등록</h2>
			
			
			<form name="inForm" method="post" id="inForm">
				<table cellspacing="0">
					<tr>
						<td colspan="2"><input type="text" size="50" name="goodsName" id="goodsName" placeholder="상품이름"></td>
		
					</tr>
					<tr>
					    <td>
							<select name="goodsType" id="goodsType">
								<option value="">-- 상품타입 --</option>
								<option value="O">원두</option>
								<option value="D">드립백</option>
								<option value="C">캡슐</option>
							</select><br><br>
						</td>
						<td><input type="number" size="50" name="goodsPrice" id="goodsPrice" placeholder="상품가격"></td>
					</tr>
					<tr>
					    <td>
							<select name="isSoldout" id="isSoldout">
								<option value="">-- 품절여부 --</option>
								<option value="0">판매중</option>
								<option value="1">품절</option>
								<option value="2">판매중지</option>
							</select>
						</td>
						<td><input type="number" size="50" name="goodsStock" id="goodsStock" placeholder="상품수량"></td>
					</tr>
					<tr>
						<td colspan="2"><textarea name="goodsDetail" id="goodsDetail" placeholder="상품설명"></textarea></td>
						
					</tr>
					<tr>
						<td colspan="2" align="center"> 
						     <input type="hidden"  name="goodsCode" id="goodsCode" >
							<input type="hidden" name="key" value="ajaxGoods">
							<input type="hidden" name="methodName" value="insert">
							<input type="button" value="등록"  id="btn">
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<br><br><hr><br>
		
		
				<table class="table" id="goodstable">
					<tr class="goods_menu">
						<td class="goodsCode">상품코드</td>
						<td class="goodsType">상품타입</td>
						<td class="goodsName">상품명</td>
						<td class="goodsPrice">상품가격</td>
						<td class="goodsStock">상품재고</td>
						<td class="isSoldout">품절여부</td>
						<td class="addImg">이미지추가</td>
						<td class="isSoldout">삭제</td>
					</tr>
				</table>
			
			
		
	</section> <!--/#cart_items-->

	

	
	


   <jsp:include page="../common/adminfooter.jsp" />
</body>
</html>