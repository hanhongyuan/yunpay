package com.yunpay.ali.req;

/**
 * 支付宝退款请求参数类
 * 文件名称:     AliRefundReq.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月11日下午4:00:37 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月11日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class AliRefundReq extends AliQrReq{
	//原支付宝交易号
	private String trade_no;
	//退款金额
	private String refund_amount;
	//退款原因
	private String refund_reason;
	//退款流水号
	private String out_request_no;
	
	public AliRefundReq(){
		
	}
	
	/**
	 * 封装请求参数
	 * @param appId
	 * @param privateKey
	 * @param alipayPublicKey
	 * @param out_trade_no
	 * @param trade_no
	 * @param refund_amount
	 * @param refund_reason
	 * @param out_request_no
	 */
	public AliRefundReq(String appId,String privateKey,String alipayPublicKey,
			String out_trade_no,String trade_no,String out_request_no,
			String refund_amount,String refund_reason){
		setAppId(appId);
		setPrivateKey(privateKey);
		setAlipayPublicKey(alipayPublicKey);
		setOut_trade_no(out_trade_no);
		setTrade_no(trade_no);
		setOut_request_no(out_request_no);
		setRefund_amount(refund_amount);
		setRefund_reason(refund_reason);
		
	}
	
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getRefund_amount() {
		return refund_amount;
	}
	public void setRefund_amount(String refund_amount) {
		this.refund_amount = refund_amount;
	}
	public String getRefund_reason() {
		return refund_reason;
	}
	public void setRefund_reason(String refund_reason) {
		this.refund_reason = refund_reason;
	}
	public String getOut_request_no() {
		return out_request_no;
	}
	public void setOut_request_no(String out_request_no) {
		this.out_request_no = out_request_no;
	}
	
	
}
