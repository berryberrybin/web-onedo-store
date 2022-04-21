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


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript"> 
google.charts.load('current', {'packages':['corechart']}); 
google.charts.setOnLoadCallback(drawChart); 

function drawChart() {
	var data = google.visualization.arrayToDataTable([ ['goodsName', 'quantity'], ${result} ]); 
	var options = { 
		title: '상품별 주문 통계',
		colors: ['#FF9AA2', '#FFDAC1', '#E2F0CB', '#B5EAD7', '#C7CEEA', '#FFB7B2']
	}; 
	var chart = new google.visualization.PieChart(document.getElementById('piechart')); 
	chart.draw(data, options); } 
</script>


<style>
td {
	text-align: center;
}
</style>
</head>
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
	<div id="piechart" style="width: 1400px; height: 500px; margin:0 auto;"></div>


		<div class="container">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="name">상품명</td>
							<td class="code">상품코드</td>
							<td class="quantity">총 주문 수량</td>
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
										<td class="itemName">
											<h4>
												<a href="">${salesDTO.goodsName}</a>
											</h4>
										</td>

										<td class="itemCode">
											<h4>
												<a href="">${salesDTO.goodsCode}</a>
											</h4>
										</td>
										<td class="itemPrice">
											<h4>
												<p>${salesDTO.orderQuantity}</p>
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