package com.yunpay.permission.entity;

/**
 * 权限管理-角色权限关联表..
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public class SysMenuRole extends PermissionBaseEntity {

	private static final long serialVersionUID = -9012707031072904356L;

	/** 角色ID **/
	private Long roleId;

	/** 菜单ID **/
	private Long menuId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
}
