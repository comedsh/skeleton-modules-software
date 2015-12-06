/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/11/24 15:05:24                          */
/*==============================================================*/


drop table if exists bill_order;

drop table if exists shopping_cart;

drop table if exists order_image;

drop table if exists order_header;

drop table if exists order_invoice;

drop table if exists order_item;

drop table if exists order_master;

drop table if exists order_payment;

drop table if exists order_task;

drop table if exists order_track;

drop table if exists order_transport;

drop table if exists order_transport_detail;

drop table if exists order_pay_trade;

drop table if exists quality_order;

drop table if exists quality_order_detail;

drop table if exists refund_bill;

drop table if exists refund_order;

drop table if exists refund_order_detail;

drop table if exists refund_track;

drop table if exists transaction_flow;

drop table if exists waybill_track;

/*==============================================================*/
/* Table: bill_order                                            */
/*==============================================================*/
create table bill_order
(
   id                   bigint not null auto_increment,
   bill_no              varchar(32) not null,
   buyer_id             bigint not null,
   seller_id            bigint not null,
   start_date           date not null,
   end_date             date not null,
   in_amount            decimal(18,4) not null,
   out_amount           decimal(18,4) not null,
   bill_amount          decimal(18,4) not null,
   status               int not null comment '10：已汇总，20：已审核，30：已结算',
   in_qty               int not null,
   out_qty              int not null,
   sum_operator_id      bigint not null,
   sum_time             datetime not null,
   review_id            bigint,
   review_time          datetime,
   review_note          varchar(200),
   payer_id             bigint,
   payed_time           datetime,
   payed_note           varchar(200),
   primary key (id)
);

