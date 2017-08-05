package com.yunpay.permission.dao;


import java.util.List;

import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.MerchTran;
import com.yunpay.permission.entity.OffTranInfo;
import com.yunpay.permission.entity.OnTranInfo;
import com.yunpay.permission.entity.TotalCount;
import com.yunpay.permission.entity.TranInfo;


@SuppressWarnings("rawtypes")
public interface TranInfoDao extends PermissionBaseDao{
	
	/**
	 * 脱机查看
	 * @param tranInfo
	 * @return
	 */
	List<OffTranInfo> offTraninfoView(TranInfo tranInfo);
	
	List<MerchTran> tranInfoExcel();
	
	/**
	 * 联机查看
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
