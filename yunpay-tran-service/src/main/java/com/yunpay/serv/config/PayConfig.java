package com.yunpay.serv.config;

import java.util.ResourceBundle;

public class PayConfig {
	//支付网关
	public static String PAY_GATEWAY = "";
	
	public static String WECHAT_APPID = "";
	public static String WECHAT_MERCHID="";
	public static String WECHAT_APISECRET="";
	public static String WECHAT_APPSECRET="";
	public static String WECHAT_CERTPATH="";
	public static String WECHAT_CERTPWD="";
	
	//微信相关扫码支付回调地址
	public static String WECHAT_SCAN_NOTIFY_URL = "";
	//wap支付回调地址
	public static String WECHAT_WAP_NOTIFY_URL = "";
	//接收code
	public static String WECHAT_REDIRECT_URL = "";
	//接收code并转发给调用方
	public static String WECHAT_REDIRECT_SEND_URL = "";
	//微信wap支付获取authcode地址
	public static String WECHAT_AUTHCODE_URL = "";
	//微信wap支付获取openid地址
	public static String WECHAT_OPENID_URL = "";
	
	
	//支付宝扫码支付回调地址
	public static String ALI_SCAN_NOTIFY_URL = "";
	//支付宝wap支付回调地址
	public static String ALI_WAP_NOTIFY_URL = "";
	//支付宝前端回调地址
	public static String ALI_WAP_RETURN_URL = "";
	
	//银联扫码支付回调地址
	public static String UNION_SCAN_NOTIFY_URL = "";
	//银联wap支付回调地址
	public static String UNION_WAP_NOTIFY_URL = "";
	//银联前端回调地址
	public static String UNION_WAP_RETURN_URL = "";
	
	
	//卡券logo保存路径
	public static String CARD_IMG_PATH = "";
	
	
	
	static {
		//微信相关
		ResourceBundle rb = ResourceBundle.getBundle("payconfig/payconfig");
		PayConfig.PAY_GATEWAY = rb.getString("PAY_GATEWAY").trim();
		
		PayConfig.WECHAT_APPID = rb.getString("WECHAT_APPID").trim();
		PayConfig.WECHAT_MERCHID= rb.getString("WECHAT_MERCHID").trim();
		PayConfig.WECHAT_APISECRET= rb.getString("WECHAT_APISECRET").trim();
		PayConfig.WECHAT_APPSECRET= rb.getString("WECHAT_APPSECRET").trim();
		PayConfig.WECHAT_CERTPATH= rb.getString("WECHAT_CERTPATH").trim();
		PayConfig.WECHAT_CERTPWD= rb.getString("WECHAT_CERTPWD").trim();
		
		PayConfig.WECHAT_SCAN_NOTIFY_URL = PAY_GATEWAY + rb.getString("WECHAT_SCAN_NOTIFY_URL").trim();
		PayConfig.WECHAT_WAP_NOTIFY_URL = PAY_GATEWAY + rb.getString("WECHAT_WAP_NOTIFY_URL").trim();
		PayConfig.WECHAT_REDIRECT_URL = PAY_GATEWAY + rb.getString("WECHAT_REDIRECT_URL").trim();
		PayConfig.WECHAT_REDIRECT_SEND_URL = PAY_GATEWAY + rb.getString("WECHAT_REDIRECT_SEND_URL").trim();
		PayConfig.WECHAT_AUTHCODE_URL = rb.getString("WECHAT_AUTHCODE_URL").trim();
		PayConfig.WECHAT_OPENID_URL = rb.getString("WECHAT_OPENID_URL").trim();
		//支付宝相关
		PayConfig.ALI_SCAN_NOTIFY_URL = PAY_GATEWAY + rb.getString("ALI_SCAN_NOTIFY_URL").trim();
		PayConfig.ALI_WAP_NOTIFY_URL = PAY_GATEWAY + rb.getString("ALI_WAP_NOTIFY_URL").trim();
		PayConfig.ALI_WAP_RETURN_URL = PAY_GATEWAY + rb.getString("ALI_WAP_RETURN_URL").trim();
		
		PayConfig.UNION_SCAN_NOTIFY_URL = PAY_GATEWAY + rb.getString("UNION_SCAN_NOTIFY_URL").trim();
		PayConfig.UNION_WAP_NOTIFY_URL = PAY_GATEWAY + rb.getString("UNION_WAP_NOTIFY_URL").trim();
		PayConfig.UNION_WAP_RETURN_URL = PAY_GATEWAY + rb.getString("UNION_WAP_RETURN_URL").trim();
		
		PayConfig.CARD_IMG_PATH = rb.getString("CARD_IMG_PATH").trim();
	}
}
