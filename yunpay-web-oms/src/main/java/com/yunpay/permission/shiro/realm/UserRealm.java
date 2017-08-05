package com.yunpay.permission.shiro.realm;

import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.yunpay.common.core.enums.PublicStatusEnum;
import com.yunpay.permission.entity.SysUser;
import com.yunpay.permission.service.SysUserRoleService;
import com.yunpay.permission.service.SysUserService;
import com.yunpay.permission.service.SysRolePermissionService;

/**
 * 自定义realm .
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysRolePermissionService sysRolePermissionService;

	@SuppressWarnings("unchecked")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String loginName = (String) principals.getPrimaryPrincipal();

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		SysUser user = (SysUser) session.getAttribute("SysUser");
		if (user == null) {
			user = sysUserService.findUserByLoginName(loginName);
			session.setAttribute("SysUser", user);
		}
		// 根据登录名查询操作员
		Long userId = Long.valueOf(user.getId());

		Set<String> roles = (Set<String>) session.getAttribute("ROLES");
		if (roles == null || roles.isEmpty()) {
			roles = sysUserRoleService.getRoleCodeByUserId(userId);
			session.setAttribute("ROLES", roles);
		}
		// 查询角色信息
		authorizationInfo.setRoles(roles);

		Set<String> permisstions = (Set<String>) session.getAttribute("PERMISSIONS");
		if (permisstions == null || permisstions.isEmpty()) {
			permisstions = sysRolePermissionService.getPermissionsByUserId(userId);
			session.setAttribute("PERMISSIONS", permisstions);
		}
		// 根据用户名查询权限
		authorizationInfo.setStringPermissions(permisstions);
		return authorizationInfo;
	}

	@Override
	// 验证的核心方法
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String loginName = (String) token.getPrincipal();
		if (StringUtils.isEmpty(loginName.trim())) {
			throw new UnknownAccountException();// 没找到帐号
		}

		// 根据登录名查询操作员
		SysUser user = sysUserService.findUserByLoginName(loginName);
		//token.setRememberMe(true);
		if (user == null) {
			throw new UnknownAccountException();// 没找到帐号
		}

		if (PublicStatusEnum.UNACTIVE.equals(user.getStatus())) {
			throw new LockedAccountException(); // 帐号锁定
		}

		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getLoginName(), // 登录名
				user.getLoginPwd(), // 密码
				ByteSource.Util.bytes(user.getCredentialsSalt()), // salt=username+salt
				getName() // realm name
		);

		return authenticationInfo;
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

}
