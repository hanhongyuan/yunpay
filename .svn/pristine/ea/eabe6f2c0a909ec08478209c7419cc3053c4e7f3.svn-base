package com.yunpay.permission.entity;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author tf
 *
 */

public class LookupBranchTree {
	private String instId;// 部门编号
	private String instName;// 部门名称
	private String longInstName;
	private String instUp;// 上级编号
	private Long childNum;
	private List<LookupBranchTree> childBranch = new ArrayList<LookupBranchTree>(0);
	
	public LookupBranchTree(Branch branch){
		this.instId = branch.getInstId();
		this.instName = branch.getInstName();
		this.instUp = branch.getInstUp();
		
		this.longInstName = branch.getRemarks();
	}

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

	public String getLongInstName() {
		return longInstName;
	}

	public void setLongInstName(String longInstName) {
		this.longInstName = longInstName;
	}

	public String getInstUp() {
		return instUp;
	}

	public void setInstUp(String instUp) {
		this.instUp = instUp;
	}

	public Long getChildNum() {
		return childNum;
	}

	public void setChildNum(Long childNum) {
		this.childNum = childNum;
	}

	public List<LookupBranchTree> getChildBranch() {
		return childBranch;
	}

	public void setChildBranch(List<LookupBranchTree> childBranch) {
		this.childBranch = childBranch;
	}
	
	
}
