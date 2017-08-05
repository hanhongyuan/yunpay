package com.yunpay.permission.dao.impl;



import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.MerchCreditDao;
import com.yunpay.permission.entity.MerchCredit;
import com.yunpay.permission.entity.TotalCount;

@SuppressWarnings("rawtypes")
@Repository("MerchCreditDao")
public class MerchCreditDaoImpl extends PermissionBaseDaoImpl implements MerchCreditDao{
	
	
	
	@Override
	public MerchCredit queryMerchCredit(String merchId){
		return super.getSqlSession().selectOne(getStatement("queryMerchCredit"),merchId);
	}
	
	@Override
	public TotalCount totalCredit(MerchCredit merchCredit){
		return super.getSqlSession().selectOne(getStatement("totalCredit"),merchCredit);
	}
}
