-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.10 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- --------------------------------------------------------
-- 创建 yunpay 的数据库
drop database if exists yunpay;
create database if not exists yunpay /*! DEFAULT CHARACTER SET utf8 */;
use yunpay;

-- 创建表
drop table if exists t_sys_menu;

drop table if exists t_sys_menu_role;

drop table if exists pms_operator;

drop table if exists pms_operator_log;

drop table if exists pms_permission;

drop table if exists pms_role;

drop table if exists pms_role_operator;

drop table if exists pms_role_permission;

create table t_sys_menu
(
   id                   bigint not null auto_increment,
   version              bigint not null,
   creater              varchar(50) not null comment '创建人',
   create_time          datetime not null comment '创建时间',
   editor               varchar(50) comment '修改人',
   edit_time            datetime comment '修改时间',
   status               varchar(20) not null,
   remark               varchar(300),
   is_leaf              varchar(20),
   level                smallint,
   parent_id            bigint not null,
   target_name          varchar(100),
   number               varchar(20),
   name                 varchar(100),
   url                  varchar(100),
   primary key (id)
)auto_increment = 1000;

alter table t_sys_menu comment '菜单表';


alter table t_sys_menu comment '菜单表';

create table t_sys_menu_role
(
   id                   bigint not null auto_increment comment '主键',
   version              bigint,
   creater              varchar(50) comment '创建人',
   create_time          datetime comment '创建时间',
   editor               varchar(50) comment '修改人',
   edit_time            datetime comment '修改时间',
   status               varchar(20),
   remark               varchar(300),
   role_id              bigint not null,
   menu_id              bigint not null,
   primary key (id),
   key ak_key_2 (role_id, menu_id)
) auto_increment = 1000;

alter table t_sys_menu_role comment '权限与角色关联表';

create table pms_operator
(
   id                   bigint not null auto_increment comment '主键',
   version              bigint not null,
   creater              varchar(50) not null comment '创建人',
   create_time          datetime not null comment '创建时间',
   editor               varchar(50) comment '修改人',
   edit_time            datetime comment '修改时间',
   status               varchar(20) not null,
   remark               varchar(300),
   real_name            varchar(50) not null,
   mobile_no            varchar(15) not null,
   login_name           varchar(50) not null,
   login_pwd            varchar(256) not null,
   type                 varchar(20) not null,
   salt                 varchar(50) not null,
   primary key (id),
   key ak_key_2 (login_name)
) auto_increment = 1000;

alter table pms_operator comment '操作员表';

create table pms_operator_log
(
   id                   bigint not null auto_increment comment '主键',
   version              bigint not null,
   creater              varchar(50) not null comment '创建人',
   create_time          datetime not null comment '创建时间',
   editor               varchar(50) comment '修改人',
   edit_time            datetime comment '修改时间',
   status               varchar(20) not null,
   remark               varchar(300),
   operator_id          bigint not null,
   operator_name        varchar(50) not null,
   operate_type         varchar(50) not null comment '操作类型（1:增加，2:修改，3:删除，4:查询）',
   ip                   varchar(100) not null,
   content              varchar(3000),
   primary key (id)
) auto_increment = 1000;

alter table pms_operator_log comment '权限_操作员操作日志表';

create table pms_permission
(
   id                   bigint not null auto_increment comment '主键',
   version              bigint not null,
   creater              varchar(50) not null comment '创建人',
   create_time          datetime not null comment '创建时间',
   editor               varchar(50) comment '修改人',
   edit_time            datetime comment '修改时间',
   status               varchar(20) not null,
   remark               varchar(300),
   permission_name      varchar(100) not null,
   permission           varchar(100) not null,
   primary key (id),
   key ak_key_2 (permission),
   key ak_key_3 (permission_name)
) auto_increment = 1000;

alter table pms_permission comment '权限表';

