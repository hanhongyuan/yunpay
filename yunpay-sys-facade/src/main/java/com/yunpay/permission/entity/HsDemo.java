package com.yunpay.permission.entity;

import java.util.Date;

public class HsDemo extends PermissionBaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int demoId;
	private String demoName;
	private int demoType;
	private Date createTime;
	private  int statu;
	public int getDemoId() {
		return demoId;
	}
	public void setDemoId(int demoId) {
		this.demoId = demoId;
	}
	public String getDemoName() {
		return demoName;
	}
	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}
	public int getDemoType() {
		return demoType;
	}
	public void setDemoType(int demoType) {
		this.demoType = demoType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	
	
}
