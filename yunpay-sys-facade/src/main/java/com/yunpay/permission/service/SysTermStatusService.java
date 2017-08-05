package com.yunpay.permission.service;


import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TermStatusEntity;

public interface SysTermStatusService {
    
    
    /**
     * 分页查询
     * @param pageParam
     * @param TermStatusEntity
     * @return
     */
    @SuppressWarnings("rawtypes")
    PageBean listPage(PageParam pageParam, TermStatusEntity termStatus);
    
    List<ComboxValue> findRegion();
    
    List<TermStatusEntity> termStatusListExcel();
}
