package com.yunpay.permission.service;



import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.MerchPayment;
import com.yunpay.permission.entity.TotalCount;

public interface MerchPaymentService {
	
	/**
	 * 分页查询商户付款明细
	 * @param pageParam
	 * @param merchPayment
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, MerchPayment merchPayment);
	
	/**
	 * 合计（付款明细）
	 * @param merchPayment
	 * @return
	 */
	TotalCount totalPayment(MerchPayment merchPayment);
	
}