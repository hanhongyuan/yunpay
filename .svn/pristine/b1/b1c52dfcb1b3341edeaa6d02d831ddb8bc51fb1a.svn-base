package com.yunpay.permission.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.SysStoreTranDao;
import com.yunpay.permission.entity.StoreTranEntity;


@Repository("SysStoreTranDao")
public class SysStoreTranDaoImpl extends PermissionBaseDaoImpl<StoreTranEntity> implements SysStoreTranDao {
    
    public List<StoreTranEntity> merchTranExcel(){
        return super.getSqlSession().selectList(getStatement("merchTranExcel"));
    }
}

