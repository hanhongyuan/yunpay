package com.yunpay.permission.service;

import java.util.List;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.Agent;

/**
 * 类名称
 * 文件名称:     AgentService.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年6月12日上午10:20:00
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月12日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */

public interface AgentService{
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param agent
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, Agent agent);
	
	/**
	 * 查询所有的代理商
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

	int updateAgent(Agent agent);

	int deleteAgent(String agentSerialNo);
	
	int insertAgent(Agent agent);
	
	/**
     * 修改状态码（停用/启用）
     * @param agentId
     * @return
     */
    public int updateAgentStatus(Integer agentId,Integer status);

}
