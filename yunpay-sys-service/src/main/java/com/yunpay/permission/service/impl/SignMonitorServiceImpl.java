package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SignMonitorDao;
import com.yunpay.permission.entity.FeedBack;
import com.yunpay.permission.entity.SignMonitor;
import com.yunpay.permission.service.SignMonitorService;

@Service("SignMonitorService")
public class SignMonitorServiceImpl implements SignMonitorService{
	@Autowired
	private SignMonitorDao signMonitorDao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageBean listPage(PageParam pageParam, SignMonitor signMonitor) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		paramMap.put("storeName", signMonitor.getStoreName());
		paramMap.put("termSeq", signMonitor.getTermSeq());
		paramMap.put("termId", signMonitor.getTermId());
		paramMap.put("date1", signMonitor.getDate1());
		paramMap.put("date2", signMonitor.getDate2());
		return signMonitorDao.listPage(pageParam, paramMap);
	}

	@Override
	public FeedBack getFeedBackById(String sssId) {
		return signMonitorDao.getFeedBackById(sssId);
	}

	@Override
	public int updateFeedBack(FeedBack feedBack) {
		return signMonitorDao.updateFeedBack(feedBack);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public PageBean listPageSignView(PageParam pageParam,SignMonitor signMonitor) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
			paramMap.put("storeName", signMonitor.getStoreName());
			paramMap.put("termSeq", signMonitor.getTermSeq());
			paramMap.put("termId", signMonitor.getTermId());
			paramMap.put("date1", signMonitor.getDate1());
			paramMap.put("date2", signMonitor.getDate2());
			return signMonitorDao.listPageSignView(pageParam, paramMap);
	
	}
}
