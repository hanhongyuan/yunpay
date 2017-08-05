package com.yunpay.permission.entity;

import java.math.BigDecimal;

import com.yunpay.common.core.utils.DateUtils;

public class MerchTran {

	//商户编码
		private String merchId;
		//商户名称
		private String merchName;
		//门店编码
		private String storeNo;
		//门店名称
		private String storeName;
		//终端编码
		private String termId;
		//交易类型
		private String tranType;
		private String tranTypeCode;
		//流水
		private String tranSerial;
		//交易金额
		private BigDecimal tranAmt;
		//卡余额
		private BigDecimal cardBalance;
		//卡号
		private String cardNo;
		//卡类型
		private String cardType;
		//交易日期
		private String tranDate;
		//交易时间
		private String tranTime;
		//批结算日期
		private String setDate;
		//批结算时间
		private String setTime;
		//交易状态
		private String tranStatus;
		//省
		private String provice;
		//市
		private String region;
		//标识脱机/联机
		private String resultType;
		//批次号
	  	private String batchNo;
		//SAM流水
		private String samSeq;
		//查询条件
		private String date1;
		private String date2;
		
		
		public String getBatchNo() {
			return batchNo;
		}
		public void setBatchNo(String batchNo) {
			this.batchNo = batchNo;
		}
		public String getSamSeq() {
			return samSeq;
		}
		public void setSamSeq(String samSeq) {
			this.samSeq = samSeq;
		}
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
		public String getMerchId() {
			return merchId;
		}
		public void setMerchId(String merchId) {
			this.merchId = merchId;
		}
		public String getMerchName() {
			return merchName;
		}
		public void setMerchName(String merchName) {
			this.merchName = merchName;
		}
		public String getStoreNo() {
			return storeNo;
		}
		public void setStoreNo(String storeNo) {
			this.storeNo = storeNo;
		}
		public String getStoreName() {
			return storeName;
		}
		public String getTranSerial() {
			return tranSerial;
		}
		public void setTranSerial(String tranSerial) {
			this.tranSerial = tranSerial;
		}
		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}
		public String getTermId() {
			return termId;
		}
		public void setTermId(String termId) {
			this.termId = termId;
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
		public BigDecimal getTranAmt() {
			return tranAmt;
		}
		public void setTranAmt(BigDecimal tranAmt) {
			this.tranAmt = tranAmt;
		}
		public BigDecimal getCardBalance() {
			return cardBalance;
		}
		public void setCardBalance(BigDecimal cardBalance) {
			this.cardBalance = cardBalance;
		}
		public String getCardNo() {
			return cardNo;
		}
		public void setCardNo(String cardNo) {
			this.cardNo = cardNo;
		}
		public String getCardType() {
			return cardType;
		}
		public void setCardType(String cardType) {
			this.cardType = cardType;
		}
		public String getTranDate() {
			return tranDate;
		}
		public void setTranDate(String tranDate) {
			this.tranDate = tranDate;
		}
		public String getTranTime() {
			return tranTime;
		}
		public void setTranTime(String tranTime) {
			this.tranTime = DateUtils.formatToformat(tranTime, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
		}
		public String getTranStatus() {
			return tranStatus;
		}
		public void setTranStatus(String tranStatus) {
			this.tranStatus = tranStatus;
		}
		public String getSetDate() {
			return setDate;
		}
		public void setSetDate(String setDate) {
			this.setDate = DateUtils.formatToformat(setDate, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
		}
		public String getSetTime() {
			return setTime;
		}
		public void setSetTime(String setTime) {
			this.setTime = setTime;
		}
		public String getProvice() {
			return provice;
		}
		public void setProvice(String provice) {
			this.provice = provice;
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
		public String getResultType() {
			return resultType;
		}
		public void setResultType(String resultType) {
			this.resultType = resultType;
		}
		
}
