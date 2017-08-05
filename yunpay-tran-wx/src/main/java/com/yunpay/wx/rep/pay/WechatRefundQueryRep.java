package com.yunpay.wx.rep.pay;

public class WechatRefundQueryRep extends WechatQrRep{
	
	//支付订单号(微信平台产生)
	private String transaction_id;
	//支付提交订单号(调用方提交)
	private String out_trade_no;
	//订单总额
	private String total_fee;
	//应结订单金额
	private String settlement_total_fee;
	//货币种类
	private String fee_type;
	//现金支付金额
	private String cash_fee ;
	//退款记录数
	private String refund_count;
	
	//平台提交的退款单号
	private String out_refund_no_0;
	private String out_refund_no_1;
	private String out_refund_no_2;
	
	//微信返回的退款单号
	private String refund_id_0;
	private String refund_id_1;
	private String refund_id_2;
	
	//退款渠道
	private String refund_channel_0;
	private String refund_channel_1;
	private String refund_channel_2;
	
	//申请退款金额
	private String refund_fee_0;
	private String refund_fee_1;
	private String refund_fee_2;
	
	//退款金额
	private String settlement_refund_fee_0;
	private String settlement_refund_fee_1;
	private String settlement_refund_fee_2;
	
	//退款状态
	private String refund_status_0;
	private String refund_status_1;
	private String refund_status_2;
	
	//退款资金来源
	private String refund_account_0;
	private String refund_account_1;
	private String refund_account_2;
	
	//退款入账账户
	private String refund_recv_accout_0;
	private String refund_recv_accout_1;
	private String refund_recv_accout_2;
	
	//退款成功时间
	private String refund_success_time_0;
	private String refund_success_time_1;
	private String refund_success_time_2;
	
	public WechatRefundQueryRep(){
		
	}
	
	public WechatRefundQueryRep(String return_code,String return_msg,String err_code,String err_code_des){
		super( return_code, return_msg, err_code, err_code_des);
	}
	
	
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getSettlement_total_fee() {
		return settlement_total_fee;
	}
	public void setSettlement_total_fee(String settlement_total_fee) {
		this.settlement_total_fee = settlement_total_fee;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getCash_fee() {
		return cash_fee;
	}
	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}
	public String getRefund_count() {
		return refund_count;
	}
	public void setRefund_count(String refund_count) {
		this.refund_count = refund_count;
	}

	public String getOut_refund_no_0() {
		return out_refund_no_0;
	}

	public void setOut_refund_no_0(String out_refund_no_0) {
		this.out_refund_no_0 = out_refund_no_0;
	}

	public String getOut_refund_no_1() {
		return out_refund_no_1;
	}

	public void setOut_refund_no_1(String out_refund_no_1) {
		this.out_refund_no_1 = out_refund_no_1;
	}

	public String getOut_refund_no_2() {
		return out_refund_no_2;
	}

	public void setOut_refund_no_2(String out_refund_no_2) {
		this.out_refund_no_2 = out_refund_no_2;
	}

	public String getRefund_id_0() {
		return refund_id_0;
	}

	public void setRefund_id_0(String refund_id_0) {
		this.refund_id_0 = refund_id_0;
	}

	public String getRefund_id_1() {
		return refund_id_1;
	}

	public void setRefund_id_1(String refund_id_1) {
		this.refund_id_1 = refund_id_1;
	}

	public String getRefund_id_2() {
		return refund_id_2;
	}

	public void setRefund_id_2(String refund_id_2) {
		this.refund_id_2 = refund_id_2;
	}

	public String getRefund_channel_0() {
		return refund_channel_0;
	}

	public void setRefund_channel_0(String refund_channel_0) {
		this.refund_channel_0 = refund_channel_0;
	}

	public String getRefund_channel_1() {
		return refund_channel_1;
	}

	public void setRefund_channel_1(String refund_channel_1) {
		this.refund_channel_1 = refund_channel_1;
	}

