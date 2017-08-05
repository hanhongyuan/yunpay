package com.yunpay.permission.service;



import java.util.List;

import com.yunpay.permission.entity.Attachment;
import com.yunpay.permission.entity.BusiContext;
import com.yunpay.permission.entity.MerchBusiApplyInfo;
import com.yunpay.permission.entity.MerchantInfo;

public interface MerchInfoService {
	
	/**
	 * 根据id查询商户信息
	 * @param sssId
	 * @return
	 */
	MerchantInfo queryMerchInfo(String merchId);

	/**
	 * 修改商户信息
	 * @param feedBack
	 * @return
	 */
	boolean updMerchInfo(String updCode,MerchantInfo merchantInfo);
	
	/**
	 * 查询商户业务开通情况
	 * @param merchId
	 * @return
	 */
	List<BusiContext> queryMerchBusiInfo(String merchId);
	
	/**
	 * 微信打款验证
	 * @param merchApplyInfo
	 * @return
	 */
	int updApplyMsg(MerchBusiApplyInfo merchApplyInfo);
	
	/**
	 * 查询商户业务申请信息
	 * @param merchApplyInfo
	 * @return
	 */
	boolean busiApplyIsExist(MerchBusiApplyInfo merchApplyInfo);
	
	/**
	 * 修改商户申请信息
	 * @param merchApplyInfo
	 * @return
	 */
	int updBusiApplyInfo(MerchBusiApplyInfo merchApplyInfo);
	
	/**
	 * 添加申请信息
	 * @param merchApplyInfo
	 * @return
	 */
	int insertBusiApplyInfo(MerchBusiApplyInfo merchApplyInfo);
	
	/**
	 * 保存附件信息
	 * @param attachment
	 * @return
	 */
	boolean insertOrUpd(Attachment attachment);
	
	/**
	 * 通过id查询附件信息
	 * @param merchId
	 * @return
	 */
	List<Attachment> queryAttachment(String merchId);
	
	/**
	 * 修改附件信息
	 * @param attachment
	 * @return
	 */
	int updAttachment(Attachment attachment);
}