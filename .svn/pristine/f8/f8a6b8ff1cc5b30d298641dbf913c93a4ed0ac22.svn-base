package com.yunpay.permission.dao;

import java.util.List;

import com.yunpay.permission.entity.SysRole;

/**
 * 权限角色dao
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public interface SysRoleDao extends PermissionBaseDao<SysRole> {

	/**
	 * 获取所有角色列表，以供添加操作员时选择.
	 * 
	 * @return roleList .
	 */
	public List<SysRole> listAll();

	/**
	 * 判断此权限是否关联有角色
	 * 
	 * @param permissionId
	 * @return
	 */
	public List<SysRole> listByPermissionId(Long permissionId);

	/**
	 * 根据角色名或者角色编号查询角色
	 * 
	 * @param roleName
	 * @param roleCode
	 * @return
	 */
	public SysRole getByRoleNameOrRoleCode(String roleName, String roleCode);

}
