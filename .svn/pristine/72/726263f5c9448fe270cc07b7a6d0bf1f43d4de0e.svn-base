package com.yunpay.permission.dao.impl;


import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.MerchPaymentDao;
import com.yunpay.permission.entity.MerchPayment;
import com.yunpay.permission.entity.TotalCount;

@SuppressWarnings("rawtypes")
@Repository("MerchPaymentDao")
public class MerchPaymentDaoImpl extends PermissionBaseDaoImpl implements MerchPaymentDao{
	
	@Override
	public TotalCount totalPayment(MerchPayment merchPayment){
		return super.getSqlSession().selectOne(getStatement("totalPayment"),merchPayment);
	}
}
