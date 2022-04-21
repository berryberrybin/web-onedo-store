<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <jsp:include page="common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
 <script type="text/javascript">
 	$(function(){
 		$(document).on("click","#goods",function(){
			let goodsCode = $(this).attr("name");
			//alert(idValue);
			//상품클릭시 조회수증가 함
			location.href="${path}/front?key=goods&methodName=selectByGoodsCode&isIncrement=y&goodsCode="+goodsCode;
 		})
 		
 		$(".orderBy").click(function(){
 			let o = $(this).attr("id");
 			
 			let orderMethod = "";
 			
 			if(o=="orderByPrice")
 				orderMethod = "1";
 			else if(o=="orderByPriceDesc")
 				orderMethod = "2";
 			else if(o=="orderByViewDesc")
 				orderMethod = "3";
 			
 			location.href="${path}/front?key=goods&methodName=orderByCondition&orderMethod="+orderMethod;
 		});
 		
 		//현재페이지 a태그에 active속성 주기
 		
 	});
 </script>
 <style type="text/css">
 	.orderby-div{text-align: right; margin: 0px 20px 10px 0px;}
 	.orderBy{text-decoration: none; color: #696763;}
 </style>
 </head>
<body>
	<section>
		<div class="container">
			<div class="row">
			<jsp:include page="common/category.jsp"/>
			
			<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Features Items</h2>
						
						<div class="orderby-div"><!-- 정렬하기 -->
							<a href="#" class="orderBy" id="orderByPrice">낮은가격 | </a>
							<a href="#" class="orderBy" id="orderByPriceDesc">높은가격 | </a>
							<a href="#" class="orderBy" id="orderByViewDesc">조회수</a>
							<!-- <a href="#" class="orderby-name" id="reviewCountDesc">후기순</a> -->
						</div>
						
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
														<a href="front?key=cart&methodName=insert&goodsCode=${goodsDTO.goodsCode}&quantity=1" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
													</div>
												</div>
										</div>
									</div>
								</div>
								
						</c:forEach>
						</c:otherwise>
				    	</c:choose> 	
			</div>
			
			<jsp:useBean class="onedo.mvc.paging.PageCnt" id="p"/> 
			<nav class="pagination-container">
				<ul class="pagination"><!-- 페이징처리 -->
					<c:set var="doneLoop" value="false"/>		
					<c:set var="temp" value="${(pageNo-1) % p.blockcount}"/>
					<c:set var="startPage" value="${pageNo - temp}"/>
					<!-- \${pageNo} = ${pageNo} , 	\${temp}=${temp}  ,   \${startPage}=${startPage}  , -->
					
					<!-- String searchField, String searchValue 넣기 -->
					<% 
						String searchField = request.getParameter("searchField");
						String searchValue = request.getParameter("searchValue");
					%>
					<c:if test="${(startPage-p.blockcount) > 0}">
			      		<li><a class="pagination-newer" href="${path}/front?key=goods&methodName=selectMultipleGoods&searchField=<%=searchField %>&searchValue=<%=searchValue %>&pageNo=${startPage-1}">&laquo;</a></li>
			  		</c:if>
					<c:forEach var='i' begin='${startPage}' end='${(startPage-1)+p.blockcount}'> 
						<c:if test="${(i-1)>=p.pageCnt}">
							<c:set var="doneLoop" value="true"/>
						</c:if> 
						<c:if test="${not doneLoop}" >
							<li><a class="${i==pageNo?'pagination-active':page}" href="${path}/front?key=goods&methodName=selectMultipleGoods&searchField=<%=searchField %>&searchValue=<%=searchValue %>&pageNo=${i}">${i}</a></li> 
						</c:if>
					</c:forEach>
					<c:if test="${(startPage+p.blockcount)<=p.pageCnt}">
					    <li><a class="pagination-older" href="${path}/front?key=goods&methodName=selectMultipleGoods&searchField=<%=searchField %>&searchValue=<%=searchValue %>&pageNo=${startPage+p.blockcount}">&raquo;</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
		</div>
	</section>

</body>
	<jsp:include page="common/footer.jsp"/>
</html>