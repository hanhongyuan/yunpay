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
import com.yunpay.permission.dao.SignMonitorDao;
import com.yunpay.permission.entity.FeedBack;

@SuppressWarnings("rawtypes")
@Repository("SignMonitorDao")
public class SignMonitorDaoImpl extends PermissionBaseDaoImpl implements SignMonitorDao{
	
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
	
	@Override
	public FeedBack getFeedBackById(String sssId) {
		return super.getSqlSession().selectOne(getStatement("getFeedBackById"),sssId);
	}

	@Override
	public int updateFeedBack(FeedBack feedBack) {
		return super.getSqlSession().update(getStatement("updateFeedBack"),feedBack);
	}
	
    @SuppressWarnings("unchecked")
	public PageBean listPageSignView(PageParam pageParam, Map<String, Object> paramMap) {
        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }

        // 统计总记录数
        Long totalCount = sessionTemplate.selectOne(getStatement("listPageCountSignView"), paramMap);
        
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
        List<Object> list = sessionTemplate.selectList(getStatement("listPageSignView"), paramMap);
        
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
