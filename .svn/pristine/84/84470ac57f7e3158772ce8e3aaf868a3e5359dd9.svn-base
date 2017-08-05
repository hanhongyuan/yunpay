package com.yunpay.permission.entity;

import java.util.Date;

import com.yunpay.common.core.utils.ExcelField;

public class Merchant extends PermissionBaseEntity{
	/**
	 * 
	 * 文件名称:
	 * 内容摘要: 商户信息,关联表:t_merchant
	 * @author:   duan zhang quan
	 * @version:  1.0  
	 * @Date:     2017年6月16日上午9:56:12 
	 * 修改历史:  
	 * 修改日期                     修改人员                                   版本	            修改内容  
	 * ----------------------------------------------  
	 * 2017年6月16日上午9:56:12   duan zhang quan   2.0     新建
	 *
	 * 版权:   版权所有(C)2017
	 * 公司
	 */
	private static final long serialVersionUID = 1L;
	@ExcelField(title = "序号")
	private int id;
	@ExcelField(title = "商户号")
	private String serialNo; // 商户编号
	@ExcelField(title = "商户名称")
	private String registerName; // 商户名称
	private String agentSerialNo;  // 代理商编号
	private String md5Key;  // 商户密钥
	private String merchantType;  // 商户类型; 0:个体,1:企业
	private String printName;  // 凭条打印名称
	@ExcelField(title = "所属行业")
	private String industryTypeId;   // 行业类型id
	private String ranges;  // 经营范围
	@ExcelField(title = "联系人")
	private String contactMan;  // 联系人
	@ExcelField(title = "手机号码")
	private String tel; // 联系人手机
	@ExcelField(title = "省市区")
	private String prov;  //省
	private String city;  //市
	private String area;  // 区
	private String address;// 联系地址
	@ExcelField(title = "状态")
	private String status; // 状态 0：停用，1：启用
	@ExcelField(title = "审核状态")
	private String checkStatus; // 审批状态 1：审批通过, 0:审批退回  checkStatus
	private String accountBank;//开户银行
	private String accountNo;	//银行卡号
	@ExcelField(title = "信息来源")
	private String info_from;  // 信息来源
	@ExcelField(title = "录入人")
	private String createdBy;  //录入人
	@ExcelField(title = "录入时间")
	private Date createdAt;  // 录入时间
	@ExcelField(title = "门店数量")
	private String storeCount;  //门店数量(不与表对应的字段)
	
	public String getSerialNo() {
		return serialNo;
	}
	
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getRegisterName() {
		return registerName;
	}
	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}
	public String getAgentSerialNo() {
		return agentSerialNo;
	}
	public void setAgentSerialNo(String agentSerialNo) {
		this.agentSerialNo = agentSerialNo;
	}
	public String getMd5Key() {
		return md5Key;
	}
	public void setMd5Key(String md5Key) {
		this.md5Key = md5Key;
	}
	public String getMerchantType() {
		return merchantType;
	}
	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}
	public String getPrintName() {
		return printName;
	}
	public void setPrintName(String printName) {
		this.printName = printName;
	}
	public String getIndustryTypeId() {
		return industryTypeId;
	}
	public void setIndustryTypeId(String industryTypeId) {
		this.industryTypeId = industryTypeId;
	}
	public String getRanges() {
		return ranges;
	}
	public void setRanges(String ranges) {
		this.ranges = ranges;
	}
	public String getContactMan() {
		return contactMan;
	}
	public void setContactMan(String contactMan) {
		this.contactMan = contactMan;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccountBank() {
		return accountBank;
	}
	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getInfo_from() {
		return info_from;
	}

	public void setInfo_from(String info_from) {
		this.info_from = info_from;
	}

	public String getStoreCount() {
		return storeCount;
	}

	public void setStoreCount(String storeCount) {
		this.storeCount = storeCount;
	}



	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
