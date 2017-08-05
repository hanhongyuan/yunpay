package com.yunpay.permission.dao;

import java.util.List;

import com.yunpay.permission.entity.StoreTranEntity;

public interface SysStoreTranDao extends PermissionBaseDao<StoreTranEntity> {
    
    public List<StoreTranEntity> merchTranExcel();

}
