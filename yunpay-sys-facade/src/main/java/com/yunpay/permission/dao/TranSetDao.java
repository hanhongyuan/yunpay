package com.yunpay.permission.dao;

import java.util.List;

import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TotalCount;
import com.yunpay.permission.entity.TranSetDetail;


@SuppressWarnings("rawtypes")
public interface TranSetDao extends PermissionBaseDao{
	
	
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
