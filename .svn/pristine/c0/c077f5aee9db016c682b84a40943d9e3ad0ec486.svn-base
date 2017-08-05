package com.yunpay.permission.service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.StoreEntity;

/**
 * 类名称		        门店业务接口
 * 文件名称:     StoreService.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年6月14日下午5:30:21
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月14日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */

public interface StoreService {
	
    
    /**
     * 分页查询
     * @param pageParam
     * @param StoreEntity
     * @return
     */
    @SuppressWarnings("rawtypes")
    PageBean listPage(PageParam pageParam, StoreEntity stroeEntity);
    
     /**
     * 修改状态码（停用/启用）
     * @param id
     * @return
     */
    public int updateStoreStatus(Integer id,Integer status);
    
    /**
     * 修改门店的信息
     */
    public int updateStoreInfo(StoreEntity storeEntity);
    
    /**
     * 新增门店的信息
     */
    public int addStoreInfo(StoreEntity storeEntity);
    
    /**
     * 根据id查询StroeEntity列表
     * @param storeNo
     * @return
     */
    public StoreEntity selectByStoreNo(String storeNo);
    
    /**
     * 根据id删除StroeEntity列表
     * @param storeNo
     * @return
     */
    public int deleteByStoreNo(String storeNo);	
}
