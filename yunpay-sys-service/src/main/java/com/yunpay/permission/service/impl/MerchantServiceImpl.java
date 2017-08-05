package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.MerchantDao;
import com.yunpay.permission.entity.MerchNoticeEntity;
import com.yunpay.permission.service.MerchantService;

@Service("MerchantService")
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantDao dao;
    
    @Override
    @SuppressWarnings("rawtypes")
    public PageBean listPage(PageParam pageParam, MerchNoticeEntity merchNotice) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("noticeTitle", merchNotice.getNoticeTitle());  //通知标题(模糊)
        paramMap.put("noticeType", merchNotice.getNoticeType());    //通知类型(精准)
        paramMap.put("noticeGrade", merchNotice.getNoticeGrade());  //通知级别(精准)
        paramMap.put("noticeStatus", merchNotice.getNoticeStatus());//通知状态(精准)
        return dao.listPage(pageParam,paramMap);
    }
    
    public int editStatus(String noticeId,String status) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("noticeId", noticeId);
        paramMap.put("status", status);
        return dao.editStatus(paramMap);
    }
    
    public int addMerchNotice(MerchNoticeEntity merchNotice) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("noticeTitle", merchNotice.getNoticeTitle());
            paramMap.put("noticeShortmsg", merchNotice.getNoticeShortMsg());
            paramMap.put("noticeMsg", merchNotice.getNoticeMsg());
            paramMap.put("noticeType", merchNotice.getNoticeType());
            paramMap.put("createUser", merchNotice.getCreateUser());
            paramMap.put("useDate", merchNotice.getUseDate());
            paramMap.put("noticeStatus", merchNotice.getNoticeStatus());
            paramMap.put("noticeGrade", merchNotice.getNoticeGrade());
        
        return dao.addMerchNotice(paramMap);
    }
    
    public int editMerchNotice(MerchNoticeEntity merchNotice) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("noticeTitle", merchNotice.getNoticeTitle());
            paramMap.put("noticeShortmsg", merchNotice.getNoticeShortMsg());
            paramMap.put("noticeMsg", merchNotice.getNoticeMsg());
            paramMap.put("noticeType", merchNotice.getNoticeType());
            paramMap.put("useDate", merchNotice.getUseDate());
            paramMap.put("noticeGrade", merchNotice.getNoticeGrade());
            paramMap.put("noticeId", merchNotice.getNoticeId());
            
        return dao.editMerchNotice(paramMap);
    }
    
    public MerchNoticeEntity findById(String noticeId) {
        return dao.findById(noticeId);
    }
    
    public int delById(String noticeId) {
        return dao.delById(noticeId);
    }
    
    public List<MerchNoticeEntity> viewNoticeRecv(String noticeId){
        return dao.viewNoticeRecv(noticeId);
    }
    
}
