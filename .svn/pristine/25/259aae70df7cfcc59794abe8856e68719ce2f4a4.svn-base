--用户表数据
DELETE FROM  pms_operator ;
INSERT INTO  pms_operator  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  real_name ,  mobile_no ,  login_name ,  login_pwd ,  type ,  salt ) VALUES
(seq_pms_operator.nextval, 0, 'admin',  'admin',  'ACTIVE', '超级管理员', '超级管理员', '18620936193', 'admin', 'd3c59d25033dbf980d29554025c23a75', 'ADMIN', '8d78869f470951332959580424d4bf4f');
commit;
--角色表数据
DELETE FROM  pms_role ;
INSERT INTO  pms_role  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  role_code ,  role_name ) VALUES
(seq_pms_role.nextval, 0, 'admin',  'admin',  'ACTIVE', '超级管理员角色', 'admin', '超级管理员角色');
commit;
  
--用户角色表数据
DELETE FROM  pms_role_operator ;
INSERT INTO  pms_role_operator  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  role_id ,  operator_id ) VALUES
(seq_pms_role_operator.nextval, 0, 'admin',  'test',  'ACTIVE', '', 1, 1);
commit;

--菜单表数据
DELETE FROM  t_sys_menu ;
INSERT INTO  t_sys_menu  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  is_leaf ,  pm_level ,  parent_id ,  target_name ,  pm_number ,  name ,  url ) VALUES
(seq_t_sys_menu.nextval, 0, 'admin',   'admin',   'ACTIVE', '', 'NO', 1, 0, '#', '001', '权限管理', '##');
INSERT INTO  t_sys_menu  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  is_leaf ,  pm_level ,  parent_id ,  target_name ,  pm_number ,  name ,  url ) VALUES
(seq_t_sys_menu.nextval, 0, 'admin',   'admin',   'ACTIVE', '', 'YES', 2, 1, 'cdgl', '00101', '菜单管理', 'pms/menu/list');
INSERT INTO  t_sys_menu  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  is_leaf ,  pm_level ,  parent_id ,  target_name ,  pm_number ,  name ,  url ) VALUES
(seq_t_sys_menu.nextval, 0, 'admin',   'admin',   'ACTIVE', '', 'YES', 2, 1, 'qxgl', '00102', '权限管理', 'pms/permission/list');
INSERT INTO  t_sys_menu  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  is_leaf ,  pm_level ,  parent_id ,  target_name ,  pm_number ,  name ,  url ) VALUES
(seq_t_sys_menu.nextval, 0, 'admin',   'admin',   'ACTIVE', '', 'YES', 2, 1, 'jsgl', '00103', '角色管理', 'pms/role/list');
INSERT INTO  t_sys_menu  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  is_leaf ,  pm_level ,  parent_id ,  target_name ,  pm_number ,  name ,  url ) VALUES
(seq_t_sys_menu.nextval, 0, 'admin',   'admin',   'ACTIVE', '', 'YES', 2, 1, 'czygl', '00104', '操作员管理', 'pms/operator/list');
commit;


--角色菜单表
DELETE FROM  t_sys_menu_role ;
INSERT INTO  t_sys_menu_role  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  role_id ,  menu_id ) VALUES
(seq_t_sys_menu_role.nextval,  NULL, NULL, NULL, NULL, NULL, 1, 1);
INSERT INTO  t_sys_menu_role  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  role_id ,  menu_id ) VALUES
(seq_t_sys_menu_role.nextval,  NULL, NULL, NULL, NULL, NULL, 1, 2);
INSERT INTO  t_sys_menu_role  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  role_id ,  menu_id ) VALUES
(seq_t_sys_menu_role.nextval,  NULL, NULL, NULL, NULL, NULL, 1, 3);
INSERT INTO  t_sys_menu_role  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  role_id ,  menu_id ) VALUES
(seq_t_sys_menu_role.nextval,  NULL, NULL, NULL, NULL, NULL, 1, 4);
INSERT INTO  t_sys_menu_role  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  role_id ,  menu_id ) VALUES
(seq_t_sys_menu_role.nextval,  NULL, NULL, NULL, NULL, NULL, 1, 5);
commit;

--角色菜单表
DELETE FROM  pms_permission ;
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-菜单-查看', '权限管理-菜单-查看', 'pms:menu:view');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES 
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-菜单-添加', '权限管理-菜单-添加', 'pms:menu:add');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-菜单-查看', '权限管理-菜单-修改', 'pms:menu:edit');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-菜单-删除', '权限管理-菜单-删除', 'pms:menu:delete');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-权限-查看', '权限管理-权限-查看', 'pms:permission:view');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-权限-添加', '权限管理-权限-添加', 'pms:permission:add');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-权限-修改', '权限管理-权限-修改', 'pms:permission:edit');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-权限-删除', '权限管理-权限-删除', 'pms:permission:delete');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-角色-查看', '权限管理-角色-查看', 'pms:role:view');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-角色-添加', '权限管理-角色-添加', 'pms:role:add');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-角色-修改', '权限管理-角色-修改', 'pms:role:edit');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-角色-删除', '权限管理-角色-删除', 'pms:role:delete');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-角色-分配权限', '权限管理-角色-分配权限', 'pms:role:assignpermission');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-操作员-查看', '权限管理-操作员-查看', 'pms:operator:view');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-操作员-添加', '权限管理-操作员-添加', 'pms:operator:add');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-操作员-查看', '权限管理-操作员-修改', 'pms:operator:edit');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-操作员-冻结与解冻', '权限管理-操作员-冻结与解冻', 'pms:operator:changestatus');
INSERT INTO  pms_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  remark ,  permission_name ,  permission ) VALUES
(seq_pms_permission.nextval, 0, 'admin',   'test',   'ACTIVE', '权限管理-操作员-重置密码', '权限管理-操作员-重置密码', 'pms:operator:resetpwd');
commit;

--角色权限表
DELETE FROM  pms_role_permission ;
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 1);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 2);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 3);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 4);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 5);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 6);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 7);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 8);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 9);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 10);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 11);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 12);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 13);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 14);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 15);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 16);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 17);
INSERT INTO  pms_role_permission  ( id ,  version ,  creater  ,  editor  ,  status ,  role_id ,  permission_id ) VALUES
(seq_pms_role_permission.nextval,  0, 'admin', 'admin', 'ACTIVE',  1, 18);
commit;
  