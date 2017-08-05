package com.yunpay.wx.config;

import java.util.ResourceBundle;


/**
 * 微信支付全局配置
 * 文件名称:     WechatPayConfig.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月16日下午3:07:59 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月16日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class WechatPayConfig {

	// sdk的版本号
	public static final String sdkVersion = "java sdk 1.0.1";
	
	//是否使用异步线程的方式来上报API测速，默认为异步模式
	public static boolean useThreadToDoReport = true;
	
	//条码支付API请求地址
	public static String BAR_PAY_API = "";
	
	//扫码支付API请求地址
	public static String SCAN_PAY_API = "";

	//订单查询API请求地址
	public static String ORDER_QUERY_API = "";
	
	//订单关闭API请求地址
	public static String ORDER_CLOSE_API = "";
	
	//订单撤销API请求地址
	public static String ORDER_REVERSE_API = "";

	//订单退款API
	public static String ORDER_REFUND_API = "";

	//退款查询API
	public static String ORDER_REFUND_QUERY_API = "";

	//下载对账单API
	public static String DOWNLOAD_BILL_API = "";

	//统计上报API
	public static String REPORT_API = "";
	

	static {
		ResourceBundle rb = ResourceBundle.getBundle("payurl/wechatpay");	
		WechatPayConfig.useThreadToDoReport = Boolean.valueOf(rb.getString("useThreadToDoReport").trim());
		//API接口
		WechatPayConfig.BAR_PAY_API = rb.getString("BAR_PAY_API").trim();
		WechatPayConfig.SCAN_PAY_API = rb.getString("SCAN_PAY_API").trim();
		WechatPayConfig.ORDER_QUERY_API = rb.getString("ORDER_QUERY_API").trim();
		WechatPayConfig.ORDER_CLOSE_API = rb.getString("ORDER_CLOSE_API").trim();
		WechatPayConfig.ORDER_REVERSE_API = rb.getString("ORDER_REVERSE_API").trim();
		WechatPayConfig.ORDER_REFUND_API = rb.getString("ORDER_REFUND_API").trim();
		WechatPayConfig.ORDER_REFUND_QUERY_API = rb.getString("ORDER_REFUND_QUERY_API").trim();
		WechatPayConfig.DOWNLOAD_BILL_API = rb.getString("DOWNLOAD_BILL_API").trim();
		WechatPayConfig.REPORT_API = rb.getString("REPORT_API").trim();
	}
}
