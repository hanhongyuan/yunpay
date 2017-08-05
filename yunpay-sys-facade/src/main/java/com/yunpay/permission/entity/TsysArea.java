package com.yunpay.permission.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 
 * 功能： 
 * 作者： 曾冬成
 * 公司： 汇商宏业
 * 日期： 2013-7-27下午02:05:58
 * @版本： V1.0
 * @修改：
 */

public class TsysArea {
	private String areaCode;
	private String areaName;
	private String areaDesc;
	private String parentId;
	private String orderNo;
	private String status;
	private String areaType;
	private String isOften;
	private long childNum;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Set<TsysArea> areaList = new HashSet(0);
	@SuppressWarnings("rawtypes")
	private List childArea = new ArrayList(0);
	
	
	public long getChildNum() {
		return childNum;
	}
	public void setChildNum(long childNum) {
		this.childNum = childNum;
	}
	@SuppressWarnings("rawtypes")
	public List getChildArea() {
		return childArea;
	}
	@SuppressWarnings("rawtypes")
	public void setChildArea(List childArea) {
		this.childArea = childArea;
	}
	public String getIsOften() {
		return isOften;
	}
	public Set<TsysArea> getAreaList() {
		return areaList;
	}
	public void setAreaList(Set<TsysArea> areaList) {
		this.areaList = areaList;
	}
	public void setIsOften(String isOften) {
		this.isOften = isOften;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaDesc() {
		return areaDesc;
	}
	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAreaType() {
		return areaType;
	}
	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}
	
	
	
}
