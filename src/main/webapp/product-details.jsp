<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <jsp:include page="common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		$(function(){
			//상품 속성
			let attrs = [{name:'신맛',score:${goodsDTO.goodsAttrDTO.sour}},{name:'단맛',score:${goodsDTO.goodsAttrDTO.sweet}},
						{name:'향미',score:${goodsDTO.goodsAttrDTO.aroma}},{name:'바디감',score:${goodsDTO.goodsAttrDTO.body}}];
			
			let str="";
			$.each(attrs,function(index,item){
				str+=item.name+" : ";
				changeToStars(item.score);
				str+="<br>"
			});
			
			//5점 만점으로 별찍기 메소드
			function changeToStars(num){
				for(let i=0;i<num;i++){
					str+="★";
				}
				for(let i=5;i>num;i--){
					str+="☆";
				}
			}
			
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
		   					str += "<details>";
		   					str += "<summary>&nbsp;"+item.reviewSubject+"&emsp;&emsp;"+item.userId+"&emsp;"+"|"+"&emsp;"+moment(item.reviewDate).format("YYYY-MM-DD")+"&emsp;"+"|"+"&emsp;";
		   					changeToStars(item.reviewScore);
		   					str += "</summary>";
		   					str += "<p>"+item.reviewContent;
		   					if(!item.reviewImg==null||!item.reviewImg=="") str += "<img src='${path}/img/"+item.reviewImg+"' alt=''>";
		   					str += "</p>";
		   					str += "</details>";
		   				});
		   				
		   				$("#searchReviews div details").remove();
		   				$("#searchReviews div").append(str);
		   				
		   			} , 
		   			error : function(err){  
		   				alert(err+"에러 발생했어요.");
		   			}
		   		});//ajax끝
		   	});//후기가져오기끝
			
		  //상품코드에 해당하는 모든 문의 가져오기
			$("#qnas").click(function(){
				$.ajax({
		   			url :"${path}/ajax" ,
		   			type:"post",
		   			dataType:"json"  ,
		   			data: {key: "ajaxQna", methodName : "selectQnaByGoodsCode", goodsCode : "${goodsDTO.goodsCode}"}, //서버에게 보낼 데이터정보(parameter정보)
		   			success :function(result){
		   				str = "";
		   				$.each(result, function(index, item){
		   					str += "<details>";
		   					str += "<summary>"+(index+1)+"&emsp;&emsp;"+item.qnaSubject+"&emsp;"+"|"+"&emsp;"+moment(item.qnaDate).format("YYYY-MM-DD")+"&emsp;"+"|"+"&emsp;"+item.userid+"</summary>";
		   					str += "<p>"+item.qnaContent+"</p>";
		   					str += "</details>";
		   				});
		   				
		   				$("#searchQna div details").remove();
		   				$("#searchQna div").append(str);
		   				
		   			} ,
		   			error : function(err){  
		   				alert(err+"에러 발생했어요.");
		   			}
		   		});//ajax끝
		   	});//후기가져오기끝
		   	
			//AddCart로 넘어가기 soobin
			$("#cartButton").click(function(){
				location.href="${path}/front?key=cart&methodName=insert&goodsCode=${goodsDTO.goodsCode}&quantity="+$("#quantity").val()		
			})
			
		});
	</script>
	<style type="text/css">
		.view-product img{height: 100%}
		details { margin:5px 0 10px; }
		details > summary { background:#fff; color:#444; padding:10px; outline:0; border-radius:5px; cursor:pointer; transition:background 0.5s; text-align:left; box-shadow: 1px 1px 2px gray;}
		details > summary::-webkit-details-marker { background:#444; color:#fff; background-size:contain; transform:rotate3d(0, 0, 1, 90deg); transition:transform 0.25s;}
		details[open] > summary::-webkit-details-marker { transform:rotate3d(0, 0, 1, 180deg);}
		details[open] > summary { background:#FE980F;}
		details[open] > summary ~ * { animation:reveal 0.5s;}
		.tpt { background:#444; color:#fff; margin:5px 0 10px; padding:5px 10px; line-height:25px; border-radius:5px; box-shadow: 1px 1px 2px gray;}
		details > p {padding: 10px; font-size: 20px;}
		details > p > img {padding-top: 10px; height: 300px;}
		@keyframes reveal {
		    from { opacity:0; transform:translate3d(0, -30px, 0); }
		    to { opacity:1; transform:translate3d(0, 0, 0); }
		}
		
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
			
		</div>
		<div class="col-sm-7">
			<div class="product-information"><!--/product-information-->
				<img src="images/product-details/new.jpg" class="newarrival" alt="" />
				<h2>${goodsDTO.goodsName}</h2>
				<p>goodsCode: ${goodsDTO.goodsCode}</p>
				<span>
					<span>&#8361; <fmt:formatNumber>${goodsDTO.goodsPrice}</fmt:formatNumber></span>
					<h4>
					<label for="quantity">수량:</label>
					<input type="number" id="quantity" name="quantity" min="1" max="99" value="1"/> 
					</h4>
					<a href="#" class="btn btn-default add-to-cart" id="cartButton">
					<i class="fa fa-shopping-cart"></i>Add to cart
					</a>
					
				</span>
				
			</div><!--/product-information-->
		</div>
	</div><!--/product-details-->
	
	<div class="category-tab shop-details-tab"><!--category-tab-->
		<div class="col-sm-12">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#details" data-toggle="tab">상세정보</a></li>
				<li><a id="qnas" href="#searchQna" data-toggle="tab">상품문의</a></li>
				<li><a id="reviews" href="#searchReviews" data-toggle="tab">상품후기</a></li>
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
			
			<div class="tab-pane fade" id="searchQna" ><!-- 상품문의 -->
				<div class="col-sm-12">
					<!-- 상품코드로 검색한 문의목록 -->
						
				</div>
			</div>
			
			<div class="tab-pane fade" id="searchReviews" >
				<div class="col-sm-12">
					<!-- 상품코드로 검색한 후기목록 -->
						
				</div>
			</div>
			
		</div>
	</div><!--/category-tab-->
	
</div>
</section>
</body>
<jsp:include page="common/footer.jsp"/>
</html>