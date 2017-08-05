package com.yunpay.controller.merchant.report;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.common.core.utils.DateUtils;
import com.yunpay.common.core.utils.ExcelUtil;
import com.yunpay.controller.common.BaseController;
import com.yunpay.permission.controller.StoreCtrl;
import com.yunpay.permission.entity.DealDetail;
import com.yunpay.permission.entity.SumDateDeal;
import com.yunpay.permission.entity.SumDayDeal;
import com.yunpay.permission.entity.PayTranLs;
import com.yunpay.permission.service.MerchantReportService;
@Controller
@RequestMapping("/sys/merchantReport")
public class MerchantReportController extends BaseController{
	private static Log log = LogFactory.getLog(StoreCtrl.class);
	@Autowired
	private MerchantReportService MerchantReportService;
	
	/**
	 * 
	 * 文件名称:
	 * 内容摘要: 商户交易流水、报表
	 * @author:   duan zhang quan
	 * @version:  1.0  
	 * @Date:     2017年7月3日上午10:39:30
	 * 修改历史:  
	 * 修改日期                     修改人员                                   版本	            修改内容  
	 * ----------------------------------------------  
	 * 2017年7月3日     duan zhang quan   1.0     修改
	 * 版权:   版权所有(C)2017
	 * 公司:   深圳市至高通信技术发展有限公司
	 */
	
	
	/**
	 * 函数功能说明 ：分页查询交易流水
	 * @throws
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest req,PageParam pageParam,Model model){
		try{
			Map<String,Object>  map = this.setQueryParam(req);
			super.setRequestAttr(req, map);
			// 输出查询数据
			PageBean<PayTranLs> pageBean = (PageBean<PayTranLs>)this.MerchantReportService.list(pageParam, map);
			req.setAttribute("pageBean", pageBean);
			return "modules/merch/report/list";
		}catch(Exception e){
			 log.error("com.yunpay.controller.merchant.report.MerchantReportController.list(HttpServletRequest, PageParam, Model) exception:", e);
	         return operateError("获取数据失败", model);
		}
	}
	
	/**
	* 保存查询参数
	* @param 
	* @return void
	* @throws
	 */
	public Map<String,Object> setQueryParam(HttpServletRequest req){
		String merchantName = StringUtils.isEmpty(req.getParameter("merchantName")) == true ? null :req.getParameter("merchantName");
		try{
			// 判断是 get 还是post
			String requestMethod = req.getMethod();
			if("get".equalsIgnoreCase(requestMethod)){
				// 设置get请求时的编码格式
				if(merchantName != null){
					merchantName = new String(merchantName.getBytes("ISO-8859-1"), "UTF-8");  // 构造一个UTF-8格式的字符串
				} 
			}else if("post".equalsIgnoreCase(requestMethod)){
				
			}
			Map<String,Object> map = new HashMap<String,Object>();
			// 前端查询条件参数
			String timeBegin = StringUtils.isEmpty(req.getParameter("timeBegin")) == true ? null :req.getParameter("timeBegin");
			String timeEnd = StringUtils.isEmpty(req.getParameter("timeEnd")) == true ? null :req.getParameter("timeEnd");
			String transNum = StringUtils.isEmpty(req.getParameter("transNum")) == true ? null :req.getParameter("transNum");
			String channel = StringUtils.isEmpty(req.getParameter("channel")) == true ? null :req.getParameter("channel");
			String status = StringUtils.isEmpty(req.getParameter("status")) == true ? null : req.getParameter("status");
			String transTime = StringUtils.isEmpty(req.getParameter("transTime")) == true ? null :req.getParameter("transTime");
			String upTransTime = StringUtils.isEmpty(req.getParameter("upTransTime")) == true ? null :req.getParameter("upTransTime");
			String todayTransTime = StringUtils.isEmpty(req.getParameter("todayTransTime")) == true ? null : req.getParameter("todayTransTime");
			map.put("timeBegin", timeBegin);
			map.put("timeEnd", timeEnd);
			map.put("merchantName", merchantName);
			map.put("transNum", transNum);
			map.put("channel", channel);
			map.put("status", status);
			map.put("transTime", transTime);
			map.put("upTransTime", upTransTime);
			map.put("todayTransTime", todayTransTime);
			MerchantReportService.dateManager(map);
			return map;
		}catch(Exception e){
			e.printStackTrace();
			return new HashMap<String,Object>();
		}

	}

	
	/**
	 * 
	* 构造日交易查询数据
	* @param 
	* @return void
	* @throws
	 */
	public void buildDayDeal(HttpServletRequest req,PageParam pageParam){
		String wechat = "微信";
		String alipay = "支付宝";
		try{
			Map<String,Object> paramMap = this.setQueryParam(req);
			// 以队列的方式排列数据
			List <SumDayDeal> queue = new ArrayList<SumDayDeal>();
			// 输出日交易汇总
			List<SumDayDeal> sumDayDeal = this.MerchantReportService.sumDayDeal(paramMap);
			// 判断是否存在微信和支付宝的汇总数据
			if(sumDayDeal.size() <2){
				// 没有查询到数据时,则增加两条新记录到队列中
				if(sumDayDeal.size() == 0){
					queue.add(new  SumDayDeal(wechat,DateUtils.today()));
					queue.add(new  SumDayDeal(alipay,DateUtils.today()));
				}
				// 查询到一条数据时,则增加一条新记录到队列中
				else if(sumDayDeal.size() == 1){
					if(sumDayDeal.get(0).getChannel().equals(wechat)){
						queue.add(new SumDayDeal(alipay,DateUtils.today()));
					}
					else if(sumDayDeal.get(0).getChannel().equals(alipay)){
						SumDayDeal s1 = new SumDayDeal(wechat,DateUtils.today());
						SumDayDeal s2 = sumDayDeal.get(0);
						queue.add(s1);
						queue.add(s2);
					}
				}
			}else{
				SumDayDeal obj1 = sumDayDeal.get(0);
				SumDayDeal obj2 = sumDayDeal.get(1);
				if(obj1.getChannel().equals(wechat)){
					queue.add(obj1);
					queue.add(obj2);
				}else if(obj1.getChannel().equals(alipay)){
					queue.add(obj2);
					queue.add(obj1);
				}
			}
			// 输出日交易详细数据
			PageBean<DealDetail> dayDeal = this.MerchantReportService.dayDeal(pageParam, paramMap);
			req.setAttribute("sumDayDeal", queue);
			req.setAttribute("dayDeal", dayDeal);
			HttpSession session = req.getSession();
			session.setAttribute("sumDayDeal", queue);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

	/**
	 * 
	* 构造日期范围交易查询数据
	* @param 
	* @return void
	* @throws
	 */
	public void buildDateDeal(HttpServletRequest req,PageParam pageParam){
		try{
			Map<String,Object> paramMap = this.setQueryParam(req);
			List<SumDateDeal> sumDateDeal = this.MerchantReportService.sumDateDeal(paramMap);
			PageBean<DealDetail> dateDeal = this.MerchantReportService.dateDeal(pageParam, paramMap);
			req.setAttribute("sumDateDeal", sumDateDeal);
			req.setAttribute("dateDeal", dateDeal);
			HttpSession session = req.getSession();
			session.setAttribute("sumDateDeal", sumDateDeal);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	* 
	* 进入商户日交易或者日期范围交易汇总页面
	* @param 
	* @return Map<Integer,String>
	* @throws
	 */
	@RequestMapping("/dealReport")
	public  String  DealReport(HttpServletRequest req,PageParam pageParam,Model model){
		// 前端查询条件
		Map<String,Object> paramMap = this.setQueryParam(req);
		String transTime = (String)paramMap.get("transTime");
		super.setRequestAttr(req, paramMap);
		paramMap.put("transTime", transTime);
		// 日交易默认为当天日期
		if(StringUtils.isEmpty(transTime)){
			transTime = DateUtils.today();
		}
		String type = req.getParameter("type");
		try{
			if(type.equals("1")){  // 日交易
				this.buildDayDeal(req, pageParam);
				return "modules/merch/report/dealSum1";
			}
			else if(type.equals("2")){ // 日期范围交易
				this.buildDateDeal(req, pageParam);
				return "modules/merch/report/dealSum2";
			}
			else{
				return null;
			}
		}catch(Exception e){
			 log.error("com.yunpay.controller.merchant.report.MerchantReportController.DealReport(HttpServletRequest, PageParam, Model) exception:", e);
	         return operateError("获取数据失败", model);
		}
		
	}

	
	/**
	 * 
	*
	*  进入 商户-日交易报表页面：综合报表
	* @param 
	* @return String
	* @throws
	 */
	@RequestMapping("/dayDealReport")
	public String dayDealReport(HttpServletRequest req){
		this.buildDayDeal(req, null);
		Map<String,Object> param = this.setQueryParam(req);
		super.setRequestAttr(req, param);
		return "modules/merch/report/dayDeal";
	}
	
	
	/**
	 *
	* 输出商户 日交易报表数据：综合报表
	* @param 
	* @return Map<String,Object>
	* @throws
	 */
	@RequestMapping("/printDayDeal")
	public @ResponseBody List<SumDayDeal> printDayDeal(HttpServletRequest req){
		Map<String,Object> map = this.setQueryParam(req);
		List<SumDayDeal> wechatList = null;
		List<SumDayDeal> alipayList = null;
		List<SumDayDeal> jsonList = new ArrayList<SumDayDeal>();
		try {
			map.put("channel", "1");
			alipayList = this.MerchantReportService.printDayDeal(map);
			map.put("channel", "2");
			wechatList =  this.MerchantReportService.printDayDeal(map);
			jsonList.addAll(wechatList);
			jsonList.addAll(alipayList);
			
		} catch (Exception e) {
			 log.error("com.yunpay.controller.merchant.report.MerchantReportController.dayReportPage(HttpServletRequest req) exception:", e);
			e.printStackTrace();
		}
		return jsonList;
	}
	
	
	/**
	 * 
	*
	*  进入 商户-日期范围交易报表页面：综合报表
	* @param 
	* @return String  
	* @throws
	 */
	@RequestMapping("/dateDealReport")
	public String dateDealReport(HttpServletRequest req,PageParam pageParam,Model model){		
		Map<String,Object> paramMap = this.setQueryParam(req);
		super.setRequestAttr(req, paramMap);
		List<SumDateDeal> sumDateDeal= MerchantReportService.sumDateDeal(paramMap);
		req.setAttribute("sumDateDeal", sumDateDeal);
		return "modules/merch/report/dateDeal";
	}
	
	
	/**
	 *
	* 输出 商户日期范围交易报表数据：综合报表
	* @param 
	* @return Map<String,Object>
	* @throws
	 */
	@RequestMapping("/printDateDeal")
	public @ResponseBody Map<String,Object> printDateDeal(HttpServletRequest req){
		Map<String,Object> map = this.setQueryParam(req);
		Map<String, Object> dateDeal = this.MerchantReportService.printDateDeal(map);
		return dateDeal;
	}
	

	
	/**
	 * 
	*
	* 进入日交易报表页面：分类报表
	* @param 
	* @return PageBean<PayTranLs>
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/dayReportPage")
	public String dayReportPage(HttpServletRequest req,PageParam pageParam,Model model){
		try{
			String channel = req.getParameter("channel");
			Map<String,Object> param = this.setQueryParam(req);
			super.setRequestAttr(req, param);
			this.buildDayDeal(req, null);
			SumDayDeal sumDayDeal = null;
			HttpSession session = req.getSession();
			List<SumDayDeal> list = (List<SumDayDeal>)session.getAttribute("sumDayDeal");
			if("wechat".equals(channel)){
				 sumDayDeal = list.get(0);
			}else if("alipay".equals(channel)){
				 sumDayDeal = list.get(1);
			}
			req.setAttribute("sumDayDeal", sumDayDeal);
			req.setAttribute("channel", channel);
			return "modules/merch/report/dayReport"; 
		}catch(Exception e){
			 log.error("com.yunpay.controller.merchant.report.MerchantReportController.dayReportPage(HttpServletRequest, PageParam, Model) exception:", e);
	         return operateError("获取数据失败", model);
		}
		
	}
	
	/**
	 * 
	*
	* 输出日交易报表数据：分类报表
	* @param 
	* @return PageBean<PayTranLs>
	* @throws
	 */
	@RequestMapping("/printDayReport")
	public  @ResponseBody List<SumDayDeal> printDayReport(HttpServletRequest req,Model model){
		Map<String,Object> map = this.setQueryParam(req);
		List<SumDayDeal> dayDeal = null;
		try {
			dayDeal = this.MerchantReportService.printDayDeal(map);
		} catch (Exception e) {
			 log.error("com.yunpay.controller.merchant.report.MerchantReportController.printDayReport(HttpServletRequest req,Model model) exception:", e);
	        e.printStackTrace();
	        
		}
		return dayDeal;
	}
	
	


	/**
	 * 
	*
	*  进入日期范围交易报表页面：分类报表
	* @param 
	* @return PageBean<PayTranLs>
	* @throws
	 */
	@RequestMapping("/dateReportPage")
	public String dateReportPage(HttpServletRequest req,PageParam pageParam){
		String channel = req.getParameter("channel");
		Map<String,Object> param = this.setQueryParam(req);
		super.setRequestAttr(req, param);
		SumDateDeal sumDateDeal=new SumDateDeal();
		List<SumDateDeal> list = this.MerchantReportService.sumDateDeal(param);
		if(channel.equals("wechat")){
			 sumDateDeal = list.get(0);
		}else if(channel.equals("alipay")){
			 sumDateDeal = list.get(1);
		}
		req.setAttribute("sumDateDeal", sumDateDeal);
		req.setAttribute("channel", channel);
		return "modules/merch/report/dateReport"; 
	}
	
	
	/**
	 * 
	*
	* 输出日期范围交易报表数据：分类报表
	* @param 
	* @return PageBean<PayTranLs>
	* @throws
	 */
	@RequestMapping("/printDateReport")
	public  @ResponseBody Map<String, Object> printDateReport(HttpServletRequest req){
		/*Map<String,Object> map = this.setQueryParam(req);		
		Map<String, Object> dateDeal = this.MerchantReportService.printDateDeal(map);*/
		
		return null;
	}
	
	
	/**
	 * 导出数据到Excel
	* @param 
	* @return void
	* @throws
	 */
	@RequestMapping(value = "exportExcel", method = RequestMethod.POST)  
	public void exportExcel(HttpServletRequest req,HttpServletResponse response) { 
		String agent = req.getHeader("USER-AGENT").toLowerCase();
		Map<String,Object> params = this.setQueryParam(req);
		List<PayTranLs> list = this.MerchantReportService.listBy(params);
	    String fileName = "商户交易流水";  
	    try {
			ExcelUtil.writeExcel(response, fileName,agent, list, PayTranLs.class);
		} catch (IllegalArgumentException | IllegalAccessException
				| IOException e) {
			e.printStackTrace();
		}  
	   
	}
}
