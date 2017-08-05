/**
 * 
 */
package com.yunpay.common.core.utils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述：秘钥生成工具
 * <p>
 * 版权所有：广东移领科技有限公司
 * <p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * 
 * @author Devin_Yang 新增日期：2016年2月22日
 * @author Devin_Yang 修改日期：2016年2月22日
 * 
 */

public class OpensslUtil {
	public static final Logger logger = LoggerFactory.getLogger(OpensslUtil.class);

	public static final String rsa_public_key = "rsa_public_key.pem";
	public static final String rsa_private_key = "rsa_private_key.pem";
	public static final String pkcs8_rsa_private_key = "pkcs8_rsa_private_key.pem";
	// 秘钥生成命令
//	public static final String generate_rsa_public_key = "openssl genrsa -out rsa_private_key.pem 1024";
//	public static final String generate_rsa_private_key = "openssl rsa -in rsa_private_key.pem -pubout -out rsa_public_key.pem";
//	public static final String generate_pkcs8_rsa_private_key = "openssl pkcs8 -topk8 -in rsa_private_key.pem -out pkcs8_rsa_private_key.pem -nocrypt";

	/**
	 * 
	 * @param merchantNo 商户号
	 * @throws Exception
	 */
	public static Map<String,String> generateCert(final String orgNo,Integer type) throws Exception {
		Map<String,String> map = new HashMap<String, String>();
		if (StringUtils.isEmpty(orgNo)) {
			throw new RuntimeException("商户号为空");
		}
		String path  = "";
		if(type==0){
			path = ConfigContants.PAYKEYPATH + File.separator + orgNo;
		}else{
			path = ConfigContants.PASSKEYPATH + File.separator + orgNo;
		}
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		String public_key_cmd = "openssl genrsa -out "+path+File.separator+"rsa_private_key.pem 1024";
		String private_key_cmd = "openssl rsa -in "+path+File.separator+"rsa_private_key.pem -pubout -out "+
		path+File.separator+"rsa_public_key.pem";
		String pk8_private_key_cmd = "openssl pkcs8 -topk8 -in "+path+File.separator+"rsa_private_key.pem -out "+
		path+File.separator+"pkcs8_rsa_private_key.pem -nocrypt";
		
		/*  暂时注释掉 
		 * 
		 * Runtime.getRuntime().exec(public_key_cmd).waitFor();
		Runtime.getRuntime().exec(private_key_cmd).waitFor();
		Runtime.getRuntime().exec(pk8_private_key_cmd).waitFor();*/
		/*map.put("publicKey", readPublicKey(orgNo,type));
		map.put("privateKey", readPrivateKey(orgNo,type));*/
		
		map.put("publicKey", "rsa_private_key.pem 1024");
		map.put("privateKey", "rsa_private_key.pem 1024");
		
		return map;
	}
	
	
	/**
	 * 
	 * @param merchantNo
	 *            商户号
	 * @throws Exception
	 */
	public static Map generatePkcs8Cert(final String orgNo,Integer type, String privateKey) throws Exception {
		Map<String,String> map = new HashMap<String, String>();
		if (StringUtils.isEmpty(orgNo)) {
			throw new RuntimeException("商户号为空");
		}
		String path  = "";
		if(type==0){
			path = ConfigContants.PAYKEYPATH + File.separator + orgNo;
		}else{
			path = ConfigContants.PASSKEYPATH + File.separator + orgNo;
		}
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
		StringBuffer sb = new StringBuffer();
		sb.append("-----BEGIN RSA PRIVATE KEY-----\n");
		for (int i = 1; i < privateKey.length() + 1 ; i++) {//获取字符串长度
			sb.append(privateKey.charAt(i - 1));
			if (i % 64 == 0) {//如果是10的倍数，打印一个换行符
				sb.append("\n");
			}
		}
		sb.append("\n-----END RSA PRIVATE KEY-----\n");
		writeData(path+File.separator+"rsa_private_key.pem", sb.toString());
		
//		String private_key_cmd = "openssl genrsa -out "+path+File.separator+"rsa_private_key.pem 1024";
		String public_key_cmd = "openssl rsa -in "+path+File.separator+"rsa_private_key.pem -pubout -out "+
		path+File.separator+"rsa_public_key.pem";
		String pk8_private_key_cmd = "openssl pkcs8 -topk8 -in "+path+File.separator+"rsa_private_key.pem -out "+
		path+File.separator+"pkcs8_rsa_private_key.pem -nocrypt";
//		logger.info("public_key_cmd="+public_key_cmd);
//		logger.info("private_key_cmd="+private_key_cmd);
//		logger.info("pk8_private_key_cmd="+pk8_private_key_cmd);
	
//		Runtime.getRuntime().exec(private_key_cmd).waitFor();
		Runtime.getRuntime().exec(public_key_cmd).waitFor();
		Runtime.getRuntime().exec(pk8_private_key_cmd).waitFor();
		map.put("publicKey", readPublicKey(orgNo,type));
		map.put("privateKey", readPrivateKey(orgNo,type));
		
		return map;
	}
	
