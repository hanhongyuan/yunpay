package com.yunpay.permission.entity;

/**
 * 商户业务申请实体类
 * @author tf
 *
 */
public class MerchBusiApplyInfo {

	private String applyId;
	private String merchId;
	private String storeNo;
	private String termId;
	private String termSeq;
	private String busiCode;	//业务码
	private String busiName;   //业务名称
	private String applyStatus;//业务申请状态
	private String applyRemark;//申请备注
	
	
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getMerchId() {
		return merchId;
	}
	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}
	public String getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}
	public String getTermId() {
		return termId;
	}
	public void setTermId(String termId) {
		this.termId = termId;
	}
	public String getTermSeq() {
		return termSeq;
	}
	public void setTermSeq(String termSeq) {
		this.termSeq = termSeq;
	}
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	public String getBusiName() {
		return busiName;
	}
	public void setBusiName(String busiName) {
		this.busiName = busiName;
	}
	public String getApplyStatus() {
		return applyStatus;
	}
	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
	public String getApplyRemark() {
		return applyRemark;
	}
	public void setApplyRemark(String applyRemark) {
		this.applyRemark = applyRemark;
	}
}
