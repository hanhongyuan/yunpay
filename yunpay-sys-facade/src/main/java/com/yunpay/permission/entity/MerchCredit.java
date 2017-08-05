package com.yunpay.permission.entity;

/**
 * 商户额度
 * @author tf
 *
 */
public class MerchCredit {
	private String merchId;//商户编号
	private String merchName;//商户名称
	private String shortName;//品牌名称
	private Double realAmount;//累积购买额度
	private Double creditAmount;//信用额度（通过公式计算）
	private Double currentAmount;//可用额度（累积购买额度 - 已使用额度）
	private Double lockAmount;//冻结额度
	private Double warningAmount;//预警额度
	private Double tempAmount;//充值未审核金额
	private String formulaId;//信用额度计算公式
	private Double useAmount;//已使用额度 
	private Double minReal;//查询条件
	private Double maxReal;//查询条件
	private Double minCurrent;//查询条件
	private Double maxCurrent;//查询条件
	
	
	public Double getMinCurrent() {
		return minCurrent;
	}
	public void setMinCurrent(Double minCurrent) {
		this.minCurrent = minCurrent;
	}
	public Double getMaxCurrent() {
		return maxCurrent;
	}
	public void setMaxCurrent(Double maxCurrent) {
		this.maxCurrent = maxCurrent;
	}
	public Double getMinReal() {
		return minReal;
	}
	public void setMinReal(Double minReal) {
		this.minReal = minReal;
	}
	public Double getMaxReal() {
		return maxReal;
	}
	public void setMaxReal(Double maxReal) {
		this.maxReal = maxReal;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getMerchId() {
		return merchId;
	}
	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}
	public Double getRealAmount() {
		return realAmount;
	}
	public void setRealAmount(Double realAmount) {
		this.realAmount = realAmount;
	}
	public Double getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}
	public Double getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(Double currentAmount) {
		this.currentAmount = currentAmount;
	}
	public Double getLockAmount() {
		return lockAmount;
	}
	public void setLockAmount(Double lockAmount) {
		this.lockAmount = lockAmount;
	}
	public Double getWarningAmount() {
		return warningAmount;
	}
	public void setWarningAmount(Double warningAmount) {
		this.warningAmount = warningAmount;
	}
	public String getFormulaId() {
		return formulaId;
	}
	public void setFormulaId(String formulaId) {
		this.formulaId = formulaId;
	}
	public String getMerchName() {
		return merchName;
	}
	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}
	public Double getTempAmount() {
		return tempAmount;
	}
	public void setTempAmount(Double tempAmount) {
		this.tempAmount = tempAmount;
	}
	public Double getUseAmount() {
		return useAmount;
	}
	public void setUseAmount(Double useAmount) {
		this.useAmount = useAmount;
	}
}
