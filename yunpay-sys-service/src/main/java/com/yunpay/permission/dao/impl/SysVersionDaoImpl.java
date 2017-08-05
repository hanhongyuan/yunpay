package com.yunpay.permission.dao.impl;


import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.SysVersionDao;
import com.yunpay.permission.entity.SysVersion;

@SuppressWarnings("rawtypes")
@Repository("SysVersionDao")
public class SysVersionDaoImpl extends PermissionBaseDaoImpl implements SysVersionDao{
    
    @Override
    public SysVersion getSysVersion(long verId) {
        return super.getSqlSession().selectOne(getStatement("getSysVersion"), verId);
    }

    @Override
    public int updateSysVersion(SysVersion sysVersion) {
        return super.getSqlSession().update(getStatement("updateSysVersion"), sysVersion);
    }

    @Override
    public int deleteSysVersion(long verId) {
        return super.getSqlSession().delete(getStatement("deleteSysVersion"), verId);
    }
    
    @Override
    public int insertSysVersion(SysVersion sysVersion){
        return super.getSqlSession().insert(getStatement("insertSysVersion"), sysVersion);
    }
}
