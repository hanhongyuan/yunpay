package com.yunpay.permission.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.SysRoleDao;
import com.yunpay.permission.entity.SysRole;

/**
 * 权限角色dao实现
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Repository
public class SysRoleDaoImpl extends PermissionBaseDaoImpl<SysRole> implements SysRoleDao {

	/**
	 * 获取所有角色列表，以供添加操作员时选择.
	 * 
	 * @return roleList .
	 */
	public List<SysRole> listAll() {
		return super.getSqlSession().selectList(getStatement("listAll"));
	}

	/**
	 * 判断此权限是否关联有角色
	 * 
	 * @param permissionId
	 * @return
	 */
	public List<SysRole> listByPermissionId(Long permissionId) {
		return super.getSqlSession().selectList(getStatement("listByPermissionId"), permissionId);
	}

	/**
	 * 根据角色名或者角色编号查询角色
	 * 
	 * @param roleName
	 * @param roleCode
	 * @return
	 */
	public SysRole getByRoleNameOrRoleCode(String roleName, String roleCode) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roleName", roleName);
		paramMap.put("roleCode", roleCode);
		return super.getSqlSession().selectOne(getStatement("getByRoleNameOrRoleCode"), paramMap);
	}
}
