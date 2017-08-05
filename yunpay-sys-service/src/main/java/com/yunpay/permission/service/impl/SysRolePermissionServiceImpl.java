package com.yunpay.permission.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SysPermissionDao;
import com.yunpay.permission.dao.SysRolePermissionDao;
import com.yunpay.permission.entity.SysPermission;
import com.yunpay.permission.entity.SysRolePermission;
import com.yunpay.permission.service.SysUserRoleService;
import com.yunpay.permission.service.SysRolePermissionService;

/**
 * 角色权限service接口实现
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Service("sysRolePermissionService")
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
	@Autowired
	private SysRolePermissionDao sysRolePermissionDao;

	@Autowired
	private SysPermissionDao sysPermissionDao;
	@Autowired
	private SysUserRoleService sysUserRoleService;

	/**
	 * 根据操作员ID，获取所有的功能权限集
	 * 
	 * @param userId
	 */
	public Set<String> getPermissionsByUserId(Long userId) {
		// 根据操作员Id查询出关联的所有角色id
		String roleIds = sysUserRoleService.getRoleIdsByUserId(userId);

		String permissionIds = getActionIdsByRoleIds(roleIds);
		Set<String> permissionSet = new HashSet<String>();

		// 根据角色ID字符串得到该用户的所有权限拼成的字符串
		if (!StringUtils.isEmpty(permissionIds)) {
			List<SysPermission> permissions = sysPermissionDao.findByIds(permissionIds);
			for (SysPermission permission : permissions) {
				permissionSet.add(permission.getPermission());
			}
		}
		return permissionSet;
	}

	/**
	 * 根据角色ID集得到所有权限ID集
	 * 
	 * @param roleIds
	 * @return actionIds
	 */
	private String getActionIdsByRoleIds(String roleIds) {
		// 得到角色－权限表中roleiId在ids中的所有关联对象
		List<SysRolePermission> listRolePermission = sysRolePermissionDao.listByRoleIds(roleIds); // 构建StringBuffer
		StringBuffer actionIdsBuf = new StringBuffer("");
		// 拼接字符串
		for (SysRolePermission sysRolePermission : listRolePermission) {
			actionIdsBuf.append(sysRolePermission.getPermissionId()).append(",");
		}
		String actionIds = actionIdsBuf.toString();
		// 截取字符串
		if (StringUtils.isEmpty(actionIds) && actionIds.length() > 0) {
			actionIds = actionIds.substring(0, actionIds.length() - 1); // 去掉最后一个逗号
		}
		return actionIds;
	}

	// /////////////////////////////下面：基本操作方法///////////////////////////////////////////////

	/**
	 * 创建sysUser
	 */
	public void saveData(SysRolePermission sysRolePermission) {
		sysRolePermissionDao.insert(sysRolePermission);
	}

	/**
	 * 修改sysUser
	 */
	public void updateData(SysRolePermission sysRolePermission) {
		sysRolePermissionDao.update(sysRolePermission);
	}

	/**
	 * 根据id获取数据sysUser
	 * 
	 * @param id
	 * @return
	 */
	public SysRolePermission getDataById(Long id) {
		return sysRolePermissionDao.getById(id);

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
	public PageBean listPage(PageParam pageParam, SysRolePermission sysRolePermission) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return sysRolePermissionDao.listPage(pageParam, paramMap);
	}
	
	/**
	 * 保存角色和权限之间的关联关系
	 */
	@Transactional(rollbackFor = Exception.class)
	public void saveRolePermission(Long roleId, String rolePermissionStr){
		// 删除原来的角色与权限关联
		//sysRolePermissionDao.deleteByRoleId(roleId);
		if (!StringUtils.isEmpty(rolePermissionStr)) {
			// 创建新的关联
			String[] permissionIds = rolePermissionStr.split(",");
			for (int i = 0; i < permissionIds.length; i++) {
				Long permissionId = Long.valueOf(permissionIds[i]);
				SysRolePermission item = new SysRolePermission();
				item.setPermissionId(permissionId);
				item.setRoleId(roleId);
				item.setCreateTime(new Date());
				item.setEditTime(new Date());
				sysRolePermissionDao.insert(item);
			}
		}
	}

}
