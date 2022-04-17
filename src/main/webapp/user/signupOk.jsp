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

	<style>
	    
	   h2{
	   		text-align: center;
	   }
	    
       #btn{
        width:100px;
        margin:auto;
        display:block;
	}
	    
	</style>


 </head>
<body>


	<section id="form"><!--form-->
			<div id="logo" class="row">
				<div class="col-md-6 col-md-offset-2">
						<h2>회원 가입 완료되었습니다.</h2><br><br>
						<button type="button" id="btn" class="btn btn-default" onclick="location.href='login.jsp' ">로그인 하기</button>
					</div>
<%-- 				<div class="col-md-4 col-md-offset-4">
					<div class="col-sm-12">
						<h2>가입하신 아이디는 ${userId} 입니다.</h2>
							<button type="button" class="btn btn-default" onclick="location.href='login.jsp' ">로그인 하기</button>
					</div><!--/login form--> --%>
			</div>
	</section><!--/form-->


</body>
</html>