package com.yunpay.permission.dao;


import java.util.Map;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.FeedBack;


@SuppressWarnings("rawtypes")
public interface SignMonitorDao extends PermissionBaseDao{
	
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
	
    public PageBean listPageSignView(PageParam pageParam, Map<String, Object> paramMap);
}
