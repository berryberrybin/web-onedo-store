<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<jsp:include page="../common/header.jsp"/>

<!DOCTYPE html>
<html>
<head>
	<script src="/controller/resources/js/jquery.form.min.js"></script>
	<style type="text/css">
	
		@font-face {
	    font-family: 'GmarketSansBold';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansBold.woff') format('woff');
	    font-weight: normal;
	    font-style: normal;
	}

		p {
			font-family: GmarketSansBold;
		}
	
	
	</style>
	

</head>
<body>

<div class="container">
	<div class="col-lg-8 col-lg-offset-2 text-center">
		<div class="logo">
			<h1 style="color: #3D3D3D;">Error !<br>
			<i class="fa fa-frown-o" aria-hidden="true"></i>
			</h1>
		</div><br>
		<p class="lead text-muted">${errorMsg} </p>
		<div class="clearfix"></div>
		
		<div class="clearfix"></div>
		<br />
		<c:choose>
		  <c:when test="${empty loginUser}">
		      <div class="col-lg-6  col-lg-offset-3">
			<div class="btn-group btn-group-justified">
				<a href="${pageContext.request.contextPath}/user/login.jsp" class="btn btn-default">로그인</a>
				<a href="javascript:history.back()" class="btn btn-default">뒤로가기</a>
			</div>

		    </div>
		  </c:when>
		  <c:otherwise>
		      <div class="col-lg-6  col-lg-offset-3">
			<div class="btn-group btn-group-justified">
				<a href="javascript:history.back()" class="btn btn-default">뒤로가기</a>
			</div>

		</div>
		  </c:otherwise>
		</c:choose>	
	</div>

</div>

<br><br>

</body>

<jsp:include page="../common/footer.jsp"/>

</html>