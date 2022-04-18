<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:include page="../common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
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


<style type="text/css">
	nav nav-pills nav-stacked active{color: red}

	td {
		text-align: center;
	}
	
</style>

</head>
<body>
<div class="container bootstrap snippets bootdey">
<div class="row">
  <div class="profile-nav col-md-3">
      <div class="panel">
          <div class="user-heading round">
              <!-- <h5>사용자 아이디</h5> -->
				<c:if test="${not empty loginUser}">
					<h4><i class="fa fa-user"></i>&nbsp;&nbsp;${loginUser.userId}님 환영합니다</h4>
				</c:if>
              <p></p>
          </div>

          <ul class="nav nav-pills nav-stacked">
              <li><a href="${path}/user/modify.jsp"> <i class="fa fa-edit"></i>&nbsp;&nbsp;내 정보 수정</a></li>
              <li><a href="#"> <i class="fa fa-file-text"></i>&nbsp;&nbsp;내가 쓴 글 보기</a></li>
          </ul>
      </div>
  </div>
  <div class="profile-info col-md-9">
      <div class="panel">
          <div class="bio-graph-heading">
            <h4>최근 주문 내역<h4>
          </div>

    </div>
</div>

  <div class="profile-info col-md-9">
      <div class="panel">
          <div class="bio-graph-heading">
            <h4>나의 장바구니<h4>
          </div><br>

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
											<b><span style="font-size: 9pt;">장바구니에 담긴 상품이 없습니다.</span></b>
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
											<div class="cart_quantity_button" id="itemAmount">
												<a class="cart_quantity_up" id="itemAmountUp" href="front?key=cart&methodName=increaseAmount&goodsCode=${cartItem.goods.goodsCode}"> + </a> 
												<input class="cart_quantity_input" type="text" name="quantity" value="${cartItem.amount}" autocomplete="off" size="2"> 
												<a class="cart_quantity_down" href="front?key=cart&methodName=decreaseAmount&goodsCode=${cartItem.goods.goodsCode}"> - </a>
											</div>
										</td>
										<td class="cart_total">
											<p class="cart_total_price">${cartItem.totalPrice}</p>
										</td>
										<td class="cart_delete">
											<a class="cart_quantity_delete" href="front?key=cart&methodName=delete&goodsCode=${cartItem.goods.goodsCode}"><i class="fa fa-times"></i></a>
										</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>

    </div><!-- div panel 끝 -->
</div><!-- col-md-9 끝 -->

                      
          </div>
     </div>


</body>
	<jsp:include page="../common/footer.jsp"/>
</html>