package com.yunpay.permission.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.MsgNoticeDao;

@SuppressWarnings("rawtypes")
@Repository("MsgNoticeDao")
public class MsgNoticeDaoImpl extends PermissionBaseDaoImpl implements MsgNoticeDao{
    
    @Override
    public int addNoticeRecv(Map<String, Object> paramMap){
        return super.getSqlSession().insert(getStatement("addNoticeRecv"), paramMap);
    }

	@Override
	public List<Map<String, Object>> queryMerchNews(String termSeq) {
		return super.getSqlSession().selectList(getStatement("queryMerchNews"), termSeq);
	}
	
	@Override
	public List<Map<String,Object>> queryMerchNotice(String noticeType){
		return super.getSqlSession().selectList(getStatement("queryMerchNews"), noticeType);
	}
}
