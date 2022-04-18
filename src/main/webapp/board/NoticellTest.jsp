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
				<th>작성일</th>
				<th>이미지</th>
			
			</tr>
			
			<c:forEach items="${list}" var="noticeBoard">
				<tr>
					<td>${noticeBoard.noticeNo}</td>
					<td>${noticeBoard.noticeSubject}</td>
					<td>${noticeBoard.noticeContent}</td>
					<td>${noticeBoard.noticeDate}</td>
					<td>${noticeBoard.noticeImg}</td>
				
					
				</tr>
			</c:forEach>
		</table>

	</body>
</html>