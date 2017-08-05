package com.yunpay.permission.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.SysUserRoleDao;
import com.yunpay.permission.entity.SysUserRole;

/**
 * 权限-操作员与角色dao实现
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Repository
public class SysUserRoleDaoImpl extends PermissionBaseDaoImpl<SysUserRole> implements SysUserRoleDao {

	/**
	 * 根据操作员ID查找该操作员关联的角色.
	 * 
	 * @param userId
	 *            .
	 * @return list .
	 */
	public List<SysUserRole> listByUserId(Long userId) {
		return super.getSqlSession().selectList(getStatement("listByUserId"), userId);
	}

	/**
	 * 根据角色ID查找该操作员关联的操作员.
	 * 
	 * @param roleId
	 * @return
	 */
	public List<SysUserRole> listByRoleId(Long roleId) {
		return super.getSqlSession().selectList(getStatement("listByRoleId"), roleId);
	}

	/**
	 * 根据操作员ID删除与角色的关联记录.
	 * 
	 * @param userId
	 *            .
	 */
	public void deleteByUserId(Long userId) {

		super.getSqlSession().delete(getStatement("deleteByUserId"), userId);
	}

	/**
	 * 根据角色ID删除操作员与角色的关联关系.
	 * 
	 * @param roleId
	 *            .
	 */
	public void deleteByRoleId(Long roleId) {
		super.getSqlSession().delete(getStatement("deleteByRoleId"), roleId);
	}

	/**
	 * 根据角色ID和操作员ID删除关联数据(用于更新操作员的角色).
	 * 
	 * @param roleId
	 *            角色ID.
	 * @param userId
	 *            操作员ID.
	 */
	@Override
	public void deleteByRoleIdAndUserId(Long roleId, Long userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleId", roleId);
		paramMap.put("userId", userId);
		super.getSqlSession().delete(getStatement("deleteByRoleIdAndUserId"), paramMap);
	}

}
