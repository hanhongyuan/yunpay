package com.yunpay.permission.controller;

import javax.servlet.http.HttpServletRequest;

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
import com.yunpay.permission.entity.TermLsEntity;
import com.yunpay.permission.service.TermsService;


@Controller
@RequestMapping("/sys/termls")
public class SysTermLsCtrl extends BaseController {
    private static Log log = LogFactory.getLog(SysTermLsCtrl.class);
    
    @Autowired
    private TermsService termService;

    /**
     *   分页查询
     * */
    @SuppressWarnings("rawtypes")
    @RequiresPermissions("sys:termLs:view")
    @RequestMapping("/list")
    public String listSysTerm(HttpServletRequest req, PageParam pageParam,
            TermLsEntity termLsEntity,Model model) {
        try {
            PageBean pageBean = termService.TermLslistPage(pageParam, termLsEntity);
            //查询操作类型
            model.addAttribute("dealtypeList",termService.selectdealtype());
            //查询厂商
            model.addAttribute("firmList",termService.selectfirm());
            String code = "NULL";
            if(termLsEntity.getFirm() != null){
                code = termLsEntity.getFirm();
            }
            model.addAttribute("typeIdList",termService.findtypeId(code));
            model.addAttribute("firm",termLsEntity.getFirm());
            model.addAttribute("typeId",termLsEntity.getTypeId());
            model.addAttribute("dealType",termLsEntity.getDealType());
            model.addAttribute(pageBean);
            return "modules/term/termlsList";
        } catch (Exception e) {
            log.error("== listSysMac exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    /**
     * 二级下拉查询型号
     * @return
     */
    @RequiresPermissions("sys:termLs:view")
    @RequestMapping("/findtypeId")
    public String findtypeId(HttpServletRequest req, Model model , String code) {
        try {
            model.addAttribute("dataList",termService.findtypeId(code));
            return "modules/common/combox_data";
        } catch (Exception e) {
            log.error("== findSysStoreRegin exception:", e);
            return operateError("获取数据失败", model);
        }
    }
   
}