package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.MerchPaymentDao;
import com.yunpay.permission.entity.MerchPayment;
import com.yunpay.permission.entity.TotalCount;
import com.yunpay.permission.service.MerchPaymentService;

@Service("MerchPaymentService")
public class MerchPaymentServiceImpl implements MerchPaymentService{
	@Autowired
	private MerchPaymentDao MerchPaymentDao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageBean listPage(PageParam pageParam, MerchPayment merchPayment) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		paramMap.put("merchName", merchPayment.getMerchName());
		paramMap.put("date1", merchPayment.getDate1());
		paramMap.put("date2", merchPayment.getDate2());
		return MerchPaymentDao.listPage(pageParam, paramMap);
	}

	@Override
	public TotalCount totalPayment(MerchPayment merchPayment) {
		return MerchPaymentDao.totalPayment(merchPayment);
	}

	
}
