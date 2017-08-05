package com.yunpay.ali.rep;

public class AliCancelRep extends AliQrRep{
	//支付宝交易号 
	private String trade_no;
	//平台提交订单号(必须)
	private String out_trade_no;
	//是否需要重试
	private String retry_flag;
	//本次撤销触发的交易动作
	/*
	close：关闭交易，无退款
	refund：产生了退款 
	*/
	
	private String action;
	
	public AliCancelRep(){
		
	}
	
	public AliCancelRep(String code,String msg,String sub_code,String sub_msg){
		super(code,msg,sub_code,sub_msg);
	}
	
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getRetry_flag() {
		return retry_flag;
	}
	public void setRetry_flag(String retry_flag) {
		this.retry_flag = retry_flag;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
}
