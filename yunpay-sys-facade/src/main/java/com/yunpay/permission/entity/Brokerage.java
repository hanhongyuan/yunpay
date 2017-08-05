package com.yunpay.permission.entity;
/**
 * 佣金费率查询实体类
 * @author tf
 *
 */
public class Brokerage {
	private String id;
	// 操作员
	private String oprName;
	// 商户与发卡方关系ID
	private String relationId;
	// 交易类型编码
	private String tranType;
	//交易类型名称
	private String typeName;
	// 受理方扣率
	private Double issuerDis;
	// 分润比率
	private Double benefitDis;
	// 单笔最低
	private Long minFee;
	// 单笔最高
	private Long maxFee;
	// 启用日期
	private String startDate;
	// 创建时间
	private String createTime;
	//结算方式
	private String settleType;
	//结算参数
	private String settleParam;
	//商户扣率
	private Double merchDis;
	//用户扣率
	private Double userDis;
	//收单方收益比率
	private Double issuerIncome;
	//发卡方收益比率
	private Double benefitIncome;
	//商户收益比率
	private Double merchIncome;
	//用户收益比率
	private Double userIncome;
	//借贷记标志
	private String tranCd;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOprName() {
		return oprName;
	}
	public void setOprName(String oprName) {
		this.oprName = oprName;
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
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Double getIssuerDis() {
		return issuerDis;
	}
	public void setIssuerDis(Double issuerDis) {
		this.issuerDis = issuerDis;
	}
	public Double getBenefitDis() {
		return benefitDis;
	}
	public void setBenefitDis(Double benefitDis) {
		this.benefitDis = benefitDis;
	}
	public Long getMinFee() {
		return minFee;
	}
	public void setMinFee(Long minFee) {
		this.minFee = minFee;
	}
	public Long getMaxFee() {
		return maxFee;
	}
	public void setMaxFee(Long maxFee) {
		this.maxFee = maxFee;
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
	public Double getMerchDis() {
		return merchDis;
	}
	public void setMerchDis(Double merchDis) {
		this.merchDis = merchDis;
	}
	public Double getUserDis() {
		return userDis;
	}
	public void setUserDis(Double userDis) {
		this.userDis = userDis;
	}
	public Double getIssuerIncome() {
		return issuerIncome;
	}
	public void setIssuerIncome(Double issuerIncome) {
		this.issuerIncome = issuerIncome;
	}
	public Double getBenefitIncome() {
		return benefitIncome;
	}
	public void setBenefitIncome(Double benefitIncome) {
		this.benefitIncome = benefitIncome;
	}
	public Double getMerchIncome() {
		return merchIncome;
	}
	public void setMerchIncome(Double merchIncome) {
		this.merchIncome = merchIncome;
	}
	public Double getUserIncome() {
		return userIncome;
	}
	public void setUserIncome(Double userIncome) {
		this.userIncome = userIncome;
	}
	public String getTranCd() {
		return tranCd;
	}
	public void setTranCd(String tranCd) {
		this.tranCd = tranCd;
	}
}
