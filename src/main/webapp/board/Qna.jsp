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
						<!-- <div class="single-blog-post">
							<h3>Girls Pink T Shirt arrived in store</h3>
							<div class="post-meta">
								<ul>
									<li><i class="fa fa-user"></i> Mac Doe</li>
									<li><i class="fa fa-clock-o"></i> 1:33 pm</li>
									<li><i class="fa fa-calendar"></i> DEC 5, 2013</li>
								</ul>
								<span>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star-half-o"></i>
								</span>
							</div>
							<a href="">
								<img src="images/blog/blog-one.jpg" alt="">
							</a>
							<p>
								Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p> <br>

							<p>
								Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p> <br>

							<p>
								Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.</p> <br>

							<p>
								Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.
							</p>
							<div class="pager-area">
								<ul class="pager pull-right">
									<li><a href="#">Pre</a></li>
									<li><a href="#">Next</a></li>
								</ul>
							</div>
						</div> -->
					</div>
					<!--/blog-post-area-->

					<!-- <div class="rating-area">
						<ul class="ratings">
							<li class="rate-this">Rate this item:</li>
							<li>
								<i class="fa fa-star color"></i>
								<i class="fa fa-star color"></i>
								<i class="fa fa-star color"></i>
								<i class="fa fa-star"></i>
								<i class="fa fa-star"></i>
							</li>
							<li class="color">(6 votes)</li>
						</ul>
						<ul class="tag">
							<li>TAG:</li>
							<li><a class="color" href="">Pink <span>/</span></a></li>
							<li><a class="color" href="">T-Shirt <span>/</span></a></li>
							<li><a class="color" href="">Girls</a></li>
						</ul>
					</div>/rating-area -->

					<!-- <div class="socials-share">
						<a href=""><img src="images/blog/socials.png" alt=""></a>
					</div>/socials-share -->




					<table align="center" border="0" cellpadding="5" cellspacing="2"
						width="100%" bordercolordark="white" bordercolorlight="black">
						<caption>
							<h2 align="center">문의 게시판 LIST</h2>
						</caption>
						<colgroup>
							<col width="7%" />
							<col width="8%" />
							<col width="15%" />
							<col width="30%" />
							<col width="20%" />
							<col width="10%" />
							<col width="10%" />

						</colgroup>
						<tr>
							<td bgcolor="#FE980F">
								<p align="center">
									<font color="white"><b><span style="font-size: 9pt;">글번호</span></b></font>
								</p>
							</td>
							<td bgcolor="#FE980F">
								<p align="center">
									<font color="white"><b><span style="font-size: 9pt;">상품코드</span></b></font>
								</p>
							</td>
							<td bgcolor="#FE980F">
								<p align="center">
									<font color="white"><b><span style="font-size: 9pt;">아이디</span></b></font>
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

							<td bgcolor="#FE980F">
								<p align="center">
									<font color="white"><b><span style="font-size: 9pt;">작성날짜</span></b></font>
								</p>
							</td>
							<td bgcolor="#FE980F">
								<p align="center">
									<font color="white"><b><span style="font-size: 9pt;">파일용량</span></b></font>
								</p>
							</td>
							
						</tr>


						<c:forEach items="${list}" var="qnaBoard">
							<tr>
								<td>${qnaBoard.qnaNo}</td>
								<td>${qnaBoard.goodsCode}</td>
								<td>${qnaBoard.userid}</td>
								<td>${qnaBoard.qnaSubject}</td>
								<td>${qnaBoard.qnaContent}</td>
								<td>${qnaBoard.qnaDate}</td>
								<td>${qnaBoard.qnaImg}</td>
								

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
							href="${path}/board/Qnawriting.jsp">글쓰기</a></span>
					</div>


<jsp:useBean class="onedo.mvc.paging.PageCnt" id="p"/> 
    
   \${p.pageCnt} = ${p.pageCnt} / \${p.blockcount}   = ${p.blockcount}  <p>

 
 <!--  블럭당  -->
 <nav class="pagination-container">
		<div class="pagination">
		<c:set var="doneLoop" value="false"/>
		
		<c:set var="temp" value="${(pageNo-1) % p.blockcount}"/> <!-- (1-1)%2  =0  , (2-1)%2    1 , (3-1)%2  0 -->
		<c:set var="startPage" value="${pageNo - temp}"/> <!--   1- 1 -->
		
	\${pageNo} = ${pageNo} , 	\${temp}=${temp}  ,   \${startPage}=${startPage}  , <br>
	
		  <!-- 
     if( ( 시작페이지 - 한블록당뿌려질[]개수) > 0 ){ // if()
	       [이전]출력한다.	
     } 
     ex) if( ( startPage -blockcount) > 0 ){

          }
		-->
		
		<!-- 
		 시작페이지 구한다(몇번부터 출력할지를 정함 [번호] )
           방법 => int temp=(현재페이지번호-1)% 한블록당 보여질[]개수;
                   int startPage=현재페이지번호 -temp; => 시작번호[]
             
             
					   int temp = (pageNo-1) % p.blockcount ;         //시작 페이지 구하기
				      int startPage = pageNo - temp;
		 -->
		
		  <c:if test="${(startPage-p.blockcount) > 0}"> <!-- (-2) > 0  -->
		      <a class="pagination-newer" href="${path}/front?key=qnaBoard&methodName=qnaSelectAll&pageNo=${startPage-1}">PREV</a>
		  </c:if>
		  
		<span class="pagination-inner"> 
		  <c:forEach var='i' begin='${startPage}' end='${(startPage-1)+p.blockcount}'> 
			  <c:if test="${(i-1)>=p.pageCnt}">
			       <c:set var="doneLoop" value="true"/>
			    </c:if> 
			  <c:if test="${not doneLoop}" >
			         <a class="${i==pageNo?'pagination-active':page}" href="${path}/front?key=qnaBoard&methodName=qnaSelectAll&pageNo=${i}">${i}</a> 
		     </c:if>
		</c:forEach>
		</span> 
				<!-- 
				[다음]
 
					  if( (시작페이지+한블록당뿌려질[]개수)<= 총페이지수){
					      [다음]출력;
					  }  
					
					  ex)if( (startPage+blockCount) <= pageCount){
					
					      }
				 -->
		 <c:if test="${(startPage+p.blockcount)<=p.pageCnt}">
		     <a class="pagination-older" href="${path}/front?key=qnaBoard&methodName=qnaSelectAll&pageNo=${startPage+p.blockcount}">NEXT</a>
		 </c:if>
				 

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