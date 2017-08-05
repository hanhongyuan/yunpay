package com.yunpay.permission.dao;

import java.util.List;

import com.yunpay.permission.entity.LogsEntity;

public interface SysLogsDao extends PermissionBaseDao<LogsEntity> {
    
    public List<LogsEntity> Findall();
    
	/**
	 * 根据id查询LogsEntity
	 * @param logid
	 * @return
	 */
	
	public LogsEntity selectByPrimaryKey(int logid);

}
