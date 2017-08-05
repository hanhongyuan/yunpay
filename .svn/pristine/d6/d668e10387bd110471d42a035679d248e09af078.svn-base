package com.yunpay.permission.controller;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

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
import com.yunpay.common.core.enums.PublicStatusEnum;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.controller.common.BaseController;
import com.yunpay.permission.biz.BranchBiz;
import com.yunpay.permission.entity.Branch;
import com.yunpay.permission.entity.LookupBranchTree;
import com.yunpay.permission.entity.SysUser;
import com.yunpay.permission.entity.SysUserRole;
import com.yunpay.permission.enums.UserTypeEnum;
import com.yunpay.permission.service.BranchService;
import com.yunpay.permission.service.SysUserRoleService;
import com.yunpay.permission.service.SysUserService;
import com.yunpay.permission.service.SysRoleService;
import com.yunpay.permission.utils.PasswordHelper;
import com.yunpay.permission.utils.ValidateUtils;

/**
 * 权限管理模块操作员管理
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserCtrl extends BaseController {

	private static Log log = LogFactory.getLog(SysUserCtrl.class);

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private BranchService branchService;
	@Autowired
	private BranchBiz branchBiz;
	
	/**
	 * 分页列出操作员信息，并可按登录名获姓名进行查询.
	 * 
	 * @return listSysUser or operateError .
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@RequiresPermissions("sys:user:view")
	@RequestMapping("/list")
	public String listSysUser(HttpServletRequest req, PageParam pageParam, SysUser user, Model model) {
		try {

			PageBean pageBean = sysUserService.listPage(pageParam, user);
			model.addAttribute(pageBean);
			model.addAttribute("UserStatusEnum", PublicStatusEnum.toMap());
			model.addAttribute("UserTypeEnum", UserTypeEnum.toMap());
			return "modules/sys/sysUserList";
		} catch (Exception e) {
			log.error("== listSysUser exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 查看我的资料
	 * @param req
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("sys:user:view")
	@RequestMapping("/viewMyUI")
	public String viewSysUserUI(HttpServletRequest req,SysUser user, Model model) {
		user.setLoginName(super.getSysUser().getLoginName());
		user.setRealName(super.getSysUser().getRealName());
		user.setMobileNo(super.getSysUser().getMobileNo());
		user.setRemark(super.getSysUser().getRemark());
		model.addAttribute("user", user);
		return "modules/sys/sysUserMyView";
	}
	
	/**
	 * 修改密码
	 * @param req
	 * @param user
	 * @param model
	 * @return
	 */
	@RequiresPermissions("sys:user:edit")
	@RequestMapping("/editPwdUI")
	public String editPwdUI(HttpServletRequest req,SysUser user, Model model) {
		user.setId(super.getSysUser().getId());
		user.setLoginName(super.getSysUser().getLoginName());
		model.addAttribute("user", user);
		return "modules/sys/sysUserEditPwd";
	}
	
	/**
	 * 保存修改后的密码
	 * @param req
	 * @param user
	 * @param model
	 * @return
	 */
	@RequiresPermissions("sys:user:edit")
	@RequestMapping("/editPwd")
	public String editPwd(HttpServletRequest req,SysUser user, Model model,String newPwd,DwzAjax dwz) {
		user.setLoginPwd(newPwd);
		PasswordHelper.encryptPassword(user);
		sysUserService.updatePwd(user);
		return operateSuccess(model, dwz);
	}
	
	/**
	 * 查看操作员详情.
	 * 
	 * @return .
	 */
	@RequiresPermissions("sys:user:view")
	@RequestMapping("/viewUI")
	public String viewSysUserUI(HttpServletRequest req, Long id, Model model) {
		try {
			SysUser sysUser = sysUserService.getDataById(id);
			if (sysUser == null) {
				return operateError("无法获取要查看的数据", model);
			}

			// 普通操作员没有查看超级管理员的权限
			if (UserTypeEnum.USER.name().equals(this.getSysUser().getType()) && UserTypeEnum.ADMIN.name().equals(sysUser.getType())) {
				return operateError("权限不足", model);
			}

			// 准备角色列表
			model.addAttribute("rolesList", sysRoleService.listAllRole());

			// 准备该用户拥有的角色ID字符串
			List<SysUserRole> lisSysUserRoles = sysUserRoleService.listUserRoleByUserId(id);
			StringBuffer owenedRoleIdBuffer = new StringBuffer("");
			for (SysUserRole sysUserRole : lisSysUserRoles) {
				owenedRoleIdBuffer.append(sysUserRole.getRoleId());
				owenedRoleIdBuffer.append(",");
			}
			String owenedRoleIds = owenedRoleIdBuffer.toString();
			if (StringUtils.isNotBlank(owenedRoleIds) && owenedRoleIds.length() > 0) {
				owenedRoleIds = owenedRoleIds.substring(0, owenedRoleIds.length() - 1);
			}
			model.addAttribute("sysUser", sysUser);
			model.addAttribute("owenedRoleIds", owenedRoleIds);
			return "modules/sys/sysUserView";
		} catch (Exception e) {
			log.error("== viewSysUserUI exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 转到添加操作员页面 .
	 * 
	 * @return addSysUserUI or operateError .
	 */
	@RequiresPermissions("sys:user:add")
	@RequestMapping("/addUI")
	public String addSysUserUI(HttpServletRequest req, Model model) {
		try {
			model.addAttribute("sysUserList",sysUserService.listAllSysUser());
			model.addAttribute("rolesList", sysRoleService.listAllRole());
			model.addAttribute("UserStatusEnumList", PublicStatusEnum.toList());
			return "modules/sys/sysUserAdd";
		} catch (Exception e) {
			log.error("== addSysUserUI exception:", e);
			return operateError("获取角色列表数据失败", model);
		}
	}
	
	/**
	 * 获取部门树.
	 * 
	 * @return  .
	 */
	@RequiresPermissions("sys:user:add")
	@RequestMapping("/addBranchUI")
	public String addBranchUI(HttpServletRequest req, Model model,Branch branch) {
		try {
			Branch rootBranch = branchService.queryRootBranch(branch);
			List<LookupBranchTree> lookupBranchTree = branchBiz.lookupBranchTree(rootBranch);
			StringBuilder treeHtml = branchBiz.treeHtml(lookupBranchTree);
			model.addAttribute("rootBranch", rootBranch);
			model.addAttribute("treeHtml", treeHtml);
			return "modules/sys/branchThree";
		} catch (Exception e) {
			log.error("== addSysUserUI exception:", e);
			return operateError("获取角色列表数据失败", model);
		}
	}

	/**
	 * 保存一个操作员
	 * 
	 */
	@RequiresPermissions("sys:user:add")
	@RequestMapping("/add")
	public String addSysUser(HttpServletRequest req, SysUser sysUser, @RequestParam("selectVal") String selectVal, Model model, DwzAjax dwz) {
		try {
			/*sysUser.setType(UserTypeEnum.USER.name());*/ // 类型（
																// "0":'普通操作员',"1":'超级管理员'），只能添加普通操作员
			String roleUserStr = getRoleUserStr(selectVal);

			// 表单数据校验
			String validateMsg = validateSysUser(sysUser, roleUserStr);


			if (StringUtils.isNotBlank(validateMsg)) {
				return operateError(validateMsg, model); // 返回错误信息
			}

			// 校验操作员登录名是否已存在
			SysUser loginNameCheck = sysUserService.findUserByLoginName(sysUser.getLoginName());
			if (loginNameCheck != null) {
				return operateError("登录名【" + sysUser.getLoginName() + "】已存在", model);
			}

			PasswordHelper.encryptPassword(sysUser);
			sysUser.setCreater(getSysUser().getLoginName());
			sysUser.setCreateTime(new Date());
			sysUser.setEditTime(new Date());
			sysUser.setEditor(getSysUser().getEditor());
			if(sysUserService.saveUser(sysUser, roleUserStr)>0){
				//查询当前插入的操作员信息
				SysUser user = sysUserService.queryUser();
				// 保存角色关联信息
				if (StringUtils.isNotBlank(roleUserStr) && roleUserStr.length() > 0) {
					sysUserService.saveOrUpdateUserRole(user, roleUserStr);
				}
			};

			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== addSysUser exception:", e);
			return operateError("保存操作员信息失败", model);
		}
	}

	/**
	 * 验证输入的邮箱格式是否符合
	 * 
	 * @param email
	 * @return 是否合法
	 */
	public static boolean emailFormat(String email) {
		// boolean tag = true;
		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		boolean result = Pattern.matches(check, email);
		return result;
	}

	/**
	 * 验证输入的密码格式是否符合
	 * 
	 * @param loginPwd
	 * @return 是否合法
	 */
	public static boolean loginPwdFormat(String loginPwd) {
		return loginPwd.matches(".*?[^a-zA-Z\\d]+.*?") && loginPwd.matches(".*?[a-zA-Z]+.*?") && loginPwd.matches(".*?[\\d]+.*?");
	}

	/**
	 * 验证输入的操作员姓名格式是否符合
	 * 
	 * @param loginPwd
	 * @return 是否合法
	 */
	public static boolean realNameFormat(String realName) {
		return realName.matches("[^\\x00-\\xff]+");
	}

	/**
	 * 校验Sys操作员表单数据.
	 * 
	 * @param SysUser
	 *            操作员信息.
	 * @param roleUserStr
	 *            关联的角色ID串.
	 * @return
	 */
	private String validateSysUser(SysUser user, String roleUserStr) {
		String msg = ""; // 用于存放校验提示信息的变量
		msg += ValidateUtils.lengthValidate("真实姓名", user.getRealName(), true, 2, 15);
		msg += ValidateUtils.lengthValidate("登录名", user.getLoginName(), true, 3, 50);

		/*
		 * String specialChar = "`!@#$%^&*()_+\\/"; if
		 * (user.getLoginName().contains(specialChar)) { msg +=
		 * "登录名不能包含特殊字符，"; }
		 */
//		if (!realNameFormat(user.getRealName())) {
//			msg += "操作员姓名必须为中文！";
//		}

		// if (!emailFormat(user.getLoginName())) {
		// msg += "账户名格式必须为邮箱地址！";
		// }

		// 登录密码
//		String loginPwd = user.getLoginPwd();
//		String loginPwdMsg = ValidateUtils.lengthValidate("登录密码", loginPwd, true, 6, 50);
//		/*
//		 * if (StringUtils.isBlank(loginPwdMsg) &&
//		 * !ValidateUtils.isAlphanumeric(loginPwd)) { loginPwdMsg +=
//		 * "登录密码应为字母或数字组成，"; }
//		 */
//		msg += loginPwdMsg;

		// 手机号码
		String mobileNo = user.getMobileNo();
		String mobileNoMsg = ValidateUtils.lengthValidate("手机号", mobileNo, true, 0, 12);
		if (StringUtils.isBlank(mobileNoMsg) && !ValidateUtils.isMobile(mobileNo)) {
			mobileNoMsg += "手机号格式不正确，";
		}
		msg += mobileNoMsg;

		// 状态
		String status = user.getStatus();
		if (status == null) {
			msg += "请选择状态，";
		} else if (!PublicStatusEnum.ACTIVE.name().equals(status) || PublicStatusEnum.UNACTIVE.name().equals(status)) {
			msg += "状态值不正确，";
		}

		msg += ValidateUtils.lengthValidate("描述", user.getRemark(), true, 3, 100);

		// 新增操作员的权限不能为空，为空没意义
		if (StringUtils.isBlank(roleUserStr) && Long.valueOf(user.getId()) == null) {
			msg += "操作员关联的角色不能为空";
		}
		return msg;
	}

	/**
	 * 删除操作员
	 * 
	 * @return
	 * */
	@RequestMapping("/delete")
	public String deleteUserStatus(HttpServletRequest req, Long id, Model model, DwzAjax dwz) {
		sysUserService.deleteUserById(id);
		return this.operateSuccess(model, dwz);
	}

	/**
	 * 转到修改操作员界面
	 * 
	 * @return SysUserEdit or operateError .
	 */
	@RequiresPermissions("sys:user:edit")
	@RequestMapping("/editUI")
	public String editSysUserUI(HttpServletRequest req, Long id, Model model) {
		try {
			SysUser sysUser = sysUserService.getDataById(id);
			if (sysUser == null) {
				return operateError("无法获取要修改的数据", model);
			}

			// 普通操作员没有修改超级管理员的权限
			if (UserTypeEnum.USER.name().equals(this.getSysUser().getType()) && UserTypeEnum.ADMIN.name().equals(sysUser.getType())) {
				return operateError("权限不足", model);
			}
			// 准备角色列表
			model.addAttribute("rolesList", sysRoleService.listAllRole());

			// 准备该用户拥有的角色ID字符串
			List<SysUserRole> lisSysUserRoles = sysUserRoleService.listUserRoleByUserId(id);
			/*StringBuffer owenedRoleIdBuffer = new StringBuffer("");
			for (SysUserRole sysUserRole : lisSysUserRoles) {
				owenedRoleIdBuffer.append(sysUserRole.getRoleId());
				owenedRoleIdBuffer.append(",");
			}
			String owenedRoleIds = owenedRoleIdBuffer.toString();
			if (StringUtils.isNotBlank(owenedRoleIds) && owenedRoleIds.length() > 0) {
				owenedRoleIds = owenedRoleIds.substring(0, owenedRoleIds.length() - 1);
			}*/
			long owenedRoleIds = Long.valueOf(lisSysUserRoles.get(0).getRoleId().toString());
			model.addAttribute("owenedRoleIds", owenedRoleIds);

			model.addAttribute("UserStatusEnum", PublicStatusEnum.toMap());
			model.addAttribute("UserTypeEnum", UserTypeEnum.toMap());
			model.addAttribute("sysUser", sysUser);
			return "modules/sys/sysUserEdit";
		} catch (Exception e) {
			log.error("== editSysUserUI exception:", e);
			return operateError("获取修改数据失败", model);
		}
	}

	/**
	 * 保存修改后的操作员信息
	 * 
	 * @return operateSuccess or operateError .
	 */
	@RequiresPermissions("sys:user:edit")
	@RequestMapping("/edit")
	public String editSysUser(HttpServletRequest req, SysUser user, String selectVal, Model model, DwzAjax dwz) {
		try {
			Long id = Long.valueOf(user.getId());

			SysUser sysUser = sysUserService.getDataById(id);
			if (sysUser == null) {
				return operateError("无法获取要修改的操作员信息", model);
			}

			// 普通操作员没有修改超级管理员的权限
			if ("USER".equals(this.getSysUser().getType()) && "ADMIN".equals(sysUser.getType())) {
				return operateError("权限不足", model);
			}

			sysUser.setRemark(user.getRemark());
			sysUser.setMobileNo(user.getMobileNo());
			sysUser.setRealName(user.getRealName());
			// 修改时不能修状态
			// sysUser.setStatus(getInteger("status"));

			String roleUserStr = getRoleUserStr(selectVal);

			// 表单数据校验
			String validateMsg = validateSysUser(sysUser, roleUserStr);
			if (StringUtils.isNotBlank(validateMsg)) {
				return operateError(validateMsg, model); // 返回错误信息
			}

			sysUserService.updateUser(sysUser, roleUserStr);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== editSysUser exception:", e);
			return operateError("更新操作员信息失败", model);
		}
	}

	/**
	 * 根据ID冻结或激活操作员.
	 * 
	 * @return operateSuccess or operateError .
	 */
	@RequiresPermissions("sys:user:changestatus")
	@RequestMapping("/changeStatus")
	public String changeUserStatus(HttpServletRequest req, SysUser user, Model model, DwzAjax dwz) {
		try {
			Long userId = Long.valueOf(user.getId());
			SysUser sysUser = sysUserService.getDataById(userId);
			if (sysUser == null) {
				return operateError("无法获取要操作的数据", model);
			}

			if (this.getSysUser().getId() == userId) {
				return operateError("不能修改自己账户的状态", model);
			}

			// 普通操作员没有修改超级管理员的权限
			if ("USER".equals(this.getSysUser().getType()) && "ADMIN".equals(sysUser.getType())) {
				return operateError("权限不足", model);
			}

			// 2014-01-02,由删除改为修改状态
			// sysPermissionBiz.deleteUser(id);
			// 激活的变冻结，冻结的则变激活
			if (sysUser.getStatus().equals(PublicStatusEnum.ACTIVE.name())) {
				if ("ADMIN".equals(sysUser.getType())) {
					return operateError("【" + sysUser.getLoginName() + "】为超级管理员，不能冻结", model);
				}
				sysUser.setStatus(PublicStatusEnum.UNACTIVE.name());
				sysUserService.updateData(sysUser);
			} else {
				sysUser.setStatus(PublicStatusEnum.ACTIVE.name());
				sysUserService.updateData(sysUser);
			}
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== changeUserStatus exception:", e);
			return operateError("删除操作员失败:" + e.getMessage(), model);
		}
	}

	/***
	 * 重置操作员的密码（注意：不是修改当前登录操作员自己的密码） .
	 * 
	 * @return
	 */
	@RequiresPermissions("sys:user:resetpwd")
	@RequestMapping("/resetPwdUI")
	public String resetUserPwdUI(HttpServletRequest req, Long id, Model model) {
		SysUser user = sysUserService.getDataById(id);
		if (user == null) {
			return operateError("无法获取要重置的信息", model);
		}

		// 普通操作员没有修改超级管理员的权限
		if ("USER".equals(this.getSysUser().getType()) && "ADMIN".equals(user.getType())) {
			return operateError("权限不足", model);
		}

		model.addAttribute("user", user);

		return "sys/sysUserResetPwd";
	}

	/**
	 * 重置操作员密码.
	 * 
	 * @return
	 */
	@RequiresPermissions("sys:user:resetpwd")
	@RequestMapping("/resetPwd")
	public String resetUserPwd(HttpServletRequest req, Long id, String newPwd, String newPwd2, Model model, DwzAjax dwz) {
		try {
			SysUser user = sysUserService.getDataById(id);
			if (user == null) {
				return operateError("无法获取要重置密码的操作员信息", model);
			}

			// 普通操作员没有修改超级管理员的权限
			if ("USER".equals(this.getSysUser().getType()) && "ADMIN".equals(user.getType())) {
				return operateError("权限不足", model);
			}


			String validateMsg = validatePassword(newPwd, newPwd2);
			if (StringUtils.isNotBlank(validateMsg)) {
				return operateError(validateMsg, model); // 返回错误信息
			}
			user.setLoginPwd(newPwd);
			PasswordHelper.encryptPassword(user);
			sysUserService.updateData(user);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== resetUserPwd exception:", e);
			return operateError("密码重置出错:" + e.getMessage(), model);
		}
	}

	/**
	 * 得到角色和操作员关联的ID字符串
	 * 
	 * @return
	 */
	private String getRoleUserStr(String selectVal) throws Exception {
		String roleStr = selectVal;
		if (StringUtils.isNotBlank(roleStr) && roleStr.length() > 0) {
			roleStr = roleStr.substring(0, roleStr.length());
		}
		return roleStr;
	}

	/***
	 * 验证重置密码
	 * 
	 * @param newPwd
	 * @param newPwd2
	 * @return
	 */
	private String validatePassword(String newPwd, String newPwd2) {
		String msg = ""; // 用于存放校验提示信息的变量
		if (StringUtils.isBlank(newPwd)) {
			msg += "新密码不能为空，";
		} else if (newPwd.length() < 6) {
			msg += "新密码不能少于6位长度，";
		}

		if (!newPwd.equals(newPwd2)) {
			msg += "两次输入的密码不一致";
		}
		return msg;
	}
}
