package com.yunpay.permission.shiro.credentials;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.yunpay.permission.entity.SysUser;
import com.yunpay.permission.service.SysUserService;

/**
 * 自定义的市容凭证匹配器
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

	@Autowired
	private SysUserService sysUserService;

	private Cache<String, AtomicInteger> passwordRetryCache;

	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	/**
	 * 做认证匹配
	 */
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		String username = (String) token.getPrincipal();
		// retry count + 1
		AtomicInteger retryCount = passwordRetryCache.get(username);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(username, retryCount);
		}
		if (retryCount.incrementAndGet() > 5) {
			// if retry count > 5 throw
			throw new ExcessiveAttemptsException();
		}

		boolean matches = super.doCredentialsMatch(token, info);
		if (matches) {
			// clear retry count
			passwordRetryCache.remove(username);

			// 根据登录名查询操作员
			SysUser user = sysUserService.findUserByLoginName(username);
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			session.setAttribute("SysUser", user);
		}
		return matches;
	}
}
