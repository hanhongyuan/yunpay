package com.yunpay.permission.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.SysUserDao;
import com.yunpay.permission.entity.SysUser;

/**
 * 权限操作员dao实现
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Repository
public class SysUserDaoImpl extends PermissionBaseDaoImpl<SysUser> implements SysUserDao {

	/**
	 * 根据操作员登录名获取操作员信息.
	 * 
	 * @param loginName
	 *            .
	 * @return user .
	 */

	public SysUser findByLoginName(String loginName) {
		return super.getSqlSession().selectOne(getStatement("findByLoginName"), loginName);
	}

	@Override
	public List<SysUser> listByRoleId(Long roleId) {
		return super.getSqlSession().selectList(getStatement("listByRoleId"), roleId);
	}

	@Override
	public SysUser queryUser() {
		return super.getSqlSession().selectOne(getStatement("queryUser"));
	}
	
	@Override
	public List<SysUser> listAllSysUser(){
		return super.getSqlSession().selectList(getStatement("listAllSysUser"));
	}
	
	@Override
	public int updatePwd(SysUser user) {
		return super.getSqlSession().update(getStatement("updatePwd"),user);
	}

}
