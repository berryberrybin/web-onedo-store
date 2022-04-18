<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../common/header.jsp" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Blog Single | E-Shopper</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="images/ico/apple-touch-icon-57-precomposed.png">
</head>
<!--/head-->
<style>
.listTable {
	width: 100%
}

th, td {
	border: 1px gray solid;
	text-align: center;
	padding: 3px
}
</style>
<body>


	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>게시판</h2>
						<div class="panel-group category-products" id="accordian">
							<!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian"
											href="#sportswear"> <span class="badge pull-right"><i
												class="fa fa-plus"></i></span> 문의게시판
										</a>
									</h4>
								</div>
								<div id="sportswear" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="">Nike </a></li>
											<li><a href="">Under Armour </a></li>
											<li><a href="">Adidas </a></li>
											<li><a href="">Puma</a></li>
											<li><a href="">ASICS </a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian"
											href="#mens"> <span class="badge pull-right"><i
												class="fa fa-plus"></i></span> 공지게시판
										</a>
									</h4>
								</div>
								<div id="mens" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="">Fendi</a></li>
											<li><a href="">Guess</a></li>
											<li><a href="">Valentino</a></li>
											<li><a href="">Dior</a></li>
											<li><a href="">Versace</a></li>
											<li><a href="">Armani</a></li>
											<li><a href="">Prada</a></li>
											<li><a href="">Dolce and Gabbana</a></li>
											<li><a href="">Chanel</a></li>
											<li><a href="">Gucci</a></li>
										</ul>
									</div>
								</div>
							</div>


							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a href="#">자주 묻는 질문</a>
									</h4>
								</div>
							</div>


						</div>
						<!--/category-products-->

						<div class="brands_products">
							<!--brands_products-->
							<h2>Brands</h2>
							<!-- <div class="brands-name">
								
							</div> -->
						</div>
						<!--/brands_products-->

						<!-- <div class="price-range">price-range
							<h2>Price Range</h2>
							<div class="well">
								 <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
								 <b>$ 0</b> <b class="pull-right">$ 600</b>
							</div>
						</div>/price-range -->
						<!-- 
						<div class="shipping text-center">shipping
							<img src="images/home/shipping.jpg" alt="" />
						</div>/shipping -->
					</div>
				</div>
				<div class="col-sm-9">
					<div class="blog-post-area">
						<h2 class="title text-center">Latest From our Blog</h2>

					</div>
					<!--/blog-post-area-->

					<table align="center" border="0" cellpadding="5" cellspacing="2"
						width="100%" bordercolordark="white" bordercolorlight="black">
						<caption>
							<h2 align="center">자주 묻는 질문</h2>
						</caption>
						<colgroup>

							<col width="15%" />
							<col width="30%" />
							<col width="50%" />


						</colgroup>
						<tr>
							<td bgcolor="#FE980F">
								<p align="center">
									<font color="white"><b><span style="font-size: 9pt;">글번호</span></b></font>
								</p>
							</td>

							<td bgcolor="#FE980F">
								<p align="center">
									<font color="white"><b><span style="font-size: 9pt;">제목</span></b></font>
								</p>
							</td>
							<td bgcolor="#FE980F">
								<p align="center">
									<font color="white"><b><span style="font-size: 9pt;">내용</span></b></font>
								</p>
							</td>


						</tr>


						<c:forEach items="${list}" var="faqBoard">
							<tr>
								<td>${qnaBoard.faqNo}</td>
								<td>${qnaBoard.faqSubject}</td>
								<td>${qnaBoard.faqContent}</td>


							</tr>
						</c:forEach>

						<c:choose>
							<c:when test="${empty requestScope.list}">
								<tr>
									<td colspan="7">
										<p align="center">
											<b><span style="font-size: 9pt;">등록된 문의 없습니다.</span></b>
										</p>
									</td>
								</tr>
							</c:when>
							<c:otherwise>

							</c:otherwise>
						</c:choose>
					</table>
					<div align="left">
						<span style="font-size: 9pt;"><a class="btn btn-primary"
							href="${path}/front?key=faqBoard&methodName=faqSelectAll">조회하기</a></span>
					</div>

					<div align=right>
						<span style="font-size: 9pt;"><a class="btn btn-primary"
							href="${path}/writing.jsp">글쓰기</a></span>
					</div>



				</div>
			</div>
		</div>
	</section>



	<script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/main.js"></script>
</body>
</html>