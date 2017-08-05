package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SysPermissionDao;
import com.yunpay.permission.dao.SysRolePermissionDao;
import com.yunpay.permission.entity.SysPermission;
import com.yunpay.permission.entity.SysRolePermission;
import com.yunpay.permission.service.SysPermissionService;

/**
 * 权限service接口实现
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {
	@Autowired
	private SysPermissionDao sysPermissionDao;
	@Autowired
	private SysRolePermissionDao sysRolePermissionDao;

	/**
	 * 创建sysUser
	 */
	public void saveData(SysPermission sysPermission) {
		sysPermissionDao.insert(sysPermission);
	}

	/**
	 * 修改sysUser
	 */
	public void updateData(SysPermission sysPermission) {
		sysPermissionDao.update(sysPermission);
	}

	/**
	 * 根据id获取数据sysUser
	 * 
	 * @param id
	 * @return
	 */
	public SysPermission getDataById(Long id) {
		return sysPermissionDao.getById(id);

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
	public PageBean listPage(PageParam pageParam, SysPermission sysPermission) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("permissionName", sysPermission.getPermissionName()); // 权限名称（模糊查询）
		paramMap.put("permission", sysPermission.getPermission()); // 权限（精确查询）
		return sysPermissionDao.listPage(pageParam, paramMap);
	}

	/**
	 * 检查权限名称是否已存在
	 * 
	 * @param trim
	 * @return
	 */
	public SysPermission getByPermissionName(String permissionName) {
		return sysPermissionDao.getByPermissionName(permissionName);
	}

	/**
	 * 检查权限是否已存在
	 * 
	 * @param permission
	 * @return
	 */
	public SysPermission getByPermission(String permission) {
		return sysPermissionDao.getByPermission(permission);
	}

	/**
	 * 检查权限名称是否已存在(其他id)
	 * 
	 * @param permissionName
	 * @param id
	 * @return
	 */
	public SysPermission getByPermissionNameNotEqId(String permissionName, Long id) {
		return sysPermissionDao.getByPermissionNameNotEqId(permissionName, id);
	}

	/**
	 * sysPermissionDao 删除
	 * 
	 * @param permission
	 */
	public void delete(Long permissionId) {
		sysPermissionDao.delete(permissionId);
	}

	/**
	 * 根据角色查找角色对应的功能权限ID集
	 * 
	 * @param roleId
	 * @return
	 */
	public String getPermissionIdsByRoleId(Long roleId) {
		List<SysRolePermission> rmList = sysRolePermissionDao.listByRoleId(roleId);
		StringBuffer actionIds = new StringBuffer();
		if (rmList != null && !rmList.isEmpty()) {
			for (SysRolePermission rm : rmList) {
				actionIds.append(rm.getPermissionId()).append(",");
			}
		}
		return actionIds.toString();
	}

	/**
	 * 查询所有的权限
	 */
	public List<SysPermission> listAll() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return sysPermissionDao.listBy(paramMap);
	}
}
