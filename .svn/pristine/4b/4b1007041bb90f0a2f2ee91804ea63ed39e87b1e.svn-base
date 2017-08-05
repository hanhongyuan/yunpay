package com.yunpay.permission.service;


import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.SysVersion;

public interface SysVersionService{
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param sysVersion
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, SysVersion sysVersion);
	
	/**
	 * 通过id查询版本信息
	 * @param agentCode
	 * @return
	 */
	SysVersion getSysVersion(long verId);

	/**
	 * 修改版本信息
	 * @param sysVersion
	 * @return
	 */
	int updateSysVersion(SysVersion sysVersion);

	/**
	 *删除版本信息 
	 * @param verId
	 * @return
	 */
	int deleteSysVersion(long verId);
	
	/**
	 * 新增版本
	 * @param sysVersion
	 * @return
	 */
	int insertSysVersion(SysVersion sysVersion);
}
