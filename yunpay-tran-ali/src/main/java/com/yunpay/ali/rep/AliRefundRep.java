package com.yunpay.ali.rep;

import java.util.Date;

public class AliRefundRep extends AliQrRep{
	
	private String trade_no;
	
	private String out_trade_no ;
	//本次退款是否发生了资金变化
	private String fund_change ;
	//退款金额
	private String refund_fee;
	//退款时间
	private Date gmt_refund_pay;
	//交易使用的资金渠道(必须)
	private String fund_channel;
	//该支付工具类型所使用的金额 (必须)
	private String amount ;
	//渠道实际付款金额(必须)
	private String real_amount ;
	//买家在支付宝的用户id(必须)
	private String buyer_user_id;
	
	public String getBuyer_user_id() {
		return buyer_user_id;
	}

	public void setBuyer_user_id(String buyer_user_id) {
		this.buyer_user_id = buyer_user_id;
	}

	public AliRefundRep(){
		
	}
	
	public AliRefundRep(String code,String msg,String sub_code,String sub_msg){
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

	public String getFund_change() {
		return fund_change;
	}

	public void setFund_change(String fund_change) {
		this.fund_change = fund_change;
	}

	public String getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}

	public Date getGmt_refund_pay() {
		return gmt_refund_pay;
	}

	public void setGmt_refund_pay(Date gmt_refund_pay) {
		this.gmt_refund_pay = gmt_refund_pay;
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
	
	
}
