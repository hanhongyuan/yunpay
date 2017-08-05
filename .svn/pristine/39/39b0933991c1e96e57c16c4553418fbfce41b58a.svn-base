package com.yunpay.permission.service;

import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.Branch;


public interface BranchService {
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param branch
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public PageBean listPage(PageParam pageParam, Branch branch);
	
	/**
	 * 添加数据
	 * @param branch
	 * @return
	 */
	public int insert(Branch branch);
	
	/**
	 * 修改数据
	 * @param branch
	 * @return
	 */
	public int updateBranch(Branch branch);
	
	/**
	 * 根据id删除数据
	 * @param instId
	 * @return
	 */
	public int deleteBranch(String instId);
	
	/**
	 * 获取所有部门信息
	 * @param instId
	 * @return
	 */
	public List<Branch> listByBranch(Branch instId);
	
	/**
	 * 得到根部门
	 * @param branch
	 * @return
	 */
	public Branch queryRootBranch(Branch branch);
	
	public List<Branch> querygetBranch(Branch branch);
	
	public List<Branch> queryByInstIdOrInstName(Branch branch);
	
	/**
	 * 通过name查找数据
	 * @param instName
	 * @return
	 */
	public Branch getBranchByInstName(String instName);
	
	/**
	 * 通过Id查找数据
	 * @param instId
	 * @return
	 */
	public Branch getBranchByInstId(String instId);
	
	/**
	 * 获取树形选择数据
	 * @param branch
	 * @return
	 */
	public List<Branch> lookupBranchTree(Branch branch);

	
}
