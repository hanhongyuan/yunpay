package com.yunpay.permission.entity;

/**
 * 
 * 权限管理-角色,操作员关联表..
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public class SysUserRole extends PermissionBaseEntity {

	private static final long serialVersionUID = 174356028197753020L;
	private Long roleId;// 角色ID
	private Long userId;// /操作员ID

	/**
	 * 角色ID
	 * 
	 * @return
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 角色ID
	 * 
	 * @return
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 操作员ID
	 * 
	 * @return
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 操作员ID
	 * 
	 * @return
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public SysUserRole() {

	}

}
