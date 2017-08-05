package com.yunpay.union.req;

import com.yunpay.union.config.SDKConfig;

public class UnionQueryReq extends UnionQrReq{
	//商户号码
	private String merId ;
	//
	private String queryId;
	//商户订单号，8-40位数字字母，不能含“-”或“_”，可以自行定制规则
	private String orderId;
	//订单发送时间，取系统时间，格式为YYYYMMDDhhmmss，必须取当前时间，否则会报txnTime无效
	private String txnTime;
	
	public UnionQueryReq(){
		
	}
	
	/**
	 * 根据queryId查询交易流水
	 * @param merId
	 * @param queryId
	 */
	public UnionQueryReq(String merId,String queryId){
		setVersion(SDKConfig.getConfig().getVersion());
		setSignMethod(SDKConfig.getConfig().getSignMethod());
		setTxnType("01");
		setTxnSubType("02");
		setMerId(merId);
		setQueryId(queryId);
	}
	
	/**
	 * 根据orderId+txnTime查询交易流水
	 * @param merId
	 * @param orderId
	 * @param txnTime
	 */
	public UnionQueryReq(String merId,String orderId,String txnTime){
		setVersion(SDKConfig.getConfig().getVersion());
		setSignMethod(SDKConfig.getConfig().getSignMethod());
		setTxnType("00");
		setTxnSubType("00");
		setMerId(merId);
		setOrderId(orderId);
		setTxnTime(txnTime);
	}
	
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getQueryId() {
		return queryId;
	}
	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTxnTime() {
		return txnTime;
	}
	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}
	
	
}
