package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.BranchDao;
import com.yunpay.permission.entity.Branch;
import com.yunpay.permission.service.BranchService;

@Service("BranchService")
public class BranchServiceImpl implements BranchService{
	@Autowired
	private BranchDao branchDao;
	
	/**
	 * 根据条件分页查询
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageBean listPage(PageParam pageParam, Branch branch) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("instId", branch.getInstId());
		paramMap.put("instName", branch.getInstName()); 
		return branchDao.listPage(pageParam, paramMap);
	}
	
	/**
	 * 添加数据
	 */
	@Override
	public int insert(Branch branch) {
		return branchDao.insertBranch(branch);
	}

	/**
	 * 获取所有部门信息
	 */
	@Override
	public List<Branch> listByBranch(Branch instId) {
		return branchDao.listByBranch(instId);
	}

	@Override
	public Branch queryRootBranch(Branch branch) {
		return branchDao.queryRootBranch(branch);
	}

	@Override
	public List<Branch> querygetBranch(Branch branch) {
		return branchDao.querygetBranch(branch);
	}

	@Override
	public List<Branch> queryByInstIdOrInstName(Branch branch) {
		return branchDao.queryByInstIdOrInstName(branch);
	}

	@Override
	public int updateBranch(Branch branch) {
		return branchDao.updateBranch(branch);
	}

	@Override
	public int deleteBranch(String instId) {
		return branchDao.deleteBranch(instId);
	}

	@Override
	public Branch getBranchByInstName(String instName) {
		return branchDao.getBranchByInstName(instName);
	}

	@Override
	public Branch getBranchByInstId(String instId) {
		return branchDao.getBranchByInstId(instId);
	}
	
	@Override
	public List<Branch> lookupBranchTree(Branch branch){
		return branchDao.lookupBranchTree(branch);
	}

	
}
