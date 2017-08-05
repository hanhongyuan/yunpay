package com.yunpay.permission.service;


import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.MccStoreEntity;

public interface SysMccStoreService {
    
    
    /**
     * 分页查询
     * @param pageParam
     * @param MccStoreEntity
     * @return
     */
    @SuppressWarnings("rawtypes")
    PageBean listPage(PageParam pageParam, MccStoreEntity mccStore);
    
    List<MccStoreEntity> mccStoreListExcel();
}
