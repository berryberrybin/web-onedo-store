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
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/font-awesome.min.css" rel="stylesheet">
<link href="./css/prettyPhoto.css" rel="stylesheet">
<link href="./css/price-range.css" rel="stylesheet">
<link href="./css/animate.css" rel="stylesheet">
<link href="./css/main.css" rel="stylesheet">
<link href="./css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
		<!-- jQuery --> 
	    <script type="text/javascript" src="js/jquery-3.6.0.min.js" ></script> 
		<!-- iamport.payment.js --> 
	    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	    <script type="text/javascript">

		    $(document).ready(function(){ 
				$("#iamportPayment").click(function(){ 
					iamport(); //버튼 클릭하면 호출 
					
			    }); 
			})
	
	
			function iamport(){//결재하기 클랙했을때
		    	uid = new Date().getTime();
				//가맹점 식별코드
				IMP.init('imp81895788');
				IMP.request_pay({
				    pg : 'kcp',
				    pay_method : 'card',
				    merchant_uid : uid ,
				    name : $("#payGoodsName").val() , //결제창에서 보여질 이름
				    amount : ${paymentPrice}, //실제 결제되는 가격
				    buyer_email : '${userId}',
				    buyer_name : '${userName}',
				    buyer_tel : ${userPhone},
				    buyer_addr : '${userAddr}',
				    buyer_postcode : '123-456'
				}, function(rsp) {
					console.log(rsp);
				    if ( rsp.success ) {
				    	var msg = '결제가 완료되었습니다.';
				        msg += '고유ID : ' + rsp.imp_uid;
				        msg += '상점 거래ID : ' + rsp.merchant_uid;
				        msg += '결제 금액 : ' + rsp.paid_amount;
				        msg += '카드 승인번호 : ' + rsp.apply_num;
				        
				        //이동(값들가지고- )
				        
				        
				       // $("#payForm").submit();//이동
				        
				    } else {
				    	 //var msg = '결제에 실패하였습니다.';
				        // msg += '에러내용 : ' + rsp.error_msg;
				         $("#payForm #key").val("order");
					     $("#payForm #methodName").val("orders");
					     $("#payForm #orderCode").val(uid);
				         $("#payForm").submit();
				    }
				    alert(msg);
				});
			}
	    </script>
<style>
td {
	text-align: center;
}
</style>

</head>
<body>

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li class="active">Check out</li>
				</ol>
			</div>
			<!--/breadcrums-->

			<div class="step-one">
				<h2 class="heading">결제</h2>
			</div>


			<div class="shopper-informations">
				<div class="row">
					<div class="col-sm-5 clearfix">
						<div class="bill-to">
							<p>회원 정보</p>
							<div class="total_area">
								<ul>
									<li>아이디<span>${userId}</span></li>
									<li>고객명<span>${userName}</span></li>
									<li>폰번호<span>${userPhone}</span></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-sm-5 clearfix">
						<div class="bill-to">
							<p>배송지 정보</p>

							<div class="total_area">
								<ul>
									<li>주소<span>${userAddr}</span></li>
								</ul>
							</div>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="bill-to">
							<p>총 결제금액</p>
							<div class="total_area">
								<ul>
									<li>총 상품 가격 <span>${totalItemPrice}</span></li>
									<li>배송비 <span>${deliveryPrice}</span></li>
									<li>총 결제 예상 금액 <span>${paymentPrice}</span></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="step-one">
				<h2 class="heading">구매내역</h2>
			</div>

			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
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
											<b><span style="font-size: 9pt;">장바구니에 담긴 상품이 없습니다.</span></b>
										</p>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${requestScope.cartItemList}" var="cartItem">
									<tr>
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

											<div class="cart_quantity_button" id="itemAmount">
												<p>${cartItem.amount}</p>
											</div>
										</td>

										<td class="cart_total">
											<p class="cart_total_price">${cartItem.totalPrice}</p>
										</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			
			<a class="btn btn-primary" href="front?key=cart&methodName=select">장바구니 돌아가기</a> 
			<c:if test="${not empty requestScope.cartItemList}">
			      <input type="hidden" value="${cartItemList.get(0).goods.goodsName}" name="payGoodsName" id="payGoodsName"/>
			      <a class="btn btn-primary" href="#" id = "iamportPayment">결제하기</a>
			</c:if>
		</div>
		<br>

	</section>

<div class="col-sm-6">
	<div class="total_area">
		<ul>
			<li>총 상품 가격 <span>${totalItemPrice}</span></li>
			<li>배송비 <span>${deliveryPrice}</span></li>
			<li>총 결제 예상 금액 <span>${paymentPrice}</span></li>
		</ul>
		<a class="btn btn-default update" href="front?key=cart&methodName=deleteAll">장바구니 비우기</a>
		 <a class="btn btn-default check_out" href="#">결제하기</a>
	</div>
</div>
<form method="post" action="${path}/front" id="payForm">
	<!-- 결재가 완료되었을때 가지고 가이동할 값들 설 -->
	<input type="hidden" name="key" id="key" value="order" />
	<input type="hidden" name="methodName" id="methodName" value="orders" />
	<input type="hidden" name="orderCode" id="orderCode" value="" />
	<input type="hidden" name="orderPrice" id="orderPrice" value="${totalItemPrice}" />
	<input type="hidden" name="userAddr" id="userAddr" value="${userAddr}" />
	<input type="hidden" name="userPhone" id="userPhone" value="${userPhone}" />
	
</form>

</body>
<jsp:include page="common/footer.jsp" />
</html>