create table pms_role
(
   id                   bigint not null auto_increment comment '主键',
   version              bigint,
   creater              varchar(50) comment '创建人',
   create_time          datetime comment '创建时间',
   editor               varchar(50) comment '修改人',
   edit_time            datetime comment '修改时间',
   status               varchar(20),
   remark               varchar(300),
   role_code            varchar(20) not null comment '角色类型（1:超级管理员角色，0:普通操作员角色）',
   role_name            varchar(100) not null,
   primary key (id),
   key ak_key_2 (role_name)
) auto_increment = 1000;

alter table pms_role comment '角色表';

create table pms_role_operator
(
   id                   bigint not null auto_increment comment '主键',
   version              bigint not null,
   creater              varchar(50) not null comment '创建人',
   create_time          datetime not null comment '创建时间',
   editor               varchar(50) comment '修改人',
   edit_time            datetime comment '修改时间',
   status               varchar(20) not null,
   remark               varchar(300),
   role_id              bigint not null,
   operator_id          bigint not null,
   primary key (id),
   key ak_key_2 (role_id, operator_id)
) auto_increment = 1000;

alter table pms_role_operator comment '操作员与角色关联表';

create table pms_role_permission
(
   id                   bigint not null auto_increment comment '主键',
   version              bigint,
   creater              varchar(50) comment '创建人',
   create_time          datetime comment '创建时间',
   editor               varchar(50) comment '修改人',
   edit_time            datetime comment '修改时间',
   status               varchar(20),
   remark               varchar(300),
   role_id              bigint not null,
   permission_id        bigint not null,
   primary key (id),
   key ak_key_2 (role_id, permission_id)
) auto_increment = 1000;

alter table pms_role_permission comment '权限与角色关联表';





-- ------------------------------step 1  菜单-------------------------------------------------
-- 菜单初始化数据
--  -- 菜单的初始化数据
insert into t_sys_menu (id,version,status,creater,create_time, editor, edit_time, remark, name, url, number, is_leaf, level, parent_id, target_name) values 
(1,0, 'ACTIVE','admin','2016-06-03 11:07:43', 'admin','2016-06-03 11:07:43', '', '权限管理', '##', '001', 'NO', 1, 0, '#'),
(2,0, 'ACTIVE','admin','2016-06-03 11:07:43', 'admin','2016-06-03 11:07:43', '', '菜单管理', 'pms/menu/list', '00101', 'YES', 2, 1, 'cdgl'),
(3,0, 'ACTIVE','admin','2016-06-03 11:07:43', 'admin','2016-06-03 11:07:43', '', '权限管理', 'pms/permission/list', '00102', 'YES',2, 1, 'qxgl'),
(4,0, 'ACTIVE','admin','2016-06-03 11:07:43', 'admin','2016-06-03 11:07:43', '', '角色管理', 'pms/role/list', '00103', 'YES',2, 1, 'jsgl'),
(5,0, 'ACTIVE','admin','2016-06-03 11:07:43', 'admin','2016-06-03 11:07:43', '', '操作员管理', 'pms/operator/list', '00104', 'YES',2, 1, 'czygl');

-- ------------------------------step 2：权限功能点-------------------------------------------------
-- 权限功能点的初始化数据


