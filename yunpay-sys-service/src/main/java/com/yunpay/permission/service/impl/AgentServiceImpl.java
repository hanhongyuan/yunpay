package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.AgentDao;
import com.yunpay.permission.entity.Agent;
import com.yunpay.permission.service.AgentService;
/**
 * 
 * 类名称                     代理商业务实现类
 * 文件名称:     AgentServiceImpl.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午9:54:07
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月12日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Service("AgentService")
public class AgentServiceImpl implements AgentService
{
	@Autowired
	private AgentDao agentDao;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageBean listPage(PageParam pageParam, Agent agent)
	{
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		paramMap.put("companyName", agent.getCompanyName());
		paramMap.put("contactMan", agent.getContactMan());
		paramMap.put("tel", agent.getTel());
		PageBean<Agent> pageBean = agentDao.listPage(pageParam, paramMap);
		return pageBean;
	}

	@Override
	public List<Agent> getAgentList(Agent agent)
	{
		return this.agentDao.getAgentList(agent);
	}

	@Override
	public Agent getAgentByName(String companyName)
	{
		return agentDao.getAgentByName(companyName);
	}

	@Override
	public Agent getAgentByCode(String agentSerialNo)
	{
		return this.agentDao.getAgentByCode(agentSerialNo);
	}

	@Override
	public int updateAgent(Agent agent)
	{
		return agentDao.updateAgent(agent);
	}

	@Override
	public int deleteAgent(String agentSerialNo)
	{
		return agentDao.deleteAgent(agentSerialNo);
	}

	@Override
	public int insertAgent(Agent agent)
	{
		return agentDao.insertAgent(agent);
	}

	@Override
	public int updateAgentStatus(Integer agentId, Integer status)
	{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("agentId", agentId);
		paramMap.put("status", status);
		return agentDao.updateAgentStatus(paramMap);
	}

}
