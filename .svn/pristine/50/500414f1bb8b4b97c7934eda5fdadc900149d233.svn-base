package com.yunpay.permission.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yunpay.permission.entity.TermMonitorEntity;
import com.yunpay.permission.service.SysTermService;


@Controller
@RequestMapping("/mgt/monitor")
public class SysTermMonitorCtrl {
    private static Log log = LogFactory.getLog(SysTermMonitorCtrl.class);
    
    @Autowired
    private SysTermService termService;

    //自助终端信息上送
    @RequestMapping("/termMonitor")
    public String addTermMonitor(HttpServletRequest req,Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        TermMonitorEntity termMonitor = new TermMonitorEntity();
        JSONObject obj;
        try {
            String requestJsonStr = req.getParameter("param") + "";
            if (requestJsonStr == null || "".equals(requestJsonStr.trim())) {
                throw new Exception("请求参数不能为空");
            }
            JSONObject jsonObj = JSONObject.fromObject(requestJsonStr);
            termMonitor.setMerchId(String.valueOf(jsonObj.get("merchId")));
            termMonitor.setStoreNo(String.valueOf(jsonObj.get("storeNo")));
            termMonitor.setTermId(String.valueOf(jsonObj.get("termId")));
            termMonitor.setTermSeq(String.valueOf(jsonObj.get("termSeq")));
            termMonitor.setMsgType(String.valueOf(jsonObj.get("msgType")));
            termMonitor.setMsgContext(String.valueOf(jsonObj.get("msgContext")));
            termMonitor.setMsgRemark(String.valueOf(jsonObj.get("msgRemark")));
            
            if (termService.addtermMonitor(termMonitor)) {
                map.put("retCode", "00");
                map.put("retMsg", "上传成功！");
                obj = JSONObject.fromObject(map);
                model.addAttribute("MerchData", obj);
                return "modules/common/MerchDataList";
            }
            
        } catch (Exception e) {
            map.put("retCode", "01");
            map.put("retMsg", e.getMessage());
            log.error("终端监控日志上送异常-----------------", e);
        }
        obj = JSONObject.fromObject(map);
        model.addAttribute("MerchData", obj);
        return "modules/common/MerchDataList";
    }
}