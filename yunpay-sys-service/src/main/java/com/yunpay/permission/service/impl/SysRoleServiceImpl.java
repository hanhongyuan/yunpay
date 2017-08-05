package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SysRoleDao;
import com.yunpay.permission.entity.SysRole;
import com.yunpay.permission.service.SysRoleService;

/**
 * 角色service接口实现
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;

	/**
	 * 创建sysUser
	 */
	public void saveData(SysRole sysRole) {
		sysRoleDao.insert(sysRole);
	}

	/**
	 * 修改sysUser
	 */
	public void updateData(SysRole sysRole) {
		sysRoleDao.update(sysRole);
	}

	/**
	 * 根据id获取数据sysUser
	 * 
	 * @param id
	 * @return
	 */
	public SysRole getDataById(Long id) {
		return sysRoleDao.getById(id);

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
	public PageBean listPage(PageParam pageParam, SysRole sysRole) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		paramMap.put("roleName", sysRole.getRoleName()); // 角色名称（模糊查询）
		return sysRoleDao.listPage(pageParam, paramMap);
	}

	/**
	 * 获取所有角色列表，以供添加操作员时选择.
	 * 
	 * @return roleList .
	 */
	public List<SysRole> listAllRole() {
		return sysRoleDao.listAll();
	}

	/**
	 * 判断此权限是否关联有角色
	 * 
	 * @param permissionId
	 * @return
	 */
	public List<SysRole> listByPermissionId(Long permissionId) {
		return sysRoleDao.listByPermissionId(permissionId);
	}

	/**
	 * 根据角色名或者角色编号查询角色
	 * 
	 * @param roleName
	 * @param roleCode
	 * @return
	 */
	public SysRole getByRoleNameOrRoleCode(String roleName, String roleCode) {
		return sysRoleDao.getByRoleNameOrRoleCode(roleName, roleCode);
	}

	/**
	 * 删除
	 * 
	 * @param roleId
	 */
	public void delete(Long roleId) {
		sysRoleDao.delete(roleId);
	}
}
