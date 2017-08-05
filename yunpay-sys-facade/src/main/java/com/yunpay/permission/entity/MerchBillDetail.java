package com.yunpay.permission.entity;

public class MerchBillDetail {
	private String billId;
	private String setClass;
	private String tranNum;
	private Double tranAmt;
	private Double benefitDis;
	private Double benefitAmt;
	private Double settleAmt;
	
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getSetClass() {
		return setClass;
	}
	public void setSetClass(String setClass) {
		this.setClass = setClass;
	}
	public String getTranNum() {
		return tranNum;
	}
	public void setTranNum(String tranNum) {
		this.tranNum = tranNum;
	}
	public Double getTranAmt() {
		return tranAmt;
	}
	public void setTranAmt(Double tranAmt) {
		this.tranAmt = tranAmt;
	}
	public Double getBenefitDis() {
		return benefitDis;
	}
	public void setBenefitDis(Double benefitDis) {
		this.benefitDis = benefitDis;
	}
	public Double getBenefitAmt() {
		return benefitAmt;
	}
	public void setBenefitAmt(Double benefitAmt) {
		this.benefitAmt = benefitAmt;
	}
	public Double getSettleAmt() {
		return settleAmt;
	}
	public void setSettleAmt(Double settleAmt) {
		this.settleAmt = settleAmt;
	}
}
