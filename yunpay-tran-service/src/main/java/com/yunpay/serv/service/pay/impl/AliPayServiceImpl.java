package com.yunpay.serv.service.pay.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.ali.rep.AliBarRep;
import com.yunpay.ali.rep.AliCancelRep;
import com.yunpay.ali.rep.AliCloseRep;
import com.yunpay.ali.rep.AliQueryRep;
import com.yunpay.ali.rep.AliRefundQueryRep;
import com.yunpay.ali.rep.AliRefundRep;
import com.yunpay.ali.rep.AliScanRep;
import com.yunpay.ali.req.AliBarReq;
import com.yunpay.ali.req.AliCancelReq;
import com.yunpay.ali.req.AliCloseReq;
import com.yunpay.ali.req.AliQueryReq;
import com.yunpay.ali.req.AliRefundQueryReq;
import com.yunpay.ali.req.AliRefundReq;
import com.yunpay.ali.req.AliScanReq;
import com.yunpay.ali.req.AliWapReq;
import com.yunpay.ali.service.AliQrPayService;
import com.yunpay.common.utils.AmountUtil;
import com.yunpay.common.utils.CommonUtil;
import com.yunpay.common.utils.DateUtil;
import com.yunpay.common.utils.Log;
import com.yunpay.common.utils.EnumUtil.ErrorCode;
import com.yunpay.common.utils.EnumUtil.PayChannel;
import com.yunpay.common.utils.EnumUtil.PayStatus;
import com.yunpay.common.utils.EnumUtil.RefundStatus;
import com.yunpay.common.utils.EnumUtil.SubChannel;
import com.yunpay.serv.config.PayConfig;
import com.yunpay.serv.dao.AlipayConfigDao;
import com.yunpay.serv.model.AlipayConfigKey;
import com.yunpay.serv.model.Merchant;
import com.yunpay.serv.model.PayTranLs;
import com.yunpay.serv.model.RefundTranLs;
import com.yunpay.serv.rep.BarPayRepDto;
import com.yunpay.serv.rep.Message;
import com.yunpay.serv.rep.RefundQueryRepDto;
import com.yunpay.serv.rep.RefundRepDto;
import com.yunpay.serv.rep.ScanPayRepDto;
import com.yunpay.serv.req.QrPayReqDto;
import com.yunpay.serv.req.QrRefundReqDto;
import com.yunpay.serv.req.WapPayReqDto;
import com.yunpay.serv.service.busi.PayTranLsService;
import com.yunpay.serv.service.busi.RefundTranLsService;
import com.yunpay.serv.service.pay.QrPayService;

