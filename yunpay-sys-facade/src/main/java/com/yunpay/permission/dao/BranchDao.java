package com.yunpay.permission.dao;

import java.util.List;

import com.yunpay.permission.entity.Branch;

@SuppressWarnings("rawtypes")
public interface BranchDao extends PermissionBaseDao {
	/**
	 * 添加保存
	 * @param branch
	 * @return
	 */
	public int insertBranch(Branch branch);
	
	/**
	 * 修改
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
	 * 分页查询
	 * @param branch
	 * @param instUp
	 * @return
	 */
	public List<Branch> queryBranchList(Branch branch,String instUp);
	
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
	
	public Branch validDelBranch(String instId);
	
	/**
	 * 校验部门编码是否重复
	 * @param instId
	 * @return
	 */
	public int validBranch(String instId);
	
	/**
	 * 获取根目录级别部门
	 * @return
	 */
	public Branch queryRootBranch(Branch branch);
	
	/**
	 * 获取所有部门信息
	 * @param branch
	 * @return
	 */
	public List<Branch> listByBranch(Branch instId);
	
	/**
	 * 获取树形选择数据
	 * @param branch
	 * @return
	 */
	public List<Branch> lookupBranchTree(Branch branch);

	public List<Branch> querygetBranch(Branch branch);

	public List<Branch> queryByInstIdOrInstName(Branch branch);
	
	
	
}
