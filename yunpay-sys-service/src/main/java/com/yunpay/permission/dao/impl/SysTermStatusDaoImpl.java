package com.yunpay.permission.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.SysTermStatusDao;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TermStatusEntity;


@Repository("SysTermStatusDao")
public class SysTermStatusDaoImpl extends PermissionBaseDaoImpl<TermStatusEntity> implements SysTermStatusDao {
    
    public List<ComboxValue> findRegion(){
        return super.getSqlSession().selectList(getStatement("findRegion"));
    }
    
    public List<TermStatusEntity> termStatusListExcel(){
      return super.getSqlSession().selectList(getStatement("termStatusListExcel"));
  }
    
}

