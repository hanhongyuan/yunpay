package com.yunpay.serv.service.pay.impl;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.utils.AmountUtil;
import com.yunpay.common.utils.CommonUtil;
import com.yunpay.common.utils.EnumUtil.ErrorCode;
import com.yunpay.common.utils.EnumUtil.PayStatus;
import com.yunpay.common.utils.EnumUtil.SubChannel;
import com.yunpay.serv.config.PayConfig;
import com.yunpay.serv.dao.UnionConfigDao;
import com.yunpay.serv.model.Merchant;
import com.yunpay.serv.model.PayTranLs;
import com.yunpay.serv.model.RefundTranLs;
import com.yunpay.serv.model.UnionConfig;
import com.yunpay.serv.rep.BarPayRepDto;
import com.yunpay.serv.rep.Message;
import com.yunpay.serv.rep.ScanPayRepDto;
import com.yunpay.serv.req.QrPayReqDto;
import com.yunpay.serv.req.QrRefundReqDto;
import com.yunpay.serv.req.WapPayReqDto;
import com.yunpay.serv.service.busi.PayTranLsService;
import com.yunpay.serv.service.pay.QrPayService;
import com.yunpay.union.rep.UnionBarRep;
import com.yunpay.union.rep.UnionQueryRep;
import com.yunpay.union.rep.UnionScanRep;
import com.yunpay.union.req.UnionBarReq;
import com.yunpay.union.req.UnionQueryReq;
import com.yunpay.union.req.UnionScanReq;
import com.yunpay.union.service.UnionQrPayService;
/**
 * 银联支付服务实现类
 * 文件名称:     UnionPayServiceImpl.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月6日上午11:15:05 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月6日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Service("unionPayService")
public class UnionPayServiceImpl extends QrPayService{
	@Autowired
	private UnionConfigDao unionConfigDao;
	@Autowired
	private PayTranLsService payTranLsService;
	@Autowired
	private UnionQrPayService unionQrPayService;
	
	/**
	 * @Description: 银联条码支付
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月6日上午11:52:44 
	 * @param qrPayReq
	 * @param merchant
	 * @return
	 */
	@Override
	public Message doBarPay(QrPayReqDto qrPayReq, Merchant merchant) {
		// TODO Auto-generated method stub
		Message payMsg = null;
		//获取支付配置
		UnionConfig unionConfig = unionConfigDao.findConfigByMerNo(merchant.getMerchantNo());
		if(unionConfig==null){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		//创建订单流水
		PayTranLs payTranLs = payTranLsService.createQrTranLs(qrPayReq, merchant, SubChannel.UNION_BAR);
		//转换交易金额
		String totalFee = AmountUtil.changeY2F(payTranLs.getTransPrice().toString());
		//订单交易时间
		String txnTime = new SimpleDateFormat("yyyyMMddHHmmss").format(payTranLs.getTransTime());
		UnionBarReq req = new UnionBarReq(unionConfig.getUnionMerchId(),payTranLs.getTransNum(), txnTime,
				totalFee,PayConfig.UNION_SCAN_NOTIFY_URL,qrPayReq.getDynamic_id(),qrPayReq.getTerminal_unique_no());
		UnionBarRep rep = unionQrPayService.doUnionBarPay(req);
		if(rep!=null){
			if("00".equals(rep.getRespCode())){
				//支付成功
				BarPayRepDto payResData = new BarPayRepDto(rep,payTranLs);
				payTranLs.setStatus(PayStatus.PAYED.getValue());
				payTranLs.setTrade_no(rep.getQueryId());
				//更新订单流水
				payTranLsService.updatePayTranLs(payTranLs);
				payMsg = new Message(payResData); 
				
			}else{
				//支付失败，修改订单状态
				payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.FAILPAY.getValue());
				payMsg = new Message(rep.getRespCode(),rep.getRespMsg());
			}
		}else{
			//返回结果为空
			payMsg = new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		return payMsg;
	}

	/**
	 * @Description:银联扫码下单
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月6日上午11:53:00 
	 * @param qrPayReq
	 * @param merchant
	 * @return
	 */
	@Override
	public Message doScanPay(QrPayReqDto qrPayReq, Merchant merchant) {
		// TODO Auto-generated method stub
		Message payMsg = null;
		//获取支付配置
		UnionConfig unionConfig = unionConfigDao.findConfigByMerNo(merchant.getMerchantNo()); 
		if(unionConfig==null){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		//创建订单流水
		PayTranLs payTranLs = payTranLsService.createQrTranLs(qrPayReq, merchant, SubChannel.UNION_SCAN);
		//转换交易金额
		String totalFee = AmountUtil.changeY2F(payTranLs.getTransPrice().toString());
		String txnTime = new SimpleDateFormat("yyyyMMddHHmmss").format(payTranLs.getTransTime());
		UnionScanReq req = new UnionScanReq(unionConfig.getUnionMerchId(),payTranLs.getTransNum(), txnTime,
				totalFee,PayConfig.UNION_SCAN_NOTIFY_URL,qrPayReq.getTerminal_unique_no());
		UnionScanRep rep = unionQrPayService.doUnionScanPay(req);
		if(rep!=null){
			if("00".equals(rep.getRespCode())){
				//银联扫码支付下单成功
				ScanPayRepDto payResData = new ScanPayRepDto(rep,payTranLs);
				payMsg = new Message(payResData);
			}else{
				//银联扫码支付下单失败
				payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.FAILPAY.getValue());
				payMsg = new Message(rep.getRespCode(),rep.getRespMsg());
			}
		}else{
			//返回结果为空
			payMsg = new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		return payMsg;
	}
	
	

	/**
	 * @Description:银联wap支付
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月6日上午11:53:15 
	 * @param qrPayReq
	 * @param merchant
	 * @return
	 */
	@Override
	public Message doWapPay(WapPayReqDto wapPayReq, Merchant merchant) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Description:银联订单查询
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月6日上午11:53:28 
	 * @param payTranLs
	 * @return
	 */
	@Override
	public Message doOrderQuery(PayTranLs payTranLs) {
		// TODO Auto-generated method stub
		Message payMsg = null;
		//获取支付配置
		UnionConfig unionConfig = unionConfigDao.findConfigByMerNo(payTranLs.getMerchantNo());
		if(unionConfig==null){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		String txnTime = new SimpleDateFormat("yyyyMMddHHmmss").format(payTranLs.getTransTime());
		UnionQueryReq req = new UnionQueryReq(unionConfig.getUnionMerchId(),payTranLs.getTransNum(),txnTime);
		UnionQueryRep rep = unionQrPayService.doUnionQuery(req);
		if(rep!=null){
			if("00".equals(rep.getRespCode())){
				//查询成功
				PayStatus payStatus = CommonUtil.convertUnionStatus(rep.getOrigRespCode());
				payTranLs.setStatus(payStatus.getValue());
				if("00".equals(rep.getOrigRespCode()) || "A6".equals(rep.getOrigRespCode())){
					//查询的交易成功，更新商户订单状态
					//银联返回的查询流水号
					payTranLs.setTrade_no(rep.getQueryId());
					//账号
					payTranLs.setTransCardNum(rep.getAccNo());
					//银联返回的系统跟踪号
					payTranLs.setOpenid(rep.getTraceNo());
				}
				//修改订单信息
				payTranLsService.updatePayTranLs(payTranLs);
				BarPayRepDto payResData = new BarPayRepDto(payTranLs);
				payMsg = new Message(payResData);
			}else if(("34").equals(rep.getRespCode())){
				//订单不存在，可认为交易状态未明，需要稍后发起交易状态查询，或依据对账结果为准
				BarPayRepDto payResData = new BarPayRepDto(payTranLs);
				payMsg = new Message(payResData);
			}else{
				//查询失败，如应答码10/11检查查询报文是否正确
				payMsg = new Message(rep.getRespCode(),rep.getRespMsg());
			}
		}else{
			//返回结果为空
			payMsg = new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		return payMsg;
	}

	/**
	 * @Description:银联订单撤销
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月6日上午11:53:38 
	 * @param payTranLs
	 * @return
	 */
	@Override
	public Message doOrderReverse(PayTranLs payTranLs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message doOrderRefund(QrRefundReqDto qrRefundReq,PayTranLs payTranLs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message doRefundQuery(RefundTranLs refundTranLs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message doOrderClose(PayTranLs payTranLs) {
		// TODO Auto-generated method stub
		return null;
	}

}
