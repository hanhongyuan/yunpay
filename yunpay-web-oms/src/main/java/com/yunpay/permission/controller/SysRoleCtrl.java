package com.yunpay.permission.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yunpay.common.core.dwz.DwzAjax;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.controller.common.BaseController;
import com.yunpay.permission.biz.SysMenuBiz;
import com.yunpay.permission.entity.SysUser;
import com.yunpay.permission.entity.SysPermission;
import com.yunpay.permission.entity.SysRole;
import com.yunpay.permission.enums.UserTypeEnum;
import com.yunpay.permission.service.SysMenuRoleService;
import com.yunpay.permission.service.SysMenuService;
import com.yunpay.permission.service.SysUserRoleService;
import com.yunpay.permission.service.SysPermissionService;
import com.yunpay.permission.service.SysRolePermissionService;
import com.yunpay.permission.service.SysRoleService;
import com.yunpay.permission.utils.ValidateUtils;

/**
 * 权限管理模块角色管理、. 
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Controller
@RequestMapping("/sys/role")
public class SysRoleCtrl extends BaseController {

	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private SysMenuRoleService sysMenuRoleService;
	@Autowired
	private SysPermissionService sysPermissionService;
	@Autowired
	private SysRolePermissionService sysRolePermissionService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysMenuBiz sysMenuBiz;

	private static Log log = LogFactory.getLog(SysRoleCtrl.class);

	/**
	 * 获取角色列表
	 * 
	 * @return listSysRole or operateError .
	 */
	@SuppressWarnings("rawtypes")
	@RequiresPermissions("sys:role:view")
	@RequestMapping("/list")
	public String listSysRole(HttpServletRequest req, PageParam pageParam, SysRole sysRole, Model model) {
		try {
			PageBean pageBean = sysRoleService.listPage(pageParam, sysRole);
			model.addAttribute(pageBean);
			model.addAttribute("pageParam", pageParam);
			model.addAttribute("sysRole", sysRole);
			return "modules/sys/sysRoleList";
		} catch (Exception e) {
			log.error("== listSysRole exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 转到添加角色页面 .
	 * 
	 * @return addSysRoleUI or operateError .
	 */
	@RequiresPermissions("sys:role:add")
	@RequestMapping("/addUI")
	public String addSysRoleUI(HttpServletRequest req, Model model) {
		try {
			return "modules/sys/sysRoleAdd";
		} catch (Exception e) {
			log.error("== addSysRoleUI get data exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 保存新添加的一个角色 .
	 * 
	 * @return operateSuccess or operateError .
	 */
	@RequiresPermissions("sys:role:add")
	@RequestMapping("/add")
	public String addSysRole(HttpServletRequest req, Model model, @RequestParam("roleCode") String roleCode, @RequestParam("roleName") String roleName, @RequestParam("remark") String remark, DwzAjax dwz) {
		try {
			SysRole roleNameCheck = sysRoleService.getByRoleNameOrRoleCode(roleName, null);
			if (roleNameCheck != null) {
				return operateError("角色名【" + roleName + "】已存在", model);
			}

			SysRole roleCodeCheck = sysRoleService.getByRoleNameOrRoleCode(null, roleCode);
			if (roleCodeCheck != null) {
				return operateError("角色编码【" + roleCode + "】已存在", model);
			}

			// 保存基本角色信息
			SysRole sysRole = new SysRole();
			sysRole.setRoleCode(roleCode);
			sysRole.setRoleName(roleName);
			sysRole.setRemark(remark);
			sysRole.setCreateTime(new Date());

			// 表单数据校验
			String validateMsg = validateSysRole(sysRole);
			if (StringUtils.isNotBlank(validateMsg)) {
				return operateError(validateMsg, model); // 返回错误信息
			}
			sysRoleService.saveData(sysRole);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== addSysRole exception:", e);
			return operateError("保存数据失败", model);
		}
	}

	/**
	 * 校验角色表单数据.
	 * 
	 * @param sysRole
	 *            角色信息.
	 * @return msg .
	 */
	private String validateSysRole(SysRole sysRole) {
		String msg = ""; // 用于存放校验提示信息的变量
		String roleName = sysRole.getRoleName(); // 角色名称
		String desc = sysRole.getRemark(); // 描述
		// 角色名称 permissionName
		msg += ValidateUtils.lengthValidate("角色名称", roleName, true, 3, 90);
		// 描述 desc
		msg += ValidateUtils.lengthValidate("描述", desc, true, 3, 300);
		return msg;
	}

	/**
	 * 转到角色修改页面 .
	 * 
	 * @return editSysRoleUI or operateError .
	 */
	@RequiresPermissions("sys:role:edit")
	@RequestMapping("/editUI")
	public String editSysRoleUI(HttpServletRequest req, Model model, Long roleId) {
		try {
			SysRole sysRole = sysRoleService.getDataById(roleId);
			if (sysRole == null) {
				return operateError("获取数据失败", model);
			}

			model.addAttribute(sysRole);
			return "/modules/sys/sysRoleEdit";
		} catch (Exception e) {
			log.error("== editSysRoleUI exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 保存修改后的角色信息 .
	 * 
	 * @return operateSuccess or operateError .
	 */
	@RequiresPermissions("sys:role:edit")
	@RequestMapping("/edit")
	public String editSysRole(HttpServletRequest req, Model model, SysRole role, DwzAjax dwz) {
		try {
			Long id = Long.valueOf(role.getId());

			SysRole sysRole = sysRoleService.getDataById(id);
			if (sysRole == null) {
				return operateError("无法获取要修改的数据", model);
			}

			sysRole.setRoleName(role.getRoleName());
			sysRole.setRoleCode(role.getRoleCode());
			sysRole.setRemark(role.getRemark());

			// 表单数据校验
			String validateMsg = validateSysRole(sysRole);
			if (StringUtils.isNotBlank(validateMsg)) {
				return operateError(validateMsg, model); // 返回错误信息
			}
			sysRoleService.updateData(sysRole);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== editSysRole exception:", e);
			return operateError("保存失败", model);
		}
	}

	/**
	 * 删除一个角色
	 * 
	 * @return operateSuccess or operateError .
	 */
	@RequiresPermissions("sys:role:delete")
	@RequestMapping("/delete")
	public String deleteSysRole(HttpServletRequest req, Model model, Long roleId, DwzAjax dwz) {
		try {

			SysRole role = sysRoleService.getDataById(roleId);
			if (role == null) {
				return operateError("无法获取要删除的角色", model);
			}
			String msg = "";
			// 判断是否有操作员关联到此角色
			int userCount = sysUserRoleService.countUserByRoleId(roleId);
			if (userCount > 0) {
				msg += "有【" + userCount + "】个操作员关联到此角色，要先解除所有关联后才能删除!";
				return operateError(msg, model);
			}

			sysRoleService.delete(roleId);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== deleteSysRole exception:", e);
			return operateError("删除失败", model);
		}
	}
	
	/**
	 * 分配权限UI
	 * 
	 * @return
	 */
	@RequiresPermissions("sys:role:assignpermission")
	@RequestMapping("/assignPermissionUI")
	public String assignPermissionUI(HttpServletRequest req, Model model, Long roleId) {

		SysRole role = sysRoleService.getDataById(roleId);
		if (role == null) {
			return operateError("无法获取角色信息", model);
		}
		// 普通操作员没有修改超级管理员角色的权限
		if (UserTypeEnum.USER.name().equals(this.getSysUser().getType()) && "admin".equals(role.getRoleName())) {
			return operateError("权限不足", model);
		}

		String permissionIds = sysPermissionService.getPermissionIdsByRoleId(roleId); // 根据角色查找角色对应的功能权限ID集
		List<SysPermission> permissionList = sysPermissionService.listAll();
		List<SysUser> userList = sysUserRoleService.listUserByRoleId(roleId);

		model.addAttribute("permissionIds", permissionIds);
		model.addAttribute("permissionList", permissionList);
		model.addAttribute("userList", userList);
		model.addAttribute("role", role);
		return "modules/sys/assignPermissionUI";
	}

	/**
	 * 分配角色权限
	 */
	@RequiresPermissions("sys:role:assignpermission")
	@RequestMapping("/assignPermission")
	public String assignPermission(HttpServletRequest req, Model model, @RequestParam("roleId") Long roleId, DwzAjax dwz, @RequestParam("selectVal") String selectVal) {
		try {
			System.out.println(selectVal);
			String rolePermissionStr = getRolePermissionStr(selectVal);
			sysRolePermissionService.saveRolePermission(roleId, rolePermissionStr);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== assignPermission exception:", e);
			return operateError("保存失败", model);
		}
	}
	
	/**
	 * 分配菜单UI
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/assignMenuUI")
	public String assignMenuUI(HttpServletRequest req, Model model, Long roleId) {
		SysRole role = sysRoleService.getDataById(roleId);
		if (role == null) {
			return operateError("无法获取角色信息", model);
		}
		// 普通操作员没有修改超级管理员角色的权限
		if (UserTypeEnum.USER.name().equals(this.getSysUser().getType()) && "admin".equals(role.getRoleName())) {
			return operateError("权限不足", model);
		}

		String menuIds = sysMenuService.getMenuIdsByRoleId(roleId); // 根据角色查找角色对应的菜单ID集
		String[] split = menuIds.split(",");
		System.out.println(split.length+"------------"+split[0]);
		List menuList = sysMenuService.getListByParent(null);
		String editMenuController = "sys/menu/ViewUI";
		String str = sysMenuBiz.getTreeCheckMenu(editMenuController);
		List<SysUser> userList = sysUserRoleService.listUserByRoleId(roleId);

		model.addAttribute("tree", str);
		model.addAttribute("menuIds", menuIds);
		model.addAttribute("split", split);
		model.addAttribute("menuList", menuList);
		model.addAttribute("userList", userList);
		model.addAttribute("role", role);
		return "modules/sys/assignMenuUI";
	}

	/**
	 * 分配角色菜单
	 */
	@RequestMapping("/assignMenu")
	public String assignMenu(HttpServletRequest req, Model model, @RequestParam("roleId") Long roleId, DwzAjax dwz, @RequestParam("selectVal") String selectVal) {
		try {
			System.out.println(selectVal);
			String roleMenuStr = getRolePermissionStr(selectVal);
			sysMenuRoleService.saveRoleMenu(roleId, roleMenuStr);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== assignPermission exception:", e);
			return operateError("保存失败", model);
		}
	}

	/**
	 * 得到角色和权限关联的ID字符串
	 * 
	 * @return
	 */
	private String getRolePermissionStr(String selectVal) throws Exception {
		String roleStr = selectVal;
		if (StringUtils.isNotBlank(roleStr) && roleStr.length() > 0) {
			roleStr = roleStr.substring(0, roleStr.length() - 1);
		}
		return roleStr;
	}
}
