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
 
 	<script type="text/javascript"> //비밀번호 눈
	    $(document).ready(function(){
	        $('.pw i').on('click',function(){
	            $('input').toggleClass('active');
	            if($('input').hasClass('active')){
	                $(this).attr('class',"fa fa-eye-slash fa-lg")
	                .prev('input').attr('type',"text");
	            }else{
	                $(this).attr('class',"fa fa-eye fa-lg")
	                .prev('input').attr('type','password');
	            }
	        });
	    });
    </script>
 
 	<script type="text/javascript">
	//로그인 폼 유효성 체크
	
	function loginCheck() {
		//변수에 입력 값 담기

		var userId = document.getElementById("userId"); //아이디
		var userPwd = document.getElementById("userPwd"); //비밀번호

		
		if(userId.value==""){
			alert("아이디를 입력해주세요")
			userId.focus();
			return;
		};
		
		if(userPwd.value==""){
			alert("비밀번호를 입력해주세요")
			userPwd.focus();
			return false;
		};

		//입력 값 전송
		document.login.submit();
		
	};

	////////////아이디에 한글 입력 불가능 하도록
	function chkCharCode(event) {
		const regExp = /[^0-9a-zA-Z]/g;
		  const ele = event.target;
		  if (regExp.test(ele.value)) {
		    ele.value = ele.value.replace(regExp, '');
		  }
	};
	
	</script>
 
<body>
<c:choose>
	<c:when test="${empty loginUser}">
	<section id="form"><!--form-->
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="login-form"><!--login form-->
						<h2>회원 로그인</h2>
						<form name="login" method="post" action="${pageContext.request.contextPath}/front">
							<input type="hidden" name="key" value = "user" /> <!-- Controller를 찾는 정보 -->
							<input type="hidden" name="methodName" value = "login" />  <!-- 메소드이름 -->
							<input type="text" class="form-control" id="userId" name="userId"
							placeholder="아이디" onkeyup="chkCharCode(event)" onKeyDown="if(event.keyCode == 13) loginCheck()"/>
							<div class="pw">
							<input type="password" class="form-control" id="userPwd" name="userPwd"
							placeholder="비밀번호" onKeyDown="if(event.keyCode == 13) loginCheck()"/>
							<i class="fa fa-eye fa-lg"></i>&nbsp;&nbsp;&nbsp;<span><a href="signup.jsp">회원가입</a></span>
							</div>
							<button type="button" onclick="loginCheck();" class="btn btn-default">로그인</button>
						</form>
					</div><!--/login form-->
			</div>
		</div>
	</section><!--/form-->
		</c:when>
	<%-- 		<c:otherwise>
			<!--  로그인한 사용자가 접속시 화면  -->
				<h3>로그인완료</h3>
				<a href="#" class="alert-link">${loginUser} / ${loginName}</a>
			</c:otherwise>
		</c:choose> --%>

</c:choose>
</body>
</html>