package com.yunpay.permission.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yunpay.common.core.dwz.DwzAjax;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.controller.common.BaseController;
import com.yunpay.permission.entity.StoreEntity;
import com.yunpay.permission.service.AddressService;
import com.yunpay.permission.service.StoreService;
/**
 * 
 * 类名称                     门店控制器类
 * 文件名称:     StoreCtrl.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午9:40:13
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
@RequestMapping("/sys/store")
public class StoreCtrl extends BaseController
{
	private static Log log = LogFactory.getLog(StoreCtrl.class);

	@Autowired
	private StoreService storeService;
	@Autowired
	private AddressService addressService;

	@SuppressWarnings("rawtypes")
	/* @RequiresPermissions("sys:store:list") */
	@RequestMapping("/list")
	public String listStore(HttpServletRequest req, PageParam pageParam, StoreEntity storeEntity, Model model)
	{
		try
		{
			PageBean pageBean = storeService.listPage(pageParam, storeEntity);
			int provId = StringUtils.isBlank(storeEntity.getProvName()) ? -1
					: Integer.parseInt(storeEntity.getProvName());
			int cityId = StringUtils.isBlank(storeEntity.getCityName()) ? -1
					: Integer.parseInt(storeEntity.getCityName());
			int areaId = StringUtils.isBlank(storeEntity.getAreaName()) ? -1
					: Integer.parseInt(storeEntity.getAreaName());
			req.setAttribute("provMap", addressService.getProvList());
			req.setAttribute("cityMap", addressService.getCityList(provId));
			req.setAttribute("areaMap", addressService.getAreaList(cityId));
			req.setAttribute("prov", provId);
			req.setAttribute("city", cityId);
			req.setAttribute("area", areaId);
			model.addAttribute(pageBean);
			return "modules/store/storeList";
		} catch (Exception e)
		{
			log.error("== ListStore exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 下拉查询市
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	/* @RequiresPermissions("sys:store:add") */
	@RequestMapping("/getCity")
	public @ResponseBody Map<Integer, String> getCity(HttpServletRequest req)
	{
		String id = req.getParameter("id");
		return addressService.getCityList(Integer.parseInt(id));
	}

	/**
	 * 下拉查询区
	 * @param req
	 * @return
	 */
	/* @RequiresPermissions("sys:store:add") */
	@RequestMapping("/getArea")
	public @ResponseBody Map<Integer, String> getArea(HttpServletRequest req)
	{
		String id = req.getParameter("id");
		return addressService.getAreaList(Integer.parseInt(id));
	}

	/**
	 * 增加门店
	 * @param req
	 * @param model
	 * @param dwz
	 * @param storeEntity
	 * @return
	 */
	@RequiresPermissions("sys:store:add")
	@RequestMapping("/add")
	public String addSysStore(HttpServletRequest req, Model model, DwzAjax dwz, StoreEntity storeEntity)
	{
		try
		{
			updateBean(storeEntity);
			/*
			 * SimpleDateFormat addsdf = new
			 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 */ // 创建时间
			storeEntity.setCreatedAt(new Date());
			// 创建人
			storeEntity.setCreatedBy(getSysUser().getId());
			// 渠道
			storeEntity.setInformationSources(0);
			// 插入数据
			if (storeService.addStoreInfo(storeEntity) > 0)
			{
				return operateSuccess(model, dwz);
			} else
			{
				return operateError("保存数据失败", model);
			}
		} catch (Exception e)
		{
			log.error("== addSysStore exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 新增 门店 查询所属商户
	 * 
	 **/
	/*
	 * @SuppressWarnings("rawtypes")
	 * 
	 * @RequiresPermissions("sys:store:add")
	 * 
	 * @RequestMapping("/lookupmerchId") public String
	 * addmerchId(HttpServletRequest req,PageParam pageParam, Model
	 * model,StoreEntity storeEntity,Merchant merchant) { try { // PageBean
	 * pageBean =StoreService.listmerch(pageParam,storeEntity); PageBean
	 * pageBean =merchService.listPage(pageParam,merchant);
	 * model.addAttribute(pageBean); return "modules/store/lookup"; } catch
	 * (Exception e) { log.error("== addSysStoreMerchid exception:", e); return
	 * operateError("获取数据失败", model); } }
	 */

	/**
	 * 跳转到修改页面
	 * 
	 * @param req
	 * @param model
	 * @param demoId
	 * @return
	 */
	@RequiresPermissions("sys:dictcode:edit")
	@RequestMapping("/editUI")
	public String editSysStoreUI(HttpServletRequest req, Model model, @RequestParam("storeNo") String storeNo)
	{
		try
		{
			// 根据ID 查询
			StoreEntity storeEntity = storeService.selectByStoreNo(storeNo);
			if (storeEntity == null)
			{
				return operateError("无法获取需要修改的数据", model);
			}
			// 获取省级信息
			/*
			 * List<ComboxValue> proviceList = StoreService.findProvice();
			 * //根据查询的门店信息获取市级信息 List<ComboxValue> RegionList =
			 * StoreService.findRegion(storeEntity.getProvicecode());
			 * //根据查询的门店信息获取区级信息 List<ComboxValue> AreaList =
			 * StoreService.findarea(storeEntity.getRegioncode());
			 * //根据查询的门店信息获取商圈信息 List<ComboxValue> AreaIdList =
			 * StoreService.findareaid(storeEntity.getAreacode());
			 * 
			 * model.addAttribute("StoreInfo",storeEntity);
			 * model.addAttribute("ProviceList",proviceList);
			 * model.addAttribute("RegionList",RegionList);
			 * model.addAttribute("AreaList",AreaList);
			 * model.addAttribute("AreaIdList",AreaIdList);
			 */
			return "modules/store/storeEdit";
		} catch (Exception e)
		{
			log.error("== editSysStore exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 
	 * 修改
	 * 
	 **/
	@RequiresPermissions("sys:store:edit")
	@RequestMapping("/edit")
	public String editSysStore(HttpServletRequest req, Model model, DwzAjax dwz, StoreEntity storeEntity)
	{
		try
		{
			updateBean(storeEntity);
			String storeNo = storeEntity.getStoreNo();
			if (storeService.selectByStoreNo(storeNo) == null)
			{
				return operateError("无法获取需要修改的数据", model);
			}
			/*
			 * SimpleDateFormat addsdf = new
			 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			 */ storeEntity.setUpdatedAt(new Date());
			if (storeService.updateStoreInfo(storeEntity) > 0)
			{
				return operateSuccess(model, dwz);
			} else
			{
				return operateError("保存数据失败", model);
			}
		} catch (Exception e)
		{
			log.error("== editSysStore exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 修改状态码 （停用/启用）
	 * 
	 * @param id
	 *            门店id
	 * @param status
	 *            状态码
	 * 
	 **/
	/* @RequiresPermissions("sys:store:edit") */
	@RequestMapping("/EditStatus")
	public String editEditStatus(HttpServletRequest req, DwzAjax dwz, @RequestParam("id") Integer id,
			@RequestParam("status") Integer status, Model model)
	{
		try
		{
			if (storeService.updateStoreStatus(id, status) > 0)
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

	/**
	 * 根据id删除
	 * 
	 * @param req
	 * @return
	 */
	@RequiresPermissions("sys:store:delete")
	@RequestMapping("/delete")
	public String findinfoById(HttpServletRequest req, @RequestParam("storeNo") String storeNo, DwzAjax dwz,
			Model model)
	{
		try
		{
			if (storeService.selectByStoreNo(storeNo) == null)
			{
				return operateError("无法获取要删除的角色", model);
			}
			storeService.deleteByStoreNo(storeNo);
			return operateSuccess(model, dwz);
		} catch (Exception e)
		{
			log.error("== deleteSysStore exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	public void updateBean(StoreEntity storeEntity)
	{
		/*
		 * if(storeEntity.getArea().equals("--请选择--")){ storeEntity.setArea("");
		 * } if(storeEntity.getAreaId().equals("--请选择--")){
		 * storeEntity.setAreaId(""); }
		 */
	}
}