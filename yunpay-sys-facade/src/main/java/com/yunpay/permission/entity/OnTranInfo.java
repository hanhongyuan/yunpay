package com.yunpay.permission.entity;

import java.math.BigDecimal;

/**
 * 联机交易查看
 * @author tf
 *
 */
public class OnTranInfo {
	
	//交易类型
		private String tranType;
		//原始交易类型
		private String origTranType;
		//清算日期
		private String settleDate;
		//交易日期
		private String tranDate;
		//交易时间
		private String tranTime;
		//交易流水
		private String tranSerial;
		//终端流水
		private String termSerial;
		//原始交易流水
		private String origSerial;
		//批次号
		private String batchNo;
		//卡号
		private String cardNo;
		//卡类型
		private String cardType;
		//交易金额	
		private BigDecimal tranAmt;
		//卡余额
		private BigDecimal remainTranAmt;
		//原始交易金额
		private BigDecimal origTranAmt;
		//交易标志
		private String tranFlag;
		//系统参考号
		private String referNo;
		//授权号
		private String authNo;
		//授权日期
		private String authDate;
		//授权金额
		private BigDecimal authAmt;
		//发卡机构代码
		private String acqInst;
		//商户号 
		private String merchId;
		//终端号
		private String termId;
		//应用交易计数器
		private String atc;
		//交易状态
		private String tranStatus;
		//批次状态
		private String batchStatus;
		//批次结果
		private String batchResult;
		//清算标志
		private String settleFlag;
		//电话号码
		private String phoneNo;
		public String getTranType() {
			return tranType;
		}
		public void setTranType(String tranType) {
			this.tranType = tranType;
		}
		public String getOrigTranType() {
			return origTranType;
		}
		public void setOrigTranType(String origTranType) {
			this.origTranType = origTranType;
		}
		public String getSettleDate() {
			return settleDate;
		}
		public void setSettleDate(String settleDate) {
			this.settleDate = settleDate;
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
			this.tranTime = tranTime;
		}
		public String getTranSerial() {
			return tranSerial;
		}
		public void setTranSerial(String tranSerial) {
			this.tranSerial = tranSerial;
		}
		public String getTermSerial() {
			return termSerial;
		}
		public void setTermSerial(String termSerial) {
			this.termSerial = termSerial;
		}
		public String getOrigSerial() {
			return origSerial;
		}
		public void setOrigSerial(String origSerial) {
			this.origSerial = origSerial;
		}
		public String getBatchNo() {
			return batchNo;
		}
		public void setBatchNo(String batchNo) {
			this.batchNo = batchNo;
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
		public BigDecimal getTranAmt() {
			return tranAmt;
		}
		public void setTranAmt(BigDecimal tranAmt) {
			this.tranAmt = tranAmt;
		}
		public BigDecimal getRemainTranAmt() {
			return remainTranAmt;
		}
		public void setRemainTranAmt(BigDecimal remainTranAmt) {
			this.remainTranAmt = remainTranAmt;
		}
		public BigDecimal getOrigTranAmt() {
			return origTranAmt;
		}
		public void setOrigTranAmt(BigDecimal origTranAmt) {
			this.origTranAmt = origTranAmt;
		}
		public String getTranFlag() {
			return tranFlag;
		}
		public void setTranFlag(String tranFlag) {
			this.tranFlag = tranFlag;
		}
		public String getReferNo() {
			return referNo;
		}
		public void setReferNo(String referNo) {
			this.referNo = referNo;
		}
		public String getAuthNo() {
			return authNo;
		}
		public void setAuthNo(String authNo) {
			this.authNo = authNo;
		}
		public String getAuthDate() {
			return authDate;
		}
		public void setAuthDate(String authDate) {
			this.authDate = authDate;
		}
		public BigDecimal getAuthAmt() {
			return authAmt;
		}
		public void setAuthAmt(BigDecimal authAmt) {
			this.authAmt = authAmt;
		}
		public String getAcqInst() {
			return acqInst;
		}
		public void setAcqInst(String acqInst) {
			this.acqInst = acqInst;
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
		public String getAtc() {
			return atc;
		}
		public void setAtc(String atc) {
			this.atc = atc;
		}
		public String getTranStatus() {
			return tranStatus;
		}
		public void setTranStatus(String tranStatus) {
			this.tranStatus = tranStatus;
		}
		public String getBatchStatus() {
			return batchStatus;
		}
		public void setBatchStatus(String batchStatus) {
			this.batchStatus = batchStatus;
		}
		public String getBatchResult() {
			return batchResult;
		}
		public void setBatchResult(String batchResult) {
			this.batchResult = batchResult;
		}
		public String getSettleFlag() {
			return settleFlag;
		}
		public void setSettleFlag(String settleFlag) {
			this.settleFlag = settleFlag;
		}
		public String getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		@Override
		public String toString() {
			return "OnTranInfo [merchId=" + merchId + ", termId=" + termId+ "]";
		}
		
		
}
