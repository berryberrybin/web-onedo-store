<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
	</head>
	<body>
		<h1>추천목록</h1><br>
		${requestScope.list}
		<c:forEach items="${list}" var="reco">
			<div>${reco.goodsCode}</div>
		</c:forEach>
	</body>
</html>