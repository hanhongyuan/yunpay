package com.yunpay.permission.biz;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yunpay.permission.service.SysMenuService;

/**
 * @author System
 * 
 * @since 2013-11-12
 */
@Component("sysMenuBiz")
public class SysMenuBiz {

	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(SysMenuBiz.class);

	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 获取用于编制菜单时的树.
	 */
	@SuppressWarnings("rawtypes")
	public String getTreeMenu(String actionUrl) {
		List treeData = sysMenuService.getListByParent(null);
		StringBuffer strJson = new StringBuffer();
		makeTreeMenu("1", strJson, treeData, actionUrl);
		return strJson.toString();
	}

	/**
	 * 
	 * @Title: makeTreeMenu 
	 * @Description: TODO(递归输出树形菜单) 
	 * @param pId
	 * @param buffer
	 * @param list
	 * @param url
	 */
	@SuppressWarnings("rawtypes")
	private void makeTreeMenu(String pId, StringBuffer buffer, List list, String url) {
		
		List<Map> listMap = getSonMenuListByPid(pId, list);
		for (Map map : listMap) {
			String id = map.get("id").toString();// id
			String parentId = map.get("pId").toString(); //父ID
			String name = map.get("name").toString();// 名称
			String isLeaf = map.get("isLeaf").toString();// 是否叶子科目
			String path = map.get("url").toString();//请求路径
//			if ("0".equals( parentId)) {
//				buffer.append("<li data-id="+id+" data-pid=\"\" data-url=\"sys/menu/view?id="+id+"\" data-divid=\"#layout_menu_list\">"+name+"</li>");
//			}
			if ("YES".equals(isLeaf)) {
				buffer.append("<li data-id="+id+" data-pid="+parentId+" data-url=\"sys/menu/view?id="+id+"\" data-divid=\"#layout_menu_list\">"+name+"</li>");
			}
			else{
				buffer.append("<li data-id="+id+" data-pid=\"\" data-url=\"sys/menu/view?id="+id+"\" data-divid=\"#layout_menu_list\">"+name+"</li>");
			}
			makeTreeMenu(id, buffer, list, path);
		}
	}
	
	/**
	 * 递归输出树形菜单
	 * 
	 * @param pId
	 * @param buffer
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	private void recursionTreeMenu(String pId, StringBuffer buffer, List list, String url) {
		if (pId.equals("0")) {
			buffer.append("<ul id=\"layout-tree\" class=\"ztree\" data-toggle=\"ztree\" data-expand-all=\"true\" data-on-click=\"do_open_layout\" >");
		} else {
			buffer.append("<ul>");
		}
		List<Map> listMap = getSonMenuListByPid(pId, list);
		for (Map map : listMap) {
			String id = map.get("id").toString();// id
			String name = map.get("name").toString();// 名称
			String isLeaf = map.get("isLeaf").toString();// 是否叶子科目
			buffer.append("<li data-id="+id+"><a onclick=\"onClickMenuNode(" + id + ")\"  href=\"" + url + "?id=" + id + "\" target=\"ajax\" rel=\"jbsxBox\"  value=" + id + ">" + name + "</a>");
			if (!isLeaf.equals("1")) {
				recursionTreeMenu(id, buffer, list, url);
			}
			buffer.append("</li>");
		}
		buffer.append("</ul>");
	}
	
	
	/**
	 * 获取用于编制菜单时的树.
	 */
	@SuppressWarnings("rawtypes")
	public String getTreeCheckMenu(String actionUrl) {
		List treeData = sysMenuService.getListByParent(null);
		StringBuffer strJson = new StringBuffer();
		makeTreeCheckMenu("1", strJson, treeData, actionUrl);
		return strJson.toString();
	}

	/**
	 * 
	 * @Title: makeTreeMenu 
	 * @Description: TODO(递归输出树形菜单) 
	 * @param pId
	 * @param buffer
	 * @param list
	 * @param url
	 */
	@SuppressWarnings("rawtypes")
	private void makeTreeCheckMenu(String pId, StringBuffer buffer, List list, String url) {
		
		List<Map> listMap = getSonMenuListByPid(pId, list);
		for (Map map : listMap) {
		
			String id = map.get("id").toString();// id
			String parentId = map.get("pId").toString(); //父ID
			String name = map.get("name").toString();// 名称
			String isLeaf = map.get("isLeaf").toString();// 是否叶子科目
			String path = map.get("url").toString();//请求路径
			
			if ("12".equals( parentId)) {
				buffer.append("<li data-id="+id+" name="+id+" data-url=\"" + url + "?id=" + id + "\" data-pid=\"\"  >"+name+"</li>");
			}
			if ("YES".equals(isLeaf)) {
				buffer.append("<li data-id="+id+" name="+id+" data-url=\"" + url + "?id=" + id + "\" data-pid="+parentId+"  >"+name+"</li>");
			}
			makeTreeCheckMenu(id, buffer, list, path);
		}
	}
	
	/**
	 * 递归输出树形菜单
	 * 
	 * @param pId
	 * @param buffer
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	private void recursionTreeCheckMenu(String pId, StringBuffer buffer, List list, String url) {
		if (pId.equals("0")) {
			buffer.append("<ul id=\"layout-tree\" class=\"ztree\" data-toggle=\"ztree\" data-expand-all=\"true\" data-on-click=\"do_open_layout\" >");
		} else {
			buffer.append("<ul>");
		}
		List<Map> listMap = getSonMenuListByPid(pId, list);
		for (Map map : listMap) {
			String id = map.get("id").toString();// id
			String name = map.get("name").toString();// 名称
			String isLeaf = map.get("isLeaf").toString();// 是否叶子科目
			buffer.append("<li><a onclick=\"onClickMenuNode(" + id + ")\"  href=\"" + url + "?id=" + id + "\" target=\"ajax\" rel=\"jbsxBox\"  value=" + id + ">" + name + "</a>");
			if (!isLeaf.equals("1")) {
				recursionTreeCheckMenu(id, buffer, list, url);
			}
			buffer.append("</li>");
		}
		buffer.append("</ul>");
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