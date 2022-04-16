<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <jsp:include page="../common/header.jsp"/>
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
 </head>
<body>

<c:choose>
	<c:when test="${empty loginUser}">
	<section id="form"><!--form-->
		<div class="container" method="post" action="${pageContext.request.contextPath}/front">
		<input type="hidden" name="key" value = "user" /> <!-- Controller를 찾는 정보 -->
		<input type="hidden" name="methodName" value = "join" />  <!-- 메소드이름 -->
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="signup-form"><!--login form-->
						<h2>회원 가입</h2>
						<form action="login.jsp" method="post">
							이름<input type="text" class="form-control" id="userName" name="userName"
							placeholder="이름" />
							아이디<input type="text" class="form-control" id="userId" name="userId"
							placeholder="아이디" />
							비밀번호<input type="password" class="form-control" id="userPwd" name="userPwd"
							placeholder="비밀번호" />
							휴대폰번호<input type="text" class="form-control" id="userPhone" name="userPhone"
							placeholder="휴대폰번호" />
							생년월일<input type="text" class="form-control" id="birth" name="birth"
							placeholder="생년월일 8자리" />
							성별 <select name="gender">
							  <option value=""selected>성별을 선택해주세요</option>
							  <option value="female">여성</option>
							  <option value="male">남성</option>
							</select><br>
							주소<input type="text" class="form-control" id="userAddr" name="userAddr"
							placeholder="주소" />
							<button type="submit" class="btn btn-default">가입하기</button>
						</form>
					</div><!--/login form-->
			</div>
		</div>
		</div>
	</section><!--/form-->
	</c:when>
</c:choose>
</body>
</html>