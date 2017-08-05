package com.yunpay.permission.dao;

import java.util.List;

import com.yunpay.permission.entity.SysRolePermission;

/**
 * 角色权限dao
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public interface SysRolePermissionDao extends PermissionBaseDao<SysRolePermission> {

	/**
	 * 根据角色ID找到角色关联的权限点.
	 * 
	 * @param roleId
	 *            .
	 * @return rolePermissionList .
	 */
	public List<SysRolePermission> listByRoleId(final long roleId);

	/**
	 * 根据角色ID字符串获取相应角色-权限关联信息.
	 * 
	 * @param roleIds
	 * @return
	 */
	public List<SysRolePermission> listByRoleIds(String roleIdsStr);

	public void deleteByRoleIdAndPermissionId(Long roleId, Long permissionId);
	
	public void deleteByRoleId(Long roleId);
}
