package com.yunpay.permission.service;



import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.SignMerch;
import com.yunpay.permission.entity.TotalCount;

public interface SignMerchService {
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param merchCredit
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, SignMerch signMerch);
	
	/**
	 * 导出商户日报表
	 * @param feedBack
	 * @return
	 */
	List<SignMerch> SignMerchExport(SignMerch signMerch);
	
	/**
	 * 合计
	 * @param signMerch
	 * @return
	 */
	TotalCount totalSignMerch(SignMerch signMerch);
}