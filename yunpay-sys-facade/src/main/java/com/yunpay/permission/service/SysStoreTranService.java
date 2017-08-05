package com.yunpay.permission.service;


import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.StoreTranEntity;

public interface SysStoreTranService {
    
    
    /**
     * 分页查询
     * @param pageParam
     * @param StoreTranEntity
     * @return
     */
    @SuppressWarnings("rawtypes")
    PageBean listPage(PageParam pageParam, StoreTranEntity StoreTran);
    
    List<StoreTranEntity> merchTranExcel();
}
