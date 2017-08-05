package com.yunpay.permission.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.controller.common.BaseController;
import com.yunpay.permission.entity.LogsEntity;
import com.yunpay.permission.service.SysLogsService;


@Controller
@RequestMapping("/sys/logs")
public class SysLogsCtrl extends BaseController {
    private static Log log = LogFactory.getLog(SysLogsCtrl.class);
    
    //<!-- 1 登录 2 退出 3 浏览 4 添加 5 修改 6 删除 7 审核 8 其他 -->
    static Map<String ,String> tranMap = new HashMap<String ,String>();
    static{
        tranMap.put("1","登录");
        tranMap.put("2","退出");
        tranMap.put("3","浏览");
        tranMap.put("4","添加");
        tranMap.put("5","修改");
        tranMap.put("6","删除");
        tranMap.put("7","审核");
        tranMap.put("8","其他");
    }
    
    @Autowired
    private SysLogsService logsService;

    @SuppressWarnings("rawtypes")
    @RequiresPermissions("sys:logs:view")
    @RequestMapping("/list")
    public String listSysUser(HttpServletRequest req, PageParam pageParam,
            LogsEntity logsEntity,Model model) {
        try {
            PageBean pageBean = logsService.listPage(pageParam, logsEntity);
            model.addAttribute(pageBean);
            model.addAttribute("allinfo",FindAllInfo());
            model.addAttribute("log_type",logsEntity.getLog_type());
            return "modules/logs/logsList";
        } catch (Exception e) {
            log.error("== listSysLogs exception:", e);
            return operateError("获取数据失败", model);
        }
    }

    public List<LogsEntity> FindAllInfo() {
        try {
            //取到log_type，根据Log_type 转成相对应的 name 存到bean的Log_type_name里面
            List<LogsEntity> Logs = logsService.Findall();
            for (int i = 0; i < Logs.size(); i++) {
                Logs.get(i).setLog_type_name(tranMap.get(Logs.get(i).getLog_type()));
            }
            return Logs;
        } catch (Exception e) {
            log.error("== findSysLogsall exception:", e);
            return null;
        }
    }

    /**
     * 根据log_id查看
     * 
     * @param req
     * @return
     */
    @RequiresPermissions("sys:logs:view")
    @RequestMapping("/view")
    public String findinfoById(HttpServletRequest req,
            @RequestParam("logid") int logid,Model model) {
        try {
            LogsEntity logs = logsService.selectByPrimaryKey(logid);
            logs.setLog_type_name(tranMap.get(logs.getLog_type()));
            model.addAttribute("loginfo",logs);
            return "modules/logs/logsView";
        } catch (Exception e) {
            log.error("== findSysLogs exception:", e);
            return operateError("获取数据失败", model);
        }
    }
}