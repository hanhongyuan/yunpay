package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.permission.dao.MsgNoticeDao;
import com.yunpay.permission.service.MsgNoticeService;

@Service("MsgNoticeService")
public class MsgNoticeServiceImpl implements MsgNoticeService{
	@Autowired
	private MsgNoticeDao msgNoticeDao;

	@Override
	public Map<String, Object> queryMerchNews(String termSeq) {
		List<Map<String,Object>> noticeList = msgNoticeDao.queryMerchNews(termSeq);
		if(noticeList!=null && noticeList.size()>0){
			return noticeList.get(0);
		}
		return null;
	}

	@Override
	public int addNoticeRecv(String termSeq, String noticeId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("noticeId", noticeId);
		paramMap.put("termSeq", termSeq);
		return msgNoticeDao.addNoticeRecv(paramMap);
	}

	@Override
	public List<Map<String, Object>> queryMerchNotice(String noticeType) {
		return msgNoticeDao.queryMerchNotice(noticeType);
	}
	

}
