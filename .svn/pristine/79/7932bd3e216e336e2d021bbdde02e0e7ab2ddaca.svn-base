package com.yunpay.permission.dao;

import java.util.List;
import java.util.Map;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TermEntity;
import com.yunpay.permission.entity.TermLsEntity;

public interface TermsDao extends PermissionBaseDao<TermEntity> {
    public TermEntity selectByPrimaryKey(int id);
    
    //查询下拉框
    public List<TermEntity> findMacselect();

    //添加
    public int addMacTerm(TermEntity termEntity);
    
    //删除
    public int delMacTerm(String termSeq);

    //修改
    public int editMacTerm(TermEntity termEntity);
    
    //根据终端机器号查询
    public TermEntity selectbytermSeq(Map<String, Object> paramMap);
    
    /**
     * 分页查询门店的数据 .
     */
    @SuppressWarnings("rawtypes")
    public PageBean TermLslistPage(PageParam pageParam, Map<String, Object> paramMap);
    
    //查询操作类型
    public List<TermLsEntity> selectdealtype();
    
    //查询厂商
    public List<ComboxValue> selectfirm();
    
    //二级下拉查询型号 
    public List<ComboxValue> findtypeId(String code);
}
