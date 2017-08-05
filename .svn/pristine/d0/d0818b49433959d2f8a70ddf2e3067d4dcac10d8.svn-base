package com.yunpay.permission.service;

import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.LogsEntity;

public interface SysLogsService {
	
    
    /**
     * 分页查询
     * @param pageParam
     * @param LogsEntity
     * @return
     */
    @SuppressWarnings("rawtypes")
    PageBean listPage(PageParam pageParam, LogsEntity logsEntity);
    
    List<LogsEntity> Findall();
    
	/**
	 * 根据logid查询LogsEntity列表
	 * @param logid
	 * @return
	 */
	public LogsEntity selectByPrimaryKey(int logid);
	
}
