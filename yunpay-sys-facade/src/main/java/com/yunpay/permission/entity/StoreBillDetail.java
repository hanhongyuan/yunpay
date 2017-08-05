package com.yunpay.permission.entity;

public class StoreBillDetail {
	//明细ID
		private String detailId;
		//单据号
		private String billId;
		//门店编码
		private String storeNo;
		//门店名称
		private String storeName;
		//结算项目
		private String setClass;
		//交易笔数
		private String tranNum;
		//交易金额
		private Double tranAmt;
		//返佣比率
		private Double benefitDis;
		//返佣金额
		private Double benefitAmt;
		//结算金额
		private Double settleAmt;
		//结算备注
		private String setRemark;
		//结算人
		private String setUser;
		//结算时间
		private String setTime;
		public String getDetailId() {
			return detailId;
		}
		public void setDetailId(String detailId) {
			this.detailId = detailId;
		}
		public String getBillId() {
			return billId;
		}
		public void setBillId(String billId) {
			this.billId = billId;
		}
		public String getStoreNo() {
			return storeNo;
		}
		public void setStoreNo(String storeNo) {
			this.storeNo = storeNo;
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
		public String getSetRemark() {
			return setRemark;
		}
		public void setSetRemark(String setRemark) {
			this.setRemark = setRemark;
		}
		public String getSetUser() {
			return setUser;
		}
		public void setSetUser(String setUser) {
			this.setUser = setUser;
		}
		public String getSetTime() {
			return setTime;
		}
		public void setSetTime(String setTime) {
			this.setTime = setTime;
		}
		public String getStoreName() {
			return storeName;
		}
		public void setStoreName(String storeName) {
			this.storeName = storeName;
		}
}
