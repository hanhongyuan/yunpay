package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SysUserLogDao;
import com.yunpay.permission.entity.SysUserLog;
import com.yunpay.permission.service.SysUserLogService;

/**
 * 操作员service接口实现
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Service("sysUserLogService")
public class SysUserLogServiceImpl implements SysUserLogService {
	@Autowired
	private SysUserLogDao sysUserLogDao;

	/**
	 * 创建sysUser
	 */
	public void saveData(SysUserLog sysUserLog) {
		sysUserLogDao.insert(sysUserLog);
	}

	/**
	 * 修改sysUser
	 */
	public void updateData(SysUserLog sysUserLog) {
		sysUserLogDao.update(sysUserLog);
	}

	/**
	 * 根据id获取数据sysUser
	 * 
	 * @param id
	 * @return
	 */
	public SysUserLog getDataById(Long id) {
		return sysUserLogDao.getById(id);

	}

	/**
	 * 分页查询sysUser
	 * 
	 * @param pageParam
	 * @param ActivityVo
	 *            SysUser
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public PageBean listPage(PageParam pageParam, SysUserLog sysUserLog) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return sysUserLogDao.listPage(pageParam, paramMap);
	}

}
