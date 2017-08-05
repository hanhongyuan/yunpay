package com.yunpay.permission.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.StoreEntity;
import com.yunpay.permission.entity.TermAppEntity;
import com.yunpay.permission.entity.TermEntity;
import com.yunpay.permission.service.StoreService;
import com.yunpay.permission.service.SysTermService;


@Controller
@RequestMapping("/sys/term")
public class SysTermCtrl extends BaseController {
    private static Log log = LogFactory.getLog(SysTermCtrl.class);

    @Autowired
    private SysTermService termService;
    @Autowired
    private StoreService StoreService;

    @SuppressWarnings("rawtypes")
    @RequiresPermissions("sys:term:view")
    @RequestMapping("/list")
    public String listSysUser(HttpServletRequest req, PageParam pageParam,
            TermEntity termEntity,Model model) {
        try {
            PageBean pageBean = termService.listPage(pageParam, termEntity);
            model.addAttribute(pageBean);
            return "modules/term/termList";
        } catch (Exception e) {
            log.error("== listTermList exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    /**
     * 修改状态码 （停用/启用）
     * @param merchId 终端号
     * @param status 状态码
     * 
     **/
    @RequiresPermissions("sys:term:edit")
    @RequestMapping("/EditStatus")
    public String EditStatus(HttpServletRequest req,DwzAjax dwz,
            @RequestParam("termSeq") String termSeq,
            @RequestParam("status") String status,Model model) {
        try {
            if (termService.editTermStatus(termSeq, status) > 0) {
                return operateSuccess(model, dwz);
            } else {
                return operateError("修改状态失败", model);
            }
        } catch (Exception e) {
            log.error("== editSysTermStatus exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    /**
     * 根据merchId撤机
     * @param merchId 终端号
     * @param req
     * @return
     */
    @RequiresPermissions("sys:term:delete")
    @RequestMapping("/delete")
    public String findinfoById(HttpServletRequest req,
            @RequestParam("termId") String termId,DwzAjax dwz,Model model) {
        try {
            if (!termService.deleteByPrimaryKey(termId,getSysUser().getLoginName())){
                return operateError("撤机失败", model);
            }
            return operateSuccess(model, dwz);
        } catch (Exception e) {
            log.error("== deleteSysTerm exception:", e);
            return operateError("撤机失败", model);
        }
    }
    
    /**
     * 跳转到添加页面
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("sys:term:add")
    @RequestMapping("/addUI")
    public String termAddUI(HttpServletRequest req, Model model) {
        try {
            //查询厂商
            List<ComboxValue> FirmList = termService.findfirm(); 
            //查询通讯方式
            List<ComboxValue> TransferTypeList = termService.findtransferType(); 
            model.addAttribute("FirmList",FirmList);
            model.addAttribute("sta","0");
            model.addAttribute("TransferTypeList",TransferTypeList);
            return "modules/term/termAdd";
        } catch (Exception e) {
            log.error("== addSysTermUI exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    /**
     * 跳转到添加页面
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("sys:term:edit")
    @RequestMapping("/editUI")
    public String termEditUI(HttpServletRequest req, Model model,String termId) {
        try {
            TermEntity term= termService.selectByPrimaryKey(termId);
            //查询厂商
            List<ComboxValue> FirmList = termService.findfirm(); 
            //查询型号
            List<ComboxValue> TypeIdList = termService.findtypeId(term.getFirm()); 
            //查询通讯方式
            List<ComboxValue> TransferTypeList = termService.findtransferType(); 
            model.addAttribute("Term",term);
            model.addAttribute("FirmList",FirmList);
            model.addAttribute("TypeIdList",TypeIdList);
            model.addAttribute("sta","2");
            model.addAttribute("TransferTypeList",TransferTypeList);
            return "modules/term/termEdit";
        } catch (Exception e) {
            log.error("== addSysTermUI exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    /**
     * 新增 门店 查询所属商户
     * 
     **/
    @SuppressWarnings("rawtypes")
    @RequiresPermissions("sys:term:add")
    @RequestMapping("/lookupmerchId")
    public String addmerchId(HttpServletRequest req,PageParam pageParam,
            Model model,StoreEntity storeEntity) {
        try {
            PageBean pageBean =termService.listStore(pageParam,storeEntity);
            model.addAttribute(pageBean);
            return "modules/term/lookup";
        } catch (Exception e) {
            log.error("== addSysStoreMerchid exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    /**
     * 连级查询型号
     * @param code
     * @return
     */
    @RequiresPermissions("sys:term:add")
    @RequestMapping("/findtypeId")
    public String findtypeId(HttpServletRequest req,@RequestParam("code") String code, Model model) {
        try {
            //查询型号
            model.addAttribute("dataList", termService.findtypeId(code));
            return "modules/common/combox_data";
        } catch (Exception e) {
            log.error("== findtypeId exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    /**
     * 添加term的查找带回
     * @param code
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequiresPermissions("sys:term:add")
    @RequestMapping("/storelookup")
    public String StoreLookUp(HttpServletRequest req,PageParam pageParam, Model model,StoreEntity storeEntity) {
        try {
            PageBean pageBean = termService.listStore(pageParam,storeEntity);
            model.addAttribute(pageBean);
            return "modules/term/lookup";
        } catch (Exception e) {
            log.error("== storelookup exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    /**
     * 添加term
     * @param code
     * @return
     */
    @RequiresPermissions("sys:term:add")
    @RequestMapping("/addterm")
    public String addterm(HttpServletRequest req, TermEntity term, Model model,DwzAjax dwz) {
        try {
            if("01".equals(term.getTransferType())){
                if("".equals(term.getGprsNo().trim())){
                    return operateError("请输入gprs卡号！", model);
                }
            }
            term.setStatus("01");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            term.setCreatetime(sdf.format(new Date()));
            term.setCreateUser(getSysUser().getLoginName());
            term.setTermFlag("1");
            term.setChannelNo(String.valueOf(getSysUser().getId()));
            
            String msg = termService.addTerm(term);
            if (msg.equals("TRUE")){
                return operateSuccess(model, dwz);
            }
            return operateError(msg, model);
        } catch (Exception e) {
            log.error("== addterm exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    /**
     * 修改term
     * @param code
     * @return
     */
    @RequiresPermissions("sys:term:edit")
    @RequestMapping("/editterm")
    public String editterm(HttpServletRequest req,
            TermEntity term, Model model,DwzAjax dwz) {
        try {
            if("01".equals(term.getTransferType())){
                if("".equals(term.getGprsNo().trim())){
                    return operateError("请输入gprs卡号！", model);
                }
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            term.setCreatetime(sdf.format(new Date()));
            term.setCreateUser(getSysUser().getLoginName());
            
            if( termService.editTerm(term) >0 ){
                return operateSuccess(model, dwz);
            }
            return operateError("修改数据失败", model);
        } catch (Exception e) {
            log.error("== editterm exception:", e);
            return operateError("修改数据失败", model);
        }
    }
    /**
     * 跳转到应用绑定页面
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("sys:term:add")
    @RequestMapping("/termyybd")
    public String termyybd(HttpServletRequest req, Model model,String seq) {
        try {
            List<TermEntity> appTerm =  termService.findTermApp(seq);
            TermEntity term = termService.findTermIdbySeq(seq);
            String termId = term.getTermId();
            String merchId = term.getMerchId();

            model.addAttribute("appTerm",appTerm);
            model.addAttribute("termId",termId);
            model.addAttribute("merchId",merchId);
            model.addAttribute("TermSeq",seq);
            return "modules/term/termyybdlayout";
        } catch (Exception e) {
            log.error("== termyybd exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    /**
     * @param req
     * @param model
     * @return
     */
    @RequiresPermissions("sys:term:add")
    @RequestMapping("/editTermAppInfo")
    public String editTermAppInfo(HttpServletRequest req, Model model,TermEntity term,String type,DwzAjax dwz) {
        try {
            String termSeq = term.getTermSeq().trim();
            String termId = term.getTermId().trim();
            String appTermNo = term.getAppTermNo().trim();
            String appCode = term.getAppCode().trim();
            if ("102".equals(type)) {
                
                model.addAttribute("TermAppId",term.getTermAppId().trim());
                model.addAttribute("appSamCard",term.getAppSamCard().trim());
                model.addAttribute("appTermSeq",term.getAppTermSeq().trim());
            }else if ("103".equals(type)) {
                  //删除绑定
                if ( termService.delTermAppInfo(term)){
                    return operateSuccess(model, dwz);
                }else {
                    return operateError("删除数据失败", model);
                }
            }
            
            TermAppEntity  termApp = termService.getTermKey(termId,term.getAppCode().trim());
            model.addAttribute("termApp",termApp);
            
            model.addAttribute("Type",type.trim());
            model.addAttribute("MerchId",term.getMerchId().trim());
            model.addAttribute("TermSeq",termSeq);
            model.addAttribute("TermId",termId);
            model.addAttribute("AppTermNo",appTermNo);
            model.addAttribute("AppCode",appCode);
            model.addAttribute("AppName",new String(term.getAppName().getBytes("ISO-8859-1"),"UTF-8").trim());
            
            return "modules/term/termappAdd";
        } catch (Exception e) {
            log.error("== editTermAppInfo exception:", e);
            return operateError("获取数据失败", model);
        }
    }
    
    /**
     * 进行添加应用 并 设置秘钥
     * @param type 101新增、102修改
     * @param termApp
     * @param term
     * @return
     */
    @RequiresPermissions("sys:term:add")
    @RequestMapping("/addTermAppInfo")
    public String addTermAppInfo(HttpServletRequest req,Model model,String type,DwzAjax dwz,
            TermAppEntity termApp, TermEntity term) {
        try {
            termApp.setOperId(getSysUser().getLoginName());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            termApp.setUpdateTime(sdf.format(new Date()));

            if(!(termApp.getAppCode().equals("01")||termApp.getAppCode().equals("08")||termApp.getAppCode().equals("11"))){
                String lmkTmk = termApp.getLmkTmk();
                String zmkTmk = termApp.getZmkTmk();
                String tmkCheckValue = termApp.getTmkCheckValue();
                String lmkTpk = termApp.getLmkTpk();
                String lmkTak = termApp.getLmkTak();
                String tmkTpk = termApp.getTmkTpk();
                String tmkTak = termApp.getTmkTak();
                String batchNo = termApp.getBatchNo();
                if(!(lmkTmk == "" && zmkTmk == "" && tmkCheckValue == "" && lmkTpk == "" && lmkTak == "" && tmkTpk == "" && tmkTak == "" && batchNo == "")){
                    return operateError("终端秘钥信息输入有误，请核查!", model);
                }
            }
            
            int iResult = 0;
            
            if(type.equals("101")){
                try {
                    iResult = termService.addTermAppInfo(term,termApp);
                } catch (Exception e) {
                    log.error("== addTermAppInfo exception:", e);
                    return operateError("应用终端信息绑定失败!", model);
                }
            }
              
            if(type.equals("102")){
                try {
                    iResult = termService.editTermAppInfo(term,termApp);
                } catch (Exception e) {
                    log.error("== editTermAppInfo exception:", e);
                    return operateError("应用终端信息绑定失败!", model);
                }
            }
            
            if (iResult == 1){
                return operateError("应用终端号已存在，不能重复!", model);
            }else if (iResult == 2){
                return operateError("SAM卡号已存在，不能重复!", model);
            }else if (iResult == 3){
                return operateError("应用终端序列号已存在，不能重复!", model);
            }else if (iResult == 4) {
                model.addAttribute("sta","3");
                return operateSuccess(model, dwz);
            }else if(iResult == 5){
                return operateError("终端信息已存在，不能重复!", model);
            }
            return operateError("添加数据失败", model);
        } catch (Exception e) {
            log.error("== addTermAppInfo exception:", e);
            return operateError("添加数据失败", model);
        }
    }
}