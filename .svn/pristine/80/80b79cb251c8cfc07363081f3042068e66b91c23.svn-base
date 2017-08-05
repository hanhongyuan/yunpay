package com.yunpay.permission.service;



import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.MerchSettle;
import com.yunpay.permission.entity.StoreBillDetail;
import com.yunpay.permission.entity.TotalCount;

public interface MerchSettleService {
	
	/**
	 * 分页查询商户结算管理
	 * @param pageParam
	 * @param merchSettle
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, MerchSettle merchSettle);
	
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam,String type,String pag, MerchSettle merchSettle);
	
	/**
	 * 查看商户结算明细
	 * @param billId
	 * @return
	 */
	MerchSettle viewMerchBill(String billId); 
	
	/**
	 * 查看商户结算明细(微信)
	 * @param billId
	 * @return
	 */
	MerchSettle viewMerchBillW(String billId);
	
	/**
	 * 查看商户结算明细（翼支付）
	 * @param billId
	 * @return
	 */
	MerchSettle viewMerchBillY(String billId);
	
	/**
	 * 查看商户结算明细（支付宝）
	 * @param billId
	 * @return
	 */
	MerchSettle viewMerchBillA(String billId);
	
	/**
	 * 合计（深圳通）
	 * @param merchSettle
	 * @return
	 */
	TotalCount totalSettleSZT(MerchSettle merchSettle);
	
	/**
	 * 合计（翼支付）
	 * @param merchSettle
	 * @return
	 */
	TotalCount totalSettleY(MerchSettle merchSettle);
	
	/**
	 * 合计（微信）
	 * @param merchSettle
	 * @return
	 */
	TotalCount totalSettleW(MerchSettle merchSettle);
	
	/**
	 * 合计（支付宝）
	 * @param merchSettle
	 * @return
	 */
	TotalCount totalSettleA(MerchSettle merchSettle);
	
	/**
	 * 按门店查询
	 * @param billId
	 * @return
	 */
	List<StoreBillDetail> queryMerchBillByStore(String billId);
	
	/**
	 * 按门店查询（微信）
	 * @param billId
	 * @return
	 */
	List<StoreBillDetail> queryMerchBillByStoreW(String billId);
	
	/**
	 * 按门店查询（翼支付）
	 * @param billId
	 * @return
	 */
	List<StoreBillDetail> queryMerchBillByStoreY(String billId);
	
	/**
	 * 按门店查询（支付宝）
	 * @param billId
	 * @return
	 */
	List<StoreBillDetail> queryMerchBillByStoreA(String billId);
	
	/**
	 * 按商户查询
	 * @param billId
	 * @return
	 */
	List<StoreBillDetail> queryMerchBillByMerch(String billId);
	
	/**
	 * 查询要导出的数据（深圳通）
	 * @param billId
	 * @return
	 */
	MerchSettle getMerchSettle(String billId);
	
	/**
	 * 查询要导出的数据（微信）
	 * @param billId
	 * @return
	 */
	MerchSettle getMerchSettleW(String billId);
	
	/**
	 * 查询要导出的数据（翼支付）
	 * @param billId
	 * @return
	 */
	MerchSettle getMerchSettleY(String billId);
	
	/**
	 * 查询要导出的数据（支付宝）
	 * @param billId
	 * @return
	 */
	MerchSettle getMerchSettleA(String billId);

	/**
	 * 合计（按门店查看深圳通）
	 * @param billId
	 * @return
	 */
	TotalCount totalSettleByStore(String billId);
	
	/**
	 * 合计（按门店查看微信）
	 * @param billId
	 * @return
	 */
	TotalCount totalSettleByStoreW(String billId);
	
	/**
	 * 合计（按门店查看翼支付）
	 * @param billId
	 * @return
	 */
	TotalCount totalSettleByStoreY(String billId);
	
	/**
	 * 合计（按门店查看支付宝）
	 * @param billId
	 * @return
	 */
	TotalCount totalSettleByStoreA(String billId);
	
	/**
	 * 合计（按商户查看）
	 * @param billId
	 * @return
	 */
	TotalCount totalSettleByMerch(String billId);
	
	/*List<MerchBillDetail> getMerchDetailList(String billId, TotalCount smCount);

	List<StoreBillDetail> getStoreDetailList(String billId, TotalCount sdCount);*/
}