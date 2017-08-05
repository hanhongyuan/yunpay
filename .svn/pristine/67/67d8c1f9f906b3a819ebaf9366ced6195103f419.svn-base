package com.yunpay.permission.entity;

import java.util.ArrayList;
import java.util.List;



public class BranchTree {
	private String instId;// 部门编号
	private String instName;// 部门名称
	private String instTel;// 部门电话
	private String instAddr;// 部门地地址
	private String instPro;// 省市代码
	private String instUp;// 上级编号
	private String instLevel;// 部门级别
	private String instType;// 部门类别
	private String instStatus;// 部门状态
	private String remarks;// 部门描述
	private Long childNum;
	
	public BranchTree(Branch branch){
		this.instId = branch.getInstId();
		this.instName = branch.getInstName();
		this.instTel = branch.getInstTel();
		this.instAddr = branch.getInstAddr();
		this.instPro = branch.getInstPro();
		this.instUp = branch.getInstUp();
		this.instLevel = branch.getInstLevel();
		this.instType = branch.getInstType();
		this.instStatus = branch.getInstStatus();
		this.remarks = branch.getRemarks();
		
	}
	
	@SuppressWarnings("rawtypes")
	private List childBranch = new ArrayList(0);
	public String getInstId() {
		return instId;
	}
	public void setInstId(String instId) {
		this.instId = instId;
	}
	public String getInstName() {
		return instName;
	}
	public void setInstName(String instName) {
		this.instName = instName;
	}
	public String getInstTel() {
		return instTel;
	}
	public void setInstTel(String instTel) {
		this.instTel = instTel;
	}
	public String getInstAddr() {
		return instAddr;
	}
	public void setInstAddr(String instAddr) {
		this.instAddr = instAddr;
	}
	public String getInstPro() {
		return instPro;
	}
	public void setInstPro(String instPro) {
		this.instPro = instPro;
	}
	public String getInstUp() {
		return instUp;
	}
	public void setInstUp(String instUp) {
		this.instUp = instUp;
	}
	public String getInstLevel() {
		return instLevel;
	}
	public void setInstLevel(String instLevel) {
		this.instLevel = instLevel;
	}
	public String getInstType() {
		return instType;
	}
	public void setInstType(String instType) {
		this.instType = instType;
	}
	public String getInstStatus() {
		return instStatus;
	}
	public void setInstStatus(String instStatus) {
		this.instStatus = instStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getChildNum() {
		return childNum;
	}
	public void setChildNum(Long childNum) {
		this.childNum = childNum;
	}
	@SuppressWarnings("rawtypes")
	public List getChildBranch() {
		return childBranch;
	}
	@SuppressWarnings("rawtypes")
	public void setChildBranch(List childBranch) {
		this.childBranch = childBranch;
	}
}
