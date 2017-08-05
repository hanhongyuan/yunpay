package com.yunpay.permission.dao;

import java.util.List;

import com.yunpay.permission.entity.DictcodeEntity;

public interface SysDictCodeDao extends PermissionBaseDao<DictcodeEntity> {
    
    public List<DictcodeEntity> Findall();
    
	/**
	 * 根据id查询DictCodeEntity
	 * @param SId
	 * @return
	 */
	
	public DictcodeEntity selectByPrimaryKey(int SId);

    /**
     * 插入一条数据
     * @param DictCodeEntity
     * @return
     */
    
    public int insertdict(DictcodeEntity dictcode);
	/**
     * 根据id删除数据
     * @param SId
     * @return
     */
    
    public int deleteBySId(int SId);
	
    /**
     * 根据条件修改DictcodeEntity
     * @param dictcode
     * @return
     */
    public int updByDemoId(DictcodeEntity dictcode);

}
