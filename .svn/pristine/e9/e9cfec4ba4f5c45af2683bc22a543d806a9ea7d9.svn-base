package com.yunpay.permission.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yunpay.common.core.dwz.DwzAjax;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.common.core.utils.DateUtils;
import com.yunpay.controller.common.BaseController;
import com.yunpay.permission.entity.UnusualTranEntity;
import com.yunpay.permission.service.SysUnusualTranService;

@Controller
@RequestMapping("/sys/tran")
public class SysUnusualTranCtrl extends BaseController {
    private static Log log = LogFactory.getLog(SysUnusualTranCtrl.class);
    
    @Autowired
    private SysUnusualTranService unTranService;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static String beginDate;
    private String endDate;
    
    
    
    public SysUnusualTranCtrl() throws ParseException{
        beginDate = sdf.format(DateUtils.getFirstDateOfMonth(new Date()));
        endDate = DateUtils.today();
    }
    
    @SuppressWarnings("rawtypes")
    @RequiresPermissions("sys:tran:unUsualTranList")
    @RequestMapping("/unUsualTranList")
    public String unUsualTranList(HttpServletRequest req, PageParam pageParam,
            UnusualTranEntity unTran,Model model) {
        try {
            String Contract_begin = unTran.getContract_begin();
            String Contract_end = unTran.getContract_end();
            model.addAttribute("contract_begin", Contract_begin);
            model.addAttribute("contract_end", Contract_end);
            if(Contract_begin ==null && Contract_end == null){
                unTran.setContract_begin(beginDate);
                unTran.setContract_end(endDate);
                model.addAttribute("contract_begin", beginDate);
                model.addAttribute("contract_end", endDate);
            }
            PageBean pageBean = unTranService.listPage(pageParam, unTran);
            model.addAttribute(pageBean);
            model.addAttribute("status",unTran.getConfirmResult());
            return "modules/mccstore/unUsualTranList";
        } catch (Exception e) {
            log.error("== unUsualTranList exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    @RequiresPermissions("sys:tran:unUsualTranList")
    @RequestMapping("/unUsualTranAdd")
    public String unUsualTranAdd(HttpServletRequest req, PageParam pageParam,
            UnusualTranEntity unTran,Model model,DwzAjax dwz,String tranDate) {
        try {
            unTran.setConfirmDate(DateUtils.getLongDateStr());
            unTran.setConfirmResult("01");
            unTran.setConfirmUser(getSysUser().getLoginName());
            if(unTranService.unUsualTranAdd(unTran)){
                return operateSuccess(model, dwz);
            }
            return operateError("受理失败", model);
        } catch (Exception e) {
            log.error("== termStatusListExcel exception:", e);
            return operateError("受理失败", model);
        }
    }
}