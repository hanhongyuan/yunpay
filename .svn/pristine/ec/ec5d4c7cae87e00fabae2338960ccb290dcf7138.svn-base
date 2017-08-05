package com.yunpay.permission.service;

import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.SysPermission;

/**
 * 权限service接口
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public interface SysPermissionService {

	/**
	 * 创建sysPermission
	 */
	void saveData(SysPermission sysPermission);

	/**
	 * 修改sysPermission
	 */
	void updateData(SysPermission sysPermission);

	/**
	 * 根据id获取数据sysPermission
	 * 
	 * @param id
	 * @return
	 */
	SysPermission getDataById(Long id);

	/**
	 * 分页查询sysPermission
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            SysPermission
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, SysPermission sysPermission);

	/**
	 * 检查权限名称是否已存在
	 * 
	 * @param permissionName
	 * @return
	 */
	SysPermission getByPermissionName(String permissionName);

	/**
	 * 检查权限是否已存在
	 * 
	 * @param permission
	 * @return
	 */
	SysPermission getByPermission(String permission);

	/**
	 * 检查权限名称是否已存在(其他id)
	 * 
	 * @param permissionName
	 * @param id
	 * @return
	 */
	SysPermission getByPermissionNameNotEqId(String permissionName, Long id);

	/**
	 * 删除
	 * 
	 * @param permissionId
	 */
	void delete(Long permissionId);

	/**
	 * 根据角色查找角色对应的功能权限ID集
	 * 
	 * @param roleId
	 * @return
	 */
	String getPermissionIdsByRoleId(Long roleId);
	
	/**
	 * 查询所有的权限
	 */
	List<SysPermission> listAll();

}
