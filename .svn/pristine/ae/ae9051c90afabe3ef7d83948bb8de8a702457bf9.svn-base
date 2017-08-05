package com.yunpay.serv.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.yunpay.serv.model.UnionConfig;

@Repository("unionConfigDao")
public interface UnionConfigDao {
	@Select("select * from t_union_config where currMerchNo=#{merchantNo}")
    public UnionConfig findConfigByMerNo(String merchantNo);
}
