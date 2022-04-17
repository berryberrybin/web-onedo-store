<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:include page="../common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<meta charset="UTF-8">

<style type="text/css">
	nav nav-pills nav-stacked active{color: red}


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
					<h5><li><a href="#"><i class="fa fa-user"></i>   ${loginUser.userId}님</a></li></h5>
				</c:if>
              <p></p>
          </div>

          <ul class="nav nav-pills nav-stacked">
              <li class="active"><a href="#"> <i class="fa fa-user"></i> 회원 정보</a></li>
              <li><a href="#"> <i class="fa fa-file-text"></i> 내 글 보기</a></li>
              <li><a href="#"> <i class="fa fa-edit"></i> 회원 정보 수정</a></li>
          </ul>
      </div>
  </div>
  <div class="profile-info col-md-9">
      <div class="panel">
          <div class="bio-graph-heading">
              최근 주문 내역
          </div>

    </div>
</div>

  <div class="profile-info col-md-9">
      <div class="panel">
          <div class="bio-graph-heading">
              나의 장바구니
          </div>

    </div>
</div>

                      
          </div>
     </div>


</body>
	<jsp:include page="../common/footer.jsp"/>
</html>