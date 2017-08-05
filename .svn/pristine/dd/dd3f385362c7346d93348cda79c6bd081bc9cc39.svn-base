package com.yunpay.wx.req.pay;

import com.yunpay.common.utils.CommonUtil;

/**
 * 微信退款查询请求参数类
 * 文件名称:     WechatRefundQueryReq.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月7日下午2:24:51 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月7日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class WechatRefundQueryReq extends WechatQrReq{
	//微信订单号 查询的优先级是： refund_id > out_refund_no > transaction_id > out_trade_no
	//微信的订单号
	private String transaction_id;
	//平台提交的退款单号
	private String out_refund_no;
	//微信返回的退款单号
	private String refund_id ;
	
	public WechatRefundQueryReq(){
		
	}
	
	/**
	 * 构造退款查询请求参数
	 * 根据退款单号查询，建议优先采用退款单号进行查询
	 * @param appId
	 * @param merchId
	 * @param subMerchId
	 * @param transactionId
	 * @param outTradeNo
	 * @param nonceStr
	 */
	public WechatRefundQueryReq(String appId,String merchId,String subMerchId,String refundId,
		String outRefundNo){
		setAppid(appId);
		setMch_id(merchId);
		setSub_mch_id(subMerchId);
		setRefund_id(refundId);
		setOut_refund_no(outRefundNo);
		setNonce_str(CommonUtil.getRandomStringByLength(32));
	}
	
	/**
	 * 构造退款查询请求参数
	 * 根据原始单号或退款单号查询
	 * @param appId
	 * @param merchId
	 * @param subMerchId
	 * @param outTradeNo
	 * @param refund_id
	 * @param transactionId
	 * @param out_refund_no
	 * @param nonceStr
	 */
	public WechatRefundQueryReq(String appId,String merchId,String subMerchId,
			String transactionId,String outTradeNo,String refundId,
			String outRefundNo,String nonceStr){
		setAppid(appId);
		setMch_id(merchId);
		setSub_mch_id(subMerchId);
		setTransaction_id(transactionId);
		setOut_trade_no(outTradeNo);
		setRefund_id(refundId);
		setOut_refund_no(outRefundNo);
		setNonce_str(nonceStr);
	}
	
	
	
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getOut_refund_no() {
		return out_refund_no;
	}
	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}
	public String getRefund_id() {
		return refund_id;
	}
	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}
	
	
}
