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
  	}
  	  //selectAll 함수 끝
		selectAll();
     });//ready끝
</script>
</head>
<body>
<section id="goodsInsert">

	<div class="GoodsInsert">
		<h2 class="heading">상품등록</h2>
	</div>
	
	<div class="goodsInsert">
				<div class="row">
					<div class="col-sm-3">
						<div class="shopper-info">
							<form name="goodsForm" method="post" id="goodsForm">
								<input type="text" name="goodsCode" id="goodsCode" placeholder="상품코드">
								<select name="goodsType" id="goodsType">
										<option>-- 상품타입 --</option>
										<option value="O">원두</option>
										<option value="D">드립백</option>
										<option value="C">캡슐</option>
								</select>
								<input type="text" name="goodsName" id="goodsName" placeholder="상품명">
								<input type="text" name="goodsPrice" id="goodsPrice" placeholder="상품가격">
								<input type="text" name="goodsStock" id="goodsStock" placeholder="상품수량">
								<select name="isSoldout" id="isSoldout">
										<option>-- 품절여부 --</option>
										<option value="0">품절</option>
										<option value="1">판매중</option>
										<option value="2">판매중지</option> <!-- 삭제 할 때. -->
								</select>
								상품이미지(**간격 조정하기)
								<input type="file" name="goodsImg" id="goodsImg" placeholder="상품이미지">
							</form>
						</div>
					</div>
					
					<div class="col-sm-4">
						<div class="goods_detail">
							<textarea name="goodsDetail" id="goodsDetail" placeholder="상품설명" rows="15"></textarea>
						</div>	
					</div>
					
					<div class="col-sm-5">
							<input type="hidden" name="key" value="ajaxGoods">
							<input type="hidden" name="methodName" value="insert">
							<input type="button" value="등록"  id="btn">
							<input type="reset" value="지우기"  id="reset">
				    </div>						
				</div>
			</div>
		</section>

	<section id="goodsView">
	<div class="GoodsView">
		<h2 class="heading">상품조회</h2>
	</div>

	<div class="goodsListTable" cellspacing="0">
		<table class="Goodstable">
				<tr class="goods_menu">
					<td class="goodsCode">상품코드</td>
					<td class="goodsType">상품타입</td>
					<td class="goodsName">상품명</td>
					<td class="goodsPrice">상품가격</td>
					<td class="goodsStock">상품재고</td>
					<td class="isSoldout">품절여부</td>
				</tr>
		</table>
	</div>
	</section>

</body>
	<jsp:include page="common/footer.jsp"/>
</html>