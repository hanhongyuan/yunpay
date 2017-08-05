package com.yunpay.permission.entity;


/**
 * 商户额度充值
 * @author tf
 *
 */
public class Recharge {
	private String lsId;//流水id
	private String merchId;//商户编号
	private String merchName;//商户名称
	private String shortName;//品牌名称
	private Double rechargeAmount;//购买金额，充值金额
	private String createUser;//创建人
	private String createDate;//创建日期
	private String checkUser;//审核人
	private String checkDate;//审核日期
	private String status;//状态（待审、通过）
	private String remark;//备注
	private String dealType;//操作类型（01：充值；02：提现）
	private Double beforeaccount;//交易前金额
	private Double afteraccount;//交易后金额
	private String transerial;//流水单号
	private String businessnumber;//业务号
	private String payDate;//支付日期
	private String payType;//支付方式
	private String date1;//查询条件
	private String date2;//查询条件
	
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
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
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getLsId() {
		return lsId;
	}
	public void setLsId(String lsId) {
		this.lsId = lsId;
	}
	public String getMerchId() {
		return merchId;
	}
	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}
	public Double getRechargeAmount() {
		return rechargeAmount;
	}
	public void setRechargeAmount(Double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCheckUser() {
		return checkUser;
	}
	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDealType() {
		return dealType;
	}
	public void setDealType(String dealType) {
		this.dealType = dealType;
	}
	public String getMerchName() {
		return merchName;
	}
	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}
	public Double getBeforeaccount() {
		return beforeaccount;
	}
	public void setBeforeaccount(Double beforeaccount) {
		this.beforeaccount = beforeaccount;
	}
	public Double getAfteraccount() {
		return afteraccount;
	}
	public void setAfteraccount(Double afteraccount) {
		this.afteraccount = afteraccount;
	}
	public String getTranserial() {
		return transerial;
	}
	public void setTranserial(String transerial) {
		this.transerial = transerial;
	}
	public String getBusinessnumber() {
		return businessnumber;
	}
	public void setBusinessnumber(String businessnumber) {
		this.businessnumber = businessnumber;
	}
}
