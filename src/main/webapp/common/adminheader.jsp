<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>ONE DO</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/prettyPhoto.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/price-range.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="${path}/images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/images/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
	<header id="header">
		<!--header-->
		<div class="header_top">
			<!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<!-- 								<li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> info@domain.com</a></li> -->
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<!-- 							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
							</ul> -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header_top-->

		<div class="header-middle">
			<!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index.jsp"><img src="${path}/images/home/OneDologo.png" alt="" /></a>
						</div>
						<div class="btn-group pull-right">
							<!-- 							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									USA
									<span class="caret"></span>
								</button>
 								<ul class="dropdown-menu">
									<li><a href="#">Canada</a></li>
									<li><a href="#">UK</a></li>
								</ul>
							</div> -->

							<!-- 							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
									DOLLAR
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="#">Canadian Dollar</a></li>
									<li><a href="#">Pound</a></li>
								</ul>
							</div> -->
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
							
							<c:choose>
								<c:when test="${loginUser.userId=='admin'}">
									<li><a href="${path}/adminPage.jsp"><i class="fa fa-cog"></i> 관리자</a></li>
								</c:when>
								<c:otherwise>
									<c:if test="${not empty loginUser}">
										<ul class="nav navbar-nav">
											<%-- <li class="active"><a href="#">${loginUser.userId}님</a></li> --%>
											<li><a href="#"><i class="fa fa-user"></i>   ${loginUser.userId}님</a></li>
										</ul>
									</c:if>
								</c:otherwise>
							</c:choose>

<%-- 								<c:if test="${loginUser.userId=='admin'}">
									<li><a href="#"><i class="fa-solid fa-toolbox"></i>   ${loginUser.userId}님</a></li>
								</c:if> --%>
							
								<li><a href="${path}/survey/survey.jsp"><i class="fa fa-coffee"></i> 커피추천</a></li>
								<li><a href="checkout.jsp"><i class="fa fa-list"></i> 게시판</a></li>
								<li><a href="front?key=cart&methodName=select"><i class="fa fa-shopping-cart"></i> 장바구니</a></li>
								<c:if test="${empty loginUser}">
									<li><a href="${path}/user/login.jsp"><i class="fa fa-unlock-alt"></i> 로그인</a></li>
								</c:if>
								<c:if test="${not empty loginUser}">
									<ul class="nav navbar-nav">
										<li><a href="${pageContext.request.contextPath}/front?key=user&methodName=logout"> <i class="fa fa-lock"></i>로그아웃
										</a></li>
									</ul>
								</c:if>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-middle-->
		<!--/header-bottom-->
	</header>
	<!--/header-->


	<script src="${path}/js/jquery.js"></script>
	<script src="${path}/js/bootstrap.min.js"></script>
	<script src="${path}/js/jquery.scrollUp.min.js"></script>
	<script src="${path}/js/price-range.js"></script>
	<script src="${path}/js/jquery.prettyPhoto.js"></script>
	<script src="${path}/js/main.js"></script>

</body>
</html>