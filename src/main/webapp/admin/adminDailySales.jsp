<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<jsp:include page="../common/adminheader.jsp" />
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
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="jquery.tablesorter.min.js"></script>
<link rel="stylesheet" href="css/blue_style.css" type="text/css">



</head>
<script type="text/javascript">

   $(document).ready(function(){ 
      $("#gcTable").tablesorter();
   });
</script>

<body>

	<section id="cart_items">
		<div class="header-bottom">
			<!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="container">
			<div class="table-responsive cart_info">
			<table id="gcTable" class="tablesorter">
					<thead>
						<tr class="cart_menu">
							<th class="orderCode">주문번호</th>
							<th class="userId">주문자아이디</th>
							<th class="orderPrice">주문총가격</th>	
							<th class="orderDate">주문날짜</th>
							<th class="orderLineCode">주문상세번호</th>
							<th class="goodsName">상품명</th>
							<th class="goodsPrice">상품가격</th>
							<th class="orderQuantity">상품수량</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${empty requestScope.salesList}">
								<tr>
									<td colspan="5">
										<p align="center">
											<b><span style="font-size: 9pt;"> 해당 내역이 없습니다. </span></b>
										</p>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach items="${requestScope.salesList}" var="salesDTO">
									<tr>
										<td class="itemOrderCode">
											<h4>
												<a href="">${salesDTO.orderCode}</a>
											</h4>
										</td>
										<td class="itemUserId">
											<h4>
												<a href="">${salesDTO.userId}</a>
											</h4>
										</td>
										<td class="itemOrderPrice">
											<h4>
												<a href=""><fmt:formatNumber value="${salesDTO.orderPrice}"/></a>
											</h4>
										</td>
										<td class="itemOrderDate">
											<h4>
												<a href="">${salesDTO.orderDate}</a>
											</h4>
										</td>
										<td class="itemOrderLineCode">
											<h4>
												<a href="">${salesDTO.orderLineCode}</a>
											</h4>
										</td>
										
										<td class="itemGoodsName">
											<h4>
												<a href="">${salesDTO.goodsName}</a>
											</h4>
										</td>
										<td class="itemGoodsPrice">
											<h4>
												<a href=""><fmt:formatNumber value="${salesDTO.goodsPrice}"/></a>
											</h4>
										</td>
										<td class="itemOrderQuantity">
											<h4>
												<a href="">${salesDTO.orderQuantity}</a>
											</h4>
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

	<!--/#do_action-->

</body>
<jsp:include page="../common/footer.jsp" />
</html>