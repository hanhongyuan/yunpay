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
import com.yunpay.permission.entity.DictcodeEntity;
import com.yunpay.permission.service.SysDictcodeService;

@Controller
@RequestMapping("/sys/dictcode")
public class SysDictCodeCtrl extends BaseController {
    private static Log log = LogFactory.getLog(SysDictCodeCtrl.class);
    @Autowired
    private SysDictcodeService dictService;

    @SuppressWarnings("rawtypes")
    @RequiresPermissions("sys:dictcode:view")
    @RequestMapping("/list")
    public String listSysUser(HttpServletRequest req, PageParam pageParam,
            DictcodeEntity dictEntity, Model model) {
        try {
            PageBean pageBean = dictService.listPage(pageParam, dictEntity);
            model.addAttribute(pageBean);
            model.addAttribute("allinfo",FindAllInfo());
            model.addAttribute("TypeCode",dictEntity.getTypeId());
            return "modules/dictcode/dictList";
        } catch (Exception e) {
            log.error("== listSysDictCode exception:", e);
            return operateError("获取数据失败", model);
        }
    }

    public List<DictcodeEntity> FindAllInfo() {
        return dictService.Findall();
    }
    /**
     * 跳转到添加页面
     * 
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("sys:dictcode:add")
    @RequestMapping("/addUI")
    public String addSysUserUI(HttpServletRequest req, Model model) {
        try {
            model.addAttribute("allinfo",FindAllInfo());
            return "modules/dictcode/dictAdd";
        } catch (Exception e) {
            log.error("== addSysDictCodeUI exception:", e);
            return operateError("获取数据失败", model);
        }
    }

    /**
     * 保存一个添加的数据
     * 
     * @param dictcode
     * @param typeName
     * @param dwz
     * @return
     */
    @RequiresPermissions("sys:dictcode:add")
    @RequestMapping("/add")
    public String addSysRole(HttpServletRequest req, Model model,
            DictcodeEntity dictcode,DwzAjax dwz) {
        try {
            //插入数据
            if (dictService.insert(dictcode) > 0) {
                return operateSuccess(model, dwz);
            } else {
                return operateError("保存数据失败", model);
            }
        } catch (Exception e) {
            log.error("== addSysDictCode exception:", e);
            return operateError("保存数据失败", model);
        }
    }

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
    public String editSysRoleUI(HttpServletRequest req, Model model,
            @RequestParam("sid") int sid) {
        try {
            DictcodeEntity dictEntity = dictService.selectByPrimaryKey(sid);
            if (dictEntity == null) {
                return operateError("获取数据失败", model);
            }
            model.addAttribute("dictEntity",dictEntity);
            model.addAttribute("allinfo",FindAllInfo());
            return "modules/dictcode/dictEdit";
        } catch (Exception e) {
            log.error("== editSysDictCodeUI exception:", e);
            return operateError("获取数据失败", model);
        }
    }

    /**
     * 保存修改的数据
     * 
     * @param req
     * @param model
     * @param hsDemo
     * @param dwz
     * @return
     */
    @RequiresPermissions("sys:role:edit")
    @RequestMapping("/edit")
    public String editSysRole(HttpServletRequest req, Model model,
            @RequestParam("sid") int sid,
            DictcodeEntity dictcode,DwzAjax dwz) {
        try {
            if (dictService.selectByPrimaryKey(sid) == null) {
                return operateError("修改的数据不存在", model);
            }
            
            if (dictService.updByDemoId(dictcode) > 0) {
                return operateSuccess(model, dwz);
            } else {
                return operateError("保存数据失败", model);
            }
        } catch (Exception e) {
            log.error("== editSysDictCode exception:", e);
            return operateError("保存数据失败", model);
        }
    }

    /**
     * 根据id删除数据
     * 
     * @param req
     * @param model
     * @param demoId
     * @param dwz
     * @return
     */
    @RequiresPermissions("sys:dictcode:delete")
    @RequestMapping("/delete")
    public String deleteDiceCode(HttpServletRequest req, Model model,int sid, DwzAjax dwz) {
        try {
               DictcodeEntity dictEntity = dictService.selectByPrimaryKey(sid);
               if (dictEntity == null) {
                   return operateError("无法获取要删除的角色", model);
               }
               if (dictService.deleteBySId(sid) > 0) {
                   return operateSuccess(model, dwz);
               } else {
                   return operateError("删除失败", model);
               }
        } catch (Exception e) {
            log.error("== deleteDictCode exception:", e);
            return operateError("删除失败", model);
        }
    }

}
