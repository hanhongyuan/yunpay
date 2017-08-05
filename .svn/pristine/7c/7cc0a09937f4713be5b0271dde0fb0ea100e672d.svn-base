package com.yunpay.permission.service;



import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TotalCount;
import com.yunpay.permission.entity.TranSetDetail;

public interface TranSetService {
	
	/**
	 * 分页查询商户结算明细
	 * @param pageParam
	 * @param merchSettle
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, TranSetDetail tranSetDetail);
	
	/**
	 * 根据标志查询类型
	 * @param settleFlag
	 * @return
	 */
	List<ComboxValue> queryType(String settleFlag);
	
	/**
	 * 合计
	 * @param tranSet
	 * @return
	 */
	TotalCount totalTranSet(TranSetDetail tranSet);
}