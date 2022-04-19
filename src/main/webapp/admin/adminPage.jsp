<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="../../common/adminheader.jsp"/>

<!DOCTYPE html>
<html>
<html lang="en">
<head>

</head>
<!--/head-->
<body>

	<header id="header">
		<!--header-->
		<div class="header-middle">
			<!--header-middle-->
		<div class="header-middle"><!--header-middle-->

			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<!-- <a href="index.html"><img src="images/home/logo.png" alt="" /></a> -->
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="adminPage2.html"><i class="fa fa-user"></i> 관리자계정</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-middle-->
		<div class="header-bottom">
			<!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="index.html" class="active">Home</a></li>
								<li class="dropdown"><a href="#">상품관리<i class="fa fa-angle-down"></i></a>
									<ul role="menu" class="sub-menu">
										<li><a href="${path}/admin/adminGoods.jsp">상품조회</a></li>
									</ul></li>
								<li class="dropdown"><a href="#">회원관리<i class="fa fa-angle-down"></i></a>
									<ul role="menu" class="sub-menu">
										<li><a href="${path}/front?key=user&methodName=userSelectAll">회원조회</a></li>
									</ul></li>
								<li class="dropdown"><a href="#">매출관리<i class="fa fa-angle-down"></i></a>
									<ul role="menu" class="sub-menu">
										<li><a href="blog.html">일별매출조회</a></li>
										<li><a href="blog.html">조건별 매출조회</a></li>
										<li><a href="blog.html">상품별 매출조회</a></li>

									</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	<jsp:include page="../../common/adminfooter.jsp" />
</body>
</html>