	public String getRefund_channel_2() {
		return refund_channel_2;
	}

	public void setRefund_channel_2(String refund_channel_2) {
		this.refund_channel_2 = refund_channel_2;
	}

	public String getRefund_fee_0() {
		return refund_fee_0;
	}

	public void setRefund_fee_0(String refund_fee_0) {
		this.refund_fee_0 = refund_fee_0;
	}

	public String getRefund_fee_1() {
		return refund_fee_1;
	}

	public void setRefund_fee_1(String refund_fee_1) {
		this.refund_fee_1 = refund_fee_1;
	}

	public String getRefund_fee_2() {
		return refund_fee_2;
	}

	public void setRefund_fee_2(String refund_fee_2) {
		this.refund_fee_2 = refund_fee_2;
	}

	public String getSettlement_refund_fee_0() {
		return settlement_refund_fee_0;
	}

	public void setSettlement_refund_fee_0(String settlement_refund_fee_0) {
		this.settlement_refund_fee_0 = settlement_refund_fee_0;
	}

	public String getSettlement_refund_fee_1() {
		return settlement_refund_fee_1;
	}

	public void setSettlement_refund_fee_1(String settlement_refund_fee_1) {
		this.settlement_refund_fee_1 = settlement_refund_fee_1;
	}

	public String getSettlement_refund_fee_2() {
		return settlement_refund_fee_2;
	}

	public void setSettlement_refund_fee_2(String settlement_refund_fee_2) {
		this.settlement_refund_fee_2 = settlement_refund_fee_2;
	}

	public String getRefund_status_0() {
		return refund_status_0;
	}

	public void setRefund_status_0(String refund_status_0) {
		this.refund_status_0 = refund_status_0;
	}

	public String getRefund_status_1() {
		return refund_status_1;
	}

	public void setRefund_status_1(String refund_status_1) {
		this.refund_status_1 = refund_status_1;
	}

	public String getRefund_status_2() {
		return refund_status_2;
	}

	public void setRefund_status_2(String refund_status_2) {
		this.refund_status_2 = refund_status_2;
	}

	public String getRefund_recv_accout_0() {
		return refund_recv_accout_0;
	}

	public void setRefund_recv_accout_0(String refund_recv_accout_0) {
		this.refund_recv_accout_0 = refund_recv_accout_0;
	}

	public String getRefund_recv_accout_1() {
		return refund_recv_accout_1;
	}

	public void setRefund_recv_accout_1(String refund_recv_accout_1) {
		this.refund_recv_accout_1 = refund_recv_accout_1;
	}

	public String getRefund_recv_accout_2() {
		return refund_recv_accout_2;
	}

	public void setRefund_recv_accout_2(String refund_recv_accout_2) {
		this.refund_recv_accout_2 = refund_recv_accout_2;
	}

	public String getRefund_success_time_0() {
		return refund_success_time_0;
	}

	public void setRefund_success_time_0(String refund_success_time_0) {
		this.refund_success_time_0 = refund_success_time_0;
	}

	public String getRefund_success_time_1() {
		return refund_success_time_1;
	}

	public void setRefund_success_time_1(String refund_success_time_1) {
		this.refund_success_time_1 = refund_success_time_1;
	}

	public String getRefund_success_time_2() {
		return refund_success_time_2;
	}

	public void setRefund_success_time_2(String refund_success_time_2) {
		this.refund_success_time_2 = refund_success_time_2;
	}

	public String getRefund_account_0() {
		return refund_account_0;
	}

	public void setRefund_account_0(String refund_account_0) {
		this.refund_account_0 = refund_account_0;
	}

	public String getRefund_account_1() {
		return refund_account_1;
	}

	public void setRefund_account_1(String refund_account_1) {
		this.refund_account_1 = refund_account_1;
	}

	public String getRefund_account_2() {
		return refund_account_2;
	}

	public void setRefund_account_2(String refund_account_2) {
		this.refund_account_2 = refund_account_2;
	}
	
	
	
}
