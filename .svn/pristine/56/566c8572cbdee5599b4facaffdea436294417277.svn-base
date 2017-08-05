package com.yunpay.permission.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yunpay.common.core.enums.PublicStatusEnum;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SysUserDao;
import com.yunpay.permission.dao.SysUserRoleDao;
import com.yunpay.permission.entity.SysUser;
import com.yunpay.permission.entity.SysUserRole;
import com.yunpay.permission.service.SysUserService;

/**
 * 操作员service接口实现
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	/**
	 * 创建sysUser
	 */
	public void saveData(SysUser sysUser) {
		sysUserDao.insert(sysUser);
	}

	/**
	 * 修改sysUser
	 */
	public void updateData(SysUser sysUser) {
		sysUserDao.update(sysUser);
	}

	/**
	 * 根据id获取数据sysUser
	 * 
	 * @param id
	 * @return
	 */
	public SysUser getDataById(Long id) {
		return sysUserDao.getById(id);

	}

	/**
	 * 分页查询sysUser
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            SysUser
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public PageBean listPage(PageParam pageParam, SysUser sysUser) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("loginName", sysUser.getLoginName()); // 操作员登录名（精确查询）
		paramMap.put("realName", sysUser.getRealName()); // 操作员姓名（模糊查询）
		paramMap.put("status", sysUser.getStatus()); // 状态

		return sysUserDao.listPage(pageParam, paramMap);
	}

	/**
	 * 根据ID删除一个操作员，同时删除与该操作员关联的角色关联信息. type="1"的超级管理员不能删除.
	 * 
	 * @param id
	 *            操作员ID.
	 */
	public void deleteUserById(Long userId) {
		SysUser sysUser = sysUserDao.getById(userId);
		if (sysUser != null) {
			if ("admin".equals(sysUser.getType())) {
				throw new RuntimeException("【" + sysUser.getLoginName() + "】为超级管理员，不能删除！");
			}
			sysUserDao.delete(userId);
			// 删除原来的角色与操作员关联
			sysUserRoleDao.deleteByUserId(userId);
		}
	}

	/**
	 * 更新操作员信息.
	 * 
	 * @param user
	 */
	public void update(SysUser user) {
		sysUserDao.update(user);

	}

	/**
	 * 根据操作员ID更新操作员密码.
	 * 
	 * @param userId
	 * @param newPwd
	 *            (已进行SHA1加密)
	 */
	public void updateUserPwd(Long userId, String newPwd) {
		SysUser sysUser = sysUserDao.getById(userId);
		sysUser.setLoginPwd(newPwd);
		sysUserDao.update(sysUser);
	}

	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	public int updatePwd(SysUser user){
		return sysUserDao.updatePwd(user);
	}
	
	/**
	 * 根据登录名取得操作员对象
	 */
	public SysUser findUserByLoginName(String loginName) {
		return sysUserDao.findByLoginName(loginName);
	}

	/**
	 * 保存操作員信息及其关联的角色.
	 * 
	 * @param sysUser
	 *            .
	 * @param roleUserStr
	 *            .
	 */

	@Transactional
	public int saveUser(SysUser sysUser, String roleUserStr) {
		return sysUserDao.insert(sysUser);
		
	}

	/**
	 * 保存用户和角色之间的关联关系
	 */
	public void saveOrUpdateUserRole(SysUser sysUser, String roleIdsStr) {
		// 删除原来的角色与操作员关联
		List<SysUserRole> listSysUserRoles = sysUserRoleDao.listByUserId(Long.valueOf(sysUser.getId()));
		Map<Long, SysUserRole> delMap = new HashMap<Long, SysUserRole>();
		for (SysUserRole sysUserRole : listSysUserRoles) {
			delMap.put(sysUserRole.getRoleId(), sysUserRole);
		}
		if (StringUtils.isNotBlank(roleIdsStr)) {
			// 创建新的关联
			String[] roleIds = roleIdsStr.split(",");
			for (int i = 0; i < roleIds.length; i++) {
				long roleId = Long.parseLong(roleIds[i]);
				if (delMap.get(roleId) == null) {
					SysUserRole sysUserRole = new SysUserRole();
					sysUserRole.setUserId(Long.valueOf(sysUser.getId()));
					sysUserRole.setRoleId(roleId);
					sysUserRole.setCreater(sysUser.getCreater());
					sysUserRole.setCreateTime(new Date());
					sysUserRole.setStatus(PublicStatusEnum.ACTIVE.name());
					sysUserRole.setEditor(sysUser.getEditor());
					sysUserRole.setEditTime(new Date());
					sysUserRole.setRemark(sysUser.getRemark());
					sysUserRoleDao.insert(sysUserRole);
				} else {
					delMap.remove(roleId);
				}
			}
		}

		Iterator<Long> iterator = delMap.keySet().iterator();
		while (iterator.hasNext()) {
			long roleId = iterator.next();
			sysUserRoleDao.deleteByRoleIdAndUserId(roleId, Long.valueOf(sysUser.getId()));
		}
	}

	/**
	 * 修改操作員信息及其关联的角色.
	 * 
	 * @param sysUser
	 *            .
	 * @param roleUserStr
	 *            .
	 */
	public void updateUser(SysUser sysUser, String roleUserStr) {
		sysUserDao.update(sysUser);
		// 更新角色信息
		this.saveOrUpdateUserRole(sysUser, roleUserStr);
	}

	@Override
	public SysUser queryUser() {
		return sysUserDao.queryUser();
		
	}

	@Override
	public List<SysUser> listAllSysUser() {
		return sysUserDao.listAllSysUser();
	}


}
