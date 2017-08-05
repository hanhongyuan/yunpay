package com.yunpay.permission.dao;

import java.util.List;

import com.yunpay.permission.entity.SysUser;

/**
 * 操作员dao
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public interface SysUserDao extends PermissionBaseDao<SysUser> {

	/**
	 * 根据操作员登录名获取操作员信息.
	 * 
	 * @param loginName
	 *            .
	 * @return user .
	 */
	SysUser findByLoginName(String loginName);

	/**
	 * 根据角色ID找到操作员列表.
	 * 
	 * @param roleId
	 * @return
	 */
	List<SysUser> listByRoleId(Long roleId);
	
	/**
	 * 查询当前插入的操作员信息
	 * @return
	 */
	SysUser queryUser();
	
	/**
	 * 查询所有的操作员
	 * @return
	 */
	public List<SysUser> listAllSysUser();
	
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	int updatePwd(SysUser user);
}
