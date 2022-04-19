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
	<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		$(function(){
			//상품 속성
			let attrs = [{name:'신맛',score:${goodsDTO.goodsAttrDTO.sour}},{name:'단맛',score:${goodsDTO.goodsAttrDTO.sweet}},
						{name:'향미',score:${goodsDTO.goodsAttrDTO.aroma}},{name:'바디감',score:${goodsDTO.goodsAttrDTO.body}}];
			
			let str="";
			$.each(attrs,function(index,item){
				str+=item.name+" : ";
				for(let i=0;i<item.score;i++){
					str+="★";
				}
				for(let i=5;i>item.score;i--){
					str+="☆";
				}
				str+="<br>"
			});
			
			let goodsDetail="<h3 style='color:#363432'>"+"${goodsDTO.goodsDetail}"+"</h3><p>";
			$("#goodsAttr").html(goodsDetail+"<h4 style='color:#FE980F'>"+str+"</h4>");
			
			//상품코드에 해당하는 모든 후기 가져오기
			$("#reviews").click(function(){
				$.ajax({
		   			url :"${path}/ajax" ,
		   			type:"post",
		   			dataType:"json"  ,
		   			data: {key: "ajaxReview", methodName : "selectByGoodsCode", goodsCode : "${goodsDTO.goodsCode}"}, //서버에게 보낼 데이터정보(parameter정보)
		   			success :function(result){
		   				str = "";
		   				$.each(result, function(index, item){
		   					alert(index);
		   					str += "<tr>";
		   					str += "<td>"+(index+1)+"</td>";
		   					str += "<td><a href='#'>"+item.reviewSubject+"</a></td>";
		   					str += "<td>"+item.reviewDate+"</td>";
		   					str += "<td>"+item.reviewScore+"</td>";
		   					str += "</tr>";
		   				});
		   				
		   				$("#reviewTable tr:gt(0)").remove();
		   				$("#reviewTable tr:eq(0)").after(str);
		   				
		   			} , //성공했을때 실행할 함수 
		   			error : function(err){  
		   				alert(err+"에러 발생했어요.");
		   			}  //실패했을때 실행할 함수 
		   		});//ajax끝
				
			});
			
		});
	</script>
	<style type="text/css">
		#reviewTable{width: 100%;}
		#reviewTable th,td{text-align: center;}
		#reviewTable tr:nth-child(odd){background-color: #BDBDBD; color: white;}
	</style>
 </head>
<body>

