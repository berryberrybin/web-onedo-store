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
<SCRIPT language=javascript>
<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js" ></script>

<script type="text/javascript">
	$(function() {
		alert(${'${loginUser.userId}'});

	})
</script>
</head>
<!--/head-->

<body>


	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<jsp:include page="../board/Leftmenu.jsp" />
				</div>
				<div class="col-sm-9">
					<div class="blog-post-area">
						<h2 class="title text-center">Latest From our Blog</h2>

					</div>
					<!--/blog-post-area-->

					<form name="writeForm" method="post"
						action="${path}/front?key=qnaBoard&methodName=insert"
						onSubmit='return checkValid()' enctype="multipart/form-data">

						<table align="center" cellpadding="5" cellspacing="2" width="600"
							border="0" >



							<tr>
								<td width="1400" height="40" colspan="2" bgcolor="#FE980F">
									<p align="center">
										<font color="white" size="3"><b> 공지사항 등록 </b></font>
									</p>
								</td>
							</tr>
							<tr>
								<td width="150" height="20">
									<p align="center">
										<b><span style="font-size: 9pt;">상품 번호</span></b>
									</p>
								</td>
								<td width="450" height="20"><b><span
										style="font-size: 9pt;"> <input type=text
											name="model_num" size="30"></span></b></td>
							</tr>
							<tr>
								<td width="150" height="20">
									<p align="center">
										<b><span style="font-size: 9pt;">제목</span></b>
									</p>
								</td>
								<td width="450" height="20"><b><span
										style="font-size: 9pt;"> <input type=text
											name="model_name" size="30"></span></b></td>
							</tr>
							
							<tr>
								<td width="150" height="20">
									<p align="center">
										<b><span style="font-size: 9pt;">내용</span></b>
									</p>
								</td>
								<td width="450" height="20"><b><span
										style="font-size: 9pt;"> <textarea name="description"
												cols="50" rows="10"></textarea></span></b></td>
							</tr>

							<tr>
								<td width="150" height="20">
									<p align="center">
										<b><span style="font-size: 9pt;">*파일첨부</span></b>
									</p>
								</td>
								<td width="450" height="20"><b><span
										style="font-size: 9pt;"> <input type="file" name="file"
											maxlength="60" size="40">
									</span></b></td>
							</tr>


							<tr>
								<td width="450" height="20" colspan="2" align="center"><b><span
										style="font-size: 9pt;"><input type=submit value=글쓰기>
											<input type=reset value=다시쓰기></span></b></td>
							</tr>
						</table>
					</form>
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