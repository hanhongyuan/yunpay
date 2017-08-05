package com.yunpay.permission.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yunpay.common.core.dwz.DwzAjax;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.controller.common.BaseController;
import com.yunpay.permission.entity.Card;
import com.yunpay.permission.entity.CardReceive;
import com.yunpay.permission.service.CardReceiveService;
import com.yunpay.permission.service.CardService;
/**
 * 
 * 类名称                     商户卡券控制器类
 * 文件名称:     CardCtrl.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午9:36:19
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
@RequestMapping("/sys/card")
public class CardCtrl extends BaseController
{
	@Autowired
	private CardService cardService;
	@Autowired
	private CardReceiveService cardReceiveService;
	private static Log log = LogFactory.getLog(CardCtrl.class);

	/**
	 * 分页查询代理商
	 * 
	 * @param req
	 * @param pageParam
	 * @param card
	 * @param model
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	/* @RequiresPermissions("sys:card:view") */
	@RequestMapping("/list")
	public String listCard(HttpServletRequest req, PageParam pageParam, Card card, Model model)
	{
		try
		{
			PageBean pageBean = cardService.listPage(pageParam, card);
			model.addAttribute(pageBean);
			model.addAttribute("pageParam", pageParam);
			model.addAttribute("card", card);
			return "modules/card/cardList";
		} catch (Exception e)
		{
			log.error("== listSysRole exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 跳转到修改页面
	 * 
	 * @param req
	 * @param model
	 * @param cardSerialNo
	 * @return
	 */
	/* @RequiresPermissions("sys:card:edit") */
	@RequestMapping("/editUI")
	public String editCardUI(HttpServletRequest req, Model model, Integer id)
	{
		try
		{
			Card card = cardService.getCardById(id);
			if (card == null)
			{
				return operateError("获取数据失败", model);
			}

			model.addAttribute("card", card);
			return "modules/card/cardEdit";
		} catch (Exception e)
		{
			log.error("== editCard exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 保存修改后的信息
	 * 
	 * @param req
	 * @param model
	 * @param card
	 * @param dwz
	 * @return
	 */
	/* @RequiresPermissions("sys:card:edit") */
	@RequestMapping("/edit")
	public String editCard(HttpServletRequest req, Model model, Card card, DwzAjax dwz)
	{
		try
		{

			cardService.updateCard(card);
			return operateSuccess(model, dwz);
		} catch (Exception e)
		{
			log.error("== editCard exception:", e);
			return operateError("保存失败", model);
		}
	}

	/**
	 * 跳转到查看页面
	 * 
	 * @param req
	 * @param model
	 * @param id
	 * @return
	 */
	/* @RequiresPermissions("sys:card:check") */
	@RequestMapping("/checkUI")
	public String checkCardUI(HttpServletRequest req, Model model, Integer id)
	{
		try
		{
			Card card = cardService.getCardById(id);
			if (card == null)
			{
				return operateError("获取数据失败", model);
			}
			model.addAttribute("card", card);
			return "modules/card/cardCheck";
		} catch (Exception e)
		{
			log.error("== editCard exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 跳转到领取码页面
	 * 
	 * @param req
	 * @param model
	 * @param id
	 * @return
	 */
	/* @RequiresPermissions("sys:card:check") */
	@RequestMapping("/QRcodeUI")
	public String receiveCard(HttpServletRequest req, Model model, Integer id)
	{
		try
		{
			Card card = cardService.getCardById(id);
			if (card == null)
			{
				return operateError("获取数据失败", model);
			}
			model.addAttribute("card", card);
			return "modules/card/cardReceiveCore";
		} catch (Exception e)
		{
			log.error("== editCard exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 跳转到领取记录页面
	 * 
	 * @param req
	 * @param model
	 * @param cardReceive
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/receiveList")
	public String receiveRecords(HttpServletRequest req, PageParam pageParam, Model model, CardReceive cardReceive)
	{
		try
		{
			PageBean pageBean = cardReceiveService.listPage(pageParam, cardReceive);
			model.addAttribute(pageBean);
			model.addAttribute("pageParam", pageParam);
			model.addAttribute("cardReceive", cardReceive);
			return "modules/card/cardReceiveList";
		} catch (Exception e)
		{
			log.error("== listReceiveRecords exception:", e);
			return operateError("获取数据失败", model);
		}
	}
}
