package com.yunpay.sdk.ctrl;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunpay.common.utils.CommonUtil;
import com.yunpay.common.utils.EnumUtil.ErrorCode;
import com.yunpay.common.utils.EnumUtil.PayStatus;
import com.yunpay.common.utils.EnumUtil.RefundStatus;
import com.yunpay.common.utils.Log;
import com.yunpay.serv.model.Merchant;
import com.yunpay.serv.model.PayTranLs;
import com.yunpay.serv.model.RefundTranLs;
import com.yunpay.serv.rep.BarPayRepDto;
import com.yunpay.serv.rep.Message;
import com.yunpay.serv.rep.RefundQueryRepDto;
import com.yunpay.serv.req.QrPayReqDto;
import com.yunpay.serv.req.QrRefundReqDto;
import com.yunpay.serv.route.PayFactory;
import com.yunpay.serv.service.busi.MerchantService;
import com.yunpay.serv.service.busi.PayTranLsService;
import com.yunpay.serv.service.busi.RefundTranLsService;
import com.yunpay.serv.service.pay.QrPayService;


/**
 * 
 * 文件名称:     QrPayCtrl.java
 * 内容摘要: 二维码支付对外接口发布类
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月22日下午1:56:37 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月22日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Controller
public class QrPayCtrl extends BaseCtrl{
	
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private PayTranLsService payTranLsService;
	@Autowired
	private RefundTranLsService refundTranLsService;
	@Autowired
	private PayFactory payFactory;
	
	/**
	 * @Description: 条码支付
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月23日上午10:38:09 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pay/micropay",method=RequestMethod.POST)
	@ResponseBody
	public Object doBarPay(HttpServletRequest request, HttpServletResponse response) {
		Map<String,String> reqParamMap = this.getRequestParams(request);
		Log.debug("条码支付入口,接收参数：" + reqParamMap);
		Message payMsg = null;
		try {
			//非空参数验证
			String[] barPara = {"sign","total_fee","dynamic_id","merchant_num","user_order_no"};
			String valiString = CommonUtil.paramValidate(reqParamMap,barPara);
			
			if(StringUtils.isNotEmpty(valiString)){
				return new Message(ErrorCode.PARAM_IS_NULL.getCode(),valiString+"参数为空");
			}
			//类型转换
			QrPayReqDto qrPayReq = (QrPayReqDto) CommonUtil.convertMap(QrPayReqDto.class, reqParamMap);
			//商品标题
			if(StringUtils.isEmpty(qrPayReq.getBody())){
				qrPayReq.setBody("barcode pay");
			}
			//获取商户信息
			Merchant merchant = merchantService.queryMerchInfo(qrPayReq.getMerchant_num());
			if (merchant == null) {
				return new Message(ErrorCode.ILLEGAL_MERCHANT_NUM.getCode(), ErrorCode.ILLEGAL_MERCHANT_NUM.getDes());			
			}
			//签名验证
//			if(!MD5.verify(reqParamMap, qrPayReq.getSign(), merchant.getMd5Key(), "utf-8")){
//				return new Message(ErrorCode.ILLEGAL_SIGN.getCode(),ErrorCode.ILLEGAL_SIGN.getDes());
//			}
			//支付流水是否存在验证
			PayTranLs payTranLs = payTranLsService.findTranLsByOrderNo(qrPayReq.getUser_order_no(), qrPayReq.getMerchant_num());
			if(payTranLs!=null){
				return new Message(ErrorCode.USER_ORDER_NO_EXIST.getCode(), ErrorCode.USER_ORDER_NO_EXIST.getDes());
			}
			String orderPrefix = qrPayReq.getDynamic_id().substring(0,2);
			//构造支付服务类
			QrPayService payService = payFactory.getServiceByOrderfix(orderPrefix);
			if(payService==null){
				return new Message(ErrorCode.PAY_CODE_ERROR.getCode(), ErrorCode.PAY_CODE_ERROR.getDes());
			}
			//调用条码支付服务
			payMsg = payService.doBarPay(qrPayReq, merchant);
		}catch (Exception e) {
			Log.error("支付出现异常："+e);
			return new Message(ErrorCode.SYSTEM_EXCEPTION.name(), ErrorCode.SYSTEM_EXCEPTION.getDes());
		}
		return payMsg;
	}
	
	
	/**
	 * @Description:扫码支付 
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月23日上午10:40:59 
	 * @return
	 */
	@RequestMapping(value = "/pay/unifiedorder",method=RequestMethod.POST)
	@ResponseBody
	public Object doScanPay(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> reqParamMap = this.getRequestParams(request);
		Log.debug("条码支付入口,接收参数：" + reqParamMap);
		Message payMsg = null;
		try {
			//非空参数验证
			String[] barPara = {"sign","total_fee","pay_channel","merchant_num","user_order_no"};
			String valiString = CommonUtil.paramValidate(reqParamMap,barPara);
			
			if(StringUtils.isNotEmpty(valiString)){
				return new Message(ErrorCode.PARAM_IS_NULL.getCode(),valiString+"参数为空");
			}
			//类型转换
			QrPayReqDto qrPayReq = (QrPayReqDto) CommonUtil.convertMap(QrPayReqDto.class, reqParamMap);
			//商品标题
			if(StringUtils.isEmpty(qrPayReq.getBody())){
				qrPayReq.setBody("scan pay");
			}
			//获取商户信息
			Merchant merchant = merchantService.queryMerchInfo(qrPayReq.getMerchant_num());
			if (merchant == null) {
				return new Message(ErrorCode.ILLEGAL_MERCHANT_NUM.getCode(), ErrorCode.ILLEGAL_MERCHANT_NUM.getDes());			
			}
			//签名验证
//			if(!MD5.verify(reqParamMap, qrPayReq.getSign(), merchant.getMd5Key(), "utf-8")){
//				return new Message(ErrorCode.ILLEGAL_SIGN.getCode(),ErrorCode.ILLEGAL_SIGN.getDes());
//			}
			//支付流水是否存在验证
			PayTranLs payTranLs = payTranLsService.findTranLsByOrderNo(qrPayReq.getUser_order_no(), qrPayReq.getMerchant_num());
			if(payTranLs!=null){
				return new Message(ErrorCode.USER_ORDER_NO_EXIST.getCode(), ErrorCode.USER_ORDER_NO_EXIST.getDes());
			}
			int payChannel = Integer.valueOf(qrPayReq.getPay_channel());
			//构造支付服务类
			QrPayService payService = payFactory.getServiceByChannel(payChannel);
			if(payService==null){
				return new Message(ErrorCode.PAY_CODE_ERROR.getCode(), ErrorCode.PAY_CODE_ERROR.getDes());
			}
			//调用条码支付服务
			payMsg = payService.doScanPay(qrPayReq, merchant);
		}catch (Exception e) {
			Log.debug("支付出现异常："+e);
			return new Message(ErrorCode.SYSTEM_EXCEPTION.name(), ErrorCode.SYSTEM_EXCEPTION.getDes());
		}
		return payMsg;
	}
	
	/**
	 * @Description: 订单查询
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月26日上午11:42:46 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pay/order/query",method=RequestMethod.POST)
	@ResponseBody
	public Object doOrderQuery(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> reqParamMap = this.getRequestParams(request);
		Log.info("订单查询入口,接收参数：" + reqParamMap);
		Message payMsg = null;
		try {
			//非空参数验证
			String[] queryPara = {"sign","merchant_num"};
			String valiString = CommonUtil.paramValidate(reqParamMap,queryPara);
			if(StringUtils.isNotEmpty(valiString)){
				return new Message(ErrorCode.PARAM_IS_NULL.getCode(),valiString+"参数为空");
			}
			PayTranLs payTranLs=null;
			if(StringUtils.isNotEmpty(reqParamMap.get("user_order_no"))){
				payTranLs = payTranLsService.findTranLsByOrderNo(
						reqParamMap.get("user_order_no"), reqParamMap.get("merchant_num"));
			}else if(StringUtils.isNotEmpty(reqParamMap.get("trace_num"))){
				payTranLs  = payTranLsService.findTranLsByTransNum(reqParamMap.get("trace_num"));
			}else{
				return new Message(ErrorCode.PARAM_IS_NULL.getCode(),"订单号不能为空");
			}
			//验证支付流水是否存在
			if(payTranLs==null){
				return new Message(ErrorCode.USER_ORDER_NO_NOT_EXIST.getCode(), ErrorCode.USER_ORDER_NO_NOT_EXIST.getDes());
			}
			//获取商户信息
			Merchant merchant = merchantService.queryMerchInfo(reqParamMap.get("merchant_num"));
			if (merchant == null) {
				return new Message(ErrorCode.ILLEGAL_MERCHANT_NUM.getCode(), ErrorCode.ILLEGAL_MERCHANT_NUM.getDes());			
			}
			//判断本地订单状态
			if(PayStatus.PAYING.getValue()==payTranLs.getStatus() || PayStatus.UNPAY.getValue()==payTranLs.getStatus()
					|| PayStatus.REFUNDING.getValue()==payTranLs.getStatus()){
				//如果订单状态为支付中或退款中，发起渠道订单查询
				//构造支付服务类
				QrPayService payService = payFactory.getServiceByChannel(payTranLs.getChannel());
				if(payService==null){
					return new Message(ErrorCode.PAY_CODE_ERROR.getCode(), ErrorCode.PAY_CODE_ERROR.getDes());
				}
				payMsg = payService.doOrderQuery(payTranLs);
			}else{
				//返回订单信息
				BarPayRepDto rep = new BarPayRepDto(payTranLs);
				payMsg = new Message(rep);
			}
		}catch (Exception e) {
			Log.debug("订单查询出现异常："+e);
			return new Message(ErrorCode.SYSTEM_EXCEPTION.name(), ErrorCode.SYSTEM_EXCEPTION.getDes());
		}
		return payMsg;
	}
	
	/**
	 * @Description: 订单关闭
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月26日上午11:46:07 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pay/order/close",method=RequestMethod.POST)
	@ResponseBody
	public Object doOrderClose(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> reqParamMap = this.getRequestParams(request);
		Log.info("订单关闭入口,接收参数：" + reqParamMap);
		Message payMsg = null;
		try {
			//非空参数验证
			String[] queryPara = {"sign","merchant_num"};
			String valiString = CommonUtil.paramValidate(reqParamMap,queryPara);
			if(StringUtils.isNotEmpty(valiString)){
				return new Message(ErrorCode.PARAM_IS_NULL.getCode(),valiString+"参数为空");
			}
			PayTranLs payTranLs=null;
			if(StringUtils.isNotEmpty(reqParamMap.get("user_order_no"))){
				payTranLs = payTranLsService.findTranLsByOrderNo(
						reqParamMap.get("user_order_no"), reqParamMap.get("merchant_num"));
			}else if(StringUtils.isNotEmpty(reqParamMap.get("trace_num"))){
				payTranLs  = payTranLsService.findTranLsByTransNum(reqParamMap.get("trace_num"));
			}else{
				return new Message(ErrorCode.PARAM_IS_NULL.getCode(),"订单号不能为空");
			}
			//验证支付流水是否存在
			if(payTranLs==null){
				return new Message(ErrorCode.USER_ORDER_NO_EXIST.getCode(), ErrorCode.USER_ORDER_NO_EXIST.getDes());
			}
			//获取商户信息
			Merchant merchant = merchantService.queryMerchInfo(reqParamMap.get("merchant_num"));
			if (merchant == null) {
				return new Message(ErrorCode.ILLEGAL_MERCHANT_NUM.getCode(), ErrorCode.ILLEGAL_MERCHANT_NUM.getDes());			
			}
			//判断本地订单状态
			if(PayStatus.CLOSED.getValue()==payTranLs.getStatus()){
				//状态为已关闭！
				payMsg = new Message(ErrorCode.ORDERCLOSED.getCode(), ErrorCode.ORDERCLOSED.getDes());
			}else if(PayStatus.PAYED.getValue()==payTranLs.getStatus()){
				//订单已支付，不能关闭
				payMsg = new Message(ErrorCode.ORDERPAIED.getCode(), ErrorCode.ORDERPAIED.getDes());
			}else{
				//构造支付服务类
				QrPayService payService = payFactory.getServiceByChannel(payTranLs.getChannel());
				if(payService==null){
					return new Message(ErrorCode.PAY_CODE_ERROR.getCode(), ErrorCode.PAY_CODE_ERROR.getDes());
				}
				payMsg = payService.doOrderClose(payTranLs);
			}
		}catch (Exception e) {
			Log.debug("订单关闭出现异常："+e);
			return new Message(ErrorCode.SYSTEM_EXCEPTION.name(), ErrorCode.SYSTEM_EXCEPTION.getDes());
		}
		return payMsg;
	}
	
	/**
	 * @Description: 订单撤销
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月26日上午11:46:07 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pay/order/reverse",method=RequestMethod.POST)
	@ResponseBody
	public Object doOrderReverse(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> reqParamMap = this.getRequestParams(request);
		Log.info("订单撤销入口,接收参数：" + reqParamMap);
		Message payMsg = null;
		try {
			//非空参数验证
			String[] queryPara = {"sign","merchant_num"};
			String valiString = CommonUtil.paramValidate(reqParamMap,queryPara);
			if(StringUtils.isNotEmpty(valiString)){
				return new Message(ErrorCode.PARAM_IS_NULL.getCode(),valiString+"参数为空");
			}
			PayTranLs payTranLs=null;
			if(StringUtils.isNotEmpty(reqParamMap.get("user_order_no"))){
				payTranLs = payTranLsService.findTranLsByOrderNo(
						reqParamMap.get("user_order_no"), reqParamMap.get("merchant_num"));
			}else if(StringUtils.isNotEmpty(reqParamMap.get("trace_num"))){
				payTranLs  = payTranLsService.findTranLsByTransNum(reqParamMap.get("trace_num"));
			}else{
				return new Message(ErrorCode.PARAM_IS_NULL.getCode(),"订单号不能为空");
			}
			//验证支付流水是否存在
			if(payTranLs==null){
				return new Message(ErrorCode.USER_ORDER_NO_EXIST.getCode(), ErrorCode.USER_ORDER_NO_EXIST.getDes());
			}
			//获取商户信息
			Merchant merchant = merchantService.queryMerchInfo(reqParamMap.get("merchant_num"));
			if (merchant == null) {
				return new Message(ErrorCode.ILLEGAL_MERCHANT_NUM.getCode(), ErrorCode.ILLEGAL_MERCHANT_NUM.getDes());			
			}
			//判断本地订单状态
			if(PayStatus.CANCEL.getValue()==payTranLs.getStatus()){
				//状态为已撤销
				return new Message(ErrorCode.REVERSED.getCode(), ErrorCode.REVERSED.getDes());
			}else{
				//如果订单状态为支付中或退款中，发起渠道订单查询
				//构造支付服务类
				QrPayService payService = payFactory.getServiceByChannel(payTranLs.getChannel());
				if(payService==null){
					return new Message(ErrorCode.PAY_CODE_ERROR.getCode(), ErrorCode.PAY_CODE_ERROR.getDes());
				}
				payMsg = payService.doOrderReverse(payTranLs);
			}
		}catch (Exception e) {
			Log.debug("订单撤销出现异常："+e);
			return new Message(ErrorCode.SYSTEM_EXCEPTION.name(), ErrorCode.SYSTEM_EXCEPTION.getDes());
		}
		return payMsg;
	}
	
	/**
	 * @Description: 退款申请
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月26日上午11:46:07 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pay/order/refund",method=RequestMethod.POST)
	@ResponseBody
	public Object doOrderRefund(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> reqParamMap = this.getRequestParams(request);
		Log.info("申请退款入口,接收参数：" + reqParamMap);
		Message payMsg = null;
		try {
			//非空参数验证
			String[] queryPara = {"sign","merchant_num","user_refund_no","refund_fee"};
			String valiString = CommonUtil.paramValidate(reqParamMap,queryPara);
			if(StringUtils.isNotEmpty(valiString)){
				return new Message(ErrorCode.PARAM_IS_NULL.getCode(),valiString+"参数为空");
			}
			QrRefundReqDto refundReq = (QrRefundReqDto) CommonUtil.convertMap(QrRefundReqDto.class, reqParamMap);
			PayTranLs payTranLs=null;
			if(StringUtils.isNotEmpty(reqParamMap.get("user_order_no"))){
				payTranLs = payTranLsService.findTranLsByOrderNo(
						reqParamMap.get("user_order_no"), reqParamMap.get("merchant_num"));
			}else if(StringUtils.isNotEmpty(reqParamMap.get("trace_num"))){
				payTranLs  = payTranLsService.findTranLsByTransNum(reqParamMap.get("trace_num"));
			}else{
				return new Message(ErrorCode.PARAM_IS_NULL.getCode(),"订单号不能为空");
			}
			//验证原支付流水是否存在
			if(payTranLs==null){
				return new Message(ErrorCode.USER_ORDER_NO_EXIST.getCode(), ErrorCode.USER_ORDER_NO_EXIST.getDes());
			}
			//获取商户信息
			Merchant merchant = merchantService.queryMerchInfo(reqParamMap.get("merchant_num"));
			if (merchant == null) {
				return new Message(ErrorCode.ILLEGAL_MERCHANT_NUM.getCode(), ErrorCode.ILLEGAL_MERCHANT_NUM.getDes());			
			}	
			//构造支付服务类
			QrPayService payService = payFactory.getServiceByChannel(payTranLs.getChannel());
			if(payService==null){
				return new Message(ErrorCode.PAY_CODE_ERROR.getCode(), ErrorCode.PAY_CODE_ERROR.getDes());
			}
			payMsg = payService.doOrderRefund(refundReq, payTranLs);
			
		}catch (Exception e) {
			Log.debug("退款申请出现异常："+e);
			return new Message(ErrorCode.SYSTEM_EXCEPTION.name(), ErrorCode.SYSTEM_EXCEPTION.getDes());
		}
		return payMsg;
	}
	
	/**
	 * @Description: 退款查询
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月11日下午2:22:24 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pay/refund/query",method=RequestMethod.POST)
	@ResponseBody
	public Object doRefundQuery(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> reqParamMap = this.getRequestParams(request);
		Log.info("退款查询入口,接收参数：" + reqParamMap);
		Message payMsg = null;
		try {
			//非空参数验证
			String[] queryPara = {"sign","merchant_num"};
			String valiString = CommonUtil.paramValidate(reqParamMap,queryPara);
			if(StringUtils.isNotEmpty(valiString)){
				return new Message(ErrorCode.PARAM_IS_NULL.getCode(),valiString+"参数为空");
			}
			RefundTranLs refundTranLs=null;
			if(StringUtils.isNotEmpty(reqParamMap.get("user_refund_no"))){
				refundTranLs = refundTranLsService.findRefundLsByOrderNo(
						reqParamMap.get("user_refund_no"), reqParamMap.get("merchant_num"));
			}else if(StringUtils.isNotEmpty(reqParamMap.get("trace_refund_num"))){
				refundTranLs  = refundTranLsService.findRefundLsByTransNum(reqParamMap.get("trace_refund_num"));
			}else{
				return new Message(ErrorCode.PARAM_IS_NULL.getCode(),"订单号不能为空");
			}
			//退款单号不存在
			if(refundTranLs==null){
				return new Message(ErrorCode.REFUND_ORDERNO_NOT_EXIST.getCode(), ErrorCode.REFUND_ORDERNO_NOT_EXIST.getDes());
			}
			//获取商户信息
			Merchant merchant = merchantService.queryMerchInfo(reqParamMap.get("merchant_num"));
			if (merchant == null) {
				return new Message(ErrorCode.ILLEGAL_MERCHANT_NUM.getCode(), ErrorCode.ILLEGAL_MERCHANT_NUM.getDes());			
			}	
			//判断本地订单状态
			if(RefundStatus.REFUNDING.getValue()==refundTranLs.getStatus() || 
					RefundStatus.UNREFUND.getValue()==refundTranLs.getStatus()){
				//如果订单状态为发起退款或退款中
				//构造支付服务类
				QrPayService payService = payFactory.getServiceByChannel(refundTranLs.getChannel());
				if(payService==null){
					return new Message(ErrorCode.PAY_CODE_ERROR.getCode(), ErrorCode.PAY_CODE_ERROR.getDes());
				}
				payMsg = payService.doRefundQuery(refundTranLs);
			}else{
				//返回订单信息
				RefundQueryRepDto rep = new RefundQueryRepDto(refundTranLs);
				payMsg = new Message(rep);
			}
			
		}catch (Exception e) {
			Log.debug("退款查询出现异常："+e);
			return new Message(ErrorCode.SYSTEM_EXCEPTION.name(), ErrorCode.SYSTEM_EXCEPTION.getDes());
		}
		return payMsg;
	}
	
	
	public static void main(String args[]){
		
		String filepath = "E:/usr/local/yunpos/cert/1297474301/apiclient_cert.p12";
		File file = new File(filepath);
		if(file.exists()){
			System.out.println("yes");
		}
	}
}
