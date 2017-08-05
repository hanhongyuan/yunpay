package com.yunpay.permission.service;

import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.MerchNoticeEntity;

public interface MerchantService {
    /**
     * 分页查询
     * @param pageParam
     * @param MerchNoticeEntity
     * @return
     */
    @SuppressWarnings("rawtypes")
    PageBean listPage(PageParam pageParam,MerchNoticeEntity merchNotice);
    
    public int editStatus(String noticeId,String status);
    
    public int addMerchNotice(MerchNoticeEntity merchNotice);
    
    public int editMerchNotice(MerchNoticeEntity merchNotice);
    
    public MerchNoticeEntity findById(String noticeId);
    
    public int delById(String noticeId); 
    
    public List<MerchNoticeEntity> viewNoticeRecv(String noticeId); 
}
