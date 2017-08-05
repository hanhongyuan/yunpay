package com.yunpay.permission.entity;

import java.math.BigDecimal;
/**
 * 商户结算单实体
 * @author tf
 *
 */
public class MerchSettle {
	//单据编号
		private String billId;
		//合同编号
		private String contractNo;
		//商户编码
		private String merchId;
		//商户名称
		private String merchName;
		//门店名称
		private String issuerName;
		//交易类型
		private String tranType;
		//交易金额
		private BigDecimal tranAmt;
		//交易笔数
		private String tranNum;
		//应收手续费
		private BigDecimal inFee;
		//应付手续费
		private BigDecimal outFee;
		//应付金额
		private BigDecimal outAmt;
		//应收金额
		private BigDecimal inAmt;
		//结算金额
		private BigDecimal merchIncome;
		//结算起始日期
		private String setBeginDate;
		//结算结束日期
		private String setEndDate;
		//状态
		private String billStatus;
		//结算周期
		private String setCycle;
		//单据生成时间
		private String createTime; 
		//实结金额
		private BigDecimal setFactAmt;
		//出单日期
		private String billDate;
		//出单备注
		private String outBillRmk;
		//核单日期
		private String checkDate;
		//核单备注
		private String checkBillRmk;
		//账单类型
		private String billType;
		//结算时间
		private String setDate;
		//交易时间
		private String tranDate;
		//批次号
		private String batNo;
		//终端流水
		private String termLs;
		//查询条件
		private String date1;
		private String date2;
		private String billType1;
		private String billType2;
		
		
		public String getBillType1() {
			return billType1;
		}
		public void setBillType1(String billType1) {
			this.billType1 = billType1;
		}
		public String getBillType2() {
			return billType2;
		}
		public void setBillType2(String billType2) {
			this.billType2 = billType2;
		}
		public String getBatNo() {
			return batNo;
		}
		public void setBatNo(String batNo) {
			this.batNo = batNo;
		}
		public String getTermLs() {
			return termLs;
		}
		public void setTermLs(String termLs) {
			this.termLs = termLs;
		}
		public BigDecimal getMerchIncome() {
			return merchIncome;
		}
		public void setMerchIncome(BigDecimal merchIncome) {
			this.merchIncome = merchIncome;
		}
		public String getSetDate() {
			return setDate;
		}
		public void setSetDate(String setDate) {
			this.setDate = setDate;
		}
		public String getTranDate() {
			return tranDate;
		}
		public void setTranDate(String tranDate) {
			this.tranDate = tranDate;
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
		public String getBillType() {
			return billType;
		}
		public void setBillType(String billType) {
			this.billType = billType;
		}
		public String getBillId() {
			return billId;
		}
		public void setBillId(String billId) {
			this.billId = billId;
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
		public String getIssuerName() {
			return issuerName;
		}
		public void setIssuerName(String issuerName) {
			this.issuerName = issuerName;
		}
		public String getTranType() {
			return tranType;
		}
		public void setTranType(String tranType) {
			this.tranType = tranType;
		}
		public BigDecimal getTranAmt() {
			return tranAmt;
		}
		public void setTranAmt(BigDecimal tranAmt) {
			this.tranAmt = tranAmt;
		}
		public String getTranNum() {
			return tranNum;
		}
		public void setTranNum(String tranNum) {
			this.tranNum = tranNum;
		}
		
		public BigDecimal getInFee() {
			return inFee;
		}
		public void setInFee(BigDecimal inFee) {
			this.inFee = inFee;
		}
		public BigDecimal getOutFee() {
			return outFee;
		}
		public void setOutFee(BigDecimal outFee) {
			this.outFee = outFee;
		}
		public BigDecimal getOutAmt() {
			return outAmt;
		}
		public void setOutAmt(BigDecimal outAmt) {
			this.outAmt = outAmt;
		}
		public BigDecimal getInAmt() {
			return inAmt;
		}
		public void setInAmt(BigDecimal inAmt) {
			this.inAmt = inAmt;
		}
		public String getBillDate() {
			return billDate;
		}
		public void setBillDate(String billDate) {
			this.billDate = billDate;
		}
		public String getSetBeginDate() {
			return setBeginDate;
		}
		public void setSetBeginDate(String setBeginDate) {
			this.setBeginDate = setBeginDate;
		}
		public String getSetEndDate() {
			return setEndDate;
		}
		public void setSetEndDate(String setEndDate) {
			this.setEndDate = setEndDate;
		}
		public String getBillStatus() {
			return billStatus;
		}
		public void setBillStatus(String billStatus) {
			this.billStatus = billStatus;
		}
		public String getSetCycle() {
			return setCycle;
		}
		public void setSetCycle(String setCycle) {
			this.setCycle = setCycle;
		}
		public String getCreateTime() {
			return createTime;
		}
		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}
		public String getContractNo() {
			return contractNo;
		}
		public void setContractNo(String contractNo) {
			this.contractNo = contractNo;
		}
		public BigDecimal getSetFactAmt() {
			return setFactAmt;
		}
		public void setSetFactAmt(BigDecimal setFactAmt) {
			this.setFactAmt = setFactAmt;
		}
		public String getOutBillRmk() {
			return outBillRmk;
		}
		public void setOutBillRmk(String outBillRmk) {
			this.outBillRmk = outBillRmk;
		}
		public String getCheckDate() {
			return checkDate;
		}
		public void setCheckDate(String checkDate) {
			this.checkDate = checkDate;
		}
		public String getCheckBillRmk() {
			return checkBillRmk;
		}
		public void setCheckBillRmk(String checkBillRmk) {
			this.checkBillRmk = checkBillRmk;
		}
}
