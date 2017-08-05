package com.yunpay.permission.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.TranInfoDao;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.MerchTran;
import com.yunpay.permission.entity.OffTranInfo;
import com.yunpay.permission.entity.OnTranInfo;
import com.yunpay.permission.entity.TotalCount;
import com.yunpay.permission.entity.TranInfo;

@SuppressWarnings("rawtypes")
@Repository("TranInfoDao")
public class TranInfoDaoImpl extends PermissionBaseDaoImpl implements TranInfoDao{
	
	@Override
	public List<OffTranInfo> offTraninfoView(TranInfo tranInfo){
		return super.getSqlSession().selectList(getStatement("offTraninfoView"),tranInfo);
	}
	
	@Override
	public List<OnTranInfo> onTraninfoView(TranInfo tranInfo){
		return super.getSqlSession().selectList(getStatement("onTraninfoView"),tranInfo);
	}
	
	@Override
    public List<ComboxValue> queryTranType(){
        return super.getSqlSession().selectList(getStatement("queryTranType"));
    }
	
	@Override
    public List<MerchTran> tranInfoExcel(){
        return super.getSqlSession().selectList(getStatement("tranInfoExcel"));
    }
    
    @Override
	public TotalCount totalTranAmt(TranInfo tranInfo){
		return super.getSqlSession().selectOne(getStatement("totalTranAmt"),tranInfo);
	}
}
