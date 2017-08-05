package com.yunpay.permission.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.yunpay.permission.dao.AddressDao;
import com.yunpay.permission.entity.Address;
import com.yunpay.permission.entity.Merchant;
/**
 * 
 * 类名称                     行政区域DAO实现类
 * 文件名称:     AddressDaoImpl.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午9:42:12
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月12日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */

@Repository("AddressDao")
public class AddressDaoImpl extends PermissionBaseDaoImpl<Merchant> implements AddressDao
{

	@Override	
	public List<Address> getAllProv()
	{
		return super.getSqlSession().selectList(getStatement("getAllProv"));
	}

	@Override
	public List<Address> getProvList()
	{
		return super.getSqlSession().selectList(getStatement("getProvList"));
	}

	@Override
	public List<Address> getCityList(int id)
	{

		return super.getSqlSession().selectList(getStatement("getCityList"), id);
	}

	@Override
	public List<Address> getAreaList(int id)
	{

		return super.getSqlSession().selectList(getStatement("getAreaList"), id);
	}

	@Override
	public Address getByCode(String code)
	{
		return super.getSqlSession().selectOne(getStatement("getByCode"), code);
	}

	@Override
	public Address getByTitle(String title)
	{
		return super.getSqlSession().selectOne(getStatement("getByTitle"), title);
	}

	@Override
	public Address getById(Integer id)
	{
		return super.getSqlSession().selectOne(getStatement("getById"), id);
	}
}
