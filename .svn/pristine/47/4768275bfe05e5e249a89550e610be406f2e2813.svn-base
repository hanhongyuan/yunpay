package com.yunpay.permission.dao;


import com.yunpay.permission.entity.MerchCredit;
import com.yunpay.permission.entity.TotalCount;


@SuppressWarnings("rawtypes")
public interface MerchCreditDao extends PermissionBaseDao{
	
	/**
	 * 根据id查询商户额度
	 * @param merchId
	 * @return
	 */
	MerchCredit queryMerchCredit(String merchId);
	
	/**
	 * 合计
	 * @param merchCredit
	 * @return
	 */
	TotalCount totalCredit(MerchCredit merchCredit);
}
