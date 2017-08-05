package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.SysDictCodeDao;
import com.yunpay.permission.entity.DictcodeEntity;
import com.yunpay.permission.service.SysDictcodeService;

@Service("SysDictcodeService")
public class SysDictcodeServiceImpl implements SysDictcodeService{
	@Autowired 
	SysDictCodeDao dictDao;
	
	@SuppressWarnings("rawtypes")
    @Override
    public PageBean listPage(PageParam pageParam, DictcodeEntity dictEntity) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("typeName", dictEntity.getTypeName()); // 显示名称（模糊查询）
        paramMap.put("typeId", dictEntity.getTypeId());     // 所属分类（模糊查询）
        paramMap.put("typeCode", dictEntity.getTypeCode()); // 引用键值（模糊查询）
        return dictDao.listPage(pageParam, paramMap);
    }
	
     
	public List<DictcodeEntity> Findall() {
        return dictDao.Findall();
	}
	
	@Override
    public int insert(DictcodeEntity dictcode) {
        return dictDao.insertdict(dictcode);
    }
	@Override
	public DictcodeEntity selectByPrimaryKey(int SId) {
		return dictDao.selectByPrimaryKey(SId);
	}
	
	@Override
    public int deleteBySId(int SId) {
        return dictDao.deleteBySId(SId);
    }
	
	@Override
	public int updByDemoId(DictcodeEntity dictcode) {
		return dictDao.updByDemoId(dictcode);
	}

}
