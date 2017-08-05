package com.yunpay.ali.config;

import java.util.ResourceBundle;

public class AliPayConfig {
	public static String BAR_PAY_API="";
	public static String SCAN_PAY_API="";
	
	static {
		ResourceBundle rb = ResourceBundle.getBundle("payurl/alipay");
		AliPayConfig.BAR_PAY_API = rb.getString("BAR_PAY_API").trim();
		AliPayConfig.SCAN_PAY_API = rb.getString("SCAN_PAY_API").trim();
	}
}
