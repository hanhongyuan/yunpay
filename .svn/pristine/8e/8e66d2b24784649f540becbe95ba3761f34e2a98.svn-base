package com.yunpay.permission.service;



import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.MerchCredit;
import com.yunpay.permission.entity.TotalCount;

public interface MerchCreditService {
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param merchCredit
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, MerchCredit merchCredit);
	
	
	/**
	 * 根据id查询商户额度
	 * @param merchId
	 * @return
	 */
	MerchCredit queryMerchCredit(String merchId);

	/**
	 * 合计(额度查询)
	 * @param merchCredit
	 * @return
	 */
	TotalCount totalCredit(MerchCredit merchCredit);
	
	
}