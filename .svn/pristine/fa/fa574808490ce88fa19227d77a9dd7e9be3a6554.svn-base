package com.yunpay.permission.dao;

import java.util.List;
import java.util.Map;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.PlanDetailEntity;
import com.yunpay.permission.entity.UpgradePlanEntity;

public interface SysUpgradePlanDao extends PermissionBaseDao<UpgradePlanEntity> {
    public int editPlanStatus(Map<String, Object> paramMap);
    
    public int editPlanDetailStatus(Map<String, Object> paramMap);
    
    public int delUpgradePlan(String planId);
    
    public int delUpgradeDetailPlan(String planId);
    
    public List<PlanDetailEntity> findUpgradeDetailPlan(String planId);
    
    public int addupgradePlan(Map<String, Object> paramMap);
    
    public int editupgradePlan(Map<String, Object> paramMap);
    
    public int addUpgradeDetailPlan(Map<String, Object> paramMap);
    
    public List<ComboxValue> findVer();
    
    public UpgradePlanEntity findUpgradePlanById(String planId);
    
    public List<PlanDetailEntity> findPlanDetailList(String planId);
    
    @SuppressWarnings("rawtypes")
    public PageBean viewUpgradePlan(PageParam pageParam,Map<String, Object> paramMap);
    
    @SuppressWarnings("rawtypes")
    public PageBean findtermMerchList(PageParam pageParam,Map<String, Object> paramMap);
}
