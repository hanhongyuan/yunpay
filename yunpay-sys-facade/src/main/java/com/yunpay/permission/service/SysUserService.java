package com.yunpay.permission.service;

import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.SysUser;

/**
 * 操作员service接口
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public interface SysUserService {

	/**
	 * 创建sysUser
	 */
	void saveData(SysUser sysUser);

	/**
	 * 修改sysUser
	 */
	void updateData(SysUser sysUser);

	/**
	 * 根据id获取数据sysUser
	 * 
	 * @param id
	 * @return
	 */
	SysUser getDataById(Long id);

	/**
	 * 查询所有的操作员
	 * @return
	 */
	public List<SysUser> listAllSysUser();
	
	/**
	 * 根据登录名取得操作员对象
	 */
	public SysUser findUserByLoginName(String loginName);

	/**
	 * 分页查询sysUser
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            SysUser
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, SysUser sysUser);

	/**
	 * 根据ID删除一个操作员，同时删除与该操作员关联的角色关联信息. type="admin"的超级管理员不能删除.
	 * 
	 * @param id
	 *            操作员ID.
	 */
	public void deleteUserById(Long userId);

	/**
	 * 根据操作员ID更新操作员密码.
	 * 
	 * @param userId
	 * @param newPwd
	 *            (已进行SHA1加密)
	 */
	public void updateUserPwd(Long userId, String newPwd);

	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	int updatePwd(SysUser user);
	
	/**
	 * 保存操作員信息及其关联的角色.
	 * 
	 * @param sysUser
	 *            .
	 * @param roleUserStr
	 *            .
	 */
	public int saveUser(SysUser sysUser, String roleUserStr);

	public void saveOrUpdateUserRole(SysUser sysUser, String roleIdsStr);
	
	/**
	 * 修改操作員信息及其关联的角色.
	 * 
	 * @param sysUser
	 *            .
	 * @param roleUserStr
	 *            .
	 */
	void updateUser(SysUser sysUser, String roleUserStr);

	/**
	 * 查询当前插入的操作员信息
	 */
	SysUser queryUser();

}
