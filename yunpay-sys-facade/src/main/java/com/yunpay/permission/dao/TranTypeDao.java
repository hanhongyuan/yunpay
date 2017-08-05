package com.yunpay.permission.dao;

import java.util.List;

import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TranType;


@SuppressWarnings("rawtypes")
public interface TranTypeDao extends PermissionBaseDao{
	
	public int updateTranType(TranType tranType);
	
	public int deleteTranType(String tranCode);
	
	public int insertTranType(TranType tranType);
	
	/**
	 * 得到下拉框的值
	 * @return
	 */
	public List<ComboxValue> getComboxValue();
	
	public TranType getTranTypeByType(String tranType);
	
	/**
	 * 获取交易类型，只上线的
	 * @return
	 */
	public List<ComboxValue> queryTranType();

}
