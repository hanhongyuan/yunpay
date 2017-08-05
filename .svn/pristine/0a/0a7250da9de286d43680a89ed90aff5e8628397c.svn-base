package com.yunpay.permission.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.SysMenuRoleDao;
import com.yunpay.permission.entity.SysMenuRole;

/**
 * 菜单角色
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Repository("sysRoleMenuDao")
public class SysMenuRoleDaoImpl extends PermissionBaseDaoImpl<SysMenuRole> implements SysMenuRoleDao {

	@Override
	public void deleteByRoleId(Long roleId) {
		super.getSqlSession().delete(getStatement("deleteByRoleId"), roleId);
	}

	/**
	 * 根据角色ID统计关联到此角色的菜单数.
	 * 
	 * @param roleId
	 *            角色ID.
	 * @return count.
	 */
	@Override
	public List<SysMenuRole> listByRoleId(Long roleId) {
		return super.getSqlSession().selectList(getStatement("listByRoleId"), roleId);
	}
}