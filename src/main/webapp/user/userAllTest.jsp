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
				<th>아이디</th>
				<th>이름</th>
				<th>연락처</th>
				<th>주소</th>
				<th>생년월일</th>
				<th>성별</th>
			</tr>
			<c:forEach items="${list}" var="users">
				<tr>
					<td>${users.userId}</td>
					<td>${users.userName}</td>
					<td>${users.userPhone}</td>
					<td>${users.userAddr}</td>
					<td>${users.birth}</td>
					<td>${users.gender}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>