package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SignMerchDao;
import com.yunpay.permission.entity.SignMerch;
import com.yunpay.permission.entity.TotalCount;
import com.yunpay.permission.service.SignMerchService;

@Service("SignMerchService")
public class SignMerchServiceImpl implements SignMerchService{
	@Autowired
	private SignMerchDao signMerchDao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageBean listPage(PageParam pageParam, SignMerch signMerch) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		paramMap.put("proviceCode", signMerch.getProviceCode());
		paramMap.put("regionCode", signMerch.getRegionCode());
		paramMap.put("date1", signMerch.getDate1());
		paramMap.put("date2", signMerch.getDate2());
		return signMerchDao.listPage(pageParam, paramMap);
	}

	@Override
	public List<SignMerch> SignMerchExport(SignMerch signMerch){
		return signMerchDao.SignMerchExport(signMerch);
	}

	@Override
	public TotalCount totalSignMerch(SignMerch signMerch) {
		return signMerchDao.totalSignMerch(signMerch);
	}


}
