package com.yunpay.permission.entity;

import java.math.BigDecimal;

/**
 * 商户交易报表实体类
 * @author tf
 *
 */
public class TranInfo {

	//批次号
  	private String batchNo;
	//交易日期
	private String tranDate;
	//流水
	private String tranSerial;
	//终端编码
	private String termId;
	//商户编码
	private String merchId;
	//卡号
	private String cardNo;
	//交易金额
	private BigDecimal tranAmt;
	//卡类型
	private String cardType;
	//卡余额
	private BigDecimal cardBalance;
	//交易时间
	private String tranTime;
	//交易类型
	private String tranType;
	private String tranTypeCode;
	//交易状态
	private String tranStatus;
	//标识脱机/联机
	private String resultType;
	//查询条件
	private String date1;
	private String date2;
	
	
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public String getTranSerial() {
		return tranSerial;
	}
	public void setTranSerial(String tranSerial) {
		this.tranSerial = tranSerial;
	}
	public String getTermId() {
		return termId;
	}
	public void setTermId(String termId) {
		this.termId = termId;
	}
	public String getMerchId() {
		return merchId;
	}
	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public BigDecimal  getTranAmt() {
		return tranAmt;
	}
	public void setTranAmt(BigDecimal tranAmt) {
		this.tranAmt = tranAmt;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public BigDecimal getCardBalance() {
		return cardBalance;
	}
	public void setCardBalance(BigDecimal cardBalance) {
		this.cardBalance = cardBalance;
	}
	public String getTranTime() {
		return tranTime;
	}
	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getTranTypeCode() {
		return tranTypeCode;
	}
	public void setTranTypeCode(String tranTypeCode) {
		this.tranTypeCode = tranTypeCode;
	}
	public String getTranStatus() {
		return tranStatus;
	}
	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
}
