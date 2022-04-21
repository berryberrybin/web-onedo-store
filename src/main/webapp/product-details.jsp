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
		   					str += "<tr>";
		   					str += "<td>"+(index+1)+"</td>";
		   					str += "<td><a href='#'>"+item.reviewSubject+"</a></td>";
		   					str += "<td>"+moment(item.reviewDate).format("YYYY-MM-DD")+"</td>"; //날짜 형식 바꾸기
		   					//후기별점
		   					let stars ="";
	   						for(let i=0;i<item.reviewScore;i++){
	   							stars+="★";
	   						}
	   						for(let i=5;i>item.reviewScore;i--){
	   							stars+="☆";
	   						}
		   					str += "<td>"+stars+"</td>"; //별찍기로 표시
		   					//str += "<td>"+item.reviewScore+"</td>"; //숫자로 표시
		   					//str += "<td>"+changeToStars(item.reviewScore)+"</td>"; //ajax밖 메소드 호출시도
		   					str += "</tr>";
		   				});
		   				
		   				$("#reviewTable tr:gt(0)").remove();
		   				$("#reviewTable tr:eq(0)").after(str);
		   				
		   			} , //성공했을때 실행할 함수 
		   			error : function(err){  
		   				alert(err+"에러 발생했어요.");
		   			}  //실패했을때 실행할 함수 
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
		   					str += "<tr>";
		   					str += "<td>"+(index+1)+"</td>";
		   					str += "<td><a href='#'>"+item.qnaSubject+"</a></td>";
		   					str += "<td>"+moment(item.qnaDate).format("YYYY-MM-DD")+"</td>"; //날짜 형식 바꾸기
		   					str += "<td>"+item.userid+"</td>";
		   					//str += "<td>"+item.reviewScore+"</td>"; //숫자로 표시
		   					//str += "<td>"+changeToStars(item.reviewScore)+"</td>"; //ajax밖 메소드 호출시도
		   					str += "</tr>";
		   				});
		   				
		   				$("#qnaTable tr:gt(0)").remove();
		   				$("#qnaTable tr:eq(0)").after(str);
		   				
		   			} , //성공했을때 실행할 함수 
		   			error : function(err){  
		   				alert(err+"에러 발생했어요.");
		   			}  //실패했을때 실행할 함수 
		   		});//ajax끝
		   	});//후기가져오기끝
		   	
			//AddCart로 넘어가기 soobin
			$("#cartButton").click(function(){
				location.href="${path}/front?key=cart&methodName=insert&goodsCode=${goodsDTO.goodsCode}&quantity="+$("#quantity").val()		
			})
			
		});
	</script>
	<style type="text/css">
		table{width: 100%;}
		table th,td{text-align: center;}
		table th{background-color: #FE980F; color: white; padding: 5px;}
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
				<img src="images/product-details/rating.png" alt="" />
				<span>
					<span>&#8361; <fmt:formatNumber>${goodsDTO.goodsPrice}</fmt:formatNumber></span>
					<label for="quantity">수량:</label>
					<input type="number" id="quantity" name="quantity" min="1" max="99" value="1"/> 
					
					<a href="#" class="btn btn-default add-to-cart" id="cartButton">
					<i class="fa fa-shopping-cart"></i>Add to cart
					</a>
					
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
					<table id="qnaTable">
						<tr>
							<th>index</th><th>제목</th><th>날짜</th><th>아이디</th>
						</tr>
						<!-- 상품코드로 검색한 문의목록 -->
						
					</table>
				</div>
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
	
</div>
</section>
</body>
<jsp:include page="common/footer.jsp"/>
</html>