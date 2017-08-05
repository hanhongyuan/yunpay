package com.yunpay.permission.service;

import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TermEntity;
import com.yunpay.permission.entity.TermLsEntity;

public interface TermsService {
	
    
    /**
     * 分页查询
     * @param pageParam
     * @param TermEntity
     * @return
     */
    @SuppressWarnings("rawtypes")
    PageBean listPage(PageParam pageParam, TermEntity termEntity);
	
    /**
     * 根据ID查询
     * @param pageParam
     * @param id
     * @return
     */
    public TermEntity selectByPrimaryKey(int logid);
    
    //查询全部
    public List<TermEntity> findMacselect();
    
    //新增
    public int addMacTerm(TermEntity termEntity);
    
    //删除
    public int delMacTerm(String termSeq);
    
    //修改
    public int editMacTerm(TermEntity termEntity);
    
    //根据终端机器号查询
    public TermEntity selectbytermSeq(TermEntity termEntity);
    
    /**
     * 装机流水分页查询
     * @param pageParam
     * @param TermEntity
     * @return
     */
    @SuppressWarnings("rawtypes")
    PageBean TermLslistPage(PageParam pageParam, TermLsEntity termLsEntity);
    
    //查询操作类型 
    List<TermLsEntity> selectdealtype();
    
    //查询厂商 
    List<ComboxValue> selectfirm();
    
    //二级下拉查询型号 
    List<ComboxValue> findtypeId(String code);
}
