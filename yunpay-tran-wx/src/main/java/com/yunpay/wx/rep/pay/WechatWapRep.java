package com.yunpay.wx.rep.pay;

public class WechatWapRep extends WechatQrRep{
	//交易类型(必需)
	private String trade_type;
	//预支付交易会话标识(必需)
	private String prepay_id;
	//二维码链接
	//trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付
	private String code_url;
	
	public WechatWapRep(){
		
	}
	
	/**
	 * 用于构造系统中返回的错误信息
	 * @param return_code
	 * @param return_msg
	 * @param err_code
	 * @param err_code_des
	 */
	public WechatWapRep(String return_code,String return_msg,String err_code,String err_code_des){
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
