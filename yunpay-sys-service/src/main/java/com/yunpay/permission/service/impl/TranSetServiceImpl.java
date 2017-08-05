package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.TranSetDao;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TotalCount;
import com.yunpay.permission.entity.TranSetDetail;
import com.yunpay.permission.service.TranSetService;

@Service("TranSetService")
public class TranSetServiceImpl implements TranSetService{
	@Autowired
	private TranSetDao TranSetDao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageBean listPage(PageParam pageParam, TranSetDetail tranSetDetail) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		paramMap.put("merchName", tranSetDetail.getMerchName());
		paramMap.put("merchId", tranSetDetail.getMerchId());
		paramMap.put("issuerName", tranSetDetail.getIssuerName());
		paramMap.put("tranType", tranSetDetail.getTranType());
		paramMap.put("date1", tranSetDetail.getDate1());
		paramMap.put("date2", tranSetDetail.getDate2());
		return TranSetDao.listPage(pageParam, paramMap);
	}

	@Override
	public List<ComboxValue> queryType(String settleFlag) {
		return TranSetDao.queryType(settleFlag);
	}

	@Override
	public TotalCount totalTranSet(TranSetDetail tranSet) {
		return TranSetDao.totalTranSet(tranSet);
	}
	
	
}
