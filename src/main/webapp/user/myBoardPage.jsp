<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:include page="../common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>ONE DO</title>
<link href="${path}/css/bootstrap.min.css" rel="stylesheet">
<link href="${path}/css/font-awesome.min.css" rel="stylesheet">
<link href="${path}/css/prettyPhoto.css" rel="stylesheet">
<link href="${path}/css/price-range.css" rel="stylesheet">
<link href="${path}/css/animate.css" rel="stylesheet">
<link href="${path}/css/main.css" rel="stylesheet">
<link href="${path}/css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="${path}images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="${path}/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${path}/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="${path}/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed" href="${path}/images/ico/apple-touch-icon-57-precomposed.png">


<style type="text/css">
	nav nav-pills nav-stacked active{color: red}
	
	@font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
}
	
	h4{
		color: #B45F04;
		font-family:Pretendard-Regular;
	}

	td {
		text-align: center;
	}
	
</style>

</head>
<body>
<div class="container bootstrap snippets bootdey">
<div class="row">
  <div class="profile-nav col-md-3">
      <div class="panel">
          <div class="user-heading round">
              <!-- <h5>사용자 아이디</h5> -->
				<c:if test="${not empty loginUser}">
					<h4><i class="fa fa-user"></i>&nbsp;&nbsp;${loginUser.userId}님 환영합니다</h4>
				</c:if>
				<hr>
              <p></p>
          </div>

          <ul class="nav nav-pills nav-stacked">
              <li><a href="${path}/user/modify.jsp"> <i class="fa fa-edit"></i>&nbsp;&nbsp;내 정보 수정</a></li>
              <li><a href="${path}/front?key=user&methodName=myBoard"> <i class="fa fa-file-text"></i>&nbsp;&nbsp;내가 쓴 글 보기</a></li>
          </ul>
      </div>
  </div>
  <div class="profile-info col-md-9">
      <div class="panel">
          <div class="bio-graph-heading">
            <h4>나의 게시물</h4>
            <hr>
            <table class="table">
					<thead>
						<tr class="cart_menu">
							<td class="boardNo">글 번호</td>
							<td class="goodsCode">문의 상품 코드</td>
							<td class="subject">제목</td>
							<td class="date">작성일</td>
							<td class="id">아이디</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					<c:choose>
							<c:when test="${empty requestScope.myBoard}">
								<tr>
									<td colspan="5">
										<p align="center">
											<b><span style="font-size: 9pt;"> 작성한 글이 없습니다. </span></b>
										</p>
									</td>
								</tr>
							</c:when>
							<c:otherwise>
							<c:forEach items="${requestScope.myBoard}" var="QnaDTO">
							<tr>
								<td class="boardNo">
									<p>${QnaDTO.qnaNo}</p>
								</td>
								<td class="goodsCode">
									<p>${QnaDTO.goodsCode}</p>
								</td>
								<td class="qnaSub">
									<a href="${path}/front?key=Qna&methodName=selectByQnaCode&orderCode=${QnaDTO.qnaNo}">
									${QnaDTO.qnaSubject}</a>
								</td>
								<td class="qnaDate">
									<p>${QnaDTO.qnaDate}</p>
								</td>
								<td class="userId">
									<p>${QnaDTO.userid}</p>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
					</tbody>
			</table>
          </div><br>
      </div>
      
 	</div> <!-- 최근 주문 내역 끝 -->

</div>
</div> <!-- 부트스트랩 끝 -->
</body>
	<jsp:include page="../common/footer.jsp"/>
</html>