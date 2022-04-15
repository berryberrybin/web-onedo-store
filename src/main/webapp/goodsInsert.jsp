<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Insert title here</title>
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
</div>

</form>
</body>
</html>