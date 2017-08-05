package com.yunpay.permission.service;

import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.PlanDetailEntity;
import com.yunpay.permission.entity.TermMerchEntity;
import com.yunpay.permission.entity.UpgradePlanEntity;

public interface SysUpgradePlanService {

    @SuppressWarnings("rawtypes")
    PageBean listPage(PageParam pageParam,UpgradePlanEntity planEntity);
    
    @SuppressWarnings("rawtypes")
    PageBean findtermMerchList(PageParam pageParam,TermMerchEntity termMerch);
    
    public boolean editPlanStatus(String planId, String planStatus);
    
    public List<ComboxValue> findVer();
    
    public UpgradePlanEntity findUpgradePlanById(String planId);
    
    public List<PlanDetailEntity> findPlanDetailList(String planIdString);
    
    public boolean delUpgradePlan(String planId);
    
    @SuppressWarnings("rawtypes")
    PageBean viewUpgradePlan(PageParam pageParam,String planId);
    
    public boolean addupgradePlan(UpgradePlanEntity planEntity,String infoMsg);
    
    public boolean editUpgradePlan(UpgradePlanEntity planEntity,String infoMsg);
}
