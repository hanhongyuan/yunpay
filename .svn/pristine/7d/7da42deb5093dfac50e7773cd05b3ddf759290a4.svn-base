package com.yunpay.wx.req.pay;

import com.yunpay.common.utils.CommonUtil;

public class WechatRefundReq extends WechatQrReq{
	
	//微信订单号
	private String transaction_id;
	//商户退款单号(我方系统生成，必须) 
	private String out_refund_no ;
	//订单总额(必须)
	private int total_fee ;
	//申请的退款金额(必须)
	private int refund_fee;
	//退款原因
	private String refund_desc;
	
	public WechatRefundReq(){
		
	}
	
	/**
	 * 构造微信退款请求参数
	 * @param appId
	 * @param merchId
	 * @param subMerchId
	 * @param transactionId
	 * @param outTradeNo
	 * @param outRefundNo
	 * @param totalFee
	 * @param refundFee
	 * @param refundDesc
	 * @param nonceStr
	 */
	public WechatRefundReq(String appId,String merchId,String subMerchId,String transactionId,
			String outTradeNo,String outRefundNo,int totalFee,int refundFee,String refundDesc){
		setAppid(appId);
		setMch_id(merchId);
		setSub_mch_id(subMerchId);
		setTransaction_id(transactionId);
		setOut_trade_no(outTradeNo);
		setOut_refund_no(outRefundNo);
		setTotal_fee(totalFee);
		setRefund_fee(refundFee);
		setRefund_desc(refundDesc);
		setNonce_str(CommonUtil.getRandomStringByLength(32));
	}
	
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getOut_refund_no() {
		return out_refund_no;
	}
	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public int getRefund_fee() {
		return refund_fee;
	}
	public void setRefund_fee(int refund_fee) {
		this.refund_fee = refund_fee;
	}
	public String getRefund_desc() {
		return refund_desc;
	}
	public void setRefund_desc(String refund_desc) {
		this.refund_desc = refund_desc;
	}
	
	
}
