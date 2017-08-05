package com.yunpay.permission.service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.SysUserLog;

/**
 * 操作员日志service接口
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public interface SysUserLogService {

	/**
	 * 创建sysUserLog
	 */
	void saveData(SysUserLog sysUserLog);

	/**
	 * 修改sysUserLog
	 */
	void updateData(SysUserLog sysUserLog);

	/**
	 * 根据id获取数据sysUserLog
	 * 
	 * @param id
	 * @return
	 */
	SysUserLog getDataById(Long id);

	/**
	 * 分页查询sysUserLog
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            SysUserLog
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, SysUserLog sysUserLog);

}
