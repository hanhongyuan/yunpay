package com.yunpay.permission.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.TranSetDao;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TotalCount;
import com.yunpay.permission.entity.TranSetDetail;

@SuppressWarnings("rawtypes")
@Repository("TranSetDao")
public class TranSetDaoImpl extends PermissionBaseDaoImpl implements TranSetDao{
	
	@Override
	public List<ComboxValue> queryType(String settleFlag) {
		return super.getSqlSession().selectList(getStatement("queryType"),settleFlag);
	}
	
	@Override
	public TotalCount totalTranSet(TranSetDetail tranSet) {
		return super.getSqlSession().selectOne(getStatement("totalTranSet"),tranSet);
	}
}
