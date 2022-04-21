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

<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js" ></script>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

function sendUpdate(){
	
	document.requestForm.methodName.value ="updateForm";
	document.requestForm.submit();
}

function sendDelete(){
	if(document.requestForm.password.value==""){
		alert("비밀번호 입력하세요.");
		document.requestForm.password.focus();
		return;
	}
	
	document.requestForm.methodName.value ="delete";
	alert(document.requestForm.password.value);
	document.requestForm.submit();
}
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

					
<table align="center" cellpadding="5" cellspacing="2" width="600" border='1'>
    <tr>
        <td width="1220" height="20" colspan="4" bgcolor="#FE980F">
            <p align="center"><font color="white" size="3"><b>
             게시물 자세히보기</b></font></p>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="center"><b><span style="font-size:9pt;">글번호</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>${qnaDTO.qnaNo}</b></span>
        </td>
    </tr>
     <tr>
        <td width="100" height="20" >
            <p align="center"><b><span style="font-size:9pt;">아이디</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>${qnaDTO.userid}</b></span>
        </td>
    </tr>
    <tr>
        <td width="100" height="20" >
            <p align="center"><b><span style="font-size:9pt;">상품코드</span></b></p>
        </td>
        <td width="300" height="20">
        	<span style="font-size:9pt;"><b>${qnaDTO.goodsCode}</b></span>
        </td>
        <td width="100" height="20" >
			<p align="center"><b><span style="font-size:9pt;">날짜</span></b></p>
		</td>
        <td width="100" height="20">
			<p><b><span style="font-size:9pt;"></span>${qnaDTO.qnaDate}</b></p>
		</td>
    </tr>
    <tr>
        <td width="100" height="20">
            <p align="center"><b><span style="font-size:9pt;">제목</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>${qnaDTO.qnaSubject}</b></span>
        </td>
    </tr>
    <tr>
		<td width="100" height="200" valign="top">
            <p align="center"><b><span style="font-size:9pt;">내 용</span></b></p>
        </td>
		<!-- 브라우저에 글 내용을 뿌려줄 때는 개행문자(\n)가 <br>태그로 변환된 문자열을 보여줘야 한다. -->
        <td width="450" height="200" valign="top" colspan="3">
        <span style="font-size:9pt;"><b><pre>${qnaDTO.qnaContent}</pre></b></span></td>
    </tr>
    
      <c:if test="${qnaDTO.fname!=null}">
       <tr>
        <td width="100" height="20">
            <p align="center"><b><span style="font-size:9pt;">다운로드</span></b></p>
        </td>
        <td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>
        	<a href='${path}/downLoad?fileName=${qnaDTO.qnaImg}'>
    			${qnaDTO.fname} 
      		</a>
      		  ( <fmt:formatNumber value="${qnaDTO.fsize}"/> byte)
        </b></span>
        </td> 
    </tr>
    </c:if>
    
    <tr>
    <td width="100" height="20">
           <p align="center"><b><span style="font-size:9pt;">비밀번호</span></b></p>
        </td>
        
    <form name="requestForm" method=post action="${path}/front">
        <td height="20" colspan="3" align="left" valign="middle">
				<input type=password name="password" value="">		
		</td>
    </tr>
    
    
    <tr>
        <td height="20" colspan="4" align="center" valign="middle">
			<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
				<input type="text" name="qnaNo" value="${qnaDTO.qnaNo}">
				<input type="text" name="key" value=qnaBoard>
				<input type="text" name="methodName" >
				<input type=button value="수정하기" onClick="sendUpdate()">
				<input type=button value="삭제하기" onClick="sendDelete()">
    </form>
			
		</td>
    </tr>
</table>
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