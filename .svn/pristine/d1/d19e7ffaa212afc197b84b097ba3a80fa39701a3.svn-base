package com.yunpay.permission.dao;

import java.util.List;
import java.util.Map;


@SuppressWarnings("rawtypes")
public interface MsgNoticeDao extends PermissionBaseDao{
	
	/**
	 * 查询新闻类消息
	 * @param termSeq
	 * @return
	 */
	List<Map<String,Object>> queryMerchNews(String termSeq);
	
	/**
	 * 添加商户通知信息
	 * @param termSeq
	 * @param noticeId
	 * @return
	 */
	int addNoticeRecv(Map<String, Object> paramMap);
	
	/**
	 * 查询通知类消息
	 * @param noticeType
	 * @return
	 */
	List<Map<String,Object>> queryMerchNotice(String noticeType);

}
