package com.yunpay.serv.service.busi.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.utils.IdWorker;
import com.yunpay.common.utils.EnumUtil.RefundStatus;
import com.yunpay.serv.dao.RefundTranLsDao;
import com.yunpay.serv.model.PayTranLs;
import com.yunpay.serv.model.RefundTranLs;
import com.yunpay.serv.req.QrRefundReqDto;
import com.yunpay.serv.service.busi.RefundTranLsService;

@Service
public class RefundTranLsServiceImpl implements RefundTranLsService{
	
	@Autowired
	private RefundTranLsDao refundTranLsDao;

	@Override
	public RefundTranLs createRefundTranLs(QrRefundReqDto refundReq,
			PayTranLs payTranLs) {
		// TODO Auto-generated method stub
		IdWorker iw = new IdWorker();
		String transNum = iw.getId() + "";
		RefundTranLs refundTranLs = new RefundTranLs();
		refundTranLs.setChannel(payTranLs.getChannel());
		refundTranLs.setMerchantNo(payTranLs.getMerchantNo());
		refundTranLs.setMerchantName(payTranLs.getMerchantName());
		refundTranLs.setUserRefundNo(refundReq.getUser_refund_no());
		refundTranLs.setOldUserOrderNo(payTranLs.getUser_order_no());
		refundTranLs.setTransNum(transNum);
		refundTranLs.setOldTransNum(payTranLs.getTransNum());
		refundTranLs.setTransTime(new Date());
		refundTranLs.setTotalPrice(payTranLs.getTotalPrice());//订单金额
		refundTranLs.setRefundFee(Float.valueOf(refundReq.getRefund_fee()));
		refundTranLs.setOrgNo(payTranLs.getOrgNo());
		refundTranLs.setStatus(RefundStatus.UNREFUND.getValue());
		refundTranLsDao.insert(refundTranLs);
		return refundTranLs;
	}

	@Override
	public int updTranStatus(int id, int status) {
		// TODO Auto-generated method stub
		return refundTranLsDao.updRefundTranStatus(id, status);
	}

	@Override
	public RefundTranLs updateRefundTranLs(RefundTranLs refundTranLs) {
		// TODO Auto-generated method stub
		refundTranLsDao.updateByPrimaryKeySelective(refundTranLs);
		return refundTranLs;
	}

	@Override
	public RefundTranLs findRefundLsByOrderNo(String userRefundNo,
			String merchantNo) {
		// TODO Auto-generated method stub
		return refundTranLsDao.findLsByUserRefundNo(userRefundNo, merchantNo);
	}

	@Override
	public RefundTranLs findRefundLsByTransNum(String transNum) {
		// TODO Auto-generated method stub
		return refundTranLsDao.findRefundLsByTransNum(transNum);
	}

	@Override
	public List<RefundTranLs> selectAllSynRefundLs(Integer intervalTime) {
		// TODO Auto-generated method stub
		return refundTranLsDao.selectAllSynRefundLs(intervalTime);
	}
	
	

}
