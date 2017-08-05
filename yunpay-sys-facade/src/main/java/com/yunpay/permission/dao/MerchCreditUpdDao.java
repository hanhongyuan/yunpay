package com.yunpay.permission.dao;

import com.yunpay.permission.entity.MerchCreditUpd;

@SuppressWarnings("rawtypes")
public interface MerchCreditUpdDao extends PermissionBaseDao{
	
	/**
	 * 添加流水（调控）
	 * @param creditUpd
	 * @return
	 */
	int insertMerchCredit(MerchCreditUpd creditUpd);
	
	/**
	 * 修改商户额度表
	 * @param creditUpd
	 * @return
	 */
	int updateMerchReditAmt(MerchCreditUpd creditUpd);
}
