package com.yunpay.permission.controller;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
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
import com.yunpay.controller.common.BaseController;
import com.yunpay.permission.entity.SysVersion;
import com.yunpay.permission.service.SysVersionService;

/**
 * 
 *系统版本
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Controller
@RequestMapping("/sys/sysVersion")
public class SysVersionCtrl extends BaseController {
	@Autowired
	private SysVersionService sysVersionService;
	private static Log log = LogFactory.getLog(SysVersionCtrl.class);

	/**
	 * 分页查询版本信息
	 * @param req
	 * @param pageParam
	 * @param agent
	 * @param model
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequiresPermissions("sys:sysVersion:list")
	@RequestMapping("/sysVersionList")
	public String listSysVersion(HttpServletRequest req, PageParam pageParam, SysVersion sysVersion, Model model) {
		try {
			PageBean pageBean = sysVersionService.listPage(pageParam, sysVersion);
			model.addAttribute(pageBean);
			model.addAttribute("pageParam", pageParam);
			return "modules/sysVersion/sysVersionList";
		} catch (Exception e) {
			log.error("== listSysVersion exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 跳转到版本添加页面
	 * @param req
	 * @param model
	 * @return
	 */
	@RequiresPermissions("sys:sysVersion:add")
	@RequestMapping("/addUI")
	public String addAgentUI(HttpServletRequest req, Model model) {
		try {
			return "modules/sysVersion/sysVersionAdd";
		} catch (Exception e) {
			log.error("== addSysVersionUI get data exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 保存添加的版本信息
	 * @param req
	 * @param model
	 * @param agentCode
	 * @param agentName
	 * @param agentlinkMan
	 * @param agentlinkTel
	 * @param agentKey
	 * @param agent
	 * @param dwz
	 * @return
	 */
	@RequiresPermissions("sys:sysVersion:add")
	@RequestMapping("/add")
	public String addSysagent(HttpServletRequest req, Model model, SysVersion sysVersion, DwzAjax dwz) {
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String verSavenamePrefix = sdf.format(date);
			String verNo = "";
			String verSavename = "";
			String verFilename = "";
			InputStream in = null;
			DiskFileItemFactory factory = new DiskFileItemFactory();
            ResourceBundle systemConfig = ResourceBundle.getBundle(
                    "config/system", Locale.getDefault());
            String uploadSysUrl = systemConfig.getString("merchEleSignUrl");
            factory.setRepository(new File(uploadSysUrl));
            // 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
            factory.setSizeThreshold(1024 * 1024);
            ServletFileUpload upload = new ServletFileUpload(factory);
            @SuppressWarnings("rawtypes")
            List list = upload.parseRequest(req);
            @SuppressWarnings("rawtypes")
            Iterator itr = list.iterator();
            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                if (item.isFormField()) {
                    if("verNo".equals(item.getFieldName()) && item.getString("UTF-8") != null && !item.getString("UTF-8").equals("")){
                    	verNo =item.getString("UTF-8");
                    	verSavenamePrefix =verSavenamePrefix + "_" + verNo;
                    }
                    if("verName".equals(item.getFieldName()) && item.getString("UTF-8") != null && !item.getString("UTF-8").equals("")){
                    	sysVersion.setVerName(item.getString("UTF-8"));
                    }
                    if("verType".equals(item.getFieldName()) && item.getString("UTF-8") != null && !item.getString("UTF-8").equals("")){
                    	sysVersion.setVerType(item.getString("UTF-8"));
                    }
                    if("verRmk".equals(item.getFieldName()) && item.getString("UTF-8") != null && !item.getString("UTF-8").equals("")){
                    	sysVersion.setVerRmk(item.getString("UTF-8"));
                    }
                } else {
                    if (item.getName() != null && !item.getName().equals("")) {
                    	//提交的文件加后缀名
                        String fileName = item.getName();
                        //版本文件名称
                        verFilename = fileName.split("\\.")[0];
                        sysVersion.setVerFilename(verFilename);
                        //存储到数据库中的文件名
                        verSavename = verSavenamePrefix+"."+fileName.split("\\.")[1];
                        // 上传文件的保存路径
                       /* File saveFile = new File(uploadSysUrl+verSavename);
                        sysVersion.setVerDir(uploadSysUrl+verSavename);
                        if (!saveFile.getParentFile().exists()) {
    	                    // 如果不存在就创建这个文件夹
    	                    saveFile.getParentFile().mkdirs();
    	                }
    	                InputStream in = item.getInputStream();
    	                FileUtils.copyToFile(in, saveFile);*/
                        in = item.getInputStream();
                    }
                }
            }
            // 上传文件的保存路径
            File saveFile = new File(uploadSysUrl+verSavename);
            sysVersion.setVerDir(uploadSysUrl+verSavename);
            if (!saveFile.getParentFile().exists()) {
                // 如果不存在就创建这个文件夹
                saveFile.getParentFile().mkdirs();
            }
            FileUtils.copyToFile(in, saveFile);
            sysVersion.setVerNo(verNo);
            sysVersion.setVerSavename(verSavename);
			sysVersion.setCreateTime(new Date());
			sysVersion.setCreateUser(getSysUser().getLoginName());
			sysVersionService.insertSysVersion(sysVersion);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== addASysVersion exception:", e);
			return operateError("保存数据失败", model);
		}
		
	}
	
	/**
	 * 跳转到修改页面
	 * @param req
	 * @param model
	 * @param agentCode
	 * @return
	 */
	@RequiresPermissions("sys:sysVersion:edit")
	@RequestMapping("/editUI")
	public String editAgentUI(HttpServletRequest req, Model model, long verId) {
		try {
			SysVersion sysVersion = sysVersionService.getSysVersion(verId);
			if (sysVersion == null) {
				return operateError("查找不到版本信息！", model);
			}
			model.addAttribute("sysVersion",sysVersion);
			return "/modules/sysVersion/sysVersionEdit";
		} catch (Exception e) {
			log.error("== editSysVersion exception:", e);
			return operateError("获取数据失败", model);
		}
	}

	/**
	 * 保存修改后的信息
	 * @param req
	 * @param model
	 * @param agent
	 * @param dwz
	 * @return
	 */
	@RequiresPermissions("sys:sysVersion:edit")
	@RequestMapping("/edit")
	public String editAgent(HttpServletRequest req, Model model, SysVersion sysVersion, DwzAjax dwz) {
		try {
			
			sysVersionService.updateSysVersion(sysVersion);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== editSysVersion exception:", e);
			return operateError("修改失败", model);
		}
	}

	/**
	 * 删除一个版本
	 * @param req
	 * @param model
	 * @param agentCode
	 * @param dwz
	 * @return
	 */
	@RequiresPermissions("sys:sysVersion:delete")
	@RequestMapping("/delete")
	public String deleteAgent(HttpServletRequest req, Model model, long verId, DwzAjax dwz) {
		try {

			SysVersion sysVersion = sysVersionService.getSysVersion(verId);
			if (sysVersion == null) {
				return operateError("无法获取要删除的版本信息", model);
			}
			
			sysVersionService.deleteSysVersion(verId);
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			log.error("== deleteSysVersion exception:", e);
			return operateError("删除失败", model);
		}
	}
}
