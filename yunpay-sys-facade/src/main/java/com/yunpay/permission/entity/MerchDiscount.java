package com.yunpay.permission.entity;

/**
 * 商户业务费率表(深圳通消费)
 * @author tf
 *
 */
public class MerchDiscount {
	/*id,relation_id,tran_type,issuer_dis,benefit_dis,
    settle_type,settle_param,start_date,create_time,user_dis,merch_dis,issuer_income,
    benefit_income,user_income,merch_income*/
    private String Id;
	private String relationId;
	private String tranType;
	private String issuerDis;
	private String benefitDis;
	private String settleType;
	private String settleParam;
	private String startDate;
	private String createTime;
	private String userDis;
	private String issuerIncome;
	private String benefitIncome;
	private String userIncome;
	private String merchIncome; 
	private String merchDis;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getRelationId() {
		return relationId;
	}
	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public String getIssuerDis() {
		return issuerDis;
	}
	public void setIssuerDis(String issuerDis) {
		this.issuerDis = issuerDis;
	}
	public String getBenefitDis() {
		return benefitDis;
	}
	public void setBenefitDis(String benefitDis) {
		this.benefitDis = benefitDis;
	}
	public String getSettleType() {
		return settleType;
	}
	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}
	public String getSettleParam() {
		return settleParam;
	}
	public void setSettleParam(String settleParam) {
		this.settleParam = settleParam;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUserDis() {
		return userDis;
	}
	public void setUserDis(String userDis) {
		this.userDis = userDis;
	}
	public String getIssuerIncome() {
		return issuerIncome;
	}
	public void setIssuerIncome(String issuerIncome) {
		this.issuerIncome = issuerIncome;
	}
	public String getBenefitIncome() {
		return benefitIncome;
	}
	public void setBenefitIncome(String benefitIncome) {
		this.benefitIncome = benefitIncome;
	}
	public String getUserIncome() {
		return userIncome;
	}
	public void setUserIncome(String userIncome) {
		this.userIncome = userIncome;
	}
	public String getMerchIncome() {
		return merchIncome;
	}
	public void setMerchIncome(String merchIncome) {
		this.merchIncome = merchIncome;
	}
	public String getMerchDis() {
		return merchDis;
	}
	public void setMerchDis(String merchDis) {
		this.merchDis = merchDis;
	}
	
	
}
