package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SysUpgradePlanDao;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.PlanDetailEntity;
import com.yunpay.permission.entity.TermMerchEntity;
import com.yunpay.permission.entity.UpgradePlanEntity;
import com.yunpay.permission.service.SysUpgradePlanService;

@Repository("SysUpgradePlanService")
public class SysUpgradePlanServiceImpl implements SysUpgradePlanService{

    @Autowired
    private SysUpgradePlanDao planDao;

    @SuppressWarnings("rawtypes")
    @Override
    public PageBean listPage(PageParam pageParam, UpgradePlanEntity planEntity) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("planId", planEntity.getPlanId());
        paramMap.put("planName", planEntity.getPlanName());
        paramMap.put("planStatus", planEntity.getPlanStatus());
        return planDao.listPage(pageParam,paramMap);
    }
    
    public boolean editPlanStatus(String planId, String planStatus) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("planId", planId);
        paramMap.put("planStatus", planStatus);
        if(planDao.editPlanStatus(paramMap) > 0){
            if(planDao.editPlanDetailStatus(paramMap) > 0){
                return true;
            }
            return false;
        }
        return false;
    }
    
    public boolean delUpgradePlan(String planId){
        if(planDao.delUpgradePlan(planId) > 0){
            if(planDao.delUpgradeDetailPlan(planId) > 0){
                return true;
            }
            return false;
        }
        return false;
    }
    
    public boolean addupgradePlan(UpgradePlanEntity planEntity,String infoMsg){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("PlanId", planEntity.getPlanId());
        paramMap.put("VerId", planEntity.getVerId());
        paramMap.put("PlanName", planEntity.getPlanName());
        paramMap.put("BeginDate", planEntity.getBeginDate());
        paramMap.put("PlanRemark", planEntity.getPlanRemark());
        paramMap.put("CreateUser", planEntity.getCreateUser());
        paramMap.put("CreateTime", planEntity.getCreateTime());
        paramMap.put("PlanStatus", planEntity.getPlanStatus());
        if(planDao.addupgradePlan(paramMap) > 0){
            if(!"".equals(infoMsg)&&infoMsg!=null){
                String[] termSeq = infoMsg.split(",");
                for (int i = 0; i < termSeq.length; i++) {
                    Map<String, Object> paramDetailMap = new HashMap<String, Object>();
                    paramDetailMap.put("PlanId", planEntity.getPlanId());
                    paramDetailMap.put("TermSeq", termSeq[i].trim());
                    paramDetailMap.put("UpdStatus", "1");
                    planDao.addUpgradeDetailPlan(paramDetailMap);
                }
            return true;
            }
        }
        return false;
    }
    
    public boolean editUpgradePlan(UpgradePlanEntity planEntity,String infoMsg){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("PlanId", planEntity.getPlanId());
        paramMap.put("VerId", planEntity.getVerId());
        paramMap.put("PlanName", planEntity.getPlanName());
        paramMap.put("BeginDate", planEntity.getBeginDate());
        paramMap.put("PlanRemark", planEntity.getPlanRemark());
        paramMap.put("CreateUser", planEntity.getCreateUser());
        paramMap.put("PlanStatus", planEntity.getPlanStatus());
        if(planDao.editupgradePlan(paramMap) > 0){
            if(!"".equals(infoMsg)&&infoMsg!=null){
                if(planDao.findUpgradeDetailPlan(planEntity.getPlanId()).size() > 0){
                    planDao.delUpgradeDetailPlan(planEntity.getPlanId());
                    String[] termSeq = infoMsg.split(",");
                    for (int i = 0; i < termSeq.length; i++) {
                        Map<String, Object> paramDetailMap = new HashMap<String, Object>();
                        paramDetailMap.put("PlanId", planEntity.getPlanId());
                        paramDetailMap.put("TermSeq", termSeq[i].trim());
                        paramDetailMap.put("UpdStatus", "1");
                        planDao.addUpgradeDetailPlan(paramDetailMap);
                    }
                    return true;
                }
            return false;
            }
        }
        return false;
    }
    
    public UpgradePlanEntity findUpgradePlanById(String planId){
        return planDao.findUpgradePlanById(planId);
    }
    
    public List<PlanDetailEntity> findPlanDetailList(String planId){
        return planDao.findPlanDetailList(planId);
    }
    
    public List<ComboxValue> findVer(){
        return planDao.findVer();
    }
    
    @SuppressWarnings("rawtypes")
    public PageBean viewUpgradePlan(PageParam pageParam,String planId){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("planId", planId);
        return planDao.viewUpgradePlan(pageParam,paramMap);
    }
    
    @SuppressWarnings("rawtypes")
    public PageBean findtermMerchList(PageParam pageParam,TermMerchEntity termMerch){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("storeNo", termMerch.getStoreNo());
        paramMap.put("storeName", termMerch.getStoreName());
        paramMap.put("termSeq", termMerch.getTermSeq());
        return planDao.findtermMerchList(pageParam,paramMap);
    }
    
}
