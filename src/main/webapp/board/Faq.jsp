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
</head>
<script type="text/javascript">
 	$(function(){
 		$(document).on("click",function(){
				let goodsCode = $(this).attr("name");
				
 		})
 		
 		//현재페이지 a태그에 active속성 주기
 		
 	});
 </script>
<!--/head-->
<style>
.listTable {
	width: 100%
}

th, td {
	border: 1px gray solid;
	text-align: center;
	padding: 3px
}
</style>
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

					<table align="center" border="0" cellpadding="5" cellspacing="2"
						width="100%" bordercolordark="white" bordercolorlight="black">
						<caption>
							<h2 align="center">자주 묻는 질문</h2>
						</caption>
						<colgroup>

							<col width="15%" />
							<col width="30%" />
							<col width="50%" />


						</colgroup>
						<tr>
							<td bgcolor="#FE980F">
								<p align="center">
									<font color="white"><b><span style="font-size: 9pt;">글번호</span></b></font>
								</p>
							</td>

							<td bgcolor="#FE980F">
								<p align="center">
									<font color="white"><b><span style="font-size: 9pt;">제목</span></b></font>
								</p>
							</td>
							<td bgcolor="#FE980F">
								<p align="center">
									<font color="white"><b><span style="font-size: 9pt;">내용</span></b></font>
								</p>
							</td>


						</tr>


						<c:forEach items="${list}" var="faqBoard">
							<tr>
								<td>${faqBoard.faqNo}</td>
								<td>
								<a href="${path}/front?key=faqBoard&methodName=selectByFaqCode&faqNo=${faqBoard.faqNo}&pageNo=${pageNo}">
								${faqBoard.faqSubject} 
								</a>
								</td>
								<td>${faqBoard.faqContent}</td>


							</tr>
						</c:forEach>

						<c:choose>
							<c:when test="${empty requestScope.list}">
								<tr>
									<td colspan="7">
										<p align="center">
											<b><span style="font-size: 9pt;">등록된 문의 없습니다.</span></b>
										</p>
									</td>
								</tr>
							</c:when>
							<c:otherwise>

							</c:otherwise>
						</c:choose>
					</table>	

					<div align=right>
						<span style="font-size: 9pt;"><a class="btn btn-primary"
							href="${path}/writing.jsp">글쓰기</a></span>
					</div>


<jsp:useBean class="onedo.mvc.paging.PageCnt" id="p"/> 
     
 <!--  블럭당  -->
 <nav class="pagination-container">
		<ul class="pagination">
		<c:set var="doneLoop" value="false"/>
		
		<c:set var="temp" value="${(pageNo-1) % p.blockcount}"/> <!-- (1-1)%2  =0  , (2-1)%2    1 , (3-1)%2  0 -->
		<c:set var="startPage" value="${pageNo - temp}"/> <!--   1- 1 -->
	
		  <c:if test="${(startPage-p.blockcount) > 0}"> <!-- (-2) > 0  -->
		      <li><a class="pagination-newer" href="${path}/front?key=faqBoard&methodName=faqSelectAll&pageNo=${startPage-1}">&laquo;</a></li>
		  </c:if>
		  
	
		  <c:forEach var='i' begin='${startPage}' end='${(startPage-1)+p.blockcount}'> 
			  <c:if test="${(i-1)>=p.pageCnt}">
			       <c:set var="doneLoop" value="true"/>
			    </c:if> 
			  <c:if test="${not doneLoop}" >
			         <li><a class="${i==pageNo?'pagination-active':page}" href="${path}/front?key=faqBoard&methodName=faqSelectAll&pageNo=${i}">${i}</a> </li>
		     </c:if>
		</c:forEach>
		
	
				
		 <c:if test="${(startPage+p.blockcount)<=p.pageCnt}">
		     <li><a class="pagination-older" href="${path}/front?key=faqBoard&methodName=faqSelectAll&pageNo=${startPage+p.blockcount}">&raquo;</a></li>
		 </c:if>
					</ul>
				</nav>
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