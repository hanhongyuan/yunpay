package com.yunpay.permission.utils;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.yunpay.permission.entity.SysUser;

/**
 * 生成密码工具类
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public class PasswordHelper {

	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	private static String algorithmName = "md5";

	private static String hashIteration = "2";

	private static int hashIterations = Integer.valueOf(hashIteration);

	public static void encryptPassword(SysUser sysUser) {

		sysUser.setsalt(randomNumberGenerator.nextBytes().toHex());

		String newPassword = new SimpleHash(algorithmName, sysUser.getLoginPwd(), ByteSource.Util.bytes(sysUser.getCredentialsSalt()), hashIterations).toHex();

		sysUser.setLoginPwd(newPassword);
	}
	
	public static void main(String args[]){
		//String salt = randomNumberGenerator.nextBytes().toHex();
		String newPwd = new SimpleHash(algorithmName,"123456",ByteSource.Util.bytes("admin"+"8d78869f470951332959580424d4bf4f"),2).toHex();
		System.out.println(newPwd);
	}

	/**
	 * 加密密码
	 * 
	 * @param loginPwd
	 *            明文密码
	 * @param salt
	 * @return
	 */
	public static String getPwd(String loginPwd, String salt) {
		String newPassword = new SimpleHash(algorithmName, loginPwd, ByteSource.Util.bytes(salt), hashIterations).toHex();
		return newPassword;
	}

}
