package com.yunpay.permission.dao;

import java.util.List;
import java.util.Map;
import com.yunpay.permission.entity.StoreEntity;
/**
 * 
 * 类名称                      门店DAO接口
 * 文件名称:     StoreDao.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午10:01:29
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月12日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@SuppressWarnings("rawtypes")
public interface StoreDao extends PermissionBaseDao {
	
	/**
	 * 查询门店列表
	 * @param storeEntity
	 * @return
	 */
	List<StoreEntity> getStoreList(StoreEntity storeEntity);
	
     /**
     * 根据storeNo修改门店的状态
     * @param storeNo
     * @param status 状态
     * @return
     */
    public int updateStoreStatus(Map<String, Object> paramMap);
    
    /**
     * 修改门店的信息
     */
    public int updateStoreInfo(StoreEntity storeEntity);
    
    /**
     * 增加门店的信息
     */
    public int addStoreInfo(StoreEntity storeEntity);
    
    /**
     * 根据storeNo查询StoreEntity
     * @param storeNo
     * @return
     */
    
    public StoreEntity selectByStoreNo(String storeNo);
    
    /**
     * 根据storeNo删除StoreEntity
     * @param storeNo
     * @return
     */
    
    public int deleteByStoreNo(String storeNo);
}
