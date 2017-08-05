package com.yunpay.permission.dao.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.SysPermissionDao;
import com.yunpay.permission.entity.SysPermission;

/**
 * 权限功能点dao实现
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Repository
public class SysPermissionDaoImpl extends PermissionBaseDaoImpl<SysPermission> implements SysPermissionDao {

	/**
	 * 根据实体ID集字符串获取对象列表.
	 * 
	 * @param idStr
	 * @return
	 */
	public List<SysPermission> findByIds(String idStr) {
		List<String> ids = Arrays.asList(idStr.split(","));
		return this.getSqlSession().selectList(getStatement("findByIds"), ids);
	}

	/**
	 * 检查权限名称是否已存在
	 * 
	 * @param trim
	 * @return
	 */
	public SysPermission getByPermissionName(String permissionName) {
		return this.getSqlSession().selectOne(getStatement("getByPermissionName"), permissionName);

	}

	/**
	 * 检查权限是否已存在
	 * 
	 * @param permission
	 * @return
	 */
	public SysPermission getByPermission(String permission) {
		return this.getSqlSession().selectOne(getStatement("getByPermission"), permission);
	}

	/**
	 * 检查权限名称是否已存在(其他id)
	 * 
	 * @param permissionName
	 * @param id
	 * @return
	 */
	public SysPermission getByPermissionNameNotEqId(String permissionName, Long id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("permissionName", permissionName);
		paramMap.put("id", id);
		return this.getSqlSession().selectOne(getStatement("getByPermissionNameNotEqId"), paramMap);
	}

	/**
	 * 获取叶子菜单下所有的功能权限
	 * 
	 * @param valueOf
	 * @return
	 */
	public List<SysPermission> listAllByMenuId(Long menuId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("menuId", menuId);
		return this.getSqlSession().selectList(getStatement("listAllByMenuId"), param);
	}
}
