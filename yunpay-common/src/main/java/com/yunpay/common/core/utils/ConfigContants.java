package com.yunpay.common.core.utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 功能描述：系统常量配置
 * <p>
 * 版权所有：至高通信技术发展有限公司
 * <p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * @author Devin_Yang 新增日期：2015年7月24日
 * @author Devin_Yang 修改日期：2015年7月24日
 *
 */
public class ConfigContants {
	private static final Logger logger = LoggerFactory.getLogger(ConfigContants.class);
	private static Properties prop = null;
	public static String IMAGEPATH = ""; // 图片路径
	public static String CERTPATH = ""; // //支付证书路径
	public static String CERTFILENAME = ""; // //支付证书路径
	public static String IMAGEURL = "";  // 图片路径
	public static String WEBURL = "";  // 项目域名
	public static String JIHUOMA_MERCHANT = "";  // 激活码商户号
	public static String JIHUOMA_CASHIER = "";   // 激活码收银员编号
	//门店创建配置信息
	public static String STORE_APP_ID = "";   // 激活码收银员编号
	public static String STORE_APP_PRIVATE_KEY = "";   // 激活码收银员编号
	public static String STORE_APP_PUBLICKEY = "";   // 激活码收银员编号
	public static String STORE_OPERATE_NOTIFY_URL = "";   // 激活码收银员编号
	public static String STORE_ISV_UID = "";   // 激活码收银员编号
	public static String SYS_SERVICE_PROVIDER_ID = "";   // 激活码收银员编号
	public static String PAYKEYPATH = "";   // 支付证书生成目录（商户配置支付信息默认生成秘钥对）
	public static String PASSKEYPATH = "";   // 卡券证书生成目录（商户配置支付信息默认生成秘钥对）
	
	static {
		InputStream is = ConfigContants.class.getClassLoader()
				.getResourceAsStream("configContants.properties");
		try {
			prop = new Properties();
			prop.load(is);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		WEBURL  = prop.getProperty("webURL");
		IMAGEPATH = prop.getProperty("imagePath");
		IMAGEURL  = WEBURL + prop.getProperty("imageURL");
		
		CERTPATH = prop.getProperty("certPath");	
		CERTFILENAME =  prop.getProperty("certFileName");
		JIHUOMA_MERCHANT = prop.getProperty("JIHUOMA_MERCHANT");
		JIHUOMA_CASHIER	= prop.getProperty("JIHUOMA_CASHIER");
		
		STORE_APP_ID = prop.getProperty("STORE_APP_ID");
		STORE_APP_PRIVATE_KEY = prop.getProperty("STORE_APP_PRIVATE_KEY");
		STORE_APP_PUBLICKEY = prop.getProperty("STORE_APP_PUBLICKEY");
		STORE_OPERATE_NOTIFY_URL = WEBURL + prop.getProperty("STORE_OPERATE_NOTIFY_URL");
		STORE_ISV_UID = prop.getProperty("STORE_ISV_UID");
		PAYKEYPATH = prop.getProperty("PAYKEYPATH");
		PASSKEYPATH = prop.getProperty("PASSKEYPATH");
		SYS_SERVICE_PROVIDER_ID=prop.getProperty("SYS_SERVICE_PROVIDER_ID");
		
	}

}
