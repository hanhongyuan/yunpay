package com.yunpay.permission.service;

import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.HsDemo;

public interface HsDemoService {
	
	/**
	 * 根据id查询demo列表
	 * @param demoId
	 * @return
	 */
	public HsDemo selectByPrimaryKey(int demoId);
	
	/**
	 * 根据条件查询demo
	 * @param hsDemo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryByDemo(HsDemo hsDemo);
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param hsDemo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, HsDemo hsDemo);
	
	/**
	 * 根据条件修改demo
	 * @param HsDemo
	 * @return
	 */
	public int updByDemoId(HsDemo HsDemo);
	
	/**
	 * 插入一条数据
	 * @param HsDemo
	 * @return
	 */
	public int insert(HsDemo hsDemo);
	
	/**
	 * 根据id删除数据
	 * @param demoId
	 * @return
	 */
	public int deletByDemoId(int demoId);

	public void saveData(HsDemo hsDemo);

	public HsDemo getByDemoName(String demoName);

	
}