insert into pms_permission (id,version,status,creater,create_time, editor, edit_time, remark, permission_name, permission) values 
 (1, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-菜单-查看','权限管理-菜单-查看','pms:menu:view'),
 (2, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-菜单-添加','权限管理-菜单-添加','pms:menu:add'),
 (3, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-菜单-查看','权限管理-菜单-修改','pms:menu:edit'),
 (4, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-菜单-删除','权限管理-菜单-删除','pms:menu:delete'),

 (11, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-权限-查看','权限管理-权限-查看','pms:permission:view'),
 (12, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-权限-添加','权限管理-权限-添加','pms:permission:add'),
 (13, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-权限-修改','权限管理-权限-修改','pms:permission:edit'),
 (14, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-权限-删除','权限管理-权限-删除','pms:permission:delete'),

 (21, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-角色-查看','权限管理-角色-查看','pms:role:view'),
 (22, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-角色-添加','权限管理-角色-添加','pms:role:add'),
 (23, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-角色-修改','权限管理-角色-修改','pms:role:edit'),
 (24, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-角色-删除','权限管理-角色-删除','pms:role:delete'),
 (25, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-角色-分配权限','权限管理-角色-分配权限','pms:role:assignpermission'),

 (31, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-操作员-查看','权限管理-操作员-查看','pms:operator:view'),
 (32, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-操作员-添加','权限管理-操作员-添加','pms:operator:add'),
 (33, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-操作员-查看','权限管理-操作员-修改','pms:operator:edit'),
 (34, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-操作员-冻结与解冻','权限管理-操作员-冻结与解冻','pms:operator:changestatus'),
 (35, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','权限管理-操作员-重置密码','权限管理-操作员-重置密码','pms:operator:resetpwd');

-- -----------------------------------step3：操作员--------------------------------------------
-- -- 操作员的初始化数据
--  admin 超级管理员
insert into pms_operator (id,version,status,creater,create_time, editor, edit_time, remark, login_name, login_pwd,real_name,mobile_no,type,salt) 
values (1, 0, 'ACTIVE','admin','2016-06-03 11:07:43', 'admin','2016-06-03 11:07:43', '超级管理员', 'admin', 'd3c59d25033dbf980d29554025c23a75','超级管理员', '18620936193', 'ADMIN','8d78869f470951332959580424d4bf4f');

--  guest  游客
insert into pms_operator (id,version,status,creater,create_time, editor, edit_time, remark, login_name, login_pwd,real_name,mobile_no,type,salt) 
values (2, 0, 'ACTIVE','admin','2016-06-03 11:07:43', 'guest','2016-06-03 11:07:43', '游客', 'guest', '3f0dbf580ee39ec03b632cb33935a363','游客', '18926215592', 'USER','183d9f2f0f2ce760e98427a5603d1c73');

-- ------------------------------------step4：角色-------------------------------------------
-- -- 角色的初始化数据
insert into pms_role (id,version,status,creater,create_time, editor, edit_time, remark, role_code, role_name) 
values (1, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'admin', '2016-06-03 11:07:43','超级管理员角色','admin', '超级管理员角色');

insert into pms_role (id,version,status,creater,create_time, editor, edit_time, remark, role_code, role_name) 
values (2, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'guest', '2016-06-03 11:07:43','游客角色','guest', '游客角色');

-- ------------------------------------step5：操作员和角色关联-------------------------------------------
-- -- 操作员与角色关联的初始化数据

--  admin  关联admin 和test两个角色
insert into pms_role_operator (id,version,status,creater,create_time, editor, edit_time, remark,role_id,operator_id) values (1, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','',1,1);
insert into pms_role_operator (id,version,status,creater,create_time, editor, edit_time, remark,role_id,operator_id) values (2, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','',2,1);

-- guest  关联游客角色  （游客角色只有查看交易记录的信息）
insert into pms_role_operator (id,version,status,creater,create_time, editor, edit_time, remark,role_id,operator_id) values (3, 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','',2,2);

-- -------------------------------------step6：角色和权限关联------------------------------------------
-- -- 角色与用户功能点关联的初始化数据

-- admin（拥有所有的权限点）
insert into pms_role_permission  (role_id, permission_id) select 1,id from PMS_PERMISSION;


-- guest （只有所有的查看权限）
insert into pms_role_permission (version,status,creater,create_time, editor, edit_time, remark,role_id,permission_id) 
values 
 ( 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','',2,1),
 ( 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','',2,11),
 ( 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','',2,21),
 ( 0,'ACTIVE', 'admin','2016-06-03 11:07:43', 'test', '2016-06-03 11:07:43','',2,31);
-- -------------------------------------step7：角色和菜单关联------------------------------------------
--  角色与信息关联初始化数据
-- admin

insert into t_sys_menu_role(role_id, menu_id) select 1,id from t_sys_menu;

-- guest  所有的菜单（只有查看权限）
insert into t_sys_menu_role (role_id, menu_id) select 2,id from t_sys_menu;