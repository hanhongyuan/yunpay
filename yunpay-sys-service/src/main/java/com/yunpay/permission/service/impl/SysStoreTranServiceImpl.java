package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SysStoreTranDao;
import com.yunpay.permission.entity.StoreTranEntity;
import com.yunpay.permission.service.SysStoreTranService;

@Service("SysStoreTranService")
public class SysStoreTranServiceImpl implements SysStoreTranService{
    @Autowired 
    SysStoreTranDao Dao;
    
    @SuppressWarnings("rawtypes")
    @Override
    public PageBean listPage(PageParam pageParam, StoreTranEntity StoreTran) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("provice", StoreTran.getProvice());
        paramMap.put("region", StoreTran.getRegion());
        paramMap.put("merchName", StoreTran.getMerchName());
        paramMap.put("minavgAmount", StoreTran.getMinavgAmount());
        paramMap.put("maxavgAmount", StoreTran.getMaxavgAmount());
        paramMap.put("mintranAmount", StoreTran.getMintranAmount());
        paramMap.put("maxtranAmount", StoreTran.getMaxtranAmount());
        paramMap.put("mintranNum", StoreTran.getMintranNum());
        paramMap.put("maxtranNum", StoreTran.getMaxtranNum());
        paramMap.put("dataType", StoreTran.getDataType());
        paramMap.put("dataType1", StoreTran.getDataType1());
        return Dao.listPage(pageParam, paramMap);
    }
    
    public List<StoreTranEntity> merchTranExcel() {
        return Dao.merchTranExcel();
    }
}
