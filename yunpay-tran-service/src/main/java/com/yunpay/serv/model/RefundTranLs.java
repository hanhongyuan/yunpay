package com.yunpay.serv.model;

import java.util.Date;

/**
 * 退款流水信息
 * 文件名称:     RefundTranLs.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月10日下午2:39:20 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月10日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class RefundTranLs {
	
	private Integer id;
	// 退款渠道(1支付宝，2微信，3银联，4：预存款)
	private Integer channel; 
	private String merchantNo;
	private String merchantName;
	private String userRefundNo;
	//原始支付号(调用方提交)
	private String oldUserOrderNo;
	//退款流水号(平台生成)
	private String transNum;
	//原始支付流水号(平台生成)
	private String oldTransNum;
	//微信退款流水号(微信返回)
	private String tradeNo;
	private Date transTime; 
	private Float totalPrice;
	private Float refundFee;
	//退款渠道
	private String refundChannel;
	//退款资金来源
	private String refundAccount;
	//退款入账账户
	private String refundRecvAccout;
	//退款成功时间
	private String refundSuccessTime;
	
	private String info;
	private String orgNo;
	private Integer status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getUserRefundNo() {
		return userRefundNo;
	}
	public void setUserRefundNo(String userRefundNo) {
		this.userRefundNo = userRefundNo;
	}
	public String getOldUserOrderNo() {
		return oldUserOrderNo;
	}
	public void setOldUserOrderNo(String oldUserOrderNo) {
		this.oldUserOrderNo = oldUserOrderNo;
	}
	public String getTransNum() {
		return transNum;
	}
	public void setTransNum(String transNum) {
		this.transNum = transNum;
	}
	public String getOldTransNum() {
		return oldTransNum;
	}
	public void setOldTransNum(String oldTransNum) {
		this.oldTransNum = oldTransNum;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public Date getTransTime() {
		return transTime;
	}
	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}
	public Float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Float getRefundFee() {
		return refundFee;
	}
	public void setRefundFee(Float refundFee) {
		this.refundFee = refundFee;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getOrgNo() {
		return orgNo;
	}
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRefundChannel() {
		return refundChannel;
	}
	public void setRefundChannel(String refundChannel) {
		this.refundChannel = refundChannel;
	}
	public String getRefundAccount() {
		return refundAccount;
	}
	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}
	public String getRefundRecvAccout() {
		return refundRecvAccout;
	}
	public void setRefundRecvAccout(String refundRecvAccout) {
		this.refundRecvAccout = refundRecvAccout;
	}
	public String getRefundSuccessTime() {
		return refundSuccessTime;
	}
	public void setRefundSuccessTime(String refundSuccessTime) {
		this.refundSuccessTime = refundSuccessTime;
	}
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	
	
}
