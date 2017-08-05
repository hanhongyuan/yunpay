/*package com.yunpay.permission.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.controller.common.BaseController;
import com.yunpay.controller.common.UploadFileExcel;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.MccStoreEntity;
import com.yunpay.permission.entity.TermStatusEntity;
import com.yunpay.permission.service.StoreService;
import com.yunpay.permission.service.SysTermStatusService;

@Controller
@RequestMapping("/sys/termstatus")
public class SysTermStatusCtrl extends BaseController {
    private static Log log = LogFactory.getLog(SysTermStatusCtrl.class);
    
    @Autowired
    private SysTermStatusService termStatusService;
    @Autowired
    private StoreService StoreService;
    
    @SuppressWarnings("rawtypes")
    @RequiresPermissions("sys:termstatus:termStatusList")
    @RequestMapping("/termStatusList")
    public String termStatusList(HttpServletRequest req, PageParam pageParam,
            TermStatusEntity termStatus,Model model) {
        try {
            PageBean pageBean = termStatusService.listPage(pageParam, termStatus);
            List<ComboxValue> RegionList = termStatusService.findRegion();
            List<ComboxValue> AreaList = StoreService.findarea(termStatus.getRegion());
            if(AreaList.size() > 0){
                model.addAttribute("AreaList",AreaList);
            }
            model.addAttribute(pageBean);
            model.addAttribute("RegionList",RegionList);
            model.addAttribute("region",termStatus.getRegion());
            model.addAttribute("area",termStatus.getArea());
            return "modules/mccstore/termStatusList";
        } catch (Exception e) {
            log.error("== termStatusList exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    @RequiresPermissions("sys:termstatus:termStatusList")
    @RequestMapping("/termStatusListExcel")
    public String termStatusListExcel(HttpServletRequest req,HttpServletResponse response, PageParam pageParam,
            MccStoreEntity mccStore,Model model) {
        try {
            List<TermStatusEntity> termStatus = termStatusService.termStatusListExcel();
            String title = "终端运营状态报表";
            String[] headers = {"终端序列号","城市区域","品牌名称","门店名称","联系人","联系电话","首次使用日期","最后使用时间","未使用天数"};
            UploadFileExcel.setResponseHeader(title+".xls", req, response);
            UploadFileExcel.termStatusExcel(response.getOutputStream(),title, headers,termStatus);
            //写入流
            response.getOutputStream().flush();
            //关闭流
            response.getOutputStream().close();
            return null;
        } catch (Exception e) {
            log.error("== termStatusListExcel exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    *//**
     * 下拉查询商圈
     * @return
     *//*
    @RequiresPermissions("sys:termstatus:termStatusList")
    @RequestMapping("/findarea")
    public String findarea(HttpServletRequest req, Model model , String code) {
        try {
            model.addAttribute("dataList",StoreService.findarea(code));
            return "modules/common/combox_data";
        } catch (Exception e) {
            log.error("== findSysStoreAreaId exception:", e);
            return operateError("获取数据失败", model);
        }
    }

}*/