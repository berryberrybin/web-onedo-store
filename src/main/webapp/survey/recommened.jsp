<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js" ></script>
		<style type="text/css">
			body{text-align: center;}
		</style>
	</head>
	<body>
		<h1>추천목록</h1><br>
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
										<a href="front?key=cart&methodName=insert&goodsCode=${goodsDTO.goodsCode}&quantity=1" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
									</div>
								</div>
						</div>
					</div>
				</div>
		</c:forEach>
	</body>
	<jsp:include page="../common/footer.jsp"/>
</html>