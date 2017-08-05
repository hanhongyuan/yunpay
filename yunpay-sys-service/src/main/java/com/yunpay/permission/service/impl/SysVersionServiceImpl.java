package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SysVersionDao;
import com.yunpay.permission.entity.SysVersion;
import com.yunpay.permission.service.SysVersionService;

@Service("SysVersionService")
public class SysVersionServiceImpl implements SysVersionService{
	@Autowired
	private SysVersionDao sysVersionDao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageBean listPage(PageParam pageParam, SysVersion sysVersion) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		paramMap.put("verNo", sysVersion.getVerNo()); 
		paramMap.put("verName", sysVersion.getVerName());
		return sysVersionDao.listPage(pageParam, paramMap);
	}

	@Override
	public SysVersion getSysVersion(long verId) {
		return sysVersionDao.getSysVersion(verId);
	}

	@Override
	public int updateSysVersion(SysVersion sysVersion) {
		return sysVersionDao.updateSysVersion(sysVersion);
	}

	@Override
	public int deleteSysVersion(long verId) {
		return sysVersionDao.deleteSysVersion(verId);
	}

	@Override
	public int insertSysVersion(SysVersion sysVersion) {
		return sysVersionDao.insertSysVersion(sysVersion);
	}
	

}
