package com.yunpay.permission.dao;

import java.util.List;
import java.util.Map;

import com.yunpay.permission.entity.MerchNoticeEntity;

public interface MerchantDao extends PermissionBaseDao<MerchNoticeEntity> {
    
    public int editStatus(Map<String, Object> paramMap);
    
    public MerchNoticeEntity findById(String noticeId);
    
    public int addMerchNotice(Map<String, Object> paramMap);
    
    public int editMerchNotice(Map<String, Object> paramMap);
    
    public int delById(String noticeId);
    
    public List<MerchNoticeEntity> viewNoticeRecv(String noticeId);
}
