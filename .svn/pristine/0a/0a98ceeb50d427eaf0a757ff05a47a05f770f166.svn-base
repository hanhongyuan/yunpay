package com.yunpay.permission.service;

import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.SysRole;

/**
 * 角色service接口
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public abstract interface SysRoleService {

	/**
	 * 创建sysRole
	 */
	void saveData(SysRole sysRole);

	/**
	 * 修改sysRole
	 */
	void updateData(SysRole sysRole);

	/**
	 * 根据id获取数据sysRole
	 * 
	 * @param id
	 * @return
	 */
	SysRole getDataById(Long id);

	/**
	 * 分页查询sysRole
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            SysRole
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, SysRole sysRole);

	/**
	 * 获取所有角色列表，以供添加操作员时选择.
	 * 
	 * @return roleList .
	 */
	public List<SysRole> listAllRole();

	/**
	 * 判断此权限是否关联有角色
	 * 
	 * @param permissionId
	 * @return
	 */
	List<SysRole> listByPermissionId(Long permissionId);

	/**
	 * 根据角色名或者角色编号查询角色
	 * 
	 * @param roleName
	 * @param roleCode
	 * @return
	 */
	SysRole getByRoleNameOrRoleCode(String roleName, String roleCode);

	/**
	 * 删除
	 * 
	 * @param roleId
	 */
	void delete(Long roleId);

}
