drop table users;
drop table goods_type;
drop sequence goods_seq;
drop table goods;
drop table goods_attr;
--drop sequence sub_goods_seq;
--drop table sub_goods;
drop table orders;
drop table order_state;
drop table board_type;
drop table board;
drop table orderline;
--drop sequence sub_goods_seq;
--drop table sub_orderline;
drop table refund;
drop sequence answer_board_seq;
drop sequence notice_board_seq;
drop sequence faq_board_seq;
drop table qna_board;
drop table answer_board;
drop table review_board;
drop table notice_board;
drop table faq_board;
commit;
--<회원>------------------------------------------------------------------------

--회원
create table users(
  user_id varchar2(10) primary key, --회원아이디
  user_pwd varchar2(10) not null, --비밀번호
  user_name varchar2(10) not null,--이름
  user_phone varchar2(13) not null, --연락처 010-0000-0000
  user_addr varchar2(100), --주소
  birth date, --생년월일
  gender varchar2(1) --성별 f,m
);

insert into users values('admin', '9999', '관리자', '999-9999-9999', null, '99/01/01', null);
insert into users values('jina', '1111', '김진아', '010-0000-0000', '경기도 성남시 분당구 구미동', '94/11/11' , 'f');
insert into users values('jung', '1234', '이정아', '010-1111-1111', '서울특별시 중구 남대문로1가','95/02/22', 'f');
insert into users values('sunj', '1234', '김순주', '010-2222-2222','경기도 수원시 권선구 고색동', '96/12/15', 'm' );
insert into users values('suub', '1234', '문수빈', '010-3333-3333', '충청남도 공주시 검상동','97/05/21','f' );
insert into users values('wooj', '1234', '정우진', '010-4444-4444', '강원도 원주시 관설동', '98/10/30' , 'm');
insert into users values('sjng', '1234', '최선정', '010-5555-5555', '제주 서귀포시 중앙동','99/04/21','f' );

select * from users;
commit;
--<상품>------------------------------------------------------------------------

--상품타입
create table goods_type(
    goods_type varchar2(1) constraint goods_type_pk primary key, --상품타입
    type_name varchar2(9) --타입명
);
insert into goods_type values('O', '원두');
insert into goods_type values('C', '캡슐');
insert into goods_type values('D', '드립백');

select * from goods_type;

--상품
--is_soldout : 0이면 품절아님, 1이면 품절. default는 0(품절아님)
--재고량, 가격 : 0이상
--상품코드 규칙 : 타입 + 순서, ex) 원두타입 두번째 상품 O02, 캡슐타입 세번째 상품 C03
create sequence goods_seq;
create table goods(
    goods_code number constraint goods_code_pk primary key, --상품코드
    goods_type varchar2(1) constraint goods_type_fk references goods_type(goods_type) on delete cascade not null, --상품타입
    goods_name varchar2(40) not null, --상품명
    goods_price number check(goods_price>0) not null, --상품가격
    goods_stock number check(goods_stock>=0) not null,
    goods_detail varchar2(100) not null, --상세정보
    is_soldout number(1) default 0 check(is_soldout=0 or is_soldout=1) not null, --품절여부
    goods_view number default 0, --조회수
    goods_image varchar2(20) --이미지
);
insert into goods values(goods_seq.nextval, 'O', '에티오피아 예가체프', 12000, 100, '꿀처럼 달콤한 맛과 싱그러운 산미의 조화', default, default, null);

select * from goods;

commit;
--상품특징 (맛 특성 범위 : 0~5)
create table goods_attr(
    goods_code number primary key,
    sour number check(sour>=0 and sour<=5), --산미
    sweet number check(sweet>=0 and sweet<=5), --단맛
    aroma number check(aroma>=0 and aroma<=5), --향미
    balance number check(balance>=0 and balance<=5), --균형
    
    constraint goods_code_pk_fk foreign key(goods_code) references goods(goods_code) on delete cascade
);
insert into goods_attr values(1, 4.5, 4, 5, 2.5);

select * from goods_attr;

--구독상품
/*
create sequence sub_goods_seq;
create table sub_goods(
    sub_goods_code number primary key, --구독상품코드
    sub_goods_name varchar2(40), --구독상품명
    sub_goods_price number check(sub_goods_price>0), --구독상품가격
    sub_goods_detail varchar(100), --구독상품상세정보
    sub_goods_view number default 0, --조회수
    sub_goods_image varchar2(20) --이미지
);
insert into sub_goods values(sub_goods_seq.nextval, '10%할인 구독상품', 28000, '3가지 상품을 10% 할인된 가격에 구독하세요.', default, null);

select * from sub_goods;
*/
--<주문>------------------------------------------------------------------------

--주문상태
create table order_state(
  state_no number primary key,--주문상태번호
  state varchar2(20) not null --주문상태
);


insert into order_state values('0', '결제완료');
insert into order_state values('1', '배송완료');

