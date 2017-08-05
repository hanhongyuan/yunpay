package com.yunpay.permission.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.TranTypeDao;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TranType;

@SuppressWarnings("rawtypes")
@Repository("TranTypeDao")
public class TranTypeDaoImpl extends PermissionBaseDaoImpl implements TranTypeDao{


	@Override
	public int updateTranType(TranType tranType) {
		return super.getSqlSession().update(getStatement("updateTranType"), tranType);
	}

	@Override
	public int deleteTranType(String tranCode) {
		return super.getSqlSession().update(getStatement("deleteTranType"), tranCode);
	}

	@Override
	public int insertTranType(TranType tranType) {
		return super.getSqlSession().update(getStatement("insertTranType"), tranType);
	}

	@Override
	public List<ComboxValue> getComboxValue() {
		return super.getSqlSession().selectList(getStatement("getComboxValue"));
	}
	
	@Override
	public TranType getTranTypeByType(String tranType){
		return super.getSqlSession().selectOne(getStatement("getTranTypeByType"),tranType);
	}
	
	@Override
	public List<ComboxValue> queryTranType() {
		return super.getSqlSession().selectList(getStatement("queryTranType"));
	}

}
