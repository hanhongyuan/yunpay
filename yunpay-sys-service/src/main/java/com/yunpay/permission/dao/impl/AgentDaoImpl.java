package com.yunpay.permission.dao.impl;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.yunpay.permission.dao.AgentDao;
import com.yunpay.permission.entity.Agent;
/**
 * 
 * 类名称                     代理商DAO实现类
 * 文件名称:     AgentDaoImpl.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午9:44:22
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月12日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@SuppressWarnings("rawtypes")
@Repository("AgentDao")
public class AgentDaoImpl extends PermissionBaseDaoImpl implements AgentDao
{

	@Override
	public List<Agent> getAgentList(Agent agent)
	{
		return super.getSqlSession().selectList(getStatement("getAgentList"), agent);
	}

	@Override
	public Agent getAgentByName(String companyName)
	{
		return super.getSqlSession().selectOne(getStatement("getAgentByName"), companyName);
	}

	@Override
	public Agent getAgentByCode(String agentSerialNo)
	{
		return super.getSqlSession().selectOne(getStatement("getAgentByCode"), agentSerialNo);
	}

	@Override
	public int updateAgent(Agent agent)
	{
		return super.getSqlSession().update(getStatement("updateAgent"), agent);
	}

	@Override
	public int deleteAgent(String agentSerialNo)
	{
		return super.getSqlSession().delete(getStatement("deleteAgent"), agentSerialNo);
	}

	@Override
	public int insertAgent(Agent agent)
	{
		return super.getSqlSession().insert(getStatement("insertAgent"), agent);
	}

	@Override
	public Agent getById(Integer agentId)
	{
		return super.getSqlSession().selectOne(getStatement("selectById"), agentId);
	}

	@Override
	public int updateAgentStatus(Map<String, Object> paramMap)
	{
		return super.getSqlSession().update(getStatement("updateAgentStatus"), paramMap);
	}
}
