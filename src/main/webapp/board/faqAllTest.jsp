<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js" ></script>
		<style type="text/css">
			td{text-align: center;}
		</style>
	</head>
	<body>
		
	<table>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>내용</th>
			
			</tr>
			
			<c:forEach items="${list}" var="faqBoard">
				<tr>
					<td>${faqBoard.faqNo}</td>
					<td>${faqBoard.faqSubject}</td>
					<td>${faqBoard.faqContent}</td>
					
				</tr>
			</c:forEach>
		</table>

	</body>
</html>