/**
 * 支付宝支付服务实现类
 * 文件名称:     AliPayServiceImpl.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月23日下午5:57:26 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月23日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Service("aliPayService")
public class AliPayServiceImpl extends QrPayService{
	
	@Autowired
	private AlipayConfigDao alipayConfigDao;
	@Autowired
	private PayTranLsService payTranLsService;
	@Autowired
	private RefundTranLsService refundTranLsService;
	@Autowired
	private AliQrPayService aliQrPayService;

	/**
	 * @Description:支付宝条码支付
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月23日下午5:57:49 
	 * @param qrPayReq
	 * @param merchant
	 * @return
	 */
	@Override
	public Message doBarPay(QrPayReqDto qrPayReq,Merchant merchant) {
		// TODO Auto-generated method stub
		Message retMsg = null;
		//获取支付配置信息
		AlipayConfigKey alipayConfig = alipayConfigDao.findConfigByMerNo(merchant.getMerchantNo());
		if(alipayConfig == null){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		//创建交易流水
		PayTranLs payTranLs = payTranLsService.createQrTranLs(qrPayReq, merchant, SubChannel.ALIPAY_BAR);
		//构造请求参数
		AliBarReq aliBarReq = new AliBarReq(alipayConfig.getAppId(),qrPayReq.getDynamic_id(),
				alipayConfig.getStoreAppPrivateKey(),alipayConfig.getStoreAppPublicKey(),payTranLs.getTransNum(),
				qrPayReq.getTotal_fee(),qrPayReq.getBody(),qrPayReq.getAttach(),qrPayReq.getTerminal_unique_no(),
				alipayConfig.getPid(),"30m");
		AliBarRep aliBarRep = aliQrPayService.doAliBarPay(aliBarReq);
		if(null==aliBarRep){
			return new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		//交易成功
		if("10000".equals(aliBarRep.getCode())){
			//支付宝平台返回交易流水号
			payTranLs.setTrade_no(aliBarRep.getTrade_no());
			//支付状态改为已完成
			payTranLs.setStatus(PayStatus.PAYED.getValue());
			//实际金额
			payTranLs.setTransPrice(Float.valueOf(aliBarRep.getReceipt_amount()));
			//买家支付宝账号
			payTranLs.setTransCardNum(aliBarRep.getBuyer_logon_id());
			//买家支付宝Id
			payTranLs.setOpenid(aliBarRep.getBuyer_user_id());
			//更新流水
			payTranLsService.updatePayTranLs(payTranLs);
			//封装平台返回参数
			BarPayRepDto rep = new BarPayRepDto(aliBarRep,payTranLs);
			retMsg = new Message(rep);
		}else if ("10003".equals(aliBarRep.getCode()) 
				|| "20000".equals(aliBarRep.getCode())){
			//10003等待用户付款
			//20000网络超时或支付宝系统异常
			payTranLs.setStatus(PayStatus.PAYING.getValue());
			payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.PAYING.getValue());
			retMsg = new Message(ErrorCode.ORDER_PAYING.getCode(),ErrorCode.ORDER_PAYING.getDes());
		}else if("40004".equals(aliBarRep.getCode())){
			//支付失败
			retMsg = new Message(aliBarRep.getSub_code(),aliBarRep.getSub_msg());
			payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.FAILPAY.getValue());
		}else{
			//状态未知
			retMsg = new Message(aliBarRep.getSub_code(),aliBarRep.getSub_msg());
			payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.UNKNOWN.getValue());
		}
		return retMsg;
	}

	/**
	 * @Description:支付宝扫码支付
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月26日上午9:07:05 
	 * @param qrPayReq
	 * @param merchant
	 * @return
	 */
	@Override
	public Message doScanPay(QrPayReqDto qrPayReq,Merchant merchant) {
		// TODO Auto-generated method stub
		Message retMsg = null;
		//获取支付配置信息
		AlipayConfigKey alipayConfig = alipayConfigDao.findConfigByMerNo(merchant.getMerchantNo());
		if(alipayConfig == null){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		//创建交易流水
		PayTranLs payTranLs = payTranLsService.createQrTranLs(qrPayReq, merchant, SubChannel.ALIPAY_SCAN);
		//封装支付请求参数
		AliScanReq aliScanReq = new AliScanReq(alipayConfig.getAppId(),PayConfig.ALI_SCAN_NOTIFY_URL,
				alipayConfig.getStoreAppPrivateKey(),alipayConfig.getStoreAppPublicKey(),payTranLs.getTransNum(),
				qrPayReq.getTotal_fee(),qrPayReq.getBody(),qrPayReq.getAttach(),qrPayReq.getTerminal_unique_no(),
				alipayConfig.getPid(),"30m");
		AliScanRep aliScanRep = aliQrPayService.doAliScanPay(aliScanReq);
		if(null==aliScanRep){
			payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.FAILPAY.getValue());
			return new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		if(aliScanRep.getCode().equals("10000")){
			//下单成功
			//修改订单状态为支付中
			payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.PAYING.getValue());
			ScanPayRepDto scanPayRep = new ScanPayRepDto(aliScanRep,payTranLs);
			retMsg = new Message(scanPayRep);
		}else{
			//下单失败
			retMsg = new Message(aliScanRep.getSub_code(),aliScanRep.getSub_msg());
			payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.FAILPAY.getValue());
		}
		return retMsg;
	}

	/**
	 * @Description:订单查询
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月26日上午11:09:15 
	 * @param payTranLs
	 * @return
	 */
	@Override
	public Message doOrderQuery(PayTranLs payTranLs) {
		// TODO Auto-generated method stub
		Message retMsg = null;
		//获取支付配置信息
		AlipayConfigKey alipayConfig = alipayConfigDao.findConfigByMerNo(payTranLs.getMerchantNo());
		if(alipayConfig == null){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		
		AliQueryReq aliQueryReq = new AliQueryReq(alipayConfig.getAppId(),
				alipayConfig.getStoreAppPrivateKey(),alipayConfig.getStoreAppPublicKey(),
				payTranLs.getTransNum(),payTranLs.getTrade_no());
		AliQueryRep aliQueryRep = aliQrPayService.doAliQuery(aliQueryReq);
		if(null==aliQueryRep){
			return new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		//查询成功
		if(aliQueryRep.getCode().equals("10000")){
			//支付宝平台返回交易流水号
			payTranLs.setTrade_no(aliQueryRep.getTrade_no());
			//支付状态改为已完成
			PayStatus payStatus = CommonUtil.convertAliStatus(aliQueryRep.getTrade_status());
			payTranLs.setStatus(payStatus.getValue());
			//实际金额
			payTranLs.setTransPrice(Float.valueOf(aliQueryRep.getReceipt_amount()));
			//买家支付宝账号
			payTranLs.setTransCardNum(aliQueryRep.getBuyer_logon_id());
			//买家支付宝Id
			payTranLs.setOpenid(aliQueryRep.getBuyer_user_id());
			//更新流水
			payTranLsService.updatePayTranLs(payTranLs);
			//封装平台返回参数
			BarPayRepDto rep = new BarPayRepDto(payTranLs);
			retMsg = new Message(rep);
		}else if ("10003".equals(aliQueryRep.getCode())
				|| "20000".equals(aliQueryRep.getCode())){
			//10003该结果码只有在条码支付请求 API 时才返回，代表付款还在进行中
			//兼容USERPAYING
			payTranLs.setStatus(PayStatus.PAYING.getValue());
			payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.PAYING.getValue());
			BarPayRepDto rep = new BarPayRepDto(payTranLs);
			retMsg = new Message(rep);
		}else if(payTranLs.getSubChannel()==SubChannel.ALIPAY_SCAN.getValue()
				&&payTranLs.getStatus()==PayStatus.PAYING.getValue()
				&& "ACQ.TRADE_NOT_EXIST".equals(aliQueryRep.getSub_code())){
			//扫码支付生成二维码后，如果用户没有用支付宝扫码，此时调用支付宝查询订单接口会返回订单不存在
			//所以这里返回订单状态为支付中
			BarPayRepDto rep = new BarPayRepDto(payTranLs);
			retMsg = new Message(rep);
		}else{
			//具体失败原因参见接口返回的错误码
			retMsg = new Message(aliQueryRep.getSub_code(),aliQueryRep.getSub_msg());
		}
		return retMsg;
		
	}
	
	
	/**
	 * @Description:撤销成功
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月26日上午11:18:58 
	 * @param payTranLs
	 * @return
	 */
	@Override
	public Message doOrderReverse(PayTranLs payTranLs) {
		// TODO Auto-generated method stub
		Message retMsg = null;
		//获取支付配置信息
		AlipayConfigKey alipayConfig = alipayConfigDao.findConfigByMerNo(payTranLs.getMerchantNo());
		if(alipayConfig == null){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		AliCancelReq aliCancelReq = new AliCancelReq(alipayConfig.getAppId(),
				alipayConfig.getStoreAppPrivateKey(),alipayConfig.getStoreAppPublicKey(),
				payTranLs.getTransNum(),payTranLs.getTrade_no());
		AliCancelRep aliCancelRep = aliQrPayService.doAliCancel(aliCancelReq);
		if(null==aliCancelRep){
			return new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		//撤销成功
		if(aliCancelRep.getCode().equals("10000")){
			payTranLs.setStatus(PayStatus.CANCEL.getValue());
			payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.CANCEL.getValue());
			//封装平台返回参数
			BarPayRepDto rep = new BarPayRepDto(payTranLs);
			retMsg = new Message(rep);
		}else{//具体失败原因参见接口返回的错误码
			retMsg = new Message(aliCancelRep.getSub_code(),aliCancelRep.getSub_msg());
		}
		return retMsg;
	}

	/**
	 * @Description:支付宝wap支付
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月27日下午2:15:30 
	 * @param qrPayReq
	 * @param merchant
	 * @return
	 */
	@Override
	public Message doWapPay(WapPayReqDto wapPayReq, Merchant merchant) {
		// TODO Auto-generated method stub
		//获取支付配置信息
		AlipayConfigKey alipayConfig = alipayConfigDao.findConfigByMerNo(merchant.getMerchantNo());
		if(alipayConfig == null){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		//创建交易流水
		PayTranLs payTranLs = payTranLsService.createWapTranLs(wapPayReq, merchant,PayChannel.ALIPAY);
		AliWapReq aliWapReq = new AliWapReq(alipayConfig.getAppId(),PayConfig.ALI_SCAN_NOTIFY_URL,
				PayConfig.ALI_WAP_RETURN_URL,alipayConfig.getStoreAppPrivateKey(),alipayConfig.getStoreAppPublicKey(),
				payTranLs.getTransNum(),wapPayReq.getTotal_fee(),wapPayReq.getBody(),wapPayReq.getAttach(),
				alipayConfig.getPid());
		String retForm = aliQrPayService.doAliWapPay(aliWapReq);
		if(retForm==null){
			return new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		return new Message(retForm);
	}

	/**
	 * @Description:支付宝退款请求
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月11日下午5:15:42 
	 * @param qrRefundReq
	 * @param payTranLs
	 * @return
	 */
	@Override
	public Message doOrderRefund(QrRefundReqDto qrRefundReq,PayTranLs payTranLs) {
		// TODO Auto-generated method stub
		Message retMsg = null;
		//退款金额(转换为分)
		int refundFee = Integer.valueOf(AmountUtil.changeY2F(qrRefundReq.getRefund_fee()));
		//原订单总额(转换为分)
		int totalFee = Integer.valueOf(AmountUtil.changeY2F(payTranLs.getTotalPrice().toString()));
		if(refundFee>totalFee){
			return new Message(ErrorCode.REFUND_FEE_ERR.getCode(),ErrorCode.REFUND_FEE_ERR.getDes());
		}
		//创建退款流水
		RefundTranLs refundTranLs = refundTranLsService.createRefundTranLs(qrRefundReq,payTranLs);
		//获取支付配置信息
		AlipayConfigKey alipayConfig = alipayConfigDao.findConfigByMerNo(qrRefundReq.getMerchant_num());
		if(alipayConfig == null){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		//构造请求参数
		AliRefundReq refundReq = new AliRefundReq(alipayConfig.getAppId(),
				alipayConfig.getStoreAppPrivateKey(),alipayConfig.getStoreAppPublicKey(),
				payTranLs.getTransNum(),payTranLs.getTrade_no(),refundTranLs.getTransNum(),
				qrRefundReq.getRefund_fee(),qrRefundReq.getRefund_desc());
		AliRefundRep refundRep = aliQrPayService.doAliRefund(refundReq);
		if(null==refundRep){
			return new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		if(refundRep.getCode().equals("10000")){
			//退款成功
			/**
			 * 此处流程同微信退款有区别，微信退款需通过查询退款接口确定退款结果，而支付宝直接返回退款结果
			 */
			refundTranLs.setStatus(RefundStatus.REFUNDED.getValue());
			//设置退款成功时间
			refundTranLs.setRefundSuccessTime(DateUtil.format(refundRep.getGmt_refund_pay(),"yyyy-MM-dd HH:mm:ss"));
			refundTranLsService.updateRefundTranLs(refundTranLs);
			RefundRepDto rep = new RefundRepDto(refundTranLs);
			retMsg = new Message(rep);
		}else{
			//退款失败
			Log.error("支付宝退款请求失败，err_msg:"+refundRep.getSub_msg());
			refundTranLs.setStatus(RefundStatus.FAILREFUND.getValue());
			refundTranLsService.updTranStatus(refundTranLs.getId(), RefundStatus.FAILREFUND.getValue());
			retMsg = new Message(refundRep.getSub_code(),refundRep.getSub_msg());
		}
		return retMsg;
	}

	
	/**
	 * @Description:支付宝退款查询
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月11日下午5:15:57 
	 * @param refundTranLs
	 * @return
	 */
	@Override
	public Message doRefundQuery(RefundTranLs refundTranLs) {
		// TODO Auto-generated method stub
		Message retMsg = null;
		AlipayConfigKey alipayConfig = alipayConfigDao.findConfigByMerNo(refundTranLs.getMerchantNo());
		if(alipayConfig == null){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		AliRefundQueryReq refundQueryReq = new AliRefundQueryReq(alipayConfig.getAppId(),
				alipayConfig.getStoreAppPrivateKey(),alipayConfig.getStoreAppPublicKey(),
				refundTranLs.getOldTransNum(),"",refundTranLs.getTransNum());
		AliRefundQueryRep refundQueryRep = aliQrPayService.doAliRefundQuery(refundQueryReq);
		if(null==refundQueryRep){
			return new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		if(refundQueryRep.getCode().equals("10000")){
			if(StringUtils.isNotBlank(refundQueryRep.getRefund_amount())){
				//查询成功，且退款成功
				refundTranLs.setStatus(RefundStatus.REFUNDED.getValue());
				refundTranLsService.updTranStatus(refundTranLs.getId(), RefundStatus.REFUNDED.getValue());
				RefundQueryRepDto rep = new RefundQueryRepDto(refundTranLs);
				retMsg = new Message(rep);
			}else{
				//查询成功，退款未成功(设置退款单状态为退款中)
				refundTranLs.setStatus(RefundStatus.REFUNDING.getValue());
				refundTranLsService.updTranStatus(refundTranLs.getId(), RefundStatus.REFUNDING.getValue());
				RefundQueryRepDto rep = new RefundQueryRepDto(refundTranLs);
				retMsg = new Message(rep);
			}
		}else{
			//查询失败
			Log.error("支付宝退款请求失败，err_msg:"+refundQueryRep.getSub_msg());
			retMsg = new Message(refundQueryRep.getSub_code(),refundQueryRep.getSub_msg());
		}
		return retMsg;
	}

	/**
	 * @Description:订单关闭
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月12日下午6:01:36 
	 * @param payTranLs
	 * @return
	 */
	@Override
	public Message doOrderClose(PayTranLs payTranLs) {
		// TODO Auto-generated method stub
		Message retMsg = null;
		//获取支付配置信息
		AlipayConfigKey alipayConfig = alipayConfigDao.findConfigByMerNo(payTranLs.getMerchantNo());
		if(alipayConfig == null){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		AliCloseReq aliCloseReq = new AliCloseReq(alipayConfig.getAppId(),
				alipayConfig.getStoreAppPrivateKey(),alipayConfig.getStoreAppPublicKey(),
				payTranLs.getTransNum(),payTranLs.getTrade_no());
		AliCloseRep aliCloseRep = aliQrPayService.doAliClose(aliCloseReq);
		if(null==aliCloseRep){
			return new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		//关闭成功或者提示订单不存在
		if(aliCloseRep.getCode().equals("10000") 
				|| "ACQ.TRADE_NOT_EXIST".equals(aliCloseRep.getSub_code())){
			payTranLs.setStatus(PayStatus.CLOSED.getValue());
			payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.CLOSED.getValue());
			//封装平台返回参数
			BarPayRepDto rep = new BarPayRepDto(payTranLs);
			retMsg = new Message(rep);
		}else{
			//具体失败原因参见接口返回的错误码
			retMsg = new Message(aliCloseRep.getSub_code(),aliCloseRep.getSub_msg());
		}
		return retMsg;
	}

}
