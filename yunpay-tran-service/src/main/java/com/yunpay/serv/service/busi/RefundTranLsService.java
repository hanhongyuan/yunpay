package com.yunpay.serv.service.busi;
import java.util.List;
import com.yunpay.serv.model.PayTranLs;
import com.yunpay.serv.model.RefundTranLs;
import com.yunpay.serv.req.QrRefundReqDto;
public interface RefundTranLsService {
	
	public RefundTranLs createRefundTranLs(QrRefundReqDto refundReq,PayTranLs payTranLs);
	
	public int updTranStatus(int id,int status);
	
	public RefundTranLs updateRefundTranLs(RefundTranLs refundTranLs);
	
	public RefundTranLs findRefundLsByOrderNo(String userRefundNo,String merchantNo);
	
	public RefundTranLs findRefundLsByTransNum(String transNum);
	
	public List<RefundTranLs> selectAllSynRefundLs(Integer intervalTime);
}
