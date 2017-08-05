/*package com.yunpay.permission.controller;

import java.text.ParseException;
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
import com.yunpay.common.core.utils.DateUtils;
import com.yunpay.controller.common.BaseController;
import com.yunpay.controller.common.UploadFileExcel;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.MccStoreEntity;
import com.yunpay.permission.service.SysMccStoreService;
import com.yunpay.permission.service.StoreService;

@Controller
@RequestMapping("/sys/mccstore")
public class SysMccStoreCtrl extends BaseController {
    private static Log log = LogFactory.getLog(SysMccStoreCtrl.class);
    
    @Autowired
    private SysMccStoreService mccStoreService;
    @Autowired
    private StoreService StoreService;
    private String beginDate;
    private String endDate;
    
    
    public SysMccStoreCtrl() throws ParseException{
        endDate = DateUtils.today();
        beginDate = DateUtils.getYesterday();
    }
    
    @SuppressWarnings("rawtypes")
    @RequiresPermissions("sys:mccstore:mccStoreList")
    @RequestMapping("/mccStoreList")
    public String mccStoreList(HttpServletRequest req, PageParam pageParam,
            MccStoreEntity mccStore,Model model) {
        try {
            String Contract_begin = mccStore.getContract_begin();
            String Contract_end = mccStore.getContract_end();
            model.addAttribute("contract_begin", Contract_begin);
            model.addAttribute("contract_end", Contract_end);
            if(Contract_begin ==null && Contract_end == null){
                mccStore.setContract_begin(beginDate);
                mccStore.setContract_end(endDate);
                model.addAttribute("contract_begin", beginDate);
                model.addAttribute("contract_end", endDate);
            }
            PageBean pageBean = mccStoreService.listPage(pageParam, mccStore);
            List<ComboxValue> ProviceList = StoreService.findProvice();
            List<ComboxValue> RegionList = StoreService.findRegion(mccStore.getProvice());
            if (RegionList.size() > 0){
                model.addAttribute("RegionList",RegionList);
            }
            model.addAttribute(pageBean);
            model.addAttribute("provice",mccStore.getProvice());
            model.addAttribute("region",mccStore.getRegion());
            model.addAttribute("ProviceList",ProviceList);
            return "modules/mccstore/mccStoreList";
        } catch (Exception e) {
            log.error("== mccStoreList exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    
    @RequiresPermissions("sys:mccstore:mccStoreList")
    @RequestMapping("/mccStoreListExcel")
    public String mccStoreListExcel(HttpServletRequest req,HttpServletResponse response, PageParam pageParam,
            MccStoreEntity mccStore,Model model) {
        try {
            List<MccStoreEntity> mcc = mccStoreService.mccStoreListExcel();
            String title = "行业门店统计报表";
            String[] headers = {"日期","城市","餐饮美食","娱乐休闲","商超购物","旅游酒店","生活服务","当前总数"};
            UploadFileExcel.setResponseHeader(title+".xls", req, response);
            UploadFileExcel.mccStoreExcel(response.getOutputStream(),title, headers,mcc);
            //写入流
            response.getOutputStream().flush();
            //关闭流
            response.getOutputStream().close();
            return null;
        } catch (Exception e) {
            log.error("== mccStoreListExcel exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    *//**
     * 下拉查询市
     * @return
     *//*
    @RequiresPermissions("sys:mccstore:mccStoreList")
    @RequestMapping("/findregion")
    public String findregion(HttpServletRequest req, Model model , String code) {
        try {
            model.addAttribute("dataList",StoreService.findRegion(code));
            return "modules/common/combox_data";
        } catch (Exception e) {
            log.error("== findSysStoreRegin exception:", e);
            return operateError("获取数据失败", model);
        }
    }
}*/