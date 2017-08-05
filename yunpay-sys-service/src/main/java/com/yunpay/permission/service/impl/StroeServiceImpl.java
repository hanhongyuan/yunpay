package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.AddressDao;
import com.yunpay.permission.dao.StoreDao;
import com.yunpay.permission.entity.StoreEntity;
import com.yunpay.permission.service.StoreService;
/**
 * 
 * 类名称                      门店业务接口实现类
 * 文件名称:     StroeServiceImpl.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午9:57:46
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月12日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Service("StoreService")
public class StroeServiceImpl implements StoreService
{
	@Autowired
	StoreDao storeDao;
	@Autowired
	AddressDao addressDao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageBean listPage(PageParam pageParam, StoreEntity storeEntity)
	{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("storeName", storeEntity.getStoreName()); // 门店名称（模糊查询）
		paramMap.put("registerName", storeEntity.getRegisterName()); // 商户名称（模糊查询）
		paramMap.put("contactMan", storeEntity.getContactMan()); // 联系人（模糊查询）
		paramMap.put("tel", storeEntity.getTel()); // 手机（精确查询）
		if (StringUtils.isNotBlank(storeEntity.getProvName()))
		{
			// 页面将id存在provName属性中，取出后转成Integer id,通过id取得address实例，从而取得省名称
			paramMap.put("provName", addressDao.getById(Integer.parseInt(storeEntity.getProvName())).getTitle()); // 省（精确查询）
		}
		if (StringUtils.isNotBlank(storeEntity.getCityName()))
		{
			// 页面将id存在cityName属性中，取出后转成Integer id,通过id取得address实例，从而取得市名称
			paramMap.put("cityName", addressDao.getById(Integer.parseInt(storeEntity.getCityName())).getTitle()); // 省（精确查询）
		}
		if (StringUtils.isNotBlank(storeEntity.getAreaName()))
		{
			// 页面将id存在areaName属性中，取出后转成Integer id,通过id取得address实例，从而取得区名称
			paramMap.put("areaName", addressDao.getById(Integer.parseInt(storeEntity.getAreaName())).getTitle()); // 省（精确查询）
		}
		return storeDao.listPage(pageParam, paramMap);
	}

	@Override
	public int updateStoreStatus(Integer id, Integer status)
	{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("status", status);
		return storeDao.updateStoreStatus(paramMap);
	}

	public int updateStoreInfo(StoreEntity storeEntity)
	{
		return storeDao.updateStoreInfo(storeEntity);
	}

	public int addStoreInfo(StoreEntity storeEntity)
	{
		return storeDao.addStoreInfo(storeEntity);
	}

	@Override
	public StoreEntity selectByStoreNo(String storeNo)
	{
		return storeDao.selectByStoreNo(storeNo);
	}

	@Override
	public int deleteByStoreNo(String storeNo)
	{
		return storeDao.deleteByStoreNo(storeNo);
	}

}
