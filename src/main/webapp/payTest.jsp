<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- jQuery --> 
	    <script type="text/javascript" src="js/jquery-3.6.0.min.js" ></script> 
		<!-- iamport.payment.js --> 
	    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
		
		<script type="text/javascript">
		//문서가 준비되면 제일 먼저 실행
			$(document).ready(function(){ 
				$("#iamportPayment").click(function(){ 
					iamport(); //버튼 클릭하면 호출 
			    }); 
			})
	
	
			function iamport(){
				//가맹점 식별코드
				IMP.init('imp81895788');
				IMP.request_pay({
				    pg : 'kcp',
				    pay_method : 'card',
				    merchant_uid : 'merchant_' + new Date().getTime(),
				    name : '상품1' , //결제창에서 보여질 이름
				    amount : 100, //실제 결제되는 가격
				    buyer_email : 'iamport@siot.do',
				    buyer_name : '구매자이름',
				    buyer_tel : '010-1234-5678',
				    buyer_addr : '서울 강남구 도곡동',
				    buyer_postcode : '123-456'
				}, function(rsp) {
					console.log(rsp);
				    if ( rsp.success ) {
				    	var msg = '결제가 완료되었습니다.';
				        msg += '고유ID : ' + rsp.imp_uid;
				        msg += '상점 거래ID : ' + rsp.merchant_uid;
				        msg += '결제 금액 : ' + rsp.paid_amount;
				        msg += '카드 승인번호 : ' + rsp.apply_num;
				    } else {
				    	 var msg = '결제에 실패하였습니다.';
				         msg += '에러내용 : ' + rsp.error_msg;
				    }
				    alert(msg);
				});
			}
		</script>
	</head>
	<body>
		
				
	    <div> 
	        <h2>IAMPORT 결제 데모</h2> 
	        <li> 
	           	<button id = "iamportPayment">결제하기</button>
	        </li> 
	    </div> 
	</body>
</html>