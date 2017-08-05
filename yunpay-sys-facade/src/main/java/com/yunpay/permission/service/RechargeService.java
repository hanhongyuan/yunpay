package com.yunpay.permission.service;




import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.Merchant;
import com.yunpay.permission.entity.Recharge;
import com.yunpay.permission.entity.TotalCount;

public interface RechargeService {
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param recharge
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, Recharge recharge);
	
	/**
	 * 分页查询商户信息
	 * @param pageParam
	 * @param merchCredit
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPageMerch(PageParam pageParam, Merchant merchant);
	
	/**
	 * 通过id查询充值表
	 * @param recharge
	 * @return
	 */
	Recharge getMerchRechargeById(String lsId);
	
	/**
	 * 修改审核状态
	 * @param recharge
	 * @return
	 */
	boolean updateStatus(Recharge recharge);

	/**
	 * 审核成功后更新商户额度
	 * @param recharge
	 * @return
	 */
	int updateMerchCredit(Recharge recharge);
	
	/**
	 * 判断用户是否存在额度表记录 
	 * @param merchId
	 * @return
	 */
	boolean getMerchReditAmtById(String merchId,Recharge recharge);
	
	/**
	 * 向额度表中添加数据
	 * @param merchId
	 * @return
	 */
	int insertMerchReditAmt(String merchId);
	
	/**
	 * 充值额度
	 * @param merchId
	 * @return
	 */
	int insertMerchRecharge(Recharge recharge);
	
	/**
	 * 通过Id删除充值申请待审核信息
	 * @param lsId
	 * @return
	 */
	int deleteMerchRecharge(String lsId);
	
	/**
	 * 充值合计
	 * @param recharge
	 * @return
	 */
	TotalCount totalRechargeLs(Recharge recharge);
}