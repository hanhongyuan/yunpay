package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.common.core.utils.DateUtils;
import com.yunpay.permission.dao.SysUnusualTranDao;
import com.yunpay.permission.entity.UnusualTranEntity;
import com.yunpay.permission.service.SysUnusualTranService;

@Service("SysUnusualTranService")
public class SysUnusualTranServiceImpl implements SysUnusualTranService{
    @Autowired 
    SysUnusualTranDao Dao;
    
    @SuppressWarnings("rawtypes")
    @Override
    public PageBean listPage(PageParam pageParam, UnusualTranEntity unTran) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("Contract_begin", unTran.getContract_begin());
        paramMap.put("Contract_end", unTran.getContract_end());
        paramMap.put("shortName", unTran.getShortName());
        paramMap.put("storeName", unTran.getStoreName());
        paramMap.put("termId", unTran.getTermId());
        paramMap.put("tranSerial", unTran.getTranSerial());
        paramMap.put("cardNo", unTran.getCardNo());
        paramMap.put("confirmResult", unTran.getConfirmResult());
        return Dao.listPage(pageParam, paramMap);
    }
    
    public boolean unUsualTranAdd(UnusualTranEntity unTran) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("TermId", unTran.getTermId());
        paramMap.put("BatchNo", unTran.getBatchNo());
        paramMap.put("TranDate", DateUtils.formatToformat(unTran.getTranDate(), "yyyy-MM-dd", "yyyyMMdd"));
        paramMap.put("TranSerial", unTran.getTranSerial());
        paramMap.put("ConfirmResult", unTran.getConfirmResult());
        paramMap.put("ConfirmDate", unTran.getConfirmDate());
        paramMap.put("ConfirmUser", unTran.getConfirmUser());
        
//        Iterator<Map.Entry<String, Object>> entries = paramMap.entrySet().iterator();  
//        while (entries.hasNext()) {  
//            Map.Entry<String, Object> entry = entries.next();  
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
//        }  
        
        if(Dao.unUsualTranAdd(paramMap) < 1){
            return false;
        }
        
        if(Dao.editbatchsend(paramMap) < 1){
            return false;
        }
        
        return true;
    }
}
