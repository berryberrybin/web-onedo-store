CREATE TABLE `Users` (
	`user_id`	varchar2(10)	NOT NULL,
	`user_pwd`	varchar2(10)	NULL,
	`user_name`	varchar2(10)	NULL,
	`user_phone`	char(13)	NULL,
	`user_addr`	varchar2(100)	NULL,
	`birth`	date	NULL,
	`gender`	varchar(3)	NULL,
	`sub_state`	char(1)	NULL
);

CREATE TABLE `goods` (
	`goods_code`	number	NOT NULL	COMMENT 'goods_seq 사용
음수 x',
	`goods_type`	char(1)	NOT NULL	COMMENT '1 : 원두
2 : 캡슐
3 : 드립백',
	`goods_name`	varchar2(40)	NULL,
	`goods_price`	varchar2(7)	NULL	COMMENT 'check(goods_price>=0)',
	`goods_stock`	VARCHAR(255)	NULL,
	`goods_detail`	varchar2(100)	NULL,
	`is_soldout`	char(1)	NULL	COMMENT '0 : 품절아님
1: 품절임
check(goods_stock>=0)',
	`goods_view`	varchar2(2)	NULL,
	`goods_image`	varchar2	NULL
);

CREATE TABLE `orders` (
	`order_code`	varchar2(12)	NULL,
	`state_no`	number	NULL,
	`user_id`	varchar2(10)	NOT NULL,
	`order_date`	date	NULL,
	`order_addr`	varchar2(100)	NULL,
	`order_phone`	char(13)	NULL,
	`total_price`	varchar2(7)	NULL,
	`freq`	char(1)	NULL
);

CREATE TABLE `goods_type` (
	`goods_type`	char(1)	NOT NULL	COMMENT '1 : 원두
2 : 캡슐
3 : 드립백',
	`type_name`	varchar2(9)	NULL	COMMENT '원두, 캡슐, 드립백'
);

CREATE TABLE `orderline` (
	`orderline_code`	varchar2(12)	NULL,
	`payment_code`	varchar2(12)	NULL,
	`goods_code`	number(3)	NOT NULL,
	`order_qty`	number(2)	NULL	COMMENT '1이상 99이하'
);

CREATE TABLE `Order_state` (
	`state_no`	number	NULL,
	`state`	varchar2(20)	NULL
);

CREATE TABLE `review` (
	`review_no`	number	NOT NULL,
	`goods_code`	number(3)	NOT NULL	COMMENT 'goods_seq 사용
음수 x',
	`user_id`	varchar2(10)	NOT NULL,
	`review_subject`	varchar2(40)	NULL,
	`review_content`	varchar2(1000)	NULL,
	`review_date`	date	NULL,
	`review_img`	varchar(30)	NULL,
	`review_score`	char(1)	NULL
);

CREATE TABLE `goods_attr` (
	`goods_code`	number	NOT NULL,
	`sour`	number	NULL,
	`sweet`	number	NULL,
	`aroma`	number	NULL,
	`balance`	number	NULL
);

CREATE TABLE `refund` (
	`refund_code`	varchar2(12)	NOT NULL,
	`orderline_code`	varchar2(4)	NULL,
	`refund_reason`	varchar2(100)	NULL,
	`refund_state`	VARCHAR(255)	NULL,
	`refund_date`	date	NULL,
	`refund_price`	varchar2(7)	NULL
);

CREATE TABLE `FAQ` (
	`faq_no`	number	NOT NULL,
	`faq_subject`	varchar2(40)	NULL,
	`faq_content`	varchar2(1000)	NULL
);

CREATE TABLE `notice` (
	`notice_no`	number	NOT NULL,
	`notice_subject`	varchar2(40)	NULL,
	`notice_content`	varchar2(1000)	NULL,
	`notice_date`	date	NULL,
	`notice_img`	varchar(30)	NULL
);

CREATE TABLE `Q&A` (
	`qna_no`	number	NOT NULL,
	`user_id`	varchar2(10)	NOT NULL,
	`goods_code`	number	NOT NULL	COMMENT 'goods_seq 사용
음수 x',
	`qna_pwd`	varchar2	NULL,
	`qna_subject`	varchar2(40)	NULL,
	`qna_content`	varchar2(1000)	NULL,
	`qna__date`	date	NULL,
	`qna_img`	varchar(30)	NULL,
	`qna_state`	boolean	NULL
);

CREATE TABLE `answer` (
	`answer_no`	number	NOT NULL,
	`qna_no`	number	NOT NULL,
	`answer_content`	varchar2(1000)	NULL
);

ALTER TABLE `Users` ADD CONSTRAINT `PK_USERS` PRIMARY KEY (
	`user_id`
);

ALTER TABLE `goods` ADD CONSTRAINT `PK_GOODS` PRIMARY KEY (
	`goods_code`
);

ALTER TABLE `orders` ADD CONSTRAINT `PK_ORDERS` PRIMARY KEY (
	`order_code`
);

ALTER TABLE `goods_type` ADD CONSTRAINT `PK_GOODS_TYPE` PRIMARY KEY (
	`goods_type`
);

ALTER TABLE `orderline` ADD CONSTRAINT `PK_ORDERLINE` PRIMARY KEY (
	`orderline_code`
);

ALTER TABLE `Order_state` ADD CONSTRAINT `PK_ORDER_STATE` PRIMARY KEY (
	`state_no`
);

ALTER TABLE `review` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
	`review_no`
);

ALTER TABLE `goods_attr` ADD CONSTRAINT `PK_GOODS_ATTR` PRIMARY KEY (
	`goods_code`
);

ALTER TABLE `refund` ADD CONSTRAINT `PK_REFUND` PRIMARY KEY (
	`refund_code`
);

ALTER TABLE `FAQ` ADD CONSTRAINT `PK_FAQ` PRIMARY KEY (
	`faq_no`
);

ALTER TABLE `notice` ADD CONSTRAINT `PK_NOTICE` PRIMARY KEY (
	`notice_no`
);

ALTER TABLE `Q&A` ADD CONSTRAINT `PK_Q&A` PRIMARY KEY (
	`qna_no`
);

ALTER TABLE `answer` ADD CONSTRAINT `PK_ANSWER` PRIMARY KEY (
	`answer_no`
);

ALTER TABLE `goods_attr` ADD CONSTRAINT `FK_goods_TO_goods_attr_1` FOREIGN KEY (
	`goods_code`
)
REFERENCES `goods` (
	`goods_code`
);

