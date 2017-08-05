package com.yunpay.ali.req;

/**
 * 支付宝扫码支付请求类
 * 文件名称:     AliScanReq.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月20日下午5:01:49 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月20日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class AliScanReq extends AliQrReq{
	//支付结果通知地址(必需)
	private String notify_url;
	
	/**
	 * 构造支付宝扫码支付请求参数
	 * @param appId
	 * @param notify_url
	 * @param privateKey
	 * @param alipayPublicKey
	 * @param out_trade_no
	 * @param total_amount
	 * @param subject
	 * @param body
	 * @param terminal_id
	 * @param sys_service_provider_id
	 */
	public AliScanReq(String appId,String notify_url,String privateKey,String alipayPublicKey,String out_trade_no,
			String total_amount,String subject,String body,String terminal_id,String sys_service_provider_id,
			String timeout_express){
		setAppId(appId);
		setNotify_url(notify_url);
		setPrivateKey(privateKey);
		setAlipayPublicKey(alipayPublicKey);
		setOut_trade_no(out_trade_no);
		setTotal_amount(total_amount);
		setSubject(subject);
		setBody(body);
		setTerminal_id(terminal_id);
		setSys_service_provider_id(sys_service_provider_id);
		setTimeout_express(timeout_express);
	}
	
	/**
	 * 构造支付宝扫码支付请求类(带扩展参数)
	 * @param appId
	 * @param notify_url
	 * @param privateKey
	 * @param alipayPublicKey
	 * @param out_trade_no
	 * @param total_amount
	 * @param subject
	 * @param body
	 * @param terminal_id
	 * @param hb_fq_num
	 * @param sys_service_provider_id
	 * @param hb_fq_seller_percent
	 * @param timeout_express
	 */
	public AliScanReq(String appId,String notify_url,String privateKey,String alipayPublicKey,String out_trade_no,
			String total_amount,String subject,String body,String terminal_id,String hb_fq_num,
			String sys_service_provider_id,String hb_fq_seller_percent,String timeout_express){
		setAppId(appId);
		setNotify_url(notify_url);
		setPrivateKey(privateKey);
		setAlipayPublicKey(alipayPublicKey);
		setOut_trade_no(out_trade_no);
		setTotal_amount(total_amount);
		setSubject(subject);
		setBody(body);
		setTerminal_id(terminal_id);
		setHb_fq_num(hb_fq_num);
		setSys_service_provider_id(sys_service_provider_id);
		setHb_fq_seller_percent(hb_fq_seller_percent);
		setTimeout_express(timeout_express);
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	
	
}