<section>
<div class="container">
<jsp:include page="common/category.jsp"/>
<div class="col-sm-9 padding-right">
	<div class="product-details"><!--product-details상세페이지-->
		<div class="col-sm-5">
			<div class="view-product">
				<img src="${path}/img/${goodsDTO.goodsImg}" alt="" />
				<h3>ZOOM</h3>
			</div>
			<div id="similar-product" class="carousel slide" data-ride="carousel">
				
				  <!-- Wrapper for slides -->
				    <div class="carousel-inner">
						<div class="item active">
						  <a href=""><img src="images/product-details/similar1.jpg" alt=""></a>
						  <a href=""><img src="images/product-details/similar2.jpg" alt=""></a>
						  <a href=""><img src="images/product-details/similar3.jpg" alt=""></a>
						</div>
						<div class="item">
						  <a href=""><img src="images/product-details/similar1.jpg" alt=""></a>
						  <a href=""><img src="images/product-details/similar2.jpg" alt=""></a>
						  <a href=""><img src="images/product-details/similar3.jpg" alt=""></a>
						</div>
						<div class="item">
						  <a href=""><img src="images/product-details/similar1.jpg" alt=""></a>
						  <a href=""><img src="images/product-details/similar2.jpg" alt=""></a>
						  <a href=""><img src="images/product-details/similar3.jpg" alt=""></a>
						</div>
						
					</div>

				  <!-- Controls -->
				  <a class="left item-control" href="#similar-product" data-slide="prev">
					<i class="fa fa-angle-left"></i>
				  </a>
				  <a class="right item-control" href="#similar-product" data-slide="next">
					<i class="fa fa-angle-right"></i>
				  </a>
			</div>
		</div>
		<div class="col-sm-7">
			<div class="product-information"><!--/product-information-->
				<img src="images/product-details/new.jpg" class="newarrival" alt="" />
				<h2>${goodsDTO.goodsName}</h2>
				<p>goodsCode: ${goodsDTO.goodsCode}</p>
				<img src="images/product-details/rating.png" alt="" />
				<span>
					<span>&#8361; <fmt:formatNumber>${goodsDTO.goodsPrice}</fmt:formatNumber></span>
					<label for="quantity">수량:</label>
					<input type="number" id="quantity" name="quantity" min="1" max="99" value="1"/>
					<a href="front?key=cart&methodName=insert&goodsCode=${goodsDTO.goodsCode}" class="btn btn-default add-to-cart">
					<i class="fa fa-shopping-cart"></i>Add to cart</a>
					
				</span>
				<p><b>Availability:</b> ${goodsDTO.isSoldout}</p>
				<p><b>Condition:</b> New</p>
				<p><b>Brand:</b> E-SHOPPER</p>
				<a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a>
			</div><!--/product-information-->
		</div>
	</div><!--/product-details-->
	
	<div class="category-tab shop-details-tab"><!--category-tab-->
		<div class="col-sm-12">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#details" data-toggle="tab">상세정보</a></li>
				<li><a href="#searchQna" data-toggle="tab">상품문의</a></li>
				<li><a href="#searchFaq" data-toggle="tab">자주묻는질문</a></li>
				<li><a id="reviews" href="#searchReviews" data-toggle="tab">후기 (5)</a></li>
			</ul>
		</div>
		<div class="tab-content">
			<div class="tab-pane fade active in" id="details" >
				<div class="col-sm-12">
					<div id="goodsAttr">
						<!-- 상품속성정보 -->
					</div>
				</div>
			</div>
			
			<div class="tab-pane fade" id="searchQna" >
				<!-- 상품문의 -->
				상품문의입니다
			</div>
			
			<div class="tab-pane fade" id="searchFaq" >
				<!-- 자주묻는질문 -->
				자주묻는질문입니다
			</div>
			
			<div class="tab-pane fade" id="searchReviews" >
				<div class="col-sm-12">
					<table id="reviewTable">
						<tr>
							<th>index</th><th>제목</th><th>날짜</th><th>별점</th>
						</tr>
						<!-- 상품코드로 검색한 후기목록 -->
						
					</table>
				</div>
			</div>
			
		</div>
	</div><!--/category-tab-->
	
	<div class="recommended_items"><!--recommended_items-->
		<h2 class="title text-center">recommended items</h2>
		
		<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
				<div class="item active">	
					<div class="col-sm-4">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/recommend1.jpg" alt="" />
									<h2>$56</h2>
									<p>Easy Polo Black Edition</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/recommend2.jpg" alt="" />
									<h2>$56</h2>
									<p>Easy Polo Black Edition</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/recommend3.jpg" alt="" />
									<h2>$56</h2>
									<p>Easy Polo Black Edition</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="item">	
					<div class="col-sm-4">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/recommend1.jpg" alt="" />
									<h2>$56</h2>
									<p>Easy Polo Black Edition</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/recommend2.jpg" alt="" />
									<h2>$56</h2>
									<p>Easy Polo Black Edition</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/recommend3.jpg" alt="" />
									<h2>$56</h2>
									<p>Easy Polo Black Edition</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
				<i class="fa fa-angle-left"></i>
			  </a>
			  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
				<i class="fa fa-angle-right"></i>
			  </a>			
		</div>
	</div><!--/recommended_items-->
</div>
</section>
</body>
<jsp:include page="common/footer.jsp"/>
</html>