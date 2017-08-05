package com.yunpay.permission.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.yunpay.permission.entity.Merchant;
/**
 * 
 * @author zengdc
 * @version 1.0.0
 * @date 2016-12-07 09:37
 * @company 深圳市前海汇商惠电子商务有限公司
 * 汇商惠支付平台交易数据监控
 */
public interface HshDataMonitorService {
	
	/**
	 * 根据时间区间查询交易金额（深圳通）
	 * @param beginTime 起始时间
	 * @param endTime 结束时间
	 * @return 交易金额（消费&结算）
	 */
	public List<BigDecimal> queryTranAmtByTime(Map<String,Object> paramMap);
	
}
