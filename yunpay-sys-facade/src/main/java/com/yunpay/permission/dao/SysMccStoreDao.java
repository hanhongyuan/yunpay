package com.yunpay.permission.dao;

import java.util.List;

import com.yunpay.permission.entity.MccStoreEntity;

public interface SysMccStoreDao extends PermissionBaseDao<MccStoreEntity> {
    
    public List<MccStoreEntity> mccStoreListExcel();

}
