package com.yunpay.permission.service;

import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.DictcodeEntity;

public interface SysDictcodeService {
	
    
    /**
     * 分页查询
     * @param pageParam
     * @param dictEntity
     * @return
     */
    @SuppressWarnings("rawtypes")
    PageBean listPage(PageParam pageParam, DictcodeEntity dictEntity);
    
    List<DictcodeEntity> Findall();
    
	/**
	 * 根据id查询dictcode列表
	 * @param SId
	 * @return
	 */
	public DictcodeEntity selectByPrimaryKey(int SId);
	
	/**
     * 插入一条数据
     * @param DictcodeEntity
     * @return
     */
    public int insert(DictcodeEntity dictcode);

    /**
     * 根据id删除数据
     * @param SId
     * @return
     */
    public int deleteBySId(int SId);
	
    /**
     * 根据条件修改dictcode
     * @param DictcodeEntity
     * @return
     */
    public int updByDemoId(DictcodeEntity dictcode);

	
}
