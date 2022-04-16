<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>ONE DO</title>
<link href="${path}/css/bootstrap.min.css" rel="stylesheet">
<link href="${path}/css/font-awesome.min.css" rel="stylesheet">
<link href="${path}/css/prettyPhoto.css" rel="stylesheet">
<link href="${path}/css/price-range.css" rel="stylesheet">
<link href="${path}/css/animate.css" rel="stylesheet">
<link href="${path}/css/main.css" rel="stylesheet">
<link href="${path}/css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="${path}images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="${path}/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${path}/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="${path}/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="${path}/images/ico/apple-touch-icon-57-precomposed.png">

<style>
td {
	text-align: center;
}

#itemAmount{
	text-align:center;
}
</style>
</head>
<body>

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li class="active">Shopping Cart</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">상품이미지</td>
							<td class="code">상품코드</td>
							<td class="name">상품이름</td>
							<td class="price">가격</td>
							<td class="quantity">수량</td>
							<td class="total">합계</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty requestScope.cartItemList}">
								<tr>
									<td colspan="5">
										<p align="center">
											<b><span style="font-size: 9pt;">등록된 상품이 없습니다.</span></b>
										</p>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${requestScope.cartItemList}" var="cartItem">
									<tr>
										<td class="itemImage">
											<a href=""><img src="${path}/img/${cartItem.goods.goodsImg}" width="100" alt=""></a>
										</td>
										<td class="itemCode">
											<h4>
												<a href="">${cartItem.goods.goodsCode}</a>
											</h4>
										</td>
										<td class="itemName">
											<h4>
												<a href="">${cartItem.goods.goodsName}</a>
											</h4>
										</td>


										<td class="itemPrice">
											<h4>
												<p>${cartItem.goods.goodsPrice}</p>
											</h4>
										</td>

										<td class="cart_quantity">
											<div class="cart_quantity_button"	id="itemAmount">
												<a class="cart_quantity_up" id="itemAmountUp" href="front?key=cart&methodName=increaseAmount&userId=soobin&goodsCode=${cartItem.goods.goodsCode}"> + </a> 
												<input class="cart_quantity_input" type="text" name="quantity" value="${cartItem.amount}" autocomplete="off" size="2"> 
												<a class="cart_quantity_down" href="front?key=cart&methodName=decreaseAmount&userId=soobin&goodsCode=${cartItem.goods.goodsCode}"> - </a>
											</div>
										</td>
										<td class="cart_total">
											<p class="cart_total_price">${cartItem.totalPrice}</p>
										</td>
										<td class="cart_delete">
											<a class="cart_quantity_delete" href="front?key=cart&methodName=delete&userId=soobin&goodsCode=${cartItem.goods.goodsCode}"><i class="fa fa-times"></i></a>
										</td>
									</tr>
								</c:forEach>

							</c:otherwise>
						</c:choose>

					</tbody>
				</table>
			</div>
		</div>
	</section>
	<!--/#cart_items-->

	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>배송비 및 총 결제 금액</h3>
				<p>  배송비는 50,000원 이상 주문시 무료입니다.</p>
			</div>

			<div class="col-sm-6">
				<div class="total_area">
					<ul>
						<li>총 상품 가격 <span>${totalItemPrice}</span></li>
						<li>배송비 <span>${deliveryPrice}</span></li>
						<li>총 결제 예상 금액 <span>${paymentPrice}</span></li>
					</ul>
					<a class="btn btn-default update" href="">장바구니 비우기</a> 
					<a class="btn btn-default check_out" href="">결제하기</a>
				</div>
			</div>
		</div>
		</div>
	</section>
	<!--/#do_action-->

</body>
<jsp:include page="common/footer.jsp" />
</html>