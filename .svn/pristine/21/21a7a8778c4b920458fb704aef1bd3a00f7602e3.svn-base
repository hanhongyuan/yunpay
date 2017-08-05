package com.yunpay.permission.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yunpay.common.core.dwz.DwzAjax;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.controller.common.BaseController;
import com.yunpay.permission.entity.MerchNoticeEntity;
import com.yunpay.permission.service.MerchantService;


@Controller
@RequestMapping("/sys/merchant")
public class SysMerchantCtrl extends BaseController {
    private static Log log = LogFactory.getLog(SysMerchantCtrl.class);
    
    @Autowired
    private MerchantService merchantService;

    @SuppressWarnings("rawtypes")
    @RequiresPermissions("sys:merchant:list")
    @RequestMapping("/merchNoticeList")
    public String merchNoticeList(HttpServletRequest req, PageParam pageParam,
            MerchNoticeEntity merchNotice,Model model) {
        try {
            PageBean pageBean = merchantService.listPage(pageParam, merchNotice);
            model.addAttribute(pageBean);
            model.addAttribute("noticeType",merchNotice.getNoticeType());
            model.addAttribute("noticeGrade",merchNotice.getNoticeGrade());
            model.addAttribute("noticeStatus",merchNotice.getNoticeStatus());
            return "modules/merch/merchNoticeList";
        } catch (Exception e) {
            log.error("== merchNoticeList exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    @RequiresPermissions("sys:merchant:edit")
    @RequestMapping("/editStutas")
    public String editMerchStutas(HttpServletRequest req, Model model,
            @RequestParam("noticeId") String noticeId,
            @RequestParam("status") String status,DwzAjax dwz) {
        try {
            if (merchantService.editStatus(noticeId,status) > 0) {
                return operateSuccess(model, dwz);
            } else {
                return operateError("修改状态失败", model);
            }
        } catch (Exception e) {
            log.error("== editMerchStutas get data exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    /**
     * 跳转到添加页面
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("sys:merchant:add")
    @RequestMapping("/addUI")
    public String merchNoticeAddUI(HttpServletRequest req, Model model) {
        try {
            return "modules/merch/merchNoticeAdd";
        } catch (Exception e) {
            log.error("== merchNoticeAddUI exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    @RequiresPermissions("sys:merchant:add")
    @RequestMapping("/add")
    public String merchNoticeAdd(HttpServletRequest req, Model model,MerchNoticeEntity merchNotice,DwzAjax dwz) {
        try {
            merchNotice.setCreateUser(getSysUser().getLoginName());
            merchNotice.setNoticeStatus("1");
            if(merchantService.addMerchNotice(merchNotice) > 0){
                return operateSuccess(model, dwz);
            }
            return operateError("添加数据失败", model);
        } catch (Exception e) {
            log.error("== merchNoticeAdd exception:", e);
            return operateError("添加数据失败", model);
        }
    }
    
    /**
     * 跳转到修改页面
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("sys:merchant:edit")
    @RequestMapping("/editUI")
    public String merchNoticeEditUI(HttpServletRequest req, MerchNoticeEntity merchNotice,Model model) {
        try {
            MerchNoticeEntity merEntity = merchantService.findById(merchNotice.getNoticeId());
            model.addAttribute("merEntity",merEntity);
            return "modules/merch/merchNoticeEdit";
        } catch (Exception e) {
            log.error("== merchNoticeEditUI exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    @RequiresPermissions("sys:merchant:edit")
    @RequestMapping("/edit")
    public String merchNoticeEdit(HttpServletRequest req, Model model,MerchNoticeEntity merchNotice,DwzAjax dwz) {
        try {
            merchNotice.setCreateUser(getSysUser().getLoginName());
            if (merchantService.editMerchNotice(merchNotice) > 0){
                return operateSuccess(model, dwz);
            }
            return operateError("修改数据失败", model);
        } catch (Exception e) {
            log.error("== merchNoticeEdit exception:", e);
            return operateError("修改数据失败", model);
        }
    }
    
    /**
     * 删除
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("sys:merchant:delete")
    @RequestMapping("/delete")
    public String merchNoticeDel(HttpServletRequest req, Model model,MerchNoticeEntity merchNotice,DwzAjax dwz) {
        try {
            if(merchantService.delById(merchNotice.getNoticeId()) > 0){
                return operateSuccess(model, dwz);
            }
            return operateError("删除失败", model);
        } catch (Exception e) {
            log.error("== merchNoticeDel exception:", e);
            return operateError("删除失败", model);
        }
    }
    
    /**
     * 查看接收详情
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("sys:merchant:list")
    @RequestMapping("/viewNoticeRecv")
    public String viewNoticeRecv(HttpServletRequest req, Model model,MerchNoticeEntity merchNotice,DwzAjax dwz) {
        try {
            List<MerchNoticeEntity> Recv = merchantService.viewNoticeRecv(merchNotice.getNoticeId());
            model.addAttribute("Recv",Recv);
            return "modules/merch/NoticeRecvList";
        } catch (Exception e) {
            log.error("== merchNoticeDel exception:", e);
            return operateError("查看接收详情失败", model);
        }
    }

}