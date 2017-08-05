package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.RechargeDao;
import com.yunpay.permission.entity.Merchant;
import com.yunpay.permission.entity.MerchCredit;
import com.yunpay.permission.entity.Recharge;
import com.yunpay.permission.entity.TotalCount;
import com.yunpay.permission.service.RechargeService;

@Service("RechargeService")
public class RechargeServiceImpl implements RechargeService{
	@Autowired
	private RechargeDao rechargeDao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageBean listPage(PageParam pageParam, Recharge recharge) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		paramMap.put("merchName", recharge.getMerchName()); 
		paramMap.put("merchId", recharge.getMerchId());
		paramMap.put("date1", recharge.getDate1());
		paramMap.put("date2", recharge.getDate2());
		paramMap.put("rechargeAmount", recharge.getRechargeAmount());
		return rechargeDao.listPage(pageParam, paramMap);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public PageBean listPageMerch(PageParam pageParam, Merchant merchant) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		//paramMap.put("nameShort", merch.getNameShort());
	//	paramMap.put("merchId", merch.getMerchId());
		return rechargeDao.listPageMerch(pageParam, paramMap);
	}
	
	@Override
	public Recharge getMerchRechargeById(String lsId) {
		return rechargeDao.getMerchRechargeById(lsId);
	}

	@Override
	public boolean updateStatus(Recharge recharge) {
		if(rechargeDao.updateStatus(recharge)>0){
			if(rechargeDao.updateMerchCredit(recharge)>0){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getMerchReditAmtById(String merchId,Recharge recharge){
		if(rechargeDao.getMerchReditAmtById(merchId).size()<1){
			if(rechargeDao.insertMerchReditAmt(merchId)<1){
				return false;
			};
		}
			List<MerchCredit> merchReditList = rechargeDao.getMerchReditAmtById(merchId);
			recharge.setAfteraccount(merchReditList.get(0).getCurrentAmount());
			recharge.setBeforeaccount(merchReditList.get(0).getCurrentAmount());
		if(rechargeDao.insertMerchRecharge(recharge)>0){
			return true;
		};
		return false;
	}
	
	@Override
	public int insertMerchReditAmt(String merchId){
		return rechargeDao.insertMerchReditAmt(merchId);
	}

	@Override
	public int insertMerchRecharge(Recharge recharge) {
		return rechargeDao.insertMerchRecharge(recharge);
	}

	@Override
	public int deleteMerchRecharge(String lsId) {
		return rechargeDao.deleteMerchRecharge(lsId);
	}

	@Override
	public int updateMerchCredit(Recharge recharge) {
		return rechargeDao.updateStatus(recharge);
	}

	@Override
	public TotalCount totalRechargeLs(Recharge recharge) {
		return rechargeDao.totalRechargeLs(recharge);
	}
}
