package com.yunpay.ali.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCancelRequest;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeCancelResponse;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunpay.ali.config.AliPayConfig;
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
import com.yunpay.common.utils.Log;
import com.yunpay.common.utils.EnumUtil.ErrorCode;
import com.yunpay.common.utils.EnumUtil.ResultCode;


/**
 * 支付宝二维码支付核心类
 * 文件名称:     AliQrPayServiceImpl.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月21日上午9:25:46 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月21日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Service("aliQrPayService")
public class AliQrPayServiceImpl implements AliQrPayService{

	/**
	 * @Description:条码支付
	 * @author:     Zeng Dongcheng
	 * @Date:       2017年6月21日上午9:26:18 
	 * @param 		aliBarReq 条码支付请求参数
	 * @return      条码支付返回结果
	 */
	@Override
	public AliBarRep doAliBarPay(AliBarReq aliBarReq) {
		// TODO Auto-generated method stub
		AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.BAR_PAY_API, aliBarReq.getAppId(), 
				aliBarReq.getPrivateKey(), aliBarReq.getFormat(), aliBarReq.getCharset(), aliBarReq.getAlipayPublicKey());
		//请求参数
		AlipayTradePayRequest request = new AlipayTradePayRequest();
		Map<String,Object> biz = new HashMap<String,Object>();
		//商户订单号
		biz.put("out_trade_no", aliBarReq.getOut_trade_no());		
		//支付场景
		biz.put("scene", aliBarReq.getScene());								
		//支付授权码
		biz.put("auth_code", aliBarReq.getAuth_code());					
		//订单总金额
		biz.put("total_amount", aliBarReq.getTotal_amount());				
		//订单标题
		biz.put("subject", aliBarReq.getSubject());	
		//订单描述
		if(StringUtils.isNotEmpty(aliBarReq.getBody())){
			biz.put("body", aliBarReq.getBody());
		}
		//支付超时时间 yyyy-MM-dd HH:mm:ss 建议30分钟
		biz.put("timeout_express", aliBarReq.getTimeout_express());	
		//终端ID
		if(StringUtils.isNotEmpty(aliBarReq.getTerminal_id())){
			biz.put("terminal_id", aliBarReq.getTerminal_id());
		}
		//分拥参数设置Pid
		Map<String,String> extendParams = new HashMap<String,String>();
		if(StringUtils.isNotEmpty(aliBarReq.getSys_service_provider_id())){
			extendParams.put("sys_service_provider_id", aliBarReq.getSys_service_provider_id());
			biz.put("extend_params", extendParams);
		}
		AliBarRep rep;
		ObjectMapper mapper = new ObjectMapper(); 
		try {
			request.setBizContent(mapper.writeValueAsString(biz));
			AlipayTradePayResponse response = alipayClient.execute(request);
			if(response!=null){
				if(response.isSuccess()){
					Log.debug("支付宝条码支付返回数据:"+response.getBody());
					rep = analysisAliBar(response);
				}else{
					rep = new AliBarRep(ResultCode.FAIL.getCode(),ResultCode.FAIL.getDes(),
							response.getSubCode(),response.getSubMsg());
				}
				return rep;
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rep = new AliBarRep(ResultCode.FAIL.getCode(),ResultCode.FAIL.getDes(),
				ErrorCode.SYSTEM_EXCEPTION.getCode(),ErrorCode.SYSTEM_EXCEPTION.getDes());
		return rep;
	}
	
	/**
	 * @Description: 	解析支付宝条码支付结果
	 * @author:   	 	Zeng Dongcheng
	 * @Date:     	 	2017年6月21日上午10:12:44 
	 * @param response  支付宝返回结果
	 * @return
	 */
	private AliBarRep analysisAliBar(AlipayTradePayResponse response){
		AliBarRep rep = new AliBarRep();
		rep.setCode(response.getCode());
		rep.setMsg(response.getMsg());
		rep.setSub_code(response.getSubCode());
		rep.setSub_msg(response.getSubMsg());
		rep.setTrade_no(response.getTradeNo());
		rep.setOut_trade_no(response.getOutTradeNo());
		rep.setBuyer_logon_id(response.getBuyerLogonId());
		rep.setTotal_amount(response.getTotalAmount());
		rep.setReceipt_amount(response.getReceiptAmount());
		rep.setBuyer_pay_amount(response.getBuyerPayAmount());
		rep.setGmt_payment(response.getGmtPayment());
		if(response.getFundBillList()!=null && response.getFundBillList().size()>0){
			rep.setFund_channel(response.getFundBillList().get(0).getFundChannel());
			rep.setAmount(response.getFundBillList().get(0).getAmount());
			rep.setReal_amount(response.getFundBillList().get(0).getRealAmount());
		}
		rep.setBuyer_user_id(response.getBuyerUserId());
		return rep;
	}
	
	
	
	/**
	 * @Description:	   支付宝扫码支付
	 * @author:   		 Zeng Dongcheng
	 * @Date:     		 2017年6月21日上午11:05:05 
	 * @param aliScanReq 请求参数
	 * @return
	 */
	@Override
	public AliScanRep doAliScanPay(AliScanReq aliScanReq) {
		// TODO Auto-generated method stub
		AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.BAR_PAY_API, aliScanReq.getAppId(), 
				aliScanReq.getPrivateKey(), aliScanReq.getFormat(), aliScanReq.getCharset(), aliScanReq.getAlipayPublicKey());
		//请求参数
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
		Map<String,Object> biz = new HashMap<String,Object>();
		//商户订单号
		biz.put("out_trade_no", aliScanReq.getOut_trade_no());	
		//订单总金额
		biz.put("total_amount", aliScanReq.getTotal_amount());				
		//订单标题
		biz.put("subject", aliScanReq.getSubject());	
		//订单描述
		if(StringUtils.isNotEmpty(aliScanReq.getBody())){
			biz.put("body", aliScanReq.getBody());
		}
		//支付超时时间 yyyy-MM-dd HH:mm:ss 建议30分钟
		biz.put("timeout_express", aliScanReq.getTimeout_express());	//支付超时时间 yyyy-MM-dd HH:mm:ss 建议30分钟
		//终端ID
		if(StringUtils.isNotEmpty(aliScanReq.getTerminal_id())){
			biz.put("terminal_id", aliScanReq.getTerminal_id());
		}
		//分拥参数设置Pid
		Map<String,String> extendParams = new HashMap<String,String>();
		if(StringUtils.isNotEmpty(aliScanReq.getSys_service_provider_id())){
			extendParams.put("sys_service_provider_id", aliScanReq.getSys_service_provider_id());
			biz.put("extend_params", extendParams);
		}
		request.setNotifyUrl(aliScanReq.getNotify_url());
		ObjectMapper mapper = new ObjectMapper();
		AliScanRep rep;
		try {
			request.setBizContent(mapper.writeValueAsString(biz));
			AlipayTradePrecreateResponse response = alipayClient.execute(request);
			if(response!=null){
				if(response.isSuccess()){
					Log.debug("支付宝扫码支付返回数据:"+response.getBody());
					rep = analysisAliScan(response);
				}else{
					rep = new AliScanRep(ResultCode.FAIL.getCode(),ResultCode.FAIL.getDes(),
							response.getSubCode(),response.getSubMsg());
				}
				return rep;
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rep = new AliScanRep(ResultCode.FAIL.getCode(),ResultCode.FAIL.getDes(),
				ErrorCode.SYSTEM_EXCEPTION.getCode(),ErrorCode.SYSTEM_EXCEPTION.getDes());
		return rep;
	}
	
	
	/**
	 * @Description: 	解析支付宝扫码支付结果
	 * @author:   	 	Zeng Dongcheng
	 * @Date:     	    2017年6月21日上午11:02:45 
	 * @param response  支付宝返回结果
	 * @return
	 */
	private AliScanRep analysisAliScan(AlipayTradePrecreateResponse response){
		AliScanRep rep = new AliScanRep();
		rep.setCode(response.getCode());
		rep.setMsg(response.getMsg());
		rep.setSub_code(response.getSubCode());
		rep.setSub_msg(response.getSubMsg());
		rep.setOut_trade_no(response.getOutTradeNo());
		rep.setQr_code(response.getQrCode());
		return rep;
	}
	
	/**
	 * 订单查询
	 * @Description:
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月26日上午10:55:24 
	 * @param aliQueryReq
	 * @return
	 */
	@Override
	public AliQueryRep doAliQuery(AliQueryReq aliQueryReq) {
		// TODO Auto-generated method stub
		AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.BAR_PAY_API, aliQueryReq.getAppId(), 
				aliQueryReq.getPrivateKey(), aliQueryReq.getFormat(), aliQueryReq.getCharset(), aliQueryReq.getAlipayPublicKey());
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
		Map<String,String> biz = new HashMap<>();
		if(StringUtils.isNotEmpty(aliQueryReq.getTrade_no())){
			biz.put("trade_no", aliQueryReq.getTrade_no());
		}
		biz.put("out_trade_no", aliQueryReq.getOut_trade_no());
		ObjectMapper mapper = new ObjectMapper();
		AliQueryRep rep;
		try {
			request.setBizContent(mapper.writeValueAsString(biz));
			AlipayTradeQueryResponse response = alipayClient.execute(request);
			if(response!=null){
				if(response.isSuccess()){
					Log.debug("支付宝订单查询返回数据:"+response.getBody());
					rep = analysisAliQuery(response);
				}else{
					rep = new AliQueryRep(ResultCode.FAIL.getCode(),ResultCode.FAIL.getDes(),
							response.getSubCode(),response.getSubMsg());
				}
				return rep;
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rep = new AliQueryRep(ResultCode.FAIL.getCode(),ResultCode.FAIL.getDes(),
				ErrorCode.SYSTEM_EXCEPTION.getCode(),ErrorCode.SYSTEM_EXCEPTION.getDes());
		return rep;
	}
	
	/**
	 * @Description: 解析订单查询结果
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月26日上午10:38:19 
	 * @param response
	 * @return
	 */
	private AliQueryRep analysisAliQuery(AlipayTradeQueryResponse response){
		AliQueryRep rep = new AliQueryRep();
		rep.setCode(response.getCode());
		rep.setMsg(response.getMsg());
		rep.setSub_code(response.getSubCode());
		rep.setSub_msg(response.getSubMsg());
		rep.setTrade_no(response.getTradeNo());
		rep.setOut_trade_no(response.getOutTradeNo());
		rep.setBuyer_logon_id(response.getBuyerLogonId());
		rep.setTrade_status(response.getTradeStatus());
		rep.setTotal_amount(response.getTotalAmount());
		rep.setReceipt_amount(response.getReceiptAmount());
		rep.setBuyer_pay_amount(response.getBuyerPayAmount());
		rep.setSend_pay_date(response.getSendPayDate());
		if(response.getFundBillList()!=null && response.getFundBillList().size()>0){
			rep.setFund_channel(response.getFundBillList().get(0).getFundChannel());
			rep.setAmount(response.getFundBillList().get(0).getAmount());
			rep.setReal_amount(response.getFundBillList().get(0).getRealAmount());
		}
		rep.setBuyer_user_id(response.getBuyerUserId());
		return rep;
	}
	

	/**
	 * @Description:订单撤销
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月26日上午10:54:45 
	 * @param aliCancelReq
	 * @return
	 */
	@Override
	public AliCancelRep doAliCancel(AliCancelReq aliCancelReq) {
		// TODO Auto-generated method stub
		AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.BAR_PAY_API, aliCancelReq.getAppId(), 
				aliCancelReq.getPrivateKey(), aliCancelReq.getFormat(), aliCancelReq.getCharset(), aliCancelReq.getAlipayPublicKey());
		AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
		Map<String,String> biz = new HashMap<>();
		if(StringUtils.isNotEmpty(aliCancelReq.getTrade_no())){
			biz.put("trade_no", aliCancelReq.getTrade_no());
		}
		biz.put("out_trade_no", aliCancelReq.getOut_trade_no());
		ObjectMapper mapper = new ObjectMapper();
		AliCancelRep rep;
		try {
			request.setBizContent(mapper.writeValueAsString(biz));
			AlipayTradeCancelResponse response = alipayClient.execute(request);
			if(response!=null){
				if(response.isSuccess()){
					Log.debug("支付宝订单撤销返回数据:"+response.getBody());
					rep = analysisAliCancel(response);
				}else{
					rep = new AliCancelRep(ResultCode.FAIL.getCode(),ResultCode.FAIL.getDes(),
							response.getSubCode(),response.getSubMsg());
				}
				return rep;
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rep = new AliCancelRep(ResultCode.FAIL.getCode(),ResultCode.FAIL.getDes(),
				ErrorCode.SYSTEM_EXCEPTION.getCode(),ErrorCode.SYSTEM_EXCEPTION.getDes());
		return rep;
	}
	
	/**
	 * @Description: 解析订单撤销返回结果
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月26日上午10:55:34 
	 * @param response
	 * @return
	 */
	private AliCancelRep analysisAliCancel(AlipayTradeCancelResponse response){
		AliCancelRep rep = new AliCancelRep();
		rep.setCode(response.getCode());
		rep.setMsg(response.getMsg());
		rep.setSub_code(response.getSubCode());
		rep.setSub_msg(response.getSubMsg());
		rep.setTrade_no(response.getTradeNo());
		rep.setOut_trade_no(response.getOutTradeNo());
		rep.setRetry_flag(response.getRetryFlag());
		rep.setAction(response.getAction());
		return rep;
	}

	public static void main(String args[]){
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", "2017040506557166", 
				"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALJR8t0SjDQepj0TzQf+D72lEtuzMW+zBoFzWv8XrOWimFvopcBpoJZO6QKXzOeJ3dbUkh4FE28ymOcR8QkFCRkiuGIiPbxUccFX8v1Del4KCatdMv7JqSTYIZNg8f9zd5SXgWqVQRhejMZ6YCC0Dc3+OXx6ql0kM9O4Vn3FAhZfAgMBAAECgYAETfIc4Au+XlcI9mdmn/1lSIzR/NtepOWtTkmOCtZDnM8suMr3gBU+S51YUK3DkRJn0y3Lx7eWYZRLT6WP4C0+Ab0f4D9t5fdy7kpuk+tdxHC/WPn/DZhAAbejrRMw6r16cBmDsgcC6ewfrOvB723+Bb0XAKeYhhoZBOUeZKFmQQJBAOfEaVnjzUKPGgLAk/gPslaD5UAcJQMas+5GZimXAWI/bQAwl/CeVoMfjSR8l7sPbClIl0s7SrcocFS9rybeDpECQQDE9vJpUDN0s5SajyfcvZLP625zm4nnCISpL2vjEYb6gCLOBMzkR1aUtH10Zx5NeccsypXvQZJQI820zvhocy3vAkEA0+VhJIv/iBDpiQakwjEnra2dFYYl2La7NugqU2/6FedDMt86qwU4t11LX8aBusaY7w2tNV0aLGbOfMuHrZNr4QJBAI2vtyHa96jzpeqpIFvCY2H+Ui4HrWPs1MF/w3RMn3SDyIW7Hkj4qGfAjp61ry68c3LdKI479SyBFPEEEd3RPTECQHoZIQhrtZ2ZREJQu8RdExf2+JYxiwsMKNyhEVrVFNzC43Pc65RceavmGfFmMSVBNw8qa2UfN5VHpcdkv1ggw48=", 
				"JSON","UTF-8", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB");
	    AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
	    alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
	    alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");//在公共参数中设置回跳和通知地址
	    alipayRequest.setBizContent("{" +
	        "    \"out_trade_no\":\"20150320010101002\"," +
	        "    \"total_amount\":0.01," +
	        "    \"subject\":\"测试\"," +
	        "    \"product_code\":\"QUICK_WAP_WAY\"" +
	        "  }");//填充业务参数
	    String form="";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody();
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //调用SDK生成表单
	    System.out.println(form);
	}

	/**
	 * @Description:wap支付
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月27日上午10:40:32 
	 * @param aliWapReq
	 * @return 支付宝封装的form格式的字符串
	 */
	@Override
	public String doAliWapPay(AliWapReq aliWapReq) {
		// TODO Auto-generated method stub
		AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.BAR_PAY_API, aliWapReq.getAppId(), 
				aliWapReq.getPrivateKey(), aliWapReq.getFormat(), aliWapReq.getCharset(), aliWapReq.getAlipayPublicKey());
		//请求参数
		AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
		Map<String,Object> biz = new HashMap<String,Object>();
		//商户订单号
		biz.put("out_trade_no", aliWapReq.getOut_trade_no());	
		//订单总金额
		biz.put("total_amount", aliWapReq.getTotal_amount());				
		//订单标题
		biz.put("subject", aliWapReq.getSubject());	
		//订单描述
		if(StringUtils.isNotEmpty(aliWapReq.getBody())){
			biz.put("body", aliWapReq.getBody());
		}
		//分拥参数设置Pid
		Map<String,String> extendParams = new HashMap<String,String>();
		if(StringUtils.isNotEmpty(aliWapReq.getSys_service_provider_id())){
			extendParams.put("sys_service_provider_id", aliWapReq.getSys_service_provider_id());
			biz.put("extend_params", extendParams);
		}
		request.setNotifyUrl(aliWapReq.getNotify_url());
		request.setReturnUrl(aliWapReq.getReturn_url());
		ObjectMapper mapper = new ObjectMapper();
		try {
			request.setBizContent(mapper.writeValueAsString(biz));
			String form = alipayClient.pageExecute(request).getBody();
			return form;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;	
	}

	/**
	 * @Description:支付宝退款申请
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月11日下午4:53:42 
	 * @param aliRefundReq
	 * @return
	 */
	@Override
	public AliRefundRep doAliRefund(AliRefundReq aliRefundReq) {
		// TODO Auto-generated method stub
		AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.BAR_PAY_API, aliRefundReq.getAppId(), 
				aliRefundReq.getPrivateKey(), aliRefundReq.getFormat(), aliRefundReq.getCharset(), aliRefundReq.getAlipayPublicKey());
		//AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
		Map<String,String> biz = new HashMap<>();
		if(StringUtils.isNotEmpty(aliRefundReq.getTrade_no())){
			biz.put("trade_no", aliRefundReq.getTrade_no());
		}
		biz.put("out_trade_no", aliRefundReq.getOut_trade_no());
		biz.put("refund_amount", aliRefundReq.getRefund_amount());
		biz.put("refund_reason", aliRefundReq.getRefund_reason());
		biz.put("out_request_no", aliRefundReq.getOut_request_no());
		
		ObjectMapper mapper = new ObjectMapper();
		AliRefundRep rep;
		try {
			request.setBizContent(mapper.writeValueAsString(biz));
			AlipayTradeRefundResponse response = alipayClient.execute(request);
			if(response!=null){
				if(response.isSuccess()){
					Log.debug("支付宝退款申请返回数据:"+response.getBody());
					rep = analysisAliRefund(response);
				}else{
					rep = new AliRefundRep(ResultCode.FAIL.getCode(),ResultCode.FAIL.getDes(),
							response.getSubCode(),response.getSubMsg());
				}
				return rep;
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rep = new AliRefundRep(ResultCode.FAIL.getCode(),ResultCode.FAIL.getDes(),
				ErrorCode.SYSTEM_EXCEPTION.getCode(),ErrorCode.SYSTEM_EXCEPTION.getDes());
		return rep;
	}
	
	/**
	 * @Description: 解析退款申请返回结果
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月26日上午10:55:34 
	 * @param response
	 * @return
	 */
	private AliRefundRep analysisAliRefund(AlipayTradeRefundResponse response){
		AliRefundRep rep = new AliRefundRep();
		rep.setCode(response.getCode());
		rep.setMsg(response.getMsg());
		rep.setSub_code(response.getSubCode());
		rep.setSub_msg(response.getSubMsg());
		rep.setTrade_no(response.getTradeNo());
		rep.setOut_trade_no(response.getOutTradeNo());
		rep.setGmt_refund_pay(response.getGmtRefundPay());
		if(response.getRefundDetailItemList()!=null && response.getRefundDetailItemList().size()>0){
			rep.setFund_channel(response.getRefundDetailItemList().get(0).getFundChannel());
			rep.setAmount(response.getRefundDetailItemList().get(0).getAmount());
			rep.setReal_amount(response.getRefundDetailItemList().get(0).getRealAmount());
		}
		rep.setBuyer_user_id(response.getBuyerUserId());
		return rep;
	}

	/**
	 * @Description:支付宝退款查询
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月11日下午4:54:04 
	 * @param aliRefundQueryReq
	 * @return
	 */
	@Override
	public AliRefundQueryRep doAliRefundQuery(
			AliRefundQueryReq aliRefundQueryReq) {
		// TODO Auto-generated method stub
		AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.BAR_PAY_API, aliRefundQueryReq.getAppId(), 
				aliRefundQueryReq.getPrivateKey(), aliRefundQueryReq.getFormat(), aliRefundQueryReq.getCharset(), aliRefundQueryReq.getAlipayPublicKey());
		//AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
		AlipayTradeFastpayRefundQueryRequest  request = new AlipayTradeFastpayRefundQueryRequest ();
		Map<String,String> biz = new HashMap<>();
		if(StringUtils.isNotEmpty(aliRefundQueryReq.getTrade_no())){
			biz.put("trade_no", aliRefundQueryReq.getTrade_no());
		}
		biz.put("out_trade_no", aliRefundQueryReq.getOut_trade_no());
		biz.put("out_request_no", aliRefundQueryReq.getOut_request_no());
		ObjectMapper mapper = new ObjectMapper();
		AliRefundQueryRep rep;
		try {
			request.setBizContent(mapper.writeValueAsString(biz));
			AlipayTradeFastpayRefundQueryResponse response = alipayClient.execute(request);
			if(response!=null){
				if(response.isSuccess()){
					Log.debug("支付宝退款查询返回数据:"+response.getBody());
					rep = analysisAliRefundQuery(response);
				}else{
					rep = new AliRefundQueryRep(ResultCode.FAIL.getCode(),ResultCode.FAIL.getDes(),
							response.getSubCode(),response.getSubMsg());
				}
				return rep;
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rep = new AliRefundQueryRep(ResultCode.FAIL.getCode(),ResultCode.FAIL.getDes(),
				ErrorCode.SYSTEM_EXCEPTION.getCode(),ErrorCode.SYSTEM_EXCEPTION.getDes());
		return rep;
	}

	/**
	 * @Description: 解析退款查询返回结果
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月26日上午10:55:34 
	 * @param response
	 * @return
	 */
	private AliRefundQueryRep analysisAliRefundQuery(AlipayTradeFastpayRefundQueryResponse response){
		AliRefundQueryRep rep = new AliRefundQueryRep();
		rep.setCode(response.getCode());
		rep.setMsg(response.getMsg());
		rep.setSub_code(response.getSubCode());
		rep.setSub_msg(response.getSubMsg());
		rep.setTrade_no(response.getTradeNo());
		rep.setOut_trade_no(response.getOutTradeNo());
		rep.setOut_request_no(response.getOutRequestNo());
		rep.setRefund_reason(response.getRefundReason());
		rep.setTotal_amount(response.getTotalAmount());
		rep.setRefund_amount(response.getRefundAmount());
		return rep;
	}

	/**
	 * @Description:订单关闭
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月12日下午6:11:05 
	 * @param aliCloseReq
	 * @return
	 */
	@Override
	public AliCloseRep doAliClose(AliCloseReq aliCloseReq) {
		AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.BAR_PAY_API, aliCloseReq.getAppId(), 
				aliCloseReq.getPrivateKey(), aliCloseReq.getFormat(), aliCloseReq.getCharset(), aliCloseReq.getAlipayPublicKey());
		AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
		Map<String,String> biz = new HashMap<>();
		if(StringUtils.isNotEmpty(aliCloseReq.getTrade_no())){
			biz.put("trade_no", aliCloseReq.getTrade_no());
		}
		biz.put("out_trade_no", aliCloseReq.getOut_trade_no());
		ObjectMapper mapper = new ObjectMapper();
		AliCloseRep rep;
		try {
			request.setBizContent(mapper.writeValueAsString(biz));
			AlipayTradeCloseResponse response = alipayClient.execute(request);
			if(response!=null){
				if(response.isSuccess()){
					Log.debug("支付宝订单关闭返回数据:"+response.getBody());
					rep = analysisAliClose(response);
				}else{
					rep = new AliCloseRep(ResultCode.FAIL.getCode(),ResultCode.FAIL.getDes(),
							response.getSubCode(),response.getSubMsg());
				}
				return rep;
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rep = new AliCloseRep(ResultCode.FAIL.getCode(),ResultCode.FAIL.getDes(),
				ErrorCode.SYSTEM_EXCEPTION.getCode(),ErrorCode.SYSTEM_EXCEPTION.getDes());
		return rep;
	}
	
	/**
	 * @Description: 解析订单关闭返回结果
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月26日上午10:55:34 
	 * @param response
	 * @return
	 */
	private AliCloseRep analysisAliClose(AlipayTradeCloseResponse response){
		AliCloseRep rep = new AliCloseRep();
		rep.setCode(response.getCode());
		rep.setMsg(response.getMsg());
		rep.setSub_code(response.getSubCode());
		rep.setSub_msg(response.getSubMsg());
		rep.setTrade_no(response.getTradeNo());
		rep.setOut_trade_no(response.getOutTradeNo());
		return rep;
	}

}
