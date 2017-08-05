package com.yunpay.ali.rep;

import java.util.Date;

public class AliQueryRep extends AliQrRep{
	//支付宝订单号(必须)
	private String trade_no;
	//平台提交订单号(必须)
	private String out_trade_no;
	//买家支付宝账号 (必须)
	private String buyer_logon_id ;
	//交易状态
	/*交易状态：WAIT_BUYER_PAY（交易创建，等待买家付款）、
	 * TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）、
	 * TRADE_SUCCESS（交易支付成功）、
	 * TRADE_FINISHED（交易结束，不可退款） 
	 */
	private String trade_status;
	//交易金额 (必须)
	private String total_amount ;
	//实收金额 (必须)
	private String receipt_amount ;
	//买家付款的金额
	private String buyer_pay_amount ;
	//交易支付时间(必须)
	private Date send_pay_date;
	//交易使用的资金渠道(必须)
	private String fund_channel;
	//该支付工具类型所使用的金额 (必须)
	private String amount ;
	//渠道实际付款金额(必须)
	private String real_amount ;
	//买家在支付宝的用户id(必须)
	private String buyer_user_id;
	
	public AliQueryRep(){
		
	}
	
	public AliQueryRep(String code,String msg,String sub_code,String sub_msg){
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
	public String getBuyer_logon_id() {
		return buyer_logon_id;
	}
	public void setBuyer_logon_id(String buyer_logon_id) {
		this.buyer_logon_id = buyer_logon_id;
	}
	public String getTrade_status() {
		return trade_status;
	}
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public String getReceipt_amount() {
		return receipt_amount;
	}
	public void setReceipt_amount(String receipt_amount) {
		this.receipt_amount = receipt_amount;
	}
	public String getBuyer_pay_amount() {
		return buyer_pay_amount;
	}
	public void setBuyer_pay_amount(String buyer_pay_amount) {
		this.buyer_pay_amount = buyer_pay_amount;
	}
	public Date getSend_pay_date() {
		return send_pay_date;
	}
	public void setSend_pay_date(Date send_pay_date) {
		this.send_pay_date = send_pay_date;
	}
	public String getFund_channel() {
		return fund_channel;
	}
	public void setFund_channel(String fund_channel) {
		this.fund_channel = fund_channel;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getReal_amount() {
		return real_amount;
	}
	public void setReal_amount(String real_amount) {
		this.real_amount = real_amount;
	}
	public String getBuyer_user_id() {
		return buyer_user_id;
	}
	public void setBuyer_user_id(String buyer_user_id) {
		this.buyer_user_id = buyer_user_id;
	}
	
	
}
