package com.yunpay.permission.dao;

import java.util.List;
import java.util.Map;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.MerchCredit;
import com.yunpay.permission.entity.Recharge;
import com.yunpay.permission.entity.TotalCount;


@SuppressWarnings("rawtypes")
public interface RechargeDao extends PermissionBaseDao{
	
	/**
	 * 通过id查询充值表
	 * @param recharge
	 * @return
	 */
	Recharge getMerchRechargeById(String lsId);
	
    public PageBean listPageMerch(PageParam pageParam, Map<String, Object> paramMap);
	
	/**
	 * 修改审核状态
	 * @param recharge
	 * @return
	 */
	int updateStatus(Recharge recharge);
	
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
	List<MerchCredit> getMerchReditAmtById(String merchId);
	
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
