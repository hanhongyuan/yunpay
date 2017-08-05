package com.yunpay.serv.service.pay.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yunpay.common.utils.AmountUtil;
import com.yunpay.common.utils.CommonUtil;
import com.yunpay.common.utils.DateUtil;
import com.yunpay.common.utils.EnumUtil.PayStatus;
import com.yunpay.common.utils.EnumUtil.RefundStatus;
import com.yunpay.common.utils.HttpUtil;
import com.yunpay.common.utils.Log;
import com.yunpay.common.utils.EnumUtil.ErrorCode;
import com.yunpay.common.utils.EnumUtil.PayChannel;
import com.yunpay.common.utils.EnumUtil.ResultCode;
import com.yunpay.common.utils.EnumUtil.SubChannel;
import com.yunpay.serv.config.PayConfig;
import com.yunpay.serv.dao.WechatConfigDao;
import com.yunpay.serv.model.Merchant;
import com.yunpay.serv.model.PayTranLs;
import com.yunpay.serv.model.RefundTranLs;
import com.yunpay.serv.model.WechatConfigKey;
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
import com.yunpay.wx.rep.pay.WechatBarRep;
import com.yunpay.wx.rep.pay.WechatCloseRep;
import com.yunpay.wx.rep.pay.WechatQueryRep;
import com.yunpay.wx.rep.pay.WechatRefundQueryRep;
import com.yunpay.wx.rep.pay.WechatRefundRep;
import com.yunpay.wx.rep.pay.WechatReverseRep;
import com.yunpay.wx.rep.pay.WechatScanRep;
import com.yunpay.wx.rep.pay.WechatWapRep;
import com.yunpay.wx.req.pay.WechatBarReq;
import com.yunpay.wx.req.pay.WechatCloseReq;
import com.yunpay.wx.req.pay.WechatQueryReq;
import com.yunpay.wx.req.pay.WechatRefundQueryReq;
import com.yunpay.wx.req.pay.WechatRefundReq;
import com.yunpay.wx.req.pay.WechatReverseReq;
import com.yunpay.wx.req.pay.WechatScanReq;
import com.yunpay.wx.req.pay.WechatWapReq;
import com.yunpay.wx.service.WechatQrPayService;

