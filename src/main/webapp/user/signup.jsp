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
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
    
    <style type="text/css">
    	span{width:150px; color:orange}

    </style>

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
	//회원가입 폼 유효성 체크
	
	function joinCheck() {
		//변수에 입력 값 담기

		var userName = document.getElementById("userName"); //이름
		var userId = document.getElementById("userId"); //아이디
		var userPwd = document.getElementById("userPwd"); //비밀번호
		var userPhone = document.getElementById("userPhone");//핸드폰 번호
		
		if(userName.value==""){
			alert("이름을 입력해주세요")
			userName.focus();
			return;
		};
		
		let regid = /^[a-z]+$/; // 영문 소문자만
		
		if(userId.value==""){
			alert("아이디를 입력해주세요")
			userId.focus();
			return;
		};
		
		
/* 	//아이디 특수문자 사용 불가능하게 체크
		var idck = /?^!@#$%^&*-=+ ;*/
		
		if(!regid.test(userId.value)){
			alert("아이디는 영문 소문자만 사용 가능합니다")
			userId.focus();
			return;
		} 
		

		if(userPwd.value==""){
			alert("비밀번호를 입력해주세요")
			userPwd.focus();
			return false;
		};
		
/* 		var reg = /^[0-9]+/g ; //숫자만 입력하는 정규식
 */		
		if(userPhone.value==""){
			alert("휴대폰 번호를 입력해주세요")
			userPhone.focus();
			return false;
		};

		//입력 값 전송
		document.join.submit();
		
	};

	////////////아이디에 한글 입력 불가능 하도록
	function chkCharCode(event) {
		const regExp = /[^0-9a-zA-Z]/g;
		  const ele = event.target;
		  if (regExp.test(ele.value)) {
		    ele.value = ele.value.replace(regExp, '');
		  }
	};
	
	////////////휴대폰 번호에 숫자,- 이외에는 입력 불가능 하도록
	function chkPhCode(event) {
		const regExp = /[^0-9\-]/g;
		  const ele = event.target;
		  if (regExp.test(ele.value)) {
		    ele.value = ele.value.replace(regExp, '');
		  }
	};
	
	////////////생년월일에 숫자 이외에는 입력 불가능 하도록
	function chkBdCode(event) {
		const regExp = /[^0-9]/g;
		  const ele = event.target;
		  if (regExp.test(ele.value)) {
		    ele.value = ele.value.replace(regExp,'');
		  }
	};
	
	
	</script>



    <script type="text/javascript">
    
    $(function() {

    /**
	id 중복 체크 ajax
	*/
	$("#userId").keyup(function() {
		if($(this).val() == ""){
			$("span").text(""); //빈 박스일때 문구 없애기
			return;
		}
		
		
		$.ajax({
				url :"../ajax" , //서버요청주소
				type:"post", //요청방식(method방식 : get | post | put | delete )
				dataType:"text"  , //서버가 보내온 데이터(응답)타입(text | html | xml | json )
				data: {key:"ajaxUser" , methodName : "idCheck" , userId : $(this).val() }, //서버에게 보낼 데이터정보(parameter정보)
				
				success :function(result){
					$("span").text(result);
				} , //성공했을때 실행할 함수 
				
				error : function(err){  
					alert(err+"에러 발생했어요.");
				}  //실패했을때 실행할 함수 
		});//ajax끝
	}); //keyup끝
	////////////////////
	
    }); //ready 끝
	
    </script>
    
  
 </head>
<body>



<c:choose>
	<c:when test="${empty loginUser}">
	<section id="form"><!--form-->
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="signup-form"><!--login form-->
						<h2>회원 가입</h2>
						<form name="join" method="post" action="${pageContext.request.contextPath}/front" onsubmit="return joinCheck()">
						<input type="hidden" name="key" value = "user" /> <!-- Controller를 찾는 정보 -->
						<input type="hidden" name="methodName" value = "join" />  <!-- 메소드이름 -->
							* 이름<input type="text" class="form-control" id="userName" name="userName"
							placeholder="이름" onKeyDown="if(event.keyCode == 13) joinCheck()"/>
							* 아이디<input type="text" class="form-control" id="userId" name="userId"
							placeholder="영문과 숫자만 입력가능합니다" onkeyup="chkCharCode(event)" onKeyDown="if(event.keyCode == 13) joinCheck()"/><span></span><br><br>
							<div class="pw">
							* 비밀번호 <input type="password" class="form-control" id="userPwd" name="userPwd"
							placeholder="비밀번호" onKeyDown="if(event.keyCode == 13) joinCheck()"/>
							<i class="fa fa-eye fa-lg"></i>
							</div><br>
							* 휴대폰번호<input type="text" class="form-control" id="userPhone" name="userPhone"
							placeholder="ex)010-0000-0000" onkeyup="chkPhCode(event)" onKeyDown="if(event.keyCode == 13) joinCheck()"/>
							생년월일<input type="text" class="form-control" id="birth" name="birth"
							placeholder="생년월일 8자리" onkeyup="chkBdCode(event)" maxlength='8'/>
							성별 <select name="gender">
							  <option value=""selected>성별을 선택해주세요</option>
							  <option value="f">여성</option>
							  <option value="m">남성</option>
							</select><br><br>
							주소<input type="text" class="form-control" id="userAddr" name="userAddr"
							placeholder="주소" /><br>
							<button type="button" onclick="joinCheck();" class="btn btn-default">가입하기</button>
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