package com.yunpay.permission.service;

import java.util.Set;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.SysRolePermission;

/**
 * 角色权限service接口
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public interface SysRolePermissionService {

	/**
	 * 根据操作员ID，获取所有的功能权限集
	 * 
	 * @param userId
	 */
	public Set<String> getPermissionsByUserId(Long userId);

	/**
	 * 创建sysRolePermission
	 */
	void saveData(SysRolePermission sysRolePermission);

	/**
	 * 修改sysRolePermission
	 */
	void updateData(SysRolePermission sysRolePermission);

	/**
	 * 根据id获取数据sysRolePermission
	 * 
	 * @param id
	 * @return
	 */
	SysRolePermission getDataById(Long id);

	/**
	 * 分页查询sysRolePermission
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            SysRolePermission
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, SysRolePermission sysRolePermission);
	
	/**
	 * 保存角色和权限之间的关联关系
	 */
	void saveRolePermission(Long roleId, String rolePermissionStr);

}
