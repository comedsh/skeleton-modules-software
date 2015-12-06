/*==============================================================*/
/* Database name:  Auto007                                      */
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015-10-21 15:59:52                          */
/*==============================================================*/


drop database if exists Auto007;

/*==============================================================*/
/* Database: Auto007                                            */
/*==============================================================*/
create database Auto007;

use Auto007;

/*==============================================================*/
/* Table: City_Area                                             */
/*==============================================================*/
create table City_Area
(
   ID                   varchar(10) not null,
   Parent_ID            varchar(10),
   Area_Code            varchar(6) not null,
   Name                 varchar(20) not null,
   Level                smallint not null,
   FullName             varchar(60) not null,
   Available            boolean not null,
   primary key (ID)
);

/*==============================================================*/
/* Index: City_Code_idx                                         */
/*==============================================================*/
create unique index City_Code_idx on City_Area
(
   Area_Code
);

/*==============================================================*/
/* Table: Company                                               */
/*==============================================================*/
create table Company
(
   ID                   bigint not null auto_increment,
   Compnay_Name         varchar(0) not null,
   Headcount            int,
   City_ID              varchar(10),
   Business_Licence     varchar(100) not null,
   Taxpayer_Licence     varchar(100) not null,
   Taxpayer_Number      varchar(20) not null,
   Contacts_Name        varchar(20) not null,
   Contacts_Phone       varchar(15) not null,
   Contacts_Mobile      varchar(15) not null,
   Contacts_Dept        varchar(50),
   Contacts_Email       varchar(100),
   primary key (ID)
);

/*==============================================================*/
/* Index: Company_Name_idx                                      */
/*==============================================================*/
create unique index Company_Name_idx on Company
(
   Compnay_Name
);

/*==============================================================*/
/* Index: Taxpayer_Num_idx                                      */
/*==============================================================*/
create unique index Taxpayer_Num_idx on Company
(
   Taxpayer_Number
);

/*==============================================================*/
/* Table: Payment_Type                                          */
/*==============================================================*/
create table Payment_Type
(
   ID                   int not null auto_increment,
   TypeName             varchar(20) not null,
   Description          varchar(100),
   NeedApprove          char not null default 'Y',
   primary key (ID)
);

/*==============================================================*/
/* Table: Role                                                  */
/*==============================================================*/
create table Role
(
   ID                   int not null auto_increment,
   Name                 varchar(10) not null,
   Description          varchar(100),
   primary key (ID)
);

/*==============================================================*/
/* Index: Name_idx                                              */
/*==============================================================*/
create unique index Name_idx on Role
(
   Name
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   ID                   bigint not null auto_increment,
   Name                 varchar(20) not null,
   Password             varchar(100),
   Email                varchar(100),
   MobilePhone          varchar(20),
   QQ_Number            varchar(15),
   WeChat               varchar(20),
   Role                 int,
   Level                int,
   Company              bigint,
   primary key (ID)
);

/*==============================================================*/
/* Index: QQ_Number_idx                                         */
/*==============================================================*/
create index QQ_Number_idx on User
(
   QQ_Number
);

/*==============================================================*/
/* Index: Wechat_idx                                            */
/*==============================================================*/
create index Wechat_idx on User
(
   WeChat
);

/*==============================================================*/
/* Table: User_Address                                          */
/*==============================================================*/
create table User_Address
(
   ID                   bigint not null auto_increment,
   User_ID              bigint not null,
   Alias                varchar(20) not null,
   City_ID              varchar(10),
   Detail_Addr          varchar(200) not null,
   Receiver_Name        varchar(40) not null,
   Receiver_Mobile      varchar(20) not null,
   "Default"            boolean not null,
   primary key (ID)
);

/*==============================================================*/
/* Index: UserID_idx                                            */
/*==============================================================*/
create index UserID_idx on User_Address
(
   User_ID
);

/*==============================================================*/
/* Table: User_Level                                            */
/*==============================================================*/
create table User_Level
(
   ID                   int not null auto_increment,
   Previous_ID          int,
   Name                 varchar(20) not null,
   Description          varchar(100),
   primary key (ID)
);

/*==============================================================*/
/* Table: User_Payment_Type                                     */
/*==============================================================*/
create table User_Payment_Type
(
   PaymentType_ID       int not null,
   User_ID              bigint not null,
   Status               int not null,
   primary key (PaymentType_ID, User_ID)
);

/*==============================================================*/
/* Index: UserID_idx                                            */
/*==============================================================*/
create index UserID_idx on User_Payment_Type
(
   User_ID
);

alter table City_Area add constraint FK_City_Parent_FK foreign key (Parent_ID)
      references City_Area (ID) on delete restrict on update restrict;

alter table Company add constraint FK_Company_City_FK foreign key (City_ID)
      references City_Area (ID) on delete restrict on update restrict;

alter table User add constraint FK_User_Company_FK foreign key (Company)
      references Company (ID) on delete restrict on update restrict;

alter table User add constraint FK_User_Role_FK foreign key (Role)
      references Role (ID) on delete restrict on update restrict;

alter table User add constraint FK_User_UserLev_FK foreign key (Level)
      references User_Level (ID) on delete restrict on update restrict;

alter table User_Address add constraint FK_User_Addr_City_FK foreign key (City_ID)
      references City_Area (ID) on delete restrict on update restrict;

alter table User_Address add constraint FK_User_Addr_User_FK foreign key (User_ID)
      references User (ID) on delete restrict on update restrict;

alter table User_Level add constraint FK_User_Lev_Prev_FK foreign key (Previous_ID)
      references User_Level (ID) on delete restrict on update restrict;

alter table User_Payment_Type add constraint FK_User_PayType_PayType_FK foreign key (PaymentType_ID)
      references Payment_Type (ID) on delete restrict on update restrict;

alter table User_Payment_Type add constraint FK_User_PayType_User_FK foreign key (User_ID)
      references User (ID) on delete restrict on update restrict;

