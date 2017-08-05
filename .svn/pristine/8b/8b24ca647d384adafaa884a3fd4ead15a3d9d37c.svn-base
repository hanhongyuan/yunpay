package com.yunpay.wx.config;

import java.util.ResourceBundle;

/**
 * 微信卡券全局配置
 * 文件名称:     WechatCardConfig.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月31日下午4:04:56 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月31日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class WechatCardConfig {
	//获取access_token
	public static String ACCESS_TOKEN_API = "";
	//图片上传
	public static String UPLOAD_IMG_API = "";
	//创建卡券
	public static String CARD_CREATE_API = "";
	//创建卡券投放码
	public static String CREATE_QRCODE_API= "";
	
	
	static {
		ResourceBundle rb = ResourceBundle.getBundle("payurl/wechatcard");	
		WechatCardConfig.ACCESS_TOKEN_API = rb.getString("ACCESS_TOKEN_API").trim();
		WechatCardConfig.UPLOAD_IMG_API = rb.getString("UPLOAD_IMG_API").trim();
		WechatCardConfig.CARD_CREATE_API = rb.getString("CARD_CREATE_API").trim();
		WechatCardConfig.CREATE_QRCODE_API = rb.getString("CREATE_QRCODE_API").trim();
	}
}
