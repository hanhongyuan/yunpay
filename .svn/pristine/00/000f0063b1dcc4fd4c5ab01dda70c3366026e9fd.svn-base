package com.yunpay.permission.service;



import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.MerchTran;
import com.yunpay.permission.entity.OffTranInfo;
import com.yunpay.permission.entity.OnTranInfo;
import com.yunpay.permission.entity.TotalCount;
import com.yunpay.permission.entity.TranInfo;

public interface TranInfoService {
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param merchCredit
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, TranInfo tranInfo);
	
	List<MerchTran> tranInfoExcel();
	
	/**
	 * 脱机查看
	 * @param tranInfo
	 * @return
	 */
	List<OffTranInfo> offTraninfoView(TranInfo tranInfo);
	
	/**
	 * 脱机查看
	 * @param tranInfo
	 * @return
	 */
	List<OnTranInfo> onTraninfoView(TranInfo tranInfo);

	/**
	 * 查询交易类型
	 * @return
	 */
	List<ComboxValue> queryTranType();
	
	/**
	 * 合计交易金额
	 * @param tranInfo
	 * @return
	 */
	TotalCount totalTranAmt(TranInfo tranInfo);
}