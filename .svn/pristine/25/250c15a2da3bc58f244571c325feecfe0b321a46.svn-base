package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.TranTypeDao;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TranType;
import com.yunpay.permission.service.TranTypeService;

@Service("TranTypeService")
public class TranTypeServiceImpl implements TranTypeService{
	@Autowired
	private TranTypeDao tranTypeDao;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public PageBean listPage(PageParam pageParam, TranType tranType) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		paramMap.put("tranType", tranType.getTranType()); 
		paramMap.put("tranDesc", tranType.getTranDesc());
		paramMap.put("appType", tranType.getAppType());
		return tranTypeDao.listPage(pageParam, paramMap);
	}

	@Override
	public int updateTranType(TranType tranType) {
		return tranTypeDao.updateTranType(tranType);
	}

	@Override
	public int deleteTranType(String tranCode) {
		return tranTypeDao.deleteTranType(tranCode);
	}

	@Override
	public int insertTranType(TranType tranType) {
		return tranTypeDao.insertTranType(tranType);
	}

	@Override
	public List<ComboxValue> getComboxValue() {
		return tranTypeDao.getComboxValue();
	}

	@Override
	public TranType getTranTypeByType(String tranType) {
		return tranTypeDao.getTranTypeByType(tranType);
	}

	@Override
	public List<ComboxValue> queryTranType() {
		return tranTypeDao.queryTranType();
	}

}
