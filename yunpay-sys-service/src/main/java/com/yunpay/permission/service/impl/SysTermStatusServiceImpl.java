package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SysTermStatusDao;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TermStatusEntity;
import com.yunpay.permission.service.SysTermStatusService;

@Service("SysTermStatusService")
public class SysTermStatusServiceImpl implements SysTermStatusService{
    @Autowired 
    SysTermStatusDao Dao;
    
    @SuppressWarnings("rawtypes")
    @Override
    public PageBean listPage(PageParam pageParam, TermStatusEntity termStatus) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("region", termStatus.getRegion());
        paramMap.put("area", termStatus.getArea());
        paramMap.put("minEndUseDate", termStatus.getMinEndUseDate());
        paramMap.put("maxEndUseDate", termStatus.getMaxEndUseDate());
        paramMap.put("merchName", termStatus.getMerchName());
        paramMap.put("storeName", termStatus.getStoreName());
        
        return Dao.listPage(pageParam, paramMap);
    }
    
    public List<ComboxValue> findRegion() {
        return Dao.findRegion();
    }
    
    public List<TermStatusEntity> termStatusListExcel() {
        return Dao.termStatusListExcel();
    }
}
