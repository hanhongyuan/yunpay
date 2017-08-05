package com.yunpay.permission.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SysUpgradePlanDao;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.PlanDetailEntity;
import com.yunpay.permission.entity.UpgradePlanEntity;

@Repository("SysUpgradePlanDao")
public class SysUpgradePlanDaoImpl extends PermissionBaseDaoImpl<UpgradePlanEntity> implements SysUpgradePlanDao {
    public int editPlanStatus(Map<String, Object> paramMap){
        return super.getSqlSession().update(getStatement("editPlanStatus"),paramMap);
    }
    
    public int editPlanDetailStatus(Map<String, Object> paramMap){
        return super.getSqlSession().update(getStatement("editPlanDetailStatus"),paramMap);
    }
    
    public int delUpgradePlan(String planId){
        return super.getSqlSession().delete(getStatement("delUpgradePlan"),planId);
    }
    
    public int delUpgradeDetailPlan(String planId){
        return super.getSqlSession().delete(getStatement("delUpgradeDetailPlan"),planId);
    }
    
    public List<ComboxValue> findVer(){
        return super.getSqlSession().selectList(getStatement("findVer"));
    }
    
    public int addupgradePlan(Map<String, Object> paramMap){
        return super.getSqlSession().insert(getStatement("addupgradePlan"),paramMap);
    }
    
    public int editupgradePlan(Map<String, Object> paramMap){
        return super.getSqlSession().insert(getStatement("editupgradePlan"),paramMap);
    }
    
    public int addUpgradeDetailPlan(Map<String, Object> paramMap){
        return super.getSqlSession().insert(getStatement("addUpgradeDetailPlan"),paramMap);
    }
    
    public UpgradePlanEntity findUpgradePlanById(String planId){
        return super.getSqlSession().selectOne(getStatement("findUpgradePlanById"),planId);
    }
    
    public List<PlanDetailEntity> findPlanDetailList(String planId){
        return super.getSqlSession().selectList(getStatement("findPlanDetailList"),planId);
    }
    
    public List<PlanDetailEntity> findUpgradeDetailPlan(String planId){
        return super.getSqlSession().selectList(getStatement("findUpgradeDetailPlan"),planId);
    }
    
    
    /**
     * 注入SqlSessionTemplate实例(要求Spring中进行SqlSessionTemplate的配置).
     * 可以调用sessionTemplate完成数据库操作.
     */
    @Autowired
    private SqlSessionTemplate sessionTemplate;

    public SqlSessionTemplate getSessionTemplate() {
        return sessionTemplate;
    }

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    public SqlSession getSqlSession() {
        return super.getSqlSession();
    }
    
    /**
     * 分页查询详情的数据 .
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public PageBean viewUpgradePlan(PageParam pageParam, Map<String, Object> paramMap) {
        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }

        // 统计总记录数
        Long totalCount = sessionTemplate.selectOne(getStatement("viewUpgradePlanCount"), paramMap);
        
        // 校验当前页数
        int currentPage = PageBean.checkCurrentPage(totalCount.intValue(), pageParam.getPageSize(), pageParam.getPageCurrent());
        pageParam.setPageCurrent(currentPage); // 为当前页重新设值
        // 校验页面输入的每页记录数numPerPage是否合法
        int numPerPage = PageBean.checkNumPerPage(pageParam.getPageSize()); // 校验每页记录数
        pageParam.setPageSize(numPerPage); // 重新设值

        // 根据页面传来的分页参数构造SQL分页参数
        paramMap.put("pageFirst", (pageParam.getPageCurrent() - 1) * pageParam.getPageSize());      //从多少条数据开始
        paramMap.put("pageSize", pageParam.getPageSize());                                          //返回多少条数据
        paramMap.put("startRowNum", (pageParam.getPageCurrent() - 1) * pageParam.getPageSize() + 1);//开始的行数
        paramMap.put("endRowNum", pageParam.getPageCurrent() * pageParam.getPageSize());            //结束的行数

        // 获取分页数据集
        List<Object> list = sessionTemplate.selectList(getStatement("viewUpgradePlanList"), paramMap);
        
        Object isCount = paramMap.get("isCount"); // 是否统计当前分页条件下的数据：1:是，其他为否
        if (isCount != null && "1".equals(isCount.toString())) {
            Map<String, Object> countResultMap = sessionTemplate.selectOne(getStatement(SQL_COUNT_BY_PAGE_PARAM), paramMap);
            return new PageBean(pageParam.getPageCurrent(), pageParam.getPageSize(), totalCount.intValue(), list, countResultMap);
        } else {
            // 构造分页对象
            return new PageBean(pageParam.getPageCurrent(), pageParam.getPageSize(), totalCount.intValue(), list);
        }
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public PageBean findtermMerchList(PageParam pageParam,Map<String, Object> paramMap){
        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }

        // 统计总记录数
        Long totalCount = sessionTemplate.selectOne(getStatement("termMerchCount"), paramMap);
        
        // 校验当前页数
        int currentPage = PageBean.checkCurrentPage(totalCount.intValue(), pageParam.getPageSize(), pageParam.getPageCurrent());
        pageParam.setPageCurrent(currentPage); // 为当前页重新设值
        // 校验页面输入的每页记录数numPerPage是否合法
        int numPerPage = PageBean.checkNumPerPage(pageParam.getPageSize()); // 校验每页记录数
        pageParam.setPageSize(numPerPage); // 重新设值

        // 根据页面传来的分页参数构造SQL分页参数
        paramMap.put("pageFirst", (pageParam.getPageCurrent() - 1) * pageParam.getPageSize());      //从多少条数据开始
        paramMap.put("pageSize", pageParam.getPageSize());                                          //返回多少条数据
        paramMap.put("startRowNum", (pageParam.getPageCurrent() - 1) * pageParam.getPageSize() + 1);//开始的行数
        paramMap.put("endRowNum", pageParam.getPageCurrent() * pageParam.getPageSize());            //结束的行数

        // 获取分页数据集
        List<Object> list = sessionTemplate.selectList(getStatement("termMerchList"), paramMap);
        
        Object isCount = paramMap.get("isCount"); // 是否统计当前分页条件下的数据：1:是，其他为否
        if (isCount != null && "1".equals(isCount.toString())) {
            Map<String, Object> countResultMap = sessionTemplate.selectOne(getStatement(SQL_COUNT_BY_PAGE_PARAM), paramMap);
            return new PageBean(pageParam.getPageCurrent(), pageParam.getPageSize(), totalCount.intValue(), list, countResultMap);
        } else {
            // 构造分页对象
            return new PageBean(pageParam.getPageCurrent(), pageParam.getPageSize(), totalCount.intValue(), list);
        }
    }
}
