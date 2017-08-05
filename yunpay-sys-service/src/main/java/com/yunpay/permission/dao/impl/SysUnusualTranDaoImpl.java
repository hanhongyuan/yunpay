package com.yunpay.permission.dao.impl;


import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.SysUnusualTranDao;
import com.yunpay.permission.entity.UnusualTranEntity;


@Repository("SysUnusualTranDao")
public class SysUnusualTranDaoImpl extends PermissionBaseDaoImpl<UnusualTranEntity> implements SysUnusualTranDao {
    
    public int unUsualTranAdd(Map<String, Object> paramMap){
        return super.getSqlSession().insert(getStatement("unUsualTranAdd"),paramMap);
    }

    public int editbatchsend(Map<String, Object> paramMap) {
        return super.getSqlSession().update(getStatement("editbatchsend"),paramMap);
    }
    
}

