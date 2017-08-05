package com.yunpay.serv.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.yunpay.serv.model.AlipayConfigKey;

@Repository("alipayConfigDao")
public interface AlipayConfigDao {
	@Select("select * from t_alipay_config where merchantNo=#{merchantNo}")
    public AlipayConfigKey findConfigByMerNo(String merchantNo);
}
