package com.yunpay.permission.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.SysDictCodeDao;
import com.yunpay.permission.entity.DictcodeEntity;


@Repository("SysDictCodeDao")
public class SysDictCodeDaoImpl extends PermissionBaseDaoImpl<DictcodeEntity> implements SysDictCodeDao {
	
	
	@Override
	public int updByDemoId(DictcodeEntity dictcode) {
		return super.getSqlSession().update(getStatement("updBySId"), dictcode);	
	}
	
	@Override
	public DictcodeEntity selectByPrimaryKey(int SId) {
		return super.getSqlSession().selectOne(getStatement(SQL_SELECT_BY_ID), SId);	
	}
	
	@Override
	public int insertdict(DictcodeEntity dictcode) {
		return super.getSqlSession().insert(getStatement("adddict"), dictcode);
	}
	
	@Override
    public int deleteBySId(int SId) {
        return super.getSqlSession().delete(getStatement("deleteBySId"), SId);
    }
	
	public List<DictcodeEntity> Findall(){
	    return super.getSqlSession().selectList(getStatement("findall"));
	}
	
}