/**
 * 微信支付服务实现类
 * 文件名称:     WechatPayServiceImpl.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月22日上午11:35:58 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月22日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Service("wechatPayService")
public class WechatPayServiceImpl extends QrPayService{
	
	@Autowired
	private WechatConfigDao wechatConfigDao;
	@Autowired
	private PayTranLsService payTranLsService;
	@Autowired
	private RefundTranLsService refundTranLsService;
	@Autowired
	private WechatQrPayService wechatQrPayService;
	
	/**
	 * @Description:	微信条码支付
	 * @author:   		Zeng Dongcheng
	 * @Date:     		2017年6月22日上午11:35:05 
	 * @param qrPayReq  条码支付请求参数
	 * @param merchant  商户信息
	 * @return
	 */
	@Override
	public Message doBarPay(QrPayReqDto qrPayReq,Merchant merchant) {
		// TODO Auto-generated method stub
		Message payMsg = null;
		try {
			//子商户配置
			WechatConfigKey wechatConfigSub = wechatConfigDao.findConfigByMerNo(qrPayReq.getMerchant_num());
			if (wechatConfigSub == null) {
				return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
			}
			//主商户配置
			if(StringUtils.isEmpty(wechatConfigSub.getParentMchNo())){
				return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes()); 
			}
			WechatConfigKey wechatConfigPar =wechatConfigDao.findConfigByMerNo(wechatConfigSub.getParentMchNo());
			//创建订单流水
			PayTranLs payTranLs = payTranLsService.createQrTranLs(qrPayReq, merchant, SubChannel.WACHAT_BAR);
			//金额转换(元转为分)
			int totalFee = Integer.valueOf(AmountUtil.changeY2F(payTranLs.getTransPrice().toString()));
			//获取本地ip
			String ip = InetAddress.getLocalHost().getHostAddress();
			//构造支付请求参数
			WechatBarReq wechatBarReq = new WechatBarReq(wechatConfigPar.getAppId(),wechatConfigPar.getMchId(),
					wechatConfigSub.getMchId(),payTranLs.getTransNum(),qrPayReq.getDynamic_id(),totalFee,
						qrPayReq.getBody(),qrPayReq.getTerminal_unique_no(),ip,null,qrPayReq.getAttach());
			//签名
			String sign = CommonUtil.getSign(CommonUtil.toMap(wechatBarReq),wechatConfigPar.getApiSecret());
			wechatBarReq.setSign(sign);
			//发起微信支付
			WechatBarRep wechatBarRep = wechatQrPayService.doWechatBarPay(wechatBarReq);
			if(wechatBarRep!=null){
				if(ResultCode.FAIL.getCode().equals(wechatBarRep.getReturn_code())){
					//微信return_code为Fail
					payMsg = new Message(ResultCode.FAIL.getCode(),wechatBarRep.getReturn_msg());
				}else{
					//微信return_code和result_code同时为SUCCESS
					if(ResultCode.SUCCESS.getCode().equals(wechatBarRep.getResult_code())){
						Log.debug("微信条码支付成功！");
						BarPayRepDto payResData = new BarPayRepDto(wechatBarRep,payTranLs);
						payTranLs.setTransPrice(Float.valueOf(payResData.getTrans_amount()));
						payTranLs.setStatus(PayStatus.PAYED.getValue());
						payTranLs.setTrade_no(wechatBarRep.getTransaction_id());
						//设置用户openid
						payTranLs.setTransCardNum(payResData.getTrans_card_num());
						payTranLs.setOpenid(payResData.getTrans_card_num());
						//更新订单流水
						payTranLsService.updatePayTranLs(payTranLs);
						payMsg = new Message(payResData); 
					}else{
						if("USERPAYING".equals(wechatBarRep.getErr_code())){
							//正在支付
							payTranLs.setStatus(PayStatus.PAYING.getValue());
							payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.PAYING.getValue());
							payMsg = new Message(ErrorCode.ORDER_PAYING.getCode(),ErrorCode.ORDER_PAYING.getDes());
						}else{
							//支付失败，将微信返回的错误信息封装到结果包中
							payMsg = new Message(wechatBarRep.getErr_code(),wechatBarRep.getErr_code_des());
							payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.FAILPAY.getValue());
						}
					}
				}
			}else{
				//返回结果为空
				payMsg = new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error(e.toString());
			return new Message(ErrorCode.SYSTEM_EXCEPTION.getCode(), ErrorCode.SYSTEM_EXCEPTION.getDes());
		}
		// TODO Auto-generated method stub
		return payMsg;
	}

	/**
	 * @Description:微信扫码支付
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月22日上午11:36:21 
	 * @param barPayReq
	 * @param sysMerchant
	 * @return
	 */
	@Override
	public Message doScanPay(QrPayReqDto qrPayReq,Merchant merchant) {
		// TODO Auto-generated method stub
		Message payMsg = null;
		//子商户配置
		WechatConfigKey wechatConfigSub = wechatConfigDao.findConfigByMerNo(qrPayReq.getMerchant_num());
		if (wechatConfigSub == null) {
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		//主商户配置
		if(StringUtils.isEmpty(wechatConfigSub.getParentMchNo())){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes()); 
		}
		WechatConfigKey wechatConfigPar =wechatConfigDao.findConfigByMerNo(wechatConfigSub.getParentMchNo());
		//创建订单流水
		PayTranLs payTranLs = payTranLsService.createQrTranLs(qrPayReq, merchant, SubChannel.WACHAT_SCAN);
		//金额转换为分
		int totalFee = Integer.valueOf(AmountUtil.changeY2F(payTranLs.getTransPrice().toString()));
		//获取本地ip
		String ip="";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//订单发起时间
		String timeStart = DateUtil.getNow("yyyyMMddHHmmss");
		//订单失效时间(半个小时)
		String timeExpire = DateUtil.getMiAfter(DateUtil.getNow("yyyyMMddHHmmss"), "yyyyMMddHHmmss", 30);
		//构造微信扫码支付请求参数
		WechatScanReq wechatScanReq = new WechatScanReq(wechatConfigPar.getAppId(),wechatConfigPar.getMchId(),
				wechatConfigSub.getMchId(),payTranLs.getTransNum(),
				totalFee,qrPayReq.getBody(),qrPayReq.getTerminal_unique_no(),ip,
				null,qrPayReq.getAttach(),PayConfig.WECHAT_SCAN_NOTIFY_URL,
				 timeStart,timeExpire);
		//签名
		String sign = CommonUtil.getSign(CommonUtil.toMap(wechatScanReq),wechatConfigPar.getApiSecret());
		wechatScanReq.setSign(sign);
		//发起微信扫码支付
		WechatScanRep wechatScanRep = wechatQrPayService.doWechatScanPay(wechatScanReq);
		if(wechatScanRep!=null){
			if(ResultCode.FAIL.getCode().equals(wechatScanRep.getReturn_code())){
				//微信return_code为Fail
				payMsg = new Message(ResultCode.FAIL.getCode(),wechatScanRep.getReturn_msg());
			}else{
				//微信return_code和result_code同时为SUCCESS
				if(ResultCode.SUCCESS.getCode().equals(wechatScanRep.getResult_code())){
					Log.debug("微信扫码支付下单成功！");
					ScanPayRepDto payResData = new ScanPayRepDto(wechatScanRep,payTranLs);
					payMsg = new Message(payResData); 
				}else{
					//将微信返回的错误信息封装到结果包中
					payMsg = new Message(wechatScanRep.getErr_code(),wechatScanRep.getErr_code_des());
					payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.FAILPAY.getValue());
				}
			}
		}else{
			//返回结果为空
			payMsg = new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		return payMsg;
	}
	
	/**
	 * @Description:微信wap支付
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月27日下午2:06:38 
	 * @param qrPayReq
	 * @param merchant
	 * @return
	 */
	@Override
	public Message doWapPay(WapPayReqDto wapPayReq, Merchant merchant) {
		// TODO Auto-generated method stub
		Message payMsg = null;
		//子商户配置
		WechatConfigKey wechatConfigSub = wechatConfigDao.findConfigByMerNo(wapPayReq.getMerchant_num());
		if (wechatConfigSub == null) {
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		//主商户配置
		if(StringUtils.isEmpty(wechatConfigSub.getParentMchNo())){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes()); 
		}
		WechatConfigKey wechatConfigPar =wechatConfigDao.findConfigByMerNo(wechatConfigSub.getParentMchNo());
		//初始化获取openId url
		String reqUrl = PayConfig.WECHAT_OPENID_URL.replace("APPID", wechatConfigPar.getAppId())
				.replaceAll("SECRET", wechatConfigPar.getAppSecret())
				.replaceAll("CODE", wapPayReq.getAuth_code());
		//获取openId
		String recvJsonMsg = HttpUtil.doGet(reqUrl, null, "UTF-8", false);
		Log.info("------------获取openId返回内容"+recvJsonMsg);
		JSONObject obj = JSONObject.parseObject(recvJsonMsg);
		String openId = obj.getString("openid");
		if(StringUtils.isEmpty(openId)){
			return new Message("open id error", "openid获取失败!");
		}
		//创建订单流水
		PayTranLs payTranLs = payTranLsService.createWapTranLs(wapPayReq, merchant, PayChannel.WECHAT);
		//金额转换为分
		int totalFee = Integer.valueOf(AmountUtil.changeY2F(payTranLs.getTransPrice().toString()));
		//获取本地ip
		String ip="";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//订单发起时间
		String timeStart = DateUtil.getNow("yyyyMMddHHmmss");
		//订单失效时间
		String timeExpire = DateUtil.getDateAfter(DateUtil.getNow("yyyyMMddHHmmss"), "yyyyMMddHHmmss", 1);
		//构造微信扫码支付请求参数
		WechatWapReq wechatWapReq = new WechatWapReq(wechatConfigPar.getAppId(),wechatConfigPar.getMchId(),
				wechatConfigSub.getMchId(),payTranLs.getTransNum(),
				totalFee,wapPayReq.getBody(),ip,
				null,wapPayReq.getAttach(),PayConfig.WECHAT_SCAN_NOTIFY_URL,
				 timeStart,timeExpire,openId);
		//签名
		String sign = CommonUtil.getSign(CommonUtil.toMap(wechatWapReq),wechatConfigPar.getApiSecret());
		wechatWapReq.setSign(sign);
		//发起微信wap支付
		WechatWapRep wechatWapRep = wechatQrPayService.doWechatWapPay(wechatWapReq);
		if(wechatWapRep!=null){
			if(ResultCode.FAIL.getCode().equals(wechatWapRep.getReturn_code())){
				//微信return_code为Fail
				payMsg = new Message(ResultCode.FAIL.getCode(),wechatWapRep.getReturn_msg());
			}else{
				//微信return_code和result_code同时为SUCCESS
				if(ResultCode.SUCCESS.getCode().equals(wechatWapRep.getResult_code())){
					Log.debug("微信wap下单成功！");
					//封装wap支付返回参数
					Map<String,String> wxWapMap = new HashMap<String,String>(); 
					String prepayId = "prepay_id="+wechatWapRep.getPrepay_id();
					wxWapMap.put("appId", wechatWapRep.getAppid());
					wxWapMap.put("timeStamp",CommonUtil.getTimeStamp() );		
					wxWapMap.put("nonceStr", wechatWapRep.getNonce_str());
					wxWapMap.put("package", prepayId);
					wxWapMap.put("signType", "MD5");
					String paySign=  CommonUtil.getSign(wxWapMap, wechatConfigPar.getApiSecret());
					wxWapMap.put("paySign", paySign);
					wxWapMap.put("packages", prepayId);
					payMsg = new Message(wxWapMap);
				}else{
					//将微信返回的错误信息封装到结果包中
					payMsg = new Message(wechatWapRep.getErr_code(),wechatWapRep.getErr_code_des());
				}
			}
		}else{
			//返回结果为空
			payMsg = new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		return payMsg;
	}

	/**
	 * @Description:微信订单查询
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月23日下午3:25:20 
	 * @param payTranLs
	 * @return
	 */
	@Override
	public Message doOrderQuery(PayTranLs payTranLs) {
		// TODO Auto-generated method stub
		Message payMsg = null;
		//子商户配置
		WechatConfigKey wechatConfigSub = wechatConfigDao.findConfigByMerNo(payTranLs.getMerchantNo());
		if (wechatConfigSub == null) {
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		//主商户配置
		if(StringUtils.isEmpty(wechatConfigSub.getParentMchNo())){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes()); 
		}
		WechatConfigKey wechatConfigPar =wechatConfigDao.findConfigByMerNo(wechatConfigSub.getParentMchNo());
		//构造订单查询请求参数
		WechatQueryReq wechatQueryReq = new WechatQueryReq(wechatConfigPar.getAppId(),wechatConfigPar.getMchId(),
				wechatConfigSub.getMchId(),payTranLs.getTrade_no(),payTranLs.getTransNum());
		//签名
		String sign = CommonUtil.getSign(CommonUtil.toMap(wechatQueryReq),wechatConfigPar.getApiSecret());
		wechatQueryReq.setSign(sign);
		//发起订单查询
		WechatQueryRep wechatQueryRep = wechatQrPayService.doWechatQuery(wechatQueryReq);
		if(wechatQueryRep!=null){
			if(ResultCode.FAIL.getCode().equals(wechatQueryRep.getReturn_code())){
				//微信return_code为Fail
				payMsg = new Message(ResultCode.FAIL.getCode(),wechatQueryRep.getReturn_msg());
			}else{
				//微信return_code和result_code同时为SUCCESS
				if(ResultCode.SUCCESS.getCode().equals(wechatQueryRep.getResult_code())){
					//微信返回订单状态
					String trade_state = wechatQueryRep.getTrade_state();
					//订单状态转换
					PayStatus payStatus = CommonUtil.convertWxStatus(trade_state);
					payTranLs.setStatus(payStatus.getValue());
					//支付成功,将扩展信息保存至流水表中
					if(payStatus==PayStatus.PAYED){
						Log.debug("订单支付成功");
						try {
							//微信返回实际支付金额
							payTranLs.setTransPrice(Float.valueOf(AmountUtil.changeF2Y(wechatQueryRep.getCash_fee())));
						}  catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							Log.error("cash_fee 转换异常");
						}
						payTranLs.setTrade_no(wechatQueryRep.getTransaction_id());
						//设置用户openid
						payTranLs.setTransCardNum(wechatQueryRep.getOpenid());
						payTranLs.setOpenid(wechatQueryRep.getOpenid());
					}
					//修改订单
					payTranLsService.updatePayTranLs(payTranLs);
					//封装平台返回参数
					BarPayRepDto queryResData = new BarPayRepDto(payTranLs);
					payMsg = new Message(ResultCode.SUCCESS.name(), "查询返回成功", queryResData); 
				}else{
					//将微信返回的错误信息封装到结果包中
					Log.debug("微信查询失败，err_code_desc="+wechatQueryRep.getErr_code_des());
					payMsg = new Message(wechatQueryRep.getErr_code(),wechatQueryRep.getErr_code_des());
				}
			}
		}else{
			//返回结果为空
			payMsg = new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		return payMsg;
	}

	/**
	 * @Description:微信订单撤销
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月23日下午4:40:16 
	 * @param payTranLs
	 * @return
	 */
	@Override
	public Message doOrderReverse(PayTranLs payTranLs) {
		// TODO Auto-generated method stub
		Message payMsg = null;
		//子商户配置
		WechatConfigKey wechatConfigSub = wechatConfigDao.findConfigByMerNo(payTranLs.getMerchantNo());
		if (wechatConfigSub == null) {
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		//主商户配置
		if(StringUtils.isEmpty(wechatConfigSub.getParentMchNo())){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes()); 
		}
		WechatConfigKey wechatConfigPar =wechatConfigDao.findConfigByMerNo(wechatConfigSub.getParentMchNo());
		//构造订单查询请求参数
		WechatReverseReq wechatReverseReq = new WechatReverseReq(wechatConfigPar.getAppId(),wechatConfigPar.getMchId(),
				wechatConfigSub.getMchId(),payTranLs.getTrade_no(),payTranLs.getTransNum());
		//签名
		String sign = CommonUtil.getSign(CommonUtil.toMap(wechatReverseReq),wechatConfigPar.getApiSecret());
		wechatReverseReq.setSign(sign);
		//发起订单查询
		WechatReverseRep wechatReverseRep = wechatQrPayService.doWechatReverse(wechatReverseReq,
				wechatConfigPar.getCertLocalPath(),wechatConfigPar.getCertPassword());
		if(wechatReverseRep!=null){
			if(ResultCode.FAIL.getCode().equals(wechatReverseRep.getReturn_code())){
				//微信return_code为Fail
				payMsg = new Message(ResultCode.FAIL.getCode(),wechatReverseRep.getReturn_msg());
			}else{
				//微信return_code和result_code同时为SUCCESS
				if(ResultCode.SUCCESS.getCode().equals(wechatReverseRep.getResult_code())){
					Log.debug("订单撤销成功！");
					//微信返回订单状态
					payTranLs.setStatus(PayStatus.CANCEL.getValue());
					//修改订单状态
					payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.CANCEL.getValue());
					//封装平台返回参数
					BarPayRepDto queryResData = new BarPayRepDto(payTranLs);
					payMsg = new Message(ResultCode.SUCCESS.name(), "订单撤销成功", queryResData); 
				}else{
					//将微信返回的错误信息封装到结果包中
					payMsg = new Message(wechatReverseRep.getErr_code(),wechatReverseRep.getErr_code_des());
				}
			}
		}else{
			//返回结果为空
			payMsg = new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		return payMsg;
	}

	
	/**
	 * @Description:微信退款申请
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月10日下午4:40:43 
	 * @param qrRefundReq
	 * @param payTranLs
	 * @return
	 */
	@Override
	public Message doOrderRefund(QrRefundReqDto qrRefundReq,PayTranLs payTranLs) {
		// TODO Auto-generated method stub
		Message payMsg = null;
		try {
			//退款金额(转换为分)
			int refundFee = Integer.valueOf(AmountUtil.changeY2F(qrRefundReq.getRefund_fee()));
			//原订单总额(转换为分)
			int totalFee = Integer.valueOf(AmountUtil.changeY2F(payTranLs.getTotalPrice().toString()));
			if(refundFee>totalFee){
				return new Message(ErrorCode.REFUND_FEE_ERR.getCode(),ErrorCode.REFUND_FEE_ERR.getDes());
			}
			//验证退款单号是否存在
			RefundTranLs refundTranLs = refundTranLsService.findRefundLsByOrderNo(
					qrRefundReq.getUser_refund_no(), qrRefundReq.getMerchant_num()); 
			if(refundTranLs!=null){
				//如果退款单状态为未退款、退款中、已退款状态，提示用户退款单已存在
				//此处流程表示如果退款失败，可用原退款单号发起重复退款请求(微信和支付宝建议如此)
				if(refundTranLs.getStatus()!= RefundStatus.FAILREFUND.getValue()){
					return new Message(ErrorCode.REFUND_ORDER_NO_EXIST.getCode(), ErrorCode.REFUND_ORDER_NO_EXIST.getDes());
				}
			}else{
				//创建退款流水
				refundTranLs = refundTranLsService.createRefundTranLs(qrRefundReq,payTranLs);
			}
			//子商户配置
			WechatConfigKey wechatConfigSub = wechatConfigDao.findConfigByMerNo(qrRefundReq.getMerchant_num());
			if (wechatConfigSub == null) {
				return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
			}
			//主商户配置
			if(StringUtils.isEmpty(wechatConfigSub.getParentMchNo())){
				return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes()); 
			}
			WechatConfigKey wechatConfigPar =wechatConfigDao.findConfigByMerNo(wechatConfigSub.getParentMchNo());		
			//构造支付请求参数
			WechatRefundReq wechatRefundReq = new WechatRefundReq(wechatConfigPar.getAppId(),wechatConfigPar.getMchId(),
					wechatConfigSub.getMchId(),payTranLs.getTrade_no(),payTranLs.getTransNum(),refundTranLs.getTransNum(),
					totalFee,refundFee,qrRefundReq.getRefund_desc());
			//签名
			String sign = CommonUtil.getSign(CommonUtil.toMap(wechatRefundReq),wechatConfigPar.getApiSecret());
			wechatRefundReq.setSign(sign);
			//发起微信支付
			WechatRefundRep wechantRefundRep = wechatQrPayService.doWechatRefund(wechatRefundReq,
					wechatConfigPar.getCertLocalPath(),wechatConfigPar.getCertPassword());
			if(wechantRefundRep!=null){
				if(ResultCode.FAIL.getCode().equals(wechantRefundRep.getReturn_code())){
					//微信return_code为Fail
					payMsg = new Message(ResultCode.FAIL.getCode(),wechantRefundRep.getReturn_msg());
				}else{
					//微信return_code和result_code同时为SUCCESS
					if(ResultCode.SUCCESS.getCode().equals(wechantRefundRep.getResult_code())){
						Log.debug("微信退款申请成功！");
						refundTranLs.setStatus(RefundStatus.REFUNDING.getValue());
						refundTranLs.setTradeNo(wechantRefundRep.getRefund_id());
						refundTranLsService.updateRefundTranLs(refundTranLs);
						RefundRepDto refundRep = new RefundRepDto(refundTranLs);
						payMsg = new Message(refundRep);
					}else{
						Log.debug("微信退款申请失败，err_code_desc="+wechantRefundRep.getErr_code_des());
						refundTranLsService.updTranStatus(refundTranLs.getId(), RefundStatus.FAILREFUND.getValue());
						payMsg = new Message(wechantRefundRep.getErr_code(),wechantRefundRep.getErr_code_des());
					}
				}
			}else{
				//返回结果为空
				payMsg = new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error(e.toString());
			return new Message(ErrorCode.SYSTEM_EXCEPTION.getCode(), ErrorCode.SYSTEM_EXCEPTION.getDes());
		}
		// TODO Auto-generated method stub
		return payMsg;
	}
	
	
	/**
	 * @Description:微信退款查询
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月10日下午4:40:43 
	 * @param qrRefundReq
	 * @param payTranLs
	 * @return
	 */
	@Override
	public Message doRefundQuery(RefundTranLs refundTranLs) {
		// TODO Auto-generated method stub
		Message payMsg = null;
		try {
			//子商户配置
			WechatConfigKey wechatConfigSub = wechatConfigDao.findConfigByMerNo(refundTranLs.getMerchantNo());
			if (wechatConfigSub == null) {
				return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
			}
			//主商户配置
			if(StringUtils.isEmpty(wechatConfigSub.getParentMchNo())){
				return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes()); 
			}
			WechatConfigKey wechatConfigPar =wechatConfigDao.findConfigByMerNo(wechatConfigSub.getParentMchNo());
			
			//构造支付请求参数
			WechatRefundQueryReq refundQueryReq = new WechatRefundQueryReq(wechatConfigPar.getAppId(),wechatConfigPar.getMchId(),
					wechatConfigSub.getMchId(),refundTranLs.getTradeNo(),refundTranLs.getTransNum());
			//签名
			String sign = CommonUtil.getSign(CommonUtil.toMap(refundQueryReq),wechatConfigPar.getApiSecret());
			refundQueryReq.setSign(sign);
			//发起微信支付
			WechatRefundQueryRep refundQueryRep = wechatQrPayService.doWechatRefundQuery(refundQueryReq);
			if(refundQueryRep!=null){
				if(ResultCode.FAIL.getCode().equals(refundQueryRep.getReturn_code())){
					//微信return_code为Fail
					payMsg = new Message(ResultCode.FAIL.getCode(),refundQueryRep.getReturn_msg());
				}else{
					//微信return_code和result_code同时为SUCCESS
					if(ResultCode.SUCCESS.getCode().equals(refundQueryRep.getResult_code())){
						
						RefundStatus refundStatus = CommonUtil.convertWxRefundStatus(refundQueryRep.getRefund_status_0());
						refundTranLs.setStatus(refundStatus.getValue());
						//如果退款状态为成功
						if(refundStatus==RefundStatus.REFUNDED){
							Log.debug("微信退款成功！");
							refundTranLs.setRefundAccount(refundQueryRep.getRefund_account_0());
							refundTranLs.setRefundChannel(refundQueryRep.getRefund_channel_0());
							refundTranLs.setTradeNo(refundQueryRep.getRefund_id_0());
							refundTranLs.setRefundRecvAccout(refundQueryRep.getRefund_recv_accout_0());
							refundTranLs.setRefundSuccessTime(refundQueryRep.getRefund_success_time_0());
							refundTranLsService.updateRefundTranLs(refundTranLs);
						}else{
							refundTranLsService.updTranStatus(refundTranLs.getId(), refundStatus.getValue());
						}
						RefundQueryRepDto rep = new RefundQueryRepDto(refundTranLs);
						payMsg = new Message(rep);
					}else{
						Log.debug("微信退款查询失败，err_code_desc="+refundQueryRep.getErr_code_des());
						payMsg = new Message(refundQueryRep.getErr_code(),refundQueryRep.getErr_code_des());
					}
				}
			}else{
				//返回结果为空
				payMsg = new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error(e.toString());
			return new Message(ErrorCode.SYSTEM_EXCEPTION.getCode(), ErrorCode.SYSTEM_EXCEPTION.getDes());
		}
		// TODO Auto-generated method stub
		return payMsg;
	}

	/**
	 * @Description:订单关闭
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月12日下午5:59:38 
	 * @param payTranLs
	 * @return
	 */
	@Override
	public Message doOrderClose(PayTranLs payTranLs) {
		Message payMsg = null;
		//子商户配置
		WechatConfigKey wechatConfigSub = wechatConfigDao.findConfigByMerNo(payTranLs.getMerchantNo());
		if (wechatConfigSub == null) {
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		//主商户配置
		if(StringUtils.isEmpty(wechatConfigSub.getParentMchNo())){
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes()); 
		}
		WechatConfigKey wechatConfigPar =wechatConfigDao.findConfigByMerNo(wechatConfigSub.getParentMchNo());
		//构造订单查询请求参数
		WechatCloseReq wechatCloseReq = new WechatCloseReq(wechatConfigPar.getAppId(),wechatConfigPar.getMchId(),
				wechatConfigSub.getMchId(),payTranLs.getTransNum());
		//签名
		String sign = CommonUtil.getSign(CommonUtil.toMap(wechatCloseReq),wechatConfigPar.getApiSecret());
		wechatCloseReq.setSign(sign);
		//发起订单查询
		WechatCloseRep wechatCloseRep = wechatQrPayService.doWechatClose(wechatCloseReq);
		if(wechatCloseRep!=null){
			if(ResultCode.FAIL.getCode().equals(wechatCloseRep.getReturn_code())){
				//微信return_code为Fail
				payMsg = new Message(ResultCode.FAIL.getCode(),wechatCloseRep.getReturn_msg());
			}else{
				//微信return_code和result_code同时为SUCCESS
				if(ResultCode.SUCCESS.getCode().equals(wechatCloseRep.getResult_code())){
					Log.debug("订单关闭成功！");
					//微信返回订单状态
					payTranLs.setStatus(PayStatus.CLOSED.getValue());
					//修改订单状态
					payTranLsService.updTranStatus(payTranLs.getId(), PayStatus.CLOSED.getValue());
					//封装平台返回参数
					BarPayRepDto queryResData = new BarPayRepDto(payTranLs);
					payMsg = new Message(ResultCode.SUCCESS.name(), "订单关闭成功", queryResData); 
				}else{
					//将微信返回的错误信息封装到结果包中
					payMsg = new Message(wechatCloseRep.getErr_code(),wechatCloseRep.getErr_code_des());
				}
			}
		}else{
			//返回结果为空
			payMsg = new Message(ErrorCode.TRADE_FAIL.getCode(),ErrorCode.TRADE_FAIL.getDes());
		}
		return payMsg;
	}
	 

}
