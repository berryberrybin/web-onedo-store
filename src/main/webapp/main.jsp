<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <jsp:include page="common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
 </head>
 <script type="text/javascript">
 	$(function(){
 		$(document).on("click","#goods",function(){
				let goodsCode = $(this).attr("name");
				//alert(idValue);
				//상품클릭시 조회수증가 함
				location.href="${path}/front?key=goods&methodName=selectByGoodsCode&isIncrement=y&goodsCode="+goodsCode;
 		})
 	});
 </script>
<body>

	<section id="slider"><!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
							<li data-target="#slider-carousel" data-slide-to="2"></li>
						</ol>
						
						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-12">
									<img src="${path}/images/home/OneDomain05.jpg" class="girl img-responsive" alt="" />
								</div>
							</div>
							<div class="item">
								<div class="col-sm-12">
									<img src="${path}/images/home/OneDomain04.jpg" class="girl img-responsive" alt="" />
								</div>
							</div>
							<div class="item">
								<div class="col-sm-12">
									<img src="${path}/images/home/OneDomain03.jpg" class="girl img-responsive" alt="" />
								</div>
							</div>
						</div>
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</section><!--/slider-->
	
		<section id="advertisement"> <!-- 배너 클릭시 설문으로.. -->
		<div class="container">
			<a href="${path}/survey/survey.jsp"><img src="images/shop/OneDObanner02.jpg" alt="" /></a>
		</div>
		</section>
		
	<section>
	<div class="container">
		<div class="row">
		<jsp:include page="common/category.jsp"/>
		<!-- 상품 페이지 추가-->
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
	</section>

</body>
	<jsp:include page="common/footer.jsp"/>
</html>