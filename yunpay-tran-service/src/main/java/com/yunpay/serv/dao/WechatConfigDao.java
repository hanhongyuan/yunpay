package com.yunpay.serv.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.yunpay.serv.model.WechatConfigKey;

@Repository("wechatConfigDao")
public interface WechatConfigDao {
	
	@Select("select * from t_wechat_config where merchantNo=#{merchantNo}")
	public WechatConfigKey findConfigByMerNo(String merchantNo);
}
