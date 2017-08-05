package com.yunpay.permission.entity;

import java.util.ArrayList;
import java.util.List;

public class SysMenuTree extends PermissionBaseEntity{
	private static final long serialVersionUID = 1L;

	/** 菜单名称 **/
	private String name;

	/** 菜单地址 **/
	private String url;

	/** 菜单编号（用于显示时排序） **/
	private String number;

	/** 是否为叶子节点 **/
	private String isLeaf;

	/** 菜单层级 **/
	private Long level;

	/** 父节点:一级菜单为0 **/
	private SysMenu parent;

	/** 目标名称（用于DWZUI的NAVTABID） **/
	private String targetName;
	private Long childNum;
	
	public SysMenuTree() {
		super();
	}
	
	public SysMenuTree(SysMenu sysMenu) {
		this.isLeaf = sysMenu.getIsLeaf();
		this.level = sysMenu.getLevel();
		this.name = sysMenu.getName();
		this.number = sysMenu.getNumber();
		this.parent = sysMenu.getParent();
		this.targetName = sysMenu.getTargetName();
		this.url = sysMenu.getUrl();
	}
	@SuppressWarnings("rawtypes")
	private List childMenu = new ArrayList(0);
	
	@SuppressWarnings("rawtypes")
	public List getChildMenu() {
		return childMenu;
	}

	@SuppressWarnings("rawtypes")
	public void setChildMenu(List childMenu) {
		this.childMenu = childMenu;
	}

	public Long getChildNum() {
		return childNum;
	}

	public void setChildNum(Long childNum) {
		this.childNum = childNum;
	}

	/** 菜单名称 **/
	public String getName() {
		return name;
	}

	/** 菜单名称 **/
	public void setName(String name) {
		this.name = name;
	}

	/** 菜单地址 **/
	public String getUrl() {
		return url;
	}

	/** 菜单地址 **/
	public void setUrl(String url) {
		this.url = url;
	}

	/** 菜单编号（用于显示时排序） **/
	public String getNumber() {
		return number;
	}

	/** 菜单编号（用于显示时排序） **/
	public void setNumber(String number) {
		this.number = number;
	}

	/** 是否为叶子节点 **/
	public String getIsLeaf() {
		return isLeaf;
	}

	/** 是否为叶子节点 **/
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	/** 菜单层级 **/
	public Long getLevel() {
		return level;
	}

	/** 菜单层级 **/
	public void setLevel(Long level) {
		this.level = level;
	}

	/** 父节点:一级菜单为0 **/
	public SysMenu getParent() {
		return parent;
	}

	/** 父节点:一级菜单为0 **/
	public void setParent(SysMenu parent) {
		this.parent = parent;
	}

	/** 目标名称（用于DWZUI的NAVTABID） **/
	public String getTargetName() {
		return targetName;
	}

	/** 目标名称（用于DWZUI的NAVTABID） **/
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
}
