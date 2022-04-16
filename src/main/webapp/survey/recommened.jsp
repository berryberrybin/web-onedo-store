<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/header.jsp"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js" ></script>
		<style type="text/css">
			body{text-align: center;}
		</style>
	</head>
	<body>
		<h1>추천목록</h1><br>
		<c:forEach items="${list}" var="reco">
			<div>${reco.goodsCode}</div>
		</c:forEach>
	</body>
	<jsp:include page="../common/footer.jsp"/>
</html>