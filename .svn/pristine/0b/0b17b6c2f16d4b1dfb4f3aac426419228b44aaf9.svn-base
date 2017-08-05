package com.yunpay.permission.dao;

import java.util.List;

import com.yunpay.permission.entity.SysMenuRole;

/**
 * 菜单角色关联表
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 */
public interface SysMenuRoleDao extends PermissionBaseDao<SysMenuRole> {

	/**
	 * 根据角色ID删除菜单与角色的关联记录.
	 * 
	 * @param roleId
	 */
	void deleteByRoleId(Long roleId);

	/**
	 * 根据角色ID统计关联到此角色的菜单数.
	 * 
	 * @param roleId
	 *            角色ID.
	 * @return count.
	 */
	List<SysMenuRole> listByRoleId(Long roleId);
}