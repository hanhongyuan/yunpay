package com.yunpay.permission.service;


import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.MerchCreditUpd;

public interface MerchCreditUpdService {
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param merchCredit
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, MerchCreditUpd merchCreditUpd);

	/**
	 * 添加流水（调控）
	 * @param creditUpd
	 * @return
	 */
	boolean insertMerchCredit(MerchCreditUpd creditUpd);
	
	/**
	 * 修改商户额度表
	 * @param creditUpd
	 * @return
	 */
	int updateMerchReditAmt(MerchCreditUpd creditUpd);
}
