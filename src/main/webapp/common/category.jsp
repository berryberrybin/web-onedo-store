<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	$(function(){
		$("a[name=category-name]").click(function(){
			let goodsType = $(this).attr("id");
			location.href="${path}/front?key=goods&methodName=selectMultipleGoods&searchField=goodsType&searchValue="+goodsType;
		})
	});
</script>
</head>
<body>
	<section>
			<!-- <div class="row"> -->
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#" name="category-name" id="O">원두</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#" name="category-name" id="C">캡슐</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#" name="category-name" id="D">드립백</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">구독</a></h4>
								</div>
							</div>
						</div><!--/category-products-->
</div>
</div>
<!-- </div> -->
</section>

</body>
</html>