/*==============================================================*/
/* Table: shopping_cart                                               */
/*==============================================================*/
CREATE TABLE `shopping_cart` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `buyer_id` bigint(20) NOT NULL,
  `seller_id` bigint(20) NOT NULL,
  `sku_id` bigint(20) NOT NULL,
  `original_price` decimal(18,4) NOT NULL,
  `sale_price` decimal(18,4) NOT NULL,
  `current_price` decimal(18,4) NOT NULL,
  `discount_strategy_desc` varchar(200) DEFAULT NULL,
  `qty` int(11) NOT NULL,
  `last_price_time` datetime DEFAULT NULL,
  `add_time` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_buyer_id` (`buyer_id`),
  KEY `idx_sku_id` (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Index: idx_buyer_id                                          */
/*==============================================================*/
create index idx_cart_id on shopping_cart
(
   buyer_id
);

/*==============================================================*/
/* Index: idx_sku_id                                            */
/*==============================================================*/
create index idx_sku_id on shopping_cart
(
   sku_id
);

/*==============================================================*/
/* Table: image                                                 */
/*==============================================================*/
create table order_image
(
   id                   bigint not null auto_increment,
   biz_type             int not null,
   biz_id               bigint not null,
   path                 varchar(100) not null,
   entry_id             bigint,
   entry_time           datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_biz_id_type                                       */
/*==============================================================*/
create index idx_biz_id_type on order_image
(
   biz_type,
   biz_id
);


/*==============================================================*/
/* Table: order_header                                          */
/*==============================================================*/
create table order_header
(
   id                   bigint not null auto_increment,
   order_no             varchar(32) not null,
   status               int not null,
   fork_status          int,
   buyer_id             bigint not null,
   seller_id            bigint not null,
   warehouse_id         bigint,
   master_order_id      bigint,
   total_amount         decimal(18,4) not null,
   discount_amount      decimal(18,4) not null,
   need_pay_amount      decimal(18,4) not null,
   transport_amount     decimal(18,4) not null,
   payed_amount         decimal(18,4) not null,
   pay_method           int not null,
   pay_status           int not null,
   delivery_method      int not null,
   create_time          datetime not null,
   pay_time             datetime,
   confirm_time         datetime,
   send_time            datetime,
   receive_delay_times  int,
   receive_expire_time  datetime,
   received_time        datetime,
   city_id              bigint not null,
   sender               varchar(32),
   sender_address       varchar(128),
   receiver             varchar(32) not null,
   receiver_phone       varchar(20) not null,
   receiver_idcard      varchar(32),
   receiver_address     varchar(128) not null,
   invoice_flag         int not null,
   come_from            int not null,
   evaluated_flag       int,
   remark               varchar(200),
   evaluated_time       datetime,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_order_no                                          */
/*==============================================================*/
create unique index idx_order_no on order_header
(
   order_no
);

/*==============================================================*/
/* Index: idx_seller_id                                         */
/*==============================================================*/
create index idx_seller_id on order_header
(
   seller_id
);

/*==============================================================*/
/* Index: idx_buyer_id                                          */
/*==============================================================*/
create index idx_buyer_id on order_header
(
   buyer_id
);

/*==============================================================*/
/* Table: order_invoice                                         */
/*==============================================================*/
create table order_invoice
(
   id                   bigint not null auto_increment,
   order_id             bigint not null,
   value_add_id         bigint,
   invoice_type         int not null,
   title                varchar(128),
   content_type         int,
   content              varchar(200),
   rec_contact          varchar(32),
   rec_contact_phone    varchar(20),
   rec_address          varchar(200),
   rec_zipcode          varchar(8),
   status                   int not null comment '0：新建，1：打印，2：发送',
   entry_time           datetime not null,
   printer_id           bigint,
   printer_name         varchar(32),
   print_time           datetime,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_order_id                                          */
/*==============================================================*/
create index idx_order_id on order_invoice
(
   order_id
);

/*==============================================================*/
/* Table: order_item                                            */
/*==============================================================*/
create table order_item
(
   id                   bigint not null auto_increment,
   order_id             bigint not null,
   seller_id            bigint not null,
   buyer_id             bigint not null,
   sku_id               bigint not null,
   sku_code             varchar(32),
   sku_name             varchar(150),
   original_price       decimal(18,4) not null,
   sale_price           decimal(18,4) not null,
   trade_price          decimal(18,4) not null,
   qty                  int not null,
   status               int not null,
   fork_status          int,
   note                 varchar(128),
   evaluated_flag       int,
   evaluated_time       datetime,
   entry_id             bigint,
   entry_date           datetime not null,
   edit_id              bigint,
   edit_date            datetime,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_order_id                                          */
/*==============================================================*/
create index idx_order_id on order_item
(
   order_id
);

/*==============================================================*/
/* Index: idx_buyer_id                                          */
/*==============================================================*/
create index idx_buyer_id on order_item
(
   buyer_id
);

/*==============================================================*/
/* Index: idx_seller_id                                         */
/*==============================================================*/
create index idx_seller_id on order_item
(
   seller_id
);

/*==============================================================*/
/* Table: order_master                                          */
/*==============================================================*/
create table order_master
(
   ID                   bigint not null auto_increment,
   master_order_no      varchar(32) not null,
   status               int not null,
   buyer_id             bigint not null,
   seller_id            bigint,
   total_amount         decimal(18,4) not null,
   discount_amount      decimal(18,4) not null,
   transport_amount     decimal(18,4) not null,
   need_pay_amount      decimal(18,4) not null,
   payed_amount         decimal(18,4) not null,
   pay_method           int not null,
   pay_status           int not null,
   create_time          datetime not null,
   pay_time             datetime,
   city_id              bigint not null,
   come_from            int not null,
   order_qty            int,
   primary key (ID)
);

/*==============================================================*/
/* Index: idx_master_no                                         */
/*==============================================================*/
create unique index idx_master_no on order_master
(
   master_order_no
);

/*==============================================================*/
/* Index: idx_buyer_id                                          */
/*==============================================================*/
create index idx_buyer_id on order_master
(
   buyer_id
);

/*==============================================================*/
/* Table: order_payment                                         */
/*==============================================================*/
create table order_payment
(
   id                   bigint not null auto_increment,
   pay_no               varchar(32) not null,
   master_order_id      bigint not null,
   master_order_no      varchar(32) not null,
   trade_no             varchar(60) not null,
   need_pay_amount      decimal(18,4) not null,
   payed_amount         decimal(18,4) not null,
   refund_amount        decimal(18,4),
   pay_status           int not null,
   pay_method           int not null,
   account_type         int,
   account_name         int,
   bank_code            varchar(32),
   account_no           int,
   submit_time          datetime not null,
   payed_time           datetime,
   payee_id             bigint,
   payee_name           varchar(32),
   payee_time           datetime,
   buyer_id             bigint not null,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_order_id                                          */
/*==============================================================*/
create index idx_order_id on order_payment
(
   master_order_id
);

/*==============================================================*/
/* Index: idx_master_order_no                                   */
/*==============================================================*/
create index idx_master_order_no on order_payment
(
   master_order_no
);

/*==============================================================*/
/* Index: idx_pay_no                                            */
/*==============================================================*/
create unique index idx_pay_no on order_payment
(
   pay_no
);

/*==============================================================*/
/* Table: order_task                                            */
/*==============================================================*/
create table order_task
(
   task_id              bigint not null auto_increment,
   order_id             bigint not null,
   order_no             varchar(32) not null,
   type                 int not null comment '10：新订单未支付取消任务；20：自动审核任务；30：收货自动确任务',
   status               int not null,
   begin_time           datetime,
   expire_time          datetime,
   handle_type          int not null,
   handler              varchar(100) not null,
   handle_times         int,
   entry_id             bigint,
   entry_time           datetime not null,
   processor_id         bigint,
   process_time         datetime,
   primary key (task_id)
);

/*==============================================================*/
/* Index: idx_order_id                                          */
/*==============================================================*/
create index idx_order_id on order_task
(
   order_id
);

/*==============================================================*/
/* Index: idx_order_no                                          */
/*==============================================================*/
create index idx_order_no on order_task
(
   order_no
);

/*==============================================================*/
/* Table: order_track                                           */
/*==============================================================*/
create table order_track
(
   id                   bigint not null auto_increment,
   order_id             bigint not null,
   order_no             varchar(32) not null,
   order_status         int not null,
   content              varchar(200),
   track_time           datetime not null,
   operator_id          bigint not null,
   operator_name        varchar(32) not null,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_order_id                                          */
/*==============================================================*/
create index idx_order_id on order_track
(
   order_id
);

/*==============================================================*/
/* Table: order_transport                                       */
/*==============================================================*/
create table order_transport
(
   id                   bigint not null auto_increment,
   order_id             bigint not null,
   order_no             varchar(32) not null,
   waybill_no           varchar(60) not null,
   logistics_com_id     bigint,
   logistics_com_code   varchar(32),
   logistics_com_name   varchar(150),
   status               int not null,
   entry_id             bigint,
   entry_time           datetime not null,
   update_id            bigint,
   update_time          datetime,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_order_id                                          */
/*==============================================================*/
create index idx_order_id on order_transport
(
   order_id,
   waybill_no
);

/*==============================================================*/
/* Index: idx_waybill_no                                        */
/*==============================================================*/
create unique index idx_waybill_no on order_transport
(
   waybill_no
);

/*==============================================================*/
/* Table: order_transport_detail                                */
/*==============================================================*/
create table order_transport_detail
(
   id                   bigint not null auto_increment,
   transport_id         bigint not null,
   order_item_id        bigint not null,
   sku_id               bigint not null,
   sku_code             varchar(32),
   sku_name             varchar(150),
   qty                  int not null,
   entry_id             bigint not null,
   entry_time           datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_waybill_id                                        */
/*==============================================================*/
create index idx_waybill_id on order_transport_detail
(
   transport_id
);

/*==============================================================*/
/* Index: idx_sku_id                                            */
/*==============================================================*/
create index idx_sku_id on order_transport_detail
(
   sku_id
);

/*==============================================================*/
/* Index: idx_order_item_id                                     */
/*==============================================================*/
create index idx_order_item_id on order_transport_detail
(
   order_item_id
);

/*==============================================================*/
/* Table: order_pay_trade                                       */
/*==============================================================*/
create table order_pay_trade
(
   id                   bigint not null auto_increment,
   order_payment_id     bigint not null,
   order_payment_sub_no varchar(32) not null comment '子号码作为支付平台使用的商户订单号，多次提交产生多个子号',
   pay_method           int not null,
   pay_status           int not null comment '0：待支付，10：已支付，-10：已取消',
   trade_no             varchar(60) not null,
   submit_time          datetime not null,
   pay_time             datetime,
   cancel_time          datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: quality_order                                         */
/*==============================================================*/
create table quality_order
(
   id                   bigint not null auto_increment,
   quality_no           varchar(32) not null,
   buyer_id             bigint not null,
   seller_id            bigint not null,
   order_id             bigint not null,
   order_no             varchar(32),
   process_desc         varchar(200),
   auditor_id           bigint not null,
   audit_time           datetime not null,
   processor_id         bigint not null,
   process_time         datetime not null,
   applicant_id         bigint,
   apply_time           bigint not null,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_quality_order_no                                  */
/*==============================================================*/
create unique index idx_quality_order_no on quality_order
(
   quality_no
);

/*==============================================================*/
/* Index: idx_buyer_id                                          */
/*==============================================================*/
create index idx_buyer_id on quality_order
(
   buyer_id
);

/*==============================================================*/
/* Index: idx_seller_id                                         */
/*==============================================================*/
create index idx_seller_id on quality_order
(
   seller_id
);

/*==============================================================*/
/* Index: idx_order_id                                          */
/*==============================================================*/
create index idx_order_id on quality_order
(
   order_id
);

/*==============================================================*/
/* Index: idx_order_no                                          */
/*==============================================================*/
create index idx_order_no on quality_order
(
   order_no
);

/*==============================================================*/
/* Table: quality_order_detail                                  */
/*==============================================================*/
create table quality_order_detail
(
   id                   bigint not null auto_increment,
   quality_id           bigint not null,
   quality_no           varchar(32) not null,
   order_item_id        bigint not null,
   sku_id               bigint not null,
   sku_code             varchar(32),
   sku_name             varchar(150),
   qty                  int not null,
   problem_desc         varchar(200),
   process_desc         varchar(200),
   processor_id         bigint,
   process_time         datetime,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_quality_order_id                                  */
/*==============================================================*/
create index idx_quality_order_id on quality_order_detail
(
   quality_id
);

/*==============================================================*/
/* Index: idx_order_item_id                                     */
/*==============================================================*/
create index idx_order_item_id on quality_order_detail
(
   order_item_id
);

/*==============================================================*/
/* Index: idx_sku_id                                            */
/*==============================================================*/
create index idx_sku_id on quality_order_detail
(
   sku_id
);

/*==============================================================*/
/* Table: refund_bill                                           */
/*==============================================================*/
create table refund_bill
(
   id                   bigint not null auto_increment,
   rebill_no            varchar(32) not null,
   retrade_no           varchar(32),
   refund_id            bigint not null,
   refund_no            varchar(32) not null,
   order_id             bigint not null,
   order_no             varchar(32) not null,
   buyer_id             bigint not null,
   seller_id            bigint not null,
   status               int not null,
   refund_amount        decimal(18,4) not null,
   act_refund_mount     decimal(18,4) not null,
   refund_method        int not null,
   pay_method           int,
   account_type         int,
   account_name         int,
   bank_code            varchar(32),
   account_no           int,
   payed_time           datetime,
   process_content      varchar(200),
   processor_id         bigint,
   audit_time           datetime,
   submit_id            bigint,
   submit_time          datetime not null,
   remark               varchar(200),
   trade_no             varchar(60),
   refund_time          datetime,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_refund_no                                         */
/*==============================================================*/
create index idx_refund_no on refund_bill
(
   refund_no
);

/*==============================================================*/
/* Index: idx_order_id                                          */
/*==============================================================*/
create index idx_order_id on refund_bill
(
   order_id
);

/*==============================================================*/
/* Index: idx_order_no                                          */
/*==============================================================*/
create index idx_order_no on refund_bill
(
   order_no
);

/*==============================================================*/
/* Index: idx_retrade_no                                        */
/*==============================================================*/
create index idx_retrade_no on refund_bill
(
   retrade_no
);

/*==============================================================*/
/* Table: refund_order                                          */
/*==============================================================*/
create table refund_order
(
   id                   bigint not null auto_increment,
   refund_no            varchar(32) not null,
   buyer_id             bigint not null,
   seller_id            bigint not null,
   order_id             bigint not null,
   warehouse_id         bigint,
   type                 int not null comment '10：取消，20：退款，30：退货，40：换货',
   reason_codes         varchar(200) not null,
   reason_desc          varchar(200),
   status               int not null,
   order_amount         decimal(18,4) not null,
   deduct_amount        decimal(18,4) not null,
   freight_amount       decimal(18,4) not null,
   refund_amount        decimal(18,4) not null,
   act_refund_mount     decimal(18,4),
   refund_status        int not null,
   re_receive_person    varchar(32),
   re_receive_phone     varchar(20),
   re_receive_address   varchar(200),
   audit_content        varchar(200),
   auditor_id           bigint,
   audit_time           datetime,
   applicant_id         bigint,
   apply_time           bigint not null,
   refund_method        int,
   pay_method           int,
   account_type         int,
   account_name         int,
   bank_code            varchar(32),
   account_no           int,
   primary key (id)
);

alter table refund_order comment '取消、退款、退货、换货单
';

/*==============================================================*/
/* Index: idx_refund_no                                         */
/*==============================================================*/
create unique index idx_refund_no on refund_order
(
   refund_no
);

/*==============================================================*/
/* Index: idx_order_id                                          */
/*==============================================================*/
create index idx_order_id on refund_order
(
   order_id
);

/*==============================================================*/
/* Index: idx_buyer_id                                          */
/*==============================================================*/
create index idx_buyer_id on refund_order
(
   buyer_id
);

/*==============================================================*/
/* Index: idx_seller_id                                         */
/*==============================================================*/
create index idx_seller_id on refund_order
(
   seller_id
);

/*==============================================================*/
/* Table: refund_order_detail                                   */
/*==============================================================*/
create table refund_order_detail
(
   id                   bigint not null auto_increment,
   refund_id            bigint not null,
   order_item_id        bigint not null,
   sku_id               bigint not null,
   sku_code             varchar(32),
   sku_name             varchar(150),
   sku_qty              int not null,
   reason_codes         varchar(200) not null,
   reason_desc          varchar(200),
   status               int not null,
   order_amount         decimal(18,4) not null,
   deduct_amount        decimal(18,4) not null,
   refund_amount        decimal(18,4) not null,
   audit_content        varchar(200),
   auditor_id           bigint,
   audit_time           datetime,
   applicant_id         bigint,
   apply_time           bigint not null,
   primary key (id)
);

alter table refund_order_detail comment '退换货才有明细';

/*==============================================================*/
/* Index: idx_refund_id                                         */
/*==============================================================*/
create index idx_refund_id on refund_order_detail
(
   refund_id
);

/*==============================================================*/
/* Index: idx_order_item_id                                     */
/*==============================================================*/
create index idx_order_item_id on refund_order_detail
(
   order_item_id
);

/*==============================================================*/
/* Index: idx_sku_id                                            */
/*==============================================================*/
create index idx_sku_id on refund_order_detail
(
   sku_id
);

/*==============================================================*/
/* Table: refund_track                                          */
/*==============================================================*/
create table refund_track
(
   id                   bigint not null auto_increment,
   refund_id            bigint not null,
   refund_no            varchar(32) not null,
   refund_status        int not null,
   content              varchar(200),
   track_time           datetime not null,
   operator_id          bigint not null,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_refund_id                                         */
/*==============================================================*/
create index idx_refund_id on refund_track
(
   refund_id
);

/*==============================================================*/
/* Index: idx_refund_no                                         */
/*==============================================================*/
create index idx_refund_no on refund_track
(
   refund_no
);

/*==============================================================*/
/* Table: transaction_flow                                      */
/*==============================================================*/
create table transaction_flow
(
   id                   bigint not null auto_increment,
   tran_type            int not null comment '1：收款，2：退款',
   biz_order_id         bigint not null comment '支付单ID、退款单ID',
   master_order_id      bigint not null,
   master_order_no      varchar(32) not null,
   order_id             bigint not null,
   order_no             varchar(32) not null,
   buyer_id             bigint not null,
   seller_id            bigint not null,
   tran_method          int not null comment '支付宝、微信支付',
   trade_no             varchar(60) not null,
   tran_amount          decimal(18,4) not null,
   status               int not null comment '0：新建，10：已汇总',
   operator_id          bigint not null,
   tran_time            datetime not null,
   bill_id              bigint,
   sum_operator_id      bigint,
   sum_time             datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: waybill_track                                         */
/*==============================================================*/
create table waybill_track
(
   id                   bigint not null auto_increment,
   transport_id         bigint not null,
   waybill_no           varchar(32) not null,
   waybill_status       varchar(200),
   content              varchar(200),
   track_time           datetime not null,
   operator_id          bigint not null,
   operator_name        varchar(32) not null,
   primary key (id)
);

/*==============================================================*/
/* Index: idx_waybill_id                                        */
/*==============================================================*/
create index idx_waybill_id on waybill_track
(
   transport_id
);
