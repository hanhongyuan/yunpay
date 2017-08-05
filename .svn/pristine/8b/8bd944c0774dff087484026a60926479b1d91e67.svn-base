package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.permission.dao.SysUserDao;
import com.yunpay.permission.dao.SysUserRoleDao;
import com.yunpay.permission.dao.SysRoleDao;
import com.yunpay.permission.entity.SysUser;
import com.yunpay.permission.entity.SysUserRole;
import com.yunpay.permission.entity.SysRole;
import com.yunpay.permission.service.SysUserRoleService;

/**
 * 操作员角色service接口实现
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@Autowired
	private SysUserDao sysUserDao;

	@Autowired
	private SysRoleDao sysRoleDao;

	/**
	 * 根据操作员ID获得该操作员的所有角色id所拼成的String，每个ID用“,”分隔
	 * 
	 * @param userId
	 *            操作员ID
	 * @return roleIds
	 */
	public String getRoleIdsByUserId(Long userId) {
		// 得到操作员和角色列表
		List<SysUserRole> rpList = sysUserRoleDao.listByUserId(userId);
		// 构建StringBuffer来拼字符串
		StringBuffer roleIdsBuf = new StringBuffer("");
		for (SysUserRole rp : rpList) {
			roleIdsBuf.append(rp.getRoleId()).append(",");
		}
		String roleIds = roleIdsBuf.toString();
		// 截取字符串
		if (StringUtils.isNotBlank(roleIds) && roleIds.length() > 0) {
			roleIds = roleIds.substring(0, roleIds.length() - 1);
		}
		return roleIds;
	}

	/**
	 * 根据操作员id，获取该操作员所有角色的编码集合
	 * 
	 * @param userId
	 * @return
	 */
	public Set<String> getRoleCodeByUserId(Long userId) {
		// 得到操作员和角色列表
		List<SysUserRole> rpList = sysUserRoleDao.listByUserId(userId);
		Set<String> roleCodeSet = new HashSet<String>();

		for (SysUserRole rp : rpList) {
			Long roleId = rp.getRoleId();
			SysRole role = sysRoleDao.getById(roleId);
			if (role == null) {
				continue;
			}
			roleCodeSet.add(role.getRoleCode());
		}

		return roleCodeSet;

	}

	/**
	 * 根据角色ID统计有多少个操作员关联到此角色.
	 * 
	 * @param roleId
	 *            .
	 * @return count.
	 */
	public int countUserByRoleId(Long roleId) {
		List<SysUserRole> userList = sysUserRoleDao.listByRoleId(roleId);
		if (userList == null || userList.isEmpty()) {
			return 0;
		} else {
			return userList.size();
		}
	}

	/**
	 * 根据操作员ID获得所有操作员－角色关联列表
	 */
	public List<SysUserRole> listUserRoleByUserId(Long userId) {
		return sysUserRoleDao.listByUserId(userId);
	}

	/**
	 * 保存操作員信息及其关联的角色.
	 * 
	 * @param sysUser
	 *            .
	 * @param UserRoleStr
	 *            .
	 */
	public void saveUser(SysUser sysUser, String UserRoleStr) {
		// 保存操作员信息
		sysUserDao.insert(sysUser);
		// 保存角色关联信息
		if (StringUtils.isNotBlank(UserRoleStr) && UserRoleStr.length() > 0) {
			saveOrUpdateUserRole(Long.valueOf(sysUser.getId()), UserRoleStr);
		}
	}

	/**
	 * 根据角色ID查询用户
	 * 
	 * @param roleId
	 * @return
	 */
	public List<SysUser> listUserByRoleId(Long roleId) {
		return sysUserDao.listByRoleId(roleId);
	}

	/**
	 * 修改操作員信息及其关联的角色.
	 * 
	 * @param sysUser
	 *            .
	 * @param UserRoleStr
	 *            .
	 */
	public void updateUser(SysUser sysUser, String UserRoleStr) {
		sysUserDao.update(sysUser);
		// 更新角色信息
		saveOrUpdateUserRole(Long.valueOf(sysUser.getId()), UserRoleStr);
	}

	/**
	 * 保存用户和角色之间的关联关系
	 */
	private void saveOrUpdateUserRole(Long userId, String roleIdsStr) {
		// 删除原来的角色与操作员关联
		List<SysUserRole> listSysUserRoles = sysUserRoleDao.listByUserId(userId);
		Map<Long, SysUserRole> delMap = new HashMap<Long, SysUserRole>();
		for (SysUserRole sysUserRole : listSysUserRoles) {
			delMap.put(sysUserRole.getRoleId(), sysUserRole);
		}
		if (StringUtils.isNotBlank(roleIdsStr)) {
			// 创建新的关联
			String[] roleIds = roleIdsStr.split(",");
			for (int i = 0; i < roleIds.length; i++) {
				Long roleId = Long.valueOf(roleIds[i]);
				if (delMap.get(roleId) == null) {
					SysUserRole sysUserRole = new SysUserRole();
					sysUserRole.setUserId(userId);
					sysUserRole.setRoleId(roleId);
					sysUserRoleDao.insert(sysUserRole);
				} else {
					delMap.remove(roleId);
				}
			}
		}

		Iterator<Long> iterator = delMap.keySet().iterator();
		while (iterator.hasNext()) {
			Long roleId = iterator.next();
			sysUserRoleDao.deleteByRoleIdAndUserId(roleId, userId);
		}
	}

}
