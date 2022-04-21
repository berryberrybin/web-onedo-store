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
	h2 {text-align: left;}
	a {text-decoration: none;}
	a:hover {color: red}

	table{
		width: 100%; 
		border-top: 1px solid #555555; 
		border-collspse: collapse; text-align: center;
	}
	
	th {
		border-left: none; 
		padding: 10px;
		text-align: center;
	}
			
	td {
		border-bottom: 1px solid  #555555 ;
		border-left: none; 
		padding: 10px;
		text-align: center;
		background-color: white;
	}
	
	/* table th: first-child, td:first-child{border-left: none;} */
	
	input[type="text"],[type="number"]{
		width:100%;
		height:50px;
		border: none;
		text-align: center;
		background-color: white; 
		box-sizing: content-box;
		font-size: 20px;
	}
	textarea{
		width:100px; 
		height:50px;
		border: none;
		text-align: center;
		background-color: white;
	}
	select{
		width:100px; 
		border: none;
		text-align: center;
		padding: 5px;
		background: transparent;
		font-size: 20px; 
	}
	input[type="button"]{
		border: none;
		text-align: center;
		background: transparent; 
	}
	
	#btn{
	    width:30%;
	    height:30px;
		border: 1px solid;
		text-align: center;
		background-color: #c0b9b0;
		font-size: 20px;
	}
	

	
	
