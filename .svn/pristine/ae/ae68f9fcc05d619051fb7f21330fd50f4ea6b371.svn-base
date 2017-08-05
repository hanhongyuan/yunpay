package com.yunpay.permission.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.SignMerchDao;
import com.yunpay.permission.entity.SignMerch;
import com.yunpay.permission.entity.TotalCount;

@SuppressWarnings("rawtypes")
@Repository("SignMerchDao")
public class SignMerchDaoImpl extends PermissionBaseDaoImpl implements SignMerchDao{
	
	@Override
	public List<SignMerch> SignMerchExport(SignMerch signMerch) {
		return super.getSqlSession().selectList(getStatement("SignMerchExport"),signMerch);
	}
	
	@Override
	public TotalCount totalSignMerch(SignMerch signMerch) {
		return super.getSqlSession().selectOne(getStatement("totalSignMerch"),signMerch);
	}
	
}
