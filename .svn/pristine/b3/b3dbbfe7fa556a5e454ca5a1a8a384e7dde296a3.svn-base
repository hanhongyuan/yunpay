package com.yunpay.permission.service;

import java.util.List;
import java.util.Map;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.MerchantInfo;
import com.yunpay.permission.entity.StoreEntity;
import com.yunpay.permission.entity.TermAppEntity;
import com.yunpay.permission.entity.TermEntity;
import com.yunpay.permission.entity.TermMonitorEntity;

public interface SysTermService {
    
    /**
     * 分页查询
     * @param pageParam
     * @param TermLsEntity
     * @return
     */
    @SuppressWarnings("rawtypes")
    PageBean listPage(PageParam pageParam, TermEntity termEntity);
    
    //添加 term
    public String addTerm(TermEntity term);
    
    //修改 term
    public int editTerm(TermEntity term);

    //获取TermId
    public TermEntity findTermId(String prefix);
    
    //获取TermId
    public TermEntity findTermIdbySeq(String termSeq);
    
    //删除绑定应用
    public boolean delTermAppInfo(TermEntity term);
    
    //根据termseq 和 termid 查询秘钥
    public TermAppEntity getTermKey(String termId,String appCode);
    
    //根据TermEntity 和 TermAppEntity 进行添加应用 并 设置秘钥
    public int addTermAppInfo(TermEntity term,TermAppEntity termApp);
    
    //根据TermEntity 和 TermAppEntity 进行修改应用 并 修改秘钥
    public int editTermAppInfo(TermEntity term,TermAppEntity termApp);
    
    public List<TermEntity> findTermApp(String termSeq);
    
    /**
     * 根据id查询TermEntity列表
     * @param storeNo
     * @return
     */
    public TermEntity selectByPrimaryKey(String termId);
    
    /**
     * 根据id进行撤机
     * @param storeNo
     * @return
     */
    public boolean deleteByPrimaryKey(String termId,String createUser);
    
    /**
     * 修改状态码（停用/启用）
     * @param termId
     * @return
     */
    public int editTermStatus(String termSeq,String status);
    
    //厂商下拉
    public List<ComboxValue> findfirm();
    
    //型号下拉
    public List<ComboxValue> findtypeId(String firmCode);
    
    //通讯方式下拉
    public List<ComboxValue> findtransferType();
    
    @SuppressWarnings("rawtypes")
    PageBean listStore(PageParam pageParam, StoreEntity storeEntity);
    
    /**
     * 接口使用的方法
     * */
    //自助终端信息上送
    public boolean addtermMonitor(TermMonitorEntity termMonitor);
    
    public List<Map<String,Object>> queryMerchSettle(String beginDate,String endDate,String merchId);
    
    public long queryMerchValidErrNum(String termSeq);
    
    public boolean validMerchInfo(MerchantInfo merchantInfo,String termSeq);
}
