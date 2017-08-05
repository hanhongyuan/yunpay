package com.yunpay.ali.req;

/**
 * 支付宝条码支付请求类
 * 文件名称:     AliBarRep.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月20日下午4:11:13 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月20日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class AliBarReq extends AliQrReq{
	
	//支付场景(bar_code,wave_code)
	private String scene="bar_code";
	//支付码
	private String auth_code ;
	
	public AliBarReq(){
		
	}
	
	/**
	 * 支付宝条码支付请求类	
	 * @param appId
	 * @param auth_code
	 * @param privateKey
	 * @param alipayPublicKey
	 * @param out_trade_no
	 * @param total_amount
	 * @param subject
	 * @param body
	 * @param terminal_id
	 * @param sys_service_provider_id
	 */
	public AliBarReq(String appId,String auth_code,String privateKey,String alipayPublicKey,String out_trade_no,
			String total_amount,String subject,String body,String terminal_id,
			String sys_service_provider_id,String timeout_express){
		setAppId(appId);
		setAuth_code(auth_code);
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
	 * 支付宝条码支付请求类(带扩展参数)
	 * @param appId
	 * @param auth_code
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
	public AliBarReq(String appId,String auth_code,String privateKey,String alipayPublicKey,String out_trade_no,
			String total_amount,String subject,String body,String terminal_id,String hb_fq_num,
			String sys_service_provider_id,String hb_fq_seller_percent,String timeout_express){
		setAppId(appId);
		setAuth_code(auth_code);
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
	
	
	public String getScene() {
		return scene;
	}
	public void setScene(String scene) {
		this.scene = scene;
	}
	public String getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}
	
	
}
