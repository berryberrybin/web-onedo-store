<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <jsp:include page="../common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
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


<style type="text/css">
	nav nav-pills nav-stacked active{color: red}
	
	@font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
}
	
	h4{
		color: #B45F04;
		font-family:Pretendard-Regular;
	}

	td {
		text-align: center;
	}
	
</style>

</head>
<body>
<div class="container bootstrap snippets bootdey">
<div class="row">
  <div class="profile-nav col-md-3">
      <div class="panel">
          <div class="user-heading round">
              <!-- <h5>????????? ?????????</h5> -->
				<c:if test="${not empty loginUser}">
					<h4><i class="fa fa-user"></i>&nbsp;&nbsp;${loginUser.userId}??? ??????????????? :)</h4>
				</c:if>
				<hr>
              <p></p>
          </div>

          <ul class="nav nav-pills nav-stacked">
              <li><a href="${path}/user/modify.jsp"> <i class="fa fa-edit"></i>&nbsp;&nbsp;??? ?????? ??????</a></li>
              <li><a href="${path}/front?key=user&methodName=myPage"> <i class="fa fa-tags"></i>&nbsp;&nbsp;?????? ?????? ??????</a></li>
              <li><a href="${path}/front?key=user&methodName=myBoard"> <i class="fa fa-file-text"></i>&nbsp;&nbsp;?????? ??? ??? ??????</a></li>
          </ul>
      </div>
  </div>
  <div class="profile-info col-md-9">
      <div class="panel">
          <div class="bio-graph-heading">
            <h4>?????? ?????? ?????? ??????</h4>
            <hr>
            <table class="table">
					<thead>
						<tr class="cart_menu">
							<td class="orderCode">????????????</td>
							<td class="name">?????? ??????</td>
							<td class="price">?????? ??????</td>
							<td class="date">?????????</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					<c:choose>
							<c:when test="${empty requestScope.myList}">
								<tr>
									<td colspan="5">
										<p align="center">
											<b><span style="font-size: 9pt;"> ?????? ????????? ????????????. </span></b>
										</p>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
							<c:forEach items="${requestScope.myList}" var="salesDTO">
							<tr>
								<td class="orderCode">
										<a href="${path}/front?key=user&methodName=myOrderLine&orderCode=${salesDTO.orderCode}">${salesDTO.orderCode}</a>
								</td>
								<td class="orderName">
										<p>${salesDTO.goodsName}</p>
								</td>
								<td class="orderPrice">
									<p class="cart_total_price"><fmt:formatNumber>${salesDTO.orderPrice}</fmt:formatNumber>???</p>
								</td>
								<td class="orderDate">
										<p>${salesDTO.orderDate}</p>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
					</tbody>
			</table>
          </div><br>
      </div>
      
<jsp:useBean class="onedo.mvc.paging.PageCnt" id="p"/> 
		<nav class="pagination-container">
			<ul class="pagination">
			<!-- ??????????????? -->
			<c:set var="doneLoop" value="false"/>
		
			<c:set var="temp" value="${(pageNo-1) % p.blockcount}"/> <!-- (1-1)%2  =0  , (2-1)%2    1 , (3-1)%2  0 -->
			<c:set var="startPage" value="${pageNo - temp}"/> <!--   1- 1 -->
		  <c:if test="${(startPage-p.blockcount) > 0}"> <!-- (-2) > 0  -->
		      <li><a class="pagination-newer" href="${path}/front?key=user&methodName=myPage&pageNo=${startPage-1}">&laquo;</a></li>
		  </c:if>
	
		  <c:forEach var='i' begin='${startPage}' end='${(startPage-1)+p.blockcount}'> 
			  <c:if test="${(i-1)>=p.pageCnt}">
			       <c:set var="doneLoop" value="true"/>
			    </c:if> 
			  <c:if test="${not doneLoop}" >
			         <li><a class="${i==pageNo?'pagination-active':page}" href="${path}/front?key=user&methodName=myPage&pageNo=${i}">${i}</a> </li>
		     </c:if>
		</c:forEach>
		
		 <c:if test="${(startPage+p.blockcount)<=p.pageCnt}">
		     <li><a class="pagination-older" href="${path}/front?key=user&methodName=myPage&pageNo=${startPage+p.blockcount}">&raquo;</a></li>
		 </c:if>
		 </ul>
			</nav>
      
      
 	</div> <!-- ?????? ?????? ?????? ??? -->

</div>
</div> <!-- ??????????????? ??? -->
</body>
	<jsp:include page="../common/footer.jsp"/>
</html>