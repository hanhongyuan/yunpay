package com.yunpay.database.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.yunpay.database.dao.BaseDao;
import com.yunpay.database.exception.BizException;
import com.yunpay.database.page.PageBean;
import com.yunpay.database.page.PageParam;


/**
 * 数据访问基础实现类
 * 文件名称:     BaseDaoImpl.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月21日下午2:18:12 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月21日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {

    public static final String SQL_INSERT = "insert";
    public static final String SQL_BATCH_INSERT = "batchInsert";
    public static final String SQL_UPDATE_BY_ID = "updateByPrimaryKey";
    public static final String SQL_BATCH_UPDATE_BY_IDS = "batchUpdateByIds";
    public static final String SQL_BATCH_UPDATE_BY_COLUMN = "batchUpdateByColumn";
    public static final String SQL_SELECT_BY_ID = "selectByPrimaryKey";
    public static final String SQL_LIST_BY_COLUMN = "listByColumn";
    public static final String SQL_ONE_BY_COLUMN = "oneByColumn";
    public static final String SQL_COUNT_BY_COLUMN = "getCountByColumn";
    public static final String SQL_DELETE_BY_ID = "deleteByPrimaryKey";
    public static final String SQL_BATCH_DELETE_BY_IDS = "batchDeleteByIds";
    public static final String SQL_BATCH_DELETE_BY_COLUMN = "batchDeleteByColumn";
    public static final String SQL_LIST_PAGE = "listPage";
    public static final String SQL_LIST_BY = "listBy";
    public static final String SQL_LIST_PAGE_COUNT = "listPageCount";
    public static final String SQL_COUNT_BY_PAGE_PARAM = "countByPageParam"; // 根据当前分页参数进行统计
    

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
     * @Description:新增数据
     * @author:   Zeng Dongcheng
     * @Date:     2017年6月21日下午2:20:10 
     * @param entity 对象实体
     * @return
     */
    public int insert(T entity) {
        int result = sessionTemplate.insert(getStatement(SQL_INSERT), entity);
        if (result <= 0) {
            throw BizException.DB_INSERT_RESULT_0.newInstance("数据库操作,insert返回0.{%s}", getStatement(SQL_INSERT));
        }
        return result;
    }

    /**
     * @Description:批量插入
     * @author:   	Zeng Dongcheng
     * @Date:     	2017年6月21日下午2:20:43 
     * @param list 	数据集
     * @return
     */
    public int insert(List<T> list) {
        if (list.isEmpty() || list.size() <= 0) {
            return 0;
        }
        int result = sessionTemplate.insert(getStatement(SQL_BATCH_INSERT), list);
        if (result <= 0) {
            throw BizException.DB_INSERT_RESULT_0.newInstance("数据库操作,batchInsert返回0.{%s}", getStatement(SQL_BATCH_INSERT));
        }
        return result;
    }

    /**
     * @Description: 修改数据
     * @author:   	 Zeng Dongcheng
     * @Date:     	 2017年6月21日下午2:21:06 
     * @param entity 对象实体
     * @return
     */
    public int update(T entity) {
        int result = sessionTemplate.update(getStatement(SQL_UPDATE_BY_ID), entity);
        if (result <= 0) {
            throw BizException.DB_UPDATE_RESULT_0.newInstance("数据库操作,updateByPrimaryKey返回0.{%s}", getStatement(SQL_UPDATE_BY_ID));
        }
        return result;
    }

    /**
     * @Description:批量修改
     * @author:   	Zeng Dongcheng
     * @Date:     	2017年6月21日下午2:21:30 
     * @param list	数据集
     * @return
     */
    public int update(List<T> list) {
        if (list.isEmpty() || list.size() <= 0) {
            return 0;
        }
        int result = sessionTemplate.update(getStatement(SQL_BATCH_UPDATE_BY_IDS), list);
        if (result <= 0) {
            throw BizException.DB_UPDATE_RESULT_0.newInstance("数据库操作,batchUpdateByIds返回0.{%s}", getStatement(SQL_BATCH_UPDATE_BY_IDS));
        }
        return result;
    }

    /**
     * @Description:根据column批量更新数据
     * @author:   	Zeng Dongcheng
     * @Date:     	2017年6月21日下午2:22:09 
     * @param 	  	paramMap  column集合
     * @return
     */
    public int update(Map<String, Object> paramMap) {
        if (paramMap == null) {
            return 0;
        }
        int result = sessionTemplate.update(getStatement(SQL_BATCH_UPDATE_BY_COLUMN), paramMap);
        if (result <= 0) {
            throw BizException.DB_UPDATE_RESULT_0.newInstance("数据库操作,batchUpdateByColumn返回0.{%s}", getStatement(SQL_BATCH_UPDATE_BY_COLUMN));
        }
        return result;
    }

    /**
     * @Description:根据Id查询数据
     * @author:     Zeng Dongcheng
     * @Date:       2017年6月21日下午2:22:36 
     * @param id
     * @return
     */
    public T getById(String id) {
        return sessionTemplate.selectOne(getStatement(SQL_SELECT_BY_ID), id);
    }

    /**
     * @Description:根据column查询数据
     * @author:   	Zeng Dongcheng
     * @Date:     	2017年6月21日下午2:23:04 
     * @param paramMap
     * @return
     */
    public T getByColumn(Map<String, Object> paramMap) {
        if (paramMap == null) {
            return null;
        }
        return sessionTemplate.selectOne(getStatement(SQL_ONE_BY_COLUMN), paramMap);
    }

    /**
     * @Description:根据条件查询
     * @author:   Zeng Dongcheng
     * @Date:     2017年6月21日下午2:23:27 
     * @param paramMap
     * @return
     */
    public T getBy(Map<String, Object> paramMap) {
        if (paramMap == null) {
            return null;
        }
        return sessionTemplate.selectOne(getStatement(SQL_LIST_BY), paramMap);
    }
    
    /**
     * 根据条件查询列表数据.
     */
    public List<T> listBy(Map<String, Object> paramMap) {
        if (paramMap == null) {
            return null;
        }
        return sessionTemplate.selectList(getStatement(SQL_LIST_BY), paramMap);
    }

    /**
     * 根据column查询列表数据.
     */
    public List<T> listByColumn(Map<String, Object> paramMap) {
        if (paramMap == null) {
            return null;
        }
        return sessionTemplate.selectList(getStatement(SQL_LIST_BY_COLUMN), paramMap);
    }

    /**
     * 根据column查询记录数.
     */
    public Long getCountByColumn(Map<String, Object> paramMap) {
        if (paramMap == null) {
            return null;
        }
        return sessionTemplate.selectOne(getStatement(SQL_COUNT_BY_COLUMN), paramMap);
    }

    /**
     * 根据id删除数据.
     */
    public int delete(String id) {
        return (int) sessionTemplate.delete(getStatement(SQL_DELETE_BY_ID), id);
    }

    /**
     * 根据id批量删除数据.
     */
    public int delete(List<T> list) {
        if (list.isEmpty() || list.size() <= 0) {
            return 0;
        } else {
            return (int) sessionTemplate.delete(getStatement(SQL_BATCH_DELETE_BY_IDS), list);
        }
    }

    /**
     * 根据column批量删除数据.
     */
    public int delete(Map<String, Object> paramMap) {
        if (paramMap == null) {
            return 0;
        } else {
            return (int) sessionTemplate.delete(getStatement(SQL_BATCH_DELETE_BY_COLUMN), paramMap);
        }
    }

    /**
     * 分页查询数据 .
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }

        // 统计总记录数
        Long totalCount = sessionTemplate.selectOne(getStatement(SQL_LIST_PAGE_COUNT), paramMap);

        // 校验当前页数
        int currentPage = PageBean.checkCurrentPage(totalCount.intValue(), pageParam.getPageSize(), pageParam.getPageCurrent());
        pageParam.setPageCurrent(currentPage); // 为当前页重新设值
        // 校验页面输入的每页记录数numPerPage是否合法
        int numPerPage = PageBean.checkNumPerPage(pageParam.getPageSize()); // 校验每页记录数
        pageParam.setPageSize(numPerPage); // 重新设值

        // 根据页面传来的分页参数构造SQL分页参数
        paramMap.put("pageFirst", (pageParam.getPageCurrent() - 1) * pageParam.getPageSize());
        paramMap.put("pageSize", pageParam.getPageSize());
        paramMap.put("startRowNum", (pageParam.getPageCurrent() - 1) * pageParam.getPageSize() + 1);
        paramMap.put("endRowNum", pageParam.getPageCurrent() * pageParam.getPageSize());

        // 获取分页数据集
        List<Object> list = sessionTemplate.selectList(getStatement(SQL_LIST_PAGE), paramMap);

        Object isCount = paramMap.get("isCount"); // 是否统计当前分页条件下的数据：1:是，其他为否
        if (isCount != null && "1".equals(isCount.toString())) {
            Map<String, Object> countResultMap = sessionTemplate.selectOne(getStatement(SQL_COUNT_BY_PAGE_PARAM), paramMap);
            return new PageBean(pageParam.getPageCurrent(), pageParam.getPageSize(), totalCount.intValue(), list, countResultMap);
        } else {
            // 构造分页对象
            return new PageBean(pageParam.getPageCurrent(), pageParam.getPageSize(), totalCount.intValue(), list);
        }
    }

    /**
     * 函数功能说明 ： 获取Mapper命名空间. 修改者名字： Along 修改日期： 2016-1-8 修改内容：
     * 
     * @参数：@param sqlId
     * @参数：@return
     * @return：String
     * @throws
     */
    public String getStatement(String sqlId) {
        String name = this.getClass().getName();
        // 单线程用StringBuilder，确保速度；多线程用StringBuffer,确保安全
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(".").append(sqlId);
        return sb.toString();
    }

}
