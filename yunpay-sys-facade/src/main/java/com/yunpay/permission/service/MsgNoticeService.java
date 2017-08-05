package com.yunpay.permission.service;

import java.util.List;
import java.util.Map;


public interface MsgNoticeService{
	
	/**
	 * 查询新闻类消息
	 * @param termSeq
	 * @return
	 */
	Map<String,Object> queryMerchNews(String termSeq);
	
	/**
	 * 添加商户通知信息
	 * @param termSeq
	 * @param noticeId
	 * @return
	 */
	int addNoticeRecv(String termSeq,String noticeId);
	
	/**
	 * 查询通知类消息(一次多条)
	 * @param termSeq
	 * @param noticeType
	 * @return
	 */
	public List<Map<String,Object>> queryMerchNotice(String noticeType);
	
}
