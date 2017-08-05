package com.yunpay.permission.dao.impl;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.yunpay.permission.dao.StoreDao;
import com.yunpay.permission.entity.StoreEntity;
/**
 * 
 * 类名称                     门店DAO实现类
 * 文件名称:     StoreDaoImpl.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午9:50:17
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月12日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@SuppressWarnings("rawtypes")
@Repository("StoreDao")
public class StoreDaoImpl extends PermissionBaseDaoImpl implements StoreDao
{

	@Override
	public List<StoreEntity> getStoreList(StoreEntity storeEntity)
	{
		return super.getSqlSession().selectOne(getStatement("getStoreList"), storeEntity);
	}

	@Override
	public StoreEntity selectByStoreNo(String storeNo)
	{
		return super.getSqlSession().selectOne(getStatement("selectByStoreNo"), storeNo);
	}

	@Override
	public int deleteByStoreNo(String storeNo)
	{
		return super.getSqlSession().delete(getStatement("deleteByStoreNo"), storeNo);
	}

	@Override
	public int updateStoreStatus(Map<String, Object> paramMap)
	{
		return super.getSqlSession().update(getStatement("updateStoreStatus"), paramMap);
	}

	@Override
	public int updateStoreInfo(StoreEntity storeEntity)
	{
		return super.getSqlSession().update(getStatement("updateStoreInfo"), storeEntity);
	}

	@Override
	public int addStoreInfo(StoreEntity storeEntity)
	{
		return super.getSqlSession().insert(getStatement("addStoreInfo"), storeEntity);
	}

	/*	*//**
			 * 注入SqlSessionTemplate实例(要求Spring中进行SqlSessionTemplate的配置).
			 * 可以调用sessionTemplate完成数据库操作.
			 */
	/*
	 * @Autowired private SqlSessionTemplate sessionTemplate;
	 * 
	 * public SqlSessionTemplate getSessionTemplate() { return sessionTemplate;
	 * }
	 * 
	 * public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
	 * this.sessionTemplate = sessionTemplate; }
	 * 
	 * public SqlSession getSqlSession() { return super.getSqlSession(); }
	 */
	/*	*//**
			 * 分页查询商户的数据 .
			 *//*
			 * @SuppressWarnings({ "rawtypes", "unchecked" }) public PageBean
			 * listmerch(PageParam pageParam, Map<String, Object> paramMap) { if
			 * (paramMap == null) { paramMap = new HashMap<String, Object>(); }
			 * // 统计总记录数 Long totalCount =
			 * sessionTemplate.selectOne(getStatement("listMerchCount"),
			 * paramMap);
			 * 
			 * // 校验当前页数 int currentPage =
			 * PageBean.checkCurrentPage(totalCount.intValue(),
			 * pageParam.getPageSize(), pageParam.getPageCurrent());
			 * pageParam.setPageCurrent(currentPage); // 为当前页重新设值
			 * 
			 * // 校验页面输入的每页记录数numPerPage是否合法 int numPerPage =
			 * PageBean.checkNumPerPage(pageParam.getPageSize()); // 校验每页记录数
			 * pageParam.setPageSize(numPerPage); // 重新设值
			 * 
			 * // 根据页面传来的分页参数构造SQL分页参数 paramMap.put("pageFirst",
			 * (pageParam.getPageCurrent() - 1) * pageParam.getPageSize());
			 * //从多少条数据开始 paramMap.put("pageSize", pageParam.getPageSize());
			 * //返回多少条数据 paramMap.put("startRowNum", (pageParam.getPageCurrent()
			 * - 1) * pageParam.getPageSize() + 1);//开始的行数
			 * paramMap.put("endRowNum", pageParam.getPageCurrent() *
			 * pageParam.getPageSize()); //结束的行数
			 * 
			 * // 获取分页数据集 List<Object> list =
			 * sessionTemplate.selectList(getStatement("listMerch"), paramMap);
			 * 
			 * Object isCount = paramMap.get("isCount"); //
			 * 是否统计当前分页条件下的数据：1:是，其他为否 if (isCount != null &&
			 * "1".equals(isCount.toString())) { Map<String, Object>
			 * countResultMap =
			 * sessionTemplate.selectOne(getStatement(SQL_COUNT_BY_PAGE_PARAM),
			 * paramMap); return new PageBean(pageParam.getPageCurrent(),
			 * pageParam.getPageSize(), totalCount.intValue(), list,
			 * countResultMap); } else { // 构造分页对象 return new
			 * PageBean(pageParam.getPageCurrent(), pageParam.getPageSize(),
			 * totalCount.intValue(), list); } }
			 */
}
