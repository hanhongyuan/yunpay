package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SysLogsDao;
import com.yunpay.permission.entity.LogsEntity;
import com.yunpay.permission.service.SysLogsService;

@Service("SysLogsService")
public class SysLogsServiceImpl implements SysLogsService{
	@Autowired 
	SysLogsDao logsDao;
	
	@SuppressWarnings("rawtypes")
    @Override
    public PageBean listPage(PageParam pageParam, LogsEntity logsEntity) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("Login_name", logsEntity.getLogin_name());         // 登录名（模糊查询）
        paramMap.put("Log_type", logsEntity.getLog_type());             // 操作类型（模糊查询）
        paramMap.put("Contract_begin", logsEntity.getContract_begin()); // 操作时间起（精准查询 YYYY-MM-dd）
        paramMap.put("Contract_end", logsEntity.getContract_end());     // 操作时间止（精准查询 YYYY-MM-dd）
        return logsDao.listPage(pageParam, paramMap);
    }
	
     
	public List<LogsEntity> Findall() {
        return logsDao.Findall();
	}
	
	@Override
	public LogsEntity selectByPrimaryKey(int logid) {
		return logsDao.selectByPrimaryKey(logid);
	}

}
