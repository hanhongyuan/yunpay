package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.MerchCreditDao;
import com.yunpay.permission.entity.MerchCredit;
import com.yunpay.permission.entity.TotalCount;
import com.yunpay.permission.service.MerchCreditService;

@Service("MerchCreditService")
public class MerchCreitServiceImpl implements MerchCreditService{
	@Autowired
	private MerchCreditDao merchCreditDao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageBean listPage(PageParam pageParam, MerchCredit merchCredit) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		paramMap.put("merchName", merchCredit.getMerchName()); 
		paramMap.put("shortName", merchCredit.getShortName());
		paramMap.put("minReal", merchCredit.getMinReal());
		paramMap.put("maxReal", merchCredit.getMaxReal());
		paramMap.put("minCurrent", merchCredit.getMinCurrent());
		paramMap.put("maxCurrent", merchCredit.getMaxCurrent());
		return merchCreditDao.listPage(pageParam, paramMap);
	}

	@Override
	public MerchCredit queryMerchCredit(String merchId) {
		return merchCreditDao.queryMerchCredit(merchId);
	}

	@Override
	public TotalCount totalCredit(MerchCredit merchCredit) {
		return merchCreditDao.totalCredit(merchCredit);
	}


}
