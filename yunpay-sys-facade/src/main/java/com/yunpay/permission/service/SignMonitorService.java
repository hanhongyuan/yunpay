package com.yunpay.permission.service;



import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.FeedBack;
import com.yunpay.permission.entity.SignMonitor;

public interface SignMonitorService {
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param merchCredit
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, SignMonitor signMonitor);
	
	/**
	 * 分页查询(查看)
	 * @param pageParam
	 * @param merchCredit
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPageSignView(PageParam pageParam, SignMonitor signMonitor);
	
	/**
	 * 根据id查询商户反馈信息
	 * @param sssId
	 * @return
	 */
	FeedBack getFeedBackById(String sssId);

	/**
	 * 修改商户反馈信息
	 * @param feedBack
	 * @return
	 */
	int updateFeedBack(FeedBack feedBack);
}