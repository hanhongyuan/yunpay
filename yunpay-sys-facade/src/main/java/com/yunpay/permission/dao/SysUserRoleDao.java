package com.yunpay.permission.dao;

import java.util.List;

import com.yunpay.permission.entity.SysUserRole;

/**
 * 操作员与角色dao
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public interface SysUserRoleDao extends PermissionBaseDao<SysUserRole> {

	/**
	 * 根据操作员ID查找该操作员关联的角色.
	 * 
	 * @param userId
	 *            .
	 * @return list .
	 */
	List<SysUserRole> listByUserId(Long userId);

	/**
	 * 根据角色ID查找该操作员关联的操作员.
	 * 
	 * @param roleId
	 * @return
	 */
	List<SysUserRole> listByRoleId(Long roleId);

	/**
	 * 根据操作员ID删除与角色的关联记录.
	 * 
	 * @param userId
	 *            .
	 */
	void deleteByUserId(Long userId);

	/**
	 * 根据角色ID删除操作员与角色的关联关系.
	 * 
	 * @param roleId
	 *            .
	 */
	void deleteByRoleId(Long roleId);

	/**
	 * 根据角色ID和操作员ID删除关联数据(用于更新操作员的角色).
	 * 
	 * @param roleId
	 *            角色ID.
	 * @param userId
	 *            操作员ID.
	 */
	void deleteByRoleIdAndUserId(Long roleId, Long userId);

}
