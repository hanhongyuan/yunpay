package com.yunpay.controller.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;

import com.yunpay.common.core.dwz.DWZ;
import com.yunpay.common.core.dwz.DwzAjax;
import com.yunpay.permission.entity.SysUser;


/**
 * controller基类
 * 深圳市前海汇商惠电子商务有限公司
 * 
 */ 
public abstract class BaseController {

	/**
	 * 获取shiro 的session
	 * 
	 * @return
	 */
	protected Session getSession() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		return session;
	}

	/**
	 * 获取当前用户信息
	 * 
	 * @return
	 */
	protected SysUser getSysUser() {
		SysUser user = (SysUser) this.getSession().getAttribute("SysUser");
		return user;
	}

	/**
	 * 响应DWZ的ajax失败请求,跳转到ajaxDone视图.
	 * 
	 * @param message
	 *            提示消息.
	 * @param model
	 *            model.
	 * @return ajaxDone .
	 */
	protected String operateError(String message, Model model) {
		DwzAjax dwz = new DwzAjax();
		dwz.setStatusCode(DWZ.ERROR);
		dwz.setMessage(message);
		model.addAttribute("dwz", dwz);
		return "notice/ajaxDone";
	}

	/**
	 * 响应DWZ的ajax失败成功,跳转到ajaxDone视图.
	 * 
	 * @param model
	 *            model.
	 * @param dwz
	 *            页面传过来的dwz参数
	 * @return ajaxDone .
	 */
	protected String operateSuccess(Model model, DwzAjax dwz) {
		dwz.setStatusCode(DWZ.SUCCESS);
		dwz.setMessage("操作成功");
		model.addAttribute("dwz", dwz);
		return "notice/ajaxDone";
	}
	
	/**
	 * 保存参数到Request作用域中
	 * @param req
	 * @param param
	 */
	protected void setRequestAttr(HttpServletRequest req,Map<String,Object> paramMap){
		for(Map.Entry<String, Object> entry : paramMap.entrySet()){
			req.setAttribute(entry.getKey(),entry.getValue());
		}
	}
	

}
