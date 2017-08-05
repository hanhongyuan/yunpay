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
import com.yunpay.permission.dao.TermsDao;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TermEntity;
import com.yunpay.permission.entity.TermLsEntity;


@Repository("TermsDao")
public class TermsDaoImpl extends PermissionBaseDaoImpl<TermEntity> implements TermsDao {

    public TermEntity selectByPrimaryKey(int id) {
        return super.getSqlSession().selectOne(getStatement("selectByPrimaryKey"), id);
    }
    
    public List<TermEntity> findMacselect() {
        return super.getSqlSession().selectList(getStatement("findMacselect"));
    }
    
    public int addMacTerm(TermEntity termEntity) {
        return super.getSqlSession().insert(getStatement("addMacTerm"),termEntity);
    }
   
    public int delMacTerm(String termSeq) {
        return super.getSqlSession().delete(getStatement("delMacTerm"),termSeq);
    }
    
    public int editMacTerm(TermEntity termEntity) {
        return super.getSqlSession().insert(getStatement("editMacTerm"),termEntity);
    }
    
    public TermEntity selectbytermSeq(Map<String, Object> paramMap) {
        return super.getSqlSession().selectOne(getStatement("selectbytermSeq"),paramMap);
    }
    
    public List<TermLsEntity> selectdealtype() {
        return super.getSqlSession().selectList(getStatement("selectdealtype"));
    }
    
    public List<ComboxValue> selectfirm() {
        return super.getSqlSession().selectList(getStatement("selectfirm"));
    }
    
    public List<ComboxValue> findtypeId(String code) {
        return super.getSqlSession().selectList(getStatement("findtypeId"),code);
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
     * 分页查询门店的数据 .
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public PageBean TermLslistPage(PageParam pageParam, Map<String, Object> paramMap) {
        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }

        // 统计总记录数
        Long totalCount = sessionTemplate.selectOne(getStatement("TermLslistPageCount"), paramMap);
        
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
        List<Object> list = sessionTemplate.selectList(getStatement("TermLslistPage"), paramMap);
        
        return new PageBean(pageParam.getPageCurrent(), pageParam.getPageSize(), totalCount.intValue(), list);
    }
}
