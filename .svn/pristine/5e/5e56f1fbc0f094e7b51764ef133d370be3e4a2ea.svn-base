package com.yunpay.wx.rep.pay;

/**
 * 微信扫码支付返回结果类(用户扫商户)
 * 文件名称:     WechatScanRep.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月19日下午3:15:23 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月19日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class WechatScanRep extends WechatQrRep{
	
	//交易类型(必需)
	private String trade_type;
	//预支付交易会话标识(必需)
	private String prepay_id;
	//二维码链接
	//trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付
	private String code_url;
	
	public WechatScanRep(){
		
	}
	
	/**
	 * 用于构造系统中返回的错误信息
	 * @param return_code
	 * @param return_msg
	 * @param err_code
	 * @param err_code_des
	 */
	public WechatScanRep(String return_code,String return_msg,String err_code,String err_code_des){
		super( return_code, return_msg, err_code, err_code_des);
	}
	
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getPrepay_id() {
		return prepay_id;
	}
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	public String getCode_url() {
		return code_url;
	}
	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}
	
	
}