	public static void writeData(String saveFileName,String content) throws IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream(saveFileName));
		InputStream is = null;
		try {
			out.write(content.getBytes("utf-8"));
		} catch (IOException exception) {
			exception.printStackTrace();
		} finally {
			if (is != null) {
				is.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	

	/**
	 * 公钥读取
	 * 
	 * @param merchantNo
	 * @return
	 * @throws IOException 
	 */
	public static String readPublicKey(String orgNo,Integer type) throws IOException {
		String path = "";
		if(type==0){
			path = ConfigContants.PAYKEYPATH + File.separator + orgNo+File.separator+rsa_public_key;
		}else{
			 path = ConfigContants.PASSKEYPATH + File.separator + orgNo+File.separator+rsa_public_key;
		}
		String publicKey = "";
		try {
			if(new File(path).exists()){
				BufferedReader br = new BufferedReader(new FileReader(path));
				String s = br.readLine();
				s = br.readLine();
				while (s.charAt(0) != '-'){
					publicKey += s ;
					s = br.readLine();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(publicKey);
        publicKey = m.replaceAll("");
        logger.info("publicKey="+publicKey);
		return publicKey;

	}

	/**
	 * 私钥读取
	 * 
	 * @param merchantNo
	 * @return
	 * @throws IOException 
	 */
	public static String readPrivateKey(String orgNo,Integer type) throws IOException {
		String path = "";
		if(type==0){
			path = ConfigContants.PAYKEYPATH + File.separator + orgNo+File.separator+pkcs8_rsa_private_key;
		}else{
			 path = ConfigContants.PASSKEYPATH + File.separator + orgNo+File.separator+pkcs8_rsa_private_key;
		}
		String privateKey = "";
		try {
			if(new File(path).exists()){
				BufferedReader br = new BufferedReader(new FileReader(path));
				String s = br.readLine();
				s = br.readLine();
				while (s.charAt(0) != '-'){
					privateKey += s ;
					s = br.readLine();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(privateKey);
        privateKey = m.replaceAll("");
        logger.info("privateKey="+privateKey);
		return privateKey;

	}
	
	public static void main(String[] args){
		String privateKey = "MIICXQIBAAKBgQCcfk695feZXSdbwXAaO+aBXSGQxWuokGHjY6C7+Nm6hdtKK9Lo2slo5viuNyuKqj7V8JgpVw4rHb2ieyGnpCnZEIcIav854U7xbJAmljVzBdGLfUZBfVlS7gVHD1BfJLP4Xi7xMhbIxL"
				+ "TcR1rnkCc6UWfB7YurfDgEZ/nr0NkN4QIDAQABAoGBAJK7V4d0vcC9+G5vJHZknc/EC/"
				+ "nbMgOeRTpZKte1ECl04tVb2+jbY6gJkTiAoEHnOP2OFo4Eg1NoEmvrufWe1mCqOPbsyP157ALMcxZllMe3am4kSOw4bJ8PpKU1d0CQCyFz17g/8kEF5jpCrxSfCxaFtTOp6sIgi9dasFEer"
				+ "S0xAkEAzm1MP7BAbhTAzZeNAhURCPSg/2dribmSrUV4jPZis4nLhD6gwwonEvGFC8ctNxqWGZbicERnHcPOSFsgU6k/5QJBAMITMqgy6jk5tkUzje6ERWQgWpFwKqElJWZGLeUOU4P77g"
				+ "50j6SAfWHlAHd1YqB5NOB5xqA3o9dZT8WPUqxkHk0CQQC1GxtcfSvp6HdHaQEjpIvviYB+06N7j75qGpsrQTdTQT+25KNyusORUShjLvoycDbkeIZt7PVzHckrnhd8ju8pAk"
				+ "BMmZ017BqsiY3alHWhvc1Rrr9whhAdWHcBfhOhQ91My8PzKqiDaj+SwvtDKy7JXe2z5/ywwiVF2zd0J5Se/ElFAkB3FvWXnaCVv2B0FVIBGlgD3wnT24yJMqW09ezwoUqM/Frflj7AJj6kl3vuEx5yg+Uc6rTwfekzkfcICwWhJHMS";
		StringBuffer sb = new StringBuffer();
		sb.append("-----BEGIN PRIVATE KEY-----\n");
		for (int i = 1; i < privateKey.length() + 1 ; i++) {//获取字符串长度
			sb.append(privateKey.charAt(i - 1));
			if (i % 64 == 0) {//如果是10的倍数，打印一个换行符
				sb.append("\n");
			}
		}
		sb.append("\n-----END PRIVATE KEY-----");
		System.out.println(sb.toString());
	}

}
