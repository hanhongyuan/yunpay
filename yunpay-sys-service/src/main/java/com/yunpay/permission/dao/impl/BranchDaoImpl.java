package com.yunpay.permission.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.BranchDao;
import com.yunpay.permission.entity.Branch;

@SuppressWarnings("rawtypes")
@Repository("BranchDao")
public class BranchDaoImpl extends PermissionBaseDaoImpl implements BranchDao{

	@Override
	public int insertBranch(Branch branch) {
		return super.getSqlSession().insert(getStatement("insertBranch"), branch);
	}

	@Override
	public int updateBranch(Branch branch) {
		return super.getSqlSession().update(getStatement("updateBranch"), branch);
	}

	@Override
	public int deleteBranch(String instId) {
		return super.getSqlSession().delete(getStatement("deleteBranch"), instId);
	}

	@Override
	public List<Branch> queryBranchList(Branch branch, String instUp) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("branch", branch);
		paramMap.put("instUp", instUp);
		return super.getSqlSession().selectOne(getStatement("queryBranchList"), paramMap);
	}

	@Override
	public Branch getBranchByInstId(String instId) {
		return super.getSqlSession().selectOne(getStatement("getBranchByInstId"), instId);
	}

	@Override
	public Branch getBranchByInstName(String instName) {
		return super.getSqlSession().selectOne(getStatement("getBranchByInstName"), instName);
	}
	
	@Override
	public Branch validDelBranch(String instId) {
		return (Branch) super.getSqlSession().selectList(getStatement("validDelBranch"), instId);
	}

	@Override
	public int validBranch(String instId) {
		return 0;
	}

	@Override
	public Branch queryRootBranch(Branch branch) {
		return (Branch) super.getSqlSession().selectOne(getStatement("queryRootBranch"), branch);
	}

	@Override
	public List<Branch> listByBranch(Branch instId) {
		return super.getSqlSession().selectList(getStatement("listByBranch"), instId);
	}

	@Override
	public List<Branch> lookupBranchTree(Branch branch) {
		return super.getSqlSession().selectList(getStatement("lookupBranchTree"), branch);
	}

	@Override
	public List<Branch> querygetBranch(Branch branch) {
		return  super.getSqlSession().selectList(getStatement("querygetBranch"), branch);
	}
	
	@Override
	public List<Branch> queryByInstIdOrInstName(Branch branch) {
		return super.getSqlSession().selectList(getStatement("queryByInstIdOrInstName"), branch);
	}


}
