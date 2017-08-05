package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SysMccStoreDao;
import com.yunpay.permission.entity.MccStoreEntity;
import com.yunpay.permission.service.SysMccStoreService;

@Service("SysMccStoreService")
public class SysMccStoreServiceImpl implements SysMccStoreService{
    @Autowired 
    SysMccStoreDao Dao;
    
    @SuppressWarnings("rawtypes")
    @Override
    public PageBean listPage(PageParam pageParam, MccStoreEntity mccStore) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("provice", mccStore.getProvice());
        paramMap.put("region", mccStore.getRegion());
        
        paramMap.put("Contract_begin", mccStore.getContract_begin());
        paramMap.put("Contract_end", mccStore.getContract_end());
        return Dao.listPage(pageParam, paramMap);
    }
    
    public List<MccStoreEntity> mccStoreListExcel() {
        return Dao.mccStoreListExcel();
    }
}
