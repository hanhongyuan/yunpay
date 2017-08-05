package com.yunpay.permission.dao.impl;


import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.MerchCreditUpdDao;
import com.yunpay.permission.entity.MerchCreditUpd;

@SuppressWarnings("rawtypes")
@Repository("MerchCreditUpdDao")
public class MerchCreditUpdDaoImpl extends PermissionBaseDaoImpl implements MerchCreditUpdDao{

	@Override
	public int insertMerchCredit(MerchCreditUpd creditUpd) {
		return super.getSqlSession().insert(getStatement("insertMerchCredit"),creditUpd);
	}
	
	@Override
	public int updateMerchReditAmt(MerchCreditUpd creditUpd){
		return super.getSqlSession().update(getStatement("updateMerchReditAmt"),creditUpd);
	}
}
