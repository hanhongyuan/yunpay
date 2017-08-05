package com.yunpay.database.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.yunpay.database.page.PageBean;
import com.yunpay.database.page.PageParam;


/**
 * 数据访问基类接口
 * 文件名称:     BaseDao.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月21日下午2:17:48 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月21日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public interface BaseDao<T> {

    /**
     * 函数功能说明 ：单条插入数据. 修改者名字：Along 修改日期： 2016-5-11 修改内容：
     * 
     * @参数：@param entity
     * @参数：@return
     * @return：int
     * @throws
     */
    int insert(T entity);

    /**
     * 函数功能说明 ： 批量插入数据. 修改者名字：Along 修改日期： 2016-5-11 修改内容：
     * 
     * @参数：@param list
     * @参数：@return
     * @return：int
     * @throws
     */
    int insert(List<T> list);

    /**
     * 函数功能说明 ：根据id单条更新数据. 修改者名字： Along 修改日期： 2016-5-11 修改内容：
     * 
     * @参数：@param entity
     * @参数：@return
     * @return：int
     * @throws
     */
    int update(T entity);
    
    /**
     * 动态修改
     * @Description: 
     * @author:   Zeng Dongcheng
     * @Date:     2017年6月22日上午11:21:54 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 函数功能说明 ： 根据id批量更新数据. 修改者名字：Along 修改日期： 2016-5-11 修改内容：
     * 
     * @参数：@param list
     * @参数：@return
     * @return：int
     * @throws
     */
    int update(List<T> list);

    /**
     * 函数功能说明 ： 根据column批量更新数据. 修改者名字： Along 修改日期： 2016-5-11 修改内容：
     * 
     * @参数：@param paramMap
     * @参数：@return
     * @return：int
     * @throws
     */
    int update(Map<String, Object> paramMap);

    /**
     * 函数功能说明 ： 根据id查询数据. 修改者名字： Along 修改日期： 2016-5-11 修改内容：
     * 
     * @参数：@param id
     * @参数：@return
     * @return：T
     * @throws
     */
    T getById(String id);

    /**
     * 函数功能说明 ： 根据column查询数据. 修改者名字： Along 修改日期： 2016-5-11 修改内容：
     * 
     * @参数：@param paramMap
     * @参数：@return
     * @return：T
     * @throws
     */
    public T getByColumn(Map<String, Object> paramMap);

    /**
     * 根据条件查询 listBy: <br/>
     * 
     * @param paramMap
     * @return 返回实体
     */
    public T getBy(Map<String, Object> paramMap);
    
    /**
     * 根据条件查询列表数据.
     */
    public List<T> listBy(Map<String, Object> paramMap);

    /**
     * 函数功能说明 ： 根据column查询列表数据. 修改者名字： Along 修改日期： 2016-5-11 修改内容：
     * 
     * @参数：@param paramMap
     * @参数：@return
     * @return：List<T>
     * @throws
     */
    public List<T> listByColumn(Map<String, Object> paramMap);

    /**
     * 函数功能说明 ： 根据column查询记录数. 修改者名字： Along 修改日期： 2016-1-9 修改内容：
     * 
     * @参数：@param paramMap
     * @参数：@return
     * @return：Long
     * @throws
     */
    Long getCountByColumn(Map<String, Object> paramMap);

    /**
     * 函数功能说明 ： 根据id删除数据. 修改者名字： Along 修改日期： 2016-5-11 修改内容：
     * 
     * @参数：@param id
     * @参数：@return
     * @return：int
     * @throws
     */
    int delete(String id);

    /**
     * 函数功能说明 ： 根据id批量删除数据. 修改者名字： Along 修改日期： 2016-5-11 修改内容：
     * 
     * @参数：@param list
     * @参数：@return
     * @return：int
     * @throws
     */
    int delete(List<T> list);

    /**
     * 函数功能说明 ： 根据column批量删除数据. 修改者名字：Along 修改日期： 2016-5-11 修改内容：
     * 
     * @参数：@param paramMap
     * @参数：@return
     * @return：int
     * @throws
     */
    int delete(Map<String, Object> paramMap);

    /**
     * 函数功能说明 ： 分页查询数据 . 修改者名字： Along 修改日期： 2016-5-11 修改内容：
     * 
     * @参数：@param pageParam
     * @参数：@param paramMap
     * @参数：@return
     * @return：PageBean
     * @throws
     */
    @SuppressWarnings("rawtypes")
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);

    public SqlSessionTemplate getSessionTemplate();

    public SqlSession getSqlSession();
}
