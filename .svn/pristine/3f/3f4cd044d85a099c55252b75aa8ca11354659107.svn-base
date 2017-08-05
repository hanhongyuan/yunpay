package com.yunpay.permission.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.MerchantDao;
import com.yunpay.permission.entity.MerchNoticeEntity;

@Repository("MerchantDao")
public class MerchantDaoImpl extends PermissionBaseDaoImpl<MerchNoticeEntity> implements MerchantDao {
    @Override
    public int editStatus(Map<String, Object> paramMap) {
        return super.getSqlSession().update(getStatement("editStatus"),paramMap);
    }
    
    @Override
    public MerchNoticeEntity findById(String noticeId) {
        return super.getSqlSession().selectOne(getStatement("findById"),noticeId);
    }
    
    @Override
    public int addMerchNotice(Map<String, Object> paramMap) {
        return super.getSqlSession().insert(getStatement("addMerchNotice"),paramMap);
    }
    
    @Override
    public int editMerchNotice(Map<String, Object> paramMap) {
        return super.getSqlSession().update(getStatement("editMerchNotice"),paramMap);
    }
    
    @Override
    public int delById(String noticeId) {
        return super.getSqlSession().delete(getStatement("delById"),noticeId);
    }
    
    @Override
    public List<MerchNoticeEntity> viewNoticeRecv(String noticeId) {
        return super.getSqlSession().selectList(getStatement("viewNoticeRecv"),noticeId);
    }
    
}
