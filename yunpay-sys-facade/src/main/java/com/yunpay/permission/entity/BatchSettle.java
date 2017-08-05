package com.yunpay.permission.entity;

import com.yunpay.common.core.utils.DateUtils;

/**
 * 监控下载参数
 * @author tf
 *
 */
public class BatchSettle {

	private String tranDate;
	private String tranTime;
	private String batchNo;
	private String merchId;
	private String termId;
	private String posSerial;
	private String pospSerial;
	private String debitAmount;
	private String debitCount;
	private String creditAmount;
	private String creditCount;
	private String stateMentRecode;
	private String recordStatus;
	private String tranType;
	//时间查询条件
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
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		if(tranDate.length() == 8){
			this.tranDate = DateUtils.formatToformat(tranDate, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
		}else{
			this.tranDate = tranDate;
		}
	}
	public String getTranTime() {
		return tranTime;
	}
	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getMerchId() {
		return merchId;
	}
	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}
	public String getTermId() {
		return termId;
	}
	public void setTermId(String termId) {
		this.termId = termId;
	}
	public String getPosSerial() {
		return posSerial;
	}
	public void setPosSerial(String posSerial) {
		this.posSerial = posSerial;
	}
	public String getPospSerial() {
		return pospSerial;
	}
	public void setPospSerial(String pospSerial) {
		this.pospSerial = pospSerial;
	}
	public String getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(String debitAmount) {
		this.debitAmount = debitAmount;
	}
	public String getDebitCount() {
		return debitCount;
	}
	public void setDebitCount(String debitCount) {
		this.debitCount = debitCount;
	}
	public String getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(String creditAmount) {
		this.creditAmount = creditAmount;
	}
	public String getCreditCount() {
		return creditCount;
	}
	public void setCreditCount(String creditCount) {
		this.creditCount = creditCount;
	}
	public String getStateMentRecode() {
		return stateMentRecode;
	}
	public void setStateMentRecode(String stateMentRecode) {
		this.stateMentRecode = stateMentRecode;
	}
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
}
