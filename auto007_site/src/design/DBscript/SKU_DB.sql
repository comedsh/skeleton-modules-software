/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/11/25 13:54:01                          */
/*==============================================================*/


drop table if exists catalog;

drop table if exists catalog_attribute;

drop table if exists catalog_sku;


drop table if exists price_strategy;

drop table if exists repertory;

drop table if exists sale_area;


drop table if exists sku;

drop table if exists sku_catalog_attr_value;

drop table if exists sku_comment;

drop table if exists sku_extend_attrs;

drop table if exists sku_image_html;

drop table if exists sku_images;

drop table if exists sku_reply;

drop table if exists sku_stock;

drop table if exists stock_lock;

drop table if exists supplier;

drop table if exists t_order;

drop table if exists vehicle_oe_sku;

/*==============================================================*/
/* Table: catalog                                               */
/*==============================================================*/
create table catalog
(
   id                   bigint not null,
   code                 varchar(20),
   name                 varchar(100),
   parent_id            bigint,
   sort_no              int,
   remark               varchar(100),
   primary key (id),
   unique key AK_code (code)
);

/*==============================================================*/
/* Table: catalog_attribute                                     */
/*==============================================================*/
create table catalog_attribute
(
   id                   bigint not null,
   name                 varchar(100),
   catalog_id           bigint,
   s_no                 int,
   remark               varchar(100),
   primary key (id)
);

/*==============================================================*/
/* Table: catalog_sku                                           */
/*==============================================================*/
create table catalog_sku
(
   catalog_id           bigint,
   sku_id               bigint
);



/*==============================================================*/
/* Table: price_strategy                                        */
/*==============================================================*/
create table price_strategy
(
   id                   bigint not null auto_increment,
   start_time           datetime,
   end_time             datetime,
   amount               int,
   discount             int,
   primary key (id)
);

/*==============================================================*/
/* Table: repertory                                             */
/*==============================================================*/
create table repertory
(
   id                   bigint not null auto_increment,
   name                 int,
   address              int,
   area                 int,
   seller_id            bigint,
   city_region_id       bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: sale_area                                             */
/*==============================================================*/
create table sale_area
(
   id                   bigint not null auto_increment,
   sale_id              bigint not null,
   type                 int comment '1.包含， 2 不包含',
   primary key (id)
);


/*==============================================================*/
/* Table: sku                                                   */
/*==============================================================*/
create table sku
(
   id                   bigint not null auto_increment,
   code                 varchar(20) not null,
   name                 varchar(200),
   title                varchar(200),
   url                  text comment '商品缩略图',
   introduce            text,
   status               int comment '1,待上架，2.已上架 3。已下架，默认 待上架',
   type                 int comment '1.品牌件 , 2 原厂件',
   shelf_time           datetime default CURRENT_TIMESTAMP,
   under_time           datetime,
   produce_time         date,
   down_time            date,
   min_quantity         int,
   gross_weight         double(7,2),
   weight               double(7,2),
   unit                 varchar(10) comment '件，台，支,个',
   brand                varchar(100),
   score                int,
   supplier_id          bigint,
   price                decimal(9,4),
   sale_price           decimal(9,4),
   create_time          datetime default CURRENT_TIMESTAMP,
   update_time          datetime,
   seller_id            char(10),
   primary key (id),
   unique key AK_Key_2 (code)
);

/*==============================================================*/
/* Table: sku_catalog_attr_value                                */
/*==============================================================*/
create table sku_catalog_attr_value
(
   id                   bigint not null,
   catalog_attr_id      bigint,
   sttr_value           varchar(100),
   sku_id               bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: sku_comment                                           */
/*==============================================================*/
create table sku_comment
(
   id                   bigint not null,
   sku_id               bigint,
   order_id             bigint,
   order_detail_id      bigint,
   star                 int comment '1到5个星，>=4,好评  ，3< 差评，3 中评',
   comtent              text,
   user_id              varchar(20),
   create_time          datetime,
   status               int default 1 comment '1 显示，2不显示，默认显示',
   comment_origin       int comment '0, pc ,1.android 2. iphone  ;',
   primary key (id)
);

/*==============================================================*/
/* Table: sku_extend_attrs                                      */
/*==============================================================*/
create table sku_extend_attrs
(
   id                   bigint not null,
   name                 varchar(100),
   contents             varchar(100),
   sort_no              int,
   sku_id               bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: sku_image_html                                        */
/*==============================================================*/
create table sku_image_html
(
   id                   bigint not null,
   contents_html        text,
   sku_id               bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: sku_images                                            */
/*==============================================================*/
create table sku_images
(
   id                   bigint not null,
   url                  text,
   title                char(100),
   sort_no              int,
   create_time          datetime default CURRENT_TIMESTAMP,
   update_time          datetime,
   sku_id               bigint,
   small_url			text,
   primary key (id)
);

/*==============================================================*/
/* Table: sku_reply                                             */
/*==============================================================*/
create table sku_reply
(
   id                   bigint not null,
   reply_code           varchar(20),
   comtent              text,
   create_time          datetime default CURRENT_TIMESTAMP,
   user_id              char(20),
   sku_comment_id       bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: sku_stock                                             */
/*==============================================================*/
create table sku_stock
(
   id                   bigint not null,
   stock_count          int,
   stock_availability   int,
   repertory_id         bigint default NULL,
   sku_id               bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: stock_lock                                            */
/*==============================================================*/
create table stock_lock
(
   id                   bigint not null auto_increment,
   order_id             bigint,
   sku_id               bigint,
   stock_id             bigint,
   nums                 int,
   create_time          datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: supplier                                              */
/*==============================================================*/
create table supplier
(
   id                   bigint not null auto_increment,
   code                 varchar(20),
   name                 varchar(20),
   address              varchar(200),
   fax                  varchar(15),
   telephone            varchar(15),
   mobile_phone         varchar(15),
   primary key (id),
   unique key supplier_code (code)
);

/*==============================================================*/
/* Table: vehicle_oe_sku                                        */
/*==============================================================*/
create table vehicle_oe_sku
(
   id                   bigint not null,
   oe_code              varchar(50),
   vehicle_id           bigint default NULL,
   vehicle_name         varchar(100),
   brand                varchar(20),
   engine               varchar(20),
   period               varchar(20),
   output_value         varchar(10),
   sku_id               bigint,
   primary key (id)
);


