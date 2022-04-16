<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <jsp:include page="common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title> ONE DO </title>
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
 </head>
<body>
	<section>
		<div class="container">
			<div class="row">
			<jsp:include page="common/category.jsp"/>
			
			<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Features Items</h2>
						<c:choose>
						<c:when test="${empty requestScope.list}">
							<p align="center"><b><span style="font-size:9pt;">등록된 상품이 없습니다.</span></b></p>
						</c:when>
						<c:otherwise>
						<c:forEach items="${requestScope.list}" var="goodsDTO">
							<div class="col-sm-4">
									<div class="product-image-wrapper">
										<div class="single-products">
												<div class="productinfo text-center">
													<img src="${path}/img/${goodsDTO.goodsImg}" alt="" />
													<h2><fmt:formatNumber>${goodsDTO.goodsPrice}</fmt:formatNumber></h2>
													<p>${goodsDTO.goodsName}</p>
												</div>
												<div class="product-overlay" id="goods" name="${goodsDTO.goodsCode}">
													<div class="overlay-content">
														<h2><fmt:formatNumber>${goodsDTO.goodsPrice}</fmt:formatNumber></h2>
														<p>${goodsDTO.goodsName}</p>
														<a href="front?key=cart&methodName=insert&goodsCode=${goodsDTO.goodsCode}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
													</div>
												</div>
										</div>
									</div>
								</div>
								
						</c:forEach>
						</c:otherwise>
				    	</c:choose>
			</div>
		</div>
		</div>
	</section>

</body>
	<jsp:include page="common/footer.jsp"/>
</html>