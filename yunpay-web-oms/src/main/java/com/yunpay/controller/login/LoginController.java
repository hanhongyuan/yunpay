package com.yunpay.controller.login;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.yunpay.common.core.dwz.DWZ;
import com.yunpay.common.core.dwz.DwzAjax;
import com.yunpay.common.core.utils.StringUtil;
import com.yunpay.controller.common.BaseController;
import com.yunpay.permission.entity.SysUser;
import com.yunpay.permission.exception.PermissionException;
import com.yunpay.permission.service.SysMenuService;
import com.yunpay.permission.service.SysUserRoleService;

/**
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Controller
public class LoginController extends BaseController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 函数功能说明 ： 进入后台登陆页面.
	 * 
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest req, Model model) {
		String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");
		String error = null;
		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			error = "用户名/密码错误";
		} else if (PermissionException.class.getName().equals(exceptionClassName)) {
			error = "网络异常,请联系管理员";
		} else if (exceptionClassName != null) {
			error = "错误提示：" + exceptionClassName;
		}
		model.addAttribute("message", error);
		return "login/login";
	}

	/**
	 * 函数功能说明 ： 登陆后台管理系统. 修改者名字： 修改日期： 修改内容：
	 * 
	 * @参数： @param request
	 * @参数： @param model
	 * @参数： @return
	 * @return String
	 * @throws PermissionException
	 */
	@RequestMapping("/")
	public String index(HttpServletRequest req, Model model) {
		SysUser sysUser = (SysUser) this.getSession().getAttribute("SysUser");
		try {		    
            String xttree = this.buildUserPermissionMenu(sysUser, req.getContextPath(),"10"); 
            //业务管理
		    String ocstree = this.buildUserPermissionMenu(sysUser, req.getContextPath(),"11"); 
		    
		    model.addAttribute("xttree", xttree);	
		    model.addAttribute("ocstree", ocstree);
		} catch (PermissionException e) {
			LOG.error("登录异常:" + e.getMessage());
			model.addAttribute("message", e.getMessage());
			return "login/login";
		}
		return "login/index";

	}
	
	/**
     * 函数功能说明 ： 根据顶部菜单生成树形菜单
     * 
     * @参数： @param request
     * @参数： @param model
     * @参数： @param treeid
     * @参数： @return
     * @return String
     * @throws PermissionException
     */
    @RequestMapping("/tree/createtree")
    public String createtree(HttpServletRequest req, Model model,String treeid,DwzAjax dwz) {
        SysUser sysUser = (SysUser) this.getSession().getAttribute("SysUser");
        try {
            String tree = this.buildUserPermissionMenu(sysUser, req.getContextPath(),treeid);
            model.addAttribute("tree", tree);
            
            dwz.setStatusCode(DWZ.SUCCESS);
            dwz.setMessage("操作成功");
            model.addAttribute("dwz", dwz);
            return "notice/ajaxDone";
        } catch (PermissionException e) {
            LOG.error("操作异常:" + e.getMessage());
            model.addAttribute("message", e.getMessage());
        }
        
        dwz.setStatusCode(DWZ.ERROR);
        dwz.setMessage("操作失败");
        model.addAttribute("dwz", dwz);
        return "notice/ajaxDone";
    }

	/**
	 * 函数功能说明 ：进入退出系统确认页面. 修改者名字： 修改日期： 修改内容：
	 * 
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/admin/confirm", method = RequestMethod.GET)
	public String confirm() {
		return "modules/login/confirm";
	}

	/**
	 * 函数功能说明 ： 退出系统. 修改者名字： 修改日期： 修改内容：
	 * 
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	@RequestMapping(value = "/admin/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request, Model model) {
		// 不是以form的形式提交的数据,要new一个DwzAjax对象
		DwzAjax dwz = new DwzAjax();
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("employee");
			//SecurityUtils.getSubject().logout();
			LOG.info("***clean session success!***");
		} catch (Exception e) {
			LOG.error(e);
			dwz.setStatusCode(DWZ.ERROR);
			dwz.setMessage("退出系统时系统出现异常，请通知系统管理员！");
			model.addAttribute("dwz", dwz);
			return "admin.common.ajaxDone";
		}
		return "admin.login";
	}

	/**
	 * 获取用户的菜单权限
	 * 
	 * @param sysUser
	 * @return
	 * @throws PermissionException
	 * @throws Exception
	 */
	private String buildUserPermissionMenu(SysUser sysUser, String path,String treeid) throws PermissionException {
		// 根据用户ID得到该用户的所有角色拼成的字符串
		String roleIds = sysUserRoleService.getRoleIdsByUserId(Long.valueOf(sysUser.getId()));
		if (StringUtils.isBlank(roleIds)) {
			LOG.error("==>用户[" + sysUser.getLoginName() + "]没有配置对应的权限角色");
			throw new RuntimeException("该帐号已被取消所有系统权限");
		}
		// 根据操作员拥有的角色ID,构建管理后台的树形权限功能菜单
		return this.buildPermissionTree(roleIds, path,treeid);
	}
	/**
	 * 根据操作员拥有的角色ID,构建管理后台的树形权限功能菜单
	 * 
	 * @param roleIds
	 * @return
	 * @throws PermissionException
	 */
	@SuppressWarnings("rawtypes")
	public String buildPermissionTree(String roleIds, String path ,String treeid) throws PermissionException {
		List treeData = null;
		try {			
		    treeData = sysMenuService.listByRoleIds(roleIds);
		    
			if (StringUtil.isEmpty(treeData)) {
				LOG.error("用户没有分配菜单权限");
				throw new PermissionException(PermissionException.PERMISSION_USER_NOT_MENU, "该用户没有分配菜单权限"); // 该用户没有分配菜单权限
			}
		} catch (Exception e) {
			LOG.error("根据角色查询菜单出现错误", e);
			throw new PermissionException(PermissionException.PERMISSION_QUERY_MENU_BY_ROLE_ERROR, "根据角色查询菜单出现错误"); // 查询当前角色的
		}
		StringBuffer strJson = new StringBuffer();
		buildManagerPermTree(treeid, strJson, treeData, path);
		return strJson.toString();
	}	
	/**
	 * 
	 * @Title: buildManagerPermTree 
	 * @Description: TODO(构建管理后台的树形权限功能菜单)
	 */
	@SuppressWarnings("rawtypes")
	private void buildManagerPermTree(String pId, StringBuffer treeBuf, List menuList, String path) {
		List<Map> listMap = getSonMenuListByPid(pId.toString(), menuList);
		for (Map map : listMap) {
			String id = map.get("id").toString();// id
			String name = map.get("name").toString();// 名称
			String isLeaf = map.get("isLeaf").toString();// 是否叶子
			String level = map.get("level").toString();// 菜单层级（1、2、3、4）
			String url = map.get("url").toString(); // ACTION访问地址
			 
			if ("2".equals(level)) {
				treeBuf.append("<ul class='menu-items' data-tit='"+name+"' data-faicon='list'>");
			}
			
			if ("YES".equals(isLeaf) && !("##".equals(url))) { 
				treeBuf.append("<li><a href=\""+ path +"/"+ url + "\" data-options=\"{id:'menu_"+id+"', faicon:'th-large'}\">"+name+"</a></li>");
			}  
			buildManagerPermTree(id, treeBuf, menuList, path);
			if ("2".equals(level)) {
				treeBuf.append("</ul>");
			}
		}		
	}
	
	/**
	 * 构建管理后台的树形权限功能菜单
	 * 
	 * @param pId
	 * @param treeBuf
	 * @param menuList
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	private void buildAdminPermissionTree(String pId, StringBuffer treeBuf, List menuList) {

		List<Map> listMap = getSonMenuListByPid(pId.toString(), menuList);
		for (Map map : listMap) {
			String id = map.get("id").toString();// id
			String name = map.get("name").toString();// 名称
			String isLeaf = map.get("isLeaf").toString();// 是否叶子
			String level = map.get("level").toString();// 菜单层级（1、2、3、4）
			String url = map.get("url").toString(); // ACTION访问地址
			String navTabId = "";
			if (!StringUtil.isEmpty(map.get("targetName"))) {
				navTabId = map.get("targetName").toString(); // 用于刷新查询页面
			}
         
			if ("1".equals(level)) {
				treeBuf.append("<div class='accordionHeader'>");
				treeBuf.append("<h2> <span>Folder</span> " + name + "</h2>");
				treeBuf.append("</div>");
				treeBuf.append("<div class='accordionContent'>");
			}

			if ("YES".equals(isLeaf)) {
				treeBuf.append("<li><a href='" + url + "' target='navTab' rel='" + navTabId + "'>" + name + "</a></li>");
			} else {

				if ("1".equals(level)) {
					treeBuf.append("<ul class='tree treeFolder'>");
				} else {
					treeBuf.append("<li><a>" + name + "</a>");
					treeBuf.append("<ul>");
				}

				buildAdminPermissionTree(id, treeBuf, menuList);

				if ("1".equals(level)) {
					treeBuf.append("</ul>");
				} else {
					treeBuf.append("</ul></li>");
				}

			}

			if ("1".equals(level)) {
				treeBuf.append("</div>");
			}
		}

	}

	/**
	 * 根据(pId)获取(menuList)中的所有子菜单集合.
	 * 
	 * @param pId
	 *            父菜单ID.
	 * @param menuList
	 *            菜单集合.
	 * @return sonMenuList.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<Map> getSonMenuListByPid(String pId, List menuList) {
		List sonMenuList = new ArrayList<Object>();
		for (Object menu : menuList) {
			Map map = (Map) menu;
			if (map != null) {
				String parentId = map.get("pId").toString();// 父id
				if (parentId.equals(pId)) {
					sonMenuList.add(map);
				}
			}
		}
		return sonMenuList;
	}

}
