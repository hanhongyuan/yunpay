package com.yunpay.permission.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.SysLogsDao;
import com.yunpay.permission.entity.LogsEntity;


@Repository("SysLogsDao")
public class SysLogsDaoImpl extends PermissionBaseDaoImpl<LogsEntity> implements SysLogsDao {
	
	@Override
	public LogsEntity selectByPrimaryKey(int logid) {
		return super.getSqlSession().selectOne(getStatement(SQL_SELECT_BY_ID), logid);	
	}
	
	public List<LogsEntity> Findall(){
	    return super.getSqlSession().selectList(getStatement("findall"));
	}
}
