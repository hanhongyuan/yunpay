package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.MerchCreditUpdDao;
import com.yunpay.permission.entity.MerchCreditUpd;
import com.yunpay.permission.service.MerchCreditUpdService;

@Service("MerchCreditUpdService")
public class MerchCreitUpdServiceImpl implements MerchCreditUpdService{
	@Autowired
	private MerchCreditUpdDao merchCreditUpdDao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PageBean listPage(PageParam pageParam,MerchCreditUpd merchCreditUpd) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		paramMap.put("date1", merchCreditUpd.getDate1()); 
		paramMap.put("date2", merchCreditUpd.getDate2());
		paramMap.put("merchId", merchCreditUpd.getMerchId());
		return merchCreditUpdDao.listPage(pageParam, paramMap);
	}

	@Override
	public boolean insertMerchCredit(MerchCreditUpd creditUpd) {
		if(merchCreditUpdDao.insertMerchCredit(creditUpd)>0){
			if(merchCreditUpdDao.updateMerchReditAmt(creditUpd)>0){
				return true;
			};
		};
		return false;
	}

	@Override
	public int updateMerchReditAmt(MerchCreditUpd creditUpd) {
		return merchCreditUpdDao.updateMerchReditAmt(creditUpd);
	}
	
}
