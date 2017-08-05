package com.yunpay.serv.model;

public class Merchant {
	
	private Integer id; // 商户ID
	// 商户号
	private String merchantNo;
	private String merchantName;
	private String registerName;
	private String md5Key; // 商户秘钥
	private String agentSerialNo;
	private Integer industryTypeId; // 行业类型Id 1 餐饮 2 KTV 3 美容美发 4 酒店

	private String contactMan; // 联系人

	private String phone; // 联系人电话

	private String tel; // 联系人手机

	private String prov; // 省

	private String city; // 市

	private String area; // 区

	private String address; // 地址

	private Byte status; // 审核状态，0：停用，1：启用

	private Byte auditStatus; // 审核状态，0：审核中，1：审核通过、2：回退、3：驳回
	

	private String orgNo; // 组织机构编码


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMerchantNo() {
		return merchantNo;
	}


	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}


	public String getMerchantName() {
		return merchantName;
	}


	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}


	public String getRegisterName() {
		return registerName;
	}


	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}


	public String getMd5Key() {
		return md5Key;
	}


	public void setMd5Key(String md5Key) {
		this.md5Key = md5Key;
	}


	public Integer getIndustryTypeId() {
		return industryTypeId;
	}


	public void setIndustryTypeId(Integer industryTypeId) {
		this.industryTypeId = industryTypeId;
	}


	public String getContactMan() {
		return contactMan;
	}


	public void setContactMan(String contactMan) {
		this.contactMan = contactMan;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getProv() {
		return prov;
	}


	public void setProv(String prov) {
		this.prov = prov;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Byte getStatus() {
		return status;
	}


	public void setStatus(Byte status) {
		this.status = status;
	}


	public Byte getAuditStatus() {
		return auditStatus;
	}


	public void setAuditStatus(Byte auditStatus) {
		this.auditStatus = auditStatus;
	}


	public String getOrgNo() {
		return orgNo;
	}


	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}


	public String getAgentSerialNo() {
		return agentSerialNo;
	}


	public void setAgentSerialNo(String agentSerialNo) {
		this.agentSerialNo = agentSerialNo;
	}

	

}
