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

import com.yunpay.common.core.dwz.DwzAjax;
import com.yunpay.common.core.enums.PublicEnum;
import com.yunpay.common.core.enums.PublicStatusEnum;
import com.yunpay.controller.common.BaseController;
import com.yunpay.permission.biz.SysMenuBiz;
import com.yunpay.permission.entity.SysMenu;
import com.yunpay.permission.service.SysMenuService;

/**
 * 权限-菜单控制器
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
@Controller
@RequestMapping("/sys/menu")
public class SysMenuCtrl extends BaseController {
	private static final Log log = LogFactory.getLog(SysMenuCtrl.class);
	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private SysMenuBiz sysMenuBiz;

	/**
	 * 列出要管理的菜单.
	 * 
	 * @return SysMenuList .
	 */
	@RequiresPermissions("sys:menu:view")
	@RequestMapping("/list")
	public String listSysMenu(HttpServletRequest req, Model model) {
		String editMenuController = "sys/menu/editUI";
		String str = sysMenuBiz.getTreeMenu(editMenuController);
		model.addAttribute("tree", str);
		return "modules/sys/sysMenuList";
	}

	/**
	 * 查看菜单详情
	 * @param req
	 * @param model
	 * @param id
	 * @return
	 */
	@RequiresPermissions("sys:menu:view")
	@RequestMapping("/view")
	public String listMenu(HttpServletRequest req, Model model,Long id) {
		
		SysMenu sysMenu = sysMenuService.getById(id);
		model.addAttribute("sysMenu", sysMenu);
		return "modules/sys/sysMenuView";
	}
	
	/**
	 * 进入新菜单添加页面.
	 * 
	 * @return SysMenuAdd .
	 */
	@RequiresPermissions("sys:menu:add")
	@RequestMapping("/addUI")
	public String addSysMenuUI(HttpServletRequest req, SysMenu sysMenu, Model model, Long id) {
		if (null != id) {
			SysMenu parentMenu = sysMenuService.getById(id);
			
			parentMenu.setId(Integer.parseInt(id.toString()));
			sysMenu.setParent(parentMenu);
			model.addAttribute(sysMenu);
		}
		return "modules/sys/sysMenuAdd";
	}

	/**
	 * 保存新增菜单.
	 * 
	 * @return operateSuccess or operateError .
	 */
	@RequiresPermissions("sys:menu:add")
	@RequestMapping("/add")
	public String addSysMenu(HttpServletRequest req, SysMenu sysMenu, Model model, DwzAjax dwz) {
		try {
			String name = sysMenu.getName();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("isLeaf", "YES");
			map.put("name", name);
			List<SysMenu> list = sysMenuService.getMenuByNameAndIsLeaf(map);
			if (list.size() > 0) {
				return operateError("同级菜单名称不能重复", model);
			}
			sysMenu.setCreater(getSysUser().getLoginName());
			sysMenu.setStatus(PublicStatusEnum.ACTIVE.name());
			sysMenu.setIsLeaf("YES");
			if (null != Long.valueOf(sysMenu.getParent().getId())) {
				sysMenu.setLevel(sysMenu.getParent().getLevel()+1);
			}else{
				sysMenu.setLevel(1L);
				SysMenu parent = new SysMenu();
				parent.setId(sysMenu.getId());
				sysMenu.setParent(parent);
			}
			sysMenuService.savaMenu(sysMenu);
		} catch (Exception e) {
			// 记录系统操作日志
			log.error("== addSysMenu exception:", e);
			return operateError("添加菜单出错", model);
		}
		return operateSuccess(model, dwz);
	}

	/**
	 * 进入菜单修改页面.
	 * 
	 * @return
	 */
	@RequiresPermissions("sys:menu:edit")
	@RequestMapping("/editUI")
	public String editSysMenuUI(HttpServletRequest req, Long id, Model model) {
		if (null != id) {
			SysMenu sysMenu = sysMenuService.getById(id);
			model.addAttribute(sysMenu);
		}
		return "modules/sys/sysMenuEdit";
	}

	/**
	 * 保存要修改的菜单.
	 * 
	 * @return
	 */
	@RequiresPermissions("sys:menu:edit")
	@RequestMapping("/edit")
	public String editSysMenu(HttpServletRequest req, SysMenu menu, Model model, DwzAjax dwz) {
		try {
			SysMenu parentMenu = menu.getParent();
			if (null == parentMenu) {
				parentMenu = new SysMenu();
				parentMenu.setId(menu.getId());
			}
			menu.setParent(parentMenu);
			sysMenuService.update(menu);
			// 记录系统操作日志
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			// 记录系统操作日志
			log.error("== editSysMenu exception:", e);
			return operateError("保存菜单出错", model);
		}
	}

	/**
	 * 删除菜单.
	 * 
	 * @return
	 */
	@RequiresPermissions("sys:menu:delete")
	@RequestMapping("/delete")
	public String delSysMenu(HttpServletRequest req, Long menuId, Model model, DwzAjax dwz) {
		try {
			if (menuId == null || menuId == 0) {
				return operateError("无法获取要删除的数据", model);
			}
			SysMenu menu = sysMenuService.getById(menuId);
			if (menu == null) {
				return operateError("无法获取要删除的数据", model);
			}
			Long parentId = Long.valueOf(menu.getParent().getId()); // 获取父菜单ID

			// 先判断此菜单下是否有子菜单
			List<SysMenu> childMenuList = sysMenuService.listByParentId(menuId);
			if (childMenuList != null && !childMenuList.isEmpty()) {
				return operateError("此菜单下关联有【" + childMenuList.size() + "】个子菜单，不能支接删除!", model);
			}

			// 删除掉菜单
			sysMenuService.delete(menuId);

			// 删除菜单后，要判断其父菜单是否还有子菜单，如果没有子菜单了就要装其父菜单设为叶子节点
			List<SysMenu> childList = sysMenuService.listByParentId(parentId);
			if (childList == null || childList.isEmpty()) {
				// 此时要将父菜单设为叶子
				SysMenu parent = sysMenuService.getById(parentId);
				parent.setIsLeaf(PublicEnum.YES.name());
				sysMenuService.update(parent);
			}
			// 记录系统操作日志
			return operateSuccess(model, dwz);
		} catch (Exception e) {
			// 记录系统操作日志
			log.error("== delSysMenu exception:", e);
			return operateError("删除菜单出错", model);
		}
	}

}
