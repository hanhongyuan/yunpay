package com.yunpay.permission.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.yunpay.common.core.dwz.DwzAjax;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.controller.common.BaseController;
import com.yunpay.permission.entity.Agent;
import com.yunpay.permission.service.AgentService;

/**
 * 
 * 类名称                     代理商控制器类
 * 文件名称:     AgentCtrl.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午9:35:14
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月12日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */

@Controller
@RequestMapping("/sys/agent")
public class AgentCtrl extends BaseController
{
	@Autowired
	private AgentService agentService;
	private static Log log = LogFactory.getLog(AgentCtrl.class);

	/**
	 * 分页查询代理商
	 * 
	 * @param req
	 * @param pageParam
	 * @param agent
	 * @param model
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	/* @RequiresPermissions("sys:agent:view") */
	@RequestMapping("/list")
	public String listAgent(HttpServletRequest req, PageParam pageParam, Agent agent, Model model)
	{
		try
		{
			PageBean pageBean = agentService.listPage(pageParam, agent);
			model.addAttribute(pageBean);
			model.addAttribute("pageParam", pageParam);
			model.addAttribute("agent", agent);
			return "modules/agent/agentList";
		} catch (Exception e)
		{
			log.error("== listSysRole exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 跳转到代理商添加页面
	 * 
	 * @param req
	 * @param model
	 * @return
	 */
	/* @RequiresPermissions("sys:agent:add") */
	@RequestMapping("/addUI")
	public String addAgentUI(HttpServletRequest req, Model model)
	{
		try
		{
			return "modules/agent/agentAdd";
		} catch (Exception e)
		{
			log.error("== addagentUI get data exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 保存添加的代理商信息
	 * 
	 * @param req
	 * @param model
	 * @param agentSerialNo
	 * @param companyName
	 * @param contactMan
	 * @param tel
	 * @param baseUserId
	 * @param agent
	 * @param dwz
	 * @return
	 */
	/* @RequiresPermissions("sys:agent:add") */
	@RequestMapping("/add")
	public String addSysagent(HttpServletRequest req, Model model, @RequestParam("agentSerialNo") String agentSerialNo,
			@RequestParam("companyName") String companyName, @RequestParam("contactMan") String contactMan,
			@RequestParam("tel") String tel, Agent agent, DwzAjax dwz)
	{
		try
		{
			Agent agentByName = agentService.getAgentByName(companyName);
			if (agentByName != null)
			{
				return operateError("代理商名称【" + companyName + "】已存在", model);
			}
			Agent agentByCode = agentService.getAgentByCode(agentSerialNo);
			if (agentByCode != null)
			{
				return operateError("代理商编码【" + agentSerialNo + "】已存在", model);
			}
			// 保存基本信息
			Agent agen = new Agent();
			agen.setStatus(1);
			agen.setAuditStatus(0);
			agen.setAgentSerialNo(agentSerialNo);
			agen.setCompanyName(companyName);
			agen.setContactMan(contactMan);
			agen.setTel(tel);
			Date date = new Date();
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			Timestamp goodsC_date = Timestamp.valueOf(nowTime);
			agen.setCreatedAt(goodsC_date);
			agen.setCreatedBy(super.getSysUser().getId());
			agentService.insertAgent(agen);
			return operateSuccess(model, dwz);
		} catch (Exception e)
		{
			log.error("== addAgent exception:", e);
			return operateError("保存数据失败", model);
		}
	}

	/**
	 * 跳转到修改页面
	 * 
	 * @param req
	 * @param model
	 * @param agentSerialNo
	 * @return
	 */
	/* @RequiresPermissions("sys:agent:edit") */
	@RequestMapping("/editUI")
	public String editAgentUI(HttpServletRequest req, Model model, String agentSerialNo)
	{
		try
		{
			Agent agent = agentService.getAgentByCode(agentSerialNo);
			if (agent == null)
			{
				return operateError("获取数据失败", model);
			}

			model.addAttribute("agent", agent);
			return "/modules/agent/agentEdit";
		} catch (Exception e)
		{
			log.error("== editAgent exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 保存修改后的信息
	 * 
	 * @param req
	 * @param model
	 * @param agent
	 * @param dwz
	 * @return
	 */
	/* @RequiresPermissions("sys:agent:edit") */
	@RequestMapping("/edit")
	public String editAgent(HttpServletRequest req, Model model, Agent agent, DwzAjax dwz)
	{
		try
		{

			agentService.updateAgent(agent);
			return operateSuccess(model, dwz);
		} catch (Exception e)
		{
			log.error("== editAgent exception:", e);
			return operateError("保存失败", model);
		}
	}

	/**
	 * 跳转到查看页面
	 * 
	 * @param req
	 * @param model
	 * @param agentSerialNo
	 * @return
	 */
	/* @RequiresPermissions("sys:agent:check") */
	@RequestMapping("/checkUI")
	public String checkAgentUI(HttpServletRequest req, Model model, String agentSerialNo)
	{
		try
		{
			Agent agent = agentService.getAgentByCode(agentSerialNo);
			if (agent == null)
			{
				return operateError("获取数据失败", model);
			}
			model.addAttribute("agent", agent);
			return "/modules/agent/agentCheck";
		} catch (Exception e)
		{
			log.error("== editAgent exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 删除一个代理商
	 * 
	 * @param req
	 * @param model
	 * @param agentSerialNo
	 * @param dwz
	 * @return
	 */
	/* @RequiresPermissions("sys:agent:delete") */
	@RequestMapping("/delete")
	public String deleteAgent(HttpServletRequest req, Model model, String agentSerialNo, DwzAjax dwz)
	{
		try
		{

			Agent agentByCode = agentService.getAgentByCode(agentSerialNo);
			if (agentByCode == null)
			{
				return operateError("无法获取要删除的代理商", model);
			}

			agentService.deleteAgent(agentSerialNo);
			return operateSuccess(model, dwz);
		} catch (Exception e)
		{
			log.error("== deleteAgent exception:", e);
			return operateError("删除失败", model);
		}
	}

	/**
	 * 修改状态码 （停用/启用）
	 * 
	 * @param agentId
	 *            代理商id
	 * @param status
	 *            状态码
	 * 
	 **/
	/* @RequiresPermissions("sys:store:edit") */
	@RequestMapping("/EditStatus")
	public String editEditStatus(HttpServletRequest req, DwzAjax dwz, @RequestParam("agentId") Integer agentId,
			@RequestParam("status") Integer status, Model model)
	{
		try
		{
			if (agentService.updateAgentStatus(agentId, status) > 0)
			{
				return operateSuccess(model, dwz);
			} else
			{
				return operateError("修改状态失败", model);
			}
		} catch (Exception e)
		{
			log.error("== editSysStoreStatus exception:", e);
			return operateError("获取数据失败", model);
		}
	}
}
