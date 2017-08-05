package com.yunpay.permission.dao;

import java.util.List;

import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TermStatusEntity;

public interface SysTermStatusDao extends PermissionBaseDao<TermStatusEntity> {
    
    public List<ComboxValue> findRegion();
    
    public List<TermStatusEntity> termStatusListExcel();
}
