package com.yunpay.permission.dao;

import java.util.List;
import java.util.Map;
import com.yunpay.permission.entity.Agent;
/**
 * 
 * 类名称                     代理商DAO接口
 * 文件名称:     AgentDao.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午9:59:40
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
public interface AgentDao extends PermissionBaseDao{
	
	/**
	 * 按查询条件查询代理商列表
	 * @param agent
	 * @return
	 */
	List<Agent> getAgentList(Agent agent);
	
	/**
	 * 通过name查询代理商
	 * @param companyName
	 * @return
	 */
	Agent getAgentByName(String companyName);
	
	/**
	 * 通过code查询代理商
	 * @param agentSerialNo
	 * @return
	 */
	Agent getAgentByCode(String agentSerialNo);
	
	/**
	 * 通过id查询代理商
	 * @param agentId
	 * @return
	 */
	Agent getById(Integer agentId);	

	int updateAgent(Agent agent);

	int deleteAgent(String agentSerialNo);
	
	int insertAgent(Agent agent);
	
    /**
    * 根据agentId修改代理商的状态
    * @param agentId
    * @param status 状态
    * @return
    */
   public int updateAgentStatus(Map<String, Object> paramMap);

}
