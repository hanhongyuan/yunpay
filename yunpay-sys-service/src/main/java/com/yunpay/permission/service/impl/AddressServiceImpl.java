package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunpay.permission.dao.AddressDao;
import com.yunpay.permission.entity.Address;
import com.yunpay.permission.service.AddressService;
/**
 * 
 * 类名称                     行政区域业务接口实现类
 * 文件名称:     AddressServiceImpl.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午9:51:25
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月12日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Service("AddressService")
public class AddressServiceImpl implements AddressService
{
	@Autowired
	private AddressDao addressDao;

	@Override
	public Map<Integer, String> getAllProv()
	{
		return setMap(this.addressDao.getAllProv());
	}

	@Override
	public Map<Integer, String> getProvList()
	{
		return setMap(this.addressDao.getProvList());
	}

	@Override
	public Map<Integer, String> getCityList(int id)
	{
		return setMap(this.addressDao.getCityList(id));
	}

	@Override
	public Map<Integer, String> getAreaList(int id)
	{
		return setMap(this.addressDao.getAreaList(id));
	}

	@Override
	public Address getByCode(String code)
	{
		return this.addressDao.getByCode(code);
	}

	@Override
	public Address getByTitle(String title)
	{
		return this.addressDao.getByTitle(title);
	}

	@Override
	public Address getById(Integer id)
	{
		return this.addressDao.getById(id);
	}
	
	/**
	 * 将查询到的list数据转化为map数据
	 * @param addressList
	 * @return
	 */
	private Map<Integer, String> setMap(List<Address> addressList)
	{
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < addressList.size(); i++)
		{
			Integer id = addressList.get(i).getId();
			String title = addressList.get(i).getTitle();
			map.put(id, title);
		}
		return map;
	}

}
