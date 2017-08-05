package com.yunpay.controller.merchant;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.common.core.utils.ExcelUtil;
import com.yunpay.common.core.utils.OpensslUtil;
import com.yunpay.controller.common.BaseController;
import com.yunpay.controller.login.LoginController;
import com.yunpay.permission.entity.Address;
import com.yunpay.permission.entity.AlipayConfig;
import com.yunpay.permission.entity.Merchant;
import com.yunpay.permission.entity.WechatConfig;
import com.yunpay.permission.service.MerchService;
import com.yunpay.permission.service.impl.MerchServiceImpl;
@Controller
@RequestMapping("/sys/merchant")
public class MerchantController extends BaseController{
	/**
	 * 
	 * 文件名称: 商户管理PC端
	 * 内容摘要: 
	 * @author:   duan zhang quan
	 * @version:  1.0  
	 * @Date:     2017年6月14日上午10:37:30
	 * 
	 * 修改历史:  
	 * 修改日期                     修改人员                   版本	        修改内容  
	 * ----------------------------------------------  
	 * 2017年7月11日     duan zhang quan   2.0      修改
	 *
	 * 版权:   版权所有(C)2017
	 * 公司:   深圳市至高通信技术发展有限公司
	 */
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);  
	@Autowired
	private MerchService MerchService; 
	@Autowired 
	private MerchServiceImpl  MerchServiceImpl;

	
	/**
	* 保存查询参数
	* @param 
	* @return void
	* @throws
	 */
	public Map<String,Object> setQueryParam(HttpServletRequest req){
		String registerName = StringUtils.isEmpty(req.getParameter("registerName")) == true ? null : req.getParameter("registerName");
		String contactMan =   StringUtils.isEmpty(req.getParameter("contactMan"))== true ?null : req.getParameter("contactMan");
		try{
			// 判断是 get 还是post
			String requestMethod = req.getMethod();
			if("get".equalsIgnoreCase(requestMethod)){
				// 设置get请求时的编码格式
				if(registerName != null){
					registerName = new String(registerName.getBytes("ISO-8859-1"), "UTF-8");  // 构造一个UTF-8格式的字符串
				}if(contactMan != null){
					contactMan = new String(contactMan.getBytes("ISO-8859-1"), "UTF-8");
				} 
			}else if("post".equalsIgnoreCase(requestMethod)){
				
			}
			//前端查询条件参数
			String serialNo =  StringUtils.isEmpty(req.getParameter("serialNo")) == true ? null : req.getParameter("serialNo");
			String tel =  StringUtils.isEmpty(req.getParameter("tel")) == true ? null : req.getParameter("tel");
			String prov = StringUtils.isEmpty(req.getParameter("prov")) == true ? null : req.getParameter("prov");
			String city = StringUtils.isEmpty(req.getParameter("city")) == true ? null : req.getParameter("city");
			String area = StringUtils.isEmpty(req.getParameter("area")) == true ? null : req.getParameter("area");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("serialNo", serialNo);
			map.put("registerName", registerName);
			map.put("contactMan", contactMan);
			map.put("tel", tel);
			map.put("prov", prov);
			map.put("city", city);
			map.put("area", area);
			return map;
		}catch(Exception e){
			e.printStackTrace();
			return new HashMap<String,Object>();
		}
	}
	

	/**
	 * 构造省市区数据, 广东省-深圳市-南山区..
	* @param 
	* @return void
	* @throws
	 */
	public void buildProv(List<Merchant> record,PageBean<Merchant> pageBean){
		List<Merchant> recordList = new ArrayList<Merchant>();
		// 输出所有的省市区数据
		Map<String,String> provMap = MerchService.getAllProv();
		// 输出商户信息列表数据
		for(int i=0; i<record.size(); i++){
			String str = null;
			Merchant m = record.get(i);
			String prov = provMap.get(m.getProv()) == null ? "" : provMap.get(m.getProv());
			String city = provMap.get(m.getCity()) == null ? "" : provMap.get(m.getCity());
			String area = provMap.get(m.getArea()) == null ? "" : provMap.get(m.getArea());
			
			if(!prov.equals("") && !city.equals("") && !area.equals("")){
				if(prov.equals(city)){
					str =  prov+"-"+area;
				}else{
					str =  prov+"-"+city+"-"+area;
				}
			}
			m.setProv(str);
			// 重新赋值
			recordList.add(m);
		}
		// 当存在分页的情况下
		if(pageBean != null){
			pageBean.setRecordList(recordList);
		// 没有分页的情况下
		}else{
			record = recordList;
		}
	
		
	}
	
	
	/**
	 * 函数功能说明 ： 查询商户数据.
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest req, Model model,PageParam pageParam) {
		// 前端查询条件
		Map<String,Object> map = this.setQueryParam(req);
		super.setRequestAttr(req, map);
		// 输出商户信息列表
		PageBean<Merchant> pageBean = (PageBean<Merchant>) MerchService.listPage(pageParam, map);
		this.buildProv(pageBean.getRecordList(),pageBean);
		model.addAttribute("pageBean", pageBean);
		// 输出省份数据
		Map<Integer,String> province = this.getProvince();
		req.setAttribute("provinceMap", province);
		// select选择项的回填
		model.addAttribute("cityList", this.returnSelected((String)map.get("prov")));
		model.addAttribute("areaList", this.returnSelected((String)map.get("city")));
		return "modules/merch/merchList";
	}
	
	
	/**
	 * 函数功能说明 ： 设置 select 选择项的回填
	 * @参数：
	 * @return 
	 * @throws
	 */
	public List<Address> returnSelected(String id){
		int _id = -1;
		if(id != null && !"".equals(id)){
			_id = Integer.parseInt(id);
		}
		List<Address> address = this.MerchService.getCity(_id);
		return address;
	}
	
	
	/**
	 * 函数功能说明 ： 删除商户数据.
	 * @参数： @return
	 * @return 
	 * @throws
	 */
	public Map<String,String> delete(HttpServletRequest req){
		String serialNo = req.getParameter("serialNo");
		Map<String,String> map = new HashMap<String,String>();
		return map;
	}

	
	/**
	 * 函数功能说明 ： 生成支付宝的公钥、私钥
	 * @param req
	 * // type 0-支付 1-卡券
	 * @return  
	 */
	@RequestMapping("/alipay/generateKey")
	public @ResponseBody Map<String,String> generateKey(HttpServletRequest req){
		int type = Integer.parseInt(req.getParameter("type"));
		String merchantNo = req.getParameter("merchantNo");
		Map<String,String> map = new HashMap<String,String>();
		String reg = "^\\d+$";
		if (!merchantNo.matches(reg)) {
			map.put("info", "error");
		}else{
			try {
				map = OpensslUtil.generateCert(merchantNo, type);
			} catch (Exception e) {
				map.put("info", "error");
				e.printStackTrace();
			}
		}
		return map;
	}
	

	/**
	 * 函数功能说明 ： 获取所有的省信息
	 * @参数： @return
	 * @return Map<String,String>
	 * @throws
	 */
	public Map<Integer,String> getProvince(){
		List<Address> province = this.MerchService.getProvince();
		Map<Integer,String> map = new HashMap<Integer,String>();
		for(int i=0; i<province.size(); i++){
			Address c = province.get(i);
			map.put(c.getId(), c.getTitle());
		}
		return map;
	}
	
	/**
	 * 函数功能说明 ： 根据省输出市信息
	 * @throws
	 */
	@RequestMapping("/getCity")
	public  @ResponseBody Map<Integer,String> getCity(HttpServletRequest req){
		String id = req.getParameter("id");
		List<Address> city = this.MerchService.getCity(Integer.parseInt(id));
		Map<Integer,String> map = new HashMap<Integer,String>();
		for(int i=0; i<city.size(); i++){
			Address c = city.get(i);
			map.put(c.getId(), c.getTitle());
		}
		return map;
	}
	
	/**
	 * 函数功能说明 ： 根据市输出区信息
	 * @throws
	 */
	@RequestMapping("/getArea")
	private  @ResponseBody Map<Integer,String> getArea(HttpServletRequest req){
		String id = req.getParameter("id");
		Map<Integer,String> map = new HashMap<Integer,String>();
		List<Address> area = this.MerchService.getArea(Integer.parseInt(id));
		for(int i=0; i<area.size(); i++){
			Address c = area.get(i);
			map.put(c.getId(), c.getTitle());
		}
		return map;
	}
	
	/**
	 * 函数功能说明 ：进入商户支付配置页面
	 * @param req
	 * @param serialNo：商户号
	 * @param confType:配置类型：微信、支付宝
	 * @return
	 */
	@RequestMapping("/payConfig")
	private String payConfig(HttpServletRequest req,String serialNo,String confType){
		req.setAttribute("", "");
		WechatConfig wechatConfig = (WechatConfig)this.MerchService.queryConfigById(serialNo, "wechat");
		AlipayConfig alipayConfig = (AlipayConfig)this.MerchService.queryConfigById(serialNo, "alipay");
		// 没有进行过支付配置,则关联商户号
		if(wechatConfig == null){
			wechatConfig = new WechatConfig();
			wechatConfig.setMerchantNo(serialNo);
		}if(alipayConfig == null){
			alipayConfig = new AlipayConfig();
			alipayConfig.setMerchantNo(serialNo);
		}
		// 输出支付配置数据
		req.setAttribute("wechatConfig", wechatConfig);
		req.setAttribute("alipayConfig", alipayConfig);
		return "modules/merch/payConfig";
	}
	
	/**
	 * 函数功能说明 ：保存或更新商户支付配置
	 * @param req
	 * @param serialNo：商户号
	 * @param confType:配置类型：微信、支付宝
	 * @return
	 */
	@RequestMapping(value="/savePayConfig",method=RequestMethod.POST)
	private @ResponseBody Map<String,String> savePayConfig(HttpServletRequest req,
			@ModelAttribute("wechatConfig") WechatConfig wechatConfig,
			@ModelAttribute("alipayConfig") AlipayConfig alipayConfig){
		Map<String,String> map = new HashMap<String,String>();
		String serialNo = req.getParameter("serialNo");
		String confType = req.getParameter("confType");
		Object obj = this.MerchService.isConfig(serialNo, confType);
		String merchantNo = null;
		map.put("success", "true");
		if(obj instanceof WechatConfig){
			//关联商户号
			wechatConfig.setMerchantNo(serialNo);
			WechatConfig wechat = (WechatConfig)obj;
			merchantNo = wechat.getMerchantNo();
			if(merchantNo != null){
				// 更新微信支付配置
				this.MerchService.updatePayConfig(wechatConfig);
			}else{
				// 新增
				this.MerchService.savePayConfig(wechatConfig);
			}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		}else if(obj instanceof AlipayConfig){
			//关联商户号
			alipayConfig.setMerchantNo(serialNo);
			AlipayConfig alipay = (AlipayConfig)obj;
			merchantNo = alipay.getMerchantNo();
			if(merchantNo != null){
				// 更新支付宝配置
				this.MerchService.updatePayConfig(alipayConfig);
			}else{
				// 新增
				this.MerchService.savePayConfig(alipayConfig);
			}
		}else{
			map.put("success", "false");
			return null;
		}
		return map;
	}
	
	
	/**
	 * 导出数据到Excel
	* @param 
	* @return void
	* @throws
	 */
	@RequestMapping(value = "exportExcel", method = RequestMethod.POST)  
	public void exportExcel(HttpServletRequest req,HttpServletResponse response) throws Exception {  
		String agent = req.getHeader("USER-AGENT").toLowerCase();
		Map<String,Object> params = this.setQueryParam(req);
		List<Merchant> list = this.MerchService.listBy(params);
		this.buildProv(list,null);
	    String fileName = "商户信息.xls";  
	    ExcelUtil.writeExcel(response, fileName, agent,list, Merchant.class);  
	}
	

}
