package com.yunpay.permission.service;



import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.FeedBack;

public interface FeedBackService {
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param merchCredit
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, FeedBack feedBack);
	
	/**
	 * 定时刷新的分页查询
	 * @param pageParam
	 * @param merchCredit
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPageTwo(PageParam pageParam, FeedBack feedBack);
	
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
	
	/**
	 * 添加商户信息反馈信息
	 * @param feedBack
	 * @return
	 */
	int insertFeedBack(FeedBack feedBack);
}