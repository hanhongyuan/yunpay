package com.yunpay.permission.service;

import java.util.List;
import java.util.Set;

import com.yunpay.permission.entity.SysUser;
import com.yunpay.permission.entity.SysUserRole;

/**
 * 操作员角色service接口
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public interface SysUserRoleService {

	/**
	 * 根据操作员ID获得该操作员的所有角色id所拼成的String，每个ID用“,”分隔
	 * 
	 * @param userId
	 *            操作员ID
	 * @return roleIds
	 */
	public String getRoleIdsByUserId(Long userId);

	/**
	 * 根据操作员id，获取该操作员所有角色的编码集合
	 * 
	 * @param userId
	 * @return
	 */
	public Set<String> getRoleCodeByUserId(Long userId);

	/**
	 * 根据角色ID查询用户
	 * 
	 * @param roleId
	 * @return
	 */
	public List<SysUser> listUserByRoleId(Long roleId);

	/**
	 * 保存操作員信息及其关联的角色.
	 * 
	 * @param sysUser
	 *            .
	 * @param roleUserStr
	 *            .
	 */
	public void saveUser(SysUser sysUser, String roleUserStr);

	/**
	 * 修改操作員信息及其关联的角色.
	 * 
	 * @param sysUser
	 *            .
	 * @param roleUserStr
	 *            .
	 */
	public void updateUser(SysUser sysUser, String roleUserStr);

	/**
	 * 根据角色ID统计有多少个操作员关联到此角色.
	 * 
	 * @param roleId
	 *            .
	 * @return count.
	 */
	public int countUserByRoleId(Long roleId);

	/**
	 * 根据操作员ID获得所有操作员－角色关联列表
	 */
	public List<SysUserRole> listUserRoleByUserId(Long userId);
	
	

}