select * from order_state;
commit;
--주문
create table orders(
  order_code number primary key, -- 주문코드
  state_no number not null,--주문상태번호
  user_id varchar2(10) not null, --아이디
  order_date date not null, --주문일자
  order_addr varchar2(100) not null,--배송지
  order_phone varchar2(13) not null,--연락처
  order_price number check(order_price>0) not null, --총결제금액
  freq varchar2(1) not null, --배송주기
  
  constraint fk_user_id foreign key(user_id) references users(user_id),
  constraint fk_state_no foreign key(state_no) references order_state(state_no)
);

--주문상세테이블
create table orderline(
    orderline_code number constraint orderline_code_pk primary key, --주문상세코드
    order_code number, --결제코드
    goods_code number, --상품코드
    order_qty number(2) check(order_qty>0), --주문수량
    
    constraint orderline_ordercode_fk foreign key(order_code) references orders(order_code) on delete cascade,
    constraint orderline_goodscode_fk foreign key(goods_code) references goods(goods_code) on delete cascade
);
commit;
--insert into payment value('20220411001', 0, admin, sysdate, default, '010-1111-1111', ); 
--insert into orderline values(orderline_seq, );

select * from users;
select * from payment;
select * from orderline;


--구독주문상세테이블
/*
create table sub_orderline(
    sub_orderline_code varchar2(4) constraint sub_orderline_code_pk primary key, --구독주문상세코드
    sub_goods_code number,--구독주문상품코드
    goods_code1 number not null, --상품코드1
    goods_code2 number not null, --상품코드2
    goods_code3 number not null, --상품코드3
    payment_code number not null, --결제코드
    sub_cycle char(1) check(sub_cycle in (1,2,3,4)), --배송주기
    sub_state char(1) check(sub_state=1 or sub_state=0), --구독상태 1이면 구독함, 0이면 구독안함
    
    constraint subline_paycode_fk foreign key(payment_code) references payment(payment_code) on delete cascade,
    constraint subline_goodscode1_fk foreign key(goods_code1) references goods(goods_code) on delete cascade,
    constraint subline_goodscode2_fk foreign key(goods_code2) references goods(goods_code) on delete cascade,
    constraint subline_goodscode3_fk foreign key(goods_code3) references goods(goods_code) on delete cascade
);
*/

--환불테이블
create table refund(
    refund_code number constraint refund_code_pk primary key, --환불코드
    orderline_code number not null, --주문상세코드
    refund_reason varchar2(100) not null, --환불사유
    refund_state varchar2(1) not null, --환불상태
    refund_date date not null, --환불신청날짜
    refund_price number check(refund_price>0) not null,
    
    constraint refund_orderlinecode_fk foreign key(orderline_code) references orderline(orderline_code)
);
commit;
/*
create sequence orders_seq
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    MAXVALUE 9999
    NOCYCLE
    NOCACHE
    NOORDER;
*/

--<게시판>----------------------------------------------------------------------

--문의
create table qna_board (
    qna_no number primary key, --글번호
	goods_code number NOT NULL, --상품코드
	user_id varchar2(10) not null, --작성자
	qna_subject	varchar2(40) not null, --제목
	qna_content	varchar2(1000) not null, --내용
	qna_date date not null, --날짜
	qna_img	varchar2(20), --이미지
	qna_pwd	varchar2(4) not null, --비밀번호
    
    constraint qna_goodscode_fk foreign key(goods_code) references goods(goods_code),
    constraint QnA_userid_fk foreign key(user_id) references users(user_id)
);
commit;

--문의답변
create sequence answer_board_seq;
create table answer_board (
	answer_no number primary key, --답변글번호
	qna_no number NOT NULL, --부모글번호
	answer_content varchar2(1000) not null, --내용
    
    constraint answer_qnano_fk foreign key(qna_no) references qna_board(qna_no)
);

--후기
create table review_board (
	review_no number primary key, --글번호
	goods_code number not null, --상품코드
	user_id varchar2(10) not null, --작성자
	review_subject varchar2(40) not null, --제목
	review_content varchar2(1000) not null, --내용
	review_date date not null, --날짜
	review_img varchar2(20), --이미지
	review_score number(1) check(review_score in (1,2,3,4,5)) not null, --별점
    
    constraint review_goodscode_fk foreign key(goods_code) references goods(goods_code),
    constraint review_userid_fk foreign key(user_id) references users(user_id)
);

--공지게시판
create sequence notice_board_seq;
create table notice_board(
	notice_no number primary key, --글번호
	notice_subject varchar2(40) not null, --제목
	notice_content varchar2(1000) not null, --내용
	notice_date date not null, --날짜
	notice_img varchar2(20) --이미지
);

--faq게시판
create sequence faq_board_seq;
create table faq_board(
	faq_no number primary key, --글번호
	faq_subject varchar2(40) not null, --제목
	faq_content varchar2(1000) not null --내용
);
--------------------------------------------------------------------------------

commit;
