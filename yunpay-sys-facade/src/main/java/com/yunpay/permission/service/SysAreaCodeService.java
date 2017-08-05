package com.yunpay.permission.service;

import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.TsysArea;
import com.yunpay.permission.entity.TsysAreaTree;

public interface SysAreaCodeService {
	
	/**
	 * 得到所有的区域信息
	 * @return
	 */
	public List<TsysAreaTree> getAllSysAreaList(TsysArea area);
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param branch
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public PageBean listPage(PageParam pageParam, TsysArea area);
	
	/**
	 * 根据条件查询区域信息
	 * @param area
	 * @return
	 */
	public List<TsysArea> getSysAreaList(TsysArea area);
	
	public List<TsysArea> getAreaList(TsysArea area);
	
	public TsysArea getAreaByareaName(String areaName);
	
	public TsysArea getAreaByareaCode(String areaCode);
	
	public List<TsysArea> getAreaByParentId(String ParentId);
	
	public int updateTsysArea(TsysArea area);
	
	public int deleteTsysArea(String areaCode);
	
	public int insertArea(TsysArea area);
}
