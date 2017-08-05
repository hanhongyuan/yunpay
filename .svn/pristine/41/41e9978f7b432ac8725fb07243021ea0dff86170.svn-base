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

import com.yunpay.common.core.dwz.DwzAjax;
import com.yunpay.common.core.enums.PublicStatusEnum;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.controller.common.BaseController;
import com.yunpay.permission.entity.SysPermission;
import com.yunpay.permission.entity.SysRole;
import com.yunpay.permission.service.SysPermissionService;
import com.yunpay.permission.service.SysRoleService;
import com.yunpay.permission.utils.ValidateUtils;

/**
 * 权限管理模块的Permission类，包括权限点管理、角色管理、操作员管理.<br/>
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Controller 
@RequestMapping("/sys/permission")
public class SysPermissionCtrl extends BaseController {

	@Autowired
	private SysPermissionService sysPermissionService;
	@Autowired
	private SysRoleService sysRoleService;

	private static Log log = LogFactory.getLog(SysPermissionCtrl.class);

	/**
	 * 分页列出sys权限，也可根据权限获权限名称进行查询.
	 * 
	 * @return SysPermissionList or operateError.
	 */
	@SuppressWarnings("rawtypes")
	@RequiresPermissions("sys:permission:view")
	@RequestMapping("/list")
	public String listSysPermission(HttpServletRequest req, PageParam pageParam, SysPermission sysPermission, Model model) {
		try {
			PageBean pageBean = sysPermissionService.listPage(pageParam, sysPermission);
			model.addAttribute(pageBean);
			model.addAttribute("pageParam", pageParam);
			return "modules/sys/sysPermissionList";
		} catch (Exception e) {
			log.error("== listSysPermission exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 进入添加Sys权限页面 .
	 * 
	 * @return addSysPermissionUI .
	 */
	@RequiresPermissions("sys:permission:add")
	@RequestMapping("/addUI")
	public String addSysPermissionUI() {
		return "modules/sys/sysPermissionAdd";
	}

	/**
	 * 将权限信息保存到数据库中
	 * 
	 * @return operateSuccess or operateError.
	 */
	@RequiresPermissions("sys:permission:add")
	@RequestMapping("/add")
	public String addSysPermission(HttpServletRequest req, SysPermission sysPermission, Model model, DwzAjax dwz) {
		try {

			// 表单数据校验
			String validateMsg = validateSysPermission(sysPermission);
			if (StringUtils.isNotBlank(validateMsg)) {
				return operateError(validateMsg, model); // 返回错误信息
			}

			String permissionName = sysPermission.getPermissionName().trim();
			String permission = sysPermission.getPermission();
			// 检查权限名称是否已存在
			SysPermission checkName = sysPermissionService.getByPermissionName(permissionName);
			if (checkName != null) {
				return operateError("权限名称【" + permissionName + "】已存在", model);
			}
			// 检查权限是否已存在
			SysPermission checkPermission = sysPermissionService.getByPermission(permission);
			if (checkPermission != null) {
				return operateError("权限【" + permission + "】已存在", model);
			}
			sysPermission.setStatus(PublicStatusEnum.ACTIVE.name());
			sysPermission.setCreater(getSysUser().getLoginName());
			sysPermission.setCreateTime(new Date());
			sysPermissionService.saveData(sysPermission);

			return operateSuccess(model, dwz); // 返回operateSuccess视图,并提示“操作成功”
		} catch (Exception e) {
			log.error("== addSysPermission exception:", e);
			return operateError("保存失败", model);
		}
	}

	/**
	 * 校验Sys权限信息.
	 * 
	 * @param sysPermission
	 *            .
	 * @return msg .
	 */
	private String validateSysPermission(SysPermission sysPermission) {
		String msg = ""; // 用于存放校验提示信息的变量
		String permissionName = sysPermission.getPermissionName(); // 权限名称
		String permission = sysPermission.getPermission(); // 权限标识
		String desc = sysPermission.getRemark(); // 权限描述
		// 权限名称 permissionName
		msg += ValidateUtils.lengthValidate("权限名称", permissionName, true, 3, 90);
		// 权限标识 permission
		msg += ValidateUtils.lengthValidate("权限标识", permission, true, 3, 100);
		// 描述 desc
		msg += ValidateUtils.lengthValidate("描述", desc, true, 3, 60);
		return msg;
	}

	/**
	 * 转到权限修改页面 .
	 * 
	 * @return editSysPermissionUI or operateError .
	 */
	@RequiresPermissions("sys:permission:edit")
	@RequestMapping("/editUI")
	public String editSysPermissionUI(HttpServletRequest req, Long id, Model model) {
		try {
			SysPermission sysPermission = sysPermissionService.getDataById(id);
			model.addAttribute("sysPermission", sysPermission);
			return "modules/sys/sysPermissionEdit";
		} catch (Exception e) {
			log.error("== editSysPermissionUI exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 保存修改后的权限信息
	 * 
	 * @return operateSuccess or operateError .
	 */
	@RequiresPermissions("sys:permission:edit")
	@RequestMapping("/edit")
	public String editSysPermission(HttpServletRequest req, SysPermission permission, Model model, DwzAjax dwz) {
		try {
			Long id = Long.valueOf(permission.getId());
			SysPermission sysPermission = sysPermissionService.getDataById(id);
			if (sysPermission == null) {
				return operateError("无法获取要修改的数据", model);
			} else {

				String permissionName = permission.getPermissionName();
				String remark = permission.getRemark();

				sysPermission.setPermissionName(permissionName);
				sysPermission.setRemark(remark);

				// 表单数据校验
				String validateMsg = validateSysPermission(sysPermission);
				if (StringUtils.isNotBlank(validateMsg)) {
					return operateError(validateMsg, model); // 返回错误信息
				}

				// 检查权限名称是否已存在
				SysPermission checkName = sysPermissionService.getByPermissionNameNotEqId(permissionName, id);
				if (checkName != null) {
					return operateError("权限名称【" + permissionName + "】已存在", model);
				}

				sysPermissionService.updateData(sysPermission);

				return operateSuccess(model, dwz);
			}
		} catch (Exception e) {
			log.error("== editSysPermission exception:", e);
			return operateError("修改失败", model);
		}
	}

	/**
	 * 删除一条权限记录
	 * 
	 * @return operateSuccess or operateError .
	 */
	@RequiresPermissions("sys:permission:delete")
	@RequestMapping("/delete")
	public String deleteSysPermission(HttpServletRequest req, Long permissionId, Model model, DwzAjax dwz) {
		try {
			SysPermission permission = sysPermissionService.getDataById(permissionId);
			if (permission == null) {
				return operateError("无法获取要删除的数据", model);
			}
			// 判断此权限是否关联有角色，要先解除与角色的关联后才能删除该权限
			List<SysRole> roleList = sysRoleService.listByPermissionId(permissionId);
			if (roleList != null && !roleList.isEmpty()) {
				return operateError("权限【" + permission.getPermission() + "】关联了【" + roleList.size() + "】个角色，要解除所有关联后才能删除。其中一个角色名为:" + roleList.get(0).getRoleName(), model);
			}
			sysPermissionService.delete(permissionId);
			return operateSuccess(model, dwz); // 返回operateSuccess视图,并提示“操作成功”
		} catch (Exception e) {
			log.error("== deleteSysPermission exception:", e);
			return operateError("删除限权异常", model);
		}
	}
}
