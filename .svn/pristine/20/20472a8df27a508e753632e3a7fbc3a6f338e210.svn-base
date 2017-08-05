package com.yunpay.permission.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.SysMccStoreDao;
import com.yunpay.permission.entity.MccStoreEntity;


@Repository("SysMccStoreDao")
public class SysMccStoreDaoImpl extends PermissionBaseDaoImpl<MccStoreEntity> implements SysMccStoreDao {
    
    public List<MccStoreEntity> mccStoreListExcel(){
        return super.getSqlSession().selectList(getStatement("mccStoreListExcel"));
    }
}

