<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Insert title here</title>
	 <script type="text/javascript">
	
   /*
	상품 등록하기&수정하기
	상품코드- 알아서 출력 readonly
	*/
	 $("#btn").click(function() {
		let state=true;
		
		$("input[type=text]").each(function(index, item) { //item은 input element이다.
			if($(this).val()==""){
				alert("값을 입력해 주세요.");
				$(this).focus(); //커서놓기
				
				state = false;
				return false; //return false의 의미 : each 함수를 빠져나가라.
			}
		});
		
		if(state){
			if($(this).val=="상품수정"){
				$("[name=methodName]").val("update");
				
				//버튼글씨 가입하기 변경, span보이기, readonly속성제거
				$("#btn").val("상품등록");
				$("span").show();
				$("#id").removeAttr("readonly");
			}
			
			$.ajax({ //상품등록할때
	   			url :"../ajax" , //서버요청주소
	   			type:"post", //요청방식(method방식 : get | post | put | delete )
	   			dataType:"text"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
	   			data: $("#inForm").serialize(), //서버에게 보낼 데이터정보(parameter정보)
	   			success :function(result){
	   				if(result==0){
	   					alert("실패하였습니다");
	   				}else{
	   					//text내용 지우고 화면 갱신
	   					$("input[type=text]").val("");
	   					selectAll();
	   					$("[name=methodName]").val("insert");
	   				}
	   			
	   			} , //성공했을때 실행할 함수 
	   			error : function(err){  
	   				alert(err+"에러 발생");
	   			}  //실패했을때 실행할 함수 
	   		}); //ajax끝
		}//if(state)끝
		
	});//click이벤트 끝
	</script>
</head>
<body>
<form role="form" method="post" autocomplete="off">

<div class="inputArea">
 <label for="goodsCode">상품코드</label>
 <input type="text" id="goodsCode" name="goodsCode" />
</div>

<div class="inputArea"> 
 <label>상품타입</label>
 <select class="category1">
  <option value="">원두</option>
  <option value="">드립백</option>
  <option value="">캡슐</option>
 </select>
</div>

<div class="inputArea">
 <label for="goodsName">상품명</label>
 <input type="text" id="goodsName" name="goodsName" />
</div>

<div class="inputArea">
 <label for="goodsPrice">상품가격</label>
 <input type="text" id="goodsPrice" name="goodsPrice" />
</div>

<div class="inputArea">
 <label for="goodsStock">상품수량</label>
 <input type="text" id="goodsStock" name="goodsStock" />
</div>

<div class="inputArea">
 <label for="goodsDetail">상품소개</label>
 <textarea rows="5" cols="50" id="goodsDetail" name="goodsDetail"></textarea>
</div>

<div class="inputArea"> 
 <label>품절여부</label>
 <select class="category1">
  <option value="">판매중</option>
  <option value="">품절</option>
 </select>
</div>

<div class="inputArea">
 <label for="goodsImg">상품이미지</label>
 <textarea rows="1" cols="20" id="goodsImg" name="goodsImg"></textarea>
</div>

<div class="inputArea">
 <button type="submit" id="register_Btn" class="btn btn-primary">등록</button>
 <input type="button" value="상품등록"  id="btn">
</div>

</form>
</body>
</html>