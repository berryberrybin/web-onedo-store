<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="common/header.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>ONE DO</title>
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
</head>
<body>

	<section id="form">
		<!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form">
						<!--login form-->
						<h2>회원 로그인</h2>
						<c:choose>
							<c:when test="${empty loginUser}">

								<form method="post" action="${pageContext.request.contextPath}/front">
									<input type="hidden" name="key" value="user" /> <input type="hidden" name="methodName" value="login" /> 
									<input type="text" id="userId" name="userId" placeholder="userId" />
									<input type="password" id="pwd" name="pwd" placeholder="password" /> 
									<span> <input type="checkbox" class="checkbox"> 아이디 기억하기 </span>

									<button type="submit" class="btn btn-default">로그인</button>
									<br>
									<span> <a href="">회원가입</a></span>

								</form>
							</c:when>
							<c:otherwise>
							<!--  로그인한 사용자가 접속시 화면  -->
								<h3>로그인완료</h3>
								<a href="#" class="alert-link">${loginUser} / ${loginName}</a>
							</c:otherwise>
						</c:choose>



					</div>
					<!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form">
						<!--sign up form-->
						<h2>New User Signup!</h2>
						<form action="#">
							<input type="text" placeholder="Name" /> <input type="email" placeholder="Email Address" /> <input type="password" placeholder="Password" />
							<button type="submit" class="btn btn-default">Signup</button>
						</form>
					</div>
					<!--/sign up form-->
				</div>
			</div>
		</div>
	</section>
	<!--/form-->

</body>
</html>