<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
<!-- 								<div class="col-sm-6">
									<h1><span>E</span>-SHOPPER</h1>
									<h2>Free E-Commerce Template</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div> -->
								<div class="col-sm-12">
									<img src="images/home/OneDomain.jpg" class="girl img-responsive" alt="" />
								</div>
							</div>
							<div class="item">
								<!-- <div class="col-sm-12">
									<h1><span>E</span>-SHOPPER</h1>
									<h2>100% Responsive Design</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div> -->
								<div class="col-sm-12">
									<img src="images/home/girl2.jpg" class="girl img-responsive" alt="" />
								</div>
							</div>
							
							<div class="item">
								<!-- <div class="col-sm-12">
									<h1><span>E</span>-SHOPPER</h1>
									<h2>Free Ecommerce Template</h2>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. </p>
									<button type="button" class="btn btn-default get">Get it now</button>
								</div> -->
								<div class="col-sm-12">
									<img src="images/home/girl3.jpg" class="girl img-responsive" alt="" />
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
			<a href="${path}/survey/survey.jsp"><img src="images/shop/OneDObanner.jpg" alt="" /></a>
		</div>
		</section>
		
	<section>
	<div class="container">
		<div class="row">
		<jsp:include page="common/category.jsp"/>
		<!-- 상품 페이지 추가-->
		</div>
	</div>
	</section>


<script type="text/javascript">
   location.href="${pageContext.request.contextPath}/front"
</script>

</body>
</html>