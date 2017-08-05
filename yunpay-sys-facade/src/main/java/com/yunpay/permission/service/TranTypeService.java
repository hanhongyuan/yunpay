package com.yunpay.permission.service;

import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TranType;

public interface TranTypeService {
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param branch
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public PageBean listPage(PageParam pageParam, TranType tranType);
	
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
