package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.TranInfoDao;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.MerchTran;
import com.yunpay.permission.entity.OffTranInfo;
import com.yunpay.permission.entity.OnTranInfo;
import com.yunpay.permission.entity.TotalCount;
import com.yunpay.permission.entity.TranInfo;
import com.yunpay.permission.service.TranInfoService;

@Service("TranInfoService")
public class TranInfoServiceImpl implements TranInfoService{
	@Autowired
	private TranInfoDao TranInfoDao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageBean listPage(PageParam pageParam, TranInfo tranInfo) {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		paramMap.put("merchId", tranInfo.getMerchId()); 
		paramMap.put("termId", tranInfo.getTermId());
		paramMap.put("tranType", tranInfo.getTranType());
		paramMap.put("cardNo", tranInfo.getCardNo());
		paramMap.put("batchNo", tranInfo.getBatchNo());
		paramMap.put("tranSerial", tranInfo.getTranSerial());
		paramMap.put("tranStatus", tranInfo.getTranStatus());
		paramMap.put("date1", tranInfo.getDate1());
		paramMap.put("date2", tranInfo.getDate2());
		return TranInfoDao.listPage(pageParam, paramMap);
	}

	public List<MerchTran> tranInfoExcel() {
	    return TranInfoDao.tranInfoExcel();
    }
	
	@Override
	public List<OffTranInfo> offTraninfoView(TranInfo tranInfo) {
		return TranInfoDao.offTraninfoView(tranInfo);
	}

	@Override
	public List<OnTranInfo> onTraninfoView(TranInfo tranInfo) {
		return TranInfoDao.onTraninfoView(tranInfo);
	}

	@Override
	public List<ComboxValue> queryTranType() {
		return TranInfoDao.queryTranType();
	}

	@Override
	public TotalCount totalTranAmt(TranInfo tranInfo) {
		return TranInfoDao.totalTranAmt(tranInfo);
	}



}