</style>
<script type="text/javascript">
	$(function() {
		
		//전체검색
		function selectAll() {
			$.ajax({
				url : "${path}/ajax",
				type : "post",
				dataType : "json",
				data : {key : "ajaxGoods", methodName : "selectAll" },
				success : function(result) {
					let str = "";
					$.each(result, function(index, item) {
						str += "<tr>";
						str += "<td><a href='#'>" + item.goodsCode +"</a>" ;
						str += "<input type='hidden' name='attrInfo' value='"+ item.goodsAttrDTO.sour+","+ item.goodsAttrDTO.sweet+","+item.goodsAttrDTO.aroma+","+item.goodsAttrDTO.body+"'>"; 
						str += "</td>";
						str += "<td>" + item.goodsType + "</td>";
						str += "<td>" + item.goodsName + "</td>";
						str += "<td>" + item.goodsPrice + "</td>";
						str += "<td>" + item.goodsStock + "</td>";
						str += "<td><span>" + item.isSoldout +"</span><span style='display:none'>"+item.goodsDetail+"</span></td>";
						if(item.goodsImg==""){
							str += `<td><input type='button' value='첨부' onclick='location.href="${path}/admin/insertGoodsImg.jsp?name=${'${item.goodsCode}'}"'></td>`;
						}else{
							str += `<td>${'${item.goodsImg}'}</td>`;
						}
						str += `<td><input type='button' value='삭제' name='${'${item.goodsCode}'}'></td>`;
						str += "</tr>";
						
						console.log(item.goodsAttrDTO.sour);
					});
					$("#goodstable tr:gt(0)").remove();
					$("#goodstable tr:eq(0)").after(str);
					
					/*"#inForm" 에 등록된 sour, sweet, aroma, body 값 가져오기
					방법 1 - <span>태그로 숨기기 (시도했는데 안돌아감.. 상세 설명까지 안보여짐.)
									<span style='display:none'>"+item.sour+"</span>
					방법 2 -"+ item.goodsAttrDTO.sour+","+ item.goodsAttrDTO.sweet+","+item.goodsAttrDTO.aroma+","+item.goodsAttrDTO.body+"
					
					*/
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
					alert("값을 빠짐없이 입력해 주세요.");
					$(this).focus();
	
					state = false;
					return false;
				}
			});
			
			if (state) {
				 if ($(this).val == "수정") {
					$("[name=methodName]").val("update");
					$("#btn").val("등록");
				}  

				 $.ajax({  //등록
					url : "${path}/ajax",
					type : "post", 
					dataType : "text", 
					data : $("#inForm").serialize(),
					success : function(result) {
						if (result == 0) {
							alert("상품 등록을 실패하였습니다.");
						} else {
						  
							//text내용 지우고 화면 갱신
							alert("상품 등록을 완료하였습니다."); 
							$("input[type=text], [type=number]").val("");
							$("#goodsType").val("");
							$("#isSoldout").val("");
							$("#goodsDetail").val("");
							$("#sour").val("");
							$("#sweet").val("");
							$("#aroma").val("");
							$("#body").val("");
							selectAll();
							$("#btn").val("등록");
							$("[name=methodName]").val("insert");
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
			
			//attrInfo가져오기 
		    let attrV = $(this).next().val();
		    let v = attrV.split(",");
			$("#sour").val(v[0]);
			$("#sweet").val(v[1]);
			$("#aroma").val(v[2]);
			$("#body").val(v[3]);
			
			/////////////////////////////////////
			
			//text박스에 값넣기
			let goodsCode = $(this).parent().next(); 
			let goodsName = goodsCode.next();
			let goodsPrice = goodsName.next();
			let goodsStock = goodsPrice.next();
			let isSoldout = goodsStock.next(); 
			let goodsType = isSoldout.next();
			let goodsDetail  = goodsType.next();
			
			let sour = goodsDetail.next();
			let sweet = sour.next();
			let aroma = sweet.next();
			let body = aroma.next();
			
			//상품코드 저장하기 
			$("#goodsCode").val($(this).parent().text());
			$("#goodsType").val($(this).parent().next().text());
			$("#goodsName").val(goodsName.text());
			$("#goodsPrice").val(goodsPrice.text());
			$("#goodsStock").val(goodsStock.text());
			$("#isSoldout").val(isSoldout.find("span:first").text());
			$("#goodsDetail").text(isSoldout.find("span:last").text());
			
			
			$("#goodsCode").attr("readonly", "readonly");
			$("#btn").val("수정");
			$("h2").text("상품수정");
			$("[name=methodName]").val("update");
			
			
		});
		

		//삭제하기 : 데이터에선X 품절상태를 판매중지로 바꾸기
		$(document).on("click", "[value=삭제]", function() {
			 $.ajax({
	   			url :"${path}/ajax", 
	   			type:"post", 
	   			dataType:"text", 
	   			data: {key:"ajaxGoods", methodName:"delete", goodsCode : $(this).attr("name") }, //서버에게 보낼 데이터정보(parameter정보)
	   			success :function(result){
	   				alert("상품 삭제 완료되었습니다.");
	   				selectAll();
	   			} ,
	   			error : function(err){  
	   				alert(err+"에러가 발생했습니다.");
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
				<table id=insertTable>
					<tr>
						<td colspan="4"><input type="text" name="goodsName" id="goodsName" placeholder="상품이름"></td>
					</tr>
					<tr>
					    <td colspan="2">
							<select name="goodsType" id="goodsType" style="font-size: 20px; background-color: white;">
								<option value="">상품타입</option>
								<option value="O">원두</option>
								<option value="D">드립백</option>
								<option value="C">캡슐</option>
							</select>
						</td>
						<td colspan="2"><input type="number" name="goodsPrice" id="goodsPrice" placeholder="상품가격"></td>
					</tr>
					<tr>
					    <td colspan="2">
							<select name="isSoldout" id="isSoldout" style="font-size: 20px; background-color: white;">
								<option value="">품절여부</option>
								<option value="0">판매중</option>
								<option value="1">품절</option>
								<option value="2">판매중지</option>
							</select>
						</td>
						<td colspan="2"><input type="number" name="goodsStock" id="goodsStock" placeholder="상품수량"></td>
					</tr>
					<tr>
						<td colspan="4"><textarea name="goodsDetail" id="goodsDetail" style="font-size: 20px; background-color: white;" placeholder="상품설명"></textarea></td>
					</tr>
					<tr>
						<td>
							<select name="sour" id="sour" style="font-size: 20px; background-color: white;">
								<option value="">신맛</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</td>
						<td>
							<select name="sweet" id="sweet" style="font-size: 20px; background-color: white;">
								<option value="">단맛</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</td>
						<td>
							<select name="aroma" id="aroma" style="font-size: 20px; background-color: white;">
								<option value="">아로마</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</td>
						<td>
							<select name="body" id="body" style="font-size: 20px; background-color: white;">
								<option value="">바디감</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="4" align="center"> 
						     <input type="hidden"  name="goodsCode" id="goodsCode" >
							<input type="hidden" name="key" value="ajaxGoods">
							<input type="hidden" name="methodName" value="insert">
							<input type="button" value="등록"  id="btn">
							
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<br><hr><br>
		
		
				<table class="table" id="goodstable">
					<tr class="goods_menu">
						<td class="goodsCode">상품코드</td>
						<td class="goodsType">상품타입</td>
						<td class="goodsName">상품명</td>
						<td class="goodsPrice">상품가격</td>
						<td class="goodsStock">상품재고</td>
						<td class="isSoldout">품절여부</td>
						<td class="addImg">이미지</td>
						<td class="isSoldout">삭제</td>
					</tr>
					
				</table>
			
			
		
	</section>

	

	
	


   <jsp:include page="../common/adminfooter.jsp" />
</body>
</html>