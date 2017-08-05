--用户表
drop table pms_operator;
CREATE TABLE  pms_operator (
   id number NOT NULL  ,
   version  number NOT NULL,
   creater  varchar(50) NOT NULL  ,
   create_time  date default sysdate NOT NULL  ,
   editor  varchar(50) DEFAULT NULL  ,
   edit_time  date default sysdate   ,
   status  varchar(20) NOT NULL,
   remark  varchar(300)  ,
   real_name  varchar(50) NOT NULL,
   mobile_no  varchar(15) NOT NULL,
   login_name  varchar(50) NOT NULL,
   login_pwd  varchar(256) NOT NULL,
   type  varchar(20) NOT NULL,
   salt  varchar(50) NOT NULL
);
alter table pms_operator
  add constraint PK_pms_operator primary key (id);
--创建sequence 
drop sequence seq_pms_operator;
create sequence seq_pms_operator
start with 1
increment by 1;

--角色表
drop table pms_role;
CREATE TABLE   pms_role  (
   id  number NOT NULL ,
   version number  ,
   creater  varchar(50)   ,
   create_time  date default sysdate   ,
   editor  varchar(50)   ,
   edit_time  date default sysdate   ,
   status  varchar(20)  ,
   remark  varchar(300)  ,
   role_code  varchar(20) NOT NULL ,
   role_name  varchar(100) NOT NULL
);
alter table pms_role
  add constraint PK_pms_role primary key (id);
--创建sequence 
drop sequence seq_pms_role;
create sequence seq_pms_role
start with 1
increment by 1;
  
--用户角色表
drop table pms_role_operator;
CREATE TABLE  pms_role_operator  (
   id  number NOT NULL ,
   version number NOT NULL,
   creater  varchar(50) NOT NULL,
   create_time  date default sysdate NOT NULL,
   editor  varchar(50)  ,
   edit_time  date default sysdate  ,
   status  varchar(20) NOT NULL,
   remark  varchar(300)  ,
   role_id  number NOT NULL,
   operator_id  number NOT NULL
);
alter table pms_role_operator
  add constraint PK_pms_role_operator primary key (id);
--创建sequence 
drop sequence seq_pms_role_operator;
create sequence seq_pms_role_operator
start with 1
increment by 1;

--菜单表
drop table t_sys_menu;
CREATE TABLE t_sys_menu (
  id number NOT NULL ,
  version number NOT NULL,
  creater varchar(50) NOT NULL ,
  create_time date default sysdate NOT NULL ,
  editor varchar(50)  ,
  edit_time date default sysdate   ,
  status varchar(20) NOT NULL,
  remark varchar(300)  ,
  is_leaf varchar(20)  ,
  pm_level number  ,
  parent_id number NOT NULL,
  target_name varchar(100)  ,
  pm_number varchar(20)  ,
  name varchar(100)  ,
  url varchar(100)  
);
alter table t_sys_menu
  add constraint PK_t_sys_menu primary key (id);
--创建sequence 
drop sequence seq_t_sys_menu;
create sequence seq_t_sys_menu
start with 1
increment by 1;
  
--角色菜单表
drop table t_sys_menu_role;
CREATE TABLE  t_sys_menu_role  (
   id  number NOT NULL ,
   version  number  ,
   creater  varchar(50)   ,
   create_time  date default sysdate   ,
   editor  varchar(50)   ,
   edit_time  date default sysdate   ,
   status  varchar(20)  ,
   remark  varchar(300)  ,
   role_id  number NOT NULL,
   menu_id number NOT NULL
);
alter table t_sys_menu_role
  add constraint PK_t_sys_menu_role primary key (id);
--创建sequence 
drop sequence seq_t_sys_menu_role;
create sequence seq_t_sys_menu_role
start with 1
increment by 1;


--权限表 
drop table pms_permission;
CREATE TABLE  pms_permission  (
   id number NOT NULL ,
   version  number NOT NULL,
   creater  varchar(50) NOT NULL,
   create_time  date default sysdate NOT NULL,
   editor  varchar(50)  ,
   edit_time  date default sysdate  ,
   status  varchar(20) NOT NULL,
   remark  varchar(300)  ,
   permission_name  varchar(100) NOT NULL,
   permission  varchar(100) NOT NULL
);
alter table pms_permission
  add constraint PK_pms_permission primary key (id);
--创建sequence 
drop sequence seq_pms_permission;
create sequence seq_pms_permission
start with 1
increment by 1;


--角色权限表
drop table pms_role_permission;
CREATE TABLE  pms_role_permission  (
   id number NOT NULL ,
   version  number  ,
   creater  varchar(50)  ,
   create_time  date default sysdate   ,
   editor  varchar(50)  ,
   edit_time  date default sysdate   ,
   status  varchar(20)  ,
   remark  varchar(300)  ,
   role_id  number NOT NULL,
   permission_id number NOT NULL
);
alter table pms_role_permission
  add constraint PK_pms_role_permission primary key (id);
--创建sequence 
drop sequence seq_pms_role_permission;
create sequence seq_pms_role_permission
start with 1
increment by 1;

  
--日志表  
drop table pms_operator_log;
CREATE TABLE pms_operator_log  (
   id number NOT NULL ,
   version  number NOT NULL,
   creater  varchar(50) NOT NULL ,
   create_time  date default sysdate NOT NULL ,
   editor  varchar(50)  ,
   edit_time  date default sysdate  ,
   status  varchar(20) NOT NULL,
   remark  varchar(300)  ,
   operator_id  number NOT NULL,
   operator_name  varchar(50) NOT NULL,
   operate_type  varchar(50) NOT NULL ,
   ip  varchar(100) NOT NULL,
   content  varchar(3000)  
);
alter table pms_operator_log
  add constraint PK_pms_operator_log primary key (id);
--创建sequence 
drop sequence seq_pms_operator_log;
create sequence seq_pms_operator_log
start with 1
increment by 1;  
  
  
  

  
